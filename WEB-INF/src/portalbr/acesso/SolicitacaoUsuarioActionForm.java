package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2017 15:01:27
 * Last Modify Date 31/08/2017 14:47:08
 */

public class SolicitacaoUsuarioActionForm extends org.apache.struts.action.ActionForm
{
  public String cnpj;
  public String email;
  public String sucesso;
  private boolean valida = false;
  public SolicitacaoUsuarioActionForm() {
  }
  /**
    * CNPJ: Method to get the field value.
    */
  public String getCnpj() {
    return cnpj;
  }
  /**
    * CNPJ: Method to set the field value.
    */
  public void setCnpj(String PARAM) {
    cnpj = PARAM;
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
    * SUCESSO: Method to get the field value.
    */
  public String getSucesso() {
    return sucesso;
  }
  /**
    * SUCESSO: Method to set the field value.
    */
  public void setSucesso(String PARAM) {
    sucesso = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cnpj = null;
    email = null;
    sucesso = null;
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
