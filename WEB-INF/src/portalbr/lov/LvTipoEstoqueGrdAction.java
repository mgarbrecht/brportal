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
 * Creation Date 03/12/2009 17:33:43
 * Last Modify Date 17/01/2022 14:16:41
 */

public class LvTipoEstoqueGrdAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      String cod = "";
      java.util.Vector vetor = new java.util.Vector();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvTipoEstoqueGrdActionForm[]_ge_grid_array = (LvTipoEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_estoque_lines");
      if (_ge_grid_array != null) {
        LvTipoEstoqueGrdActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];

          if (f.getGridCheckField() == true) {
            if (cod.equals("")) {
              vetor.addElement(f.getCodigo() + "-"+f.getDescricao());
              cod = f.getCodigo();
            } else {
              vetor.addElement(f.getCodigo() + "-"+f.getDescricao());
              cod += ","+f.getCodigo();
            }

          }
        }
        f = _ge_grid_array[0];
      }
      session.setAttribute("tipos_estoque",vetor);
      session.setAttribute("codigos_estoque",cod);
      request.setAttribute("cod_estoque",cod);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    LvTipoEstoqueGrdActionForm[]_ge_grid_array = (LvTipoEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_estoque_lines");
    LvTipoEstoqueGrdActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_tipo_estoque table = new Jw_tipo_estoque();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"CODIGO","=", com.egen.util.text.FormatNumber.toDouble(f.getCodigo())}, {"DESCRICAO","like", f.getDescricao()}, };
      Vector res_Jw_tipo_estoque = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_tipo_estoque",res_Jw_tipo_estoque);
      if (res_Jw_tipo_estoque != null && res_Jw_tipo_estoque.size() > 0) {
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.reset(mapping, request);
          if (res_Jw_tipo_estoque.size() > _ge_pos) {
            Jw_tipo_estoque r = (Jw_tipo_estoque) res_Jw_tipo_estoque.elementAt(_ge_pos);
            f.setCodigo(r.getCodigo() + "");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
            //f.setPos("" + _ge_pos);
          }
          _ge_grid_array[_ge_grid_array_index] = f;
        }
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvTipoEstoqueGrdActionForm[]_ge_grid_array = (LvTipoEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_estoque_lines");
      LvTipoEstoqueGrdActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvTipoEstoqueGrdActionForm[]_ge_grid_array = (LvTipoEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_estoque_lines");
    LvTipoEstoqueGrdActionForm f = _ge_grid_array[0];
    String tiposEstoqueSelecionados = null;
    String tt[] = null;
    if (session.getAttribute("opener") != null && ((String) session.getAttribute("opener")).equalsIgnoreCase("saldo_estoque_grade")) {
      if (session.getAttribute("codigos_estoque") != null) {
        tiposEstoqueSelecionados = (String) session.getAttribute("codigos_estoque");
        tt = tiposEstoqueSelecionados.split(",");
      }
    }
    if (f != null) {
      Jw_tipo_estoque table = new Jw_tipo_estoque();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = {};
      Vector res_Jw_tipo_estoque = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_tipo_estoque",res_Jw_tipo_estoque);
      if (res_Jw_tipo_estoque != null && res_Jw_tipo_estoque.size() > 0) {
        LvTipoEstoqueGrdActionForm[]_ge_grid_array_flex = new LvTipoEstoqueGrdActionForm[res_Jw_tipo_estoque.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_tipo_estoque_lines", res_Jw_tipo_estoque.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new LvTipoEstoqueGrdActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_tipo_estoque.size() > _ge_pos) {
            Jw_tipo_estoque r = (Jw_tipo_estoque) res_Jw_tipo_estoque.elementAt(_ge_pos);
            if (tiposEstoqueSelecionados != null) {
              for (String s :
                  tt) {
                if (s.equalsIgnoreCase(r.getCodigo() + "")) {
                  f.setGridCheckField(true);
                }
              }
            }
            f.setCodigo(r.getCodigo() + "");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_tipo_estoque_lines", _ge_grid_array_flex);
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque", new ActionMessage("warn.norowsselected",""));
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
      LvTipoEstoqueGrdActionForm[]_ge_grid_array = (LvTipoEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_estoque_lines");
      LvTipoEstoqueGrdActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_tipo_estoque");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_tipo_estoque_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      LvTipoEstoqueGrdActionForm[]_ge_grid_array = (LvTipoEstoqueGrdActionForm[])_ge_grid.get("bl_form_Jw_tipo_estoque_lines");
      LvTipoEstoqueGrdActionForm f = _ge_grid_array[0];
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
