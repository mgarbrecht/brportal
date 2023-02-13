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
 * Creation Date 31/10/2011 11:09:37
 * Last Modify Date 31/10/2011 12:05:26
 */

public class DispositivosMoveis_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DispositivosMoveis_rActionForm[]_ge_grid_array = (DispositivosMoveis_rActionForm[])_ge_grid.get("bl_form_Usuarios_sistema_afv_lines");
      DispositivosMoveis_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DispositivosMoveis_rActionForm[]_ge_grid_array = (DispositivosMoveis_rActionForm[])_ge_grid.get("bl_form_Usuarios_sistema_afv_lines");
    DispositivosMoveis_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Usuarios_sistema_afv table = new Usuarios_sistema_afv();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = (Object[][]) session.getAttribute("where");
      Vector res_Usuarios_sistema_afv = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Usuarios_sistema_afv",res_Usuarios_sistema_afv);
      if (res_Usuarios_sistema_afv != null && res_Usuarios_sistema_afv.size() > 0) {
        DispositivosMoveis_rActionForm[]_ge_grid_array_flex = new DispositivosMoveis_rActionForm[res_Usuarios_sistema_afv.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Usuarios_sistema_afv_lines", res_Usuarios_sistema_afv.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new DispositivosMoveis_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Usuarios_sistema_afv.size() > _ge_pos) {
            Usuarios_sistema_afv r = (Usuarios_sistema_afv) res_Usuarios_sistema_afv.elementAt(_ge_pos);
            f.setCodigo_usuario((r.getCodigo_usuario() != null) ? r.getCodigo_usuario() + "":"");
            f.setNome_usuario((r.getNome_usuario() != null) ? r.getNome_usuario() + "":"");
            f.setId_tablet((r.getId_tablet() != null) ? r.getId_tablet() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Usuarios_sistema_afv_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DispositivosMoveis_rActionForm[]_ge_grid_array = (DispositivosMoveis_rActionForm[])_ge_grid.get("bl_form_Usuarios_sistema_afv_lines");
      DispositivosMoveis_rActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DispositivosMoveis_rActionForm[]_ge_grid_array = (DispositivosMoveis_rActionForm[])_ge_grid.get("bl_form_Usuarios_sistema_afv_lines");
    DispositivosMoveis_rActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (true) {
        Usuarios_sistema_afv table = new Usuarios_sistema_afv();
        Vector sets = new Vector(10, 2);
        table.setCodigo_usuario(f.getCodigo_usuario());
        if (f.getCodigo_usuario() != null) {
          sets.addElement("codigo_usuario");
        }
        table.setNome_usuario(f.getNome_usuario());
        if (f.getNome_usuario() != null) {
          sets.addElement("nome_usuario");
        }
        table.setId_tablet(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId_tablet()));
        if (f.getId_tablet() != null) {
          sets.addElement("id_tablet");
        }
        if (sets != null && sets.size() > 0) {
          String[] set = new String[sets.size()];
          for (int i = 0; i < sets.size(); i++) {
            set[i] = (String) sets.elementAt(i);
          }
          int updated = j.update(table, set);
          if (updated == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("warn.norowsupdated",": " + updated));
            request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
          } else {
            Vector res_Usuarios_sistema_afv = (Vector) session.getAttribute("res_Usuarios_sistema_afv");
            if (res_Usuarios_sistema_afv != null) {
              res_Usuarios_sistema_afv.setElementAt(table, 0);
              Usuarios_sistema_afv r = (Usuarios_sistema_afv) res_Usuarios_sistema_afv.elementAt(0);
              f.setCodigo_usuario((r.getCodigo_usuario() != null) ? r.getCodigo_usuario() + "":"");
              f.setNome_usuario((r.getNome_usuario() != null) ? r.getNome_usuario() + "":"");
              f.setId_tablet((r.getId_tablet() != null) ? r.getId_tablet() + "":"");
            }
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      DispositivosMoveis_rActionForm[]_ge_grid_array = (DispositivosMoveis_rActionForm[])_ge_grid.get("bl_form_Usuarios_sistema_afv_lines");
      DispositivosMoveis_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Usuarios_sistema_afv");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Usuarios_sistema_afv_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = new ActionForward("/com/DispositivosMoveisForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
