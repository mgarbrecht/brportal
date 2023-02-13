package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/09/2010 12:01:07
 * Last Modify Date 18/10/2010 09:55:18
 */

public class LvLinExp0400ActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String lin_nome;
  private boolean valida = false;
  public LvLinExp0400ActionForm() {
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_NOME: Method to get the field value.
    */
  public String getLin_nome() {
    return lin_nome;
  }
  /**
    * LIN_NOME: Method to set the field value.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    lin_nome = null;
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
