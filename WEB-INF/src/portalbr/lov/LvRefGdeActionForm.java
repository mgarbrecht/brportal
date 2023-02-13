package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/09/2010 07:10:48
 * Last Modify Date 10/09/2010 08:56:21
 */

public class LvRefGdeActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String grade;
  public String linha;
  public String referencia;
  private boolean valida = false;
  public LvRefGdeActionForm() {
  }
  /**
    * RETURN0: Method to get the field value.
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Method to set the field value.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * GRADE: Method to get the field value.
    */
  public String getGrade() {
    return grade;
  }
  /**
    * GRADE: Method to set the field value.
    */
  public void setGrade(String PARAM) {
    grade = PARAM;
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
    return0 = null;
    grade = null;
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
