package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/04/2007 08:30:36
 * Last Modify Date 03/04/2013 13:12:30
 */

import org.apache.struts.upload.FormFile;

public class UploadCargaCompletaAFVActionForm extends org.apache.struts.action.ActionForm
{
  public FormFile arquivo;
  private boolean valida = false;
  public UploadCargaCompletaAFVActionForm() {
  }
  /**
    * ARQUIVO: Método Gets para este campo
    */
  public FormFile getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Método Sets pára este campo.
    */
  public void setArquivo(FormFile PARAM) {
    arquivo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    arquivo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("upload_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
