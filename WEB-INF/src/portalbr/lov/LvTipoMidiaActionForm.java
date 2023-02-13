package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/05/2010 16:22:16
 * Last Modify Date 25/05/2010 07:41:24
 */

public class LvTipoMidiaActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String cdgo_tmidia;
  public String desc_tmidia;
  private boolean valida = false;
  public LvTipoMidiaActionForm() {
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
    * CDGO_TMIDIA: Method to get the field value.
    */
  public String getCdgo_tmidia() {
    return cdgo_tmidia;
  }
  /**
    * CDGO_TMIDIA: Method to set the field value.
    */
  public void setCdgo_tmidia(String PARAM) {
    cdgo_tmidia = PARAM;
  }
  /**
    * DESC_TMIDIA: Method to get the field value.
    */
  public String getDesc_tmidia() {
    return desc_tmidia;
  }
  /**
    * DESC_TMIDIA: Method to set the field value.
    */
  public void setDesc_tmidia(String PARAM) {
    desc_tmidia = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    cdgo_tmidia = null;
    desc_tmidia = null;
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
