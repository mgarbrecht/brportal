package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/09/2016 09:31:52
 * Last Modify Date 21/09/2016 13:13:24
 */

public class PrecoVendaPedido_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String ped_nmro;
  public String cli_cdgo;
  public String esc_seqn;
  public String cli_rzao;
  public String ped_daem;
  public String ite_seqn;
  public String lin_cdgo;
  public String ref_cdgo;
  public String cab_cdgo;
  public String cor_cdgo;
  public String ped_ped_cliente;
  public String ite_preco_venda;
  public String ite_preco_venda_novo;
  public String rep_cdgo;
  public String codigo_regional;
  private boolean valida = false;
  public PrecoVendaPedido_rActionForm() {
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
    * PED_NMRO: Método Gets para este campo
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Método Sets pára este campo.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
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
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * PED_DAEM: Método Gets para este campo
    */
  public String getPed_daem() {
    return ped_daem;
  }
  /**
    * PED_DAEM: Método Sets pára este campo.
    */
  public void setPed_daem(String PARAM) {
    ped_daem = PARAM;
  }
  /**
    * ITE_SEQN: Método Gets para este campo
    */
  public String getIte_seqn() {
    return ite_seqn;
  }
  /**
    * ITE_SEQN: Método Sets pára este campo.
    */
  public void setIte_seqn(String PARAM) {
    ite_seqn = PARAM;
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * REF_CDGO: Método Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Método Sets pára este campo.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * CAB_CDGO: Método Gets para este campo
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Método Sets pára este campo.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * COR_CDGO: Método Gets para este campo
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Método Sets pára este campo.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * PED_PED_CLIENTE: Método Gets para este campo
    */
  public String getPed_ped_cliente() {
    return ped_ped_cliente;
  }
  /**
    * PED_PED_CLIENTE: Método Sets pára este campo.
    */
  public void setPed_ped_cliente(String PARAM) {
    ped_ped_cliente = PARAM;
  }
  /**
    * ITE_PRECO_VENDA: Método Gets para este campo
    */
  public String getIte_preco_venda() {
    return ite_preco_venda;
  }
  /**
    * ITE_PRECO_VENDA: Método Sets pára este campo.
    */
  public void setIte_preco_venda(String PARAM) {
    ite_preco_venda = PARAM;
  }
  /**
    * ITE_PRECO_VENDA_NOVO: Método Gets para este campo
    */
  public String getIte_preco_venda_novo() {
    return ite_preco_venda_novo;
  }
  /**
    * ITE_PRECO_VENDA_NOVO: Método Sets pára este campo.
    */
  public void setIte_preco_venda_novo(String PARAM) {
    ite_preco_venda_novo = PARAM;
  }
  /**
    * REP_CDGO: Método Gets para este campo
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Método Sets pára este campo.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Método Sets pára este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    ped_nmro = null;
    cli_cdgo = null;
    esc_seqn = null;
    cli_rzao = null;
    ped_daem = null;
    ite_seqn = null;
    lin_cdgo = null;
    ref_cdgo = null;
    cab_cdgo = null;
    cor_cdgo = null;
    ped_ped_cliente = null;
    ite_preco_venda = null;
    ite_preco_venda_novo = null;
    rep_cdgo = null;
    codigo_regional = null;
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
