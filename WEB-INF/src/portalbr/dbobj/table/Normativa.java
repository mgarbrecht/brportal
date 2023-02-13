package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Normativa
  * @version 26/09/2014 08:54:45
  */
public class Normativa implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int nro_normativa;
  private java.lang.String descricao;
  private java.lang.String observacao;
  private java.sql.Timestamp dthr_inclusao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp data_log_afv;
  private java.lang.String status;

  public Normativa() {
  }

  public int getNro_normativa() {
    return nro_normativa;
  }

  public void setNro_normativa(int PARAM) {
    this.nro_normativa = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
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

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}
