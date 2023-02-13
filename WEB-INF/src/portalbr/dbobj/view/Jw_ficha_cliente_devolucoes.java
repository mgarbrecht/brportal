package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_devolucoes
  * @version 03/04/2013 09:30:05
  */
public class Jw_ficha_cliente_devolucoes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ordem;
  private java.sql.Timestamp data_cad;
  private java.lang.Integer nfs_nmro;
  private java.lang.Integer pares;
  private java.lang.Double valor;

  public Jw_ficha_cliente_devolucoes() {
  }

  public java.lang.Integer getOrdem() {
    return ordem;
  }

  public void setOrdem(java.lang.Integer PARAM) {
    this.ordem = PARAM;
  }

  public java.sql.Timestamp getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Timestamp PARAM) {
    this.data_cad = PARAM;
  }

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

  public java.lang.Double getValor() {
    return valor;
  }

  public void setValor(java.lang.Double PARAM) {
    this.valor = PARAM;
  }

}
