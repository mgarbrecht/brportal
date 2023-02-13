package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2006 10:54:21
 * Last Modify Date 01/12/2011 16:09:27
 */

public class CircularesVendasActionForm extends org.apache.struts.action.ActionForm
{
  public String numero;
  public String data;
  public String remetente;
  public String assunto;
  private boolean valida = false;
  public CircularesVendasActionForm() {
  }
  /**
    * NUMERO: Method to get the field value.
    */
  public String getNumero() {
    return numero;
  }
  /**
    * NUMERO: Method to set the field value.
    */
  public void setNumero(String PARAM) {
    numero = PARAM;
  }
  /**
    * DATA: Method to get the field value.
    */
  public String getData() {
    return data;
  }
  /**
    * DATA: Method to set the field value.
    */
  public void setData(String PARAM) {
    data = PARAM;
  }
  /**
    * REMETENTE: Method to get the field value.
    */
  public String getRemetente() {
    return remetente;
  }
  /**
    * REMETENTE: Method to set the field value.
    */
  public void setRemetente(String PARAM) {
    remetente = PARAM;
  }
  /**
    * ASSUNTO: Method to get the field value.
    */
  public String getAssunto() {
    return assunto;
  }
  /**
    * ASSUNTO: Method to set the field value.
    */
  public void setAssunto(String PARAM) {
    assunto = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero = null;
    data = null;
    remetente = null;
    assunto = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (!com.egen.util.text.Validate.isDate(data)) {
        errors.add("data", new ActionMessage("error.validate.date","Data","data","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
