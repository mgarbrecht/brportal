package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/08/2006 15:48:36
 * Last Modify Date 05/07/2019 18:42:04
 */

public class DirectActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_usuario;
  public String usua_id;
  public String usua_senha;
  public String usua_tipo;
  private boolean valida = false;
  public DirectActionForm() {
  }
  /**
    * USUA_USUARIO: Method to get the field value.
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: Method to set the field value.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_ID: Method to get the field value.
    */
  public String getUsua_id() {
    return usua_id;
  }
  /**
    * USUA_ID: Method to set the field value.
    */
  public void setUsua_id(String PARAM) {
    usua_id = PARAM;
  }
  /**
    * USUA_SENHA: Method to get the field value.
    */
  public String getUsua_senha() {
    return usua_senha;
  }
  /**
    * USUA_SENHA: Method to set the field value.
    */
  public void setUsua_senha(String PARAM) {
    usua_senha = PARAM;
  }
  /**
    * USUA_TIPO: Method to get the field value.
    */
  public String getUsua_tipo() {
    return usua_tipo;
  }
  /**
    * USUA_TIPO: Method to set the field value.
    */
  public void setUsua_tipo(String PARAM) {
    usua_tipo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_usuario = null;
    usua_id = null;
    usua_senha = null;
    usua_tipo = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
