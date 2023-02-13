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
 * Creation Date 30/09/2015 15:51:21
 * Last Modify Date 02/02/2016 12:09:28
 */

public class NecessidadeInsumos_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      NecessidadeInsumos_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
    NecessidadeInsumos_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_dom_ordem_compra table = new Jw_dom_ordem_compra();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      //  Object[][] where = (Object[][])session.getAttribute("where");
      String where = (String) session.getAttribute("where");
      //  Vector res_Jw_dom_ordem_compra = j.select(table, select, where, groupby, having, order);
      Vector res_Jw_dom_ordem_compra = j.select(table, where, null);
      session.setAttribute("res_Jw_dom_ordem_compra",res_Jw_dom_ordem_compra);
      if (res_Jw_dom_ordem_compra != null && res_Jw_dom_ordem_compra.size() > 0) {
        NecessidadeInsumos_rActionForm[]_ge_grid_array_flex = new NecessidadeInsumos_rActionForm[res_Jw_dom_ordem_compra.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_dom_ordem_compra_lines", res_Jw_dom_ordem_compra.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new NecessidadeInsumos_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_dom_ordem_compra.size() > _ge_pos) {
            Jw_dom_ordem_compra r = (Jw_dom_ordem_compra) res_Jw_dom_ordem_compra.elementAt(_ge_pos);
            f.setNumero((r.getNumero() != null) ? r.getNumero() + "":"");
            f.setData_compra(com.egen.util.text.FormatDate.format(r.getData_compra()));
            f.setEmp_empresa((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
            f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setUnn_codigo((r.getUnn_codigo() != null) ? r.getUnn_codigo() + "":"");
            f.setForn_codigo((r.getForn_codigo() != null) ? r.getForn_codigo() + "":"");
            f.setForn_razsoc((r.getForn_razsoc() != null) ? r.getForn_razsoc() + "":"");
            f.setFen_seq((r.getFen_seq() != null) ? r.getFen_seq() + "":"");
            f.setCpg_codigo((r.getCpg_codigo() != null) ? r.getCpg_codigo() + "":"");
            f.setCom_codigo((r.getCom_codigo() != null) ? r.getCom_codigo() + "":"");
            f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
            f.setTra_cdgo((r.getTra_cdgo() != null) ? r.getTra_cdgo() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_dom_ordem_compra_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("warn.norowsselected",""));
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
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      NecessidadeInsumos_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_dom_ordem_compra");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_dom_ordem_compra_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      NecessidadeInsumos_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      if (_ge_grid_array != null) {
        NecessidadeInsumos_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(true);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      NecessidadeInsumos_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      if (_ge_grid_array != null) {
        NecessidadeInsumos_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      NecessidadeInsumos_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/NecessidadeInsumosForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_gerar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      NecessidadeInsumos_rActionForm[]_ge_grid_array = (NecessidadeInsumos_rActionForm[])_ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
      NecessidadeInsumos_rActionForm f = _ge_grid_array[0];
      gerar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void gerar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    util.consultas.com.NecessidadeInsumos necessidadeInsumos = new util.consultas.com.NecessidadeInsumos();
    necessidadeInsumos.gerar(form, request);
  }



}
