package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/10/2012 13:10:06
 * Last Modify Date 19/10/2012 15:38:21
 */

public class AdministradorPedidos_rsActionForm extends org.apache.struts.action.ActionForm
{
  public String quebra;
  private boolean valida = false;
  public AdministradorPedidos_rsActionForm() {
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
