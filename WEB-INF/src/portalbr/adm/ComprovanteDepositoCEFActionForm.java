package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/11/2010 05:44:39
 * Last Modify Date 22/06/2015 15:29:42
 */

public class ComprovanteDepositoCEFActionForm extends org.apache.struts.action.ActionForm
{
  public String data_inicial;
  public String data_final;
  public String nr_bordero;
  private boolean valida = false;
  public ComprovanteDepositoCEFActionForm() {
  }
  /**
    * DATA_INICIAL: Method to get the field value.
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Method to set the field value.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Method to get the field value.
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Method to set the field value.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * NR_BORDERO: Method to get the field value.
    */
  public String getNr_bordero() {
    return nr_bordero;
  }
  /**
    * NR_BORDERO: Method to set the field value.
    */
  public void setNr_bordero(String PARAM) {
    nr_bordero = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    data_inicial = null;
    data_final = null;
    nr_bordero = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.notnull","Data Inicial","data_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.notnull","Data Final","data_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
