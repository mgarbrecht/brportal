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
 * Creation Date 04/07/2016 16:29:58
 * Last Modify Date 16/08/2016 16:32:14
 */

public class LvSituacaoPedidoGrdAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      LvSituacaoPedidoGrdActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
        tg_select_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
    LvSituacaoPedidoGrdActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_situacao_pedidos table = new Jw_situacao_pedidos();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo())}, {"descricao","like", f.getDescricao()}, };
      Vector res_Jw_situacao_pedidos = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_situacao_pedidos",res_Jw_situacao_pedidos);
      if (res_Jw_situacao_pedidos != null && res_Jw_situacao_pedidos.size() > 0) {
        LvSituacaoPedidoGrdActionForm[]_ge_grid_array_flex = new LvSituacaoPedidoGrdActionForm[res_Jw_situacao_pedidos.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_situacao_pedidos_lines", res_Jw_situacao_pedidos.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvSituacaoPedidoGrdActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_situacao_pedidos.size() > _ge_pos) {
            Jw_situacao_pedidos r = (Jw_situacao_pedidos) res_Jw_situacao_pedidos.elementAt(_ge_pos);
            f.setCodigo((r.getCodigo() != null) ? r.getCodigo() + "":"");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_situacao_pedidos_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_pedidos", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      if (_ge_grid_array != null) {
        LvSituacaoPedidoGrdActionForm f = null;
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
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      LvSituacaoPedidoGrdActionForm f = _ge_grid_array[0];
      selecionar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    session.removeAttribute("res_situacao_pedido");
    session.removeAttribute("consulta_pedidos_situacao_pedido");
    String cod = "";
    boolean marcou = false;
    java.util.Vector vetor = new java.util.Vector();
    LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
    LvSituacaoPedidoGrdActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        marcou = true;
        if (cod.equals("")) {
          vetor.addElement(f.getCodigo() + " - "+f.getDescricao());
          cod = f.getCodigo();
        } else {
          vetor.addElement(f.getCodigo() + " - "+f.getDescricao());
          cod += ","+f.getCodigo();
        }
      }
      request.setAttribute("selecionou", "s");
      session.setAttribute(mapping.getName(), form);
    }
    if (marcou) {
      session.setAttribute("res_situacao_pedido",vetor);
      session.setAttribute("consulta_pedidos_situacao_pedido", cod);
    }
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      LvSituacaoPedidoGrdActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      if (_ge_grid_array != null) {
        LvSituacaoPedidoGrdActionForm f = null;
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
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      LvSituacaoPedidoGrdActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvSituacaoPedidoGrdActionForm[]_ge_grid_array = (LvSituacaoPedidoGrdActionForm[])_ge_grid.get("bl_form_Jw_situacao_pedidos_lines");
      if (_ge_grid_array != null) {
        LvSituacaoPedidoGrdActionForm f = null;
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
