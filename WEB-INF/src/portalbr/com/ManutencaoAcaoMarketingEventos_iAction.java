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
 * Creation Date 25/05/2010 10:18:16
 * Last Modify Date 09/06/2010 09:53:11
 */

public class ManutencaoAcaoMarketingEventos_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingEventos_iActionForm f = (ManutencaoAcaoMarketingEventos_iActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos_i", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ManutencaoAcaoMarketingEventos_iActionForm f = (ManutencaoAcaoMarketingEventos_iActionForm) form;
    String chave = "";
    acesso.Sessao se = new acesso.Sessao(session);
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("AREAS")) {
      chave = se.getUsuario();
    }
    Jw_acao_marketing_eventos_i table = new Jw_acao_marketing_eventos_i();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"seq_acao_mkt","=", com.egen.util.text.FormatNumber.toInt(f.getSeq_acao_mkt())}, {"cracha_usuario","like", chave} };
    Vector res_Jw_acao_marketing_eventos_i = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_marketing_eventos_i",res_Jw_acao_marketing_eventos_i);
    if (res_Jw_acao_marketing_eventos_i != null && res_Jw_acao_marketing_eventos_i.size() > 0) {
      Jw_acao_marketing_eventos_i r = (Jw_acao_marketing_eventos_i) res_Jw_acao_marketing_eventos_i.elementAt(0);
      f.setSeq_acao_mkt(r.getSeq_acao_mkt() + "");
      f.setEmail_origem((r.getEmail_origem() != null) ? r.getEmail_origem() + "":"");
      f.setEmail((r.getEmail() != null) ? r.getEmail() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos_i", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingEventos_iActionForm f = (ManutencaoAcaoMarketingEventos_iActionForm) form;
      insert_action(j, mapping, form, request, response);
      tg_insert_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos_i", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ManutencaoAcaoMarketingEventos_iActionForm f = (ManutencaoAcaoMarketingEventos_iActionForm) form;
    String chave = null;
    acesso.Sessao se = new acesso.Sessao(session);
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("AREAS")) {
      chave = se.getUsuario();
    }
    //---- Cadastra novo evento ---------------------
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("INSERT INTO acao_marketing_eventos ");
      sb.append(" VALUES ( "+f.getSeq_acao_mkt());
      sb.append("        , (SELECT max(seq_evento)+1 FROM acao_marketing_eventos WHERE seq_acao_mkt = "+f.getSeq_acao_mkt() + ") ");
      sb.append("        , '"+f.getEmail() + "'  ");
      sb.append("        , '"+f.getObservacao() + "' ");
      sb.append("        , trunc(SYSDATE) ");
      sb.append("        , USER ");
      sb.append("        , NULL, NULL, NULL, NULL, "+chave + ") ");
      pstm = j.getConn().prepareStatement(sb.toString());
      pstm.executeUpdate();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
    }
    //---- Envia Email ------------------------------
    Prc_send_email_job r = new Prc_send_email_job();
    r.setP_module_name("Ação de Marketing");
    r.setP_from(f.getEmail());
    r.setP_to(f.getEmail_origem());
    r.setP_subject("Ação de Marketing");
    r.setP_message_body("Ação: "+f.getSeq_acao_mkt() + "<br><br>"+f.getObservacao().replaceAll("\n", "<br>"));
    r.setP_message_style("HTML");
    r = (Prc_send_email_job) j.execute(r);
    //---- Troca o Status ----------------------------
    Prc_troca_status_acao_mkt rs = new Prc_troca_status_acao_mkt();
    rs.setP_acao_mkt(com.egen.util.text.FormatNumber.parseInt(f.getSeq_acao_mkt()));
    rs.setP_status("4");
    rs = (Prc_troca_status_acao_mkt) j.execute(rs);
    //------------------------------------------------
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }


  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos_i", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManutencaoAcaoMarketingEventos_iActionForm f = (ManutencaoAcaoMarketingEventos_iActionForm) form;
      session.removeAttribute("res_Jw_acao_marketing_eventos_i");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos_i", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManutencaoAcaoMarketingEventos_iActionForm f = (ManutencaoAcaoMarketingEventos_iActionForm) form;
      actionForward = new ActionForward("/com/ManutencaoAcaoMarketingEventosForm.do?select_action=&acao="+f.getSeq_acao_mkt(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos_i", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
