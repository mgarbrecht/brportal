package portalbr.acesso;

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
 * Creation Date 01/04/2008 07:30:01
 * Last Modify Date 01/08/2014 12:33:00
 */

public class ParametrosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_pos1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos1";
        String _lines_name = "bl_form_Parametros_1_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos1_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos1_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
    ParametrosActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
      f = _ge_grid_array[_ge_grid_array_index];
      Vector res_Parametros = (Vector) session.getAttribute("res_Parametros");
      if (res_Parametros != null && _ge_pos < res_Parametros.size()) {
        Parametros r = (Parametros) res_Parametros.elementAt(_ge_pos);
        f.setNome1((r.getNome() != null) ? r.getNome() + "":"");
        f.setValor1((r.getValor() != null) ? r.getValor() + "":"");
        f.setPar_sist_codigo((r.getPar_sist_codigo() != null) ? r.getPar_sist_codigo() + "":"");
        f.setPos1("" + _ge_pos);
      } else {
        f.reset(mapping, request);
      }
      f.setGridCheckField(false);
      _ge_grid_array[_ge_grid_array_index] = f;
      session.setAttribute("pos1", "" + _ge_pos);
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
      ParametrosActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
    ParametrosActionForm f = _ge_grid_array[0];
    if (f != null) {
      Parametros table = new Parametros();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"nome","like", f.getNome1()}, {"valor","like", f.getValor1()}, {"par_sist_codigo","like", f.getPar_sist_codigo()}, };
      Vector res_Parametros = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Parametros",res_Parametros);
      if (res_Parametros != null && res_Parametros.size() > 0) {
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.reset(mapping, request);
          if (res_Parametros.size() > _ge_pos) {
            Parametros r = (Parametros) res_Parametros.elementAt(_ge_pos);
            f.setNome1((r.getNome() != null) ? r.getNome() + "":"");
            f.setValor1((r.getValor() != null) ? r.getValor() + "":"");
            f.setPar_sist_codigo((r.getPar_sist_codigo() != null) ? r.getPar_sist_codigo() + "":"");
            f.setPos1("" + _ge_pos);
          }
          _ge_grid_array[_ge_grid_array_index] = f;
        }
        session.setAttribute("pos1", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_insert1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
      ParametrosActionForm f = _ge_grid_array[0];
      try {
        insert1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
    ParametrosActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        Parametros table = new Parametros();
        Object[][] name_value = { {"nome",f.getNome1()}, {"valor",f.getValor1()}, {"par_sist_codigo",f.getPar_sist_codigo()}, };
        j.insert(table, name_value);
        Vector res_Parametros = (Vector) session.getAttribute("res_Parametros");
        if (res_Parametros != null && table != null) {
          res_Parametros.addElement(table);
          session.setAttribute("res_Parametros", res_Parametros);
        }
      }
    }
  }

  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
      ParametrosActionForm f = _ge_grid_array[0];
      try {
        update1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
    ParametrosActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        Parametros table = new Parametros();
        Vector sets = new Vector(10, 2);
        table.setNome(f.getNome1());
        if (f.getNome1() != null) {
          sets.addElement("nome");
        }
        table.setValor(f.getValor1());
        if (f.getValor1() != null) {
          sets.addElement("valor");
        }
        table.setPar_sist_codigo(f.getPar_sist_codigo());
        if (f.getPar_sist_codigo() != null) {
          sets.addElement("par_sist_codigo");
        }
        if (sets != null && sets.size() > 0) {
          String[] set = new String[sets.size()];
          for (int i = 0; i < sets.size(); i++) {
            set[i] = (String) sets.elementAt(i);
          }
          int updated = j.update(table, set);
          String _pos_field_name = "pos1";
          String _lines_name = "bl_form_Parametros_1_lines";
          String action = null;
          int _ge_pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, f, request);
          if (updated == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("warn.norowsupdated",": " + updated));
            request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
          } else {
            Vector res_Parametros = (Vector) session.getAttribute("res_Parametros");
            if (res_Parametros != null) {
              res_Parametros.setElementAt(table, _ge_pos);
              Parametros r = (Parametros) res_Parametros.elementAt(_ge_pos);
              f.setNome1((r.getNome() != null) ? r.getNome() + "":"");
              f.setValor1((r.getValor() != null) ? r.getValor() + "":"");
              f.setPar_sist_codigo((r.getPar_sist_codigo() != null) ? r.getPar_sist_codigo() + "":"");
            }
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }

  public ActionForward perform_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ParametrosActionForm[]_ge_grid_array = (ParametrosActionForm[])_ge_grid.get("bl_form_Parametros_1_lines");
      ParametrosActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Parametros");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Parametros_1_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos1","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
