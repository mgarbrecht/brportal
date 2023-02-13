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
 * Creation Date 01/03/2006 10:28:53
 * Last Modify Date 06/11/2009 16:56:43
 */

public class LvCabedalAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cabedal", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvCabedalActionForm f = (LvCabedalActionForm) form;
    portalbr.dbobj.view.Jw_lov_cabedal table = new portalbr.dbobj.view.Jw_lov_cabedal();
    String cab_cdgo = "null";
    String cab_desc = "null";
    String lin_cdgo = "null";
    String ref_cdgo = "null";
    if (f.getCab_cdgo() != "") {
      cab_cdgo = f.getCab_cdgo();
    }
    if (f.getCab_desc() != "") {
      cab_desc = "'"+f.getCab_desc() + "'";
    }
    if (f.getLin_cdgo() != "") {
      lin_cdgo = f.getLin_cdgo();
    }
    if (f.getRef_cdgo() != "") {
      ref_cdgo = f.getRef_cdgo();
    }

    StringBuilder query = new StringBuilder();
    query.append(" select distinct ");
    query.append("        rc.cab_cdgo, ");
    query.append("        c.cab_desc ");
    query.append("   from ref_cab rc, ");
    query.append("        cabedal c ");
    query.append("  where c.cab_cdgo  = rc.cab_cdgo ");
    query.append("    and rc.lin_cdgo = nvl(").append(lin_cdgo).append(",rc.lin_cdgo) ");
    query.append("    and rc.ref_cdgo = nvl(").append(ref_cdgo).append(",rc.ref_cdgo) ");
    query.append("    and c.cab_cdgo  = nvl(").append(cab_cdgo).append(",c.cab_cdgo) ");
    query.append("    and upper(c.cab_desc) like upper(nvl(").append(cab_desc).append(",c.cab_desc)) ");
    query.append("  order by cab_desc ");

    Vector res_Jw_lov_cabedal = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_lov_cabedal",res_Jw_lov_cabedal);
    if (res_Jw_lov_cabedal == null || res_Jw_lov_cabedal.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cabedal", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.removeAttribute("res_Jw_lov_cabedal");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cabedal", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
