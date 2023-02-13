package portalbr.com;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;

/**
 * Creation Date 08/09/2006 15:12:36
 * Last Modify Date 12/09/2006 13:32:17
 */

public class FilialLinhasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/FilialLinhas_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionError("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FilialLinhasActionForm f = (FilialLinhasActionForm) form;
    portalbr.dbobj.view.Jw_filial_linhas table = new portalbr.dbobj.view.Jw_filial_linhas();
    String[][] select = null;
    String[] order = {"lin_codigo","ref_codigo"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"Lin_codigo","=", com.egen.util.text.FormatNumber.toInt(f.getLin_cdgo())}, {"Ref_codigo","=", com.egen.util.text.FormatNumber.toInt(f.getRef_cdgo())} };
    Vector res_Jw_filial_linhas = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_filial_linhas",res_Jw_filial_linhas);
    if (!(res_Jw_filial_linhas != null && res_Jw_filial_linhas.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.removeAttribute("res_Filial_linhas");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionError("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
