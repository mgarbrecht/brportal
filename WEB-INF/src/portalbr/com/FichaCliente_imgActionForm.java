package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/03/2013 16:55:58
 * Last Modify Date 02/04/2013 15:17:37
 */

public class FichaCliente_imgActionForm extends org.apache.struts.action.ActionForm
{
  public String linha;
  public String referencia;
  private boolean valida = false;
  public FichaCliente_imgActionForm() {
  }
  /**
    * LINHA: Method to get the field value.
    */
  public String getLinha() {
    return linha;
  }
  /**
    * LINHA: Method to set the field value.
    */
  public void setLinha(String PARAM) {
    linha = PARAM;
  }
  /**
    * REFERENCIA: Method to get the field value.
    */
  public String getReferencia() {
    return referencia;
  }
  /**
    * REFERENCIA: Method to set the field value.
    */
  public void setReferencia(String PARAM) {
    referencia = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    linha = null;
    referencia = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
