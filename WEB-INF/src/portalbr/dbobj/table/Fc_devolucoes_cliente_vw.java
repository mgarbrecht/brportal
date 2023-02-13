package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Fc_devolucoes_cliente_vw
  * @version 03/04/2013 09:57:41
  */
public class Fc_devolucoes_cliente_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String repres;
  private java.lang.Integer cliente;
  private java.sql.Timestamp data_dev;
  private java.lang.Double linha;
  private java.lang.String motivo;
  private java.lang.Double prs;
  private java.lang.Double vlr;

  public Fc_devolucoes_cliente_vw() {
  }

  public java.lang.String getRepres() {
    return repres;
  }

  public void setRepres(java.lang.String PARAM) {
    this.repres = PARAM;
  }

  public java.lang.Integer getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.Integer PARAM) {
    this.cliente = PARAM;
  }

  public java.sql.Timestamp getData_dev() {
    return data_dev;
  }

  public void setData_dev(java.sql.Timestamp PARAM) {
    this.data_dev = PARAM;
  }

  public java.lang.Double getLinha() {
    return linha;
  }

  public void setLinha(java.lang.Double PARAM) {
    this.linha = PARAM;
  }

  public java.lang.String getMotivo() {
    return motivo;
  }

  public void setMotivo(java.lang.String PARAM) {
    this.motivo = PARAM;
  }

  public java.lang.Double getPrs() {
    return prs;
  }

  public void setPrs(java.lang.Double PARAM) {
    this.prs = PARAM;
  }

  public java.lang.Double getVlr() {
    return vlr;
  }

  public void setVlr(java.lang.Double PARAM) {
    this.vlr = PARAM;
  }

}
