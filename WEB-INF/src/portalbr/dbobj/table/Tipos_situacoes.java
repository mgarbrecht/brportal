package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tipos_situacoes
  * @version 17/06/2014 08:08:30
  */
public class Tipos_situacoes implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo_situacao;
  private java.lang.String descricao_situacao;
  private java.sql.Timestamp dt_cad_situacao;
  private java.lang.String usuario_situacao;
  private java.lang.String observ_situacao;
  private java.lang.String indicador_situacao;

  public Tipos_situacoes() {
  }

  public java.lang.Integer getCodigo_situacao() {
    return codigo_situacao;
  }

  public void setCodigo_situacao(java.lang.Integer PARAM) {
    this.codigo_situacao = PARAM;
  }

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

  public java.sql.Timestamp getDt_cad_situacao() {
    return dt_cad_situacao;
  }

  public void setDt_cad_situacao(java.sql.Timestamp PARAM) {
    this.dt_cad_situacao = PARAM;
  }

  public java.lang.String getUsuario_situacao() {
    return usuario_situacao;
  }

  public void setUsuario_situacao(java.lang.String PARAM) {
    this.usuario_situacao = PARAM;
  }

  public java.lang.String getObserv_situacao() {
    return observ_situacao;
  }

  public void setObserv_situacao(java.lang.String PARAM) {
    this.observ_situacao = PARAM;
  }

  public java.lang.String getIndicador_situacao() {
    return indicador_situacao;
  }

  public void setIndicador_situacao(java.lang.String PARAM) {
    this.indicador_situacao = PARAM;
  }

}
