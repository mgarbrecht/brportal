package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/10/2012 12:08:13
 * Last Modify Date 01/03/2013 16:28:12
 */

public class FichaCliente_ifActionForm extends org.apache.struts.action.ActionForm
{
  public String limite;
  public String saldo;
  public String paresPedLiberados;
  public String valorPedLiberados;
  public String paresPedNaoLiberados;
  public String valorPedNaoLiberados;
  public String valorVencido;
  public String diasVencido;
  private boolean valida = false;
  public FichaCliente_ifActionForm() {
  }
  /**
    * LIMITE: Method to get the field value.
    */
  public String getLimite() {
    return limite;
  }
  /**
    * LIMITE: Method to set the field value.
    */
  public void setLimite(String PARAM) {
    limite = PARAM;
  }
  /**
    * SALDO: Method to get the field value.
    */
  public String getSaldo() {
    return saldo;
  }
  /**
    * SALDO: Method to set the field value.
    */
  public void setSaldo(String PARAM) {
    saldo = PARAM;
  }
  /**
    * PARESPEDLIBERADOS: Method to get the field value.
    */
  public String getParesPedLiberados() {
    return paresPedLiberados;
  }
  /**
    * PARESPEDLIBERADOS: Method to set the field value.
    */
  public void setParesPedLiberados(String PARAM) {
    paresPedLiberados = PARAM;
  }
  /**
    * VALORPEDLIBERADOS: Method to get the field value.
    */
  public String getValorPedLiberados() {
    return valorPedLiberados;
  }
  /**
    * VALORPEDLIBERADOS: Method to set the field value.
    */
  public void setValorPedLiberados(String PARAM) {
    valorPedLiberados = PARAM;
  }
  /**
    * PARESPEDNAOLIBERADOS: Method to get the field value.
    */
  public String getParesPedNaoLiberados() {
    return paresPedNaoLiberados;
  }
  /**
    * PARESPEDNAOLIBERADOS: Method to set the field value.
    */
  public void setParesPedNaoLiberados(String PARAM) {
    paresPedNaoLiberados = PARAM;
  }
  /**
    * VALORPEDNAOLIBERADOS: Method to get the field value.
    */
  public String getValorPedNaoLiberados() {
    return valorPedNaoLiberados;
  }
  /**
    * VALORPEDNAOLIBERADOS: Method to set the field value.
    */
  public void setValorPedNaoLiberados(String PARAM) {
    valorPedNaoLiberados = PARAM;
  }
  /**
    * VALORVENCIDO: Method to get the field value.
    */
  public String getValorVencido() {
    return valorVencido;
  }
  /**
    * VALORVENCIDO: Method to set the field value.
    */
  public void setValorVencido(String PARAM) {
    valorVencido = PARAM;
  }
  /**
    * DIASVENCIDO: Method to get the field value.
    */
  public String getDiasVencido() {
    return diasVencido;
  }
  /**
    * DIASVENCIDO: Method to set the field value.
    */
  public void setDiasVencido(String PARAM) {
    diasVencido = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    limite = null;
    saldo = null;
    paresPedLiberados = null;
    valorPedLiberados = null;
    paresPedNaoLiberados = null;
    valorPedNaoLiberados = null;
    valorVencido = null;
    diasVencido = null;
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
