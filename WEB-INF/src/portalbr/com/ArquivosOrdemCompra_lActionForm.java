package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/09/2016 11:20:55
 * Last Modify Date 18/07/2022 16:24:32
 */

public class ArquivosOrdemCompra_lActionForm extends org.apache.struts.action.ActionForm
{
  public String interface_arq_compra_id;
  public String oco_numero;
  public String situacao;
  public String data_transacao;
  public String usuario;
  private boolean valida = false;
  public ArquivosOrdemCompra_lActionForm() {
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Method to get the field value.
    */
  public String getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Method to set the field value.
    */
  public void setInterface_arq_compra_id(String PARAM) {
    interface_arq_compra_id = PARAM;
  }
  /**
    * OCO_NUMERO: Method to get the field value.
    */
  public String getOco_numero() {
    return oco_numero;
  }
  /**
    * OCO_NUMERO: Method to set the field value.
    */
  public void setOco_numero(String PARAM) {
    oco_numero = PARAM;
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * DATA_TRANSACAO: Method to get the field value.
    */
  public String getData_transacao() {
    return data_transacao;
  }
  /**
    * DATA_TRANSACAO: Method to set the field value.
    */
  public void setData_transacao(String PARAM) {
    data_transacao = PARAM;
  }
  /**
    * USUARIO: Method to get the field value.
    */
  public String getUsuario() {
    return usuario;
  }
  /**
    * USUARIO: Method to set the field value.
    */
  public void setUsuario(String PARAM) {
    usuario = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    interface_arq_compra_id = null;
    oco_numero = null;
    situacao = null;
    data_transacao = null;
    usuario = null;
  }
  /**
    * Validate fields and return errors.
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
