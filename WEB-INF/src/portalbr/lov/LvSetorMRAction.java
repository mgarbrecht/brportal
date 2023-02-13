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
 * Creation Date 28/05/2014 13:59:07
 * Last Modify Date 28/05/2014 15:22:34
 */

public class LvSetorMRAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
      LvSetorMRActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
        tg_select_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Setor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
    LvSetorMRActionForm f = _ge_grid_array[0];
    if (f != null) {
      Setor table = new Setor();
      String[][] select = null;
      String[] order = {"set_nome"};
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"set_cdgo","like", f.getSet_cdgo()}, {"set_nome","like", f.getSet_nome()}, };
      Vector res_Setor = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Setor",res_Setor);
      if (res_Setor != null && res_Setor.size() > 0) {
        LvSetorMRActionForm[]_ge_grid_array_flex = new LvSetorMRActionForm[res_Setor.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Setor_lines", res_Setor.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvSetorMRActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Setor.size() > _ge_pos) {
            Setor r = (Setor) res_Setor.elementAt(_ge_pos);
            f.setSet_cdgo((r.getSet_cdgo() != null) ? r.getSet_cdgo() + "":"");
            f.setSet_nome((r.getSet_nome() != null) ? r.getSet_nome() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Setor_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Setor", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
      if (_ge_grid_array != null) {
        LvSetorMRActionForm f = null;
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

  public ActionForward perform_selecionar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
      LvSetorMRActionForm f = _ge_grid_array[0];
      try {
        selecionar_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Setor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
    LvSetorMRActionForm f = _ge_grid_array[0];
    java.util.List < String > listaSetores = new java.util.ArrayList();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        listaSetores.add(f.getSet_cdgo());
      }
    }
    if (listaSetores.size() > 0) {
      session.setAttribute("listaSetores", listaSetores);
      session.setAttribute("setouSetores", "ok");
    } else {
      session.removeAttribute("listaSetores");
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
      LvSetorMRActionForm f = _ge_grid_array[0];


      try {
        tg_resetfull_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Setor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSetorMRActionForm[]_ge_grid_array = (LvSetorMRActionForm[])_ge_grid.get("bl_form_Setor_lines");
      if (_ge_grid_array != null) {
        LvSetorMRActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute("LvSetorMRActionForm",form);
    } catch (Exception e) {
      throw e;
    }
  }

}
