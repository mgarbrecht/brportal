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
 * Creation Date 17/09/2018 10:10:44
 * Last Modify Date 17/09/2018 10:53:35
 */

public class LvMarcaGrdAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      LvMarcaGrdActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      if (_ge_grid_array != null) {
        LvMarcaGrdActionForm f = null;
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
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      LvMarcaGrdActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      if (_ge_grid_array != null) {
        LvMarcaGrdActionForm f = null;
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

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      LvMarcaGrdActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Marcas_produtos");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Marcas_produtos_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      LvMarcaGrdActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
    LvMarcaGrdActionForm f = _ge_grid_array[0];
    String codigoMarcas = "";
    java.util.Vector vetor = new java.util.Vector();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (codigoMarcas.equals("")) {
          vetor.addElement(f.getCodigo_marca() + "-"+f.getDescricao_marca());
          codigoMarcas = f.getCodigo_marca();
        } else {
          vetor.addElement(f.getCodigo_marca() + "-"+f.getDescricao_marca());
          codigoMarcas += ","+f.getCodigo_marca();
        }
      }
    }
    session.setAttribute("est102_marcas_selecionadas_vetor", vetor);
    session.setAttribute("est102_marcas_selecionadas_codigos", codigoMarcas);
    request.setAttribute("marcas_selecionadas", codigoMarcas);
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
      LvMarcaGrdActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvMarcaGrdActionForm[]_ge_grid_array = (LvMarcaGrdActionForm[])_ge_grid.get("bl_form_Marcas_produtos_lines");
    LvMarcaGrdActionForm f = _ge_grid_array[0];
    if (f != null) {
      Marcas_produtos table = new Marcas_produtos();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = {{"status","=", "A"}, {"codigo_marca","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo_marca())}, {"descricao_marca","like", f.getDescricao_marca()} };
      Vector res_Marcas_produtos = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Marcas_produtos",res_Marcas_produtos);
      if (res_Marcas_produtos != null && res_Marcas_produtos.size() > 0) {
        LvMarcaGrdActionForm[]_ge_grid_array_flex = new LvMarcaGrdActionForm[res_Marcas_produtos.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Marcas_produtos_lines", res_Marcas_produtos.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvMarcaGrdActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Marcas_produtos.size() > _ge_pos) {
            Marcas_produtos r = (Marcas_produtos) res_Marcas_produtos.elementAt(_ge_pos);
            f.setCodigo_marca(r.getCodigo_marca() + "");
            f.setDescricao_marca((r.getDescricao_marca() != null) ? r.getDescricao_marca() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Marcas_produtos_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

}
