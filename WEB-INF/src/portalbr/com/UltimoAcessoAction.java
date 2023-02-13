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
 * Creation Date 06/03/2006 15:27:13
 * Last Modify Date 18/12/2014 09:03:43
 */

public class UltimoAcessoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      UltimoAcessoActionForm f = (UltimoAcessoActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    UltimoAcessoActionForm f = (UltimoAcessoActionForm) form;
    portalbr.dbobj.view.Jw_ultimo_acesso table = new portalbr.dbobj.view.Jw_ultimo_acesso();
    String[][] select = null;
    String[] order = {"trunc(data_ultimo) desc,razao"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"cli_situ","=",f.getSituacao()},};
    Vector res_Jw_ultimo_acesso = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_ultimo_acesso",res_Jw_ultimo_acesso);
    if (res_Jw_ultimo_acesso != null && res_Jw_ultimo_acesso.size() > 0) {
      portalbr.dbobj.view.Jw_ultimo_acesso r = (portalbr.dbobj.view.Jw_ultimo_acesso) res_Jw_ultimo_acesso.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      UltimoAcessoActionForm f = (UltimoAcessoActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! javaview: Jw_ultimo_acesso");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

}
