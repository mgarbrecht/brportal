package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/03/2006 08:52:01
 * Last Modify Date 04/02/2022 11:03:19
 */

public class ImpressaoDuplicatasNV_rActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String nome;
  public String bairro;
  public String cidade_uf;
  public String emp_empresa;
  public boolean gridCheckField;
  public String tit_codigo1;
  public String tip_codigo1;
  public String tit_datvenc1;
  public String tit_valor;
  public String prt_codigo1;
  public String emp_empresa2;
  public String fil_filial1;
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
  public String cac_sequencia;
  public String dt_venc_final;
  private boolean valida = false;
  public ImpressaoDuplicatasNV_rActionForm() {
  }
  /**
    * CODIGO: Método Gets para este campo
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Método Sets pára este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * NOME: Método Gets para este campo
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: Método Sets pára este campo.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * BAIRRO: Método Gets para este campo
    */
  public String getBairro() {
    return bairro;
  }
  /**
    * BAIRRO: Método Sets pára este campo.
    */
  public void setBairro(String PARAM) {
    bairro = PARAM;
  }
  /**
    * CIDADE_UF: Método Gets para este campo
    */
  public String getCidade_uf() {
    return cidade_uf;
  }
  /**
    * CIDADE_UF: Método Sets pára este campo.
    */
  public void setCidade_uf(String PARAM) {
    cidade_uf = PARAM;
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * TIT_CODIGO1: Método Gets para este campo
    */
  public String getTit_codigo1() {
    return tit_codigo1;
  }
  /**
    * TIT_CODIGO1: Método Sets pára este campo.
    */
  public void setTit_codigo1(String PARAM) {
    tit_codigo1 = PARAM;
  }
  /**
    * TIP_CODIGO1: Método Gets para este campo
    */
  public String getTip_codigo1() {
    return tip_codigo1;
  }
  /**
    * TIP_CODIGO1: Método Sets pára este campo.
    */
  public void setTip_codigo1(String PARAM) {
    tip_codigo1 = PARAM;
  }
  /**
    * TIT_DATVENC1: Método Gets para este campo
    */
  public String getTit_datvenc1() {
    return tit_datvenc1;
  }
  /**
    * TIT_DATVENC1: Método Sets pára este campo.
    */
  public void setTit_datvenc1(String PARAM) {
    tit_datvenc1 = PARAM;
  }
  /**
    * TIT_VALOR: Método Gets para este campo
    */
  public String getTit_valor() {
    return tit_valor;
  }
  /**
    * TIT_VALOR: Método Sets pára este campo.
    */
  public void setTit_valor(String PARAM) {
    tit_valor = PARAM;
  }
  /**
    * PRT_CODIGO1: Método Gets para este campo
    */
  public String getPrt_codigo1() {
    return prt_codigo1;
  }
  /**
    * PRT_CODIGO1: Método Sets pára este campo.
    */
  public void setPrt_codigo1(String PARAM) {
    prt_codigo1 = PARAM;
  }
  /**
    * EMP_EMPRESA2: Método Gets para este campo
    */
  public String getEmp_empresa2() {
    return emp_empresa2;
  }
  /**
    * EMP_EMPRESA2: Método Sets pára este campo.
    */
  public void setEmp_empresa2(String PARAM) {
    emp_empresa2 = PARAM;
  }
  /**
    * FIL_FILIAL1: Método Gets para este campo
    */
  public String getFil_filial1() {
    return fil_filial1;
  }
  /**
    * FIL_FILIAL1: Método Sets pára este campo.
    */
  public void setFil_filial1(String PARAM) {
    fil_filial1 = PARAM;
  }
  /**
    * ESC_SEQN: Método Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Método Sets pára este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * DT_VENC: Método Gets para este campo
    */
  public String getDt_venc() {
    return dt_venc;
  }
  /**
    * DT_VENC: Método Sets pára este campo.
    */
  public void setDt_venc(String PARAM) {
    dt_venc = PARAM;
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * W_LIQ: Método Gets para este campo
    */
  public String getW_liq() {
    return w_liq;
  }
  /**
    * W_LIQ: Método Sets pára este campo.
    */
  public void setW_liq(String PARAM) {
    w_liq = PARAM;
  }
  /**
    * W_SALDO_TOT: Método Gets para este campo
    */
  public String getW_saldo_tot() {
    return w_saldo_tot;
  }
  /**
    * W_SALDO_TOT: Método Sets pára este campo.
    */
  public void setW_saldo_tot(String PARAM) {
    w_saldo_tot = PARAM;
  }
  /**
    * W_VALOR_TOT: Método Gets para este campo
    */
  public String getW_valor_tot() {
    return w_valor_tot;
  }
  /**
    * W_VALOR_TOT: Método Sets pára este campo.
    */
  public void setW_valor_tot(String PARAM) {
    w_valor_tot = PARAM;
  }
  /**
    * EMP_EMPRESA1: Método Gets para este campo
    */
  public String getEmp_empresa1() {
    return emp_empresa1;
  }
  /**
    * EMP_EMPRESA1: Método Sets pára este campo.
    */
  public void setEmp_empresa1(String PARAM) {
    emp_empresa1 = PARAM;
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * TIP_CODIGO: Método Gets para este campo
    */
  public String getTip_codigo() {
    return tip_codigo;
  }
  /**
    * TIP_CODIGO: Método Sets pára este campo.
    */
  public void setTip_codigo(String PARAM) {
    tip_codigo = PARAM;
  }
  /**
    * TIT_CODIGO: Método Gets para este campo
    */
  public String getTit_codigo() {
    return tit_codigo;
  }
  /**
    * TIT_CODIGO: Método Sets pára este campo.
    */
  public void setTit_codigo(String PARAM) {
    tit_codigo = PARAM;
  }
  /**
    * VALOR: Método Gets para este campo
    */
  public String getValor() {
    return valor;
  }
  /**
    * VALOR: Método Sets pára este campo.
    */
  public void setValor(String PARAM) {
    valor = PARAM;
  }
  /**
    * PRT_CODIGO: Método Gets para este campo
    */
  public String getPrt_codigo() {
    return prt_codigo;
  }
  /**
    * PRT_CODIGO: Método Sets pára este campo.
    */
  public void setPrt_codigo(String PARAM) {
    prt_codigo = PARAM;
  }
  /**
    * TIT_DATVENC: Método Gets para este campo
    */
  public String getTit_datvenc() {
    return tit_datvenc;
  }
  /**
    * TIT_DATVENC: Método Sets pára este campo.
    */
  public void setTit_datvenc(String PARAM) {
    tit_datvenc = PARAM;
  }
  /**
    * CAC_SEQUENCIA: Método Gets para este campo
    */
  public String getCac_sequencia() {
    return cac_sequencia;
  }
  /**
    * CAC_SEQUENCIA: Método Sets pára este campo.
    */
  public void setCac_sequencia(String PARAM) {
    cac_sequencia = PARAM;
  }
  /**
    * DT_VENC_FINAL: Método Gets para este campo
    */
  public String getDt_venc_final() {
    return dt_venc_final;
  }
  /**
    * DT_VENC_FINAL: Método Sets pára este campo.
    */
  public void setDt_venc_final(String PARAM) {
    dt_venc_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    nome = null;
    bairro = null;
    cidade_uf = null;
    emp_empresa = null;
    gridCheckField = false;
    tit_codigo1 = null;
    tip_codigo1 = null;
    tit_datvenc1 = null;
    tit_valor = null;
    prt_codigo1 = null;
    emp_empresa2 = null;
    fil_filial1 = null;
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
    cac_sequencia = null;
    dt_venc_final = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
