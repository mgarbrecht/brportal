package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2006 15:57:03
 * Last Modify Date 21/09/2009 08:28:57
 */

public class LvTipoEntidadeNegocioActionForm extends org.apache.struts.action.ActionForm
{
  public String tien_id;
  public String return0;
  public String tien_tipo;
  private boolean valida = false;
  public LvTipoEntidadeNegocioActionForm() {
  }
  /**
    * TIEN_ID: Method to get the field value.
    */
  public String getTien_id() {
    return tien_id;
  }
  /**
    * TIEN_ID: Method to set the field value.
    */
  public void setTien_id(String PARAM) {
    tien_id = PARAM;
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
    * TIEN_TIPO: Method to get the field value.
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Method to set the field value.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tien_id = null;
    return0 = null;
    tien_tipo = null;
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
