package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/03/2006 15:11:02
 * Last Modify Date 30/11/2017 12:01:08
 */

public class ConsultaPedidos_rActionForm extends org.apache.struts.action.ActionForm
{
  public String situacao;
  public String dt_entrega;
  public String dt_emissao;
  public String marca;
  public String tipo_pedido;
  private boolean valida = false;
  public ConsultaPedidos_rActionForm() {
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
    * DT_ENTREGA: Method to get the field value.
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Method to set the field value.
    */
  public void setDt_entrega(String PARAM) {
    dt_entrega = PARAM;
  }
  /**
    * DT_EMISSAO: Method to get the field value.
    */
  public String getDt_emissao() {
    return dt_emissao;
  }
  /**
    * DT_EMISSAO: Method to set the field value.
    */
  public void setDt_emissao(String PARAM) {
    dt_emissao = PARAM;
  }
  /**
    * MARCA: Method to get the field value.
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Method to set the field value.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  /**
    * TIPO_PEDIDO: Method to get the field value.
    */
  public String getTipo_pedido() {
    return tipo_pedido;
  }
  /**
    * TIPO_PEDIDO: Method to set the field value.
    */
  public void setTipo_pedido(String PARAM) {
    tipo_pedido = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    situacao = null;
    dt_entrega = null;
    dt_emissao = null;
    marca = null;
    tipo_pedido = null;
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
