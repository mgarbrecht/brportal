package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/09/2016 11:20:07
 * Last Modify Date 19/07/2022 10:09:20
 */

public class ArquivosTalao_lActionForm extends org.apache.struts.action.ActionForm
{
  public String interface_arq_compra_id;
  public String rem_nro;
  public String oco_numero;
  public String situacao;
  public String data_transacao;
  public String usuario;
  private boolean valida = false;
  public ArquivosTalao_lActionForm() {
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
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * DATA_TRANSACAO: Método Gets para este campo
    */
  public String getData_transacao() {
    return data_transacao;
  }
  /**
    * DATA_TRANSACAO: Método Sets pára este campo.
    */
  public void setData_transacao(String PARAM) {
    data_transacao = PARAM;
  }
  /**
    * USUARIO: Método Gets para este campo
    */
  public String getUsuario() {
    return usuario;
  }
  /**
    * USUARIO: Método Sets pára este campo.
    */
  public void setUsuario(String PARAM) {
    usuario = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    interface_arq_compra_id = null;
    rem_nro = null;
    oco_numero = null;
    situacao = null;
    data_transacao = null;
    usuario = null;
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
