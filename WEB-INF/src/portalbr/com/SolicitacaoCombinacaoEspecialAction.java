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
 * Creation Date 03/02/2012 10:45:13
 * Last Modify Date 09/10/2020 11:39:31
 */

public class SolicitacaoCombinacaoEspecialAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecial_rGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;

    if (f.getDt_entrada_inicial() != null && f.getDt_entrada_inicial().equals("__/__/____")) {
      f.setDt_entrada_inicial("");
    }
    if (f.getDt_entrada_final() != null && f.getDt_entrada_final().equals("__/__/____")) {
      f.setDt_entrada_final("");
    }
    if (f.getData_entrega_amostra() != null && f.getData_entrega_amostra().equals("__/__/____")) {
      f.setData_entrega_amostra("");
    }
    if (f.getData_entrega_amostra_fim() != null && f.getData_entrega_amostra_fim().equals("__/__/____")) {
      f.setData_entrega_amostra_fim("");
    }
    if (f.getSomente_entrada().equalsIgnoreCase("S")) {
      if (f.getDt_entrada_inicial().equals("") || f.getDt_entrada_final().equals("")) {
        throw new Exception("O per&#65533;odo de entrada deve ser informado!");
      }
      //util.consultas.Query query = new util.consultas.Query();
      //String foraPeriodo = query.retorna(j, "SELECT case when MONTHS_BETWEEN(to_date('"+f.getDt_entrada_final() + "','dd/mm/yyyy'), to_date('"+f.getDt_entrada_inicial() + "','dd/mm/yyyy'))>3 then 'S' else 'N' end data_fora_periodo FROM dual");
      //if(foraPeriodo.equalsIgnoreCase("S")){
      //   throw new Exception("O intervalo de entrada n&#65533;o pode ser maior que 3 meses!");
      //}
    }
    Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();
    StringBuilder sb = new StringBuilder();

    sb.append("  SELECT rce.id_solicitacao ");
    sb.append("       , rce.usuario_solicitacao ");
    sb.append("       , rce.data_solicitacao ");
    sb.append("       , rce.codigo_marca ");
    sb.append("       , pck_marcas_produtos.get_nome(rce.codigo_marca) nome_marca ");
    sb.append("       , rce.nova_combinacao ");
    sb.append("       , rce.alteracao_modelo ");
    sb.append("       , rce.amostra ");
    sb.append("       , rce.data_entrega_prevista ");
    sb.append("       , rce.data_entrega_solicitada ");
    sb.append("       , rce.data_entrega_amostra ");
    sb.append("       , rce.lin_cdgo ");
    sb.append("       , pck_linha.get_nome(rce.lin_cdgo) lin_nome ");
    sb.append("       , rce.ref_cdgo ");
    sb.append("       , pck_referencia.get_nome(rce.lin_cdgo, rce.ref_cdgo) ref_desc ");
    sb.append("       , rce.cab_cdgo ");
    sb.append("       , pck_cabedal.get_nome(rce.cab_cdgo) cab_desc ");
    sb.append("       , rce.cor_cdgo ");
    sb.append("       , pck_cor.get_nome(rce.cor_cdgo) cor_desc ");
    sb.append("       , rce.observacao ");
    sb.append("       , rce.material_cor1 ");
    sb.append("       , rce.material_cor2 ");
    sb.append("       , rce.material_cor3 ");
    sb.append("       , rce.biqueira_debrum ");
    sb.append("       , rce.capa_palmilha ");
    sb.append("       , rce.cacharel ");
    sb.append("       , rce.forro ");
    sb.append("       , rce.metais ");
    sb.append("       , rce.taloneira ");
    sb.append("       , rce.salto ");
    sb.append("       , rce.enfeite ");
    sb.append("       , rce.carimbo_etiqueta ");
    sb.append("       , rce.cli_cdgo ");
    sb.append("       , pck_cliente.get_nome(rce.cli_cdgo) cli_rzao ");
    sb.append("       , rce.gre_grupo ");
    sb.append("       , pck_grupo_economico.get_nome(rce.gre_grupo) gre_descricao  ");
    sb.append("       , rce.prs_negociacao ");
    sb.append("       , rce.pares_linha ");
    sb.append("       , rce.pares_alteracao ");
    sb.append("       , rce.preco_liguido ");
    sb.append("       , rce.ll_alteracao_solicitada ");
    sb.append("       , rce.situacao_solicitacao ");
    sb.append("       , cgrc.rv_meaning situacao_solicitacao_desc ");
    sb.append("       , rce.data_aceite ");
    sb.append("       , rce.usuario_aceite ");
    sb.append("       , rce.imagem_produto ");
    sb.append("       , rcei.imagem ");
    sb.append("       , decode(rce.gre_grupo,null,(rce.cli_cdgo||' - '||pck_cliente.get_nome(rce.cli_cdgo) ),rce.gre_grupo || ' - ' || pck_grupo_economico.get_nome(rce.gre_grupo) || ' (<small>' || replace(rowtocol('SELECT cli_Cdgo FROM grupo_economico ge WHERE ge.gre_grupo = '||rce.gre_grupo||' AND status = ''A'''),',',', ') || '</small>)') cliente_grupo_economico    ");
    sb.append("       , rce.desenvolvimento ");
    sb.append("       , rce.data_desenvolvimento ");
    sb.append("       , rce.fora_mix ");
    sb.append("       , rce.data_fora_mix ");
    sb.append("       , rce.manipulacao ");
    sb.append("       , rce.data_manipulacao ");
    sb.append("       , rce.modelo_exclusivo ");
    sb.append("       , rce.tipo_solicitacao_comb_especial ");
    sb.append("       , cgr.rv_meaning desc_solicitacao_comb_especial ");
    sb.append("       , rce.subtipo_solicitacao_comb_espec ");
    sb.append("       , crc.rv_meaning desc_subtipo_comb_espec ");
    sb.append("       , rce.data_aprovacao ");
    sb.append("       , rce.material ");
    sb.append("       , pck_regionais_vendas.get_sigla(pck_representante.get_regional(rce.rep_cdgo)) regional ");

    if (f.getSomente_entrada().equalsIgnoreCase("S")) {
      sb.append("       , CASE ");
      sb.append("             WHEN lin_cdgo IS NOT NULL AND ref_cdgo IS NOT NULL AND ");
      sb.append("                  cab_cdgo IS NOT NULL AND cor_cdgo IS NOT NULL AND ");
      sb.append("                  tipo_solicitacao_comb_especial NOT IN ('12', '1') THEN ");
      sb.append("              (SELECT SUM(i.ite_qtde) total_pares_vendidos ");
      sb.append("                 FROM ped p ");
      sb.append("                    , ite i ");
      sb.append("                WHERE i.lin_cdgo = rce.lin_cdgo ");
      sb.append("                  AND i.ref_cdgo = rce.ref_cdgo ");
      sb.append("                  AND i.cab_cdgo = rce.cab_cdgo ");
      sb.append("                  AND i.cor_cdgo = rce.cor_cdgo ");
      sb.append("                  AND p.ped_nmro = i.ped_nmro ");
      sb.append("                  AND p.ped_dadg >= to_date('"+f.getDt_entrada_inicial() + "', 'dd/mm/yyyy') ");
      sb.append("                  AND p.ped_dadg < to_date('"+f.getDt_entrada_final() + "', 'dd/mm/yyyy') + 1 ");
      sb.append("                  AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = ");
      sb.append("                      pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn)) ");
      sb.append("             ELSE ");
      sb.append("              NULL ");
      sb.append("           END pares_vendidos ");
    } else {
      sb.append("     , null pares_vendidos ");
    }

    sb.append("    FROM brio.ref_combinacao_especial rce ");
    sb.append("       , cg_ref_codes                 cgr ");
    sb.append("       , cg_ref_codes                 crc ");
    sb.append("       , cg_ref_codes                 cgrc ");
    sb.append("       , brio.ref_combinacao_especial_img rcei ");
    sb.append("  WHERE cgr.rv_domain(+) = 'TIPO_SOLICITACAO_COMB_ESPECIAL' ");
    sb.append("    AND cgr.rv_low_value(+) = rce.tipo_solicitacao_comb_especial ");
    sb.append("    AND nvl(rce.tipo_solicitacao_comb_especial,null) <> 11 ");
    sb.append("    AND crc.rv_domain(+) = 'SUBTIPO_SOLICITACAO_COMB_ESPEC' ");
    sb.append("    AND crc.rv_low_value(+) = rce.subtipo_solicitacao_comb_espec ");
    sb.append("    AND cgrc.rv_domain(+) = 'SITUACAO_SOLICITACAO_COMB_ESPEC' ");
    sb.append("    AND cgrc.rv_low_value(+) = rce.situacao_solicitacao ");
    sb.append("    AND rce.id_solicitacao = rcei.id_solicitacao(+) ");

    if (!f.getTipo_mercado().equalsIgnoreCase("T")) {
      sb.append(" AND (rce.cli_cdgo IS NULL OR rce.cli_cdgo = (SELECT cli_cdgo ");
      sb.append("                                                FROM cli c ");
      sb.append("                                               WHERE c.cli_cdgo = rce.cli_cdgo ");
      sb.append("                                                 AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "')) ");
      sb.append(" AND (rce.gre_grupo IS NULL OR  rce.gre_grupo = (SELECT rce.gre_grupo ");
      sb.append("                                                   FROM grupo_economico g ");
      sb.append("                                                      , cli             c ");
      sb.append("                                                  WHERE g.cli_cdgo = c.cli_cdgo ");
      sb.append("                                                    AND g.status = 'A' ");
      sb.append("                                                    AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "' ");
      sb.append("                                                    AND g.gre_grupo = rce.gre_grupo ");
      sb.append("                                                    AND rownum = 1)) ");
    }

    if (f.getMaterial() != "") {
      sb.append(" AND nvl(rce.material,null) = '"+f.getMaterial() + "' ");
    }
    if (f.getId_solicitacao() != "") {
      sb.append(" AND rce.id_solicitacao = " + f.getId_solicitacao());
    }
    if (f.getCli_cdgo() != "") {
      sb.append(" AND rce.cli_cdgo IN (" + f.getCli_cdgo() + ") ");
    }
    if (f.getCodigo_marca() != "") {
      sb.append(" AND rce.codigo_marca in (" + f.getCodigo_marca() + ")");
    }
    if (f.getLin_cdgo() != "") {
      sb.append(" AND rce.lin_cdgo = " + f.getLin_cdgo());
    }
    if (f.getGre_grupo() != "") {
      sb.append(" AND rce.gre_grupo = " + f.getGre_grupo());
    }
    if (f.getRep_cdgo() != "") {
      sb.append(" AND rce.rep_cdgo = " + f.getRep_cdgo());
    }
    if (f.getRegional() != "") {
      sb.append(" AND pck_representante.get_regional(rce.rep_cdgo) = " + f.getRegional());
    }
    if (f.getData_inicial_aprovacao() != "") {
      sb.append(" AND trunc(rce.data_aprovacao) >= to_date('"+f.getData_inicial_aprovacao() + "','dd/mm/yyyy')");
    }
    if (f.getData_final_aprovacao() != "") {
      sb.append(" AND trunc(rce.data_aprovacao) <= to_date('"+f.getData_final_aprovacao() + "','dd/mm/yyyy')");
    }
    if (f.getData_solicitacao() != "") {
      sb.append(" AND trunc(rce.data_solicitacao) >= to_date('"+f.getData_solicitacao() + "','dd/mm/yyyy') ");
    }
    if (f.getData_solicitacao_final() != "") {
      sb.append(" AND trunc(rce.data_solicitacao) <= to_date('"+f.getData_solicitacao_final() + "','dd/mm/yyyy') ");
    }
    if (f.getData_entrega_amostra() != "") {
      sb.append(" AND trunc(rce.data_entrega_amostra) >= to_date('"+f.getData_entrega_amostra() + "','dd/mm/yyyy') ");
    }
    if (f.getData_entrega_amostra_fim() != "") {
      sb.append(" AND trunc(rce.data_entrega_amostra) <= to_date('"+f.getData_entrega_amostra_fim() + "','dd/mm/yyyy') ");
    }
    if (f.getSituacao_solicitacao() != "") {
      sb.append(" AND rce.situacao_solicitacao IN (" + f.getSituacao_solicitacao() + ") ");
    }

    if (f.getTipo_solicitacao() != "") {
      sb.append(" AND rce.tipo_solicitacao_comb_especial IN ("+f.getTipo_solicitacao() + ") ");
    }

    if (f.getSubtipo_solicitacao_comb_espec() != "") {
      sb.append(" AND rce.subtipo_solicitacao_comb_espec IN ("+f.getSubtipo_solicitacao_comb_espec() + ") ");
    }

    if ((f.getTipo_solicitacao().equals("5")) && (f.getSituacao_solicitacao().equalsIgnoreCase("'I'"))) {
      session.setAttribute("fora_mix", "true");
    } else {
      session.setAttribute("fora_mix", "false");
    }

    sb.append("  ORDER BY codigo_marca, desc_solicitacao_comb_especial, cli_rzao, nvl(pares_alteracao,0) desc ");

    session.setAttribute("where", sb.toString());

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_ref_combinacao_especial = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
    if (!(res_Jw_ref_combinacao_especial != null && res_Jw_ref_combinacao_especial.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      if (true) {
        throw new Exception("Nenhum registro encontrado!");
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      session.removeAttribute("res_Jw_ref_combinacao_especial");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      session.removeAttribute("est102_marcas_selecionadas_vetor");
      session.removeAttribute("est102_marcas_selecionadas_codigos");
      session.removeAttribute("situacoes_solicitacao_comb_espec_vetor");
      session.removeAttribute("situacoes_solicitacao_comb_espec_codigos");
      session.removeAttribute("tipos_solicitacao_comb_espec_vetor");
      session.removeAttribute("tipos_solicitacao_comb_espec_codigos");
      session.removeAttribute("subtipos_solicitacao_comb_espec_vetor");
      session.removeAttribute("subtipos_solicitacao_comb_espec_codigos");
      session.removeAttribute("lista_clientes_selecionados");
      session.removeAttribute("lista_clientes_selecionados_codigos");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecial_iForm.do?resetfull_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      select2_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecial_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
    Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();
    Vector res_Jw_ref_combinacao_especial = j.select(table, (String) session.getAttribute("where"), null);
    session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
    if (res_Jw_ref_combinacao_especial != null && res_Jw_ref_combinacao_especial.size() > 0) {
      Jw_ref_combinacao_especial r = (Jw_ref_combinacao_especial) res_Jw_ref_combinacao_especial.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_gerar_relatorio_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      StringBuilder sb = new StringBuilder();
      acesso.Sessao sessao = new acesso.Sessao(session);

      if (f.getDt_entrada_inicial() != null && f.getDt_entrada_inicial().equals("__/__/____")) {
        f.setDt_entrada_inicial("");
      }
      if (f.getDt_entrada_final() != null && f.getDt_entrada_final().equals("__/__/____")) {
        f.setDt_entrada_final("");
      }
      if (f.getSomente_entrada().equalsIgnoreCase("S")) {
        if (f.getDt_entrada_inicial().equals("") || f.getDt_entrada_final().equals("")) {
          throw new Exception("O per&#65533;odo de entrada deve ser informado!");
        }
        //util.consultas.Query query = new util.consultas.Query();
        //String foraPeriodo = query.retorna("SELECT case when MONTHS_BETWEEN(to_date('"+f.getDt_entrada_final() + "','dd/mm/yyyy'), to_date('"+f.getDt_entrada_inicial() + "','dd/mm/yyyy'))>3 then 'S' else 'N' end data_fora_periodo FROM dual");
        //if(foraPeriodo.equalsIgnoreCase("S")){
        //   throw new Exception("O intervalo de entrada n&#65533;o pode ser maior que 3 meses!");
        //}
      }

      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      if (f.getSomente_entrada().equals("S")) {
        g.setRelatorio("SolicitacaoCombinacaoEspecialVendidos.jasper");
        g.setParametro("P_QUERY_ENTRADA", " AND p.ped_dadg >= to_date('"+f.getDt_entrada_inicial() + "', 'dd/mm/yyyy') AND p.ped_dadg <  to_date('"+f.getDt_entrada_final() + "', 'dd/mm/yyyy') + 1 ");
        g.setParametro("P_DT_ENTRADA_INICIAL", f.getDt_entrada_inicial());
        g.setParametro("P_DT_ENTRADA_FINAL", f.getDt_entrada_final());
      } else {
        g.setRelatorio("SolicitacaoCombinacaoEspecial.jasper");
      }


      if (f.getMaterial() != "") {
        sb.append(" AND nvl(rce.material,null) = '"+f.getMaterial() + "' ");
      }
      if (f.getLin_cdgo() != "") {
        sb.append(" AND rce.lin_cdgo = " + f.getLin_cdgo());
      }

      if (f.getId_solicitacao() != "") {
        sb.append(" AND id_solicitacao = " + f.getId_solicitacao());
      }
      if (f.getCli_cdgo() != "") {
        sb.append(" AND cli_cdgo IN (" + f.getCli_cdgo() + ") ");
      }
      if (f.getCodigo_marca() != "") {
        sb.append(" AND codigo_marca IN (" + f.getCodigo_marca() + ")");
      }
      if (f.getGre_grupo() != "") {
        sb.append(" AND gre_grupo = " + f.getGre_grupo());
      }
      if (f.getRep_cdgo() != "") {
        sb.append(" AND rep_cdgo = " + f.getRep_cdgo());
      }
      if (f.getRegional() != "") {
        sb.append(" AND pck_representante.get_regional(rce.rep_cdgo) = " + f.getRegional());
      }
      if (f.getData_solicitacao() != "") {
        g.setParametro("P_DT_INICIAL", f.getData_solicitacao());
        sb.append(" AND trunc(data_solicitacao) >= to_date('"+f.getData_solicitacao() + "','dd/mm/yyyy') ");
      }
      if (f.getData_solicitacao_final() != "") {
        g.setParametro("P_DT_FINAL", f.getData_solicitacao_final());
        sb.append(" AND trunc(data_solicitacao) <= to_date('"+f.getData_solicitacao_final() + "','dd/mm/yyyy') ");
      }
      if (f.getData_entrega_amostra() != "") {
        sb.append(" AND trunc(data_entrega_amostra) >= to_date('"+f.getData_entrega_amostra() + "','dd/mm/yyyy') ");
      }
      if (f.getData_entrega_amostra_fim() != "") {
        sb.append(" AND trunc(data_entrega_amostra) <= to_date('"+f.getData_entrega_amostra_fim() + "','dd/mm/yyyy') ");
      }
      if (f.getSituacao_solicitacao() != "") {
        sb.append(" AND situacao_solicitacao IN (" + f.getSituacao_solicitacao() + ") ");
      }
      if (f.getTipo_solicitacao() != "") {
        sb.append(" AND tipo_solicitacao_comb_especial IN (" + f.getTipo_solicitacao() + ") ");
      }
      if (f.getSubtipo_solicitacao_comb_espec() != "") {
        sb.append(" AND subtipo_solicitacao_comb_espec IN ("+f.getSubtipo_solicitacao_comb_espec() + ") ");
      }
      if (f.getSubtipo_solicitacao_comb_espec() != "") {
        sb.append(" AND subtipo_solicitacao_comb_espec = '" + f.getSubtipo_solicitacao_comb_espec() + "'");
      }
      sb.append(" AND  nvl(tipo_solicitacao_comb_especial, null) <> 11 ");
      if (!f.getTipo_mercado().equalsIgnoreCase("T")) {
        sb.append(" AND (rce.cli_cdgo IS NULL OR rce.cli_cdgo = (SELECT cli_cdgo ");
        sb.append("                                                FROM cli c ");
        sb.append("                                               WHERE c.cli_cdgo = rce.cli_cdgo ");
        sb.append("                                                 AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "')) ");
        sb.append(" AND (rce.gre_grupo IS NULL OR  rce.gre_grupo = (SELECT rce.gre_grupo ");
        sb.append("                                                   FROM grupo_economico g ");
        sb.append("                                                      , cli             c ");
        sb.append("                                                  WHERE g.cli_cdgo = c.cli_cdgo ");
        sb.append("                                                    AND g.status = 'A' ");
        sb.append("                                                    AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "' ");
        sb.append("                                                    AND g.gre_grupo = rce.gre_grupo ");
        sb.append("                                                    AND rownum = 1)) ");
      }
      g.setParametro("P_QUERY", sb.toString());

      g.gerar();
      //--------------------------------------------------------------------------

      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_gerar_relatorio_resumo_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {

      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      StringBuilder sb = new StringBuilder();
      StringBuilder sbAnt = new StringBuilder();
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("SolicitacaoCombinacaoEspecialResMarca.jasper");

      if (f.getMaterial() != "") {
        sb.append(" AND nvl(rce.material,null) = '"+f.getMaterial() + "' ");
      }
      if (f.getLin_cdgo() != "") {
        sb.append(" AND rce.lin_cdgo = " + f.getLin_cdgo());
      }
      if (f.getId_solicitacao() != "") {
        sb.append(" AND id_solicitacao = " + f.getId_solicitacao());
      }
      if (f.getCli_cdgo() != "") {
        sb.append(" AND cli_cdgo IN (" + f.getCli_cdgo() + ") ");
      }
      if (f.getCodigo_marca() != "") {
        sb.append(" AND codigo_marca IN (" + f.getCodigo_marca() + ") ");
      }
      if (f.getGre_grupo() != "") {
        sb.append(" AND gre_grupo = " + f.getGre_grupo());
      }
      if (f.getRep_cdgo() != "") {
        sb.append(" AND rep_cdgo = " + f.getRep_cdgo());
      }
      if (f.getRegional() != "") {
        sb.append(" AND pck_representante.get_regional(rce.rep_cdgo) = " + f.getRegional());
      }
      if (f.getSituacao_solicitacao() != "") {
        sb.append(" AND situacao_solicitacao IN (" + f.getSituacao_solicitacao() + ") ");
      }
      if (f.getTipo_solicitacao() != "") {
        sb.append(" AND tipo_solicitacao_comb_especial IN (" + f.getTipo_solicitacao() + ") ");
      }
      if (f.getSubtipo_solicitacao_comb_espec() != "") {
        sb.append(" AND subtipo_solicitacao_comb_espec IN ("+f.getSubtipo_solicitacao_comb_espec() + ") ");
      }
      if (f.getSubtipo_solicitacao_comb_espec() != "") {
        sb.append(" AND subtipo_solicitacao_comb_espec = '" + f.getSubtipo_solicitacao_comb_espec() + "'");
      }
      sb.append(" AND  nvl(tipo_solicitacao_comb_especial, null) <> 11 ");
      if (!f.getTipo_mercado().equalsIgnoreCase("T")) {
        sb.append(" AND (rce.cli_cdgo IS NULL OR rce.cli_cdgo = (SELECT cli_cdgo ");
        sb.append("                                                FROM cli c ");
        sb.append("                                               WHERE c.cli_cdgo = rce.cli_cdgo ");
        sb.append("                                                 AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "')) ");
        sb.append(" AND (rce.gre_grupo IS NULL OR  rce.gre_grupo = (SELECT rce.gre_grupo ");
        sb.append("                                                   FROM grupo_economico g ");
        sb.append("                                                      , cli             c ");
        sb.append("                                                  WHERE g.cli_cdgo = c.cli_cdgo ");
        sb.append("                                                    AND g.status = 'A' ");
        sb.append("                                                    AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "' ");
        sb.append("                                                    AND g.gre_grupo = rce.gre_grupo ");
        sb.append("                                                    AND rownum = 1)) ");
      }
      sbAnt.append(sb.toString());
      if (f.getData_solicitacao() != "") {
        g.setParametro("P_DT_INICIAL", f.getData_solicitacao());
        sb.append(" AND trunc(data_solicitacao) >= to_date('"+f.getData_solicitacao() + "','dd/mm/yyyy') ");
        sbAnt.append(" AND trunc(data_solicitacao) >= add_months(to_date('"+f.getData_solicitacao() + "','dd/mm/yyyy'), -12) ");
      }
      if (f.getData_solicitacao_final() != "") {
        g.setParametro("P_DT_FINAL", f.getData_solicitacao_final());
        sb.append(" AND trunc(data_solicitacao) <= to_date('"+f.getData_solicitacao_final() + "','dd/mm/yyyy') ");
        sbAnt.append(" AND trunc(data_solicitacao) <= add_months(to_date('"+f.getData_solicitacao_final() + "','dd/mm/yyyy'), -12) ");
      }
      if (f.getData_entrega_amostra() != "") {
        sb.append(" AND trunc(data_entrega_amostra) >= to_date('"+f.getData_entrega_amostra() + "','dd/mm/yyyy') ");
      }
      if (f.getData_entrega_amostra_fim() != "") {
        sb.append(" AND trunc(data_entrega_amostra) <= to_date('"+f.getData_entrega_amostra_fim() + "','dd/mm/yyyy') ");
      }
      g.setParametro("P_QUERY", sb.toString());
      g.setParametro("P_QUERY_ANT", sbAnt.toString());

      g.gerar();
      //--------------------------------------------------------------------------

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_gerar_relatorio_ranking_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      StringBuilder sb = new StringBuilder();
      acesso.Sessao sessao = new acesso.Sessao(session);

      if (f.getDt_entrada_inicial() != null && f.getDt_entrada_inicial().equals("__/__/____")) {
        f.setDt_entrada_inicial("");
      }
      if (f.getDt_entrada_final() != null && f.getDt_entrada_final().equals("__/__/____")) {
        f.setDt_entrada_final("");
      }
      if (f.getSomente_entrada().equalsIgnoreCase("S")) {
        if (f.getDt_entrada_inicial().equals("") || f.getDt_entrada_final().equals("")) {
          throw new Exception("O per&#65533;odo de entrada deve ser informado!");
        }
      }

      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("SolicitacaoCombinacaoEspecialRanking.jasper");

      if (f.getData_solicitacao() != "") {
        g.setParametro("P_DT_INICIAL", f.getData_solicitacao());
      }
      if (f.getData_solicitacao_final() != "") {
        g.setParametro("P_DT_FINAL", f.getData_solicitacao_final());
      }
      if (!f.getNumero_ranking().equals("")) {
        g.setParametro("P_LIMITE_CLIENTE_RANKING1", f.getNumero_ranking());
      }
      if (f.getNumero_ranking().equals("")) {
        g.setParametro("P_LIMITE_CLIENTE_RANKING1", 5 + "");
      }

      if (f.getSomente_entrada().equals("S")) {
        g.setParametro("P_DT_ENTRADA_INICIAL", f.getDt_entrada_inicial());
        g.setParametro("P_DT_ENTRADA_FINAL", f.getDt_entrada_final());
      } else {
        g.setParametro("P_DT_ENTRADA_INICIAL", f.getData_solicitacao());
        g.setParametro("P_DT_ENTRADA_FINAL", f.getData_solicitacao_final());
      }

      if (f.getMaterial() != "") {
        sb.append(" AND nvl(rce.material,null) = '"+f.getMaterial() + "' ");
      }
      if (f.getLin_cdgo() != "") {
        sb.append(" AND rce.lin_cdgo = " + f.getLin_cdgo());
      }

      if (f.getId_solicitacao() != "") {
        sb.append(" AND rce.id_solicitacao = " + f.getId_solicitacao());
      }
      if (f.getCli_cdgo() != "") {
        sb.append(" AND rce.cli_cdgo IN (" + f.getCli_cdgo() + ") ");
      }
      if (f.getCodigo_marca() != "") {
        sb.append(" AND rce.codigo_marca IN (" + f.getCodigo_marca() + ") ");
      }
      if (f.getGre_grupo() != "") {
        sb.append(" AND rce.gre_grupo = " + f.getGre_grupo());
      }
      if (f.getRep_cdgo() != "") {
        sb.append(" AND rce.rep_cdgo = " + f.getRep_cdgo());
      }
      if (f.getRegional() != "") {
        sb.append(" AND pck_representante.get_regional(rce.rep_cdgo) = " + f.getRegional());
      }
      if (f.getData_entrega_amostra() != "") {
        sb.append(" AND trunc(rce.data_entrega_amostra) >= to_date('"+f.getData_entrega_amostra() + "','dd/mm/yyyy') ");
      }
      if (f.getData_entrega_amostra_fim() != "") {
        sb.append(" AND trunc(rce.data_entrega_amostra) <= to_date('"+f.getData_entrega_amostra_fim() + "','dd/mm/yyyy') ");
      }
      if (f.getSituacao_solicitacao() != "") {
        sb.append(" AND rce.situacao_solicitacao IN (" + f.getSituacao_solicitacao() + ") ");
      }
      if (f.getTipo_solicitacao() != "") {
        sb.append(" AND rce.tipo_solicitacao_comb_especial IN (" + f.getTipo_solicitacao() + ") ");
      }
      if (f.getSubtipo_solicitacao_comb_espec() != "") {
        sb.append(" AND rce.subtipo_solicitacao_comb_espec IN ("+f.getSubtipo_solicitacao_comb_espec() + ") ");
      }
      if (f.getSubtipo_solicitacao_comb_espec() != "") {
        sb.append(" AND subtipo_solicitacao_comb_espec = '" + f.getSubtipo_solicitacao_comb_espec() + "'");
      }
      sb.append(" AND  nvl(rce.tipo_solicitacao_comb_especial, null) <> 11 ");
      if (!f.getTipo_mercado().equalsIgnoreCase("T")) {
        sb.append(" AND (rce.cli_cdgo IS NULL OR rce.cli_cdgo = (SELECT cli_cdgo ");
        sb.append("                                                FROM cli c ");
        sb.append("                                               WHERE c.cli_cdgo = rce.cli_cdgo ");
        sb.append("                                                 AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "')) ");
        sb.append(" AND (rce.gre_grupo IS NULL OR  rce.gre_grupo = (SELECT rce.gre_grupo ");
        sb.append("                                                   FROM grupo_economico g ");
        sb.append("                                                      , cli             c ");
        sb.append("                                                  WHERE g.cli_cdgo = c.cli_cdgo ");
        sb.append("                                                    AND g.status = 'A' ");
        sb.append("                                                    AND c.cli_tipo_mercado = '"+f.getTipo_mercado() + "' ");
        sb.append("                                                    AND g.gre_grupo = rce.gre_grupo ");
        sb.append("                                                    AND rownum = 1)) ");
      }
      g.setParametro("P_QUERY", sb.toString());

      g.gerar();
      //--------------------------------------------------------------------------

      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      try {
        select3_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select3_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
    Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();
    String[][] select = null;
    String[] order = {"data_solicitacao desc"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"data_solicitacao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy")}, {"data_entrega_amostra","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_entrega_amostra(), "dd/MM/yyyy")}, {"codigo_marca","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_marca())}, {"material","like", f.getMaterial()}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo())}, {"lin_nome","like", f.getLin_nome()}, {"situacao_solicitacao","like", f.getSituacao_solicitacao()}, {"cli_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCli_cdgo())}, {"cli_rzao","like", f.getCli_rzao()}, {"gre_grupo","=", com.egen.util.text.FormatNumber.toInteger(f.getGre_grupo())}, {"gre_descricao","like", f.getGre_descricao()}, {"rep_cdgo","like", f.getRep_cdgo()}, {"rep_rzao","like", f.getRep_rzao()}, {"regional","like", f.getRegional()}, {"subtipo_solicitacao_comb_espec","like", f.getSubtipo_solicitacao_comb_espec()}, };
    Vector res_Jw_ref_combinacao_especial = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
    if (res_Jw_ref_combinacao_especial != null && res_Jw_ref_combinacao_especial.size() > 0) {
      Jw_ref_combinacao_especial r = (Jw_ref_combinacao_especial) res_Jw_ref_combinacao_especial.elementAt(0);
      f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
      f.setImagem((r.getImagem() != null) ? r.getImagem() + "":"");
      f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy"));
      f.setData_entrega_amostra(com.egen.util.text.FormatDate.format(r.getData_entrega_amostra(), "dd/MM/yyyy"));
      f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
      f.setMaterial((r.getMaterial() != null) ? r.getMaterial() + "":"");
      f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
      f.setLin_nome((r.getLin_nome() != null) ? r.getLin_nome() + "":"");
      f.setSituacao_solicitacao((r.getSituacao_solicitacao() != null) ? r.getSituacao_solicitacao() + "":"");
      f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
      f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
      f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
      f.setGre_descricao((r.getGre_descricao() != null) ? r.getGre_descricao() + "":"");
      f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
      f.setRep_rzao((r.getRep_rzao() != null) ? r.getRep_rzao() + "":"");
      f.setRegional((r.getRegional() != null) ? r.getRegional() + "":"");
      f.setSubtipo_solicitacao_comb_espec((r.getSubtipo_solicitacao_comb_espec() != null) ? r.getSubtipo_solicitacao_comb_espec() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_limpar_clientes_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoCombinacaoEspecialActionForm f = (SolicitacaoCombinacaoEspecialActionForm) form;
      session.removeAttribute("lista_clientes_selecionados");
      session.removeAttribute("lista_clientes_selecionados_codigos");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
