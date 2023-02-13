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
 * Creation Date 22/09/2016 11:20:07
 * Last Modify Date 19/07/2022 10:09:20
 */

public class ArquivosTalao_lAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ArquivosTalao_lActionForm f = (ArquivosTalao_lActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interface_arq_compra_tal_log", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosTalao_lActionForm f = (ArquivosTalao_lActionForm) form;
    Interface_arq_compra_tal_log table = new Interface_arq_compra_tal_log();
    String[][] select = null;
    String[] order = {"decode(situacao,'P',1,'C',2,'G',3,'V',4) desc"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"interface_arq_compra_id","=", com.egen.util.text.FormatNumber.toInteger(f.getInterface_arq_compra_id())}, {"rem_nro","=", com.egen.util.text.FormatNumber.toInteger(f.getRem_nro())}, {"oco_numero","=", com.egen.util.text.FormatNumber.toInteger(f.getOco_numero())}, {"situacao","like", f.getSituacao()}, {"data_transacao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_transacao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario","like", f.getUsuario()} };
    Vector res_Interface_arq_compra_tal_log = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Interface_arq_compra_tal_log",res_Interface_arq_compra_tal_log);
    if (!(res_Interface_arq_compra_tal_log != null && res_Interface_arq_compra_tal_log.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interface_arq_compra_tal_log", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ArquivosTalao_lActionForm f = (ArquivosTalao_lActionForm) form;
      session.removeAttribute("res_Interface_arq_compra_tal_log");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Interface_arq_compra_tal_log", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
