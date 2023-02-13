package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/02/2006 12:15:49
 * Last Modify Date 24/01/2017 08:53:32
 */

public class Saldo_estoque_grades_gActionForm extends org.apache.struts.action.ActionForm
{
  public String numero;
  public String quantidade;
  public String emp_empresa;
  public String fil_filial;
  public String unn_codigo;
  public String les_codigo;
  public String tes_codigo;
  public String tco_codigo;
  public String gde_codigo;
  public String lin_cdgo;
  public String ref_cdgo;
  public String cab_cdgo;
  public String cor_cdgo;
  private boolean valida = false;
  public Saldo_estoque_grades_gActionForm() {
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
    * QUANTIDADE: Method to get the field value.
    */
  public String getQuantidade() {
    return quantidade;
  }
  /**
    * QUANTIDADE: Method to set the field value.
    */
  public void setQuantidade(String PARAM) {
    quantidade = PARAM;
  }
  /**
    * EMP_EMPRESA: Method to get the field value.
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Method to set the field value.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * FIL_FILIAL: Method to get the field value.
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Method to set the field value.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * UNN_CODIGO: Method to get the field value.
    */
  public String getUnn_codigo() {
    return unn_codigo;
  }
  /**
    * UNN_CODIGO: Method to set the field value.
    */
  public void setUnn_codigo(String PARAM) {
    unn_codigo = PARAM;
  }
  /**
    * LES_CODIGO: Method to get the field value.
    */
  public String getLes_codigo() {
    return les_codigo;
  }
  /**
    * LES_CODIGO: Method to set the field value.
    */
  public void setLes_codigo(String PARAM) {
    les_codigo = PARAM;
  }
  /**
    * TES_CODIGO: Method to get the field value.
    */
  public String getTes_codigo() {
    return tes_codigo;
  }
  /**
    * TES_CODIGO: Method to set the field value.
    */
  public void setTes_codigo(String PARAM) {
    tes_codigo = PARAM;
  }
  /**
    * TCO_CODIGO: Method to get the field value.
    */
  public String getTco_codigo() {
    return tco_codigo;
  }
  /**
    * TCO_CODIGO: Method to set the field value.
    */
  public void setTco_codigo(String PARAM) {
    tco_codigo = PARAM;
  }
  /**
    * GDE_CODIGO: Method to get the field value.
    */
  public String getGde_codigo() {
    return gde_codigo;
  }
  /**
    * GDE_CODIGO: Method to set the field value.
    */
  public void setGde_codigo(String PARAM) {
    gde_codigo = PARAM;
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
    * CAB_CDGO: Method to get the field value.
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Method to set the field value.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * COR_CDGO: Method to get the field value.
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Method to set the field value.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero = null;
    quantidade = null;
    emp_empresa = null;
    fil_filial = null;
    unn_codigo = null;
    les_codigo = null;
    tes_codigo = null;
    tco_codigo = null;
    gde_codigo = null;
    lin_cdgo = null;
    ref_cdgo = null;
    cab_cdgo = null;
    cor_cdgo = null;
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
