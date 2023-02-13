package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/11/2007 05:07:39
 * Last Modify Date 24/09/2009 09:52:31
 */

public class LvEstadosActionForm extends org.apache.struts.action.ActionForm
{
  public String est_unifed;
  public String return0;
  public String est_descri;
  private boolean valida = false;
  public LvEstadosActionForm() {
  }
  /**
    * EST_UNIFED: Method to get the field value.
    */
  public String getEst_unifed() {
    return est_unifed;
  }
  /**
    * EST_UNIFED: Method to set the field value.
    */
  public void setEst_unifed(String PARAM) {
    est_unifed = PARAM;
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
    * EST_DESCRI: Method to get the field value.
    */
  public String getEst_descri() {
    return est_descri;
  }
  /**
    * EST_DESCRI: Method to set the field value.
    */
  public void setEst_descri(String PARAM) {
    est_descri = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    est_unifed = null;
    return0 = null;
    est_descri = null;
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
