package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/11/2010 08:33:38
 * Last Modify Date 23/11/2010 08:38:58
 */

public class LvComponenteDetalheActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String cmp_cdgo;
  public String cmp_desc;
  private boolean valida = false;
  public LvComponenteDetalheActionForm() {
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
    * CMP_CDGO: Method to get the field value.
    */
  public String getCmp_cdgo() {
    return cmp_cdgo;
  }
  /**
    * CMP_CDGO: Method to set the field value.
    */
  public void setCmp_cdgo(String PARAM) {
    cmp_cdgo = PARAM;
  }
  /**
    * CMP_DESC: Method to get the field value.
    */
  public String getCmp_desc() {
    return cmp_desc;
  }
  /**
    * CMP_DESC: Method to set the field value.
    */
  public void setCmp_desc(String PARAM) {
    cmp_desc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    cmp_cdgo = null;
    cmp_desc = null;
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
