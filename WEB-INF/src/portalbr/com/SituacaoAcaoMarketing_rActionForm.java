package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/12/2010 12:37:16
 * Last Modify Date 03/04/2013 13:10:10
 */

public class SituacaoAcaoMarketing_rActionForm extends org.apache.struts.action.ActionForm
{
  public String acao;
  public String estagio;
  private boolean valida = false;
  public SituacaoAcaoMarketing_rActionForm() {
  }
  /**
    * ACAO: Método Gets para este campo
    */
  public String getAcao() {
    return acao;
  }
  /**
    * ACAO: Método Sets pára este campo.
    */
  public void setAcao(String PARAM) {
    acao = PARAM;
  }
  /**
    * ESTAGIO: Método Gets para este campo
    */
  public String getEstagio() {
    return estagio;
  }
  /**
    * ESTAGIO: Método Sets pára este campo.
    */
  public void setEstagio(String PARAM) {
    estagio = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    acao = null;
    estagio = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
