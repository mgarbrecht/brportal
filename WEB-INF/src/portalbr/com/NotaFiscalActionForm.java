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
    * NF_NMRO: M�todo Gets para este campo
    */
  public String getNf_nmro() {
    return nf_nmro;
  }
  /**
    * NF_NMRO: M�todo Sets p�ra este campo.
    */
  public void setNf_nmro(String PARAM) {
    nf_nmro = PARAM;
  }
  /**
    * EMP_EMPRESA: M�todo Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: M�todo Sets p�ra este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * FIL_FILIAL: M�todo Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: M�todo Sets p�ra este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * NMRO_SERIE: M�todo Gets para este campo
    */
  public String getNmro_serie() {
    return nmro_serie;
  }
  /**
    * NMRO_SERIE: M�todo Sets p�ra este campo.
    */
  public void setNmro_serie(String PARAM) {
    nmro_serie = PARAM;
  }
  /**
    * EMPRESA: M�todo Gets para este campo
    */
  public String getEmpresa() {
    return empresa;
  }
  /**
    * EMPRESA: M�todo Sets p�ra este campo.
    */
  public void setEmpresa(String PARAM) {
    empresa = PARAM;
  }
  /**
    * FILIAL: M�todo Gets para este campo
    */
  public String getFilial() {
    return filial;
  }
  /**
    * FILIAL: M�todo Sets p�ra este campo.
    */
  public void setFilial(String PARAM) {
    filial = PARAM;
  }
  /**
    * CLIENTE: M�todo Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * STATUS: M�todo Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: M�todo Sets p�ra este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  /**
    * DATA_EMISSAO: M�todo Gets para este campo
    */
  public String getData_emissao() {
    return data_emissao;
  }
  /**
    * DATA_EMISSAO: M�todo Sets p�ra este campo.
    */
  public void setData_emissao(String PARAM) {
    data_emissao = PARAM;
  }
  /**
    * VALOR_TOTAL: M�todo Gets para este campo
    */
  public String getValor_total() {
    return valor_total;
  }
  /**
    * VALOR_TOTAL: M�todo Sets p�ra este campo.
    */
  public void setValor_total(String PARAM) {
    valor_total = PARAM;
  }
  /**
    * REQUISICAO: M�todo Gets para este campo
    */
  public String getRequisicao() {
    return requisicao;
  }
  /**
    * REQUISICAO: M�todo Sets p�ra este campo.
    */
  public void setRequisicao(String PARAM) {
    requisicao = PARAM;
  }
  /**
    * REP: M�todo Gets para este campo
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: M�todo Sets p�ra este campo.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
  }
  /**
    * COMISSAO: M�todo Gets para este campo
    */
  public String getComissao() {
    return comissao;
  }
  /**
    * COMISSAO: M�todo Sets p�ra este campo.
    */
  public void setComissao(String PARAM) {
    comissao = PARAM;
  }
  /**
    * TRANSPORTADORA: M�todo Gets para este campo
    */
  public String getTransportadora() {
    return transportadora;
  }
  /**
    * TRANSPORTADORA: M�todo Sets p�ra este campo.
    */
  public void setTransportadora(String PARAM) {
    transportadora = PARAM;
  }
  /**
    * CONS_DESC: M�todo Gets para este campo
    */
  public String getCons_desc() {
    return cons_desc;
  }
  /**
    * CONS_DESC: M�todo Sets p�ra este campo.
    */
  public void setCons_desc(String PARAM) {
    cons_desc = PARAM;
  }
  /**
    * BONIF1: M�todo Gets para este campo
    */
  public String getBonif1() {
    return bonif1;
  }
  /**
    * BONIF1: M�todo Sets p�ra este campo.
    */
  public void setBonif1(String PARAM) {
    bonif1 = PARAM;
  }
  /**
    * BONIF2: M�todo Gets para este campo
    */
  public String getBonif2() {
    return bonif2;
  }
  /**
    * BONIF2: M�todo Sets p�ra este campo.
    */
  public void setBonif2(String PARAM) {
    bonif2 = PARAM;
  }
  /**
    * DESC_PONT: M�todo Gets para este campo
    */
  public String getDesc_pont() {
    return desc_pont;
  }
  /**
    * DESC_PONT: M�todo Sets p�ra este campo.
    */
  public void setDesc_pont(String PARAM) {
    desc_pont = PARAM;
  }
  /**
    * PESO_BRUTO: M�todo Gets para este campo
    */
  public String getPeso_bruto() {
    return peso_bruto;
  }
  /**
    * PESO_BRUTO: M�todo Sets p�ra este campo.
    */
  public void setPeso_bruto(String PARAM) {
    peso_bruto = PARAM;
  }
  /**
    * PESO_LIQ: M�todo Gets para este campo
    */
  public String getPeso_liq() {
    return peso_liq;
  }
  /**
    * PESO_LIQ: M�todo Sets p�ra este campo.
    */
  public void setPeso_liq(String PARAM) {
    peso_liq = PARAM;
  }
  /**
    * CS: M�todo Gets para este campo
    */
  public String getCs() {
    return cs;
  }
  /**
    * CS: M�todo Sets p�ra este campo.
    */
  public void setCs(String PARAM) {
    cs = PARAM;
  }
  /**
    * PRT_CODIGO: M�todo Gets para este campo
    */
  public String getPrt_codigo() {
    return prt_codigo;
  }
  /**
    * PRT_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setPrt_codigo(String PARAM) {
    prt_codigo = PARAM;
  }
  /**
    * NFS_SERIE: M�todo Gets para este campo
    */
  public String getNfs_serie() {
    return nfs_serie;
  }
  /**
    * NFS_SERIE: M�todo Sets p�ra este campo.
    */
  public void setNfs_serie(String PARAM) {
    nfs_serie = PARAM;
  }
  /**
    * NFS_ICMS: M�todo Gets para este campo
    */
  public String getNfs_icms() {
    return nfs_icms;
  }
  /**
    * NFS_ICMS: M�todo Sets p�ra este campo.
    */
  public void setNfs_icms(String PARAM) {
    nfs_icms = PARAM;
  }
  /**
    * NFS_VALICM: M�todo Gets para este campo
    */
  public String getNfs_valicm() {
    return nfs_valicm;
  }
  /**
    * NFS_VALICM: M�todo Sets p�ra este campo.
    */
  public void setNfs_valicm(String PARAM) {
    nfs_valicm = PARAM;
  }
  /**
    * NF_SERIE: M�todo Gets para este campo
    */
  public String getNf_serie() {
    return nf_serie;
  }
  /**
    * NF_SERIE: M�todo Sets p�ra este campo.
    */
  public void setNf_serie(String PARAM) {
    nf_serie = PARAM;
  }
  /**
    * NFS_QTDVOL: M�todo Gets para este campo
    */
  public String getNfs_qtdvol() {
    return nfs_qtdvol;
  }
  /**
    * NFS_QTDVOL: M�todo Sets p�ra este campo.
    */
  public void setNfs_qtdvol(String PARAM) {
    nfs_qtdvol = PARAM;
  }
  /**
    * CHAVE_NFE: M�todo Gets para este campo
    */
  public String getChave_nfe() {
    return chave_nfe;
  }
  /**
    * CHAVE_NFE: M�todo Sets p�ra este campo.
    */
  public void setChave_nfe(String PARAM) {
    chave_nfe = PARAM;
  }
  /**
    * NATOPER_CODIGO: M�todo Gets para este campo
    */
  public String getNatoper_codigo() {
    return natoper_codigo;
  }
  /**
    * NATOPER_CODIGO: M�todo Sets p�ra este campo.
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
    * Valida��o dos campos, retornando um ActionErrors.
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
