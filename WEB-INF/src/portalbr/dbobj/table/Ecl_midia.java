package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ecl_midia
  * @version 03/04/2013 09:59:13
  */
public class Ecl_midia implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo_marca;
  private java.lang.Integer codigo_regional;
  private java.lang.Integer codigo_cliente;
  private java.lang.Integer codigo_sequencial;

  public Ecl_midia() {
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.Integer getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(java.lang.Integer PARAM) {
    this.codigo_cliente = PARAM;
  }

  public java.lang.Integer getCodigo_sequencial() {
    return codigo_sequencial;
  }

  public void setCodigo_sequencial(java.lang.Integer PARAM) {
    this.codigo_sequencial = PARAM;
  }

}
