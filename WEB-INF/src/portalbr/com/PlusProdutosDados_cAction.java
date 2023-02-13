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
 * Creation Date 17/04/2006 13:22:29
 * Last Modify Date 16/09/2009 14:15:29
 */

public class PlusProdutosDados_cAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref_cab_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusProdutosDados_cActionForm f = (PlusProdutosDados_cActionForm) form;
    portalbr.dbobj.view.Jw_linha_ref_cab_cor table = new portalbr.dbobj.view.Jw_linha_ref_cab_cor();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT r.cab_cdgo ");
    query.append("      , c.cab_desc ");
    query.append("      , decode(r.rfb_status,'A','Ativo','I','Inativo') status ");
    query.append("      , re.cor_cdgo ");
    query.append("      , co.cor_desc  ");
    query.append("   FROM ref_cab  r   ");
    query.append("      , cabedal  c   ");
    query.append("      , cor      co  ");
    query.append("      , ref_cor  re   ");
    query.append("  WHERE r.cab_cdgo    = c.cab_cdgo ");
    query.append("    AND r.lin_cdgo    = ").append(f.getLin_cdgo());
    query.append("    AND r.ref_cdgo    = ").append(f.getRef_cdgo());
    query.append("    AND co.cor_cdgo   = re.cor_cdgo ");
    query.append("    AND re.lin_cdgo   = r.lin_cdgo ");
    query.append("    AND re.ref_cdgo   = r.ref_cdgo ");
    query.append("    AND re.cab_cdgo   = r.cab_cdgo ");
    query.append("  ORDER BY r.cab_cdgo ");
    query.append("         , co.cor_cdgo ");

    Vector res_Jw_linha_ref_cab_cor = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_linha_ref_cab_cor",res_Jw_linha_ref_cab_cor);
    if (!(res_Jw_linha_ref_cab_cor != null && res_Jw_linha_ref_cab_cor.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref_cab_cor", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
