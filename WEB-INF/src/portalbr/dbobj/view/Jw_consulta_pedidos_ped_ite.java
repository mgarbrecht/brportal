package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_ped_ite
  * @version 09/09/2021 15:15:46
  */
public class Jw_consulta_pedidos_ped_ite implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ped_beira_rio;
  private java.lang.String tipo;
  private java.lang.String ped_repres;
  private java.lang.String ped_cliente;
  private java.lang.String st;
  private java.lang.Integer nota;
  private java.lang.String serie;
  private java.lang.String cliente;
  private java.lang.String rep;
  private java.lang.String transportadora;
  private java.lang.Double bon1;
  private java.lang.Double bon2;
  private double desconto_public;
  private java.lang.String corr;
  private java.lang.String emb;
  private java.lang.String pino_anel;
  private java.lang.String livro;
  private java.lang.String cond_pagamento;
  private java.sql.Timestamp dt_entrega;
  private java.lang.String ped_data_faturamento;
  private java.lang.String dt_digitacao;
  private java.lang.String ped_afv;
  private double seq;
  private java.lang.String especie;
  private java.lang.String observ;
  private java.lang.String moeda;
  private java.lang.String czf_nmro;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.Integer codigo_corrugado;
  private java.lang.Integer codigo_embalagem;
  private java.lang.Integer les_codigo;
  private java.lang.String previsao_faturamento;
  private java.lang.String previsao_fat;
  private java.lang.String ped_invoice;
  private java.lang.String imagem;
  private java.lang.String frete;
  private java.lang.String recolocado;
  private java.lang.String ped_stat;
  private java.lang.String fora_normas;
  private java.lang.Double ped_comr;
  private java.lang.Double ped_boni_avaria;
  private java.lang.Double desc_com_original;
  private java.lang.Double desc_prom_original;
  private java.lang.String livro_original;
  private java.lang.String frete_isento;

  public Jw_consulta_pedidos_ped_ite() {
  }

  public java.lang.Integer getPed_beira_rio() {
    return ped_beira_rio;
  }

  public void setPed_beira_rio(java.lang.Integer PARAM) {
    this.ped_beira_rio = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.String getPed_repres() {
    return ped_repres;
  }

  public void setPed_repres(java.lang.String PARAM) {
    this.ped_repres = PARAM;
  }

  public java.lang.String getPed_cliente() {
    return ped_cliente;
  }

  public void setPed_cliente(java.lang.String PARAM) {
    this.ped_cliente = PARAM;
  }

  public java.lang.String getSt() {
    return st;
  }

  public void setSt(java.lang.String PARAM) {
    this.st = PARAM;
  }

  public java.lang.Integer getNota() {
    return nota;
  }

  public void setNota(java.lang.Integer PARAM) {
    this.nota = PARAM;
  }

  public java.lang.String getSerie() {
    return serie;
  }

  public void setSerie(java.lang.String PARAM) {
    this.serie = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getRep() {
    return rep;
  }

  public void setRep(java.lang.String PARAM) {
    this.rep = PARAM;
  }

  public java.lang.String getTransportadora() {
    return transportadora;
  }

  public void setTransportadora(java.lang.String PARAM) {
    this.transportadora = PARAM;
  }

  public java.lang.Double getBon1() {
    return bon1;
  }

  public void setBon1(java.lang.Double PARAM) {
    this.bon1 = PARAM;
  }

  public java.lang.Double getBon2() {
    return bon2;
  }

  public void setBon2(java.lang.Double PARAM) {
    this.bon2 = PARAM;
  }

  public double getDesconto_public() {
    return desconto_public;
  }

  public void setDesconto_public(double PARAM) {
    this.desconto_public = PARAM;
  }

  public java.lang.String getCorr() {
    return corr;
  }

  public void setCorr(java.lang.String PARAM) {
    this.corr = PARAM;
  }

  public java.lang.String getEmb() {
    return emb;
  }

  public void setEmb(java.lang.String PARAM) {
    this.emb = PARAM;
  }

  public java.lang.String getPino_anel() {
    return pino_anel;
  }

  public void setPino_anel(java.lang.String PARAM) {
    this.pino_anel = PARAM;
  }

  public java.lang.String getLivro() {
    return livro;
  }

  public void setLivro(java.lang.String PARAM) {
    this.livro = PARAM;
  }

  public java.lang.String getCond_pagamento() {
    return cond_pagamento;
  }

  public void setCond_pagamento(java.lang.String PARAM) {
    this.cond_pagamento = PARAM;
  }

  public java.sql.Timestamp getDt_entrega() {
    return dt_entrega;
  }

  public void setDt_entrega(java.sql.Timestamp PARAM) {
    this.dt_entrega = PARAM;
  }

  public java.lang.String getPed_data_faturamento() {
    return ped_data_faturamento;
  }

  public void setPed_data_faturamento(java.lang.String PARAM) {
    this.ped_data_faturamento = PARAM;
  }

  public java.lang.String getDt_digitacao() {
    return dt_digitacao;
  }

  public void setDt_digitacao(java.lang.String PARAM) {
    this.dt_digitacao = PARAM;
  }

  public java.lang.String getPed_afv() {
    return ped_afv;
  }

  public void setPed_afv(java.lang.String PARAM) {
    this.ped_afv = PARAM;
  }

  public double getSeq() {
    return seq;
  }

  public void setSeq(double PARAM) {
    this.seq = PARAM;
  }

  public java.lang.String getEspecie() {
    return especie;
  }

  public void setEspecie(java.lang.String PARAM) {
    this.especie = PARAM;
  }

  public java.lang.String getObserv() {
    return observ;
  }

  public void setObserv(java.lang.String PARAM) {
    this.observ = PARAM;
  }

  public java.lang.String getMoeda() {
    return moeda;
  }

  public void setMoeda(java.lang.String PARAM) {
    this.moeda = PARAM;
  }

  public java.lang.String getCzf_nmro() {
    return czf_nmro;
  }

  public void setCzf_nmro(java.lang.String PARAM) {
    this.czf_nmro = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.Integer getCodigo_corrugado() {
    return codigo_corrugado;
  }

  public void setCodigo_corrugado(java.lang.Integer PARAM) {
    this.codigo_corrugado = PARAM;
  }

  public java.lang.Integer getCodigo_embalagem() {
    return codigo_embalagem;
  }

  public void setCodigo_embalagem(java.lang.Integer PARAM) {
    this.codigo_embalagem = PARAM;
  }

  public java.lang.Integer getLes_codigo() {
    return les_codigo;
  }

  public void setLes_codigo(java.lang.Integer PARAM) {
    this.les_codigo = PARAM;
  }

  public java.lang.String getPrevisao_faturamento() {
    return previsao_faturamento;
  }

  public void setPrevisao_faturamento(java.lang.String PARAM) {
    this.previsao_faturamento = PARAM;
  }

  public java.lang.String getPrevisao_fat() {
    return previsao_fat;
  }

  public void setPrevisao_fat(java.lang.String PARAM) {
    this.previsao_fat = PARAM;
  }

  public java.lang.String getPed_invoice() {
    return ped_invoice;
  }

  public void setPed_invoice(java.lang.String PARAM) {
    this.ped_invoice = PARAM;
  }

  public java.lang.String getImagem() {
    return imagem;
  }

  public void setImagem(java.lang.String PARAM) {
    this.imagem = PARAM;
  }

  public java.lang.String getFrete() {
    return frete;
  }

  public void setFrete(java.lang.String PARAM) {
    this.frete = PARAM;
  }

  public java.lang.String getRecolocado() {
    return recolocado;
  }

  public void setRecolocado(java.lang.String PARAM) {
    this.recolocado = PARAM;
  }

  public java.lang.String getPed_stat() {
    return ped_stat;
  }

  public void setPed_stat(java.lang.String PARAM) {
    this.ped_stat = PARAM;
  }

  public java.lang.String getFora_normas() {
    return fora_normas;
  }

  public void setFora_normas(java.lang.String PARAM) {
    this.fora_normas = PARAM;
  }

  public java.lang.Double getPed_comr() {
    return ped_comr;
  }

  public void setPed_comr(java.lang.Double PARAM) {
    this.ped_comr = PARAM;
  }

  public java.lang.Double getPed_boni_avaria() {
    return ped_boni_avaria;
  }

  public void setPed_boni_avaria(java.lang.Double PARAM) {
    this.ped_boni_avaria = PARAM;
  }

  public java.lang.Double getDesc_com_original() {
    return desc_com_original;
  }

  public void setDesc_com_original(java.lang.Double PARAM) {
    this.desc_com_original = PARAM;
  }

  public java.lang.Double getDesc_prom_original() {
    return desc_prom_original;
  }

  public void setDesc_prom_original(java.lang.Double PARAM) {
    this.desc_prom_original = PARAM;
  }

  public java.lang.String getLivro_original() {
    return livro_original;
  }

  public void setLivro_original(java.lang.String PARAM) {
    this.livro_original = PARAM;
  }

  public java.lang.String getFrete_isento() {
    return frete_isento;
  }

  public void setFrete_isento(java.lang.String PARAM) {
    this.frete_isento = PARAM;
  }

}
