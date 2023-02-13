package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/03/2006 17:45:59
 * Last Modify Date 03/04/2013 13:04:13
 */

public class VendasPrincipais_rActionForm extends org.apache.struts.action.ActionForm
{
  public String quebra;
  private boolean valida = false;
  public VendasPrincipais_rActionForm() {
  }
  /**
    * QUEBRA: Method to get the field value.
    */
  public String getQuebra() {
    return quebra;
  }
  /**
    * QUEBRA: Method to set the field value.
    */
  public void setQuebra(String PARAM) {
    quebra = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    quebra = null;
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
