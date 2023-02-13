package portalbr.dbobj.table;

/** DataBase Object from table EXP.Emula_itens_faturas_proformas
  * @version 05/08/2014 09:46:37
  */
public class Emula_itens_faturas_proformas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer numero_pedido;
  private java.lang.Integer numero_item;
  private java.lang.Integer codigo_linha;
  private java.lang.Integer codigo_referencia;
  private java.lang.Integer codigo_cabedal;
  private java.lang.Integer codigo_cor;
  private java.lang.Integer codigo_grade;
  private java.lang.Double quantidade_pares;
  private java.lang.Double preco_unitario;
  private java.lang.String descricao_item;
  private java.lang.String descricao_erro;
  private java.lang.String loja_cliente;
  private java.lang.Integer codigo_corrugado;

  public Emula_itens_faturas_proformas() {
  }

  public java.lang.Integer getNumero_pedido() {
    return numero_pedido;
  }

  public void setNumero_pedido(java.lang.Integer PARAM) {
    this.numero_pedido = PARAM;
  }

  public java.lang.Integer getNumero_item() {
    return numero_item;
  }

  public void setNumero_item(java.lang.Integer PARAM) {
    this.numero_item = PARAM;
  }

  public java.lang.Integer getCodigo_linha() {
    return codigo_linha;
  }

  public void setCodigo_linha(java.lang.Integer PARAM) {
    this.codigo_linha = PARAM;
  }

  public java.lang.Integer getCodigo_referencia() {
    return codigo_referencia;
  }

  public void setCodigo_referencia(java.lang.Integer PARAM) {
    this.codigo_referencia = PARAM;
  }

  public java.lang.Integer getCodigo_cabedal() {
    return codigo_cabedal;
  }

  public void setCodigo_cabedal(java.lang.Integer PARAM) {
    this.codigo_cabedal = PARAM;
  }

  public java.lang.Integer getCodigo_cor() {
    return codigo_cor;
  }

  public void setCodigo_cor(java.lang.Integer PARAM) {
    this.codigo_cor = PARAM;
  }

  public java.lang.Integer getCodigo_grade() {
    return codigo_grade;
  }

  public void setCodigo_grade(java.lang.Integer PARAM) {
    this.codigo_grade = PARAM;
  }

  public java.lang.Double getQuantidade_pares() {
    return quantidade_pares;
  }

  public void setQuantidade_pares(java.lang.Double PARAM) {
    this.quantidade_pares = PARAM;
  }

  public java.lang.Double getPreco_unitario() {
    return preco_unitario;
  }

  public void setPreco_unitario(java.lang.Double PARAM) {
    this.preco_unitario = PARAM;
  }

  public java.lang.String getDescricao_item() {
    return descricao_item;
  }

  public void setDescricao_item(java.lang.String PARAM) {
    this.descricao_item = PARAM;
  }

  public java.lang.String getDescricao_erro() {
    return descricao_erro;
  }

  public void setDescricao_erro(java.lang.String PARAM) {
    this.descricao_erro = PARAM;
  }

  public java.lang.String getLoja_cliente() {
    return loja_cliente;
  }

  public void setLoja_cliente(java.lang.String PARAM) {
    this.loja_cliente = PARAM;
  }

  public java.lang.Integer getCodigo_corrugado() {
    return codigo_corrugado;
  }

  public void setCodigo_corrugado(java.lang.Integer PARAM) {
    this.codigo_corrugado = PARAM;
  }

}
