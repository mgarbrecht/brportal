package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/11/2010 11:38:42
 * Last Modify Date 22/11/2010 11:48:17
 */

public class LvProjetosActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String projeto_cdgo;
  public String projeto_desc;
  private boolean valida = false;
  public LvProjetosActionForm() {
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
    * PROJETO_CDGO: Method to get the field value.
    */
  public String getProjeto_cdgo() {
    return projeto_cdgo;
  }
  /**
    * PROJETO_CDGO: Method to set the field value.
    */
  public void setProjeto_cdgo(String PARAM) {
    projeto_cdgo = PARAM;
  }
  /**
    * PROJETO_DESC: Method to get the field value.
    */
  public String getProjeto_desc() {
    return projeto_desc;
  }
  /**
    * PROJETO_DESC: Method to set the field value.
    */
  public void setProjeto_desc(String PARAM) {
    projeto_desc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    projeto_cdgo = null;
    projeto_desc = null;
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
