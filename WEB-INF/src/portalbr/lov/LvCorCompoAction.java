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
 * Creation Date 19/11/2007 11:22:54
 * Last Modify Date 02/12/2009 10:19:12
 */

public class LvCorCompoAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cor_compo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvCorCompoActionForm f = (LvCorCompoActionForm) form;
    portalbr.dbobj.view.Jw_cor_compo table = new portalbr.dbobj.view.Jw_cor_compo();
    StringBuilder parametros = new StringBuilder();
    StringBuilder sb = new StringBuilder();

    if (!(f.getLin_cdgo().equals(""))) {
      parametros.append(" and cr.lin_cdgo = ").append(f.getLin_cdgo());
    }

    if (!(f.getRef_cdgo().equals(""))) {
      parametros.append(" and cr.ref_cdgo = ").append(f.getRef_cdgo());
    }

    if (!(f.getCab_cdgo().equals(""))) {
      parametros.append(" and cr.cab_cdgo = ").append(f.getCab_cdgo());
    }

    if (!(f.getCor_cdgo().equals(""))) {
      parametros.append(" and c.cor_cdgo = ").append(f.getCor_cdgo());
    }

    if (!(f.getCor_desc().equals(""))) {
      parametros.append(" and upper(c.cor_desc) like ('").append(f.getCor_desc().toUpperCase()).append("') ");
    }

    Object[][] where = { {"Cor_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCor_cdgo())}, {"Cor_desc","like", f.getCor_desc()}, };

    sb.append(" SELECT DISTINCT ");
    sb.append("        c.cor_cdgo ");
    sb.append("      , c.cor_desc ");
    sb.append("   FROM ref_cor cr ");
    sb.append("      , cor c ");
    sb.append("  WHERE c.cor_cdgo = cr.cab_cdgo ");
    sb.append(parametros);
    sb.append("  ORDER BY cor_desc ");

    Vector res_Jw_cor_compo = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_cor_compo",res_Jw_cor_compo);
    if (!(res_Jw_cor_compo != null && res_Jw_cor_compo.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cor_compo", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvCorCompoActionForm f = (LvCorCompoActionForm) form;
      session.removeAttribute("res_Jw_cor_compo");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cor_compo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
