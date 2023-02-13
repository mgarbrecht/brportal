package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/01/2016 12:10:16
 * Last Modify Date 16/09/2020 18:27:22
 */

public class DownloadImagens_eActionForm extends org.apache.struts.action.ActionForm
{
  public String email;
  private boolean valida = false;
  public DownloadImagens_eActionForm() {
  }
  /**
    * EMAIL: Method to get the field value.
    */
  public String getEmail() {
    return email;
  }
  /**
    * EMAIL: Method to set the field value.
    */
  public void setEmail(String PARAM) {
    email = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    email = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("enviar_email_action,", request)) {
      if (com.egen.util.text.Validate.isNull(email)) {
        errors.add("email", new ActionMessage("error.validate.notnull","Email","email","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(email, "^[A-Za-z0-9_\\-\\.]+@([A-Za-z0-9_\\-]+.){1,3}[a-zA-Z]{2,3}$")) {
        errors.add("email", new ActionMessage("error.validate.regex","Email","email","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
