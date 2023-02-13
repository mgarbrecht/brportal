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
 * Creation Date 04/04/2006 13:58:26
 * Last Modify Date 18/12/2014 09:05:18
 */

public class UltimoAcessoAnalistaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      UltimoAcessoAnalistaActionForm f = (UltimoAcessoAnalistaActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso_analista", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    UltimoAcessoAnalistaActionForm f = (UltimoAcessoAnalistaActionForm) form;
    portalbr.dbobj.view.Jw_ultimo_acesso_analista table = new portalbr.dbobj.view.Jw_ultimo_acesso_analista();
    String[][] select = null;
    String[] order = {"divisao_gerente","data_ultimo_acesso desc"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"rep_situ","=",f.getSituacao()},};
    Vector res_Jw_ultimo_acesso_analista = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_ultimo_acesso_analista",res_Jw_ultimo_acesso_analista);
    if (res_Jw_ultimo_acesso_analista != null && res_Jw_ultimo_acesso_analista.size() > 0) {
      portalbr.dbobj.view.Jw_ultimo_acesso_analista r = (portalbr.dbobj.view.Jw_ultimo_acesso_analista) res_Jw_ultimo_acesso_analista.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso_analista", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      UltimoAcessoAnalistaActionForm f = (UltimoAcessoAnalistaActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! javaview: Jw_ultimo_acesso_analista");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

}
