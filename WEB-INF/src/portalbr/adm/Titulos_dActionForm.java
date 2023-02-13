package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/03/2006 08:52:01
 * Last Modify Date 01/08/2013 12:52:31
 */

public class Titulos_dActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String nome;
  public String bairro;
  public String cidade_uf;
  public String esc_seqn;
  public String situacao;
  public String dt_venc;
  public String cli_cdgo;
  public String w_liq;
  public String w_saldo_tot;
  public String w_valor_tot;
  private boolean valida = false;
  public Titulos_dActionForm() {
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    nome = null;
    bairro = null;
    cidade_uf = null;
    esc_seqn = null;
    situacao = null;
    dt_venc = null;
    cli_cdgo = null;
    w_liq = null;
    w_saldo_tot = null;
    w_valor_tot = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
