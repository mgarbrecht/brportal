package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 01/03/2006 10:28:53
 * Last Modify Date 06/11/2009 16:56:43
 */

public class LvCabedalActionForm extends org.apache.struts.action.ActionForm
{
  public String cab_cdgo;
  public String return0;
  public String cab_desc;
  public String lin_cdgo;
  public String ref_cdgo;
  private boolean valida = false;
  public LvCabedalActionForm() {
  }
  /**
    * CAB_CDGO: Method to get the field value.
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Method to set the field value.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
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
    * CAB_DESC: Method to get the field value.
    */
  public String getCab_desc() {
    return cab_desc;
  }
  /**
    * CAB_DESC: Method to set the field value.
    */
  public void setCab_desc(String PARAM) {
    cab_desc = PARAM;
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
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cab_cdgo = null;
    return0 = null;
    cab_desc = null;
    lin_cdgo = null;
    ref_cdgo = null;
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
