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
 * Creation Date 09/03/2011 15:57:48
 * Last Modify Date 22/06/2015 15:34:10
 */

public class SolicitacaoMailingAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailingActionForm f = (SolicitacaoMailingActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/SolicitacaoMailing_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SolicitacaoMailingActionForm f = (SolicitacaoMailingActionForm) form;
    Jw_acao_mkt_solic_mailing table = new Jw_acao_mkt_solic_mailing();
    String[][] select = null;
    String[] order = {"id_solicitacao desc"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"data_envio",">=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_envio(), "dd/MM/yyyy")}, {"data_envio","<=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_envio_final(), "dd/MM/yyyy")}, {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInt(f.getId_solicitacao())}, {"situacao","like", f.getSituacao()}, {"observacoes","like", f.getObservacoes()}, {"assunto","like", f.getAssunto()} };
    session.setAttribute("where", where);
    Vector res_Jw_acao_mkt_solic_mailing = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_mkt_solic_mailing",res_Jw_acao_mkt_solic_mailing);
    if (!(res_Jw_acao_mkt_solic_mailing != null && res_Jw_acao_mkt_solic_mailing.size() > 0)) {
      throw new Exception("Nenhum registro encontrado");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoMailingActionForm f = (SolicitacaoMailingActionForm) form;
      session.removeAttribute("res_Jw_acao_mkt_solic_mailing");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailingActionForm f = (SolicitacaoMailingActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoMailing_iForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_select_session_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailingActionForm f = (SolicitacaoMailingActionForm) form;
      try {
        select_session_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/SolicitacaoMailing_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_session_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoMailingActionForm f = (SolicitacaoMailingActionForm) form;
    Jw_acao_mkt_solic_mailing table = new Jw_acao_mkt_solic_mailing();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = (Object[][]) session.getAttribute("where");
    Vector res_Jw_acao_mkt_solic_mailing = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_mkt_solic_mailing",res_Jw_acao_mkt_solic_mailing);
    if (!(res_Jw_acao_mkt_solic_mailing != null && res_Jw_acao_mkt_solic_mailing.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_solic_mailing", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
