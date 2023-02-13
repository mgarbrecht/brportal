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
 * Creation Date 22/08/2006 09:57:01
 * Last Modify Date 21/08/2013 11:43:15
 */

public class ClientesGruposAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      String cli = "";
      java.util.Vector vetor = new java.util.Vector();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ClientesGruposActionForm[]_ge_grid_array = (ClientesGruposActionForm[])_ge_grid.get("bl_form_Jw_clientes_grupos_economicos_lines");
      if (_ge_grid_array != null) {
        ClientesGruposActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];

          if (f.getGridCheckField() == true) {
            if (cli.equals("")) {
              vetor.addElement(f.getCli_cdgo() + "-"+f.getCli_rzao());
              cli = "x"+f.getCli_cdgo() + "x";
            } else {
              vetor.addElement(f.getCli_cdgo() + "-"+f.getCli_rzao());
              cli += ",x"+f.getCli_cdgo() + "x";
            }

          }
        }
        f = _ge_grid_array[0];
      }
      session.setAttribute("clientes_grupo",vetor);
      request.setAttribute("clientes",cli);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ClientesGruposActionForm[]_ge_grid_array = (ClientesGruposActionForm[])_ge_grid.get("bl_form_Jw_clientes_grupos_economicos_lines");
    ClientesGruposActionForm f = _ge_grid_array[0];
    if (f != null) {
      portalbr.dbobj.view.Jw_clientes_grupos_economicos table = new portalbr.dbobj.view.Jw_clientes_grupos_economicos();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"Gre_grupo","like", (String) request.getParameter("gre_grupo")}};
      Vector res_Jw_clientes_grupos_economicos = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_clientes_grupos_economicos",res_Jw_clientes_grupos_economicos);
      if (res_Jw_clientes_grupos_economicos != null && res_Jw_clientes_grupos_economicos.size() > 0) {
        ClientesGruposActionForm[]_ge_grid_array_flex = new ClientesGruposActionForm[res_Jw_clientes_grupos_economicos.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_clientes_grupos_economicos_lines", res_Jw_clientes_grupos_economicos.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ClientesGruposActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_clientes_grupos_economicos.size() > _ge_pos) {
            portalbr.dbobj.view.Jw_clientes_grupos_economicos r = (portalbr.dbobj.view.Jw_clientes_grupos_economicos) res_Jw_clientes_grupos_economicos.elementAt(_ge_pos);
            f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
            f.setGre_descricao((r.getGre_descricao() != null) ? r.getGre_descricao() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setCli_nome((r.getCli_nome() != null) ? r.getCli_nome() + "":"");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setCli_situ((r.getCli_situ() != null) ? r.getCli_situ() + "":"");
            f.setGridCheckField(true);
            f.setPos("" + _ge_pos);
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_clientes_grupos_economicos_lines", _ge_grid_array_flex);
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("warn.norowsselected",""));
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
      ClientesGruposActionForm[]_ge_grid_array = (ClientesGruposActionForm[])_ge_grid.get("bl_form_Jw_clientes_grupos_economicos_lines");
      ClientesGruposActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_clientes_grupos_economicos");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_clientes_grupos_economicos_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_pos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos";
        String _lines_name = "bl_form_Jw_clientes_grupos_economicos_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ClientesGruposActionForm[]_ge_grid_array = (ClientesGruposActionForm[])_ge_grid.get("bl_form_Jw_clientes_grupos_economicos_lines");
    ClientesGruposActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
      f = _ge_grid_array[_ge_grid_array_index];
      Vector res_Jw_clientes_grupos_economicos = (Vector) session.getAttribute("res_Jw_clientes_grupos_economicos");
      if (res_Jw_clientes_grupos_economicos != null && _ge_pos < res_Jw_clientes_grupos_economicos.size()) {
        portalbr.dbobj.view.Jw_clientes_grupos_economicos r = (portalbr.dbobj.view.Jw_clientes_grupos_economicos) res_Jw_clientes_grupos_economicos.elementAt(_ge_pos);
        f.setPos("" + _ge_pos);
      } else {
        f.reset(mapping, request);
      }
      f.setGridCheckField(false);
      _ge_grid_array[_ge_grid_array_index] = f;
      session.setAttribute("pos", "" + _ge_pos);
      session.setAttribute(mapping.getName(), form);
    }
  }

}
