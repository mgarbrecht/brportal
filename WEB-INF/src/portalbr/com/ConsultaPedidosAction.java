package portalbr.com;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/03/2006 15:03:23
 * Last Modify Date 17/10/2022 13:49:28
 */

public class ConsultaPedidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/03/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_consulta_pedidos,
    //                     redirecionando após a consulta para a tela de relatório:
    //                     /com/ConsultaPedidos_rForm.jsp
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
    session.removeAttribute("consulta_pedidos_situacao_filtro");
    session.removeAttribute("consulta_pedidos_status_filtro");
    session.removeAttribute("consulta_pedidos_ordenacao");
    session.removeAttribute("consulta_pedidos_nao_mostra_linhas");
    session.removeAttribute("consulta_pedidos_grupo_economico");
    session.removeAttribute("multiplos_pedidos");
    try {
      session.removeAttribute("consulta_pedidos_agrupa_cliente");
      util.consultas.Query qr = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      //--- Se for cliente ---
      String tipo = "";
      String cliente = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("CLIENTE MERCADO EXTERNO")) {
          cliente = ent.getChave() + "";
        }
        if (tipo.equals("CLIENTE MERCADO INTERNO")) {
          String grupocliente = qr.retorna("SELECT gre_grupo FROM grupo_economico WHERE cli_cdgo = " + ent.getChave());
          if (grupocliente.equals("")) {
            cliente = ent.getChave() + "";
          } else {
            cliente = "";
          }
        }
      }

      if (tipo.equals("AREAS") || u.isSuperUsuario() || tipo.equals("REGIONAL DE VENDA") || tipo.equals("REPRESENTANTE COMERCIAL")) {
        if ((f.getCli_cdgo() == "") && (f.getNo_cliente() == "") && (f.getEsc_cgc() == "") && (f.getRep_cdgo1() == "") && (f.getGrup_economico() == "")) {
          throw new Exception("Um dos parâmetros deve ser informado!");
        }
      } else {
        if ((f.getCli_cdgo() == "") && (f.getNo_cliente() == "") && (f.getEsc_cgc() == "") && (f.getGrup_economico() == "")) {
          throw new Exception("Um dos parâmetros deve ser informado!");
        }
      }

      select_action(j, mapping, form, request, response);

      //if(tipo.equals("AREAS") || u.isSuperUsuario()) {

      if (f.getCb_nao_imprimir_linhas() != null && f.getCb_nao_imprimir_linhas().equals("1")) {
        session.setAttribute("consulta_pedidos_nao_mostra_linhas", "s");
      }
      if (f.getCb_somente_indenizados() != null && f.getCb_somente_indenizados().equals("1")) {
        session.setAttribute("consulta_pedidos_somente_indenizados", "s");
      } else {
        session.setAttribute("consulta_pedidos_somente_indenizados", "n");
      }
      session.setAttribute("consulta_pedidos_ordenacao", f.getOrdenacao());

      if (f.getAgrupar_clientes().equalsIgnoreCase("N") && !f.getRep_cdgo1().equals("")) {
        if ((f.getDt_entrega().equals("") || f.getDt_entrega_fim1().equals("")) && (f.getDt_emissao_ini1().equals("") || f.getDt_emissao_fim1().equals("")) && (f.getDt_entrada_ini().equals("") || f.getDt_entrada_fim().equals("")) && (f.getDt_faturamento_ini().equals("") || f.getDt_faturamento_fim().equals(""))) {
          throw new Exception("Selecione agrupar clientes do representante ou informe algum período de datas!");
        }
        session.setAttribute("consulta_pedidos_agrupa_cliente", "n");
        actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&cod=" + f.getCli_cdgo() + "&dt_entrega=" + f.getDt_entrega() + "&codigo=" + f.getCodigo() + "&razao_social=" + f.getRazao_social() + "&cid_uf=" + f.getCid_uf() + "&marca=" + f.getCodigo_marca() + "&cliente=s" + (f.getSeq() != ""?"&seqn="+f.getSeq() : "") + "&tipo_pedido=" + f.getTipo_pedido(), true);
      } else {
        if (cliente != "") {
          actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&cod=" + cliente + "&dt_entrega=" + f.getDt_entrega() + "&codigo=" + f.getCodigo() + "&razao_social=" + f.getRazao_social() + "&cid_uf=" + f.getCid_uf() + "&marca=" + f.getCodigo_marca() + "&cliente=s" + "&tipo_pedido=" + f.getTipo_pedido(), true);
        } else {
          actionForward = new ActionForward("/com/ConsultaPedidos_rForm.do?&dt_entrega=" + f.getDt_entrega() + "&marca=" + f.getCodigo_marca() + "&tipo_pedido=" + f.getTipo_pedido(), true);
        }
        if (f.getGrup_economico() != "" && f.getGrup_economico() != null) {
          actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&cod=" + f.getGrup_economico() + "g&seqn=&dt_entrega=" + f.getDt_entrega() + "&codigo=" + f.getGrup_economico() + "&razao_social=" + qr.retorna("SELECT gre_descricao FROM grupo_economico where gre_grupo = " + f.getGrup_economico()) + "&cid_uf=&cliente=n&marca=" + f.getCodigo_marca() + "&tipo_pedido=" + f.getTipo_pedido(), true);
        }

      }

      if (f.getGrup_economico() != "" && f.getGrup_economico() != null) {
        session.setAttribute("consulta_pedidos_grupo_economico", f.getGrup_economico());
      }

      //--------------------------
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    return actionForward;
  }


  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    boolean somente_entrada = false;
    boolean usuarioConsultaGrupoEconomico = false;
    String grupoEconomicoLiberadoUsuario = null;
    String representante = "null";
    String rep = "null";
    String regional = "null";
    StringBuilder marca = new StringBuilder();
    StringBuilder grupo_eco = new StringBuilder();
    String cliente = "null";
    String seq = "null";
    String cgc = "null";
    StringBuilder situacao = new StringBuilder();
    StringBuilder situacao_ite = new StringBuilder();
    StringBuilder sbDataEntrega = new StringBuilder();
    StringBuilder sbDataEmissao = new StringBuilder();
    StringBuilder sbDataEntrada = new StringBuilder();
    StringBuilder sbDataFaturamento = new StringBuilder();
    StringBuilder nome = new StringBuilder();
    util.consultas.Query qr = new util.consultas.Query();
    ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;

    session.removeAttribute("consulta_pedidos_mix");
    session.removeAttribute("consulta_pedidos_filtro_clientes");
    session.removeAttribute("consulta_pedidos_tipo_produto");
    session.removeAttribute("consulta_pedidos_lin_cdgo");
    session.removeAttribute("consulta_pedidos_ref_cdgo");
    session.removeAttribute("consulta_pedidos_cab_cdgo");
    session.removeAttribute("consulta_pedidos_cor_cdgo");
    session.removeAttribute("consulta_pedidos_data_entrada");
    session.removeAttribute("consulta_pedidos_data_emissao");
    session.removeAttribute("consulta_pedidos_data_faturamento");
    session.removeAttribute("consulta_pedidos_somente_entrada");
    session.removeAttribute("consulta_pedidos_somente_entrada_periodo");
    session.removeAttribute("consulta_pedidos_invoice");
    session.removeAttribute("consulta_pedidos_condicao_pagamento");
    session.removeAttribute("consulta_pedidos_fora_normas");
    session.removeAttribute("consulta_pedidos_ordenacao");
    session.removeAttribute("consulta_pedidos_nao_mostra_linhas");
    session.setAttribute("consulta_pedidos_representante", "null");

    acesso.Sessao sessao = new acesso.Sessao(session);
    StringBuilder sbg = new StringBuilder();
    sbg.append(" SELECT /*+ all_rows */ substr(valor, instr(valor, '#')+1, length(valor)) ");
    sbg.append("   FROM wbrio.parametros ");
    sbg.append("  WHERE nome = 'usuario_consulta_grupo_economico' ");
    sbg.append("    AND substr(valor,0,instr(valor,'#')-1) = '" + sessao.getUsuario() + "' ");
    grupoEconomicoLiberadoUsuario = qr.retorna(j, sbg.toString());
    if (!grupoEconomicoLiberadoUsuario.equals("")) {
      usuarioConsultaGrupoEconomico = true;
    }

    if ((f.getCb_somente_entrada() + "").equalsIgnoreCase("1")) {
      somente_entrada = true;
      session.setAttribute("consulta_pedidos_somente_entrada", "S");
      if (f.getDt_entrada_ini().equals("") || f.getDt_entrada_fim().equals("")) {
        throw new Exception("A data de entrada deve ser informada!");
      }
      session.setAttribute("consulta_pedidos_somente_entrada_periodo", " AND (NVL(p.ped_especie_pedido, NULL) <> 'C' OR (NVL(TRUNC(pck_pedidos.get_data_ultimo_recolocado(p.ped_nmro)), TRUNC(p.ped_dadg)) >= to_date('" + f.getDt_entrada_ini() + "','dd/mm/yyyy') AND NVL(TRUNC(pck_pedidos.get_data_ultimo_recolocado(p.ped_nmro)), TRUNC(p.ped_dadg)) < (TO_DATE('" + f.getDt_entrada_fim() + "','dd/mm/yyyy')))) ");
    }

    if (f.getCb_fora_normas() != null && f.getCb_fora_normas().equals("1")) {
      session.setAttribute("consulta_pedidos_fora_normas", "s");
    }
    if (f.getCb_nao_imprimir_linhas() != null && f.getCb_nao_imprimir_linhas().equals("1")) {
      session.setAttribute("consulta_pedidos_nao_mostra_linhas", "s");
    }
    session.setAttribute("consulta_pedidos_ordenacao", f.getOrdenacao());
    session.setAttribute("consulta_pedidos_mix", f.getMix());
    if (f.getInvoice() != "") {
      session.setAttribute("consulta_pedidos_invoice", f.getInvoice());
    }
    if (f.getRep_cdgo1() != "" && f.getRep_cdgo1() != null) {
      session.setAttribute("consulta_pedidos_representante", "'" + f.getRep_cdgo1() + "'");
    }
    if (f.getLin_cdgo() != "") {
      session.setAttribute("consulta_pedidos_lin_cdgo", f.getLin_cdgo());
    }
    if (f.getTipo_produto() != "") {
      session.setAttribute("consulta_pedidos_tipo_produto", f.getTipo_produto());
    }
    if (f.getRef_cdgo() != "") {
      session.setAttribute("consulta_pedidos_ref_cdgo", f.getRef_cdgo());
    }
    if (f.getCab_cdgo() != "") {
      session.setAttribute("consulta_pedidos_cab_cdgo", f.getCab_cdgo());
    }
    if (f.getCor_cdgo() != "") {
      session.setAttribute("consulta_pedidos_cor_cdgo", f.getCor_cdgo());
    }
    if (f.getRepresentante() != "") {
      representante = f.getRepresentante();
    }
    if (f.getRegional() != "") {
      regional = f.getRegional();
    }
    if (f.getCodigo_marca() != "") {
      marca.append(" and i.codigo_marca = ").append(f.getCodigo_marca());
    }

    if ((f.getNo_cliente() + "").equals("null")) {
      f.setNo_cliente("");
    }
    if ((f.getEsc_cgc() + "").equals("null")) {
      f.setEsc_cgc("");
    }

    if (f.getGrup_economico() != "" && f.getGrup_economico() != null) {
      grupo_eco.append("  AND EXISTS (SELECT 1 FROM grupo_economico ge WHERE ge.cli_cdgo = c.cli_cdgo AND ge.status = 'A' AND ge.gre_grupo = " + f.getGrup_economico() + ") ");
    }

    if (f.getSeq() != "") {
      seq = f.getSeq();
    }
    if (f.getNo_cliente() != "") {
      nome.append(" and c.cli_rzao like upper('").append(f.getNo_cliente()).append("') ");
    }
    if (f.getEsc_cgc() != "") {
      cgc = f.getEsc_cgc();
    }


    if (session.getAttribute("consulta_pedidos_situacao_pedido") != null) {
      situacao_ite.append(" AND nvl(i.ite_situ,null) in (" + (String) session.getAttribute("consulta_pedidos_situacao_pedido") + ") ");
      session.setAttribute("consulta_pedidos_situacao_filtro", situacao_ite.toString());
    }


    if (session.getAttribute("consulta_pedidos_status_pedido") != null) {
      String situacaos = (String) session.getAttribute("consulta_pedidos_status_pedido");
      situacao.append(" and (p.ped_nmro <0 ");
      //     if(situacaos.indexOf("A")!=-1){
      //        situacao.append(" OR (p.ped_stat = 'A' or (p.ped_stat = 'L' and i.ite_situ = '5')) ");
      //     }
      if (situacaos.indexOf("A") != -1) {
        situacao.append(" OR (p.ped_stat in ('A')) ");
      }
      if (situacaos.indexOf("L") != -1) {
        situacao.append(" OR (p.ped_stat in ('L')) ");
      }
      if (situacaos.indexOf("F") != -1) {
        situacao.append(" OR (p.ped_stat in ('F')) ");
      }
      //     if(situacaos.indexOf("B")!=-1){
      //        situacao.append(" OR (p.ped_stat in ('P','B','T')) ");
      //     }
      if (situacaos.indexOf("B") != -1) {
        situacao.append(" OR (p.ped_stat in ('B')) ");
      }
      if (situacaos.indexOf("P") != -1) {
        situacao.append(" OR (p.ped_stat in ('P')) ");
      }
      if (situacaos.indexOf("T") != -1) {
        situacao.append(" OR (p.ped_stat in ('T')) ");
      }
      if (situacaos.indexOf("C") != -1) {
        situacao.append(" OR (p.ped_stat in ('C')) ");
      }
      situacao.append(" ) ");
      session.setAttribute("consulta_pedidos_status_filtro", situacao.toString());
    }

    if (f.getDt_entrega() != "") {
      sbDataEntrega.append(" and p.ped_det >= to_date('" + f.getDt_entrega() + "','dd/mm/yyyy')");
    }
    if (f.getDt_entrega_fim1() != "") {
      sbDataEntrega.append(" and p.ped_det <= to_date('" + f.getDt_entrega_fim1() + "','dd/mm/yyyy')");
    }
    if (f.getDt_emissao_ini1() != "") {
      sbDataEmissao.append(" and p.ped_daem >= to_date('" + f.getDt_emissao_ini1() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_emissao_fim1() != "") {
      sbDataEmissao.append(" and p.ped_daem <= to_date('" + f.getDt_emissao_fim1() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_entrada_ini() != "") {
      sbDataEntrada.append(" and p.ped_dadg >= to_date('" + f.getDt_entrada_ini() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_entrada_fim() != "") {
      sbDataEntrada.append(" and p.ped_dadg < to_date('" + f.getDt_entrada_fim() + "','dd/mm/yyyy')+1 ");
    }
    if (f.getDt_faturamento_ini() != "") {
      sbDataFaturamento.append(" and p.ped_emba >= to_date('" + f.getDt_faturamento_ini() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_faturamento_fim() != "") {
      sbDataFaturamento.append(" and p.ped_emba < to_date('" + f.getDt_faturamento_fim() + "','dd/mm/yyyy')+1 ");
    }

    // ---trata o cliente ---

    if (f.getCli_cdgo() != "") {
      cliente = f.getCli_cdgo();
    }

    String tipo = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("CLIENTE MERCADO EXTERNO")) {
        cliente = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO INTERNO")) {
        String grupocliente = "";
        String consultaSomenteCliente = qr.retorna("SELECT 'S' FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'usuario_desvincular_grupo_economico' and valor = " + ent.getChave());
        if (consultaSomenteCliente.equalsIgnoreCase("S")) {
          grupocliente = "";
        } else {
          grupocliente = qr.retorna("SELECT gre_grupo FROM grupo_economico WHERE cli_cdgo = " + ent.getChave() + " AND status='A'");
        }
        if (grupocliente.equals("")) {
          cliente = ent.getChave() + "";
        } else {
          grupo_eco.append(" AND EXISTS (SELECT 1 FROM grupo_economico ge WHERE ge.cli_cdgo = c.cli_cdgo AND status = 'A' AND ge.gre_grupo = " + grupocliente + ") ");
          cliente = "null";
        }
      }
    }

    //-------- MONTA PARAMETROS ------------

    StringBuilder parametros = new StringBuilder();
    StringBuilder parametros_ped = new StringBuilder();
    if ((!(cliente.equals("null")))) {
      parametros.append(" and c.cli_cdgo = ").append(cliente);
    }

    if ((!((seq + "").equals("null")))) {
      parametros.append(" AND s.esc_seqn = nvl(").append(seq).append(", s.esc_seqn) ");
    }

    if ((!(regional.equals("null")))) {
      if (usuarioConsultaGrupoEconomico) {
        StringBuilder sbge = new StringBuilder();
        sbge.append(" AND ((r.codigo_regional = NVL(").append(regional).append(", r.codigo_regional))  ");
        sbge.append("     or (EXISTS (SELECT 1 ");
        sbge.append("                   FROM grupo_economico ge ");
        sbge.append("                  WHERE ge.cli_cdgo = c.cli_cdgo ");
        sbge.append("                    AND nvl(ge.status,null) = 'A' ");
        sbge.append("                    AND ge.gre_grupo = ").append(grupoEconomicoLiberadoUsuario).append("))) ");
        parametros.append(sbge.toString());
      } else {
        parametros.append(" AND r.codigo_regional = nvl(").append(regional).append(", r.codigo_regional) ");
      }
    }

    if (session.getAttribute("consulta_pedidos_lin_cdgo") != null) {
      parametros_ped.append(" AND i.lin_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_lin_cdgo") + ",i.lin_cdgo) ");
    }
    if (session.getAttribute("consulta_pedidos_tipo_produto") != null) {
      parametros_ped.append(" AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) = ").append((String) session.getAttribute("consulta_pedidos_tipo_produto"));
    }
    if (session.getAttribute("consulta_pedidos_ref_cdgo") != null) {
      parametros_ped.append(" AND i.ref_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_ref_cdgo") + ",i.ref_cdgo)");
    }

    if (session.getAttribute("consulta_pedidos_cab_cdgo") != null) {
      parametros_ped.append(" AND i.cab_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_cab_cdgo") + ",i.cab_cdgo) ");
    }
    if (session.getAttribute("consulta_pedidos_cor_cdgo") != null) {
      parametros_ped.append(" AND i.cor_cdgo = nvl(" + (String) session.getAttribute("consulta_pedidos_cor_cdgo") + ",i.cor_cdgo)");
    }

    int contador = 0;

    if ((!(cgc.equals("null")))) {
      java.sql.PreparedStatement pstm = null;
      java.sql.ResultSet rset = null;
      try {
        pstm = j.getConn().prepareStatement(" select distinct cli_cdgo,esc_seqn from esc e where e.esc_cgc = " + cgc + " AND esc_situacao = 'A'");
        rset = pstm.executeQuery();
        while (rset.next()) {
          parametros.append(" and c.cli_cdgo = ").append(rset.getInt(1));
          parametros.append(" and s.esc_seqn = ").append(rset.getInt(2));
          contador++;
        }
        if (contador == 0) {
          parametros.append(" and c.cli_cdgo = -1");
        }
      }
      finally {
        if (rset != null) {
          rset.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      }
    }

    // ------------------------------------------------------------------
    portalbr.dbobj.view.Jw_consulta_pedidos table = new portalbr.dbobj.view.Jw_consulta_pedidos();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        c.cli_cdgo || '-' || s.esc_seqn codigo ");
    query.append("      , cli_rzao razao_social ");
    query.append("      , ecl_cdad || ' - ' || s.est_unifed cid_uf ");
    query.append("      , s.est_unifed eunifed ");
    query.append("      , ecl_cdad ecidad ");
    query.append("      , s.esc_seqn seqn ");
    query.append("      , s.cli_cdgo cod ");
    query.append("      , ca.cli_cdgo_sucessor codigo_sucessor ");
    query.append("      , ca.esc_seqn_sucessor sequencial_sucessor ");
    query.append("      , pck_cliente.get_nome(ca.cli_cdgo_sucessor) razao_social_sucessor ");
    query.append("      , (SELECT ec.ecl_cdad || ' - ' || ec.est_unifed FROM ecl ec WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor AND esc_seqn = ca.esc_seqn_sucessor and ec.ned_cdgo IN ('UNI', 'ENT') and rownum=1 ) cid_uf_sucessor ");
    query.append("   FROM cli                      c ");
    query.append("      , esc                      s ");
    query.append("      , ecl                      e ");
    query.append("      , regionais_vendas        rv ");
    query.append("      , cliente_representante   cr ");
    query.append("      , brio.cli_inf_adicionais ca ");
    query.append("      , rep                      r  ");
    query.append("  WHERE s.esc_seqn         = e.esc_seqn ");
    query.append("    AND c.cli_cdgo         = s.cli_cdgo ");
    query.append("    AND s.cli_cdgo         = e.cli_cdgo ");
    query.append("    AND c.cli_cdgo         = cr.codigo_cliente ");
    query.append("    AND ca.cli_cdgo    (+) = e.cli_cdgo ");
    query.append("    AND ca.esc_seqn    (+) = e.esc_seqn ");
    query.append("    AND s.esc_seqn         = cr.codigo_sequencial ");
    query.append("    AND r.rep_cdgo         = cr.codigo_representante ");
    query.append("    AND rv.codigo_regional = r.codigo_regional ");
    query.append("    AND (e.ned_cdgo        = 'UNI' or e.ned_cdgo = 'ENT') ");
    query.append("    AND r.rep_cdgo         = nvl(").append(representante).append(", r.rep_cdgo) ");
    query.append("    AND r.rep_cdgo         = nvl(" + (String) session.getAttribute("consulta_pedidos_representante") + ", r.rep_cdgo) ");
    query.append(parametros.toString());
    query.append(nome.toString());
    query.append(grupo_eco.toString());
    query.append("    AND EXISTS (SELECT 1  ");
    query.append("                  FROM ped p ");
    query.append("                     , rep rr ");
    query.append("                     , ite i ");
    if (f.getCb_fora_normas() != null && f.getCb_fora_normas().equals("1")) {
      query.append("                  , situacoes_pedidos sp ");
    }
    query.append("                 WHERE p.cli_cdgo = e.cli_cdgo ");
    if (!f.getMix().equalsIgnoreCase("T")) {
      query.append(" AND wbrio.fct_mix_produto_pedido(p.ped_nmro) = '"+f.getMix() + "' ");
    }
    if (somente_entrada) {
      query.append("                AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
      query.append("                AND (NVL(p.ped_especie_pedido, NULL) <> 'C' OR (NVL(TRUNC(pck_pedidos.get_data_ultimo_recolocado(p.ped_nmro)), TRUNC(p.ped_dadg)) >= to_date('" + f.getDt_entrada_ini() + "','dd/mm/yyyy') AND NVL(TRUNC(pck_pedidos.get_data_ultimo_recolocado(p.ped_nmro)), TRUNC(p.ped_dadg)) < (TO_DATE('" + f.getDt_entrada_fim() + "','dd/mm/yyyy')))) ");
    }
    if (f.getCb_fora_normas() != null && f.getCb_fora_normas().equals("1")) {
      query.append("                AND p.ped_nmro = sp.ped_nmro ");
      query.append("                AND NVL(sp.ts_codigo_situacao, NULL) = 36 ");
    }
    query.append("                   AND rr.rep_cdgo = p.rep_cdgo ");
    query.append("                   AND rr.rep_cdgo = r.rep_cdgo ");
    query.append("                   AND p.esc_seqn = e.esc_seqn ");
    if (f.getInvoice() != "") {
      query.append("                AND NVL(p.ped_invoice, NULL) = '" + f.getInvoice() + "' ");
    }
    query.append("                   AND p.ped_tipo = NVL(" + f.getTipo_pedido() + ", p.ped_tipo) ");
    query.append("                   AND p.ped_nmro = i.ped_nmro ");
    if (f.getCnd_cdgo() != "") {
      query.append("                AND nvl(p.cnd_cdgo,null) = " + f.getCnd_cdgo());
      session.setAttribute("consulta_pedidos_condicao_pagamento", (" AND nvl(p.cnd_cdgo,null) = " + f.getCnd_cdgo() + " "));
    }
    query.append(situacao_ite.toString());
    query.append(situacao.toString());
    query.append(marca.toString());
    query.append(sbDataEntrega.toString());
    query.append(sbDataEmissao.toString());
    query.append(sbDataEntrada.toString());
    query.append(sbDataFaturamento.toString());
    query.append(parametros_ped.toString());
    query.append("  AND ROWNUM = 1) ");
    query.append("  ORDER BY cod, seqn ");

    if (u.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_consulta_pedidos = j.select(table, query.toString(), null);

    if (sbDataEntrada.length() > 0) {
      session.setAttribute("consulta_pedidos_data_entrada", sbDataEntrada.toString());
    }
    if (sbDataEmissao.length() > 0) {
      session.setAttribute("consulta_pedidos_data_emissao", sbDataEmissao.toString());
    }
    if (sbDataFaturamento.length() > 0) {
      session.setAttribute("consulta_pedidos_data_faturamento", sbDataFaturamento.toString());
    }
    session.setAttribute("res_Jw_consulta_pedidos", res_Jw_consulta_pedidos);
    if (!(res_Jw_consulta_pedidos != null && res_Jw_consulta_pedidos.size() > 0)) {
      String texto = java.util.ResourceBundle.getBundle("ComercialResources").getString("ConsultaPedidos.erro.nenhum.registro");

      if (f.getCli_cdgo() != "") {
        java.sql.PreparedStatement pstm = null;
        java.sql.ResultSet rset = null;
        try {
          pstm = j.getConn().prepareStatement(new StringBuilder(" select * from cli where cli_cdgo = ").append(f.getCli_cdgo()).toString());
          rset = pstm.executeQuery();
          while (rset.next()) {
            texto = java.util.ResourceBundle.getBundle("ComercialResources").getString("ConsultaPedidos.erro.cliente.sem.pedidos");
          }
        }
        finally {
          if (rset != null) {
            rset.close();
          }
          if (pstm != null) {
            pstm.close();
          }
        }
      }
      throw new Exception(texto);
    }


    if (cliente != "") {
      portalbr.dbobj.view.Jw_consulta_pedidos t_jw_consulta_pedidos = new portalbr.dbobj.view.Jw_consulta_pedidos();
      t_jw_consulta_pedidos = (portalbr.dbobj.view.Jw_consulta_pedidos) res_Jw_consulta_pedidos.elementAt(0);
      String codigo = t_jw_consulta_pedidos.getCodigo() == null ? "" : t_jw_consulta_pedidos.getCodigo();
      String razao_social = t_jw_consulta_pedidos.getRazao_social() == null ? "" : t_jw_consulta_pedidos.getRazao_social();
      String cid_uf = t_jw_consulta_pedidos.getCid_uf() == null ? "" : t_jw_consulta_pedidos.getCid_uf();
      f.setCodigo(codigo);
      f.setRazao_social(razao_social);
      f.setCid_uf(cid_uf);
    }

    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      session.removeAttribute("res_Jw_consulta_pedidos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      session.removeAttribute("consulta_pedidos_tipo_produto");
      session.removeAttribute("consulta_pedidos_lin_cdgo");
      session.removeAttribute("consulta_pedidos_ref_cdgo");
      session.removeAttribute("consulta_pedidos_cab_cdgo");
      session.removeAttribute("consulta_pedidos_cor_cdgo");
      session.removeAttribute("consulta_pedidos_data_entrada");
      session.removeAttribute("consulta_pedidos_data_emissao");
      session.removeAttribute("consulta_pedidos_somente_entrada");
      session.removeAttribute("consulta_pedidos_somente_entrada_periodo");
      session.removeAttribute("consulta_pedidos_condicao_pagamento");
      session.removeAttribute("consulta_pedidos_invoice");
      session.removeAttribute("consulta_pedidos_situacao_pedido");
      session.removeAttribute("consulta_pedidos_status_pedido");
      session.removeAttribute("consulta_pedidos_fora_normas");
      session.removeAttribute("mostrar_imagem");
      session.removeAttribute("consulta_pedidos_nao_mostra_linhas");
      session.removeAttribute("consulta_pedidos_somente_indenizados");
      session.removeAttribute("consulta_pedidos_agrupa_cliente");
      session.removeAttribute("consulta_pedidos_grupo_economico");
      session.removeAttribute("consulta_pedidos_representante");
      session.removeAttribute("consulta_pedidos_ordenacao");
      session.removeAttribute("consulta_pedidos_mix");
      session.removeAttribute("consulta_pedidos_situacao_filtro");
      session.removeAttribute("consulta_pedidos_status_filtro");
      session.removeAttribute("consulta_pedidos_data_faturamento");
      session.removeAttribute("consulta_pedidos_filtro_clientes");
      session.removeAttribute("multiplos_pedidos");
      session.removeAttribute("res_status_pedido");
      session.removeAttribute("res_situacao_pedido");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_limpar_situacao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      session.removeAttribute("res_situacao_pedido");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_limpar_status_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      session.removeAttribute("res_status_pedido");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-----------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/03/2006
    // Objetivo          : Executa a consulta direta do pedido através do número do pedido ou do número
    //                     do pedido AFV informados, validando os mesmos e redirecionando para a consulta:
    //                     /com/ConsultaPedidos_iForm
    //-----------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    session.removeAttribute("consulta_pedidos_tipo_produto");
    session.removeAttribute("consulta_pedidos_lin_cdgo");
    session.removeAttribute("consulta_pedidos_ref_cdgo");
    session.removeAttribute("consulta_pedidos_cab_cdgo");
    session.removeAttribute("consulta_pedidos_cor_cdgo");
    session.removeAttribute("consulta_pedidos_data_entrada");
    session.removeAttribute("consulta_pedidos_data_emissao");
    session.removeAttribute("consulta_pedidos_somente_entrada");
    session.removeAttribute("consulta_pedidos_somente_entrada_periodo");
    session.removeAttribute("consulta_pedidos_invoice");
    session.removeAttribute("consulta_pedidos_condicao_pagamento");
    session.removeAttribute("consulta_pedidos_situacao_pedido");
    session.removeAttribute("consulta_pedidos_fora_normas");
    session.removeAttribute("consulta_pedidos_ordenacao");
    session.removeAttribute("consulta_pedidos_mix");
    session.removeAttribute("consulta_pedidos_nao_mostra_linhas");
    session.removeAttribute("consulta_pedidos_somente_indenizados");
    session.removeAttribute("consulta_pedidos_agrupa_cliente");
    session.removeAttribute("consulta_pedidos_grupo_economico");
    session.removeAttribute("consulta_pedidos_representante");
    session.removeAttribute("consulta_pedidos_mix");
    session.removeAttribute("consulta_pedidos_situacao_filtro");
    session.removeAttribute("consulta_pedidos_status_filtro");
    session.removeAttribute("consulta_pedidos_data_faturamento");
    session.removeAttribute("multiplos_pedidos");
    session.removeAttribute("consulta_pedidos_status_pedido");
    session.removeAttribute("consulta_pedidos_filtro_clientes");
    session.removeAttribute("res_status_pedido");
    session.removeAttribute("res_situacao_pedido");

    boolean usuarioConsultaGrupoEconomico = false;
    String grupoEconomicoLiberadoUsuario = null;
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil conn = null;
    String pedido = "";
    StringBuilder parametros = new StringBuilder();
    boolean consultaMultiplosPedidos = false;
    try {
      util.consultas.Query qry = new util.consultas.Query();
      session.removeAttribute("multiplos_pedidos");
      session.removeAttribute("consulta_pedidos_somente_entrada");
      //---------------------------------------
      String codigo_regional = "";
      String codigo_representante = "";
      String codigo_analista = "";
      String grupo_economico = "";
      String tipo = "";
      String parametro_dias_retroativos = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");

      //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
      String diasRetroativos = "";
      com.egen.util.jdbc.JdbcUtil connection = null;
      try {
        connection = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Acessos_documentos_interfaces table_acessos = new portalbr.dbobj.table.Acessos_documentos_interfaces();
        String[][] select = null;
        Object[][] where = { {"Acdi_doin_id","=","75"}, {"Acdi_usua_id","=",u.getId()}, {"Acdi_dias_consulta_retroativa",">",0} };
        Vector res_Acessos_documentos_interfaces = connection.select(table_acessos, select, where, null, null, null);
        if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
          portalbr.dbobj.table.Acessos_documentos_interfaces r = (portalbr.dbobj.table.Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
          diasRetroativos = r.getAcdi_dias_consulta_retroativa() + "";
        } else {
          if (u.getDiasConsultaRetroativa() != null && u.getDiasConsultaRetroativa() > 0) {
            diasRetroativos = u.getDiasConsultaRetroativa() + "";
          }
        }
      } catch (Exception e) {
        throw e;
      } finally {
        if (connection != null) {
          connection.close();
          connection = null;
        }
      }

      if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
        parametro_dias_retroativos = " and trunc(p.ped_dadg) > trunc(sysdate-" + diasRetroativos + ") ";
      }

      //----------------------------------------------------------
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          codigo_regional = ent.getChave() + "";
        }
        if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
          codigo_representante = ent.getChave() + "";
        }
        if (tipo.equals("ANALISTA REGIONAL")) {
          codigo_analista = ent.getChave() + "";
        }
        if (tipo.equals("GRUPO ECONOMICO")) {
          grupo_economico = ent.getChave() + "";
        }
      }
      if (tipo.equals("ANALISTA REGIONAL")) {
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
          String[][] select = null;
          Object[][] where = { { "codigo_gerente","=",codigo_analista } };
          Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
          if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
            portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
            codigo_regional = r.getCodigo_regional();
          }
        }
        finally {
          if (j != null) {
            j.close();
            j = null;
          }
        }
      }
      //---------------------------------
      conn = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;

      session.setAttribute("consulta_pedidos_ordenacao", (f.getOrdenacao1() != null ? f.getOrdenacao1() : "C"));

      if (f.getPedido_sites() != "") {
        String ped = "";
        ped = qry.retorna("SELECT pia.ped_nmro FROM pre_pedido_rpi ppr, ped_inf_adicionais pia WHERE ppr.pedido_ifv = pia.ped_sequencial_maquina AND ppr.pedido_origem <> 'CATALOGO' AND ppr.id_pedido = " + f.getPedido_sites());
        if (ped.isEmpty()) {
          throw new Exception("Nenhum registro encontrado!");
        } else {
          f.setNr_pedido1(ped);
        }
      }
      if (f.getPedido_catalogo() != "") {
        String ped = "";
        ped = qry.retorna("SELECT pia.ped_nmro FROM pre_pedido_rpi ppr, ped_inf_adicionais pia WHERE ppr.pedido_ifv = pia.ped_sequencial_maquina AND ppr.pedido_origem = 'CATALOGO' AND ppr.id_pedido = " + f.getPedido_catalogo());
        if (ped.isEmpty()) {
          throw new Exception("Nenhum registro encontrado!");
        } else {
          f.setNr_pedido1(ped);
        }
      }
      if (!codigo_representante.equals("")) {
        parametros.append(" AND r.rep_cdgo = ").append(codigo_representante);
      }

      if (!codigo_regional.equals("")) {
        acesso.Sessao sessao = new acesso.Sessao(session);
        StringBuilder sbg = new StringBuilder();
        sbg.append(" SELECT /*+ all_rows */ substr(valor, instr(valor, '#')+1, length(valor)) ");
        sbg.append("   FROM wbrio.parametros ");
        sbg.append("  WHERE nome = 'usuario_consulta_grupo_economico' ");
        sbg.append("    AND substr(valor,0,instr(valor,'#')-1) = '"+sessao.getUsuario() + "' ");
        grupoEconomicoLiberadoUsuario = qry.retorna(conn, sbg.toString());
        if (!grupoEconomicoLiberadoUsuario.equals("")) {
          usuarioConsultaGrupoEconomico = true;
        }
        if (usuarioConsultaGrupoEconomico) {
          StringBuilder sbge = new StringBuilder();
          sbge.append(" AND ((rv.codigo_regional = NVL(").append(codigo_regional).append(", rv.codigo_regional))  ");
          sbge.append("     OR (EXISTS (SELECT 1 ");
          sbge.append("                   FROM grupo_economico ge ");
          sbge.append("                  WHERE ge.cli_cdgo = p.cli_cdgo ");
          sbge.append("                    AND nvl(ge.status,null) = 'A' ");
          sbge.append("                    AND ge.gre_grupo = ").append(grupoEconomicoLiberadoUsuario).append("))) ");
          parametros.append(sbge.toString());
        } else {
          parametros.append(" AND rv.codigo_regional = ").append(codigo_regional);
        }
      }

      if (!f.getNr_pedido1().equals("")) {
        f.setNr_pedido1(f.getNr_pedido1().replace(" ", ""));
        String pedidos = f.getNr_pedido1().replaceAll("[^0-9]", " ").trim();
        pedidos = pedidos.replaceAll("\\s+", " ");
        pedidos = pedidos.replaceAll(" ", "\n");
        pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
        if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
          pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
        }
        parametros.append(" AND p.ped_nmro in (" + pedidos + ") ");
        if (pedidos.indexOf(",") != -1) {
          session.setAttribute("multiplos_pedidos", " AND p.ped_nmro in (" + pedidos + ") ");
          consultaMultiplosPedidos = true;
        }
      }

      if (!f.getPedido_afv1().equals("")) {
        parametros.append(" AND p.ped_sequencial_maquina = '").append(f.getPedido_afv1()).append("'");
      }

      if (!(f.getNr_pedido1() != "") && (!(f.getPedido_sites() != "")) && (!(f.getPedido_catalogo() != "")) && (!(f.getPedido_afv1() != "")) && (!(f.getPed_ped_cliente() != ""))) {
        throw new Exception("Um dos parâmetros de pesquisa devem ser informados!");
      }
      if (!grupo_economico.equals("")) {
        parametros.append(" AND pck_cliente.get_grupo_economico(pck_pedidos.get_cli_cdgo(p.ped_nmro)) = " + grupo_economico);
      }
      //--------------------------------------------------------------

      if (f.getPed_ped_cliente().equals("")) {
        portalbr.dbobj.view.Jw_pedido_regional_representante table_pedido_regional_representante = new portalbr.dbobj.view.Jw_pedido_regional_representante();
        StringBuilder query = new StringBuilder();
        query.append(" SELECT r.rep_cdgo ");
        query.append("      , rv.codigo_regional ");
        query.append("      , p.ped_nmro ");
        query.append("      , p.ped_nped ");
        query.append("      , p.ped_sequencial_maquina ");
        query.append("   FROM ped              p ");
        query.append("      , regionais_vendas rv ");
        query.append("      , rep r ");
        query.append("  WHERE p.rep_cdgo        = r.rep_cdgo ");
        query.append("    AND r.codigo_regional = rv.codigo_regional ");
        query.append(parametros.toString());
        query.append("    AND p.ped_nmro  > 0 ");
        query.append(parametro_dias_retroativos);

        //         if (true) {
        //            throw new Exception(query.toString());
        //         }

        Vector res_ped_reg_rep = conn.select(table_pedido_regional_representante, query.toString(), null);


        if (res_ped_reg_rep != null && res_ped_reg_rep.size() == 0) {
          throw new Exception("Nenhum registro encontrado!");
        }
      }

      //------OC-----------
      if (f.getPed_ped_cliente() != "") {
        tg_select3_action_2(mapping, form, request, response);
        actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&ped_ped_cliente=" + f.getPed_ped_cliente() + "&ped_=" + f.getPed_ped_cliente(), true);
      }

      //-----------------------------------------------------------------------
      // Dispara a trigger para verificar o pedido caso o mesmo seja informado
      //-----------------------------------------------------------------------
      if (f.getNr_pedido1() != "") {
        tg_select3_action(mapping, form, request, response);
        if (!consultaMultiplosPedidos) {
          actionForward = new ActionForward("/com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=" + f.getNr_pedido1(), true);
        } else {
          actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&multiplos=true", true);
        }
      }

      //---------------------------------------------------------------------------
      // Dispara a trigger para verificar o pedido AFV caso o mesmo seja informado
      //---------------------------------------------------------------------------
      if (f.getPedido_afv1() != "") {
        StringBuilder sb = new StringBuilder();
        tg_select3_action_1(mapping, form, request, response);
        portalbr.dbobj.view.Jw_pedido_afv table = new portalbr.dbobj.view.Jw_pedido_afv();
        sb.append(" SELECT p.ped_nmro ");
        sb.append("      , p.ped_sequencial_maquina ");
        sb.append("   FROM ped p ");
        sb.append("  WHERE p.ped_sequencial_maquina = '").append(f.getPedido_afv1()).append("'");
        sb.append("    AND p.ped_nmro > 0 ");
        sb.append(parametro_dias_retroativos);

        Vector res_Ped = conn.select(table, sb.toString(), null);

        if (res_Ped != null && res_Ped.size() > 0) {
          portalbr.dbobj.view.Jw_pedido_afv r = (portalbr.dbobj.view.Jw_pedido_afv) res_Ped.elementAt(0);
          pedido = r.getPed_nmro() + "";
        }

        actionForward = new ActionForward("/com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=" + pedido, true);
      }

    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {

      if (conn != null) {
        conn.close();
        conn = null;
      }
    }
    return actionForward;
  }
  private void tg_select3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //----------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/03/2006
    // Objetivo          : Verifica se o pedido informado existe.
    //----------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------------------

    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    if (session.getAttribute("multiplos_pedidos") == null) {
      try {


        j = new com.egen.util.jdbc.JdbcUtil();
        ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
        portalbr.dbobj.table.Ped table = new portalbr.dbobj.table.Ped();
        String[][] select = null;
        Object[][] where = { {"ped_nmro","=",f.getNr_pedido1()} };
        Vector res_Ped = j.select(table, select, where, null, null, null);
        if (res_Ped != null && res_Ped.size() == 0) {
          throw new Exception("Pedido Inexistente!");
        }
        session.setAttribute(mapping.getName(), form);
      } catch (Exception e) {
        throw e;
      } finally {
        if (j != null) {
          j.close();
          j = null;
        }
      }
    }

  }

  private void tg_select3_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //----------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/03/2006
    // Objetivo          : Verifica se o pedido, baseado no ped_sequencial_maquina (pedido AFV) informado,
    //                     existe.
    //----------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      portalbr.dbobj.view.Jw_pedido_afv table = new portalbr.dbobj.view.Jw_pedido_afv();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ped_nmro ");
      sb.append("      , ped_sequencial_maquina ");
      sb.append("   FROM ped ");
      sb.append("  WHERE ped_sequencial_maquina= '").append(f.getPedido_afv1()).append("'");
      sb.append("    AND ped_nmro > 0");

      Vector res_Ped = j.select(table, sb.toString(), null);

      if (res_Ped != null && res_Ped.size() == 0) {
        throw new Exception("Pedido AFV Inexistente!");
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }

  private void tg_select3_action_2(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      String oc = f.getPed_ped_cliente();
      oc = oc.replace(" ", "");
      String ocs = oc;
      ocs = ocs.replaceAll("\\s+", " ");
      ocs = ocs.replaceAll(" ", "\n");
      ocs = ocs.replaceAll("\\r\\n|\\r|\\n", "','");
      if ((ocs.charAt(ocs.length() - 1) + "").equalsIgnoreCase(",")) {
        ocs = ocs.substring(0, ocs.lastIndexOf(","));
      }

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT DISTINCT ");
      sb.append("        p.ped_ped_cliente ");
      sb.append("   FROM ped p ");
      sb.append("  WHERE p.ped_ped_cliente in ('").append(ocs).append("')");

      pstm = j.getConn().prepareStatement(sb.toString());
      rset = pstm.executeQuery();
      if (!rset.next()) {
        throw new Exception("Nenhum registro encontrado!");
      }
      session.setAttribute("consulta_pedidos_agrupa_cliente","N");
    } catch (Exception e) {
      throw e;
    } finally {
      rset.close();
      pstm.close();
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }


  public ActionForward perform_imprimir_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    //  java.sql.PreparedStatement pstm = null;
    //  java.sql.ResultSet rset = null;
    try {

      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      boolean usuarioConsultaGrupoEconomico = false;
      String grupoEconomicoLiberadoUsuario = null;
      util.consultas.Query query = new util.consultas.Query();
      String grupo_economico = "";
      String tipo = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("GRUPO ECONOMICO")) {
          grupo_economico = ent.getChave() + "";
        }
      }
      acesso.Sessao sessao = new acesso.Sessao(session);
      StringBuilder sbg = new StringBuilder();
      sbg.append(" SELECT /*+ all_rows */ substr(valor, instr(valor, '#')+1, length(valor)) ");
      sbg.append("   FROM wbrio.parametros ");
      sbg.append("  WHERE nome = 'usuario_consulta_grupo_economico' ");
      sbg.append("    AND substr(valor,0,instr(valor,'#')-1) = '"+sessao.getUsuario() + "' ");

      grupoEconomicoLiberadoUsuario = query.retorna(sbg.toString());
      if (!grupoEconomicoLiberadoUsuario.equals("")) {
        usuarioConsultaGrupoEconomico = true;
      }

      if (u.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr0522.rdf");
      }

      util.consultas.Query qry = new util.consultas.Query();
      if (f.getPedido_sites1() != "") {
        String ped = "";
        ped = qry.retorna("SELECT pia.ped_nmro FROM pre_pedido_rpi ppr, ped_inf_adicionais pia WHERE ppr.pedido_ifv = pia.ped_sequencial_maquina AND ppr.pedido_origem <> 'CATALOGO' AND ppr.id_pedido = " + f.getPedido_sites1());
        if (ped.isEmpty()) {
          throw new Exception("Pedido inexistente!");
        } else {
          f.setNr_pedido(ped);
        }
      }
      if (f.getPedido_catalogo1() != "") {
        String ped = "";
        ped = qry.retorna("SELECT pia.ped_nmro FROM pre_pedido_rpi ppr, ped_inf_adicionais pia WHERE ppr.pedido_ifv = pia.ped_sequencial_maquina AND ppr.pedido_origem = 'CATALOGO' AND ppr.id_pedido = " + f.getPedido_catalogo1());
        if (ped.isEmpty()) {
          throw new Exception("Pedido inexistente!");
        } else {
          f.setNr_pedido(ped);
        }
      }
      if (f.getNr_pedido().equals("") && f.getPedido_sites1().equals("") && f.getPedido_catalogo1().equals("") && f.getPedido_afv().equals("") && f.getDt_emissao_ini().equals("") && f.getDt_emissao_fim().equals("")) {
        throw new Exception("Um dos parâmetros deve ser informado!");
      }
      if (f.getNr_pedido().equals("") && f.getPedido_afv().equals("")) {
        if (f.getDt_emissao_ini().equals("") || f.getDt_emissao_fim().equals("")) {
          throw new Exception("O período de emissão deve ser informado!");
        }
      } else {
        StringBuilder parametros = new StringBuilder();
        if (!(f.getNr_pedido().equals(""))) {
          parametros.append(" and p.ped_nmro = ").append(f.getNr_pedido());
        }
        if (!(f.getPedido_afv().equals(""))) {
          parametros.append(" and p.ped_sequencial_maquina = '").append(f.getPedido_afv()).append("'");
        }
        String data_pedido = query.retorna(new StringBuilder(" select to_char(trunc(p.ped_daem),'dd/mm/yyyy') ").append("   from ped p ").append("  where p.ped_daem > sysdate-10000 ").append(parametros).append("    and rownum = 1 ").toString());
        if (data_pedido.equals("")) {
          f.setDt_emissao_ini("");
          f.setDt_emissao_fim("");
          throw new Exception("Pedido inválido!");
        }
        f.setDt_emissao_ini(data_pedido);
        f.setDt_emissao_fim(data_pedido);

      }
      if ((!(f.getDt_emissao_ini().equals(""))) && (!(f.getDt_emissao_fim().equals("")))) {
        if (!com.egen.util.text.Validate.isDate(f.getDt_emissao_ini())) {
          throw new Exception("Data de emissão inicial inválida!");
        }
        if (!com.egen.util.text.Validate.isDate(f.getDt_emissao_fim())) {
          throw new Exception("Data de emissão final inválida!");
        }
        Date d1 = FormatDate.parse(f.getDt_emissao_ini());
        Date d2 = FormatDate.parse(f.getDt_emissao_fim());
        if (d2.before(d1)) {
          throw new Exception("A data de emissão final não pode ser menor que a data de emissão inicial!");
        }

        String parametro_dias_retroativos = "";

        String diasRetroativos = "";
        portalbr.dbobj.table.Acessos_documentos_interfaces table_acessos = new portalbr.dbobj.table.Acessos_documentos_interfaces();
        j = new com.egen.util.jdbc.JdbcUtil();
        try {

          String[][] select = null;
          Object[][] where = { {"Acdi_doin_id","=","75"}, {"Acdi_usua_id","=",u.getId()}, {"Acdi_dias_consulta_retroativa",">",0} };
          Vector res_Acessos_documentos_interfaces = j.select(table_acessos, select, where, null, null, null);
          if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
            portalbr.dbobj.table.Acessos_documentos_interfaces r = (portalbr.dbobj.table.Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
            diasRetroativos = r.getAcdi_dias_consulta_retroativa() + "";
          } else {
            if (u.getDiasConsultaRetroativa() != null && u.getDiasConsultaRetroativa() > 0) {
              diasRetroativos = u.getDiasConsultaRetroativa() + "";
            }
          }

        } catch (Exception e) {
        } finally {
          if (j != null) {
            j.close();
            j = null;
          }
        }

        String data_retroativa = "";
        if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
          data_retroativa = query.retorna("select to_char(sysdate-"+diasRetroativos + ",'dd/mm/yyyy') from dual");
          if (FormatDate.parseDate(data_retroativa).after(FormatDate.parseDate(f.getDt_emissao_ini()))) {
            f.setDt_emissao_ini(data_retroativa);
          }
        }

      }
      //--------------------------------------------------------------------

      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr0522.rdf");
      g.setParametro("P_CODIGO_REGIONAL", f.getCodigo_regional());
      g.setParametro("P_GRUPO_ECONOMICO", grupo_economico);
      g.setParametro("P_REP_CDGO", f.getRep_cdgo());
      g.setParametro("P_DT_ENTREGA_INI", f.getDt_entrega_ini());
      g.setParametro("P_DT_ENTREGA_FIM", f.getDt_entrega_fim());
      g.setParametro("P_DT_EMISSAO_INI", f.getDt_emissao_ini());
      g.setParametro("P_DT_EMISSAO_FIM", f.getDt_emissao_fim());
      g.setParametro("P_SITUACAO", f.getSituacao1());
      g.setParametro("P_TP_PEDIDO", f.getTp_pedido());
      g.setParametro("P_CODIGO_CLIENTE", f.getCliente());
      g.setParametro("P_SEQ_CLIENTE", f.getCli_seq());
      g.setParametro("P_PED_NMRO", f.getNr_pedido());
      g.setParametro("P_PEDIDO_AFV", f.getPedido_afv());
      if (usuarioConsultaGrupoEconomico) {
        g.setParametro("P_REG_GRUPO_ECONOMICO_AGRUPADO", grupoEconomicoLiberadoUsuario);
      }
      //--------------------------------------------------------------------
      g.gerar();
      //--------------------------------------------------------------------
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");

      } else {
        request.setAttribute("abre_automaticamente","N");
      }

      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_2", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //----------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/03/2006
    // Objetivo          : Busca o número do pedido, através do número do pedido do representante,
    //                     e executa a consulta:
    //                     /com/ConsultaPedidos_iForm.jsp
    //----------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j2 = null;
    String ped_nmro = "";
    try {
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      if ((f.getCod_representante() != "") && (f.getNr_pedido_rep1() != "")) {
        tg_select2_action(mapping, form, request, response);
        //------------------------------------------------
        j2 = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Ped table = new portalbr.dbobj.table.Ped();
        String[][] select = null;
        String[] order = null;
        String[] groupby = null;
        String[] having = null;
        Object[][] where = { {"ped_nped","=",f.getNr_pedido_rep1()}, {"rep_cdgo","=",f.getCod_representante()} };

        Vector res_Ped = j2.select(table, select, where, groupby, having, order);
        if (res_Ped != null && res_Ped.size() > 0) {
          portalbr.dbobj.table.Ped r = (portalbr.dbobj.table.Ped) res_Ped.elementAt(0);
          ped_nmro = r.getPed_nmro() + "";

        }
        //------------------------------------------------
        if (res_Ped.size() > 1) {
          actionForward = new ActionForward(new StringBuilder("/com/ConsultaPedidos_dForm.do?select_action=").append("&ped_nped=").append(f.getNr_pedido_rep1()).append("&rep_cdgo=").append(f.getCod_representante()).toString(), true);
        } else {
          actionForward = new ActionForward(new StringBuilder("/com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=").append(ped_nmro).toString(), true);
        }
      } else {
        throw new Exception("informe todos os parâmetros");
      }
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j2 != null) {
        j2.close();
        j2 = null;
      }
    }
    return actionForward;
  }
  private void tg_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //----------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/03/2006
    // Objetivo          : Verifica se o pedido existe.
    //----------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      StringBuilder parametros = new StringBuilder();
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidosActionForm f = (ConsultaPedidosActionForm) form;
      String codigo_regional = "";
      String codigo_representante = "";
      String tipo = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          codigo_regional = ent.getChave() + "";
        }
        if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
          codigo_representante = ent.getChave() + "";
        }
      }
      //---------------------------------
      if (!codigo_representante.equals("")) {
        parametros.append(" AND r.rep_cdgo = ").append(codigo_representante);
      }
      if (!codigo_regional.equals("")) {
        parametros.append(" AND rv.codigo_regional = ").append(codigo_regional);
      }
      //--------------------------------------------------------------

      portalbr.dbobj.view.Jw_pedido_regional_representante table_pedido_regional_representante = new portalbr.dbobj.view.Jw_pedido_regional_representante();
      StringBuilder query = new StringBuilder();
      query.append(" SELECT r.rep_cdgo ");
      query.append("      , rv.codigo_regional ");
      query.append("      , p.ped_nmro ");
      query.append("      , p.ped_nped ");
      query.append("      , p.ped_sequencial_maquina ");
      query.append("   FROM ped               p ");
      query.append("      , regionais_vendas  rv ");
      query.append("      , rep               r ");
      query.append("  WHERE p.rep_cdgo        = r.rep_cdgo ");
      query.append("    AND r.codigo_regional = rv.codigo_regional ");
      query.append("    AND p.ped_nped        = '").append(f.getNr_pedido_rep1()).append("'");
      query.append(parametros.toString());
      query.append("    AND p.ped_nmro        > 0 ");

      Vector res_ped_reg_rep = j.select(table_pedido_regional_representante, query.toString(), null);

      if (res_ped_reg_rep != null && res_ped_reg_rep.size() == 0) {
        throw new Exception("Nenhum registro encontrado!");
      }

      //--------------------------------------------------------------------
      portalbr.dbobj.table.Ped table = new portalbr.dbobj.table.Ped();
      String[][] select = null;
      Object[][] where = { {"ped_nped","=",f.getNr_pedido_rep1()}, {"rep_cdgo","=",f.getCod_representante()} };
      Vector res_Ped = j.select(table, select, where, null, null, null);
      session.setAttribute("res_Ped",res_Ped);
      if (res_Ped != null && res_Ped.size() == 0) {
        throw new Exception("Pedido Inexistente!");
      }
      //--------------------------------------------------------------------
      session.setAttribute(mapping.getName(), form);
    }
    catch (Exception e) {
      throw e;
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }

}
