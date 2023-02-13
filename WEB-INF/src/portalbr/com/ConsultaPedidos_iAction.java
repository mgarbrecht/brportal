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
 * Creation Date 09/03/2006 14:14:38
 * Last Modify Date 11/11/2021 14:37:31
 */

public class ConsultaPedidos_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_ite", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPedidos_iActionForm f = (ConsultaPedidos_iActionForm) form;
    portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite table = new portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite();
    portalbr.dbobj.view.Jw_consulta_pedidos_grade table_itens = new portalbr.dbobj.view.Jw_consulta_pedidos_grade();
    String parametro_dias_retroativos = "";
    String consultaSomenteCliente = "N";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    util.consultas.Query queryUtil = new util.consultas.Query();
    boolean usuarioConsultaGrupoEconomico = false;
    String grupoEconomicoLiberadoUsuario = null;
    acesso.Sessao sessao = new acesso.Sessao(session);
    StringBuilder sbg = new StringBuilder();
    sbg.append(" SELECT /*+ all_rows */ substr(valor, instr(valor, '#')+1, length(valor)) ");
    sbg.append("   FROM wbrio.parametros ");
    sbg.append("  WHERE nome = 'usuario_consulta_grupo_economico' ");
    sbg.append("    AND substr(valor,0,instr(valor,'#')-1) = '"+sessao.getUsuario() + "' ");
    grupoEconomicoLiberadoUsuario = queryUtil.retorna(j, sbg.toString());
    if (!grupoEconomicoLiberadoUsuario.equals("")) {
      usuarioConsultaGrupoEconomico = true;
    }

    //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
    String diasRetroativos = "";
    try {
      portalbr.dbobj.table.Acessos_documentos_interfaces table_acessos = new portalbr.dbobj.table.Acessos_documentos_interfaces();
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
      throw e;
    } finally {
    }

    if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
      parametro_dias_retroativos = " and trunc(p.ped_dadg) >= trunc(sysdate-"+diasRetroativos + ") ";
    }
    //----------------------------------------------------------

    String codigo_regional = "null";
    String codigo_representante = "null";
    String codigo_analista = "";
    String grupo_economico = "";
    String tipo = "";

    String cliente = "null";
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
      if (tipo.equals("GRUPO ECONOMICO")) {
        grupo_economico = ent.getChave() + "";
      }
      if (tipo.equals("ANALISTA REGIONAL")) {
        codigo_analista = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO EXTERNO")) {
        cliente = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO INTERNO")) {
        cliente = ent.getChave() + "";
        consultaSomenteCliente = queryUtil.retorna("SELECT 'S' FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'usuario_desvincular_grupo_economico' and valor = " + cliente);
      }
    }

    if (tipo.equals("ANALISTA REGIONAL")) {
      try {
        portalbr.dbobj.view.Jw_regional_analista tablea = new portalbr.dbobj.view.Jw_regional_analista();
        String[][] select = null;
        Object[][] where = { {"codigo_gerente","=",codigo_analista} };
        Vector res_Jw_regional_analista = j.select(tablea, select, where, null, null, null);
        if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
          portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
          codigo_regional = r.getCodigo_regional();
        }
      }
      finally {
      }
    }




    //----------------------------------------------------------
    StringBuilder query = new StringBuilder();
    query.append(" SELECT p.ped_nmro ped_beira_rio ");
    query.append("      , p.ped_tipo tipo ");
    query.append("      , p.ped_nped ped_repres ");
    query.append("      , p.ped_ped_cliente ped_cliente ");
    query.append("      , decode(p.ped_stat, 'A', 'Liber.Prod','B','Em Análise','C', ");
    query.append("              'Cancelado', 'F', 'Faturado', 'L', 'Liberado', 'P', ");
    query.append("              'Bloq.Cred.', 'PF', 'Parc.Fat', 'T', 'Bloq.Com') st ");
    query.append("      , nota_fiscal.nota nota ");
    query.append("      , nota_fiscal.serie serie ");
    query.append("      , p.cli_cdgo || ' - ' || cl.cli_rzao cliente ");
    query.append("      , r.rep_cdgo || ' - ' || rep_rzao rep ");
    query.append("      , tra_rzao transportadora ");
    query.append("      , to_char(nvl(ped_boni,0), '990.00') bon1 ");
    query.append("      , to_char(nvl(ped_boni2,0), '990.00') bon2  ");
    query.append("      , ped_desc desconto_public ");
    query.append("      , c.descricao corr ");
    query.append("      , e.descricao emb ");
    query.append("      , decode(p.ped_pino_anel, 'S', 'Sim', 'Não') pino_anel ");
    query.append("      , l.liv_codigo || ' - ' || l.liv_descri livro ");
    query.append("      , cnd_desc cond_pagamento ");
    query.append("      , ped_det dt_entrega ");
    query.append("      , to_char(ped_emba, 'dd/mm/yyyy') ped_data_faturamento ");
    query.append("      , to_char(ped_dadg, 'dd/mm/yyyy') dt_digitacao ");
    query.append("      , p.ped_sequencial_maquina ped_afv ");
    query.append("      , p.esc_seqn seq ");
    query.append("      , p.ped_especie_pedido especie ");
    query.append("      , p.ped_obse observ ");
    query.append("      , p.moe_codigo moeda ");
    query.append("      , z.czf_nmro czf_nmro ");
    query.append("      , p.emp_empresa ");
    query.append("      , nota_fiscal.filial fil_filial");
    query.append("      , c.codigo codigo_corrugado ");
    query.append("      , e.codigo codigo_embalagem ");
    query.append("      , p.les_codigo ");
    query.append("      , DECODE(p.ped_emba, NULL, (DECODE(tf.cli_cdgo, NULL, brio.fct_periodo_data_tonel(p.ped_nmro), to_char(ped_det,'dd/mm/yyyy'))), to_char(p.ped_emba,'dd/mm/yyyy')) previsao_faturamento ");
    query.append("      , brio.fct_periodo_data_tonel(p.ped_nmro) previsao_fat ");
    query.append("      , p.ped_invoice ");
    query.append("      , CASE ");
    query.append("               WHEN pck_pedidos.get_origem_pedido(p.ped_nmro) = pck_origem_pedido.get_modare THEN ");
    query.append("                'logo_modarep.jpg' ");
    query.append("               WHEN pck_pedidos.get_origem_pedido(p.ped_nmro) = pck_origem_pedido.get_compra_rapida THEN ");
    query.append("                'logo_compra_rapida.jpg' ");
    query.append("               WHEN pck_lote_estrategico.get_id_lote_by_ped_nmro(p.ped_nmro) IS NOT NULL THEN ");
    query.append("                'logo_lote_estrategico.jpg' ");
    query.append("               WHEN pck_pedidos.get_origem_pedido(p.ped_nmro) = pck_origem_pedido.get_estrategico THEN ");
    query.append("                'logo_estoque_estrategico.jpg' ");
    query.append("               WHEN pck_pedidos.get_origem_pedido(p.ped_nmro) = pck_origem_pedido.get_afv THEN ");
    query.append("                'logo_afv.jpg' ");
    query.append("               WHEN pck_pedidos.get_origem_pedido(p.ped_nmro) = pck_origem_pedido.get_catalogo THEN ");
    query.append("                'logo_catalogo.jpg' ");
    query.append("               WHEN pck_pedidos.get_origem_pedido(p.ped_nmro) = pck_origem_pedido.get_br_programado THEN ");
    query.append("                'logo_compra_programada.jpg' ");
    query.append("               ELSE '' ");
    query.append("             END imagem ");
    query.append("      , CASE WHEN (SELECT nvl(nfs.nfs_valor_frete,0) ");
    query.append("                     FROM nf_saida nfs ");
    query.append("                    WHERE nfs.nfs_nmro = nota_fiscal.nota ");
    query.append("                      AND nfs.nfs_serie = nota_fiscal.serie ");
    query.append("                      AND nfs.emp_empresa = nota_fiscal.empresa ");
    query.append("                      AND nfs.fil_filial = nota_fiscal.filial)>0 THEN 'Há cobrança de frete' ELSE 'Frete isento' END frete ");
    query.append("       ,decode( nvl((select count(1) ");
    query.append("                       from ped_recolocacoes r  ");
    query.append("                      where r.ped_recolocado = p.ped_nmro  ");
    query.append("                        and p.ped_stat = 'C'),0), 0, 'Não', 'Sim' ) recolocado ");
    query.append("       , p.ped_stat ");
    query.append("       , decode( nvl((select count(1) ");
    query.append("                       from situacoes_pedidos sp ");
    query.append("                      where sp.ped_nmro = p.ped_nmro ");
    query.append("                        AND NVL(sp.ts_codigo_situacao, NULL) = 36),0), 0, 'Não', 'Sim' ) fora_normas ");
    query.append("      , p.ped_comr ");
    query.append("      , pia.ped_boni_avaria ");
    query.append("      , pia.bonif_cli_preco_liq desc_com_original ");
    query.append("      , pia.bonif_prom_preco_liq desc_prom_original ");
    query.append("      , pia.livro_preco_preco_liq livro_original ");
    query.append("      , decode(nvl(pia.cobrar_frete,'S'),'S','Não','Sim') frete_isento ");
    query.append("      ,(SELECT n.nfs_vltot FROM nf_saida n WHERE n.ped_nmro = p.ped_nmro AND n.stat_codigo IN (4, 8) AND rownum = 1) valor_nota ");
    query.append("   FROM ped p ");
    query.append("      , tra t ");
    query.append("      , rep r ");
    query.append("      , ped_inf_adicionais pia ");
    query.append("      , brio.cli_respeita_tranca_fat_vw tf ");
    query.append("      , cli cl ");
    query.append("      , corrugados c ");
    query.append("      , embalagens e ");
    query.append("      , cnd n ");
    query.append("      , livro l ");
    query.append("      , czf z ");
    query.append("      , (SELECT nfs_nmro nota ");
    query.append("              , nfs_serie serie ");
    query.append("              , ped_nmro ");
    query.append("              , fil_filial filial ");
    query.append("              , emp_empresa empresa ");
    query.append("           FROM notas_fiscais_saida_ped_venda ");
    query.append("          WHERE ped_nmro > 0) nota_fiscal  ");
    query.append("  WHERE p.ped_nmro               = ").append(f.getPedido_beira_rio());
    query.append("    AND p.rep_cdgo               = r.rep_cdgo ");
    query.append("    AND p.cli_cdgo               = cl.cli_cdgo ");
    query.append("    AND p.tra_cdgo               = t.tra_cdgo ");
    query.append("    AND p.ped_tipo_corrugado     = c.codigo (+) ");
    query.append("    AND p.ped_forma_embalagem    = e.codigo (+) ");
    query.append("    AND p.ped_nmro               = pia.ped_nmro(+) ");
    query.append("    AND p.cnd_cdgo               = n.cnd_cdgo ");
    query.append("    AND p.liv_codigo             = l.liv_codigo ");
    query.append("    AND p.cli_cdgo               = z.cli_cdgo(+) ");
    query.append("    AND nota_fiscal.ped_nmro (+) = p.ped_nmro ");
    query.append("    AND p.esc_seqn               = z.esc_seqn(+) ");

    if (usuarioConsultaGrupoEconomico) {
      StringBuilder sbge = new StringBuilder();
      sbge.append(" AND ((r.codigo_regional = NVL(").append(codigo_regional).append(", r.codigo_regional))  ");
      sbge.append("     or (EXISTS (SELECT 1 ");
      sbge.append("                   FROM grupo_economico ge ");
      sbge.append("                  WHERE ge.cli_cdgo = p.cli_cdgo ");
      sbge.append("                    AND nvl(ge.status,null) = 'A' ");
      sbge.append("                    AND ge.gre_grupo = ").append(grupoEconomicoLiberadoUsuario).append("))) ");
      query.append(sbge.toString());
    } else {
      query.append(" AND r.codigo_regional = nvl(").append(codigo_regional).append(", r.codigo_regional) ");
    }

    query.append("    AND r.rep_cdgo               = nvl("+codigo_representante + ", r.rep_cdgo) ");
    query.append("    AND p.cli_cdgo               = tf.cli_cdgo(+) ");
    if (consultaSomenteCliente.equalsIgnoreCase("S")) {
      query.append("    AND p.cli_cdgo               = nvl("+cliente + ", p.cli_cdgo) ");
    } else {
      if (cliente.equals("null")) {
        query.append("    AND p.cli_cdgo               = nvl("+cliente + ", p.cli_cdgo) ");
      } else {
        query.append("    AND ((pck_cliente.get_grupo_economico(p.cli_cdgo) = pck_cliente.get_grupo_economico("+cliente + ")) OR (p.cli_cdgo = "+cliente + ") ");
        query.append("     OR (p.cli_cdgo IN (SELECT CIA.Cli_Cdgo_Sucessor ");
        query.append("              FROM grupo_economico    ge ");
        query.append("                  ,cli_inf_adicionais cia ");
        query.append("             WHERE ge.gre_grupo = pck_cliente.get_grupo_economico("+cliente + ") ");
        query.append("               AND cia.cli_cdgo = ge.cli_cdgo ");
        query.append("               AND cia.cli_cdgo_sucessor IS NOT NULL))) ");
      }
    }

    if ((!(grupo_economico.equals("")))) {
      query.append(" AND pck_cliente.get_grupo_economico(pck_pedidos.get_cli_cdgo(p.ped_nmro)) = "+grupo_economico);
    }

    query.append(parametro_dias_retroativos);
    Vector res_Jw_consulta_pedidos_ped_ite = j.select(table, query.toString(), null);

    if ((f.getRemove() + "").equalsIgnoreCase("s")) {
      queryUtil .execute("DELETE ite_distribuicao_cliente WHERE ped_nmro = "+f.getPedido_beira_rio() + " and ite_seqn = "+f.getItem());
    }
    session.setAttribute("res_Jw_consulta_pedidos_ped_ite",res_Jw_consulta_pedidos_ped_ite);


    StringBuilder queryi = new StringBuilder();
    queryi.append(" SELECT i.ped_nmro ");
    queryi.append("      , fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) filial_pedido ");
    queryi.append("      , i.gde_cdgo grade ");
    queryi.append("      , ite_seqn item ");
    queryi.append("      , fct_mask_modelo(i.lin_cdgo,i.ref_cdgo) refer ");
    queryi.append("      , substr(ite_descricao,1,30) descricao ");
    queryi.append("      , c.cor_cdgo||' - '|| replace(cor_desc,'/','/ ')  Cor ");
    queryi.append("      , ite_qtde Quant ");
    queryi.append("      , ite_prco Preco ");
    queryi.append("      , ite_prco * ite_qtde Total ");
    queryi.append("      , cab.cab_cdgo ||'-'|| replace(cab.cab_desc,'/','/ ') cabedal ");
    queryi.append("      , fct_retorna_fit_imagem(i.lin_cdgo, i.ref_cdgo, cab.cab_cdgo, c.cor_cdgo) imagem ");
    queryi.append("      , i.lin_cdgo ");
    queryi.append("      , i.ref_cdgo ");
    queryi.append("      , p.les_codigo ");
    queryi.append("      , i.codigo_corrugado ");
    queryi.append("      , cg.descricao descricao_corrugado ");
    queryi.append("      , i.ite_situ ||' - '|| upper((SELECT crc.rv_meaning FROM cg_ref_codes crc WHERE crc.rv_domain = 'ITE_SITU'  AND crc.rv_low_value = i.ite_situ)) ite_situ ");
    queryi.append("      , nvl((SELECT 'S' FROM ite_distribuicao_cliente idc WHERE idc.ped_nmro = i.ped_nmro AND idc.ite_seqn = i.ite_seqn AND rownum = 1),'N') distribuicao ");
    queryi.append("      , fct_ncm_produto(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)) ncm ");
    queryi.append("      , nvl((select 'N' from ref_sem_desconto rsd where rsd.lin_cdgo = i.lin_cdgo and rsd.ref_cdgo = i.ref_cdgo),'S') aceita_descontos ");
    queryi.append("      , i.tes_codigo ");
    queryi.append("      , i.ite_preco_venda item_preco ");
    queryi.append("  , pck_parametros_sugestao_pdv.get_sugestao_pdv(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo) preco_pdv ");
    queryi.append("   FROM ped          p ");
    queryi.append("      , ite          i ");
    queryi.append("      , cor          c ");
    queryi.append("      , cabedal      cab ");
    queryi.append("      , corrugados   cg ");
    queryi.append("  WHERE i.ped_nmro   = ").append(f.getPedido_beira_rio());
    queryi.append("    AND p.ped_nmro   = i.ped_nmro ");
    if (session.getAttribute("consulta_pedidos_somente_entrada") != null) {
      queryi.append("  AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
    }
    queryi.append("    AND cab.cab_cdgo = i.cab_cdgo ");
    queryi.append("    AND i.cor_cdgo   = c.cor_cdgo ");
    queryi.append("    AND cg.codigo    = i.codigo_corrugado ");
    queryi.append("  GROUP BY ite_seqn ");
    queryi.append("         , i.lin_cdgo ");
    queryi.append("         , i.ref_cdgo ");
    queryi.append("         , p.ped_nmro ");
    queryi.append("         , ite_descricao ");
    queryi.append("         , ite_qtde ");
    queryi.append("         , ite_prco ");
    queryi.append("         , c.cor_cdgo ");
    queryi.append("         , cor_desc ");
    queryi.append("         , i.gde_cdgo ");
    queryi.append("         , i.cab_cdgo ");
    queryi.append("         , i.ped_nmro ");
    queryi.append("         , cab.cab_cdgo ");
    queryi.append("         , cab.cab_desc ");
    queryi.append("         , i.lin_cdgo ");
    queryi.append("         , i.ref_cdgo ");
    queryi.append("         , p.les_codigo ");
    queryi.append("         , i.codigo_corrugado ");
    queryi.append("         , cg.descricao ");
    queryi.append("         , i.ite_situ ");
    queryi.append("         , fct_ncm_produto(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)) ");
    queryi.append("         , i.tes_codigo ");
    queryi.append("         , i.ite_preco_venda ");
    queryi.append("         , p.liv_codigo ");
    queryi.append("  ORDER BY ite_seqn ");

    Vector res_Jw_consulta_pedidos_grade = j.select(table_itens, queryi.toString(), null);

    session.setAttribute("res_Jw_consulta_pedidos_grade", res_Jw_consulta_pedidos_grade);
    session.setAttribute("liberaEdicaoDistribuicao", "s");
    if (res_Jw_consulta_pedidos_ped_ite != null && res_Jw_consulta_pedidos_ped_ite.size() > 0) {
      portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite r = (portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite) res_Jw_consulta_pedidos_ped_ite.elementAt(0);
      if (r.getPed_stat().equals("C") || r.getPed_stat().equals("L") || r.getPed_stat().equals("F")) {
        session.removeAttribute("liberaEdicaoDistribuicao");
      }
      f.setPed_beira_rio((r.getPed_beira_rio() != null) ? r.getPed_beira_rio() + "":"");
      f.setTipo((r.getTipo() != null) ? r.getTipo() + "":"");
      f.setPed_repres((r.getPed_repres() != null) ? r.getPed_repres() + "":"");
      f.setPed_cliente((r.getPed_cliente() != null) ? r.getPed_cliente() + "":"");
      f.setSt((r.getSt() != null) ? r.getSt() + "":"");
      f.setRep((r.getRep() != null) ? r.getRep() + "":"");
      f.setMoeda((r.getMoeda() != null) ? r.getMoeda() + "":"");
      f.setPed_afv((r.getPed_afv() != null) ? r.getPed_afv() + "":"");
      f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
      f.setTransportadora((r.getTransportadora() != null) ? r.getTransportadora() + "":"");
      f.setBon1(((r.getBon1() != null) ? com.egen.util.text.FormatNumber.format(r.getBon1(), "##,##0.00") : "") + " %");
      f.setBon2(((r.getBon2() != null) ? com.egen.util.text.FormatNumber.format(r.getBon2(), "##,##0.00") : "") + " %");
      f.setPed_comr(((r.getPed_comr() != null) ? com.egen.util.text.FormatNumber.format(r.getPed_comr(), "##,##0.00") : "") + " %");
      f.setBon1h((r.getBon2() != null) ? r.getBon1() + "":"");
      f.setBon2h((r.getBon2() != null) ? r.getBon2() + "":"");
      f.setDesconto_public((com.egen.util.text.FormatNumber.format(r.getDesconto_public(), "##,##0.00")) + " %");
      f.setCorr((r.getCorr() != null) ? r.getCorr() + "":"");
      f.setEmb((r.getEmb() != null) ? r.getEmb() + "":"");
      f.setSeq((com.egen.util.text.FormatNumber.format(r.getSeq(), "0")) + "");
      f.setPino_anel((r.getPino_anel() != null) ? r.getPino_anel() + "":"");
      f.setLivro((r.getLivro() != null) ? r.getLivro() + "":"");
      f.setCond_pagamento((r.getCond_pagamento() != null) ? r.getCond_pagamento() + "":"");
      f.setDt_entrega(com.egen.util.text.FormatDate.format(r.getDt_entrega(), "dd/MM/yyyy"));
      f.setDt_digitacao((r.getDt_digitacao() != null) ? r.getDt_digitacao() + "":"");
      f.setPed_data_faturamento((r.getPed_data_faturamento() != null) ? r.getPed_data_faturamento() + "":"");
      f.setObserv((r.getObserv() != null) ? r.getObserv() + "":"");
      f.setCzf_nmro((r.getCzf_nmro() != null) ? r.getCzf_nmro() + "":"");
      f.setPrevisao_faturamento((r.getPrevisao_faturamento() != null) ? r.getPrevisao_faturamento() + "":"");
      f.setPrevisao_fat((r.getPrevisao_fat() != null) ? r.getPrevisao_fat() + "":"");
      f.setPed_invoice((r.getPed_invoice() != null) ? r.getPed_invoice() + "":"");
      f.setImagem((r.getImagem() != null) ? r.getImagem() + "":"");
      f.setRecolocado((r.getRecolocado() != null) ? r.getRecolocado() + "":"");
      f.setFrete_isento((r.getFrete_isento() != null) ? r.getFrete_isento() + "":"");
      f.setFora_normas((r.getFora_normas() != null) ? r.getFora_normas() + "":"");
      f.setPed_boni_avaria(((r.getPed_boni_avaria() != null) ? com.egen.util.text.FormatNumber.format(r.getPed_boni_avaria(), "##,##0.00") : ""));
      f.setDesc_com_original(((r.getDesc_com_original() != null) ? com.egen.util.text.FormatNumber.format(r.getDesc_com_original(), "##,##0.00") : ""));
      f.setDesc_prom_original(((r.getDesc_prom_original() != null) ? com.egen.util.text.FormatNumber.format(r.getDesc_prom_original(), "##,##0.00") : ""));
      f.setLivro_original((r.getLivro_original() != null) ? r.getLivro_original() + "":"");

      f.setCodigo_corrugado((r.getCodigo_corrugado() != null) ? r.getCodigo_corrugado() + "":"");
      f.setCodigo_embalagem((r.getCodigo_embalagem() != null) ? r.getCodigo_embalagem() + "":"");

      if (f.getCzf_nmro() != "") {
        f.setCliente(r.getCliente() + " (SUFRAMA- "+f.getCzf_nmro() + " )");
      } else {
        f.setCliente(r.getCliente());
      }
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }

      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_ite", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    //--------------


    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT tra_rzao ");
    sb.append("   FROM ped p ");
    sb.append("      , tra t ");
    sb.append("  WHERE p.ped_nmro = ").append(f.getPed_beira_rio());
    sb.append("    AND p.ped_cons = t.tra_cdgo ");
    sb.append("    AND rownum = 1 ");
    String consignatario = queryUtil.retorna(sb.toString());
    f.setConsignatario(consignatario);

    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_clientes_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidos_iActionForm f = (ConsultaPedidos_iActionForm) form;
      String cliente = f.getCliente().substring(0, f.getCliente().indexOf(" "));
      actionForward = new ActionForward("/adm/CadastroClientes_dForm.do?select_action=&cli_cdgo="+cliente + "&esc_seqn="+f.getSeq(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_ite", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidos_iActionForm f = (ConsultaPedidos_iActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_ite", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      //ConsultaPedidos_iActionForm f = (ConsultaPedidos_iActionForm) form;
      actionForward = new ActionForward("/com/ConsultaPedidos_pForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
