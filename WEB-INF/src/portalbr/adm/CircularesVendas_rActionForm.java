package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2006 11:18:26
 * Last Modify Date 27/08/2009 16:34:28
 */

public class CircularesVendas_rActionForm extends org.apache.struts.action.ActionForm
{
  public String numero;
  public String pos;
  private boolean valida = false;
  public CircularesVendas_rActionForm() {
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
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero = null;
    pos = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
