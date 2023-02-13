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
 * Creation Date 10/09/2010 07:10:48
 * Last Modify Date 10/09/2010 08:56:21
 */

public class LvRefGdeAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvRefGdeActionForm f = (LvRefGdeActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_gde", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvRefGdeActionForm f = (LvRefGdeActionForm) form;
    Jw_ref_gde table = new Jw_ref_gde();

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT rgde.gde_cdgo grade ");
    sb.append("      , grde.gde_numi no_inicial ");
    sb.append("      , grde.gde_numf no_final ");
    sb.append("   FROM ref_gde rgde ");
    sb.append("      , gre grde ");
    sb.append("  WHERE grde.gde_cdgo = rgde.gde_cdgo ");
    sb.append("    AND rgde.rfg_status = 'A' ");
    sb.append("    AND lin_cdgo = "+f.getLinha());
    sb.append("    AND ref_cdgo = "+f.getReferencia());
    sb.append("  ORDER BY 1 ");

    //  if(true){throw new Exception(sb.toString());}
    Vector res_Jw_ref_gde = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_ref_gde",res_Jw_ref_gde);
    if (res_Jw_ref_gde == null || res_Jw_ref_gde.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_gde", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvRefGdeActionForm f = (LvRefGdeActionForm) form;
      session.removeAttribute("res_Jw_ref_gde");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_gde", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
