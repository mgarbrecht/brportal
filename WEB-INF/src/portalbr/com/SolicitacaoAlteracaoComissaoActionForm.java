package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/01/2012 17:15:54
 * Last Modify Date 30/05/2018 16:42:00
 */

public class SolicitacaoAlteracaoComissaoActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String nfs_nmro;
  public String nfs_serie;
  public String emp_empresa;
  public String fil_filial;
  public String nro_dias_prorrogacao;
  public String valor_calculado;
  public String data_solicitacao;
  public String usuario_solicitacao;
  public String situacao;
  public String data_aprovacao;
  public String usuario_aprovacao;
  private boolean valida = false;
  public SolicitacaoAlteracaoComissaoActionForm() {
  }
  /**
    * ID_SOLICITACAO: Method to get the field value.
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Method to set the field value.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * NFS_NMRO: Method to get the field value.
    */
  public String getNfs_nmro() {
    return nfs_nmro;
  }
  /**
    * NFS_NMRO: Method to set the field value.
    */
  public void setNfs_nmro(String PARAM) {
    nfs_nmro = PARAM;
  }
  /**
    * NFS_SERIE: Method to get the field value.
    */
  public String getNfs_serie() {
    return nfs_serie;
  }
  /**
    * NFS_SERIE: Method to set the field value.
    */
  public void setNfs_serie(String PARAM) {
    nfs_serie = PARAM;
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
    * NRO_DIAS_PRORROGACAO: Method to get the field value.
    */
  public String getNro_dias_prorrogacao() {
    return nro_dias_prorrogacao;
  }
  /**
    * NRO_DIAS_PRORROGACAO: Method to set the field value.
    */
  public void setNro_dias_prorrogacao(String PARAM) {
    nro_dias_prorrogacao = PARAM;
  }
  /**
    * VALOR_CALCULADO: Method to get the field value.
    */
  public String getValor_calculado() {
    return valor_calculado;
  }
  /**
    * VALOR_CALCULADO: Method to set the field value.
    */
  public void setValor_calculado(String PARAM) {
    valor_calculado = PARAM;
  }
  /**
    * DATA_SOLICITACAO: Method to get the field value.
    */
  public String getData_solicitacao() {
    return data_solicitacao;
  }
  /**
    * DATA_SOLICITACAO: Method to set the field value.
    */
  public void setData_solicitacao(String PARAM) {
    data_solicitacao = PARAM;
  }
  /**
    * USUARIO_SOLICITACAO: Method to get the field value.
    */
  public String getUsuario_solicitacao() {
    return usuario_solicitacao;
  }
  /**
    * USUARIO_SOLICITACAO: Method to set the field value.
    */
  public void setUsuario_solicitacao(String PARAM) {
    usuario_solicitacao = PARAM;
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
  Vector situacaoList = new Vector(10, 1);
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList.addElement("");
      situacaoLabelList.addElement("Todas");
      situacaoList.addElement("P");
      situacaoLabelList.addElement("Pendente");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Aprovado");
      situacaoList.addElement("R");
      situacaoLabelList.addElement("Reprovado");
      situacaoList.addElement("L");
      situacaoLabelList.addElement("Lançado");
    }
    java.util.Vector list = situacaoList;
    return list;
  }
  java.util.Vector situacaoLabelList = new Vector(10, 1);
  public java.util.Vector getSituacaoLabelList() {
    java.util.Vector list = situacaoLabelList;
    return list;
  }
  /**
    * DATA_APROVACAO: Method to get the field value.
    */
  public String getData_aprovacao() {
    return data_aprovacao;
  }
  /**
    * DATA_APROVACAO: Method to set the field value.
    */
  public void setData_aprovacao(String PARAM) {
    data_aprovacao = PARAM;
  }
  /**
    * USUARIO_APROVACAO: Method to get the field value.
    */
  public String getUsuario_aprovacao() {
    return usuario_aprovacao;
  }
  /**
    * USUARIO_APROVACAO: Method to set the field value.
    */
  public void setUsuario_aprovacao(String PARAM) {
    usuario_aprovacao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    nfs_nmro = null;
    nfs_serie = null;
    emp_empresa = null;
    fil_filial = null;
    nro_dias_prorrogacao = null;
    valor_calculado = null;
    data_solicitacao = null;
    usuario_solicitacao = null;
    situacao = null;
    data_aprovacao = null;
    usuario_aprovacao = null;
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
      if (!com.egen.util.text.Validate.isDate(data_aprovacao)) {
        errors.add("data_aprovacao", new ActionMessage("error.validate.date","Data_aprovacao","data_aprovacao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
