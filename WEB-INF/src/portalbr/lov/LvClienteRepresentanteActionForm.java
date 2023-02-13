package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/01/2007 15:18:16
 * Last Modify Date 21/09/2009 08:21:43
 */

public class LvClienteRepresentanteActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_cliente;
  public String return0;
  public String cli_rzao;
  public String codigo_representante;
  private boolean valida = false;
  public LvClienteRepresentanteActionForm() {
  }
  /**
    * CODIGO_CLIENTE: M�todo Gets para este campo
    */
  public String getCodigo_cliente() {
    return codigo_cliente;
  }
  /**
    * CODIGO_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setCodigo_cliente(String PARAM) {
    codigo_cliente = PARAM;
  }
  /**
    * RETURN0: M�todo Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: M�todo Sets p�ra este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * CLI_RZAO: M�todo Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: M�todo Sets p�ra este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * CODIGO_REPRESENTANTE: M�todo Gets para este campo
    */
  public String getCodigo_representante() {
    return codigo_representante;
  }
  /**
    * CODIGO_REPRESENTANTE: M�todo Sets p�ra este campo.
    */
  public void setCodigo_representante(String PARAM) {
    codigo_representante = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_cliente = null;
    return0 = null;
    cli_rzao = null;
    codigo_representante = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
