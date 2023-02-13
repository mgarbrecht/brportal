package portalbr.adm;

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
 * Creation Date 20/12/2010 07:45:08
 * Last Modify Date 20/12/2010 08:07:47
 */

public class FiltroPadraoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_pos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos";
        String _lines_name = "bl_form_Usuarios_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
    Vector res_Usuarios = (Vector) session.getAttribute("res_Usuarios");
    if (res_Usuarios != null && _ge_pos < res_Usuarios.size()) {
      Usuarios r = (Usuarios) res_Usuarios.elementAt(_ge_pos);
      f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
      f.setUsua_nome((r.getUsua_nome() != null) ? r.getUsua_nome() + "":"");
      f.setUsua_usuario((r.getUsua_usuario() != null) ? r.getUsua_usuario() + "":"");
      f.setUsua_senha((r.getUsua_senha() != null) ? r.getUsua_senha() + "":"");
      f.setUsua_super((r.getUsua_super() != null) ? r.getUsua_super() + "":"");
      f.setUsua_enne_id((r.getUsua_enne_id() != null) ? r.getUsua_enne_id() + "":"");
      f.setUsua_dt_senha(com.egen.util.text.FormatDate.format(r.getUsua_dt_senha()));
      f.setUsua_acessos((r.getUsua_acessos() != null) ? r.getUsua_acessos() + "":"");
      f.setUsua_dt_ultimo_acesso(com.egen.util.text.FormatDate.format(r.getUsua_dt_ultimo_acesso()));
      f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
      f.setDias_consulta_retroativa((r.getDias_consulta_retroativa() != null) ? r.getDias_consulta_retroativa() + "":"");
      f.setUsua_expira_senha((r.getUsua_expira_senha() != null) ? r.getUsua_expira_senha() + "":"");
      f.setControla_usua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
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
      FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
    Usuarios table = new Usuarios();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"usua_id","=", com.egen.util.text.FormatNumber.toInteger(f.getUsua_id())}, {"usua_nome","like", f.getUsua_nome()}, {"usua_usuario","like", f.getUsua_usuario()}, {"usua_senha","like", f.getUsua_senha()}, {"usua_super","like", f.getUsua_super()}, {"usua_enne_id","=", com.egen.util.text.FormatNumber.toInteger(f.getUsua_enne_id())}, {"usua_dt_senha","=", com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_senha(), "")}, {"usua_acessos","=", com.egen.util.text.FormatNumber.toInteger(f.getUsua_acessos())}, {"usua_dt_ultimo_acesso","=", com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_ultimo_acesso(), "")}, {"situacao","like", f.getSituacao()}, {"dias_consulta_retroativa","=", com.egen.util.text.FormatNumber.toInteger(f.getDias_consulta_retroativa())}, {"usua_expira_senha","like", f.getUsua_expira_senha()}, {"usua_id","=", com.egen.util.text.FormatNumber.toInteger(f.getControla_usua_id())}, };
    Vector res_Usuarios = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Usuarios",res_Usuarios);
    if (res_Usuarios != null && res_Usuarios.size() > 0) {
      Usuarios r = (Usuarios) res_Usuarios.elementAt(0);
      f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
      f.setUsua_nome((r.getUsua_nome() != null) ? r.getUsua_nome() + "":"");
      f.setUsua_usuario((r.getUsua_usuario() != null) ? r.getUsua_usuario() + "":"");
      f.setUsua_senha((r.getUsua_senha() != null) ? r.getUsua_senha() + "":"");
      f.setUsua_super((r.getUsua_super() != null) ? r.getUsua_super() + "":"");
      f.setUsua_enne_id((r.getUsua_enne_id() != null) ? r.getUsua_enne_id() + "":"");
      f.setUsua_dt_senha(com.egen.util.text.FormatDate.format(r.getUsua_dt_senha()));
      f.setUsua_acessos((r.getUsua_acessos() != null) ? r.getUsua_acessos() + "":"");
      f.setUsua_dt_ultimo_acesso(com.egen.util.text.FormatDate.format(r.getUsua_dt_ultimo_acesso()));
      f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
      f.setDias_consulta_retroativa((r.getDias_consulta_retroativa() != null) ? r.getDias_consulta_retroativa() + "":"");
      f.setUsua_expira_senha((r.getUsua_expira_senha() != null) ? r.getUsua_expira_senha() + "":"");
      f.setControla_usua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
      f.setPos("0");
      session.setAttribute("pos", "0");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("warn.norowsselected",""));
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
      FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
    Usuarios table = new Usuarios();
    Object[][] name_value = { {"usua_id",com.egen.util.text.FormatNumber.toInteger(f.getUsua_id())}, {"usua_nome",f.getUsua_nome()}, {"usua_usuario",f.getUsua_usuario()}, {"usua_senha",f.getUsua_senha()}, {"usua_super",f.getUsua_super()}, {"usua_enne_id",com.egen.util.text.FormatNumber.toInteger(f.getUsua_enne_id())}, {"usua_dt_senha",com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_senha(), "")}, {"usua_acessos",com.egen.util.text.FormatNumber.toInteger(f.getUsua_acessos())}, {"usua_dt_ultimo_acesso",com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_ultimo_acesso(), "")}, {"situacao",f.getSituacao()}, {"dias_consulta_retroativa",com.egen.util.text.FormatNumber.toInteger(f.getDias_consulta_retroativa())}, {"usua_expira_senha",f.getUsua_expira_senha()}, {"usua_id",com.egen.util.text.FormatNumber.toInteger(f.getControla_usua_id())}, };
    j.insert(table, name_value);
    Vector res_Usuarios = (Vector) session.getAttribute("res_Usuarios");
    if (res_Usuarios != null && table != null) {
      res_Usuarios.addElement(table);
      session.setAttribute("res_Usuarios", res_Usuarios);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
      try {
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
    Usuarios table = new Usuarios();
    Vector sets = new Vector(10, 2);
    table.setUsua_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_id()));
    if (f.getUsua_id() != null) {
      sets.addElement("usua_id");
    }
    table.setUsua_nome(f.getUsua_nome());
    if (f.getUsua_nome() != null) {
      sets.addElement("usua_nome");
    }
    table.setUsua_usuario(f.getUsua_usuario());
    if (f.getUsua_usuario() != null) {
      sets.addElement("usua_usuario");
    }
    table.setUsua_senha(f.getUsua_senha());
    if (f.getUsua_senha() != null) {
      sets.addElement("usua_senha");
    }
    table.setUsua_super(f.getUsua_super());
    if (f.getUsua_super() != null) {
      sets.addElement("usua_super");
    }
    table.setUsua_enne_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_enne_id()));
    if (f.getUsua_enne_id() != null) {
      sets.addElement("usua_enne_id");
    }
    table.setUsua_dt_senha(com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_senha(), ""));
    if (f.getUsua_dt_senha() != null) {
      sets.addElement("usua_dt_senha");
    }
    table.setUsua_acessos(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_acessos()));
    if (f.getUsua_acessos() != null) {
      sets.addElement("usua_acessos");
    }
    table.setUsua_dt_ultimo_acesso(com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_ultimo_acesso(), ""));
    if (f.getUsua_dt_ultimo_acesso() != null) {
      sets.addElement("usua_dt_ultimo_acesso");
    }
    table.setSituacao(f.getSituacao());
    if (f.getSituacao() != null) {
      sets.addElement("situacao");
    }
    table.setDias_consulta_retroativa(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getDias_consulta_retroativa()));
    if (f.getDias_consulta_retroativa() != null) {
      sets.addElement("dias_consulta_retroativa");
    }
    table.setUsua_expira_senha(f.getUsua_expira_senha());
    if (f.getUsua_expira_senha() != null) {
      sets.addElement("usua_expira_senha");
    }
    table.setUsua_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getControla_usua_id()));
    if (f.getControla_usua_id() != null) {
      sets.addElement("usua_id");
    }
    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      int updated = j.update(table, set);
      String _pos_field_name = "pos";
      String _lines_name = "bl_form_Usuarios_lines";
      String action = null;
      int _ge_pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, f, request);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_Usuarios = (Vector) session.getAttribute("res_Usuarios");
        if (res_Usuarios != null) {
          res_Usuarios.setElementAt(table, _ge_pos);
          Usuarios r = (Usuarios) res_Usuarios.elementAt(_ge_pos);
          f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
          f.setUsua_nome((r.getUsua_nome() != null) ? r.getUsua_nome() + "":"");
          f.setUsua_usuario((r.getUsua_usuario() != null) ? r.getUsua_usuario() + "":"");
          f.setUsua_senha((r.getUsua_senha() != null) ? r.getUsua_senha() + "":"");
          f.setUsua_super((r.getUsua_super() != null) ? r.getUsua_super() + "":"");
          f.setUsua_enne_id((r.getUsua_enne_id() != null) ? r.getUsua_enne_id() + "":"");
          f.setUsua_dt_senha(com.egen.util.text.FormatDate.format(r.getUsua_dt_senha()));
          f.setUsua_acessos((r.getUsua_acessos() != null) ? r.getUsua_acessos() + "":"");
          f.setUsua_dt_ultimo_acesso(com.egen.util.text.FormatDate.format(r.getUsua_dt_ultimo_acesso()));
          f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
          f.setDias_consulta_retroativa((r.getDias_consulta_retroativa() != null) ? r.getDias_consulta_retroativa() + "":"");
          f.setUsua_expira_senha((r.getUsua_expira_senha() != null) ? r.getUsua_expira_senha() + "":"");
          f.setControla_usua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
        tg_delete_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
    int pos = 0;
    try {
      pos = (new Integer(f.getPos())).intValue();
    } catch (Exception e) {}
    Usuarios table = new Usuarios();
    table.setUsua_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_id()));
    table.setUsua_nome(f.getUsua_nome());
    table.setUsua_usuario(f.getUsua_usuario());
    table.setUsua_senha(f.getUsua_senha());
    table.setUsua_super(f.getUsua_super());
    table.setUsua_enne_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_enne_id()));
    table.setUsua_dt_senha(com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_senha(), ""));
    table.setUsua_acessos(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_acessos()));
    table.setUsua_dt_ultimo_acesso(com.egen.util.text.FormatDate.parseTimestamp(f.getUsua_dt_ultimo_acesso(), ""));
    table.setSituacao(f.getSituacao());
    table.setDias_consulta_retroativa(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getDias_consulta_retroativa()));
    table.setUsua_expira_senha(f.getUsua_expira_senha());
    table.setUsua_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getControla_usua_id()));
    j.delete(table);
    Vector res_Usuarios = (Vector) session.getAttribute("res_Usuarios");
    if (res_Usuarios != null && res_Usuarios.size() > pos) {
      if (pos == res_Usuarios.size()) {
        pos--;
      }
      res_Usuarios.removeElementAt(pos);
      if (res_Usuarios.size() > pos) {
        Usuarios r = (Usuarios) res_Usuarios.elementAt(pos);
        f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
        f.setUsua_nome((r.getUsua_nome() != null) ? r.getUsua_nome() + "":"");
        f.setUsua_usuario((r.getUsua_usuario() != null) ? r.getUsua_usuario() + "":"");
        f.setUsua_senha((r.getUsua_senha() != null) ? r.getUsua_senha() + "":"");
        f.setUsua_super((r.getUsua_super() != null) ? r.getUsua_super() + "":"");
        f.setUsua_enne_id((r.getUsua_enne_id() != null) ? r.getUsua_enne_id() + "":"");
        f.setUsua_dt_senha(com.egen.util.text.FormatDate.format(r.getUsua_dt_senha()));
        f.setUsua_acessos((r.getUsua_acessos() != null) ? r.getUsua_acessos() + "":"");
        f.setUsua_dt_ultimo_acesso(com.egen.util.text.FormatDate.format(r.getUsua_dt_ultimo_acesso()));
        f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
        f.setDias_consulta_retroativa((r.getDias_consulta_retroativa() != null) ? r.getDias_consulta_retroativa() + "":"");
        f.setUsua_expira_senha((r.getUsua_expira_senha() != null) ? r.getUsua_expira_senha() + "":"");
        f.setControla_usua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
        f.setPos("" + pos);
      } else {
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FiltroPadraoActionForm f = (FiltroPadraoActionForm) form;
      session.removeAttribute("res_Usuarios");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
