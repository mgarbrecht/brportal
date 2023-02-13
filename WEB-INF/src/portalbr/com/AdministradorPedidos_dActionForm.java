package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/04/2006 14:23:12
 * Last Modify Date 19/10/2012 13:03:13
 */

public class AdministradorPedidos_dActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String linha;
  public String lin_nome;
  public String data;
  public String prev;
  public String dt;
  public String ref_cdgo;
  private boolean valida = false;
  public AdministradorPedidos_dActionForm() {
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LINHA: Method to get the field value.
    */
  public String getLinha() {
    return linha;
  }
  /**
    * LINHA: Method to set the field value.
    */
  public void setLinha(String PARAM) {
    linha = PARAM;
  }
  /**
    * LIN_NOME: Method to get the field value.
    */
  public String getLin_nome() {
    return lin_nome;
  }
  /**
    * LIN_NOME: Method to set the field value.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
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
    * PREV: Method to get the field value.
    */
  public String getPrev() {
    return prev;
  }
  /**
    * PREV: Method to set the field value.
    */
  public void setPrev(String PARAM) {
    prev = PARAM;
  }
  /**
    * DT: Method to get the field value.
    */
  public String getDt() {
    return dt;
  }
  /**
    * DT: Method to set the field value.
    */
  public void setDt(String PARAM) {
    dt = PARAM;
  }
  /**
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    linha = null;
    lin_nome = null;
    data = null;
    prev = null;
    dt = null;
    ref_cdgo = null;
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
