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
 * Creation Date 17/04/2006 11:33:02
 * Last Modify Date 26/06/2009 06:26:41
 */

public class PlusProdutos_refAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusProdutos_refActionForm f = (PlusProdutos_refActionForm) form;
    portalbr.dbobj.view.Jw_linha_ref table = new portalbr.dbobj.view.Jw_linha_ref();
    String[][] select = null;
    String[] order = {"ref_cdgo"};
    Object[][] where = { {"Lin_cdgo","like", f.getLin_cdgo()} };
    Vector res_Jw_linha_ref = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Jw_linha_ref",res_Jw_linha_ref);
    if (res_Jw_linha_ref != null && res_Jw_linha_ref.size() > 0) {
      portalbr.dbobj.view.Jw_linha_ref r = (portalbr.dbobj.view.Jw_linha_ref) res_Jw_linha_ref.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
