package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/03/2006 14:18:56
 * Last Modify Date 01/08/2019 15:11:48
 */

public class ConsultaDuplicataActionForm extends org.apache.struts.action.ActionForm
{
  public String cliente;
  public String cnpj;
  public String duplicata;
  public String pedido;
  public String nf;
  public String rep;
  public String existe;
  public String serie;
  public String emp_empresa;
  public String fil_filial;
  public String tip;
  public String empresa;
  public String status;
  public String dt_emissao;
  public String dt_venc;
  public String cli_cdgo;
  public String esc_seqn;
  public String dt_pagamento;
  public String triplic;
  public String anuencia;
  public String ins_prot;
  public String nr_banco;
  public String desc_pontualidade;
  public String desc_antecipacao;
  public String juros;
  public String valor_receb;
  public String valor_abatim;
  public String desconto;
  public String cartorio;
  public String desban;
  public String saldo;
  public String filial;
  public String tip_codigo;
  public String titulo;
  public String rep_codigo;
  public String rec_prot;
  public String valor;
  public String encargos;
  public String valor_vendor;
  public String carteira;
  public String link;
  private boolean valida = false;
  public ConsultaDuplicataActionForm() {
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
    * CNPJ: M�todo Gets para este campo
    */
  public String getCnpj() {
    return cnpj;
  }
  /**
    * CNPJ: M�todo Sets p�ra este campo.
    */
  public void setCnpj(String PARAM) {
    cnpj = PARAM;
  }
  /**
    * DUPLICATA: M�todo Gets para este campo
    */
  public String getDuplicata() {
    return duplicata;
  }
  /**
    * DUPLICATA: M�todo Sets p�ra este campo.
    */
  public void setDuplicata(String PARAM) {
    duplicata = PARAM;
  }
  /**
    * PEDIDO: M�todo Gets para este campo
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: M�todo Sets p�ra este campo.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * NF: M�todo Gets para este campo
    */
  public String getNf() {
    return nf;
  }
  /**
    * NF: M�todo Sets p�ra este campo.
    */
  public void setNf(String PARAM) {
    nf = PARAM;
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
    * EXISTE: M�todo Gets para este campo
    */
  public String getExiste() {
    return existe;
  }
  /**
    * EXISTE: M�todo Sets p�ra este campo.
    */
  public void setExiste(String PARAM) {
    existe = PARAM;
  }
  /**
    * SERIE: M�todo Gets para este campo
    */
  public String getSerie() {
    return serie;
  }
  /**
    * SERIE: M�todo Sets p�ra este campo.
    */
  public void setSerie(String PARAM) {
    serie = PARAM;
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
    * TIP: M�todo Gets para este campo
    */
  public String getTip() {
    return tip;
  }
  /**
    * TIP: M�todo Sets p�ra este campo.
    */
  public void setTip(String PARAM) {
    tip = PARAM;
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
    * DT_EMISSAO: M�todo Gets para este campo
    */
  public String getDt_emissao() {
    return dt_emissao;
  }
  /**
    * DT_EMISSAO: M�todo Sets p�ra este campo.
    */
  public void setDt_emissao(String PARAM) {
    dt_emissao = PARAM;
  }
  /**
    * DT_VENC: M�todo Gets para este campo
    */
  public String getDt_venc() {
    return dt_venc;
  }
  /**
    * DT_VENC: M�todo Sets p�ra este campo.
    */
  public void setDt_venc(String PARAM) {
    dt_venc = PARAM;
  }
  /**
    * CLI_CDGO: M�todo Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: M�todo Sets p�ra este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * ESC_SEQN: M�todo Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: M�todo Sets p�ra este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * DT_PAGAMENTO: M�todo Gets para este campo
    */
  public String getDt_pagamento() {
    return dt_pagamento;
  }
  /**
    * DT_PAGAMENTO: M�todo Sets p�ra este campo.
    */
  public void setDt_pagamento(String PARAM) {
    dt_pagamento = PARAM;
  }
  /**
    * TRIPLIC: M�todo Gets para este campo
    */
  public String getTriplic() {
    return triplic;
  }
  /**
    * TRIPLIC: M�todo Sets p�ra este campo.
    */
  public void setTriplic(String PARAM) {
    triplic = PARAM;
  }
  /**
    * ANUENCIA: M�todo Gets para este campo
    */
  public String getAnuencia() {
    return anuencia;
  }
  /**
    * ANUENCIA: M�todo Sets p�ra este campo.
    */
  public void setAnuencia(String PARAM) {
    anuencia = PARAM;
  }
  /**
    * INS_PROT: M�todo Gets para este campo
    */
  public String getIns_prot() {
    return ins_prot;
  }
  /**
    * INS_PROT: M�todo Sets p�ra este campo.
    */
  public void setIns_prot(String PARAM) {
    ins_prot = PARAM;
  }
  /**
    * NR_BANCO: M�todo Gets para este campo
    */
  public String getNr_banco() {
    return nr_banco;
  }
  /**
    * NR_BANCO: M�todo Sets p�ra este campo.
    */
  public void setNr_banco(String PARAM) {
    nr_banco = PARAM;
  }
  /**
    * DESC_PONTUALIDADE: M�todo Gets para este campo
    */
  public String getDesc_pontualidade() {
    return desc_pontualidade;
  }
  /**
    * DESC_PONTUALIDADE: M�todo Sets p�ra este campo.
    */
  public void setDesc_pontualidade(String PARAM) {
    desc_pontualidade = PARAM;
  }
  /**
    * DESC_ANTECIPACAO: M�todo Gets para este campo
    */
  public String getDesc_antecipacao() {
    return desc_antecipacao;
  }
  /**
    * DESC_ANTECIPACAO: M�todo Sets p�ra este campo.
    */
  public void setDesc_antecipacao(String PARAM) {
    desc_antecipacao = PARAM;
  }
  /**
    * JUROS: M�todo Gets para este campo
    */
  public String getJuros() {
    return juros;
  }
  /**
    * JUROS: M�todo Sets p�ra este campo.
    */
  public void setJuros(String PARAM) {
    juros = PARAM;
  }
  /**
    * VALOR_RECEB: M�todo Gets para este campo
    */
  public String getValor_receb() {
    return valor_receb;
  }
  /**
    * VALOR_RECEB: M�todo Sets p�ra este campo.
    */
  public void setValor_receb(String PARAM) {
    valor_receb = PARAM;
  }
  /**
    * VALOR_ABATIM: M�todo Gets para este campo
    */
  public String getValor_abatim() {
    return valor_abatim;
  }
  /**
    * VALOR_ABATIM: M�todo Sets p�ra este campo.
    */
  public void setValor_abatim(String PARAM) {
    valor_abatim = PARAM;
  }
  /**
    * DESCONTO: M�todo Gets para este campo
    */
  public String getDesconto() {
    return desconto;
  }
  /**
    * DESCONTO: M�todo Sets p�ra este campo.
    */
  public void setDesconto(String PARAM) {
    desconto = PARAM;
  }
  /**
    * CARTORIO: M�todo Gets para este campo
    */
  public String getCartorio() {
    return cartorio;
  }
  /**
    * CARTORIO: M�todo Sets p�ra este campo.
    */
  public void setCartorio(String PARAM) {
    cartorio = PARAM;
  }
  /**
    * DESBAN: M�todo Gets para este campo
    */
  public String getDesban() {
    return desban;
  }
  /**
    * DESBAN: M�todo Sets p�ra este campo.
    */
  public void setDesban(String PARAM) {
    desban = PARAM;
  }
  /**
    * SALDO: M�todo Gets para este campo
    */
  public String getSaldo() {
    return saldo;
  }
  /**
    * SALDO: M�todo Sets p�ra este campo.
    */
  public void setSaldo(String PARAM) {
    saldo = PARAM;
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
    * TIP_CODIGO: M�todo Gets para este campo
    */
  public String getTip_codigo() {
    return tip_codigo;
  }
  /**
    * TIP_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setTip_codigo(String PARAM) {
    tip_codigo = PARAM;
  }
  /**
    * TITULO: M�todo Gets para este campo
    */
  public String getTitulo() {
    return titulo;
  }
  /**
    * TITULO: M�todo Sets p�ra este campo.
    */
  public void setTitulo(String PARAM) {
    titulo = PARAM;
  }
  /**
    * REP_CODIGO: M�todo Gets para este campo
    */
  public String getRep_codigo() {
    return rep_codigo;
  }
  /**
    * REP_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setRep_codigo(String PARAM) {
    rep_codigo = PARAM;
  }
  /**
    * REC_PROT: M�todo Gets para este campo
    */
  public String getRec_prot() {
    return rec_prot;
  }
  /**
    * REC_PROT: M�todo Sets p�ra este campo.
    */
  public void setRec_prot(String PARAM) {
    rec_prot = PARAM;
  }
  /**
    * VALOR: M�todo Gets para este campo
    */
  public String getValor() {
    return valor;
  }
  /**
    * VALOR: M�todo Sets p�ra este campo.
    */
  public void setValor(String PARAM) {
    valor = PARAM;
  }
  /**
    * ENCARGOS: M�todo Gets para este campo
    */
  public String getEncargos() {
    return encargos;
  }
  /**
    * ENCARGOS: M�todo Sets p�ra este campo.
    */
  public void setEncargos(String PARAM) {
    encargos = PARAM;
  }
  /**
    * VALOR_VENDOR: M�todo Gets para este campo
    */
  public String getValor_vendor() {
    return valor_vendor;
  }
  /**
    * VALOR_VENDOR: M�todo Sets p�ra este campo.
    */
  public void setValor_vendor(String PARAM) {
    valor_vendor = PARAM;
  }
  /**
    * CARTEIRA: M�todo Gets para este campo
    */
  public String getCarteira() {
    return carteira;
  }
  /**
    * CARTEIRA: M�todo Sets p�ra este campo.
    */
  public void setCarteira(String PARAM) {
    carteira = PARAM;
  }
  /**
    * LINK: M�todo Gets para este campo
    */
  public String getLink() {
    return link;
  }
  /**
    * LINK: M�todo Sets p�ra este campo.
    */
  public void setLink(String PARAM) {
    link = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cliente = null;
    cnpj = null;
    duplicata = null;
    pedido = null;
    nf = null;
    rep = null;
    existe = null;
    serie = null;
    emp_empresa = null;
    fil_filial = null;
    tip = null;
    empresa = null;
    status = null;
    dt_emissao = null;
    dt_venc = null;
    cli_cdgo = null;
    esc_seqn = null;
    dt_pagamento = null;
    triplic = null;
    anuencia = null;
    ins_prot = null;
    nr_banco = null;
    desc_pontualidade = null;
    desc_antecipacao = null;
    juros = null;
    valor_receb = null;
    valor_abatim = null;
    desconto = null;
    cartorio = null;
    desban = null;
    saldo = null;
    filial = null;
    tip_codigo = null;
    titulo = null;
    rep_codigo = null;
    rec_prot = null;
    valor = null;
    encargos = null;
    valor_vendor = null;
    carteira = null;
    link = null;
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
