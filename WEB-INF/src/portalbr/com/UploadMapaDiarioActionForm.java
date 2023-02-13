package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/04/2007 08:30:36
 * Last Modify Date 03/04/2013 13:12:45
 */

import org.apache.struts.upload.FormFile;

public class UploadMapaDiarioActionForm extends org.apache.struts.action.ActionForm
{
  public FormFile arquivo;
  public String observacao;
  private boolean valida = false;
  public UploadMapaDiarioActionForm() {
  }
  /**
    * ARQUIVO: Method to get the field value.
    */
  public FormFile getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Method to set the field value.
    */
  public void setArquivo(FormFile PARAM) {
    arquivo = PARAM;
  }
  /**
    * OBSERVACAO: Method to get the field value.
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Method to set the field value.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    arquivo = null;
    observacao = null;
  }
  /**
    * Validate fields and return errors.
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
