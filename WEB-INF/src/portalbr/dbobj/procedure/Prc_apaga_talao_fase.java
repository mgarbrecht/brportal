package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_apaga_talao_fase
  * @version 18/06/2014 08:29:38
  */
public class Prc_apaga_talao_fase implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private double p_rem_nro;
  private double p_tal_nro;
  private java.lang.String p_set_cdgo;
  private double p_app_seq;
  private java.lang.String p_app_observ1;

  public Prc_apaga_talao_fase() {
  }

  public double getP_rem_nro() {
    return p_rem_nro;
  }

  public void setP_rem_nro(double PARAM) {
    this.p_rem_nro = PARAM;
  }

  public double getP_tal_nro() {
    return p_tal_nro;
  }

  public void setP_tal_nro(double PARAM) {
    this.p_tal_nro = PARAM;
  }

  public java.lang.String getP_set_cdgo() {
    return p_set_cdgo;
  }

  public void setP_set_cdgo(java.lang.String PARAM) {
    this.p_set_cdgo = PARAM;
  }

  public double getP_app_seq() {
    return p_app_seq;
  }

  public void setP_app_seq(double PARAM) {
    this.p_app_seq = PARAM;
  }

  public java.lang.String getP_app_observ1() {
    return p_app_observ1;
  }

  public void setP_app_observ1(java.lang.String PARAM) {
    this.p_app_observ1 = PARAM;
  }

}
