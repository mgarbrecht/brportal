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
 * Creation Date 17/01/2022 13:50:47
 * Last Modify Date 17/01/2022 15:43:30
 */

public class LvTipoProdutoGrdAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      LvTipoProdutoGrdActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    String tipoProdutos = "";
    java.util.Vector vetor = new java.util.Vector();
    LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
    LvTipoProdutoGrdActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (tipoProdutos.equals("")) {
          vetor.addElement(f.getCodigo_grupo() + "-"+f.getDescricao_grupo());
          tipoProdutos = f.getCodigo_grupo();
        } else {
          vetor.addElement(f.getCodigo_grupo() + "-"+f.getDescricao_grupo());
          tipoProdutos += ","+f.getCodigo_grupo();
        }
      }
    }
    session.setAttribute("tipos_produtos_selecionados_vetor", vetor);
    session.setAttribute("tipos_produtos_selecionados_codigos", tipoProdutos);
    request.setAttribute("tipos_produtos_selecionados", tipoProdutos);
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      LvTipoProdutoGrdActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("back");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      if (_ge_grid_array != null) {
        LvTipoProdutoGrdActionForm f = null;
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
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      LvTipoProdutoGrdActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      if (_ge_grid_array != null) {
        LvTipoProdutoGrdActionForm f = null;
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

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      LvTipoProdutoGrdActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
    LvTipoProdutoGrdActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_tipo_produto table = new Jw_tipo_produto();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"descricao_grupo","like", f.getDescricao_grupo()}, {"codigo_grupo","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo_grupo())} };
      Vector res_Jw_tipo_produto = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_tipo_produto",res_Jw_tipo_produto);
      if (res_Jw_tipo_produto != null && res_Jw_tipo_produto.size() > 0) {
        LvTipoProdutoGrdActionForm[]_ge_grid_array_flex = new LvTipoProdutoGrdActionForm[res_Jw_tipo_produto.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_tipo_produto_lines", res_Jw_tipo_produto.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvTipoProdutoGrdActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_tipo_produto.size() > _ge_pos) {
            Jw_tipo_produto r = (Jw_tipo_produto) res_Jw_tipo_produto.elementAt(_ge_pos);
            f.setDescricao_grupo((r.getDescricao_grupo() != null) ? r.getDescricao_grupo() + "":"");
            f.setCodigo_grupo(r.getCodigo_grupo() + "");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_tipo_produto_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("warn.norowsselected",""));
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
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      LvTipoProdutoGrdActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_tipo_produto");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_tipo_produto_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvTipoProdutoGrdActionForm[]_ge_grid_array = (LvTipoProdutoGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_produto_lines");
      LvTipoProdutoGrdActionForm f = _ge_grid_array[0];
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_produto", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
