package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/01/2014 11:37:25
 * Last Modify Date 22/02/2016 10:03:41
 */

public class GeracaoRomaneio_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String emp_empresa;
  public String fil_filial;
  public String nfs_nmro;
  public String nfs_serie;
  public String nfs_dtemis;
  public String cli_cdgo;
  public String esc_seqn;
  public String cli_rzao;
  public String rep_cdgo;
  public String rep_rzao;
  public String possui_sku;
  public String preco_final_liquido;
  private boolean valida = false;
  public GeracaoRomaneio_rActionForm() {
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
    * NFS_NMRO: Método Gets para este campo
    */
  public String getNfs_nmro() {
    return nfs_nmro;
  }
  /**
    * NFS_NMRO: Método Sets pára este campo.
    */
  public void setNfs_nmro(String PARAM) {
    nfs_nmro = PARAM;
  }
  /**
    * NFS_SERIE: Método Gets para este campo
    */
  public String getNfs_serie() {
    return nfs_serie;
  }
  /**
    * NFS_SERIE: Método Sets pára este campo.
    */
  public void setNfs_serie(String PARAM) {
    nfs_serie = PARAM;
  }
  /**
    * NFS_DTEMIS: Método Gets para este campo
    */
  public String getNfs_dtemis() {
    return nfs_dtemis;
  }
  /**
    * NFS_DTEMIS: Método Sets pára este campo.
    */
  public void setNfs_dtemis(String PARAM) {
    nfs_dtemis = PARAM;
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
    * REP_RZAO: Método Gets para este campo
    */
  public String getRep_rzao() {
    return rep_rzao;
  }
  /**
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * POSSUI_SKU: Método Gets para este campo
    */
  public String getPossui_sku() {
    return possui_sku;
  }
  /**
    * POSSUI_SKU: Método Sets pára este campo.
    */
  public void setPossui_sku(String PARAM) {
    possui_sku = PARAM;
  }
  /**
    * PRECO_FINAL_LIQUIDO: Método Gets para este campo
    */
  public String getPreco_final_liquido() {
    return preco_final_liquido;
  }
  /**
    * PRECO_FINAL_LIQUIDO: Método Sets pára este campo.
    */
  public void setPreco_final_liquido(String PARAM) {
    preco_final_liquido = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    emp_empresa = null;
    fil_filial = null;
    nfs_nmro = null;
    nfs_serie = null;
    nfs_dtemis = null;
    cli_cdgo = null;
    esc_seqn = null;
    cli_rzao = null;
    rep_cdgo = null;
    rep_rzao = null;
    possui_sku = null;
    preco_final_liquido = null;
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
      if (com.egen.util.text.Validate.isValidate("gerar_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
