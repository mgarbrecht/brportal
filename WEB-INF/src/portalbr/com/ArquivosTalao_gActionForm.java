package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/09/2015 11:16:57
 * Last Modify Date 19/07/2022 10:09:15
 */

public class ArquivosTalao_gActionForm extends org.apache.struts.action.ActionForm
{
  public String interface_arq_compra_id;
  public String tipo;
  public String arquivo;
  public String rem_nro;
  public String oco_numero;
  public String forn_codigo;
  private boolean valida = false;
  public ArquivosTalao_gActionForm() {
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Gets para este campo
    */
  public String getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Sets pára este campo.
    */
  public void setInterface_arq_compra_id(String PARAM) {
    interface_arq_compra_id = PARAM;
  }
  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * ARQUIVO: Método Gets para este campo
    */
  public String getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Método Sets pára este campo.
    */
  public void setArquivo(String PARAM) {
    arquivo = PARAM;
  }
  /**
    * REM_NRO: Método Gets para este campo
    */
  public String getRem_nro() {
    return rem_nro;
  }
  /**
    * REM_NRO: Método Sets pára este campo.
    */
  public void setRem_nro(String PARAM) {
    rem_nro = PARAM;
  }
  /**
    * OCO_NUMERO: Método Gets para este campo
    */
  public String getOco_numero() {
    return oco_numero;
  }
  /**
    * OCO_NUMERO: Método Sets pára este campo.
    */
  public void setOco_numero(String PARAM) {
    oco_numero = PARAM;
  }
  /**
    * FORN_CODIGO: Método Gets para este campo
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Método Sets pára este campo.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    interface_arq_compra_id = null;
    tipo = null;
    arquivo = null;
    rem_nro = null;
    oco_numero = null;
    forn_codigo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
