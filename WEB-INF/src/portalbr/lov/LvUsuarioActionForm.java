package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/02/2006 10:45:56
 * Last Modify Date 12/02/2016 08:06:44
 */

public class LvUsuarioActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String usua_usuario;
  public String usua_nome;
  private boolean valida = false;
  public LvUsuarioActionForm() {
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
    * USUA_NOME: Method to get the field value.
    */
  public String getUsua_nome() {
    return usua_nome;
  }
  /**
    * USUA_NOME: Method to set the field value.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    usua_usuario = null;
    usua_nome = null;
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
