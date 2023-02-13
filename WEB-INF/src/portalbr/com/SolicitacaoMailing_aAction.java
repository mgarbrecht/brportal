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
 * Creation Date 11/03/2011 11:24:29
 * Last Modify Date 03/04/2013 13:05:44
 */

public class SolicitacaoMailing_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
    Acao_mkt_solic_mailing table = new Acao_mkt_solic_mailing();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInt(f.getId_solicitacao())}, {"data_envio","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_envio(), "dd/MM/yyyy")}, {"assunto","like", f.getAssunto()}, {"email_retorno","like", f.getEmail_retorno()}, {"situacao","like", f.getSituacao()}, {"observacoes","like", f.getObservacoes()}, };
    Vector res_Acao_mkt_solic_mailing = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Acao_mkt_solic_mailing",res_Acao_mkt_solic_mailing);
    if (res_Acao_mkt_solic_mailing != null && res_Acao_mkt_solic_mailing.size() > 0) {
      Acao_mkt_solic_mailing r = (Acao_mkt_solic_mailing) res_Acao_mkt_solic_mailing.elementAt(0);
      f.setId_solicitacao(r.getId_solicitacao() + "");
      f.setData_envio(com.egen.util.text.FormatDate.format(r.getData_envio(), "dd/MM/yyyy"));
      f.setAssunto((r.getAssunto() != null) ? r.getAssunto() + "":"");
      f.setEmail_retorno((r.getEmail_retorno() != null) ? r.getEmail_retorno() + "":"");
      f.setNome_arquivo((r.getNome_arquivo() != null) ? r.getNome_arquivo() + "":"");
      f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
      f.setSituacao_desc((r.getSituacao() != null) ? r.getSituacao() + "":"");
      f.setObservacoes((r.getObservacoes() != null) ? r.getObservacoes() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
      try {
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
    Acao_mkt_solic_mailing table = new Acao_mkt_solic_mailing();
    //--------------------------
    if (f.getListas_selecionadas().equals("")) {
      throw new Exception("Informação obrigatória");
    }
    //--------- UPLOAD ----------------------
    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
      String realPath2bl_form = request.getRealPath("/") + "arquivos/mailing" + java.io.File.separator;
      realPath2bl_form = realPath2bl_form + java.io.File.separator;
      org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
      java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
      java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + f.getId_solicitacao() + "_" + inputfile2bl_form.getFileName());
      int bytesRead2bl_form = 0;
      byte[] buffer2bl_form = new byte[8192];
      while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
        bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
      }
      bos2bl_form.close();
      stream2bl_form.close();
      f.setNome_arquivo(inputfile2bl_form.getFileName());
    }

    //-------------------------------------

    Vector sets = new Vector(10, 2);
    table.setId_solicitacao(com.egen.util.text.FormatNumber.parseInt(f.getId_solicitacao()));
    if (f.getId_solicitacao() != null) {
      sets.addElement("id_solicitacao");
    }
    table.setData_envio(com.egen.util.text.FormatDate.parseTimestamp(f.getData_envio(), "dd/MM/yyyy"));
    if (f.getData_envio() != null) {
      sets.addElement("data_envio");
    }
    table.setAssunto(f.getAssunto());
    if (f.getAssunto() != null) {
      sets.addElement("assunto");
    }
    table.setEmail_retorno(f.getEmail_retorno());
    if (f.getEmail_retorno() != null) {
      sets.addElement("email_retorno");
    }
    table.setNome_arquivo(f.getNome_arquivo());
    if (f.getNome_arquivo() != null) {
      sets.addElement("nome_arquivo");
    }

    table.setSituacao(f.getSituacao());
    if (f.getSituacao() != null) {
      sets.addElement("situacao");
    }
    table.setObservacoes(f.getObservacoes());
    if (f.getObservacoes() != null) {
      sets.addElement("observacoes");
    }
    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      int updated = j.update(table, set);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_Acao_mkt_solic_mailing = (Vector) session.getAttribute("res_Acao_mkt_solic_mailing");
        if (res_Acao_mkt_solic_mailing != null) {
          res_Acao_mkt_solic_mailing.setElementAt(table, 0);
          Acao_mkt_solic_mailing r = (Acao_mkt_solic_mailing) res_Acao_mkt_solic_mailing.elementAt(0);
          f.setId_solicitacao(r.getId_solicitacao() + "");
          f.setData_envio(com.egen.util.text.FormatDate.format(r.getData_envio(), "dd/MM/yyyy"));
          f.setAssunto((r.getAssunto() != null) ? r.getAssunto() + "":"");
          f.setEmail_retorno((r.getEmail_retorno() != null) ? r.getEmail_retorno() + "":"");
          f.setNome_arquivo((r.getNome_arquivo() != null) ? r.getNome_arquivo() + "":"");
          f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
          f.setSituacao_desc((r.getSituacao() != null) ? r.getSituacao() + "":"");
          f.setObservacoes((r.getObservacoes() != null) ? r.getObservacoes() + "":"");
        }
      }
    }
    //------- LISTAS ----------------------
    util.consultas.Query query = new util.consultas.Query();
    query.execute("delete brio.acao_mkt_solic_listas where id_solicitacao = " + f.getId_solicitacao());
    String[] listas = f.getListas_selecionadas().trim().split(" ");
    for (int x = 0; x < listas.length; x++) {
      query.execute("insert into brio.acao_mkt_solic_listas values ("+f.getId_solicitacao() + ","+listas[x] + ")");
    }
    //-------------------------------------
    if (f.getSituacao().equals("S")) {
      query.execute("UPDATE brio.acao_mkt_solic_mailing SET data_encerramento = NULL WHERE id_solicitacao = "+f.getId_solicitacao());
    }
    //-------------------------------------
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
        tg_delete_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/SolicitacaoMailingForm.do?select_session_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    util.consultas.Query query = new util.consultas.Query();
    Acao_mkt_solic_mailing table = new Acao_mkt_solic_mailing();
    table.setId_solicitacao(com.egen.util.text.FormatNumber.parseInt(f.getId_solicitacao()));
    table.setData_envio(com.egen.util.text.FormatDate.parseTimestamp(f.getData_envio(), "dd/MM/yyyy"));
    table.setAssunto(f.getAssunto());
    table.setEmail_retorno(f.getEmail_retorno());
    table.setNome_arquivo(f.getNome_arquivo());
    table.setSituacao(f.getSituacao());
    table.setObservacoes(f.getObservacoes());
    j.delete(table);
    //---Exclui o arquivo ----------
    if (!f.getNome_arquivo().equals("")) {
      java.io.File arquivo = new java.io.File(parametros.retornaParametro("diretorio_arquivos_mailing") + f.getId_solicitacao() + "_"+f.getNome_arquivo());
      if (arquivo.exists()) {
        arquivo.delete();
      }
    }
    //------------------------------
    query.execute(j, "DELETE acao_mkt_solic_listas WHERE id_solicitacao = "+f.getId_solicitacao());
    //------------------------------
    Vector res_Acao_mkt_solic_mailing = (Vector) session.getAttribute("res_Acao_mkt_solic_mailing");
    if (res_Acao_mkt_solic_mailing != null && res_Acao_mkt_solic_mailing.size() > 0) {
      res_Acao_mkt_solic_mailing.removeElementAt(0);
      if (res_Acao_mkt_solic_mailing.size() > 0) {
        Acao_mkt_solic_mailing r = (Acao_mkt_solic_mailing) res_Acao_mkt_solic_mailing.elementAt(0);
        f.setId_solicitacao(r.getId_solicitacao() + "");
        f.setData_envio(com.egen.util.text.FormatDate.format(r.getData_envio(), "dd/MM/yyyy"));
        f.setAssunto((r.getAssunto() != null) ? r.getAssunto() + "":"");
        f.setEmail_retorno((r.getEmail_retorno() != null) ? r.getEmail_retorno() + "":"");
        f.setNome_arquivo((r.getNome_arquivo() != null) ? r.getNome_arquivo() + "":"");
        f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
        f.setObservacoes((r.getObservacoes() != null) ? r.getObservacoes() + "":"");
      } else {
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoMailingForm.do?select_session_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_remover_arquivo_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoMailing_aActionForm f = (SolicitacaoMailing_aActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      //---Exclui o arquivo ----------
      if (!f.getNome_arquivo().equals("")) {
        java.io.File arquivo = new java.io.File(parametros.retornaParametro("diretorio_arquivos_mailing") + f.getId_solicitacao() + "_"+f.getNome_arquivo());
        if (arquivo.exists()) {
          arquivo.delete();
        }
      }
      query.execute("UPDATE brio.acao_mkt_solic_mailing SET nome_arquivo = NULL WHERE id_solicitacao = "+f.getId_solicitacao());
      f.setNome_arquivo("");
      //------------------------------
      tg_remover_arquivo_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  private void tg_remover_arquivo_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
