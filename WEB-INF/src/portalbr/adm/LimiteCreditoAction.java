package portalbr.adm;

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
 * Creation Date 08/03/2006 13:38:42
 * Last Modify Date 22/06/2015 16:33:45
 */

public class LimiteCreditoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LimiteCreditoActionForm f = (LimiteCreditoActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/adm/LimiteCredito_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LimiteCreditoActionForm f = (LimiteCreditoActionForm) form;
    if ((f.getCodigo_regional() == "") && (f.getRep_cdgo() == "")) {
      throw new Exception("A Regional e/ou o Representante deve(m) ser informado(s)");
    }
    portalbr.dbobj.view.Jw_limite_credito table = new portalbr.dbobj.view.Jw_limite_credito();
    String[][] select = null;
    String[] order = {"codigo_regional","rep_cdgo", "situacao", "cli_rzao", "cli_cdgo" };
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"codigo_regional","=",f.getCodigo_regional()}, {"rep_cdgo","=",f.getRep_cdgo()}, {"situacao","=",f.getSituacao()}, {"situacao_cr","=",f.getSituacao_cr()} };
    Vector res_Jw_limite_credito = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_limite_credito",res_Jw_limite_credito);
    if (!(res_Jw_limite_credito != null && res_Jw_limite_credito.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      LimiteCreditoActionForm f = (LimiteCreditoActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! javaview: Jw_limite_credito");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LimiteCreditoActionForm f = (LimiteCreditoActionForm) form;
      session.removeAttribute("res_Jw_limite_credito");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
