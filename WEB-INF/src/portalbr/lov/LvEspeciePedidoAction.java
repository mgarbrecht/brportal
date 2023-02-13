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
 * Creation Date 31/07/2013 12:00:21
 * Last Modify Date 14/06/2019 11:41:59
 */

public class LvEspeciePedidoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      LvEspeciePedidoActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
        tg_select_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_especie_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
    LvEspeciePedidoActionForm f = _ge_grid_array[0];
    StringBuilder sb = new StringBuilder();
    if (f != null) {
      Jw_especie_pedido table = new Jw_especie_pedido();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"codigo","like", f.getCodigo()}, {"descricao","like", f.getDescricao()}, {"ordem","=", com.egen.util.text.FormatNumber.toInt(f.getOrdem())}, };
      Vector res_Jw_especie_pedido = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_especie_pedido",res_Jw_especie_pedido);
      if (res_Jw_especie_pedido != null && res_Jw_especie_pedido.size() > 0) {
        LvEspeciePedidoActionForm[]_ge_grid_array_flex = new LvEspeciePedidoActionForm[res_Jw_especie_pedido.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_especie_pedido_lines", res_Jw_especie_pedido.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvEspeciePedidoActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_especie_pedido.size() > _ge_pos) {
            Jw_especie_pedido r = (Jw_especie_pedido) res_Jw_especie_pedido.elementAt(_ge_pos);
            f.setCodigo((r.getCodigo() != null) ? r.getCodigo() + "":"");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
            f.setOrdem(r.getOrdem() + "");
            if (sb.toString().equals("")) {
              sb.append("'").append(r.getCodigo()).append("'");
            } else {
              sb.append(",'").append(r.getCodigo()).append("'");
            }

          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_especie_pedido_lines", _ge_grid_array_flex);
        session.setAttribute("especies", sb.toString());
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_especie_pedido", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      if (_ge_grid_array != null) {
        LvEspeciePedidoActionForm f = null;
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

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      LvEspeciePedidoActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_especie_pedido");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_especie_pedido_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_especie_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      LvEspeciePedidoActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_especie_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      if (_ge_grid_array != null) {
        LvEspeciePedidoActionForm f = null;
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
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      LvEspeciePedidoActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_especie_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      if (_ge_grid_array != null) {
        LvEspeciePedidoActionForm f = null;
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

  public ActionForward perform_selecionar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
      LvEspeciePedidoActionForm f = _ge_grid_array[0];
      selecionar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_especie_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvEspeciePedidoActionForm[]_ge_grid_array = (LvEspeciePedidoActionForm[])_ge_grid.get("bl_form_Jw_especie_pedido_lines");
    LvEspeciePedidoActionForm f = _ge_grid_array[0];
    StringBuilder sb = new StringBuilder();
    session.removeAttribute("listaEspecies");
    session.removeAttribute("especies");
    boolean marcou = false;
    java.util.Vector listaEspecies = new java.util.Vector();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        marcou = true;
        listaEspecies.add(f.getCodigo() + " - "+f.getDescricao());
        if (sb.toString().equals("")) {
          sb.append("'").append(f.getCodigo()).append("'");
        } else {
          sb.append(",'").append(f.getCodigo()).append("'");
        }
      }
      if (marcou) {
        session.setAttribute("listaEspecies",listaEspecies);
        session.setAttribute("especies", sb.toString());
      }
      request.setAttribute("selecionou_especies","s");
    }
  }
}
