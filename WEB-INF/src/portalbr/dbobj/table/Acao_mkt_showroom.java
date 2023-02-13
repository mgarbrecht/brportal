package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_showroom
  * @version 03/04/2013 10:08:21
  */
public class Acao_mkt_showroom implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id_showroom;
  private java.lang.Integer codigo_regional;
  private java.lang.String evento;
  private java.lang.Integer mun_codigo;
  private java.lang.String est_unifed;
  private java.lang.Integer est_pais_codigo;
  private java.sql.Date dt_periodo_ini;
  private java.sql.Date dt_periodo_fim;

  public Acao_mkt_showroom() {
  }

  public java.lang.Integer getId_showroom() {
    return id_showroom;
  }

  public void setId_showroom(java.lang.Integer PARAM) {
    this.id_showroom = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getEvento() {
    return evento;
  }

  public void setEvento(java.lang.String PARAM) {
    this.evento = PARAM;
  }

  public java.lang.Integer getMun_codigo() {
    return mun_codigo;
  }

  public void setMun_codigo(java.lang.Integer PARAM) {
    this.mun_codigo = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.Integer getEst_pais_codigo() {
    return est_pais_codigo;
  }

  public void setEst_pais_codigo(java.lang.Integer PARAM) {
    this.est_pais_codigo = PARAM;
  }

  public java.sql.Date getDt_periodo_ini() {
    return dt_periodo_ini;
  }

  public void setDt_periodo_ini(java.sql.Date PARAM) {
    this.dt_periodo_ini = PARAM;
  }

  public java.sql.Date getDt_periodo_fim() {
    return dt_periodo_fim;
  }

  public void setDt_periodo_fim(java.sql.Date PARAM) {
    this.dt_periodo_fim = PARAM;
  }

}
