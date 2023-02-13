package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/07/2010 10:24:02
 * Last Modify Date 16/07/2010 10:29:18
 */

public class LvAcaoMarketingUsuariosActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String cracha;
  public String nome;
  private boolean valida = false;
  public LvAcaoMarketingUsuariosActionForm() {
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
