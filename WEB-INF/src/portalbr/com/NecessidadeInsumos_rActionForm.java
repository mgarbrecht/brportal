package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 30/09/2015 15:51:21
 * Last Modify Date 02/02/2016 12:09:28
 */

public class NecessidadeInsumos_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String numero;
  public String data_compra;
  public String emp_empresa;
  public String fil_filial;
  public String unn_codigo;
  public String forn_codigo;
  public String fen_seq;
  public String cpg_codigo;
  public String com_codigo;
  public String situacao;
  public String tra_cdgo;
  public String forn_razsoc;
  private boolean valida = false;
  public NecessidadeInsumos_rActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
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
    * DATA_COMPRA: Method to get the field value.
    */
  public String getData_compra() {
    return data_compra;
  }
  /**
    * DATA_COMPRA: Method to set the field value.
    */
  public void setData_compra(String PARAM) {
    data_compra = PARAM;
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
    * FEN_SEQ: Method to get the field value.
    */
  public String getFen_seq() {
    return fen_seq;
  }
  /**
    * FEN_SEQ: Method to set the field value.
    */
  public void setFen_seq(String PARAM) {
    fen_seq = PARAM;
  }
  /**
    * CPG_CODIGO: Method to get the field value.
    */
  public String getCpg_codigo() {
    return cpg_codigo;
  }
  /**
    * CPG_CODIGO: Method to set the field value.
    */
  public void setCpg_codigo(String PARAM) {
    cpg_codigo = PARAM;
  }
  /**
    * COM_CODIGO: Method to get the field value.
    */
  public String getCom_codigo() {
    return com_codigo;
  }
  /**
    * COM_CODIGO: Method to set the field value.
    */
  public void setCom_codigo(String PARAM) {
    com_codigo = PARAM;
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
    * TRA_CDGO: Method to get the field value.
    */
  public String getTra_cdgo() {
    return tra_cdgo;
  }
  /**
    * TRA_CDGO: Method to set the field value.
    */
  public void setTra_cdgo(String PARAM) {
    tra_cdgo = PARAM;
  }
  /**
    * FORN_RAZSOC: Method to get the field value.
    */
  public String getForn_razsoc() {
    return forn_razsoc;
  }
  /**
    * FORN_RAZSOC: Method to set the field value.
    */
  public void setForn_razsoc(String PARAM) {
    forn_razsoc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    numero = null;
    data_compra = null;
    emp_empresa = null;
    fil_filial = null;
    unn_codigo = null;
    forn_codigo = null;
    fen_seq = null;
    cpg_codigo = null;
    com_codigo = null;
    situacao = null;
    tra_cdgo = null;
    forn_razsoc = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
