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
 * Creation Date 14/01/2015 12:29:10
 * Last Modify Date 09/02/2015 10:39:45
 */

public class LvFornecedorQuarterizadoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvFornecedorQuarterizadoActionForm f = (LvFornecedorQuarterizadoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvFornecedorQuarterizadoActionForm f = (LvFornecedorQuarterizadoActionForm) form;
    For_endere_quarterizado table = new For_endere_quarterizado();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"for_codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getFo_codigo())}, {"for_codigo_quarterizado","=", com.egen.util.text.FormatNumber.toInteger(f.getFo_codigo_quarterizado())}, {"fen_seq_quarterizado","=", com.egen.util.text.FormatNumber.toInteger(f.getFen_seq_quarterizado())}, {"for_razsoc","like", f.getFo_razsoc().toUpperCase()}, {"fen_cgc_quarterizado","=", com.egen.util.text.FormatNumber.toDouble(f.getFen_cgc_quarterizado())} };
    Vector res_For_endere_quarterizado = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_For_endere_quarterizado",res_For_endere_quarterizado);
    if (res_For_endere_quarterizado == null || res_For_endere_quarterizado.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvFornecedorQuarterizadoActionForm f = (LvFornecedorQuarterizadoActionForm) form;
      session.removeAttribute("res_For_endere_quarterizado");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
