package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/08/2015 09:23:57
 * Last Modify Date 18/07/2022 16:24:26
 */

public class ArquivosOrdemCompra_gActionForm extends org.apache.struts.action.ActionForm
{
  public String interface_arq_compra_id;
  public String tipo;
  public String arquivo;
  public String oco_numero;
  public String forn_codigo;
  private boolean valida = false;
  public ArquivosOrdemCompra_gActionForm() {
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
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * ARQUIVO: Method to get the field value.
    */
  public String getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Method to set the field value.
    */
  public void setArquivo(String PARAM) {
    arquivo = PARAM;
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
    * FORN_CODIGO: Method to get the field value.
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Method to set the field value.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    interface_arq_compra_id = null;
    tipo = null;
    arquivo = null;
    oco_numero = null;
    forn_codigo = null;
  }
  /**
    * Validate fields and return errors.
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
