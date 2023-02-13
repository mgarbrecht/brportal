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
 * Creation Date 04/04/2007 08:30:36
 * Last Modify Date 03/04/2013 13:12:30
 */

public class UploadCargaCompletaAFVAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      UploadCargaCompletaAFVActionForm f = (UploadCargaCompletaAFVActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
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

  public ActionForward perform_upload_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        util.consultas.Parametros parametros = new util.consultas.Parametros();
        UploadCargaCompletaAFVActionForm f = (UploadCargaCompletaAFVActionForm) form;
        if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
          String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_afv");
          realPath2bl_form = realPath2bl_form + java.io.File.separator;
          org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
          java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
          java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + inputfile2bl_form.getFileName());
          int bytesRead2bl_form = 0;
          byte[] buffer2bl_form = new byte[8192];
          while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
            bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
          }
          bos2bl_form.close();
          stream2bl_form.close();
        }
        tg_upload_action(mapping, form, request, response);
      } catch (Exception e) {} finally {}
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
  private void tg_upload_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
