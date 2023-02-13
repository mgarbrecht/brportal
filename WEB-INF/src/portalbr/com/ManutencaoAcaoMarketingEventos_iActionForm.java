package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/05/2010 10:18:16
 * Last Modify Date 09/06/2010 09:53:11
 */

public class ManutencaoAcaoMarketingEventos_iActionForm extends org.apache.struts.action.ActionForm
{
  public String seq_acao_mkt;
  public String email_origem;
  public String email;
  public String observacao;
  private boolean valida = false;
  public ManutencaoAcaoMarketingEventos_iActionForm() {
  }
  /**
    * SEQ_ACAO_MKT: Method to get the field value.
    */
  public String getSeq_acao_mkt() {
    return seq_acao_mkt;
  }
  /**
    * SEQ_ACAO_MKT: Method to set the field value.
    */
  public void setSeq_acao_mkt(String PARAM) {
    seq_acao_mkt = PARAM;
  }
  /**
    * EMAIL_ORIGEM: Method to get the field value.
    */
  public String getEmail_origem() {
    return email_origem;
  }
  /**
    * EMAIL_ORIGEM: Method to set the field value.
    */
  public void setEmail_origem(String PARAM) {
    email_origem = PARAM;
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
    * OBSERVACAO: Method to get the field value.
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Method to set the field value.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    seq_acao_mkt = null;
    email_origem = null;
    email = null;
    observacao = null;
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
      if (com.egen.util.text.Validate.isNull(observacao)) {
        errors.add("observacao", new ActionMessage("error.validate.notnull","Observação","observacao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
