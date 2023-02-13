package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Apont_prod
  * @version 02/07/2015 08:41:35
  */
public class Apont_prod implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer rem_nro;
  private java.lang.Integer tal_nro;
  private java.lang.String set_cdgo;
  private java.lang.Integer app_seq;
  private java.lang.String app_minfab;
  private java.sql.Timestamp app_data;
  private java.lang.Integer app_parbom;
  private java.lang.Integer app_parrej;
  private java.lang.Integer app_tempo;
  private java.lang.String app_observ;
  private java.lang.String app_observ1;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dtrh_corrente;

  public Apont_prod() {
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

  public java.lang.String getSet_cdgo() {
    return set_cdgo;
  }

  public void setSet_cdgo(java.lang.String PARAM) {
    this.set_cdgo = PARAM;
  }

  public java.lang.Integer getApp_seq() {
    return app_seq;
  }

  public void setApp_seq(java.lang.Integer PARAM) {
    this.app_seq = PARAM;
  }

  public java.lang.String getApp_minfab() {
    return app_minfab;
  }

  public void setApp_minfab(java.lang.String PARAM) {
    this.app_minfab = PARAM;
  }

  public java.sql.Timestamp getApp_data() {
    return app_data;
  }

  public void setApp_data(java.sql.Timestamp PARAM) {
    this.app_data = PARAM;
  }

  public java.lang.Integer getApp_parbom() {
    return app_parbom;
  }

  public void setApp_parbom(java.lang.Integer PARAM) {
    this.app_parbom = PARAM;
  }

  public java.lang.Integer getApp_parrej() {
    return app_parrej;
  }

  public void setApp_parrej(java.lang.Integer PARAM) {
    this.app_parrej = PARAM;
  }

  public java.lang.Integer getApp_tempo() {
    return app_tempo;
  }

  public void setApp_tempo(java.lang.Integer PARAM) {
    this.app_tempo = PARAM;
  }

  public java.lang.String getApp_observ() {
    return app_observ;
  }

  public void setApp_observ(java.lang.String PARAM) {
    this.app_observ = PARAM;
  }

  public java.lang.String getApp_observ1() {
    return app_observ1;
  }

  public void setApp_observ1(java.lang.String PARAM) {
    this.app_observ1 = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDtrh_corrente() {
    return dtrh_corrente;
  }

  public void setDtrh_corrente(java.sql.Timestamp PARAM) {
    this.dtrh_corrente = PARAM;
  }

}
