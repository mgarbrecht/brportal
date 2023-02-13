package portalbr.system;

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
 * Creation Date 23/11/2004 09:12:38
 * Last Modify Date 20/12/2016 15:11:17
 */

public class MainAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_logout_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    ActionForward actionForward = null;
    HttpSession session = request.getSession(true);
    try {
      MainActionForm f = (MainActionForm) form;
      session.removeAttribute("treeAcesso");
      session.removeAttribute("User");
      session.removeAttribute(com.egen.util.aas.Constants.SUBJECT_SESSION_KEY);
      session.invalidate();
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    ActionForward actionForward = null;
    HttpSession session = request.getSession(true);
    try {
      MainActionForm f = (MainActionForm) form;
      String localeCombination = f.getLanguage() == null ? "":f.getLanguage();
      java.util.Locale locale = null;
      if (localeCombination != null && localeCombination.length() > 0) {
        String[] params = localeCombination.split("_");
        locale = new java.util.Locale(params[0], params[1]);
        session.setAttribute("locale1",params[0]);
        session.setAttribute("locale2",params[1]);
        Locale.setDefault(locale);
        session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
