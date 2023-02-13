package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 30/11/2010 06:58:22
 * Last Modify Date 30/11/2010 07:24:43
 */

public class EntPedidosAvisoErroActionForm extends org.apache.struts.action.ActionForm
{
  public String numero_pedido;
  public String numero_item;
  public String descricao_erro;
  private boolean valida = false;
  public EntPedidosAvisoErroActionForm() {
  }
  /**
    * NUMERO_PEDIDO: Method to get the field value.
    */
  public String getNumero_pedido() {
    return numero_pedido;
  }
  /**
    * NUMERO_PEDIDO: Method to set the field value.
    */
  public void setNumero_pedido(String PARAM) {
    numero_pedido = PARAM;
  }
  /**
    * NUMERO_ITEM: Method to get the field value.
    */
  public String getNumero_item() {
    return numero_item;
  }
  /**
    * NUMERO_ITEM: Method to set the field value.
    */
  public void setNumero_item(String PARAM) {
    numero_item = PARAM;
  }
  /**
    * DESCRICAO_ERRO: Method to get the field value.
    */
  public String getDescricao_erro() {
    return descricao_erro;
  }
  /**
    * DESCRICAO_ERRO: Method to set the field value.
    */
  public void setDescricao_erro(String PARAM) {
    descricao_erro = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero_pedido = null;
    numero_item = null;
    descricao_erro = null;
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
