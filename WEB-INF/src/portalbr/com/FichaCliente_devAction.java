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
 * Creation Date 27/03/2013 08:58:11
 * Last Modify Date 11/04/2013 15:09:49
 */

public class FichaCliente_devAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaCliente_devActionForm f = (FichaCliente_devActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_cliente_devolucoes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichaCliente_devActionForm f = (FichaCliente_devActionForm) form;
    Jw_ficha_cliente_devolucoes table = new Jw_ficha_cliente_devolucoes();
    acesso.Sessao sessao = new acesso.Sessao(session);
    boolean temRestricao = false;

    StringBuilder parametros = new StringBuilder();
    if ((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) || (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))) {
      temRestricao = true;
    }
    if (temRestricao) {
      parametros.append("  AND EXISTS (SELECT 1 ");
      parametros.append("                FROM rep r ");
      parametros.append("                   , cliente_representante cr ");
      parametros.append("                   , analistas_regionais a ");
      parametros.append("               WHERE rep_situ = 'A' ");
      parametros.append("                 AND cr.situacao = 'A' ");
      parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
      parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");
      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        parametros.append("              AND r.codigo_regional = " + sessao.getChave());
        parametros.append("              AND r.rep_cdgo = d.rep_cdgo ");
      }
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        parametros.append("              AND r.rep_cdgo = '"+sessao.getChave() + "' ");
        parametros.append("              AND r.rep_cdgo = d.rep_cdgo ");
      }
      if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
        parametros.append("              AND a.codigo_gerente = '"+sessao.getChave() + "' ");
        parametros.append("              AND r.rep_cdgo = d.rep_cdgo ");
      }
      parametros.append("                 AND cr.codigo_cliente = ns.cli_cdgo ");
      parametros.append("                 AND cr.codigo_sequencial = ns.esc_seqn) ");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT ROWNUM ordem ");
    sb.append("       ,data_cad ");
    sb.append("       ,nfs_nmro ");
    sb.append("       ,pares ");
    sb.append("       ,valor ");
    sb.append("   FROM (SELECT dm.data_cad ");
    sb.append("               ,ns.nfs_nmro ");
    sb.append("               ,SUM(idv.total_pares) pares ");
    sb.append("               ,SUM(idv.valor_total) valor ");
    sb.append("           FROM devolucoes_mercadorias dm ");
    sb.append("               ,itens_devolucoes idv ");
    sb.append("               ,nf_item ni ");
    sb.append("               ,nf_saida ns ");
    sb.append("          WHERE dm.data_cad >= trunc(SYSDATE,'yyyy') ");
    sb.append("            AND dm.data_cad <= TRUNC(add_months(SYSDATE,12),'yyyy')-1 ");
    sb.append("            AND ns.emp_empresa = ni.emp_empresa ");
    sb.append("            AND ns.fil_filial = ni.fil_filial ");
    sb.append("            AND ns.nfs_nmro = ni.nfs_nmro ");
    sb.append("            AND ns.nfs_serie = ni.nfs_serie ");
    sb.append("            AND ni.emp_empresa = dm.nfs_emp_empresa ");
    sb.append("            AND ni.fil_filial = dm.nfs_fil_filial ");
    sb.append(parametros.toString());


    if (session.getAttribute("cli_cdgo") != null) {
      sb.append("           and nvl(ns.cli_cdgo,NULL) = " + (String) session.getAttribute("cli_cdgo"));
      sb.append("           and nvl(ns.esc_seqn,NULL) = " + (String) session.getAttribute("esc_seqn"));
    } else {
      sb.append("          AND EXISTS (SELECT 1 ");
      sb.append("                        FROM grupo_economico gre  ");
      sb.append("                       WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
      sb.append("                         AND NVL(gre.status, NULL) = 'A' ");
      sb.append("                         AND gre.cli_cdgo = ns.cli_cdgo ) ");
    }

    sb.append("            AND ni.nfs_nmro = dm.nfs_numero ");
    sb.append("            AND ni.nfs_serie = dm.nfs_serie ");
    sb.append("            AND ni.nfi_seqitem = idv.nfi_seqitem ");
    sb.append("            AND dm.codigo = idv.devmerc_codigo ");
    sb.append("            AND ((dm.motdev_codigo <> 85) AND (dm.motdev_codigo <> 54 AND dm.sitdev_codigo <> 2)) ");
    sb.append("            AND NOT EXISTS (SELECT * ");
    sb.append("                               FROM nf_refat_dev nrd ");
    sb.append("                              WHERE nrd.emp_empresa = dm.nfs_emp_empresa ");
    sb.append("                                AND nrd.fil_filial = dm.nfs_fil_filial ");
    sb.append("                                AND nrd.nfs_nmro = dm.nfs_numero ");
    sb.append("                                AND nrd.nfs_serie = dm.nfs_serie ");
    sb.append("                                AND CASE WHEN nrd.tipo_refaturamento = pck_nf_refat_dev.get_refaturamento AND nrd.cli_cdgo <> dm.cli_cdgo THEN 0 ELSE 1 END = 1 ");
    sb.append("                                AND nrd.estagio <> pck_nf_refat_dev.get_estagio_cancelado) ");
    sb.append("            AND NOT EXISTS (SELECT * ");
    sb.append("                   FROM ite ite ");
    sb.append("                       ,ped ped ");
    sb.append("                  WHERE ite.emp_empresa_refat = dm.nfs_emp_empresa ");
    sb.append("                    AND ite.fil_filial_refat = dm.nfs_fil_filial ");
    sb.append("                    AND ite.nfs_nmro_refat = dm.nfs_numero ");
    sb.append("                    AND ite.nfs_serie_refat = dm.nfs_serie ");
    sb.append("                    AND ite.ped_nmro = ped.ped_nmro ");
    sb.append("                    AND CASE WHEN ped.cli_cdgo <> dm.cli_cdgo THEN 0 ELSE 1 END = 1 ");
    sb.append("                    AND ped.ped_stat <> 'C' ) ");
    sb.append("          GROUP BY dm.data_cad ");
    sb.append("                  ,ns.nfs_nmro ");
    sb.append("          ORDER BY dm.data_cad DESC) ");


    Vector res_Jw_ficha_cliente_devolucoes = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_ficha_cliente_devolucoes_dev",res_Jw_ficha_cliente_devolucoes);
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaCliente_devActionForm f = (FichaCliente_devActionForm) form;
      select1_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_cliente_devolucoes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    FichaCliente_devActionForm f = (FichaCliente_devActionForm) form;
    Jw_ficha_cliente_devolucoes table = new Jw_ficha_cliente_devolucoes();
    acesso.Sessao sessao = new acesso.Sessao(session);
    boolean temRestricao = false;

    StringBuilder parametros = new StringBuilder();
    if ((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) || (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))) {
      temRestricao = true;
    }
    if (temRestricao) {
      parametros.append("  AND EXISTS (SELECT 1 ");
      parametros.append("                FROM rep r ");
      parametros.append("                   , cliente_representante cr ");
      parametros.append("                   , analistas_regionais a ");
      parametros.append("               WHERE rep_situ = 'A' ");
      parametros.append("                 AND cr.situacao = 'A' ");
      parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
      parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");
      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        parametros.append("              AND r.codigo_regional = " + sessao.getChave());
        parametros.append("              AND r.rep_cdgo = d.rep_cdgo ");
      }
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        parametros.append("              AND r.rep_cdgo = '"+sessao.getChave() + "' ");
        parametros.append("              AND r.rep_cdgo = d.rep_cdgo ");
      }
      if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
        parametros.append("              AND a.codigo_gerente = '"+sessao.getChave() + "' ");
        parametros.append("              AND r.rep_cdgo = d.rep_cdgo ");
      }
      parametros.append("                 AND cr.codigo_cliente = ns.cli_cdgo ");
      parametros.append("                 AND cr.codigo_sequencial = ns.esc_seqn) ");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT ROWNUM ordem ");
    sb.append("       ,data_cad ");
    sb.append("       ,nfs_nmro ");
    sb.append("       ,pares ");
    sb.append("       ,valor ");
    sb.append("   FROM (SELECT dm.data_cad ");
    sb.append("               ,ns.nfs_nmro ");
    sb.append("               ,SUM(idv.total_pares) pares ");
    sb.append("               ,SUM(idv.valor_total) valor ");
    sb.append("           FROM devolucoes_mercadorias dm ");
    sb.append("               ,itens_devolucoes idv ");
    sb.append("               ,nf_item ni ");
    sb.append("               ,nf_saida ns ");
    sb.append("          WHERE dm.data_cad >= trunc(add_months(SYSDATE,'-12'),'yyyy') ");
    sb.append("            AND dm.data_cad <= TRUNC(SYSDATE,'yyyy')-1 ");
    sb.append("            AND ns.emp_empresa = ni.emp_empresa ");
    sb.append("            AND ns.fil_filial = ni.fil_filial ");
    sb.append("            AND ns.nfs_nmro = ni.nfs_nmro ");
    sb.append("            AND ns.nfs_serie = ni.nfs_serie ");
    sb.append("            AND ni.emp_empresa = dm.nfs_emp_empresa ");
    sb.append("            AND ni.fil_filial = dm.nfs_fil_filial ");
    sb.append(parametros.toString());


    if (session.getAttribute("cli_cdgo") != null) {
      sb.append("           and nvl(ns.cli_cdgo,NULL) = " + (String) session.getAttribute("cli_cdgo"));
      sb.append("           and nvl(ns.esc_seqn,NULL) = " + (String) session.getAttribute("esc_seqn"));
    } else {
      sb.append("          AND EXISTS (SELECT 1 ");
      sb.append("                        FROM grupo_economico gre  ");
      sb.append("                       WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
      sb.append("                         AND NVL(gre.status, NULL) = 'A' ");
      sb.append("                         AND gre.cli_cdgo = ns.cli_cdgo ) ");
    }

    sb.append("            AND ni.nfs_nmro = dm.nfs_numero ");
    sb.append("            AND ni.nfs_serie = dm.nfs_serie ");
    sb.append("            AND ni.nfi_seqitem = idv.nfi_seqitem ");
    sb.append("            AND dm.codigo = idv.devmerc_codigo ");
    sb.append("            AND ((dm.motdev_codigo <> 85) AND (dm.motdev_codigo <> 54 AND dm.sitdev_codigo <> 2)) ");
    sb.append("            AND NOT EXISTS (SELECT * ");
    sb.append("                               FROM nf_refat_dev nrd ");
    sb.append("                              WHERE nrd.emp_empresa = dm.nfs_emp_empresa ");
    sb.append("                                AND nrd.fil_filial = dm.nfs_fil_filial ");
    sb.append("                                AND nrd.nfs_nmro = dm.nfs_numero ");
    sb.append("                                AND nrd.nfs_serie = dm.nfs_serie ");
    sb.append("                                AND CASE WHEN nrd.tipo_refaturamento = pck_nf_refat_dev.get_refaturamento AND nrd.cli_cdgo <> dm.cli_cdgo THEN 0 ELSE 1 END = 1 ");
    sb.append("                                AND nrd.estagio <> pck_nf_refat_dev.get_estagio_cancelado) ");
    sb.append("            AND NOT EXISTS (SELECT * ");
    sb.append("                   FROM ite ite ");
    sb.append("                       ,ped ped ");
    sb.append("                  WHERE ite.emp_empresa_refat = dm.nfs_emp_empresa ");
    sb.append("                    AND ite.fil_filial_refat = dm.nfs_fil_filial ");
    sb.append("                    AND ite.nfs_nmro_refat = dm.nfs_numero ");
    sb.append("                    AND ite.nfs_serie_refat = dm.nfs_serie ");
    sb.append("                    AND ite.ped_nmro = ped.ped_nmro ");
    sb.append("                    AND CASE WHEN ped.cli_cdgo <> dm.cli_cdgo THEN 0 ELSE 1 END = 1 ");
    sb.append("                    AND ped.ped_stat <> 'C' ) ");
    sb.append("          GROUP BY dm.data_cad ");
    sb.append("                  ,ns.nfs_nmro ");
    sb.append("          ORDER BY dm.data_cad DESC) ");

    Vector res_Jw_ficha_cliente_devolucoes = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_ficha_cliente_devolucoes_dev",res_Jw_ficha_cliente_devolucoes);
    session.setAttribute(mapping.getName(), form);
  }
}
