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
 * Creation Date 28/06/2006 08:23:57
 * Last Modify Date 16/09/2009 14:10:51
 */

public class PlusClientes_rAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes_sequenciais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusClientes_rActionForm f = (PlusClientes_rActionForm) form;
    portalbr.dbobj.view.Jw_plus_clientes_sequenciais table = new portalbr.dbobj.view.Jw_plus_clientes_sequenciais();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT distinct a.cli_cdgo || '-' || b.esc_seqn codigo ");
    query.append("      , cli_rzao razao_social ");
    query.append("      , c.ecl_cdad ||'-'|| c.est_unifed cidade_uf ");
    query.append("      , b.esc_seqn seqn ");
    query.append("      , b.cli_cdgo cod ");
    query.append("   FROM brio.cli a ");
    query.append("      , brio.esc b ");
    query.append("      , brio.ecl c ");
    query.append("      , cliente_representante cr ");
    query.append("  WHERE a.cli_cdgo = ").append(f.getCod());
    query.append("    AND b.esc_seqn = c.esc_seqn ");
    query.append("    AND a.cli_cdgo = b.cli_cdgo ");
    query.append("    AND b.cli_cdgo = c.cli_cdgo ");
    query.append("    AND (c.ned_cdgo = 'UNI' or c.ned_cdgo = 'ENT') ");
    query.append("    AND cr.codigo_cliente    = a.cli_cdgo ");
    query.append("    AND cr.codigo_sequencial = b.esc_seqn ");
    query.append("  ORDER BY seqn");

    Vector res_Jw_plus_clientes_sequenciais = j.select(table, query.toString(), null);
    session.setAttribute("res_Jw_plus_clientes_sequenciais",res_Jw_plus_clientes_sequenciais);
    if (!(res_Jw_plus_clientes_sequenciais != null && res_Jw_plus_clientes_sequenciais.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes_sequenciais", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/com/PlusClientesForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes_sequenciais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
