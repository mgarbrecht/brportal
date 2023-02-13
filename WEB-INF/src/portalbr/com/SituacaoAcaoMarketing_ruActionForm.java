package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/12/2010 12:37:16
 * Last Modify Date 03/04/2013 13:10:26
 */

public class SituacaoAcaoMarketing_ruActionForm extends org.apache.struts.action.ActionForm
{
  public String acao;
  public String estagio;
  private boolean valida = false;
  public SituacaoAcaoMarketing_ruActionForm() {
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
    * ESTAGIO: Method to get the field value.
    */
  public String getEstagio() {
    return estagio;
  }
  /**
    * ESTAGIO: Method to set the field value.
    */
  public void setEstagio(String PARAM) {
    estagio = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    acao = null;
    estagio = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("check_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
