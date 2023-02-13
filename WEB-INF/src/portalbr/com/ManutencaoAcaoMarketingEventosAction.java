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
 * Creation Date 25/05/2010 07:40:36
 * Last Modify Date 02/04/2013 15:32:33
 */

public class ManutencaoAcaoMarketingEventosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    String chave = null;
    acesso.Sessao se = new acesso.Sessao(session);
    String tipo = se.getTipoEntidadeNegocio();
    String coordenador = null;
    if (tipo.equals("AREAS")) {
      chave = se.getUsuario();
      coordenador = query.retorna("SELECT coordenador FROM acao_marketing_usuarios where cracha = "+chave);
      if (coordenador.equals("S")) {
        chave = "";
      }
    }

    Jw_acao_marketing_eventos table = new Jw_acao_marketing_eventos();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"acao","=", com.egen.util.text.FormatNumber.toInt(f.getAcao())}, {"cracha_usuario","=", chave} };
    Vector res_Jw_acao_marketing_eventos = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_marketing_eventos",res_Jw_acao_marketing_eventos);
    if (res_Jw_acao_marketing_eventos != null && res_Jw_acao_marketing_eventos.size() > 0) {
      Jw_acao_marketing_eventos r = (Jw_acao_marketing_eventos) res_Jw_acao_marketing_eventos.elementAt(0);
      session.setAttribute("ManutencaoAcaoMarketingEventosSituacao", r.getSituacao());
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;


      actionForward = new ActionForward("/com/ManutencaoAcaoMarketingForm.do?select_session_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
      actionForward = new ActionForward("/com/ManutencaoAcaoMarketingEventos_iForm.do?select_action=&seq_acao_mkt="+f.getAcao(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_update1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
      String situacaoNova = (String) session.getAttribute("ManutencaoAcaoMarketingEventosSituacao");
      String situacaoOriginal = (String) session.getAttribute("ManutencaoAcaoMarketingEventosSituacaoAnterior");
      if (!(situacaoNova.equals(situacaoOriginal))) {
        update1_action(j, mapping, form, request, response);
      }
      session.removeAttribute("ManutencaoAcaoMarketingEventosSituacao");
      session.removeAttribute("ManutencaoAcaoMarketingEventosSituacaoAnterior");
      actionForward = new ActionForward("/com/ManutencaoAcaoMarketingEventosForm.do?select_action=&acao="+f.getAcao(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    acesso.Sessao se = new acesso.Sessao(session);
    String chave = null;
    String situacaoNova = (String) session.getAttribute("ManutencaoAcaoMarketingEventosSituacao");
    String situacaoOriginal = (String) session.getAttribute("ManutencaoAcaoMarketingEventosSituacaoAnterior");
    String descricaoSituacaoNova = query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+situacaoNova);
    String descricaoSituacaoOriginal = query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+situacaoOriginal);
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("AREAS")) {
      chave = se.getUsuario();
    }
    String emailOrigem = query.retorna("SELECT DISTINCT i.email FROM acao_marketing_eventos i where i.seq_acao_mkt = "+f.getAcao() + " AND cracha_usuario = "+chave);
    String email = query.retorna("SELECT a.email FROM acao_marketing a WHERE a.seq_acao_mkt="+f.getAcao());

    //---- Cadastra novo evento ---------------------
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("INSERT INTO acao_marketing_eventos ");
      sb.append(" VALUES ( "+f.getAcao());
      sb.append("        , (SELECT max(seq_evento)+1 FROM acao_marketing_eventos WHERE seq_acao_mkt = "+f.getAcao() + ") ");
      sb.append("        , '"+emailOrigem + "'  ");
      sb.append("        , 'Alterado o status de "+descricaoSituacaoOriginal + " para "+descricaoSituacaoNova + " pela criação' ");
      sb.append("        , trunc(SYSDATE) ");
      sb.append("        , USER ");
      sb.append("        , NULL, NULL, NULL, NULL, "+chave + ") ");
      //     pstm = j.getConn().prepareStatement(sb.toString());
      //     pstm.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pstm != null) {
        pstm.close();
      }
    }
    //---- Envia Email ------------------------------
    //  Prc_send_email_job r = new Prc_send_email_job();
    //  r.setP_module_name("Ação de Marketing");
    //  r.setP_from(email);
    //  r.setP_to(emailOrigem);
    //  r.setP_subject("Ação de Marketing");
    //  r.setP_message_body(f.getObservacao().replaceAll("\n", "<br>"));
    //  r.setP_message_style("HTML");
    //  r = (Prc_send_email_job) j.execute(r);
    //---- Troca o Status ----------------------------
    Prc_troca_status_acao_mkt rs = new Prc_troca_status_acao_mkt();
    rs.setP_acao_mkt(com.egen.util.text.FormatNumber.parseInt(f.getAcao()));
    rs.setP_status(situacaoNova);
    rs = (Prc_troca_status_acao_mkt) j.execute(rs);
    //------------------------------------------------

    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_trocar_cracha_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
      trocar_cracha_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ManutencaoAcaoMarketingEventosForm.do?select_action=&acao="+f.getAcao(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_eventos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void trocar_cracha_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ManutencaoAcaoMarketingEventosActionForm f = (ManutencaoAcaoMarketingEventosActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    acesso.Sessao se = new acesso.Sessao(session);
    String chave = null;
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("AREAS")) {
      chave = se.getUsuario();
    }
    String email = query.retorna("SELECT email FROM acao_marketing_usuarios  WHERE cracha = "+f.getCracha_alterar() + " AND ROWNUM = 1 ");
    String nome = query.retorna("SELECT nome FROM acao_marketing_usuarios  WHERE cracha = "+f.getCracha_alterar() + " AND ROWNUM = 1 ");
    if (nome.equals("")) {
      throw new Exception(nome);
    }
    //---- Cadastra novo evento ---------------------
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("INSERT INTO acao_marketing_eventos ");
      sb.append(" VALUES ( "+f.getAcao());
      sb.append("        , (SELECT max(seq_evento)+1 FROM acao_marketing_eventos WHERE seq_acao_mkt = "+f.getAcao() + ") ");
      sb.append("        , '"+email + "'  ");
      sb.append("        , 'Alterado o usuário de desenvolvimento para "+f.getCracha_alterar() + "-"+nome + ".'");
      sb.append("        , trunc(SYSDATE) ");
      sb.append("        , USER ");
      sb.append("        , NULL, NULL, NULL, NULL, "+f.getCracha_alterar() + ") ");
      pstm = j.getConn().prepareStatement(sb.toString());
      pstm.executeUpdate();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
}
