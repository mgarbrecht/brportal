package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 31/05/2006 12:49:18
 * Last Modify Date 22/02/2008 09:15:14
 */

public class ConsultaPedidos_dActionForm extends org.apache.struts.action.ActionForm
{
  public String rep_cdgo;
  public String ped_nped;
  private boolean valida = false;
  public ConsultaPedidos_dActionForm() {
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * PED_NPED: Method to get the field value.
    */
  public String getPed_nped() {
    return ped_nped;
  }
  /**
    * PED_NPED: Method to set the field value.
    */
  public void setPed_nped(String PARAM) {
    ped_nped = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rep_cdgo = null;
    ped_nped = null;
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
