package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/05/2010 14:33:17
 * Last Modify Date 04/05/2010 14:37:18
 */

public class LvUsuariosLojaActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String cracha;
  public String nome;
  private boolean valida = false;
  public LvUsuariosLojaActionForm() {
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
    * CRACHA: Method to get the field value.
    */
  public String getCracha() {
    return cracha;
  }
  /**
    * CRACHA: Method to set the field value.
    */
  public void setCracha(String PARAM) {
    cracha = PARAM;
  }
  /**
    * NOME: Method to get the field value.
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: Method to set the field value.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    cracha = null;
    nome = null;
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
