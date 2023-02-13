package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/11/2010 12:04:34
 * Last Modify Date 24/11/2010 10:53:47
 */

public class LvFmaActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String fma_cdgo;
  public String fma_base;
  private boolean valida = false;
  public LvFmaActionForm() {
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
    * FMA_CDGO: Method to get the field value.
    */
  public String getFma_cdgo() {
    return fma_cdgo;
  }
  /**
    * FMA_CDGO: Method to set the field value.
    */
  public void setFma_cdgo(String PARAM) {
    fma_cdgo = PARAM;
  }
  /**
    * FMA_BASE: Method to get the field value.
    */
  public String getFma_base() {
    return fma_base;
  }
  /**
    * FMA_BASE: Method to set the field value.
    */
  public void setFma_base(String PARAM) {
    fma_base = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    fma_cdgo = null;
    fma_base = null;
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
