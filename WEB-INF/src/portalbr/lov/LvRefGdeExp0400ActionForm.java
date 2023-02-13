package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/09/2010 12:52:32
 * Last Modify Date 29/11/2010 13:51:02
 */

public class LvRefGdeExp0400ActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String gde_cdgo;
  public String lin_cdgo;
  public String ref_cdgo;
  public String codigo_corrug;
  private boolean valida = false;
  public LvRefGdeExp0400ActionForm() {
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
    * GDE_CDGO: Method to get the field value.
    */
  public String getGde_cdgo() {
    return gde_cdgo;
  }
  /**
    * GDE_CDGO: Method to set the field value.
    */
  public void setGde_cdgo(String PARAM) {
    gde_cdgo = PARAM;
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
    * CODIGO_CORRUG: Method to get the field value.
    */
  public String getCodigo_corrug() {
    return codigo_corrug;
  }
  /**
    * CODIGO_CORRUG: Method to set the field value.
    */
  public void setCodigo_corrug(String PARAM) {
    codigo_corrug = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    gde_cdgo = null;
    lin_cdgo = null;
    ref_cdgo = null;
    codigo_corrug = null;
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
