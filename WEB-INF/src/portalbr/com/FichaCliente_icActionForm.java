package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 01/10/2012 14:59:35
 * Last Modify Date 04/10/2012 13:08:43
 */

public class FichaCliente_icActionForm extends org.apache.struts.action.ActionForm
{
  public String informacoes;
  private boolean valida = false;
  public FichaCliente_icActionForm() {
  }
  /**
    * INFORMACOES: Method to get the field value.
    */
  public String getInformacoes() {
    return informacoes;
  }
  /**
    * INFORMACOES: Method to set the field value.
    */
  public void setInformacoes(String PARAM) {
    informacoes = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    informacoes = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(informacoes)) {
        errors.add("informacoes", new ActionMessage("error.validate.notnull","Informações","informacoes","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
