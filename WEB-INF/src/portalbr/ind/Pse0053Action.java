package portalbr.ind;

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
 * Creation Date 02/09/2009 10:14:34
 * Last Modify Date 19/10/2021 17:42:37
 */

public class Pse0053Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Pse0053ActionForm f = (Pse0053ActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/Pse0053_r2Form.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Pse0053ActionForm f = (Pse0053ActionForm) form;
    Jw_pse0053_forn table = new Jw_pse0053_forn();
    Jw_pse0053_total_aberto table_aberto = new Jw_pse0053_total_aberto();
    Jw_pse0053_total_fechado table_fechado = new Jw_pse0053_total_fechado();
    Jw_pse0053_notas_fiscais table_notas_fiscais = new Jw_pse0053_notas_fiscais();

    session.removeAttribute("pse0053_resumo");
    session.removeAttribute("pse0053_r_tipo");
    session.removeAttribute("pse0053_r_filial");
    session.removeAttribute("pse0053_tipo");
    session.removeAttribute("pse0053_filial");
    session.removeAttribute("pse0053_dt_inicial");
    session.removeAttribute("pse0053_dt_final");
    session.removeAttribute("pse0053_hora_inicial");
    session.removeAttribute("pse0053_hora_final");
    session.removeAttribute("pse0053_fornecedor");
    session.removeAttribute("pse0053_fen_seq");

    String filial = "";
    String processo = "";
    if (!f.getFil_filial().equals("")) {
      filial = " AND fil_filial = '"+f.getFil_filial() + "'";
    }
    if (!f.getPro_numero().equals("")) {
      processo = " AND a.pro_numero = "+f.getPro_numero();
    }
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT DISTINCT ");
    sb.append("       pck_remessa.get_filial(rem_nro) fil_filial ");
    sb.append("     , for_codigo ");
    sb.append("     , pro_numero ");
    sb.append("  FROM atelier_pre_envio a ");
    if (f.getHora_inicial() != "") {
      sb.append(" WHERE data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sb.append(" WHERE data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sb.append("   AND data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sb.append("   AND data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sb.append("   AND for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sb.append(" AND a.fen_seq = " + f.getSeq_fornec());
    }
    sb.append(filial);
    sb.append(processo);
    sb.append("   AND (('"+f.getTipo() + "' = 'E' AND (a.status = 'E' AND nvl(A.STATUS_CONSISTE_ATELIER,'1') <> 'C'  and a.status_retorno IS NULL ) ) OR ('"+f.getTipo() + "' = 'R' AND nvl(a.status_consiste_atelier,'1') = 'C' and a.status_retorno IS NULL)) ");

    Vector res_Jw_pse0053_forn = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_pse0053_forn",res_Jw_pse0053_forn);

    Jw_pse0053_ref table_ref = new Jw_pse0053_ref();
    StringBuilder sb_ref = new StringBuilder();
    sb_ref.append(" SELECT DISTINCT ");
    sb_ref.append("        a.ref_cdgo ");
    sb_ref.append("      , pck_atelier.get_preco(a.emp_empresa,a.fil_filial,pck_filial.get_unn_codigo(a.fil_filial,a.emp_empresa),a.lin_cdgo,a.ref_cdgo,null,a.pro_numero,a.for_codigo,a.fen_seq) preco ");
    sb_ref.append("   FROM atelier_pre_envio a ");
    if (f.getHora_inicial() != "") {
      sb_ref.append(" WHERE data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sb_ref.append(" WHERE data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sb_ref.append("   AND data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sb_ref.append("   AND data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sb_ref.append("    AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sb_ref.append(" AND a.fen_seq = " + f.getSeq_fornec());
    }
    sb_ref.append(filial);
    sb_ref.append(processo);
    sb_ref.append("    AND (('"+f.getTipo() + "' = 'E' AND (a.status = 'E' AND nvl(A.STATUS_CONSISTE_ATELIER,'1') <> 'C'  and a.status_retorno IS NULL ) ) OR ('"+f.getTipo() + "' = 'R' AND nvl(a.status_consiste_atelier,'1') = 'C' and a.status_retorno IS NULL)) ");
    Vector res_Jw_pse0053_ref = j.select(table_ref, sb_ref.toString(), null);
    session.setAttribute("res_Jw_pse0053_ref",res_Jw_pse0053_ref);


    //----------------- Novas Queries -----------------------------------
    StringBuilder sbf = new StringBuilder();
    sbf.append(" SELECT /*+ all_rows */pro_numero ");
    sbf.append("      , pck_processo_fab.get_nome(pro_numero) pro_nome ");
    sbf.append("      , pares ");
    sbf.append("      , preco ");
    sbf.append("      , pares * preco total ");
    sbf.append("      , fen_seq ");
    sbf.append("   FROM (SELECT a.pro_numero ");
    sbf.append("              , SUM(tal_pares) pares ");
    sbf.append("              , pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq) preco ");
    sbf.append("              , a.fen_seq ");
    sbf.append("           FROM atelier_pre_envio a ");
    sbf.append("          WHERE a.fil_filial = '"+f.getFil_filial() + "' ");
    sbf.append("            AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sbf.append("         AND a.fen_seq = " + f.getSeq_fornec());
    }
    if (f.getHora_inicial() != "") {
      sbf.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sbf.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sbf.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sbf.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sbf.append(processo);
    sbf.append("            AND (('"+f.getTipo() + "' = 'E' AND (a.status = 'E' AND nvl(A.STATUS_CONSISTE_ATELIER,'1') <> 'C'  and a.status_retorno IS NULL )  )) ");
    sbf.append("          GROUP BY a.pro_numero ");
    sbf.append("                 , a.fen_seq ");
    sbf.append("                 , pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq)) ");
    sbf.append(" UNION ");
    sbf.append(" SELECT pro_numero ");
    sbf.append("      , pck_processo_fab.get_nome(pro_numero) pro_nome ");
    sbf.append("      , pares ");
    sbf.append("      , preco ");
    sbf.append("      , pares * preco total ");
    sbf.append("      , fen_seq ");
    sbf.append("   FROM (SELECT a.pro_numero ");
    sbf.append("              , SUM(a.tal_pares) pares ");
    sbf.append("              , ioc.preco_unitario preco ");
    sbf.append("              , a.fen_seq ");
    sbf.append("           FROM atelier_pre_envio a ");
    sbf.append("              , talao t ");
    sbf.append("              , cpr.atelier_rem_taloes_oc art ");
    sbf.append("              , cpr.atelier_rem_talao_item_oc arti ");
    sbf.append("              , cpr.dom_item_ordem_compra ioc ");
    sbf.append("              , cpr.dom_ordem_compra oc ");
    sbf.append("          WHERE a.fil_filial = '"+f.getFil_filial() + "' ");
    sbf.append("            AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sbf.append(" AND a.fen_seq = " + f.getSeq_fornec());
    }
    sbf.append(processo);
    sbf.append("            AND t.rem_nro = a.rem_nro ");
    sbf.append("            AND t.tal_nro = a.tal_nro ");
    if (f.getHora_inicial() != "") {
      sbf.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sbf.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sbf.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sbf.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sbf.append("            AND art.aroc_rem_nro = a.rem_nro ");
    sbf.append("            AND art.tal_nro = a.tal_nro ");
    sbf.append("            AND art.pro_numero = a.pro_numero ");
    sbf.append("            AND arti.oco_numero = art.aroc_oco_numero ");
    sbf.append("            AND arti.rem_nro = art.aroc_rem_nro ");
    sbf.append("            AND arti.tal_nro = art.tal_nro ");
    sbf.append("            AND ioc.oco_numero = arti.oco_numero ");
    sbf.append("            AND ioc.sequencia = arti.ioc_sequencia ");
    sbf.append("            AND oc.numero = ioc.oco_numero ");
    sbf.append("            AND ioc.oco_numero = arti.oco_numero ");
    sbf.append("            AND ioc.sequencia = arti.ioc_sequencia ");
    sbf.append("            AND oc.numero = ioc.oco_numero ");
    sbf.append("            AND ('"+f.getTipo() + "' = 'R' AND nvl(a.status_consiste_atelier,'1') = 'C' and a.status_retorno IS NULL) ");
    sbf.append("          GROUP BY a.pro_numero ");
    sbf.append("                 , a.fen_seq ");
    sbf.append("                 , ioc.preco_unitario) ");
    sbf.append("  ORDER BY pro_numero ");
    sbf.append("         , preco ");



    StringBuilder sba = new StringBuilder();
    sba.append(" SELECT /*+ all_rows */ pro_numero ");
    sba.append("       ,pck_processo_fab.get_nome(pro_numero) pro_nome ");
    sba.append("       ,pck_processo_fab.get_item_estoque(pro_numero) codigo_item ");
    sba.append("       ,pck_item_estoque.get_nome(pck_processo_fab.get_item_estoque(pro_numero)) descricao_produtos ");
    sba.append("       ,linha ");
    sba.append("       ,referencia ");
    sba.append("       ,cabedal ");
    sba.append("       ,preco ");
    sba.append("       ,pares ");
    sba.append("       ,preco * pares total ");
    sba.append("   FROM (SELECT t.pro_numero ");
    sba.append("               ,t.lin_cdgo linha ");
    sba.append("               ,t.ref_cdgo referencia ");
    sba.append("               ,t.cab_cdgo cabedal ");
    sba.append("               ,t.preco ");
    sba.append("               ,tal_pares pares ");
    sba.append("           FROM (SELECT t.emp_empresa ");
    sba.append("                       ,t.fil_filial ");
    sba.append("                       ,t.unn_codigo ");
    sba.append("                       ,t.lin_cdgo ");
    sba.append("                       ,t.ref_cdgo ");
    sba.append("                       ,t.cab_cdgo ");
    sba.append("                       ,t.pro_numero ");
    sba.append("                       ,t.pro_tipo ");
    sba.append("                       ,t.for_codigo ");
    sba.append("                       ,t.fen_seq ");
    sba.append("                       ,t.codigo_cond_pgto ");
    sba.append("                       ,t.preco_unidade preco ");
    sba.append("                       ,MAX(data_ini_validade) data_validade ");
    sba.append("                       ,SUM(ta.tal_pares) tal_pares ");
    sba.append("                   FROM tab_preco_atelier t ");
    sba.append("                       ,atelier_pre_envio a ");
    sba.append("                       ,talao ta ");
    sba.append("                  WHERE a.fil_filial = '"+f.getFil_filial() + "' ");
    sba.append("                    AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sba.append("                 AND a.fen_seq = " + f.getSeq_fornec());
    }
    sba.append(processo);
    if (f.getHora_inicial() != "") {
      sba.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sba.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sba.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sba.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sba.append("                    AND ta.rem_nro = a.rem_nro ");
    sba.append("                    AND ta.tal_nro = a.tal_nro ");
    sba.append("                    AND t.emp_empresa = a.emp_empresa ");
    sba.append("                    AND t.fil_filial = a.fil_filial ");
    sba.append("                    AND t.data_ini_validade = (SELECT MAX(data_ini_validade) ");
    sba.append("                                                FROM tab_preco_atelier ");
    sba.append("                                               WHERE data_ini_validade <= SYSDATE ");
    sba.append("                                                 AND emp_empresa = t.emp_empresa ");
    sba.append("                                                 AND fil_filial = t.fil_filial ");
    sba.append("                                                 AND unn_codigo = t.unn_codigo ");
    sba.append("                                                 AND lin_cdgo = t.lin_cdgo ");
    sba.append("                                                 AND ref_cdgo = t.ref_cdgo ");
    sba.append("                                                 AND cab_cdgo = t.cab_cdgo ");
    sba.append("                                                 AND pro_numero = t.pro_numero ");
    sba.append("                                                 AND pro_tipo = t.pro_tipo ");
    sba.append("                                                 AND for_codigo = t.for_codigo ");
    sba.append("                                                 AND codigo_cond_pgto = t.codigo_cond_pgto ");
    sba.append("                                                 AND status = '1') ");
    sba.append("                      AND ((t.cab_cdgo = ta.cab_cdgo) OR (t.cab_cdgo = 999 AND NOT EXISTS (SELECT NULL ");
    sba.append("                                                                                           FROM tab_preco_atelier pcab ");
    sba.append("                                                                                          WHERE pcab.emp_empresa = t.emp_empresa ");
    sba.append("                                                                                            AND pcab.fil_filial = t.fil_filial ");
    sba.append("                                                                                            AND pcab.unn_codigo = t.unn_codigo ");
    sba.append("                                                                                            AND pcab.pro_numero = t.pro_numero ");
    sba.append("                                                                                            AND pcab.lin_cdgo = t.lin_cdgo ");
    sba.append("                                                                                            AND pcab.ref_cdgo = t.ref_cdgo ");
    sba.append("                                                                                            AND pcab.cab_cdgo = ta.cab_cdgo ");
    sba.append("                                                                                            AND pcab.pro_tipo = t.pro_tipo ");
    sba.append("                                                                                            AND pcab.for_codigo = t.for_codigo ");
    sba.append("                                                                                            AND pcab.fen_seq = t.fen_seq ");
    sba.append("                                                                                            AND pcab.codigo_cond_pgto = t.codigo_cond_pgto ");
    sba.append("                                                                                            AND pcab.data_ini_validade = t.data_ini_validade))) ");
    sba.append("                    AND t.for_codigo = a.for_codigo ");
    sba.append("                    AND t.pro_numero = a.pro_numero ");
    sba.append("                    AND t.lin_cdgo = a.lin_cdgo ");
    sba.append("                    AND t.ref_cdgo = a.ref_cdgo ");
    /*
        sba.append("                    AND NOT EXISTS (SELECT 1 ");
        sba.append("                                      FROM atelier_rem_talao_item_oc art ");
        sba.append("                                         , atelier_rem_taloes_oc arto ");
        sba.append("                                     WHERE art.rem_nro = a.rem_nro ");
        sba.append("                                       AND art.tal_nro = a.tal_nro ");
        sba.append("                                       AND arto.pro_numero = a.pro_numero ");
        sba.append("                                       AND nvl(arto.for_codigo,null) = a.for_codigo ");
        sba.append("                                       AND arto.aroc_oco_numero = art.oco_numero ");
        sba.append("                                       AND arto.aroc_rem_nro = art.rem_nro ");
        sba.append("                                       AND arto.tal_nro = art.tal_nro ) ");
        */
    sba.append("                    AND unn_codigo = pck_filial.get_unn_codigo(t.fil_filial, t.emp_empresa) ");
    sba.append("                    AND (('"+f.getTipo() + "' = 'E' AND (a.status = 'E' AND nvl(A.status_consiste_atelier,'1') <> 'C'  and a.status_retorno IS NULL))) ");
    sba.append("                  GROUP BY t.emp_empresa ");
    sba.append("                          ,t.fil_filial ");
    sba.append("                          ,t.unn_codigo ");
    sba.append("                          ,t.lin_cdgo ");
    sba.append("                          ,t.ref_cdgo ");
    sba.append("                          ,t.cab_cdgo ");
    sba.append("                          ,t.pro_numero ");
    sba.append("                          ,t.pro_tipo ");
    sba.append("                          ,t.preco_unidade ");
    sba.append("                          ,t.for_codigo ");
    sba.append("                          ,t.fen_seq ");
    sba.append("                          ,t.codigo_cond_pgto) t) ");
    sba.append(" UNION ");
    sba.append(" SELECT pro_numero ");
    sba.append("       ,pck_processo_fab.get_nome(pro_numero) pro_nome ");
    sba.append("       ,pck_processo_fab.get_item_estoque(pro_numero) codigo_item ");
    sba.append("       ,pck_item_estoque.get_nome(pck_processo_fab.get_item_estoque(pro_numero)) descricao_produtos ");
    sba.append("       ,linha ");
    sba.append("       ,referencia ");
    sba.append("       ,cabedal ");
    sba.append("       ,preco ");
    sba.append("       ,pares ");
    sba.append("       ,preco * pares total ");
    sba.append("   FROM (SELECT a.pro_numero ");
    sba.append("               ,a.lin_cdgo linha ");
    sba.append("               ,a.ref_cdgo referencia ");
    sba.append("               ,t.cab_cdgo cabedal ");
    sba.append("               ,ioc.preco_unitario preco ");
    sba.append("               ,SUM(a.tal_pares) pares ");
    sba.append("           FROM atelier_pre_envio a ");
    sba.append("               ,talao t ");
    sba.append("               ,cpr.atelier_rem_taloes_oc art ");
    sba.append("               ,cpr.atelier_rem_talao_item_oc arti ");
    sba.append("               ,cpr.dom_item_ordem_compra ioc ");
    sba.append("               ,cpr.dom_ordem_compra oc ");
    sba.append("          WHERE a.fil_filial = '"+f.getFil_filial() + "' ");
    sba.append("            AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sba.append("         AND a.fen_seq = " + f.getSeq_fornec());
    }
    sba.append(processo);
    sba.append("            AND t.rem_nro = a.rem_nro ");
    sba.append("            AND t.tal_nro = a.tal_nro ");
    if (f.getHora_inicial() != "") {
      sba.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sba.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sba.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sba.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sba.append("            AND art.aroc_rem_nro = a.rem_nro ");
    sba.append("            AND art.tal_nro = a.tal_nro ");
    sba.append("            AND art.pro_numero = a.pro_numero ");
    sba.append("            AND arti.oco_numero = art.aroc_oco_numero ");
    sba.append("            AND arti.rem_nro = art.aroc_rem_nro ");
    sba.append("            AND arti.tal_nro = art.tal_nro ");
    sba.append("            AND ioc.oco_numero = arti.oco_numero ");
    sba.append("            AND ioc.sequencia = arti.ioc_sequencia ");
    sba.append("            AND oc.numero = ioc.oco_numero ");
    sba.append("            AND ioc.oco_numero = arti.oco_numero ");
    sba.append("            AND ioc.sequencia = arti.ioc_sequencia ");
    sba.append("            AND oc.numero = ioc.oco_numero ");
    sba.append("            AND ('"+f.getTipo() + "' = 'R' AND nvl(a.status_consiste_atelier,'1') = 'C' and a.status_retorno IS NULL) ");
    sba.append("          GROUP BY a.pro_numero ");
    sba.append("                  ,a.lin_cdgo ");
    sba.append("                  ,a.ref_cdgo ");
    sba.append("                  ,t.cab_cdgo ");
    sba.append("                  ,ioc.preco_unitario) ");
    sba.append("  ORDER BY pro_numero ");
    sba.append("          ,linha ");
    sba.append("          ,referencia ");
    sba.append("          ,cabedal ");



    StringBuilder sbnf = new StringBuilder();
    sbnf.append(" SELECT /*+ all_rows */ pro_numero ");
    sbnf.append("      , pro_nome ");
    sbnf.append("      , fil_filial ");
    sbnf.append("      , nfs_serie ");
    sbnf.append("      , nfs_nmro ");
    sbnf.append("      , (SELECT rowtocol('SELECT DISTINCT o.aroc_rem_nro ");
    sbnf.append("                           FROM atelier_pre_envio a ");
    sbnf.append("                              , cpr.dom_item_ordem_item_requisicao i ");
    sbnf.append("                              , atelier_rem_taloes_oc o ");
    sbnf.append("                              , fat.notas_fiscais_saida_requis n ");
    sbnf.append("                          WHERE a.fil_filial = '''||fil_filial||''' ");
    sbnf.append("                            AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sbnf.append("                         AND a.fen_seq = " + f.getSeq_fornec());
    }
    sbnf.append(processo);
    if (f.getHora_inicial() != "") {
      sbnf.append("   AND a.data_pre_envio >= to_date(''"+f.getDt_inicial() + " "+f.getHora_inicial() + "'',''dd/mm/yyyy hh24:mi'') ");
    } else {
      sbnf.append("   AND a.data_pre_envio >= to_date(''"+f.getDt_inicial() + "'',''dd/mm/yyyy'') ");
    }
    if (f.getHora_final() != "") {
      sbnf.append("   AND a.data_pre_envio < to_date(''"+f.getDt_final() + " "+f.getHora_final() + "'',''dd/mm/yyyy hh24:mi'') + 1 ");
    } else {
      sbnf.append("   AND a.data_pre_envio < to_date(''"+f.getDt_final() + "'',''dd/mm/yyyy'') + 1 ");
    }
    sbnf.append("                            AND a.rem_nro = o.aroc_rem_nro ");
    sbnf.append("                            AND a.tal_nro = o.tal_nro ");
    sbnf.append("                            AND a.pro_numero = o.pro_numero ");
    sbnf.append("                            and n.nfs_nmro = '||nfs_nmro||' ");
    sbnf.append("                            and n.nfs_serie = '||nfs_serie||' ");
    sbnf.append("                            AND a.for_codigo = o.for_codigo ");
    sbnf.append("                            AND o.aroc_oco_numero = i.oco_numero ");
    sbnf.append("                            AND i.reqnf_numero = n.reqnf_numero ");
    sbnf.append("                            AND ((''"+f.getTipo() + "'' = ''E'' AND (a.status = ''E'' AND nvl(A.status_consiste_atelier,''1'') <> ''C'' and a.status_retorno IS NULL)) OR (''"+f.getTipo() + "'' = ''R'' AND nvl(a.status_consiste_atelier,''1'') = ''C'' and a.status_retorno IS NULL))' ) ");
    sbnf.append("                           FROM dual) remessas ");
    sbnf.append("      , oc ");
    sbnf.append("   FROM ( ");
    sbnf.append(" SELECT DISTINCT a.pro_numero ");
    sbnf.append("                ,pck_processo_fab.get_nome(a.pro_numero) pro_nome ");
    sbnf.append("                ,n.fil_filial ");
    sbnf.append("                ,n.nfs_serie ");
    sbnf.append("                ,n.nfs_nmro ");
    sbnf.append("                ,o.aroc_oco_numero oc");
    sbnf.append("   FROM atelier_pre_envio a ");
    sbnf.append("      , cpr.dom_item_ordem_item_requisicao i ");
    sbnf.append("      , atelier_rem_taloes_oc o ");
    sbnf.append("      , fat.notas_fiscais_saida_requis n ");
    sbnf.append("  WHERE a.fil_filial = '"+f.getFil_filial() + "' ");
    sbnf.append("    AND a.for_codigo = ").append(f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      sbnf.append(" AND a.fen_seq = " + f.getSeq_fornec());
    }
    sbnf.append(processo);
    if (f.getHora_inicial() != "") {
      sbnf.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
    } else {
      sbnf.append("   AND a.data_pre_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getHora_final() != "") {
      sbnf.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
    } else {
      sbnf.append("   AND a.data_pre_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
    }
    sbnf.append("    AND a.rem_nro = o.aroc_rem_nro ");
    sbnf.append("    AND a.tal_nro = o.tal_nro ");
    sbnf.append("    AND a.pro_numero = o.pro_numero ");
    sbnf.append("    AND a.for_codigo = o.for_codigo ");
    sbnf.append("    AND o.aroc_oco_numero = i.oco_numero ");
    sbnf.append("    AND i.reqnf_numero = n.reqnf_numero ");
    sbnf.append("    AND (('"+f.getTipo() + "' = 'E' AND (a.status = 'E' AND nvl(A.status_consiste_atelier,'1') <> 'C'  and a.status_retorno IS NULL)) OR ('"+f.getTipo() + "' = 'R' AND nvl(a.status_consiste_atelier,'1') = 'C' and a.status_retorno IS NULL)) ");
    sbnf.append(" ORDER BY pro_numero, fil_filial, nfs_serie, nfs_nmro ) ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      StringBuilder sbq = new StringBuilder();
      sbq.append("*** QUERY FECHADA *** " + sbf.toString());
      sbq.append("*** QUERY ABERTA *** " + sba.toString());
      sbq.append("*** QUERY NOTAS *** " + sbnf.toString());
      throw new Exception(sbq.toString());
    }

    Vector res_Jw_pse0053_total_fechado = j.select(table_fechado, sbf.toString(), null);
    session.setAttribute("res_Jw_pse0053_total_fechado",res_Jw_pse0053_total_fechado);

    if (res_Jw_pse0053_total_fechado != null && res_Jw_pse0053_total_fechado.size() > 0) {
      Jw_pse0053_total_fechado r = (Jw_pse0053_total_fechado) res_Jw_pse0053_total_fechado.elementAt(0);
      session.setAttribute("pse0053_fen_seq", r.getFen_seq());
    }

    Vector res_Jw_pse0053_total_aberto = j.select(table_aberto, sba.toString(), null);
    session.setAttribute("res_Jw_pse0053_total_aberto",res_Jw_pse0053_total_aberto);


    if (f.getTipo().equalsIgnoreCase("E")) {
      session.setAttribute("res_Jw_pse0053_notas_fiscais", null);
    } else {
      Vector res_Jw_pse0053_notas_fiscais = j.select(table_notas_fiscais, sbnf.toString(), null);
      session.setAttribute("res_Jw_pse0053_notas_fiscais",res_Jw_pse0053_notas_fiscais);
    }

    //-------------------------------------------------------------------
    session.setAttribute("pse0053_r_tipo",f.getTipo().equals("E") ? "Envio":"Retorno");
    if (f.getFil_filial() != "") {
      session.setAttribute("pse0053_r_filial",f.getFil_filial() + " - "+f.getFil_razsoc());
    } else {
      session.setAttribute("pse0053_r_filial","Todas");
    }
    session.setAttribute("pse0053_tipo",f.getTipo());
    session.setAttribute("pse0053_filial",f.getFil_filial());
    session.setAttribute("pse0053_dt_inicial",f.getDt_inicial());
    session.setAttribute("pse0053_dt_final",f.getDt_final());

    if (f.getResumo().equalsIgnoreCase("S")) {
      session.setAttribute("pse0053_resumo", true);
    }
    if (f.getHora_inicial() != "") {
      session.setAttribute("pse0053_hora_inicial",f.getHora_inicial());
    }
    if (f.getHora_final() != "") {
      session.setAttribute("pse0053_hora_final",f.getHora_final());
    }
    session.setAttribute("pse0053_fornecedor",f.getFornecedor());
    if (f.getSeq_fornec() != "") {
      session.setAttribute("pse0053_fen_seq", f.getSeq_fornec());
    }

    if (res_Jw_pse0053_forn != null && res_Jw_pse0053_forn.size() > 0) {
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Pse0053ActionForm f = (Pse0053ActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
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
