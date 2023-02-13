package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/11/2005 09:08:41
 * Last Modify Date 02/04/2013 17:25:18
 */

public class NecessidadeLiquidaPDFActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  private boolean valida = false;
  public NecessidadeLiquidaPDFActionForm() {
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
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
