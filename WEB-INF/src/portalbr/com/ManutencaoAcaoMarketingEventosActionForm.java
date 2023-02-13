package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/05/2010 07:40:36
 * Last Modify Date 02/04/2013 15:32:33
 */

public class ManutencaoAcaoMarketingEventosActionForm extends org.apache.struts.action.ActionForm
{
  public String acao;
  public String cracha_alterar;
  private boolean valida = false;
  public ManutencaoAcaoMarketingEventosActionForm() {
  }
  /**
    * ACAO: Method to get the field value.
    */
  public String getAcao() {
    return acao;
  }
  /**
    * ACAO: Method to set the field value.
    */
  public void setAcao(String PARAM) {
    acao = PARAM;
  }
  /**
    * CRACHA_ALTERAR: Method to get the field value.
    */
  public String getCracha_alterar() {
    return cracha_alterar;
  }
  /**
    * CRACHA_ALTERAR: Method to set the field value.
    */
  public void setCracha_alterar(String PARAM) {
    cracha_alterar = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    acao = null;
    cracha_alterar = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update1_action,trocar_cracha_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
