package portalbr.dbobj.table;

/** DataBase Object from table EXP.Emula_grades_itens_proformas
  * @version 03/04/2013 09:58:48
  */
public class Emula_grades_itens_proformas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer numero_pedido;
  private java.lang.Integer numero_item;
  private java.lang.String numeracao_par;
  private java.lang.Integer quantidade_pares;

  public Emula_grades_itens_proformas() {
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

  public java.lang.String getNumeracao_par() {
    return numeracao_par;
  }

  public void setNumeracao_par(java.lang.String PARAM) {
    this.numeracao_par = PARAM;
  }

  public java.lang.Integer getQuantidade_pares() {
    return quantidade_pares;
  }

  public void setQuantidade_pares(java.lang.Integer PARAM) {
    this.quantidade_pares = PARAM;
  }

}
