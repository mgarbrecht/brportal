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
 * Creation Date 18/09/2012 08:21:59
 * Last Modify Date 10/02/2014 12:05:33
 */

public class ConsultaNotaFiscal_oAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaNotaFiscal_oActionForm f = (ConsultaNotaFiscal_oActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_conhecimentos_fretes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaNotaFiscal_oActionForm f = (ConsultaNotaFiscal_oActionForm) form;
    Jw_conhecimentos_fretes table = new Jw_conhecimentos_fretes();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"emp_empresa","=", f.getEmp_empresa()}, {"fil_filial","=", f.getFil_filial()}, {"nfs_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getNfs_nmro())}, {"nfs_serie","=", f.getNfs_serie()} };
    Vector res_Jw_conhecimentos_fretes = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_conhecimentos_fretes",res_Jw_conhecimentos_fretes);
    if (!(res_Jw_conhecimentos_fretes != null && res_Jw_conhecimentos_fretes.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_conhecimentos_fretes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
