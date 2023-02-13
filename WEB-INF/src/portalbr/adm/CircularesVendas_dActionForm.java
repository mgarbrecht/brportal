package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2006 12:03:19
 * Last Modify Date 27/08/2009 16:36:01
 */

public class CircularesVendas_dActionForm extends org.apache.struts.action.ActionForm
{
  public String numero;
  public String data;
  public String remetente;
  public String destinatario;
  public String assunto;
  public String texto;
  private boolean valida = false;
  public CircularesVendas_dActionForm() {
  }
  /**
    * NUMERO: Method to get the field value.
    */
  public String getNumero() {
    return numero;
  }
  /**
    * NUMERO: Method to set the field value.
    */
  public void setNumero(String PARAM) {
    numero = PARAM;
  }
  /**
    * DATA: Method to get the field value.
    */
  public String getData() {
    return data;
  }
  /**
    * DATA: Method to set the field value.
    */
  public void setData(String PARAM) {
    data = PARAM;
  }
  /**
    * REMETENTE: Method to get the field value.
    */
  public String getRemetente() {
    return remetente;
  }
  /**
    * REMETENTE: Method to set the field value.
    */
  public void setRemetente(String PARAM) {
    remetente = PARAM;
  }
  /**
    * DESTINATARIO: Method to get the field value.
    */
  public String getDestinatario() {
    return destinatario;
  }
  /**
    * DESTINATARIO: Method to set the field value.
    */
  public void setDestinatario(String PARAM) {
    destinatario = PARAM;
  }
  Vector destinatarioList = new Vector(10, 1);
  public java.util.Vector getDestinatarioList() {
    if (destinatarioList == null || destinatarioList.size() == 0) {
      destinatarioList.addElement("1");
      destinatarioLabelList.addElement("Todos");
      destinatarioList.addElement("2");
      destinatarioLabelList.addElement("Representantes Riva Bianca");
      destinatarioList.addElement("3");
      destinatarioLabelList.addElement("Representantes Vizzano");
      destinatarioList.addElement("4");
      destinatarioLabelList.addElement("Analistas e Repres. Riva Bianca");
      destinatarioList.addElement("5");
      destinatarioLabelList.addElement("Todos Representantes");
      destinatarioList.addElement("6");
      destinatarioLabelList.addElement("Analistas Regionais de Vendas");
      destinatarioList.addElement("7");
      destinatarioLabelList.addElement("Analistas e Repres. Beira Rio");
      destinatarioList.addElement("8");
      destinatarioLabelList.addElement("Analistas e Repres. Vizzano");
    }
    java.util.Vector list = destinatarioList;
    return list;
  }
  java.util.Vector destinatarioLabelList = new Vector(10, 1);
  public java.util.Vector getDestinatarioLabelList() {
    java.util.Vector list = destinatarioLabelList;
    return list;
  }
  /**
    * ASSUNTO: Method to get the field value.
    */
  public String getAssunto() {
    return assunto;
  }
  /**
    * ASSUNTO: Method to set the field value.
    */
  public void setAssunto(String PARAM) {
    assunto = PARAM;
  }
  /**
    * TEXTO: Method to get the field value.
    */
  public String getTexto() {
    return texto;
  }
  /**
    * TEXTO: Method to set the field value.
    */
  public void setTexto(String PARAM) {
    texto = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero = null;
    data = null;
    remetente = null;
    destinatario = null;
    assunto = null;
    texto = null;
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
