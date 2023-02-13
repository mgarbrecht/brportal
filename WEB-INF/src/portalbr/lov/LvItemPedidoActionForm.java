package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/02/2019 16:17:21
 * Last Modify Date 04/03/2019 16:07:40
 */

public class LvItemPedidoActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String linha;
  public String referencia;
  public String cabedal;
  public String cor;
  public String pedido;
  private boolean valida = false;
  public LvItemPedidoActionForm() {
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
    * LINHA: M�todo Gets para este campo
    */
  public String getLinha() {
    return linha;
  }
  /**
    * LINHA: M�todo Sets p�ra este campo.
    */
  public void setLinha(String PARAM) {
    linha = PARAM;
  }
  /**
    * REFERENCIA: M�todo Gets para este campo
    */
  public String getReferencia() {
    return referencia;
  }
  /**
    * REFERENCIA: M�todo Sets p�ra este campo.
    */
  public void setReferencia(String PARAM) {
    referencia = PARAM;
  }
  /**
    * CABEDAL: M�todo Gets para este campo
    */
  public String getCabedal() {
    return cabedal;
  }
  /**
    * CABEDAL: M�todo Sets p�ra este campo.
    */
  public void setCabedal(String PARAM) {
    cabedal = PARAM;
  }
  /**
    * COR: M�todo Gets para este campo
    */
  public String getCor() {
    return cor;
  }
  /**
    * COR: M�todo Sets p�ra este campo.
    */
  public void setCor(String PARAM) {
    cor = PARAM;
  }
  /**
    * PEDIDO: M�todo Gets para este campo
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: M�todo Sets p�ra este campo.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    linha = null;
    referencia = null;
    cabedal = null;
    cor = null;
    pedido = null;
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
