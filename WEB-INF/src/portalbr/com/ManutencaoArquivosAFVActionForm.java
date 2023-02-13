package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/04/2007 15:11:16
 * Last Modify Date 27/08/2009 17:03:10
 */

public class ManutencaoArquivosAFVActionForm extends org.apache.struts.action.ActionForm
{
  public String arq;
  private boolean valida = false;
  public ManutencaoArquivosAFVActionForm() {
  }
  /**
    * ARQ: Method to get the field value.
    */
  public String getArq() {
    return arq;
  }
  /**
    * ARQ: Method to set the field value.
    */
  public void setArq(String PARAM) {
    arq = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    arq = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("delete_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
