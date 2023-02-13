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
 * Creation Date 23/01/2007 15:18:16
 * Last Modify Date 21/09/2009 08:21:43
 */

public class LvClienteRepresentanteAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cliente_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvClienteRepresentanteActionForm f = (LvClienteRepresentanteActionForm) form;
    portalbr.dbobj.view.Jw_cliente_representante table = new portalbr.dbobj.view.Jw_cliente_representante();

    StringBuilder parametros = new StringBuilder();
    if (!f.getCodigo_cliente().equals("")) {
      parametros.append(" AND C.CLI_CDGO = ").append(f.getCodigo_cliente());
    }
    if (!f.getCli_rzao().equals("")) {
      parametros.append(" AND upper(C.CLI_RZAO) like upper('").append(f.getCli_rzao()).append("')");
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        cr.codigo_cliente, ");
    query.append("        c.cli_rzao, ");
    query.append("        cr.codigo_representante, ");
    query.append("        r.rep_rzao ");
    query.append("   FROM cliente_representante cr, ");
    query.append("        rep r, ");
    query.append("        cli c ");
    query.append("  WHERE cr.codigo_representante = r.rep_cdgo ");
    query.append("    AND cr.codigo_cliente       = c.cli_cdgo ");
    query.append("    AND r.rep_situ              = 'A' ");
    query.append("    AND cr.situacao             = 'A' ");
    query.append("    AND cr.codigo_cliente       > 0 ");
    query.append("    AND cr.codigo_representante = ").append(f.getCodigo_representante());
    query.append(parametros.toString());
    Vector res_Jw_cliente_representante = j.select(table, query.toString(), null);
    session.setAttribute("res_Jw_cliente_representante",res_Jw_cliente_representante);
    if (res_Jw_cliente_representante == null || res_Jw_cliente_representante.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cliente_representante", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvClienteRepresentanteActionForm f = (LvClienteRepresentanteActionForm) form;
      session.removeAttribute("res_Jw_cliente_representante");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cliente_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
