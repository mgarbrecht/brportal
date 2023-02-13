package portalbr.dbobj.table;

/** DataBase Object from table CPR.Atelier_pre_envio_quarterizado
  * @version 02/07/2015 08:41:18
  */
public class Atelier_pre_envio_quarterizado implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer for_codigo;
  private java.lang.Integer for_codigo_quarterizado;
  private java.lang.Integer fen_seq_quarterizado;
  private java.lang.Integer pro_numero;
  private java.sql.Timestamp data_envio;
  private java.sql.Timestamp data_retorno;
  private java.lang.Integer rem_nro;
  private java.lang.Integer tal_nro;
  private java.lang.String status;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;

  public Atelier_pre_envio_quarterizado() {
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.Integer getFor_codigo_quarterizado() {
    return for_codigo_quarterizado;
  }

  public void setFor_codigo_quarterizado(java.lang.Integer PARAM) {
    this.for_codigo_quarterizado = PARAM;
  }

  public java.lang.Integer getFen_seq_quarterizado() {
    return fen_seq_quarterizado;
  }

  public void setFen_seq_quarterizado(java.lang.Integer PARAM) {
    this.fen_seq_quarterizado = PARAM;
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.sql.Timestamp getData_envio() {
    return data_envio;
  }

  public void setData_envio(java.sql.Timestamp PARAM) {
    this.data_envio = PARAM;
  }

  public java.sql.Timestamp getData_retorno() {
    return data_retorno;
  }

  public void setData_retorno(java.sql.Timestamp PARAM) {
    this.data_retorno = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.lang.Integer getTal_nro() {
    return tal_nro;
  }

  public void setTal_nro(java.lang.Integer PARAM) {
    this.tal_nro = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

}
