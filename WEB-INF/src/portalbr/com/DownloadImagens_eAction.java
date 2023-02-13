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
 * Creation Date 21/01/2016 12:10:16
 * Last Modify Date 16/09/2020 18:27:22
 */

public class DownloadImagens_eAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_enviar_email_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DownloadImagens_eActionForm f = (DownloadImagens_eActionForm) form;
      util.consultas.com.DownloadImagens downloadImagens = new util.consultas.com.DownloadImagens();
      String arquivo = downloadImagens.processar(request);
      acesso.Sessao sessao = new acesso.Sessao(session);
      if (arquivo != null) {
        org.apache.commons.mail.MultiPartEmail mpemail = new org.apache.commons.mail.MultiPartEmail();
        org.apache.commons.mail.EmailAttachment attachment = new org.apache.commons.mail.EmailAttachment();
        String nomeArquivo = arquivo.replace("../temp/","");
        arquivo = arquivo.replace("../temp/", "/opt/tomcat/webapps/brportal/temp/");
        attachment.setPath(arquivo);
        attachment.setDisposition(org.apache.commons.mail.EmailAttachment.ATTACHMENT);
        attachment.setDescription("Download de imagens");
        attachment.setName(nomeArquivo);
        mpemail.setHostName("10.0.1.189");
        mpemail.setSmtpPort(25);
        mpemail.addTo(f.getEmail(), f.getEmail());
        mpemail.setFrom("no-reply@beirario.com.br", "BR Portal");
        mpemail.setSubject("Download de imagens");
        mpemail.setMsg("Imagens enviadas por " + sessao.getUsuario());
        mpemail.attach(attachment);
        mpemail.setAuthentication("estategicos", "beirario*123");
        mpemail.send();
      }
      try {
        tg_enviar_email_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_enviar_email_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
