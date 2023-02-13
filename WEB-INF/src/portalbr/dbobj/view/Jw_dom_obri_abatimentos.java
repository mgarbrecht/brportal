package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dom_obri_abatimentos
  * @version 23/07/2018 14:54:39
  */
public class Jw_dom_obri_abatimentos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String nm_obri;
  private java.lang.String cd_enti;
  private java.lang.String codi_tipo_ender;
  private java.lang.String cd_tipo;
  private java.lang.String cd_tran;
  private java.lang.String nm_descri;
  private double vl_pago;
  private java.sql.Timestamp dt_moob;
  private java.lang.String te_observ;

  public Jw_dom_obri_abatimentos() {
  }

  public java.lang.String getNm_obri() {
    return nm_obri;
  }

  public void setNm_obri(java.lang.String PARAM) {
    this.nm_obri = PARAM;
  }

  public java.lang.String getCd_enti() {
    return cd_enti;
  }

  public void setCd_enti(java.lang.String PARAM) {
    this.cd_enti = PARAM;
  }

  public java.lang.String getCodi_tipo_ender() {
    return codi_tipo_ender;
  }

  public void setCodi_tipo_ender(java.lang.String PARAM) {
    this.codi_tipo_ender = PARAM;
  }

  public java.lang.String getCd_tipo() {
    return cd_tipo;
  }

  public void setCd_tipo(java.lang.String PARAM) {
    this.cd_tipo = PARAM;
  }

  public java.lang.String getCd_tran() {
    return cd_tran;
  }

  public void setCd_tran(java.lang.String PARAM) {
    this.cd_tran = PARAM;
  }

  public java.lang.String getNm_descri() {
    return nm_descri;
  }

  public void setNm_descri(java.lang.String PARAM) {
    this.nm_descri = PARAM;
  }

  public double getVl_pago() {
    return vl_pago;
  }

  public void setVl_pago(double PARAM) {
    this.vl_pago = PARAM;
  }

  public java.sql.Timestamp getDt_moob() {
    return dt_moob;
  }

  public void setDt_moob(java.sql.Timestamp PARAM) {
    this.dt_moob = PARAM;
  }

  public java.lang.String getTe_observ() {
    return te_observ;
  }

  public void setTe_observ(java.lang.String PARAM) {
    this.te_observ = PARAM;
  }

}
