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
 * Creation Date 06/02/2014 13:53:43
 * Last Modify Date 26/02/2014 13:29:39
 */

public class UploadArquivos_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      insert_action(j, mapping, form, request, response);
      tg_insert_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    UploadArquivos_iActionForm f = (UploadArquivos_iActionForm) form;
    if (f.getArq() != null && f.getArq().equals("")) {
      throw new Exception("O arquivo deve ser informado!");
    }
    String id = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;

    util.consultas.Sequence sequence = new util.consultas.Sequence();
    id = sequence.nextValue("links_dinamicos","lidi_id") + "";

    util.consultas.Parametros parametros = new util.consultas.Parametros();
    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
      String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_manuais");
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


    portalbr.dbobj.table.Links_dinamicos table = new portalbr.dbobj.table.Links_dinamicos();
    table.setLidi_id(com.egen.util.text.FormatNumber.parseInt(id));
    table.setLidi_titulo(f.getLidi_titulo());
    table.setLidi_tipo(f.getLidi_tipo());
    table.setLidi_marca(Integer.parseInt(f.getLidi_marca()));
    table.setLidi_caminho(f.getArquivo() + "");
    table.setLidi_descricao(f.getLidi_descricao());
    if (!f.getLidi_tien_id().equals("")) {
      if (f.getLidi_tien_id().indexOf("#") != -1) {
        table.setLidi_enne_id(Integer.parseInt(f.getLidi_tien_id().replace("#","")));
      } else {
        table.setLidi_tien_id(Integer.parseInt(f.getLidi_tien_id()));
      }
    }
    j.insert(table);
    Vector res_Links_dinamicos = (Vector) session.getAttribute("res_Links_dinamicos");
    if (res_Links_dinamicos != null && table != null) {
      res_Links_dinamicos.addElement(table);
      session.setAttribute("res_Links_dinamicos", res_Links_dinamicos);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      UploadArquivos_iActionForm f = (UploadArquivos_iActionForm) form;
      session.removeAttribute("res_Links_dinamicos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      UploadArquivos_iActionForm f = (UploadArquivos_iActionForm) form;


      actionForward = new ActionForward("/adm/UploadArquivosForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
