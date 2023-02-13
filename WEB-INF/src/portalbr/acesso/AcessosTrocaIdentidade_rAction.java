package portalbr.acesso;

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
 * Creation Date 12/12/2017 12:43:18
 * Last Modify Date 14/12/2017 11:43:07
 */

public class AcessosTrocaIdentidade_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
    AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_acessos_troca_identidade table = new Jw_acessos_troca_identidade();
      Vector res_Jw_acessos_troca_identidade = (Vector) session.getAttribute("res_Jw_acessos_troca_identidade");
      if (res_Jw_acessos_troca_identidade != null && res_Jw_acessos_troca_identidade.size() > 0) {
        AcessosTrocaIdentidade_rActionForm[]_ge_grid_array_flex = new AcessosTrocaIdentidade_rActionForm[res_Jw_acessos_troca_identidade.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_acessos_troca_identidade_lines", res_Jw_acessos_troca_identidade.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new AcessosTrocaIdentidade_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_acessos_troca_identidade.size() > _ge_pos) {
            Jw_acessos_troca_identidade r = (Jw_acessos_troca_identidade) res_Jw_acessos_troca_identidade.elementAt(_ge_pos);
            f.setAtid_usua_id(r.getAtid_usua_id() + "");
            f.setUsua_usuario((r.getUsua_usuario() != null) ? r.getUsua_usuario() + "":"");
            f.setUsua_nome((r.getUsua_nome() != null) ? r.getUsua_nome() + "":"");
            f.setAtid_tien_id(r.getAtid_tien_id() + "");
            f.setTien_tipo((r.getTien_tipo() != null) ? r.getTien_tipo() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_acessos_troca_identidade_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];
      delete_action(j, mapping, form, request, response);
      tg_delete_action(mapping, form, request, response);
      actionForward = new ActionForward("/acesso/AcessosTrocaIdentidade_rGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
    AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];
    int _ge_pos = 0;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        Acessos_troca_identidade table = new Acessos_troca_identidade();
        table.setAtid_usua_id(com.egen.util.text.FormatNumber.parseInt(f.getAtid_usua_id()));
        table.setAtid_tien_id(com.egen.util.text.FormatNumber.parseInt(f.getAtid_tien_id()));
        j.delete(table);
        Vector res_Jw_acessos_troca_identidade = (Vector) session.getAttribute("res_Jw_acessos_troca_identidade");
        if (res_Jw_acessos_troca_identidade != null && res_Jw_acessos_troca_identidade.size() > 0) {
          res_Jw_acessos_troca_identidade.removeElementAt(0);
          if (res_Jw_acessos_troca_identidade.size() > 0) {
            Jw_acessos_troca_identidade r = (Jw_acessos_troca_identidade) res_Jw_acessos_troca_identidade.elementAt(0);
            f.setAtid_usua_id(r.getAtid_usua_id() + "");
            f.setUsua_usuario((r.getUsua_usuario() != null) ? r.getUsua_usuario() + "":"");
            f.setUsua_nome((r.getUsua_nome() != null) ? r.getUsua_nome() + "":"");
            f.setAtid_tien_id(r.getAtid_tien_id() + "");
            f.setTien_tipo((r.getTien_tipo() != null) ? r.getTien_tipo() + "":"");
          } else {
            f.reset(mapping, request);
          }
        } else {
          f.reset(mapping, request);
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }
  private void tg_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      if (_ge_grid_array != null) {
        AcessosTrocaIdentidade_rActionForm f = null;
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
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      if (_ge_grid_array != null) {
        AcessosTrocaIdentidade_rActionForm f = null;
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
      AcessosTrocaIdentidade_rActionForm[]_ge_grid_array = (AcessosTrocaIdentidade_rActionForm[])_ge_grid.get("bl_form_Jw_acessos_troca_identidade_lines");
      AcessosTrocaIdentidade_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/acesso/AcessosTrocaIdentidadeForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
