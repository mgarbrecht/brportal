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
 * Creation Date 11/03/2011 10:17:19
 * Last Modify Date 03/04/2013 13:05:16
 */

public class SolicitacaoMailing_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailing_iActionForm f = (SolicitacaoMailing_iActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoMailing_iActionForm f = (SolicitacaoMailing_iActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    //--------------------------
    if (f.getListas_selecionadas().equals("")) {
      throw new Exception("Informação obrigatória");
    }
    //--------------------------
    String dataOk = query.retorna(j, "SELECT 1 FROM dual WHERE to_date('"+f.getData_envio() + "','dd/mm/yyyy') > TRUNC(sysdate)");
    if (!dataOk.equals("1")) {
      throw new Exception("A data de envio deve ser maior que a data atual");
    }
    String seq = query.retorna(j, "SELECT brio.id_solicitacao_mailing_seq.nextval FROM dual");
    //--------------------------
    Acao_mkt_solic_mailing table = new Acao_mkt_solic_mailing();
    Object[][] name_value = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInt(seq)}, {"data_envio",com.egen.util.text.FormatDate.parseTimestamp(f.getData_envio(), "dd/MM/yyyy")}, {"assunto",f.getAssunto()}, {"nome_arquivo",util.text.Caracteres.removerAcentos(f.getNome_arquivo().getFileName())}, {"situacao",f.getSituacao()}, {"email_retorno",f.getEmail_retorno()}, {"observacoes",f.getObservacoes()} };
    j.insert(table, name_value);
    //--------- UPLOAD ----------------------
    if (f.getNome_arquivo() != null && f.getNome_arquivo().toString() != null && f.getNome_arquivo().toString().length() > 0) {
      String realPath2bl_form = request.getRealPath("/") + "arquivos/mailing" + java.io.File.separator;
      realPath2bl_form = realPath2bl_form + java.io.File.separator;
      org.apache.struts.upload.FormFile inputfile2bl_form = f.getNome_arquivo();
      java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
      java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + seq + "_" + util.text.Caracteres.removerAcentos(inputfile2bl_form.getFileName()));
      int bytesRead2bl_form = 0;
      byte[] buffer2bl_form = new byte[8192];
      while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
        bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
      }
      bos2bl_form.close();
      stream2bl_form.close();
    }

    //------- LISTAS ----------------------
    String[] listas = f.getListas_selecionadas().trim().split(" ");
    for (int x = 0; x < listas.length; x++) {
      query.execute("insert into brio.acao_mkt_solic_listas values ("+seq + ","+listas[x] + ")");
    }
    //-------------------------------------
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }

  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoMailing_iActionForm f = (SolicitacaoMailing_iActionForm) form;
      session.removeAttribute("res_Acao_mkt_solic_mailing");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoMailing_iActionForm f = (SolicitacaoMailing_iActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoMailingForm.jsp",true);
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
}
