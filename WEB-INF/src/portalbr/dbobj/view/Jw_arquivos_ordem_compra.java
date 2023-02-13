package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivos_ordem_compra
  * @version 07/04/2022 14:27:42
  */
public class Jw_arquivos_ordem_compra implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer forn_codigo;
  private java.lang.Integer interface_arq_compra_id;
  private java.lang.Integer oco_numero;
  private java.lang.String fil_filial;
  private java.sql.Timestamp data_emissao;
  private java.lang.String cond_pagto;
  private java.lang.String arquivo_edi;
  private java.lang.String situacao;
  private java.lang.String descricao_situacao;
  private java.sql.Timestamp data_entrega;
  private java.lang.String forn_razsoc;
  private java.lang.Integer rem_nro;
  private java.lang.String visualizado;
  private java.lang.String amostra;
  private java.lang.Integer lin_cdgo;
  private java.sql.Date data_entrega_fornecedor;
  private java.lang.Integer situacao_ordem_compra;

  public Jw_arquivos_ordem_compra() {
  }

  public java.lang.Integer getForn_codigo() {
    return forn_codigo;
  }

  public void setForn_codigo(java.lang.Integer PARAM) {
    this.forn_codigo = PARAM;
  }

  public java.lang.Integer getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }

  public void setInterface_arq_compra_id(java.lang.Integer PARAM) {
    this.interface_arq_compra_id = PARAM;
  }

  public java.lang.Integer getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(java.lang.Integer PARAM) {
    this.oco_numero = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.sql.Timestamp getData_emissao() {
    return data_emissao;
  }

  public void setData_emissao(java.sql.Timestamp PARAM) {
    this.data_emissao = PARAM;
  }

  public java.lang.String getCond_pagto() {
    return cond_pagto;
  }

  public void setCond_pagto(java.lang.String PARAM) {
    this.cond_pagto = PARAM;
  }

  public java.lang.String getArquivo_edi() {
    return arquivo_edi;
  }

  public void setArquivo_edi(java.lang.String PARAM) {
    this.arquivo_edi = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

  public java.sql.Timestamp getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Timestamp PARAM) {
    this.data_entrega = PARAM;
  }

  public java.lang.String getForn_razsoc() {
    return forn_razsoc;
  }

  public void setForn_razsoc(java.lang.String PARAM) {
    this.forn_razsoc = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.lang.String getVisualizado() {
    return visualizado;
  }

  public void setVisualizado(java.lang.String PARAM) {
    this.visualizado = PARAM;
  }

  public java.lang.String getAmostra() {
    return amostra;
  }

  public void setAmostra(java.lang.String PARAM) {
    this.amostra = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.sql.Date getData_entrega_fornecedor() {
    return data_entrega_fornecedor;
  }

  public void setData_entrega_fornecedor(java.sql.Date PARAM) {
    this.data_entrega_fornecedor = PARAM;
  }

  public java.lang.Integer getSituacao_ordem_compra() {
    return situacao_ordem_compra;
  }

  public void setSituacao_ordem_compra(java.lang.Integer PARAM) {
    this.situacao_ordem_compra = PARAM;
  }

}
