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
 * Creation Date 23/01/2014 11:37:25
 * Last Modify Date 02/09/2015 16:18:01
 */

public class ArquivosFornecedoresOc_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
    ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_interface_arq_compra table = new Jw_interface_arq_compra();
      String sbQuery = session.getAttribute("query_interface_arq_compra") != null ? ((String) session.getAttribute("query_interface_arq_compra")) : "";
      Vector res_Jw_interface_arq_compra = j.select(table, sbQuery, null);
      session.setAttribute("res_Jw_interface_arq_compra",res_Jw_interface_arq_compra);
      if (res_Jw_interface_arq_compra != null && res_Jw_interface_arq_compra.size() > 0) {
        ArquivosFornecedoresOc_rActionForm[]_ge_grid_array_flex = new ArquivosFornecedoresOc_rActionForm[res_Jw_interface_arq_compra.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_interface_arq_compra_lines", res_Jw_interface_arq_compra.size());
        int _ge_pos = 0;
        util.consultas.Query query = new util.consultas.Query();
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ArquivosFornecedoresOc_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_interface_arq_compra.size() > _ge_pos) {
            Jw_interface_arq_compra r = (Jw_interface_arq_compra) res_Jw_interface_arq_compra.elementAt(_ge_pos);
            query.execute("update interface_arq_compra set situacao = 'C' where interface_arq_compra_id = " + r.getInterface_arq_compra_id());
            f.setInterface_arq_compra_id((r.getInterface_arq_compra_id() != null) ? r.getInterface_arq_compra_id() + "":"");
            f.setForn_codigo((r.getForn_codigo() != null) ? r.getForn_codigo() + "":"");
            f.setNome_arquivo((r.getNome_arquivo() != null) ? r.getNome_arquivo() + "":"");
            f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
            f.setDescricao_situacao((r.getDescricao_situacao() != null) ? r.getDescricao_situacao() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_interface_arq_compra_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("warn.norowsselected",""));
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
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.com.InterfaceArqCompra interfaceArqCompra = new util.consultas.com.InterfaceArqCompra();
    interfaceArqCompra.gerar(form, request);
    ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
    ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];
    //  for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
    //    f = _ge_grid_array[_ge_grid_array_index];
    //    if (f.getGridCheckField()) {
    //    }
    //  }
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      if (_ge_grid_array != null) {
        ArquivosFornecedoresOc_rActionForm f = null;
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
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      if (_ge_grid_array != null) {
        ArquivosFornecedoresOc_rActionForm f = null;
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

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/ArquivosFornecedoresOcForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
      ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];
      update1_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ArquivosFornecedoresOc_rActionForm[]_ge_grid_array = (ArquivosFornecedoresOc_rActionForm[])_ge_grid.get("bl_form_Jw_interface_arq_compra_lines");
    ArquivosFornecedoresOc_rActionForm f = _ge_grid_array[0];
    StringBuilder query = new StringBuilder();
    query.append(" i.interface_arq_compra_id IN (");
    StringBuilder sbQuery = new StringBuilder();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (sbQuery.length() > 0) {
          sbQuery.append(",");
        } else {
          sbQuery.append(f.getInterface_arq_compra_id());
        }
      }
    }
    query.append(sbQuery.toString());
    query.append(") ");
    //--------------------------------------------------------------------------
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("OrdemCompra.jasper");
    g.setParametro("P_QUERY", query.toString());
    g.gerar();
    //--------------------------------------------------------------------------

  }

}
