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
    * USERNAME: Método Gets para este campo
    */
  public String getUsername() {
    return username;
  }
  /**
    * USERNAME: Método Sets pára este campo.
    */
  public void setUsername(String PARAM) {
    username = PARAM;
  }
  /**
    * PASSWORD: Método Gets para este campo
    */
  public String getPassword() {
    return password;
  }
  /**
    * PASSWORD: Método Sets pára este campo.
    */
  public void setPassword(String PARAM) {
    password = PARAM;
  }
  /**
    * LANGUAGE: Método Gets para este campo
    */
  public String getLanguage() {
    return language;
  }
  /**
    * LANGUAGE: Método Sets pára este campo.
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
    * Validação dos campos, retornando um ActionErrors.
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
