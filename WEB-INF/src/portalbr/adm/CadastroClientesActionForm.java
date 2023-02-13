package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/04/2006 15:15:12
 * Last Modify Date 02/07/2019 10:47:08
 */

public class CadastroClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String cli_rzao;
  public String cli_nome;
  public String cli_cdgo;
  public String esc_seqn;
  public String esc_cgc;
  public String representante;
  public String regional;
  public String esc_email;
  private boolean valida = false;
  public CadastroClientesActionForm() {
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
    * CLI_NOME: Método Gets para este campo
    */
  public String getCli_nome() {
    return cli_nome;
  }
  /**
    * CLI_NOME: Método Sets pára este campo.
    */
  public void setCli_nome(String PARAM) {
    cli_nome = PARAM;
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
    * ESC_SEQN: Método Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Método Sets pára este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * ESC_CGC: Método Gets para este campo
    */
  public String getEsc_cgc() {
    return esc_cgc;
  }
  /**
    * ESC_CGC: Método Sets pára este campo.
    */
  public void setEsc_cgc(String PARAM) {
    esc_cgc = PARAM;
  }
  /**
    * REPRESENTANTE: Método Gets para este campo
    */
  public String getRepresentante() {
    return representante;
  }
  /**
    * REPRESENTANTE: Método Sets pára este campo.
    */
  public void setRepresentante(String PARAM) {
    representante = PARAM;
  }
  /**
    * REGIONAL: Método Gets para este campo
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Método Sets pára este campo.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * ESC_EMAIL: Método Gets para este campo
    */
  public String getEsc_email() {
    return esc_email;
  }
  /**
    * ESC_EMAIL: Método Sets pára este campo.
    */
  public void setEsc_email(String PARAM) {
    esc_email = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cli_rzao = null;
    cli_nome = null;
    cli_cdgo = null;
    esc_seqn = null;
    esc_cgc = null;
    representante = null;
    regional = null;
    esc_email = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Código","cli_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(esc_seqn)) {
        errors.add("esc_seqn", new ActionMessage("error.validate.number","Seq.","esc_seqn","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
