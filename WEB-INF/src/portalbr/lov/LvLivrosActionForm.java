package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/04/2012 09:03:07
 * Last Modify Date 02/04/2012 09:37:58
 */

public class LvLivrosActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String liv_codigo;
  public String liv_descri;
  private boolean valida = false;
  public LvLivrosActionForm() {
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
    * LIV_CODIGO: Method to get the field value.
    */
  public String getLiv_codigo() {
    return liv_codigo;
  }
  /**
    * LIV_CODIGO: Method to set the field value.
    */
  public void setLiv_codigo(String PARAM) {
    liv_codigo = PARAM;
  }
  /**
    * LIV_DESCRI: Method to get the field value.
    */
  public String getLiv_descri() {
    return liv_descri;
  }
  /**
    * LIV_DESCRI: Method to set the field value.
    */
  public void setLiv_descri(String PARAM) {
    liv_descri = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    liv_codigo = null;
    liv_descri = null;
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
