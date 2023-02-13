package portalbr.system;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/11/2004 16:59:51
 * Last Modify Date 16/01/2015 15:27:10
 */

public class LogonActionForm extends org.apache.struts.action.ActionForm
{
  public String username;
  public String password;
  public String language;
  private boolean valida = false;
  public LogonActionForm() {
  }
  /**
    * USERNAME: M�todo Gets para este campo
    */
  public String getUsername() {
    return username;
  }
  /**
    * USERNAME: M�todo Sets p�ra este campo.
    */
  public void setUsername(String PARAM) {
    username = PARAM;
  }
  /**
    * PASSWORD: M�todo Gets para este campo
    */
  public String getPassword() {
    return password;
  }
  /**
    * PASSWORD: M�todo Sets p�ra este campo.
    */
  public void setPassword(String PARAM) {
    password = PARAM;
  }
  /**
    * LANGUAGE: M�todo Gets para este campo
    */
  public String getLanguage() {
    return language;
  }
  /**
    * LANGUAGE: M�todo Sets p�ra este campo.
    */
  public void setLanguage(String PARAM) {
    language = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    username = null;
    password = null;
    language = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("mostra_query_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      request.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
