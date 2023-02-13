package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/02/2006 13:19:16
 * Last Modify Date 15/08/2019 11:46:38
 */

public class LvClienteActionForm extends org.apache.struts.action.ActionForm
{
  public String cli_cdgo;
  public String return0;
  public String cli_rzao;
  public String cli_cdgo_sessao;
  public String cli_rzao_sessao;
  private boolean valida = false;
  public LvClienteActionForm() {
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * RETURN0: Método Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Método Sets pára este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * CLI_CDGO_SESSAO: Método Gets para este campo
    */
  public String getCli_cdgo_sessao() {
    return cli_cdgo_sessao;
  }
  /**
    * CLI_CDGO_SESSAO: Método Sets pára este campo.
    */
  public void setCli_cdgo_sessao(String PARAM) {
    cli_cdgo_sessao = PARAM;
  }
  /**
    * CLI_RZAO_SESSAO: Método Gets para este campo
    */
  public String getCli_rzao_sessao() {
    return cli_rzao_sessao;
  }
  /**
    * CLI_RZAO_SESSAO: Método Sets pára este campo.
    */
  public void setCli_rzao_sessao(String PARAM) {
    cli_rzao_sessao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cli_cdgo = null;
    return0 = null;
    cli_rzao = null;
    cli_cdgo_sessao = null;
    cli_rzao_sessao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
