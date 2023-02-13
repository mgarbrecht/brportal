package portalbr.dbobj.table;

/** DataBase Object from table EXP.Emula_faturas_proformas
  * @version 03/04/2013 09:58:57
  */
public class Emula_faturas_proformas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer numero_pedido;
  private java.lang.Integer codigo_cliente;
  private java.lang.Integer estabelecimento_cliente;
  private java.sql.Date data_pedido;
  private java.sql.Date data_entrega;
  private java.lang.Integer codigo_destino;
  private java.lang.Integer codigo_composicao;
  private java.lang.Integer codigo_condicao_pagamento;
  private java.lang.Integer codigo_via_transporte;
  private java.lang.Integer codigo_pessoa_consignado;
  private java.lang.Integer codigo_pessoa_notificado;
  private java.lang.Integer codigo_pessoa_despachante;
  private java.lang.String codigo_moeda;
  private java.lang.Integer codigo_livro;
  private java.lang.String empresa_fatura_proforma;
  private java.lang.Integer ano_fatura_proforma;
  private java.lang.Integer numero_fatura_proforma;
  private java.lang.String nome_planilha;
  private java.sql.Date versao_tabela;
  private java.lang.Integer codigo_pais_tabela;
  private java.lang.String status;

  public Emula_faturas_proformas() {
  }

  public java.lang.Integer getNumero_pedido() {
    return numero_pedido;
  }

  public void setNumero_pedido(java.lang.Integer PARAM) {
    this.numero_pedido = PARAM;
  }

  public java.lang.Integer getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(java.lang.Integer PARAM) {
    this.codigo_cliente = PARAM;
  }

  public java.lang.Integer getEstabelecimento_cliente() {
    return estabelecimento_cliente;
  }

  public void setEstabelecimento_cliente(java.lang.Integer PARAM) {
    this.estabelecimento_cliente = PARAM;
  }

  public java.sql.Date getData_pedido() {
    return data_pedido;
  }

  public void setData_pedido(java.sql.Date PARAM) {
    this.data_pedido = PARAM;
  }

  public java.sql.Date getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Date PARAM) {
    this.data_entrega = PARAM;
  }

  public java.lang.Integer getCodigo_destino() {
    return codigo_destino;
  }

  public void setCodigo_destino(java.lang.Integer PARAM) {
    this.codigo_destino = PARAM;
  }

  public java.lang.Integer getCodigo_composicao() {
    return codigo_composicao;
  }

  public void setCodigo_composicao(java.lang.Integer PARAM) {
    this.codigo_composicao = PARAM;
  }

  public java.lang.Integer getCodigo_condicao_pagamento() {
    return codigo_condicao_pagamento;
  }

  public void setCodigo_condicao_pagamento(java.lang.Integer PARAM) {
    this.codigo_condicao_pagamento = PARAM;
  }

  public java.lang.Integer getCodigo_via_transporte() {
    return codigo_via_transporte;
  }

  public void setCodigo_via_transporte(java.lang.Integer PARAM) {
    this.codigo_via_transporte = PARAM;
  }

  public java.lang.Integer getCodigo_pessoa_consignado() {
    return codigo_pessoa_consignado;
  }

  public void setCodigo_pessoa_consignado(java.lang.Integer PARAM) {
    this.codigo_pessoa_consignado = PARAM;
  }

  public java.lang.Integer getCodigo_pessoa_notificado() {
    return codigo_pessoa_notificado;
  }

  public void setCodigo_pessoa_notificado(java.lang.Integer PARAM) {
    this.codigo_pessoa_notificado = PARAM;
  }

  public java.lang.Integer getCodigo_pessoa_despachante() {
    return codigo_pessoa_despachante;
  }

  public void setCodigo_pessoa_despachante(java.lang.Integer PARAM) {
    this.codigo_pessoa_despachante = PARAM;
  }

  public java.lang.String getCodigo_moeda() {
    return codigo_moeda;
  }

  public void setCodigo_moeda(java.lang.String PARAM) {
    this.codigo_moeda = PARAM;
  }

  public java.lang.Integer getCodigo_livro() {
    return codigo_livro;
  }

  public void setCodigo_livro(java.lang.Integer PARAM) {
    this.codigo_livro = PARAM;
  }

  public java.lang.String getEmpresa_fatura_proforma() {
    return empresa_fatura_proforma;
  }

  public void setEmpresa_fatura_proforma(java.lang.String PARAM) {
    this.empresa_fatura_proforma = PARAM;
  }

  public java.lang.Integer getAno_fatura_proforma() {
    return ano_fatura_proforma;
  }

  public void setAno_fatura_proforma(java.lang.Integer PARAM) {
    this.ano_fatura_proforma = PARAM;
  }

  public java.lang.Integer getNumero_fatura_proforma() {
    return numero_fatura_proforma;
  }

  public void setNumero_fatura_proforma(java.lang.Integer PARAM) {
    this.numero_fatura_proforma = PARAM;
  }

  public java.lang.String getNome_planilha() {
    return nome_planilha;
  }

  public void setNome_planilha(java.lang.String PARAM) {
    this.nome_planilha = PARAM;
  }

  public java.sql.Date getVersao_tabela() {
    return versao_tabela;
  }

  public void setVersao_tabela(java.sql.Date PARAM) {
    this.versao_tabela = PARAM;
  }

  public java.lang.Integer getCodigo_pais_tabela() {
    return codigo_pais_tabela;
  }

  public void setCodigo_pais_tabela(java.lang.Integer PARAM) {
    this.codigo_pais_tabela = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}
