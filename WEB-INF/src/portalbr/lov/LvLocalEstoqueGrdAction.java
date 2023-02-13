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
 * Creation Date 10/09/2021 16:34:25
 * Last Modify Date 10/09/2021 18:50:45
 */

public class LvLocalEstoqueGrdAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
      LvLocalEstoqueGrdActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_localestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
    LvLocalEstoqueGrdActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_localestoque table = new Jw_localestoque();
      String[][] select = null;
      String[] order = {"codigo"};
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"fil_filial","like", f.getFil_filial()}, {"codigo","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo())}, {"descricao","like", f.getDescricao()}, };
      Vector res_Jw_localestoque = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_localestoque",res_Jw_localestoque);
      if (res_Jw_localestoque != null && res_Jw_localestoque.size() > 0) {
        LvLocalEstoqueGrdActionForm[]_ge_grid_array_flex = new LvLocalEstoqueGrdActionForm[res_Jw_localestoque.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_localestoque_lines", res_Jw_localestoque.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvLocalEstoqueGrdActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_localestoque.size() > _ge_pos) {
            Jw_localestoque r = (Jw_localestoque) res_Jw_localestoque.elementAt(_ge_pos);
            f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setCodigo(r.getCodigo() + "");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_localestoque_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_localestoque", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
      LvLocalEstoqueGrdActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_localestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
      if (_ge_grid_array != null) {
        LvLocalEstoqueGrdActionForm f = null;
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
      LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
      LvLocalEstoqueGrdActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_localestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
      if (_ge_grid_array != null) {
        LvLocalEstoqueGrdActionForm f = null;
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

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
      LvLocalEstoqueGrdActionForm f = _ge_grid_array[0];
      try {
        update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_localestoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  private void update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    session.removeAttribute("selecionou_locais");
    session.removeAttribute("locais_selecionados");
    session.removeAttribute("codigos_locais_selecionados");
    java.util.Vector vetor = new java.util.Vector();
    String locaisSelecionados = "";
    DynaActionForm _ge_grid = (DynaActionForm) form;
    LvLocalEstoqueGrdActionForm[]_ge_grid_array = (LvLocalEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_localestoque_lines");
    LvLocalEstoqueGrdActionForm f = _ge_grid_array[0];
    boolean selecionou = false;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        selecionou = true;
        if (locaisSelecionados.equals("")) {
          vetor.addElement(f.getCodigo() + "-"+f.getDescricao());
          locaisSelecionados = f.getCodigo();
        } else {
          vetor.addElement(f.getCodigo() + "-"+f.getDescricao());
          locaisSelecionados += ","+f.getCodigo();
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
    if (selecionou) {
      session.setAttribute("locais_selecionados",vetor);
      if (locaisSelecionados.equals("")) {
        session.removeAttribute("codigos_locais_selecionados");
        session.removeAttribute("locais_selecionados");
      } else {
        session.setAttribute("codigos_locais_selecionados",locaisSelecionados);
      }
    } else {
      session.setAttribute("codigos_locais_selecionados","");
    }
    session.setAttribute("selecionou_locais", true);
  }

}
