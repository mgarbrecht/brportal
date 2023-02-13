package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/03/2006 09:42:00
 * Last Modify Date 02/10/2019 10:46:58
 */

public class NotaFiscalActionForm extends org.apache.struts.action.ActionForm
{
  public String nf_nmro;
  public String emp_empresa;
  public String fil_filial;
  public String nmro_serie;
  public String empresa;
  public String filial;
  public String cliente;
  public String status;
  public String data_emissao;
  public String valor_total;
  public String requisicao;
  public String rep;
  public String comissao;
  public String transportadora;
  public String cons_desc;
  public String bonif1;
  public String bonif2;
  public String desc_pont;
  public String peso_bruto;
  public String peso_liq;
  public String cs;
  public String prt_codigo;
  public String nfs_serie;
  public String nfs_icms;
  public String nfs_valicm;
  public String nf_serie;
  public String nfs_qtdvol;
  public String chave_nfe;
  public String natoper_codigo;
  private boolean valida = false;
  public NotaFiscalActionForm() {
  }
  /**
    * NF_NMRO: Método Gets para este campo
    */
  public String getNf_nmro() {
    return nf_nmro;
  }
  /**
    * NF_NMRO: Método Sets pára este campo.
    */
  public void setNf_nmro(String PARAM) {
    nf_nmro = PARAM;
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
    * NMRO_SERIE: Método Gets para este campo
    */
  public String getNmro_serie() {
    return nmro_serie;
  }
  /**
    * NMRO_SERIE: Método Sets pára este campo.
    */
  public void setNmro_serie(String PARAM) {
    nmro_serie = PARAM;
  }
  /**
    * EMPRESA: Método Gets para este campo
    */
  public String getEmpresa() {
    return empresa;
  }
  /**
    * EMPRESA: Método Sets pára este campo.
    */
  public void setEmpresa(String PARAM) {
    empresa = PARAM;
  }
  /**
    * FILIAL: Método Gets para este campo
    */
  public String getFilial() {
    return filial;
  }
  /**
    * FILIAL: Método Sets pára este campo.
    */
  public void setFilial(String PARAM) {
    filial = PARAM;
  }
  /**
    * CLIENTE: Método Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Método Sets pára este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * STATUS: Método Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Método Sets pára este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  /**
    * DATA_EMISSAO: Método Gets para este campo
    */
  public String getData_emissao() {
    return data_emissao;
  }
  /**
    * DATA_EMISSAO: Método Sets pára este campo.
    */
  public void setData_emissao(String PARAM) {
    data_emissao = PARAM;
  }
  /**
    * VALOR_TOTAL: Método Gets para este campo
    */
  public String getValor_total() {
    return valor_total;
  }
  /**
    * VALOR_TOTAL: Método Sets pára este campo.
    */
  public void setValor_total(String PARAM) {
    valor_total = PARAM;
  }
  /**
    * REQUISICAO: Método Gets para este campo
    */
  public String getRequisicao() {
    return requisicao;
  }
  /**
    * REQUISICAO: Método Sets pára este campo.
    */
  public void setRequisicao(String PARAM) {
    requisicao = PARAM;
  }
  /**
    * REP: Método Gets para este campo
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: Método Sets pára este campo.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
  }
  /**
    * COMISSAO: Método Gets para este campo
    */
  public String getComissao() {
    return comissao;
  }
  /**
    * COMISSAO: Método Sets pára este campo.
    */
  public void setComissao(String PARAM) {
    comissao = PARAM;
  }
  /**
    * TRANSPORTADORA: Método Gets para este campo
    */
  public String getTransportadora() {
    return transportadora;
  }
  /**
    * TRANSPORTADORA: Método Sets pára este campo.
    */
  public void setTransportadora(String PARAM) {
    transportadora = PARAM;
  }
  /**
    * CONS_DESC: Método Gets para este campo
    */
  public String getCons_desc() {
    return cons_desc;
  }
  /**
    * CONS_DESC: Método Sets pára este campo.
    */
  public void setCons_desc(String PARAM) {
    cons_desc = PARAM;
  }
  /**
    * BONIF1: Método Gets para este campo
    */
  public String getBonif1() {
    return bonif1;
  }
  /**
    * BONIF1: Método Sets pára este campo.
    */
  public void setBonif1(String PARAM) {
    bonif1 = PARAM;
  }
  /**
    * BONIF2: Método Gets para este campo
    */
  public String getBonif2() {
    return bonif2;
  }
  /**
    * BONIF2: Método Sets pára este campo.
    */
  public void setBonif2(String PARAM) {
    bonif2 = PARAM;
  }
  /**
    * DESC_PONT: Método Gets para este campo
    */
  public String getDesc_pont() {
    return desc_pont;
  }
  /**
    * DESC_PONT: Método Sets pára este campo.
    */
  public void setDesc_pont(String PARAM) {
    desc_pont = PARAM;
  }
  /**
    * PESO_BRUTO: Método Gets para este campo
    */
  public String getPeso_bruto() {
    return peso_bruto;
  }
  /**
    * PESO_BRUTO: Método Sets pára este campo.
    */
  public void setPeso_bruto(String PARAM) {
    peso_bruto = PARAM;
  }
  /**
    * PESO_LIQ: Método Gets para este campo
    */
  public String getPeso_liq() {
    return peso_liq;
  }
  /**
    * PESO_LIQ: Método Sets pára este campo.
    */
  public void setPeso_liq(String PARAM) {
    peso_liq = PARAM;
  }
  /**
    * CS: Método Gets para este campo
    */
  public String getCs() {
    return cs;
  }
  /**
    * CS: Método Sets pára este campo.
    */
  public void setCs(String PARAM) {
    cs = PARAM;
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
    * NFS_ICMS: Método Gets para este campo
    */
  public String getNfs_icms() {
    return nfs_icms;
  }
  /**
    * NFS_ICMS: Método Sets pára este campo.
    */
  public void setNfs_icms(String PARAM) {
    nfs_icms = PARAM;
  }
  /**
    * NFS_VALICM: Método Gets para este campo
    */
  public String getNfs_valicm() {
    return nfs_valicm;
  }
  /**
    * NFS_VALICM: Método Sets pára este campo.
    */
  public void setNfs_valicm(String PARAM) {
    nfs_valicm = PARAM;
  }
  /**
    * NF_SERIE: Método Gets para este campo
    */
  public String getNf_serie() {
    return nf_serie;
  }
  /**
    * NF_SERIE: Método Sets pára este campo.
    */
  public void setNf_serie(String PARAM) {
    nf_serie = PARAM;
  }
  /**
    * NFS_QTDVOL: Método Gets para este campo
    */
  public String getNfs_qtdvol() {
    return nfs_qtdvol;
  }
  /**
    * NFS_QTDVOL: Método Sets pára este campo.
    */
  public void setNfs_qtdvol(String PARAM) {
    nfs_qtdvol = PARAM;
  }
  /**
    * CHAVE_NFE: Método Gets para este campo
    */
  public String getChave_nfe() {
    return chave_nfe;
  }
  /**
    * CHAVE_NFE: Método Sets pára este campo.
    */
  public void setChave_nfe(String PARAM) {
    chave_nfe = PARAM;
  }
  /**
    * NATOPER_CODIGO: Método Gets para este campo
    */
  public String getNatoper_codigo() {
    return natoper_codigo;
  }
  /**
    * NATOPER_CODIGO: Método Sets pára este campo.
    */
  public void setNatoper_codigo(String PARAM) {
    natoper_codigo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    nf_nmro = null;
    emp_empresa = null;
    fil_filial = null;
    nmro_serie = null;
    empresa = null;
    filial = null;
    cliente = null;
    status = null;
    data_emissao = null;
    valor_total = null;
    requisicao = null;
    rep = null;
    comissao = null;
    transportadora = null;
    cons_desc = null;
    bonif1 = null;
    bonif2 = null;
    desc_pont = null;
    peso_bruto = null;
    peso_liq = null;
    cs = null;
    prt_codigo = null;
    nfs_serie = null;
    nfs_icms = null;
    nfs_valicm = null;
    nf_serie = null;
    nfs_qtdvol = null;
    chave_nfe = null;
    natoper_codigo = null;
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
