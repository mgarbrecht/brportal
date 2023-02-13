package portalbr.lov;

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
 * Creation Date 03/12/2019 09:46:11
 * Last Modify Date 09/01/2020 09:08:47
 */

public class LvPedidosIndenizadosDescontosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvPedidosIndenizadosDescontosActionForm f = (LvPedidosIndenizadosDescontosActionForm) form;
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/lov/LvPedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvPedidosIndenizadosDescontosActionForm f = (LvPedidosIndenizadosDescontosActionForm) form;

    if ((!(f.getPed_nmro1() != "")) && (!(f.getNota_fiscal() != ""))) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }

    String notas = null;
    if (f.getNota_fiscal() != "") {

      notas = f.getNota_fiscal().replaceAll("[^0-9]", " ").trim();
      notas = notas.replaceAll("\\s+", " ");
      notas = notas.replaceAll(" ", "\n");
      notas = notas.replaceAll("\\r\\n|\\r|\\n", ",");

      if ((notas.charAt(notas.length() - 1) + "").equalsIgnoreCase(",")) {
        notas = notas.substring(0, notas.lastIndexOf(","));
      }

    }



    Jw_pedidos_indenizados_descontos table = new Jw_pedidos_indenizados_descontos();
    String[][] select = null;
    session.setAttribute("return0", f.getReturn0());

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT DISTINCT ");
    sb.append("        p.ped_nmro ");
    sb.append("      , i.lin_cdgo ");
    sb.append("      , i.ref_cdgo ");
    sb.append("      , i.cab_cdgo ");
    sb.append("      , ca.cab_desc ");
    sb.append("      , i.cor_cdgo ");
    sb.append("      , co.cor_desc ");
    sb.append("      , 0 quantidade ");
    sb.append("      , i.ite_seqn ");
    sb.append("      , i.ite_prco ");
    sb.append("      , p.ped_boni desconto_comercial ");
    sb.append("      , ped_boni2 desconto_promocional ");
    sb.append("      , pck_calculos.subtrai_percentual(ite_prco, (ped_boni+ped_boni2)) ite_prco_descontos ");
    sb.append("   FROM ped p ");
    sb.append("      , ite i ");
    sb.append("      , cabedal ca ");
    sb.append("      , cor co ");
    sb.append("  WHERE p.ped_nmro = i.ped_nmro ");
    sb.append("    AND p.cli_cdgo = " + (String) session.getAttribute("LvPedidosIndenizadosDescontosCliCdgo"));
    //sb.append("    AND p.esc_seqn = " + (String)session.getAttribute("LvPedidosIndenizadosDescontosEscSeqn"));
    sb.append("    AND co.cor_cdgo = i.cor_cdgo ");
    if (f.getPed_nmro1() != "") {
      sb.append(" AND p.ped_nmro = " + f.getPed_nmro1());
    }
    if (notas != null) {
      sb.append(" AND p.ped_nmro IN (SELECT ped_nmro ");
      sb.append("                      FROM notas_fiscais_saida_ped_venda nf ");
      sb.append("                     WHERE nf.nfs_nmro IN (" + notas + ") ");
      if (f.getSerie() != "") {
        sb.append("                    AND nf.nfs_serie = '"+f.getSerie() + "' ");
      }
      sb.append("                       AND nf.ped_nmro = p.ped_nmro) ");
    }
    sb.append("   AND NOT EXISTS (SELECT 1 ");
    sb.append("                     FROM brio.ite_motivo_indenizacao imi ");
    sb.append("                    WHERE imi.ped_nmro = p.ped_nmro  ");
    sb.append("                      AND imi.ite_seqn = i.ite_seqn) ");

    sb.append("    AND ca.cab_cdgo = i.cab_cdgo ");
    sb.append("    AND p.ped_stat = 'F' ");
    sb.append("  ORDER BY ite_seqn ");

    Vector res_Jw_pedidos_indenizados_descontos = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_pedidos_indenizados_descontos",res_Jw_pedidos_indenizados_descontos);
    if (res_Jw_pedidos_indenizados_descontos != null && res_Jw_pedidos_indenizados_descontos.size() > 0) {
      Jw_pedidos_indenizados_descontos r = (Jw_pedidos_indenizados_descontos) res_Jw_pedidos_indenizados_descontos.elementAt(0);
      f.setPed_nmro1((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos_1", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvPedidosIndenizadosDescontosActionForm f = (LvPedidosIndenizadosDescontosActionForm) form;
      session.removeAttribute("res_Jw_pedidos_indenizados_descontos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull1_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      LvPedidosIndenizadosDescontosActionForm f = (LvPedidosIndenizadosDescontosActionForm) form;
      session.removeAttribute("LvPedidosIndenizadosDescontosErros");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvPedidosIndenizadosDescontosActionForm f = (LvPedidosIndenizadosDescontosActionForm) form;
      session.setAttribute("LvPedidosIndenizadosDescontosCliCdgo", f.getCli_cdgo());
      session.setAttribute("LvPedidosIndenizadosDescontosEscSeqn", f.getEsc_seqn());
      session.setAttribute("LvPedidosIndenizadosDescontosPedNmro", f.getPedido());
      session.removeAttribute("res_Jw_pedidos_indenizados_descontos");
      session.removeAttribute("LvPedidosIndenizadosDescontosErros");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvPedidosIndenizadosDescontosActionForm[]_ge_grid_array = (LvPedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
      LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    LvPedidosIndenizadosDescontosActionForm[]_ge_grid_array = (LvPedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
    LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_pedidos_indenizados_descontos table = new Jw_pedidos_indenizados_descontos();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo())}, {"ref_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getRef_cdgo())}, {"cab_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCab_cdgo())}, {"cab_desc","like", f.getCab_desc()}, {"cor_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCor_cdgo())}, {"cor_desc","like", f.getCor_desc()}, {"quantidade","=", com.egen.util.text.FormatNumber.toInteger(f.getQuantidade())} };
      Vector res_Jw_pedidos_indenizados_descontos = (Vector) session.getAttribute("res_Jw_pedidos_indenizados_descontos");

      session.setAttribute("res_Jw_pedidos_indenizados_descontos",res_Jw_pedidos_indenizados_descontos);
      if (res_Jw_pedidos_indenizados_descontos != null && res_Jw_pedidos_indenizados_descontos.size() > 0) {
        LvPedidosIndenizadosDescontosActionForm[]_ge_grid_array_flex = new LvPedidosIndenizadosDescontosActionForm[res_Jw_pedidos_indenizados_descontos.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_pedidos_indenizados_descontos_lines", res_Jw_pedidos_indenizados_descontos.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvPedidosIndenizadosDescontosActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_pedidos_indenizados_descontos.size() > _ge_pos) {
            Jw_pedidos_indenizados_descontos r = (Jw_pedidos_indenizados_descontos) res_Jw_pedidos_indenizados_descontos.elementAt(_ge_pos);
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setIte_seqn((r.getIte_seqn() != null) ? r.getIte_seqn() + "":"");
            f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
            f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
            f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
            f.setCab_desc((r.getCab_desc() != null) ? r.getCab_desc() + "":"");
            f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
            f.setCor_desc((r.getCor_desc() != null) ? r.getCor_desc() + "":"");
            f.setQuantidade((r.getQuantidade() != null) ? r.getQuantidade() + "":"");
            f.setIte_prco((r.getIte_prco() != null) ? r.getIte_prco() + "":"");
            f.setDesconto_comercial((r.getDesconto_comercial() != null) ? r.getDesconto_comercial() + "":"");
            f.setDesconto_promocional((r.getDesconto_promocional() != null) ? r.getDesconto_promocional() + "":"");
            f.setIte_prco_descontos((r.getIte_prco_descontos() != null) ? r.getIte_prco_descontos() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_pedidos_indenizados_descontos_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvPedidosIndenizadosDescontosActionForm[]_ge_grid_array = (LvPedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
      LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_pedidos_indenizados_descontos");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_pedidos_indenizados_descontos_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvPedidosIndenizadosDescontosActionForm[]_ge_grid_array = (LvPedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
      LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    LvPedidosIndenizadosDescontosActionForm[]_ge_grid_array = (LvPedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Jw_pedidos_indenizados_descontos_lines");
    LvPedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
    util.consultas.com.PedidosIndenizadosDescontos pedidosIndenizadosDescontos = new util.consultas.com.PedidosIndenizadosDescontos();
    pedidosIndenizadosDescontos.salvarAlteracoes(j, form, request);
  }

}
