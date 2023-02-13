package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arquivo_compra_oc
  * @version 10/08/2015 08:13:45
  */
public class Interface_arquivo_compra_oc implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer interface_arquivo_compra_id;
  private java.lang.Integer oco_numero;
  private java.lang.Integer sequencia_item;
  private java.lang.Long cnpj_cliente;
  private java.lang.Integer rem_nro;
  private java.sql.Timestamp data_compra;
  private java.lang.String tipo_operacao;
  private java.sql.Timestamp data_entrega;
  private java.lang.String local_entrega;
  private java.lang.String fil_filial;
  private java.lang.Integer ies_codigo;
  private java.lang.Double quant_comprada;
  private java.lang.String unm_codigo;
  private java.lang.Double percentual_icms;
  private java.lang.Double preco_unitario;
  private java.lang.String moe_codigo;
  private java.lang.String cond_pagto;
  private java.lang.Double desconto;
  private java.lang.String drawback;
  private java.lang.String uso_cliente;
  private java.lang.String descricao_produto;
  private java.lang.Long cnpj_fornecedor;
  private java.lang.String observacoes;
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.String tai_codigo;
  private java.lang.String nomenclatura;
  private java.lang.String lote;
  private java.lang.String desc_grupo_material;
  private java.lang.String nome_comprador;
  private java.lang.String email_comprador;
  private java.lang.String marca_cliente;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dthr_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp dthr_alteracao;

  public Interface_arquivo_compra_oc() {
  }

  public java.lang.Integer getInterface_arquivo_compra_id() {
    return interface_arquivo_compra_id;
  }

  public void setInterface_arquivo_compra_id(java.lang.Integer PARAM) {
    this.interface_arquivo_compra_id = PARAM;
  }

  public java.lang.Integer getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(java.lang.Integer PARAM) {
    this.oco_numero = PARAM;
  }

  public java.lang.Integer getSequencia_item() {
    return sequencia_item;
  }

  public void setSequencia_item(java.lang.Integer PARAM) {
    this.sequencia_item = PARAM;
  }

  public java.lang.Long getCnpj_cliente() {
    return cnpj_cliente;
  }

  public void setCnpj_cliente(java.lang.Long PARAM) {
    this.cnpj_cliente = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.sql.Timestamp getData_compra() {
    return data_compra;
  }

  public void setData_compra(java.sql.Timestamp PARAM) {
    this.data_compra = PARAM;
  }

  public java.lang.String getTipo_operacao() {
    return tipo_operacao;
  }

  public void setTipo_operacao(java.lang.String PARAM) {
    this.tipo_operacao = PARAM;
  }

  public java.sql.Timestamp getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Timestamp PARAM) {
    this.data_entrega = PARAM;
  }

  public java.lang.String getLocal_entrega() {
    return local_entrega;
  }

  public void setLocal_entrega(java.lang.String PARAM) {
    this.local_entrega = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.Integer getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.Integer PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.Double getQuant_comprada() {
    return quant_comprada;
  }

  public void setQuant_comprada(java.lang.Double PARAM) {
    this.quant_comprada = PARAM;
  }

  public java.lang.String getUnm_codigo() {
    return unm_codigo;
  }

  public void setUnm_codigo(java.lang.String PARAM) {
    this.unm_codigo = PARAM;
  }

  public java.lang.Double getPercentual_icms() {
    return percentual_icms;
  }

  public void setPercentual_icms(java.lang.Double PARAM) {
    this.percentual_icms = PARAM;
  }

  public java.lang.Double getPreco_unitario() {
    return preco_unitario;
  }

  public void setPreco_unitario(java.lang.Double PARAM) {
    this.preco_unitario = PARAM;
  }

  public java.lang.String getMoe_codigo() {
    return moe_codigo;
  }

  public void setMoe_codigo(java.lang.String PARAM) {
    this.moe_codigo = PARAM;
  }

  public java.lang.String getCond_pagto() {
    return cond_pagto;
  }

  public void setCond_pagto(java.lang.String PARAM) {
    this.cond_pagto = PARAM;
  }

  public java.lang.Double getDesconto() {
    return desconto;
  }

  public void setDesconto(java.lang.Double PARAM) {
    this.desconto = PARAM;
  }

  public java.lang.String getDrawback() {
    return drawback;
  }

  public void setDrawback(java.lang.String PARAM) {
    this.drawback = PARAM;
  }

  public java.lang.String getUso_cliente() {
    return uso_cliente;
  }

  public void setUso_cliente(java.lang.String PARAM) {
    this.uso_cliente = PARAM;
  }

  public java.lang.String getDescricao_produto() {
    return descricao_produto;
  }

  public void setDescricao_produto(java.lang.String PARAM) {
    this.descricao_produto = PARAM;
  }

  public java.lang.Long getCnpj_fornecedor() {
    return cnpj_fornecedor;
  }

  public void setCnpj_fornecedor(java.lang.Long PARAM) {
    this.cnpj_fornecedor = PARAM;
  }

  public java.lang.String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(java.lang.String PARAM) {
    this.observacoes = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.lang.String getTai_codigo() {
    return tai_codigo;
  }

  public void setTai_codigo(java.lang.String PARAM) {
    this.tai_codigo = PARAM;
  }

  public java.lang.String getNomenclatura() {
    return nomenclatura;
  }

  public void setNomenclatura(java.lang.String PARAM) {
    this.nomenclatura = PARAM;
  }

  public java.lang.String getLote() {
    return lote;
  }

  public void setLote(java.lang.String PARAM) {
    this.lote = PARAM;
  }

  public java.lang.String getDesc_grupo_material() {
    return desc_grupo_material;
  }

  public void setDesc_grupo_material(java.lang.String PARAM) {
    this.desc_grupo_material = PARAM;
  }

  public java.lang.String getNome_comprador() {
    return nome_comprador;
  }

  public void setNome_comprador(java.lang.String PARAM) {
    this.nome_comprador = PARAM;
  }

  public java.lang.String getEmail_comprador() {
    return email_comprador;
  }

  public void setEmail_comprador(java.lang.String PARAM) {
    this.email_comprador = PARAM;
  }

  public java.lang.String getMarca_cliente() {
    return marca_cliente;
  }

  public void setMarca_cliente(java.lang.String PARAM) {
    this.marca_cliente = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

}
