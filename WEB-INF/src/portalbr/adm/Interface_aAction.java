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
 * Creation Date 07/04/2010 10:03:19
 * Last Modify Date 29/04/2010 14:09:17
 */

public class Interface_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Interface_aActionForm f = (Interface_aActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interfaces_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Interface_aActionForm f = (Interface_aActionForm) form;
    Interfaces_loja table = new Interfaces_loja();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {};
    Vector interfaces = j.select(table, select, where, groupby, having, order);
    session.setAttribute("interfaces",interfaces);
    if (interfaces != null && interfaces.size() > 0) {
      Interfaces_loja r = (Interfaces_loja) interfaces.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interfaces_loja", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Interface_aActionForm f = (Interface_aActionForm) form;
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/adm/InterfaceForm.do?select_session_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interfaces_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Interface_aActionForm f = (Interface_aActionForm) form;
    Interfaces_loja table = new Interfaces_loja();
    Vector sets = new Vector(10, 2);
    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      int updated = j.update(table, set);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interfaces_loja", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector interfaces = (Vector) session.getAttribute("interfaces");
        if (interfaces != null) {
          interfaces.setElementAt(table, 0);
          Interfaces_loja r = (Interfaces_loja) interfaces.elementAt(0);
        }
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
      Interface_aActionForm f = (Interface_aActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/adm/InterfaceForm.do?select_session_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interfaces_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Interface_aActionForm f = (Interface_aActionForm) form;
    Interfaces_loja table = new Interfaces_loja();
    j.delete(table);
    Vector interfaces = (Vector) session.getAttribute("interfaces");
    if (interfaces != null && interfaces.size() > 0) {
      interfaces.removeElementAt(0);
      if (interfaces.size() > 0) {
        Interfaces_loja r = (Interfaces_loja) interfaces.elementAt(0);
      } else {
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Interface_aActionForm f = (Interface_aActionForm) form;


      actionForward = new ActionForward("/adm/Interface_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interfaces_loja", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
