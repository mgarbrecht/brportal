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
 * Creation Date 12/09/2013 08:46:26
 * Last Modify Date 14/06/2019 11:45:07
 */

public class LvIteSituAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
      LvIteSituActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cg_ref_codes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
    LvIteSituActionForm f = _ge_grid_array[0];
    if (f != null) {
      Cg_ref_codes table = new Cg_ref_codes();
      String[][] select = null;
      String[] order = {"RV_LOW_VALUE"};
      String[] groupby = null;
      String[] having = null;
      Object[][] where = {{"RV_DOMAIN","=", "ITE_SITU"}, {"rv_low_value","like", f.getRv_low_value()}, {"rv_meaning","like", f.getRv_meaning()} };
      Vector res_Cg_ref_codes = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Cg_ref_codes",res_Cg_ref_codes);
      if (res_Cg_ref_codes != null && res_Cg_ref_codes.size() > 0) {
        LvIteSituActionForm[]_ge_grid_array_flex = new LvIteSituActionForm[res_Cg_ref_codes.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Cg_ref_codes_lines", res_Cg_ref_codes.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvIteSituActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Cg_ref_codes.size() > _ge_pos) {
            Cg_ref_codes r = (Cg_ref_codes) res_Cg_ref_codes.elementAt(_ge_pos);
            f.setRv_low_value((r.getRv_low_value() != null) ? r.getRv_low_value() + "":"");
            f.setRv_meaning((r.getRv_meaning() != null) ? r.getRv_meaning() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Cg_ref_codes_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cg_ref_codes", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_selecionar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
      LvIteSituActionForm f = _ge_grid_array[0];
      selecionar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cg_ref_codes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void selecionar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
    LvIteSituActionForm f = _ge_grid_array[0];
    java.util.Vector listaSituacoes = new java.util.Vector();
    session.removeAttribute("listaSituacoes");
    boolean marcou = false;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        marcou = true;
        listaSituacoes.add(f.getRv_low_value() + "-"+f.getRv_meaning());
      }
    }
    if (marcou) {
      session.setAttribute("listaSituacoes",listaSituacoes);
    }
    request.setAttribute("ite_situ","s");
  }
  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
      LvIteSituActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cg_ref_codes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
      if (_ge_grid_array != null) {
        LvIteSituActionForm f = null;
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
      LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
      LvIteSituActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cg_ref_codes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvIteSituActionForm[]_ge_grid_array = (LvIteSituActionForm[])_ge_grid.get("bl_form_Cg_ref_codes_lines");
      if (_ge_grid_array != null) {
        LvIteSituActionForm f = null;
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
}
