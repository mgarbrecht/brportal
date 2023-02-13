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
 * Creation Date 10/09/2010 12:18:05
 * Last Modify Date 18/10/2010 09:57:18
 */

public class LvRefCabExp0400Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvRefCabExp0400ActionForm f = (LvRefCabExp0400ActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_ref_cab_exp0400", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvRefCabExp0400ActionForm f = (LvRefCabExp0400ActionForm) form;
    Jw_lv_ref_cab_exp0400 table = new Jw_lv_ref_cab_exp0400();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"cab_cdgo","like", f.getCab_cdgo()}, {"cab_desc","like", f.getCab_desc()}, {"descricao","like", f.getDescricao()}, {"lin_cdgo","like", f.getLin_cdgo()}, {"ref_cdgo","like", f.getRef_cdgo()} };
    Vector res_Jw_lv_ref_cab_exp0400 = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_lv_ref_cab_exp0400",res_Jw_lv_ref_cab_exp0400);
    if (res_Jw_lv_ref_cab_exp0400 == null || res_Jw_lv_ref_cab_exp0400.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_ref_cab_exp0400", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvRefCabExp0400ActionForm f = (LvRefCabExp0400ActionForm) form;
      session.removeAttribute("res_Jw_lv_ref_cab_exp0400");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_ref_cab_exp0400", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
