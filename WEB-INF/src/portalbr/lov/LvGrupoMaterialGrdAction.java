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
 * Creation Date 19/03/2015 10:57:35
 * Last Modify Date 19/03/2015 11:52:40
 */

public class LvGrupoMaterialGrdAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
      LvGrupoMaterialGrdActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_grupo_material", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
    LvGrupoMaterialGrdActionForm f = _ge_grid_array[0];
    if (f != null) {
      Dom_grupo_material table = new Dom_grupo_material();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"gpo_mater_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getGpo_mater_cdgo())}, {"gpo_mater_desc","like", f.getGpo_mater_desc()}, };
      Vector res_Dom_grupo_material = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Dom_grupo_material",res_Dom_grupo_material);
      if (res_Dom_grupo_material != null && res_Dom_grupo_material.size() > 0) {
        LvGrupoMaterialGrdActionForm[]_ge_grid_array_flex = new LvGrupoMaterialGrdActionForm[res_Dom_grupo_material.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Dom_grupo_material_lines", res_Dom_grupo_material.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvGrupoMaterialGrdActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Dom_grupo_material.size() > _ge_pos) {
            Dom_grupo_material r = (Dom_grupo_material) res_Dom_grupo_material.elementAt(_ge_pos);
            f.setGpo_mater_cdgo((r.getGpo_mater_cdgo() != null) ? r.getGpo_mater_cdgo() + "":"");
            f.setGpo_mater_desc((r.getGpo_mater_desc() != null) ? r.getGpo_mater_desc() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Dom_grupo_material_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_grupo_material", new ActionMessage("warn.norowsselected",""));
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
      LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
      LvGrupoMaterialGrdActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_grupo_material", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
    session.removeAttribute("grupos_selecionados");
    session.removeAttribute("codigos_grupos_selecionados");
    java.util.Vector vetor = new java.util.Vector();
    String gruposSelecionados = "";
    LvGrupoMaterialGrdActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (gruposSelecionados.equals("")) {
          vetor.addElement(f.getGpo_mater_cdgo() + "-"+f.getGpo_mater_desc());
          gruposSelecionados = f.getGpo_mater_cdgo();
        } else {
          vetor.addElement(f.getGpo_mater_cdgo() + "-"+f.getGpo_mater_desc());
          gruposSelecionados += ","+f.getGpo_mater_cdgo();
        }
      }
    }
    session.setAttribute("selecionou_grupos", true);
    session.setAttribute("grupos_selecionados",vetor);
    session.setAttribute("codigos_grupos_selecionados",gruposSelecionados);
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
      LvGrupoMaterialGrdActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_grupo_material", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
      if (_ge_grid_array != null) {
        LvGrupoMaterialGrdActionForm f = null;
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
      LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
      LvGrupoMaterialGrdActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_grupo_material", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvGrupoMaterialGrdActionForm[]_ge_grid_array = (LvGrupoMaterialGrdActionForm[])_ge_grid.get("bl_form_Dom_grupo_material_lines");
      if (_ge_grid_array != null) {
        LvGrupoMaterialGrdActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute("LvGrupoMaterialGrdActionForm",form);
    } catch (Exception e) {
      throw e;
    }
  }

}
