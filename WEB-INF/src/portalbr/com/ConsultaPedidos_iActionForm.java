package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/03/2006 14:14:38
 * Last Modify Date 11/11/2021 14:37:31
 */

public class ConsultaPedidos_iActionForm extends org.apache.struts.action.ActionForm
{
  public String imagem;
  public String p_rep;
  public String p_ped_repres;
  public String ped_beira_rio;
  public String recolocado;
  public String czf_nmro;
  public String tipo;
  public String ped_repres;
  public String ped_afv;
  public String ped_cliente;
  public String st;
  public String fora_normas;
  public String frete_isento;
  public String nota;
  public String cliente;
  public String seq;
  public String rep;
  public String transportadora;
  public String consignatario;
  public String bon2h;
  public String bon1h;
  public String bon1;
  public String bon2;
  public String desconto_public;
  public String ped_boni_avaria;
  public String ped_comr;
  public String corr;
  public String emb;
  public String pino_anel;
  public String livro;
  public String cond_pagamento;
  public String dt_entrega;
  public String ped_data_faturamento;
  public String dt_digitacao;
  public String previsao_faturamento;
  public String previsao_fat;
  public String observ;
  public String ped_invoice;
  public String desc_com_original;
  public String desc_prom_original;
  public String livro_original;
  public String pedido_beira_rio;
  public String fil_filial;
  public String moeda;
  public String codigo_embalagem;
  public String codigo_corrugado;
  public String frete;
  public String item;
  public String remove;
  private boolean valida = false;
  public ConsultaPedidos_iActionForm() {
  }
  /**
    * IMAGEM: Method to get the field value.
    */
  public String getImagem() {
    return imagem;
  }
  /**
    * IMAGEM: Method to set the field value.
    */
  public void setImagem(String PARAM) {
    imagem = PARAM;
  }
  /**
    * P_REP: Method to get the field value.
    */
  public String getP_rep() {
    return p_rep;
  }
  /**
    * P_REP: Method to set the field value.
    */
  public void setP_rep(String PARAM) {
    p_rep = PARAM;
  }
  /**
    * P_PED_REPRES: Method to get the field value.
    */
  public String getP_ped_repres() {
    return p_ped_repres;
  }
  /**
    * P_PED_REPRES: Method to set the field value.
    */
  public void setP_ped_repres(String PARAM) {
    p_ped_repres = PARAM;
  }
  /**
    * PED_BEIRA_RIO: Method to get the field value.
    */
  public String getPed_beira_rio() {
    return ped_beira_rio;
  }
  /**
    * PED_BEIRA_RIO: Method to set the field value.
    */
  public void setPed_beira_rio(String PARAM) {
    ped_beira_rio = PARAM;
  }
  /**
    * RECOLOCADO: Method to get the field value.
    */
  public String getRecolocado() {
    return recolocado;
  }
  /**
    * RECOLOCADO: Method to set the field value.
    */
  public void setRecolocado(String PARAM) {
    recolocado = PARAM;
  }
  /**
    * CZF_NMRO: Method to get the field value.
    */
  public String getCzf_nmro() {
    return czf_nmro;
  }
  /**
    * CZF_NMRO: Method to set the field value.
    */
  public void setCzf_nmro(String PARAM) {
    czf_nmro = PARAM;
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * PED_REPRES: Method to get the field value.
    */
  public String getPed_repres() {
    return ped_repres;
  }
  /**
    * PED_REPRES: Method to set the field value.
    */
  public void setPed_repres(String PARAM) {
    ped_repres = PARAM;
  }
  /**
    * PED_AFV: Method to get the field value.
    */
  public String getPed_afv() {
    return ped_afv;
  }
  /**
    * PED_AFV: Method to set the field value.
    */
  public void setPed_afv(String PARAM) {
    ped_afv = PARAM;
  }
  /**
    * PED_CLIENTE: Method to get the field value.
    */
  public String getPed_cliente() {
    return ped_cliente;
  }
  /**
    * PED_CLIENTE: Method to set the field value.
    */
  public void setPed_cliente(String PARAM) {
    ped_cliente = PARAM;
  }
  /**
    * ST: Method to get the field value.
    */
  public String getSt() {
    return st;
  }
  /**
    * ST: Method to set the field value.
    */
  public void setSt(String PARAM) {
    st = PARAM;
  }
  /**
    * FORA_NORMAS: Method to get the field value.
    */
  public String getFora_normas() {
    return fora_normas;
  }
  /**
    * FORA_NORMAS: Method to set the field value.
    */
  public void setFora_normas(String PARAM) {
    fora_normas = PARAM;
  }
  /**
    * FRETE_ISENTO: Method to get the field value.
    */
  public String getFrete_isento() {
    return frete_isento;
  }
  /**
    * FRETE_ISENTO: Method to set the field value.
    */
  public void setFrete_isento(String PARAM) {
    frete_isento = PARAM;
  }
  /**
    * NOTA: Method to get the field value.
    */
  public String getNota() {
    return nota;
  }
  /**
    * NOTA: Method to set the field value.
    */
  public void setNota(String PARAM) {
    nota = PARAM;
  }
  /**
    * CLIENTE: Method to get the field value.
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Method to set the field value.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * SEQ: Method to get the field value.
    */
  public String getSeq() {
    return seq;
  }
  /**
    * SEQ: Method to set the field value.
    */
  public void setSeq(String PARAM) {
    seq = PARAM;
  }
  /**
    * REP: Method to get the field value.
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: Method to set the field value.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
  }
  /**
    * TRANSPORTADORA: Method to get the field value.
    */
  public String getTransportadora() {
    return transportadora;
  }
  /**
    * TRANSPORTADORA: Method to set the field value.
    */
  public void setTransportadora(String PARAM) {
    transportadora = PARAM;
  }
  /**
    * CONSIGNATARIO: Method to get the field value.
    */
  public String getConsignatario() {
    return consignatario;
  }
  /**
    * CONSIGNATARIO: Method to set the field value.
    */
  public void setConsignatario(String PARAM) {
    consignatario = PARAM;
  }
  /**
    * BON2H: Method to get the field value.
    */
  public String getBon2h() {
    return bon2h;
  }
  /**
    * BON2H: Method to set the field value.
    */
  public void setBon2h(String PARAM) {
    bon2h = PARAM;
  }
  /**
    * BON1H: Method to get the field value.
    */
  public String getBon1h() {
    return bon1h;
  }
  /**
    * BON1H: Method to set the field value.
    */
  public void setBon1h(String PARAM) {
    bon1h = PARAM;
  }
  /**
    * BON1: Method to get the field value.
    */
  public String getBon1() {
    return bon1;
  }
  /**
    * BON1: Method to set the field value.
    */
  public void setBon1(String PARAM) {
    bon1 = PARAM;
  }
  /**
    * BON2: Method to get the field value.
    */
  public String getBon2() {
    return bon2;
  }
  /**
    * BON2: Method to set the field value.
    */
  public void setBon2(String PARAM) {
    bon2 = PARAM;
  }
  /**
    * DESCONTO_PUBLIC: Method to get the field value.
    */
  public String getDesconto_public() {
    return desconto_public;
  }
  /**
    * DESCONTO_PUBLIC: Method to set the field value.
    */
  public void setDesconto_public(String PARAM) {
    desconto_public = PARAM;
  }
  /**
    * PED_BONI_AVARIA: Method to get the field value.
    */
  public String getPed_boni_avaria() {
    return ped_boni_avaria;
  }
  /**
    * PED_BONI_AVARIA: Method to set the field value.
    */
  public void setPed_boni_avaria(String PARAM) {
    ped_boni_avaria = PARAM;
  }
  /**
    * PED_COMR: Method to get the field value.
    */
  public String getPed_comr() {
    return ped_comr;
  }
  /**
    * PED_COMR: Method to set the field value.
    */
  public void setPed_comr(String PARAM) {
    ped_comr = PARAM;
  }
  /**
    * CORR: Method to get the field value.
    */
  public String getCorr() {
    return corr;
  }
  /**
    * CORR: Method to set the field value.
    */
  public void setCorr(String PARAM) {
    corr = PARAM;
  }
  /**
    * EMB: Method to get the field value.
    */
  public String getEmb() {
    return emb;
  }
  /**
    * EMB: Method to set the field value.
    */
  public void setEmb(String PARAM) {
    emb = PARAM;
  }
  /**
    * PINO_ANEL: Method to get the field value.
    */
  public String getPino_anel() {
    return pino_anel;
  }
  /**
    * PINO_ANEL: Method to set the field value.
    */
  public void setPino_anel(String PARAM) {
    pino_anel = PARAM;
  }
  /**
    * LIVRO: Method to get the field value.
    */
  public String getLivro() {
    return livro;
  }
  /**
    * LIVRO: Method to set the field value.
    */
  public void setLivro(String PARAM) {
    livro = PARAM;
  }
  /**
    * COND_PAGAMENTO: Method to get the field value.
    */
  public String getCond_pagamento() {
    return cond_pagamento;
  }
  /**
    * COND_PAGAMENTO: Method to set the field value.
    */
  public void setCond_pagamento(String PARAM) {
    cond_pagamento = PARAM;
  }
  /**
    * DT_ENTREGA: Method to get the field value.
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Method to set the field value.
    */
  public void setDt_entrega(String PARAM) {
    dt_entrega = PARAM;
  }
  /**
    * PED_DATA_FATURAMENTO: Method to get the field value.
    */
  public String getPed_data_faturamento() {
    return ped_data_faturamento;
  }
  /**
    * PED_DATA_FATURAMENTO: Method to set the field value.
    */
  public void setPed_data_faturamento(String PARAM) {
    ped_data_faturamento = PARAM;
  }
  /**
    * DT_DIGITACAO: Method to get the field value.
    */
  public String getDt_digitacao() {
    return dt_digitacao;
  }
  /**
    * DT_DIGITACAO: Method to set the field value.
    */
  public void setDt_digitacao(String PARAM) {
    dt_digitacao = PARAM;
  }
  /**
    * PREVISAO_FATURAMENTO: Method to get the field value.
    */
  public String getPrevisao_faturamento() {
    return previsao_faturamento;
  }
  /**
    * PREVISAO_FATURAMENTO: Method to set the field value.
    */
  public void setPrevisao_faturamento(String PARAM) {
    previsao_faturamento = PARAM;
  }
  /**
    * PREVISAO_FAT: Method to get the field value.
    */
  public String getPrevisao_fat() {
    return previsao_fat;
  }
  /**
    * PREVISAO_FAT: Method to set the field value.
    */
  public void setPrevisao_fat(String PARAM) {
    previsao_fat = PARAM;
  }
  /**
    * OBSERV: Method to get the field value.
    */
  public String getObserv() {
    return observ;
  }
  /**
    * OBSERV: Method to set the field value.
    */
  public void setObserv(String PARAM) {
    observ = PARAM;
  }
  /**
    * PED_INVOICE: Method to get the field value.
    */
  public String getPed_invoice() {
    return ped_invoice;
  }
  /**
    * PED_INVOICE: Method to set the field value.
    */
  public void setPed_invoice(String PARAM) {
    ped_invoice = PARAM;
  }
  /**
    * DESC_COM_ORIGINAL: Method to get the field value.
    */
  public String getDesc_com_original() {
    return desc_com_original;
  }
  /**
    * DESC_COM_ORIGINAL: Method to set the field value.
    */
  public void setDesc_com_original(String PARAM) {
    desc_com_original = PARAM;
  }
  /**
    * DESC_PROM_ORIGINAL: Method to get the field value.
    */
  public String getDesc_prom_original() {
    return desc_prom_original;
  }
  /**
    * DESC_PROM_ORIGINAL: Method to set the field value.
    */
  public void setDesc_prom_original(String PARAM) {
    desc_prom_original = PARAM;
  }
  /**
    * LIVRO_ORIGINAL: Method to get the field value.
    */
  public String getLivro_original() {
    return livro_original;
  }
  /**
    * LIVRO_ORIGINAL: Method to set the field value.
    */
  public void setLivro_original(String PARAM) {
    livro_original = PARAM;
  }
  /**
    * PEDIDO_BEIRA_RIO: Method to get the field value.
    */
  public String getPedido_beira_rio() {
    return pedido_beira_rio;
  }
  /**
    * PEDIDO_BEIRA_RIO: Method to set the field value.
    */
  public void setPedido_beira_rio(String PARAM) {
    pedido_beira_rio = PARAM;
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
    * MOEDA: Method to get the field value.
    */
  public String getMoeda() {
    return moeda;
  }
  /**
    * MOEDA: Method to set the field value.
    */
  public void setMoeda(String PARAM) {
    moeda = PARAM;
  }
  /**
    * CODIGO_EMBALAGEM: Method to get the field value.
    */
  public String getCodigo_embalagem() {
    return codigo_embalagem;
  }
  /**
    * CODIGO_EMBALAGEM: Method to set the field value.
    */
  public void setCodigo_embalagem(String PARAM) {
    codigo_embalagem = PARAM;
  }
  /**
    * CODIGO_CORRUGADO: Method to get the field value.
    */
  public String getCodigo_corrugado() {
    return codigo_corrugado;
  }
  /**
    * CODIGO_CORRUGADO: Method to set the field value.
    */
  public void setCodigo_corrugado(String PARAM) {
    codigo_corrugado = PARAM;
  }
  /**
    * FRETE: Method to get the field value.
    */
  public String getFrete() {
    return frete;
  }
  /**
    * FRETE: Method to set the field value.
    */
  public void setFrete(String PARAM) {
    frete = PARAM;
  }
  /**
    * ITEM: Method to get the field value.
    */
  public String getItem() {
    return item;
  }
  /**
    * ITEM: Method to set the field value.
    */
  public void setItem(String PARAM) {
    item = PARAM;
  }
  /**
    * REMOVE: Method to get the field value.
    */
  public String getRemove() {
    return remove;
  }
  /**
    * REMOVE: Method to set the field value.
    */
  public void setRemove(String PARAM) {
    remove = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    imagem = null;
    p_rep = null;
    p_ped_repres = null;
    ped_beira_rio = null;
    recolocado = null;
    czf_nmro = null;
    tipo = null;
    ped_repres = null;
    ped_afv = null;
    ped_cliente = null;
    st = null;
    fora_normas = null;
    frete_isento = null;
    nota = null;
    cliente = null;
    seq = null;
    rep = null;
    transportadora = null;
    consignatario = null;
    bon2h = null;
    bon1h = null;
    bon1 = null;
    bon2 = null;
    desconto_public = null;
    ped_boni_avaria = null;
    ped_comr = null;
    corr = null;
    emb = null;
    pino_anel = null;
    livro = null;
    cond_pagamento = null;
    dt_entrega = null;
    ped_data_faturamento = null;
    dt_digitacao = null;
    previsao_faturamento = null;
    previsao_fat = null;
    observ = null;
    ped_invoice = null;
    desc_com_original = null;
    desc_prom_original = null;
    livro_original = null;
    pedido_beira_rio = null;
    fil_filial = null;
    moeda = null;
    codigo_embalagem = null;
    codigo_corrugado = null;
    frete = null;
    item = null;
    remove = null;
  }
  /**
    * Validate fields and return errors.
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
