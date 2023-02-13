package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2013 10:49:01
 * Last Modify Date 09/08/2013 10:55:29
 */

public class LvGrupoMaterialActionForm extends org.apache.struts.action.ActionForm
{
  public String gpo_mater_cdgo;
  public String gpo_mater_desc;
  private boolean valida = false;
  public LvGrupoMaterialActionForm() {
  }
  /**
    * GPO_MATER_CDGO: Method to get the field value.
    */
  public String getGpo_mater_cdgo() {
    return gpo_mater_cdgo;
  }
  /**
    * GPO_MATER_CDGO: Method to set the field value.
    */
  public void setGpo_mater_cdgo(String PARAM) {
    gpo_mater_cdgo = PARAM;
  }
  /**
    * GPO_MATER_DESC: Method to get the field value.
    */
  public String getGpo_mater_desc() {
    return gpo_mater_desc;
  }
  /**
    * GPO_MATER_DESC: Method to set the field value.
    */
  public void setGpo_mater_desc(String PARAM) {
    gpo_mater_desc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gpo_mater_cdgo = null;
    gpo_mater_desc = null;
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
