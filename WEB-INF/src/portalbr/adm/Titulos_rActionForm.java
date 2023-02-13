package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/03/2006 08:52:01
 * Last Modify Date 20/05/2020 14:36:43
 */

public class Titulos_rActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String nome;
  public String bairro;
  public String cidade_uf;
  public String emp_empresa;
  public String esc_seqn;
  public String situacao;
  public String dt_venc;
  public String cli_cdgo;
  public String w_liq;
  public String w_saldo_tot;
  public String w_valor_tot;
  public String emp_empresa1;
  public String fil_filial;
  public String tip_codigo;
  public String tit_codigo;
  public String valor;
  public String prt_codigo;
  public String tit_datvenc;
  private boolean valida = false;
  public Titulos_rActionForm() {
  }
  /**
    * CODIGO: Method to get the field value.
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Method to set the field value.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * NOME: Method to get the field value.
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: Method to set the field value.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * BAIRRO: Method to get the field value.
    */
  public String getBairro() {
    return bairro;
  }
  /**
    * BAIRRO: Method to set the field value.
    */
  public void setBairro(String PARAM) {
    bairro = PARAM;
  }
  /**
    * CIDADE_UF: Method to get the field value.
    */
  public String getCidade_uf() {
    return cidade_uf;
  }
  /**
    * CIDADE_UF: Method to set the field value.
    */
  public void setCidade_uf(String PARAM) {
    cidade_uf = PARAM;
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
    * ESC_SEQN: Method to get the field value.
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Method to set the field value.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
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
    * DT_VENC: Method to get the field value.
    */
  public String getDt_venc() {
    return dt_venc;
  }
  /**
    * DT_VENC: Method to set the field value.
    */
  public void setDt_venc(String PARAM) {
    dt_venc = PARAM;
  }
  /**
    * CLI_CDGO: Method to get the field value.
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Method to set the field value.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * W_LIQ: Method to get the field value.
    */
  public String getW_liq() {
    return w_liq;
  }
  /**
    * W_LIQ: Method to set the field value.
    */
  public void setW_liq(String PARAM) {
    w_liq = PARAM;
  }
  /**
    * W_SALDO_TOT: Method to get the field value.
    */
  public String getW_saldo_tot() {
    return w_saldo_tot;
  }
  /**
    * W_SALDO_TOT: Method to set the field value.
    */
  public void setW_saldo_tot(String PARAM) {
    w_saldo_tot = PARAM;
  }
  /**
    * W_VALOR_TOT: Method to get the field value.
    */
  public String getW_valor_tot() {
    return w_valor_tot;
  }
  /**
    * W_VALOR_TOT: Method to set the field value.
    */
  public void setW_valor_tot(String PARAM) {
    w_valor_tot = PARAM;
  }
  /**
    * EMP_EMPRESA1: Method to get the field value.
    */
  public String getEmp_empresa1() {
    return emp_empresa1;
  }
  /**
    * EMP_EMPRESA1: Method to set the field value.
    */
  public void setEmp_empresa1(String PARAM) {
    emp_empresa1 = PARAM;
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
    * TIP_CODIGO: Method to get the field value.
    */
  public String getTip_codigo() {
    return tip_codigo;
  }
  /**
    * TIP_CODIGO: Method to set the field value.
    */
  public void setTip_codigo(String PARAM) {
    tip_codigo = PARAM;
  }
  /**
    * TIT_CODIGO: Method to get the field value.
    */
  public String getTit_codigo() {
    return tit_codigo;
  }
  /**
    * TIT_CODIGO: Method to set the field value.
    */
  public void setTit_codigo(String PARAM) {
    tit_codigo = PARAM;
  }
  /**
    * VALOR: Method to get the field value.
    */
  public String getValor() {
    return valor;
  }
  /**
    * VALOR: Method to set the field value.
    */
  public void setValor(String PARAM) {
    valor = PARAM;
  }
  /**
    * PRT_CODIGO: Method to get the field value.
    */
  public String getPrt_codigo() {
    return prt_codigo;
  }
  /**
    * PRT_CODIGO: Method to set the field value.
    */
  public void setPrt_codigo(String PARAM) {
    prt_codigo = PARAM;
  }
  /**
    * TIT_DATVENC: Method to get the field value.
    */
  public String getTit_datvenc() {
    return tit_datvenc;
  }
  /**
    * TIT_DATVENC: Method to set the field value.
    */
  public void setTit_datvenc(String PARAM) {
    tit_datvenc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    nome = null;
    bairro = null;
    cidade_uf = null;
    emp_empresa = null;
    esc_seqn = null;
    situacao = null;
    dt_venc = null;
    cli_cdgo = null;
    w_liq = null;
    w_saldo_tot = null;
    w_valor_tot = null;
    emp_empresa1 = null;
    fil_filial = null;
    tip_codigo = null;
    tit_codigo = null;
    valor = null;
    prt_codigo = null;
    tit_datvenc = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
