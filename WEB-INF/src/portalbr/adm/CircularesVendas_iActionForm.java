package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2006 12:59:50
 * Last Modify Date 01/12/2011 16:08:29
 */

public class CircularesVendas_iActionForm extends org.apache.struts.action.ActionForm
{
  public String numero;
  public String data;
  public String remetente;
  public String destinatario;
  public String assunto;
  public String texto;
  public String status;
  private boolean valida = false;
  public CircularesVendas_iActionForm() {
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
    * STATUS: Method to get the field value.
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Method to set the field value.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
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
    status = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(numero)) {
        errors.add("numero", new ActionMessage("error.validate.notnull","Número","numero","0"));
      }
      if (com.egen.util.text.Validate.isNull(data)) {
        errors.add("data", new ActionMessage("error.validate.notnull","Data","data","0"));
      }
      if (com.egen.util.text.Validate.isNull(remetente)) {
        errors.add("remetente", new ActionMessage("error.validate.notnull","Remetente","remetente","0"));
      }
      if (com.egen.util.text.Validate.isNull(destinatario)) {
        errors.add("destinatario", new ActionMessage("error.validate.notnull","Destinatário","destinatario","0"));
      }
      if (com.egen.util.text.Validate.isNull(assunto)) {
        errors.add("assunto", new ActionMessage("error.validate.notnull","Assunto","assunto","0"));
      }
      if (com.egen.util.text.Validate.isNull(texto)) {
        errors.add("texto", new ActionMessage("error.validate.notnull","Texto","texto","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
