package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arq_compra_oc_log
  * @version 22/09/2016 08:45:00
  */
public class Interface_arq_compra_oc_log implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer interface_arq_compra_id;
  private java.lang.Integer oco_numero;
  private java.lang.String situacao;
  private java.sql.Timestamp data_transacao;
  private java.lang.String usuario;

  public Interface_arq_compra_oc_log() {
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

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.sql.Timestamp getData_transacao() {
    return data_transacao;
  }

  public void setData_transacao(java.sql.Timestamp PARAM) {
    this.data_transacao = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

}
