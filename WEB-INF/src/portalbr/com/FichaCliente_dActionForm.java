package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 29/09/2011 12:44:24
 * Last Modify Date 19/03/2014 08:59:44
 */

public class FichaCliente_dActionForm extends org.apache.struts.action.ActionForm
{
  public String cli_cdgo;
  public String esc_seqn;
  public String gre_grupo;
  public String valor_utilizado;
  public String valor_disponivel;
  private boolean valida = false;
  public FichaCliente_dActionForm() {
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
    * GRE_GRUPO: Método Gets para este campo
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Método Sets pára este campo.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * VALOR_UTILIZADO: Método Gets para este campo
    */
  public String getValor_utilizado() {
    return valor_utilizado;
  }
  /**
    * VALOR_UTILIZADO: Método Sets pára este campo.
    */
  public void setValor_utilizado(String PARAM) {
    valor_utilizado = PARAM;
  }
  /**
    * VALOR_DISPONIVEL: Método Gets para este campo
    */
  public String getValor_disponivel() {
    return valor_disponivel;
  }
  /**
    * VALOR_DISPONIVEL: Método Sets pára este campo.
    */
  public void setValor_disponivel(String PARAM) {
    valor_disponivel = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cli_cdgo = null;
    esc_seqn = null;
    gre_grupo = null;
    valor_utilizado = null;
    valor_disponivel = null;
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
