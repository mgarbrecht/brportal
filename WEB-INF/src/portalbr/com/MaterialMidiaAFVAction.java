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
 * Creation Date 27/10/2011 14:09:40
 * Last Modify Date 02/04/2013 17:26:22
 */

public class MaterialMidiaAFVAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_blank_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MaterialMidiaAFVActionForm f = (MaterialMidiaAFVActionForm) form;

      //---------------------------------------------------------------------------
      if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
        util.consultas.Parametros parametros = new util.consultas.Parametros();
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

        //--- Executa o FTP ---
        //	util.file.Ftp ftp = new util.file.Ftp();
        //	ftp.enviar((realPath2bl_form + inputfile2bl_form.getFileName()), f.getMarca(), f.getTipo_arquivo(), f.getCodtipomarketing(), f.getTitulo(), f.getDescricao());

        //--- Exclui ----
        java.io.File fdelete = new java.io.File(realPath2bl_form + inputfile2bl_form.getFileName());
        if (fdelete.isFile()) {
          fdelete.delete();
        }
        //---------------
        tg_blank_action(mapping, form, request, response);
      } else {
        throw new Exception("O arquivo precisa ser informado!");
      }
      //---------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_afv_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_blank_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_afv_marketing", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MaterialMidiaAFVActionForm f = (MaterialMidiaAFVActionForm) form;
      session.removeAttribute("res_Jw_afv_marketing");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_afv_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
