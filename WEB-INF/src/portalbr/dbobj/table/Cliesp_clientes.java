package portalbr.dbobj.table;

/** DataBase Object from table ESP.Cliesp_clientes
  * @version 03/04/2013 10:02:25
  */
public class Cliesp_clientes implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String cliente;
  private java.lang.String tipo_cliente;
  private int codigo_regional;

  public Cliesp_clientes() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getTipo_cliente() {
    return tipo_cliente;
  }

  public void setTipo_cliente(java.lang.String PARAM) {
    this.tipo_cliente = PARAM;
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

}
