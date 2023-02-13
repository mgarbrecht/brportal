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
 * Creation Date 07/02/2006 13:49:02
 * Last Modify Date 29/10/2010 07:49:51
 */

public class NavegacaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      insert_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    return actionForward;
  }
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    NavegacaoActionForm f = (NavegacaoActionForm) form;
    //-------------------------------------------------------------------------------------------------
    acesso.MenuAPI menu = new acesso.MenuAPI(j.getConn());
    if (f.getMenu_pai_menu_id() != "") {
      acesso.MenuAPI menu_pai = new acesso.MenuAPI(j.getConn());
      menu_pai.select(Integer.parseInt(f.getMenu_pai_menu_id()));
      menu.setMenuPai((acesso.Menu) menu_pai);
    }
    menu.setNome(f.getMenu_nome());
    menu.setTexto(f.getMenu_texto());
    menu.insert();
    //-------------------------------------------------------------------------------------------------
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }


  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("NavegacaoActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("back");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    return actionForward;
  }
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    NavegacaoActionForm f = (NavegacaoActionForm) form;
    portalbr.dbobj.table.Menus table = new portalbr.dbobj.table.Menus();
    Vector sets = new Vector(10, 2);
    table.setMenu_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getMenu_id()));
    table.setMenu_nome(f.getMenu_nome());
    if (f.getMenu_nome() != null) {
      sets.addElement("menu_nome");
    } else {
      sets.addElement("");
    };
    table.setMenu_texto(f.getMenu_texto());
    if (f.getMenu_texto() != null) {
      sets.addElement("menu_texto");
    } else {
      sets.addElement("");
    };
    table.setMenu_pai_menu_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getMenu_pai_menu_id()));
    if (f.getMenu_pai_menu_id() != null) {
      sets.addElement("menu_pai_menu_id");
    } else {
      sets.addElement("");
    };
    String[] set = new String[sets.size()];
    for (int i = 0; i < sets.size(); i++) {
      set[i] = (String) sets.elementAt(i);
    }


    //----------------------------------------------------------
    acesso.MenuAPI menu = new acesso.MenuAPI(j.getConn());
    menu.select(Integer.parseInt(f.getMenu_id()));
    if (f.getMenu_pai_menu_id() != "") {
      acesso.MenuAPI menu_pai = new acesso.MenuAPI(j.getConn());
      menu_pai.select(Integer.parseInt(f.getMenu_pai_menu_id()));
      menu.setMenuPai((acesso.Menu) menu_pai);
    } else {
      acesso.MenuAPI menu_pai = new acesso.MenuAPI(j.getConn());
      menu.setMenuPai(null);
    }

    menu.setNome(f.getMenu_nome());
    menu.setTexto(f.getMenu_texto());
    menu.update();
    int updated = 1;

    //----------------------------------------------------------

    String _pos_field_name = "pos";
    String _lines_name = "bl_form_Menus_lines";
    String action = null;
    int _ge_pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, f, request);
    if (updated == 0) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("warn.norowsupdated",": " + updated));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    } else {
      Vector res_Menus = (Vector) session.getAttribute("res_Menus");
      if (res_Menus != null) {
        res_Menus.setElementAt(table, _ge_pos);
        portalbr.dbobj.table.Menus r = (portalbr.dbobj.table.Menus) res_Menus.elementAt(_ge_pos);
        f.setMenu_id((r.getMenu_id() != null) ? r.getMenu_id() + "":"");
        f.setMenu_nome((r.getMenu_nome() != null) ? r.getMenu_nome() + "":"");
        f.setMenu_texto((r.getMenu_texto() != null) ? r.getMenu_texto() + "":"");
        f.setMenu_pai_menu_id((r.getMenu_pai_menu_id() != null) ? r.getMenu_pai_menu_id() + "":"");
      }
    }
    session.setAttribute(mapping.getName(), form);
  }







  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("back");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    return actionForward;
  }
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    NavegacaoActionForm f = (NavegacaoActionForm) form;
    acesso.MenuAPI menu = new acesso.MenuAPI(j.getConn());
    menu.select(Integer.parseInt(f.getMenu_id()));
    menu.delete();
    Vector res_Menus = (Vector) session.getAttribute("res_Menus");
    if (res_Menus != null && res_Menus.size() > 0) {
      res_Menus.removeElementAt(Integer.parseInt(f.getPos()));
      if (res_Menus.size() > 0) {
        portalbr.dbobj.table.Menus r = (portalbr.dbobj.table.Menus) res_Menus.elementAt(0);
        f.setMenu_id((r.getMenu_id() != null) ? r.getMenu_id() + "":"");
        f.setMenu_nome((r.getMenu_nome() != null) ? r.getMenu_nome() + "":"");
        f.setMenu_texto((r.getMenu_texto() != null) ? r.getMenu_texto() + "":"");
        f.setMenu_pai_menu_id((r.getMenu_pai_menu_id() != null) ? r.getMenu_pai_menu_id() + "":"");
      } else {
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    NavegacaoActionForm f = (NavegacaoActionForm) form;
    portalbr.dbobj.table.Menus table = new portalbr.dbobj.table.Menus();
    String[][] select = null;
    Object[][] where = { {"Menu_id","=", com.egen.util.text.FormatNumber.toInteger(f.getMenu_id())}, {"Menu_nome","like", f.getMenu_nome()}, {"Menu_texto","like", f.getMenu_texto()}, {"Menu_pai_menu_id","=", com.egen.util.text.FormatNumber.toInteger(f.getMenu_pai_menu_id())} };
    Vector res_Menus = j.select(table, select, where, null, null, null);

    session.setAttribute("res_Menus",res_Menus);
    if (res_Menus != null && res_Menus.size() > 0) {
      portalbr.dbobj.table.Menus r = (portalbr.dbobj.table.Menus) res_Menus.elementAt(0);
      f.setMenu_id((r.getMenu_id() != null) ? r.getMenu_id() + "":"");
      f.setMenu_nome((r.getMenu_nome() != null) ? r.getMenu_nome() + "":"");
      f.setMenu_texto((r.getMenu_texto() != null) ? r.getMenu_texto() + "":"");
      f.setMenu_pai_menu_id((r.getMenu_pai_menu_id() != null) ? r.getMenu_pai_menu_id() + "":"");
      f.setPos("0");
      session.setAttribute("pos", "0");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_incluir_item_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NavegacaoActionForm f = (NavegacaoActionForm) form;
      actionForward = new ActionForward("/acesso/ItemNavegacaoForm.do?pop_action=&itme_menu_id="+f.getMenu_id() + ""+"&menu_nome="+f.getMenu_nome() + "",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Menus", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
