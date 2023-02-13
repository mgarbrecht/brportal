package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/06/2006 16:31:45
 * Last Modify Date 27/08/2009 17:05:32
 */

public class NormasVenda_cActionForm extends org.apache.struts.action.ActionForm
{
  public String lidi_marca;
  private boolean valida = false;
  public NormasVenda_cActionForm() {
  }
  /**
    * LIDI_MARCA: Method to get the field value.
    */
  public String getLidi_marca() {
    return lidi_marca;
  }
  /**
    * LIDI_MARCA: Method to set the field value.
    */
  public void setLidi_marca(String PARAM) {
    lidi_marca = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lidi_marca = null;
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
