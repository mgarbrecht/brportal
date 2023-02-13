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
 * Creation Date 01/11/2011 08:50:03
 * Last Modify Date 02/04/2013 13:44:08
 */

public class AdministradoresCatalogoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_pos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos";
        String _lines_name = "bl_form_Jw_usuarios_tablets_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
    Vector res_Jw_usuarios_tablets = (Vector) session.getAttribute("res_Jw_usuarios_tablets");
    if (res_Jw_usuarios_tablets != null && _ge_pos < res_Jw_usuarios_tablets.size()) {
      Jw_usuarios_tablets r = (Jw_usuarios_tablets) res_Jw_usuarios_tablets.elementAt(_ge_pos);
      f.setCodigo_usuario((r.getCodigo_usuario() != null) ? r.getCodigo_usuario() + "":"");
      f.setNome_usuario((r.getNome_usuario() != null) ? r.getNome_usuario() + "":"");
      f.setSenha_usuario((r.getSenha_usuario() != null) ? r.getSenha_usuario() + "":"");
      f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
      f.setEmail((r.getEmail() != null) ? r.getEmail() + "":"");
      f.setPos("" + _ge_pos);
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute("pos", "" + _ge_pos);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
    Jw_usuarios_tablets table = new Jw_usuarios_tablets();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"codigo_usuario","like", f.getCodigo_usuario()}, {"nome_usuario","like", f.getNome_usuario().toUpperCase()}, {"senha_usuario","like", f.getSenha_usuario()}, {"codigo_regional","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_regional())}, {"email","like", f.getEmail()}, };
    Vector res_Jw_usuarios_tablets = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_usuarios_tablets",res_Jw_usuarios_tablets);
    if (res_Jw_usuarios_tablets != null && res_Jw_usuarios_tablets.size() > 0) {
      Jw_usuarios_tablets r = (Jw_usuarios_tablets) res_Jw_usuarios_tablets.elementAt(0);
      f.setCodigo_usuario((r.getCodigo_usuario() != null) ? r.getCodigo_usuario() + "":"");
      f.setNome_usuario((r.getNome_usuario() != null) ? r.getNome_usuario() + "":"");
      f.setSenha_usuario((r.getSenha_usuario() != null) ? r.getSenha_usuario() + "":"");
      f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
      f.setEmail((r.getEmail() != null) ? r.getEmail() + "":"");
      f.setPos("0");
      session.setAttribute("pos", "0");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
      StringBuilder sb = new StringBuilder();
      sb.append(" INSERT INTO webstore.wt_usuarios_tablets@sadig ");
      sb.append("   (codigo_usuario ");
      sb.append("   ,nome_usuario ");
      sb.append("   ,senha_usuario ");
      sb.append("   ,codigo_regional ");
      sb.append("   ,email) ");
      sb.append(" VALUES ");
      sb.append("   ('"+f.getCodigo_usuario() + "'");
      sb.append("   ,'"+f.getNome_usuario().toUpperCase() + "' ");
      sb.append("   ,'"+f.getSenha_usuario() + "' ");

      if (f.getCodigo_regional().equals("")) {
        sb.append(" ,null ");
      } else {
        sb.append(" ,'"+f.getCodigo_regional() + "' ");
      }

      if (f.getEmail().equals("")) {
        sb.append(" ,null) ");
      } else {
        sb.append(" ,'"+f.getEmail() + "') ");
      }


      query.execute(j, sb.toString());

      tg_insert_action(mapping, form, request, response);
      form.reset(mapping, request);

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
      StringBuilder sb = new StringBuilder();
      sb.append(" UPDATE webstore.wt_usuarios_tablets@sadig ");
      sb.append("    SET nome_usuario = '"+f.getNome_usuario() + "' ");
      sb.append("      , senha_usuario = '"+f.getSenha_usuario() + "' ");

      if (f.getCodigo_regional().equals("")) {
        sb.append("    , codigo_regional = null ");
      } else {
        sb.append("    , codigo_regional = '"+f.getCodigo_regional() + "' ");
      }

      if (f.getEmail().equals("")) {
        sb.append("    , email = null ");
      } else {
        sb.append("    , email = '"+f.getEmail() + "' ");
      }

      sb.append("  WHERE codigo_usuario = '" + f.getCodigo_usuario() + "'");

      query.execute(j, sb.toString());
      tg_update_action(mapping, form, request, response);

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
      query.execute(j, "DELETE webstore.wt_usuarios_tablets@sadig WHERE codigo_usuario = '"+f.getCodigo_usuario() + "'");
      tg_delete_action(mapping, form, request, response);
      form.reset(mapping, request);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AdministradoresCatalogoActionForm f = (AdministradoresCatalogoActionForm) form;
      session.removeAttribute("res_Jw_usuarios_tablets");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
