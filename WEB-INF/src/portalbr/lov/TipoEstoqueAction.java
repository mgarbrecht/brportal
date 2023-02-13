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
 * Creation Date 24/11/2009 08:40:36
 * Last Modify Date 30/11/2009 10:36:55
 */

public class TipoEstoqueAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      String cli = "";
      java.util.Vector vetor = new java.util.Vector();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      TipoEstoqueActionForm[]_ge_grid_array = (TipoEstoqueActionForm[])_ge_grid.get("bl_form_Jw_tipoestoque_lines");
      if (_ge_grid_array != null) {
        TipoEstoqueActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];

          if (f.getGridCheckField() == true) {
            if (cli.equals("")) {
              vetor.addElement(f.getCodigo() + "-"+f.getDescricao());
              cli = "x"+f.getCodigo() + "x";
            } else {
              vetor.addElement(f.getCodigo() + "-"+f.getDescricao());
              cli += ",x"+f.getCodigo() + "x";
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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipoestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      TipoEstoqueActionForm[]_ge_grid_array = (TipoEstoqueActionForm[])_ge_grid.get("bl_form_Jw_tipoestoque_lines");
      TipoEstoqueActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipoestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    TipoEstoqueActionForm[]_ge_grid_array = (TipoEstoqueActionForm[])_ge_grid.get("bl_form_Jw_tipoestoque_lines");
    TipoEstoqueActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_tipoestoque table = new Jw_tipoestoque();
      String[][] select = null;
      String[] order = {"descricao"};
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"CODIGO","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo())}, {"DESCRICAO","like", f.getDescricao()}, };
      Vector res_Jw_tipoestoque = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_tipoestoque",res_Jw_tipoestoque);
      if (res_Jw_tipoestoque != null && res_Jw_tipoestoque.size() > 0) {
        TipoEstoqueActionForm[]_ge_grid_array_flex = new TipoEstoqueActionForm[res_Jw_tipoestoque.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_tipoestoque_lines", res_Jw_tipoestoque.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new TipoEstoqueActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_tipoestoque.size() > _ge_pos) {
            Jw_tipoestoque r = (Jw_tipoestoque) res_Jw_tipoestoque.elementAt(_ge_pos);
            f.setCodigo(com.egen.util.text.FormatNumber.format(r.getCodigo(), "0"));
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_tipoestoque_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipoestoque", new ActionMessage("warn.norowsselected",""));
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
      TipoEstoqueActionForm[]_ge_grid_array = (TipoEstoqueActionForm[])_ge_grid.get("bl_form_Jw_tipoestoque_lines");
      TipoEstoqueActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_tipoestoque");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_tipoestoque_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipoestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
