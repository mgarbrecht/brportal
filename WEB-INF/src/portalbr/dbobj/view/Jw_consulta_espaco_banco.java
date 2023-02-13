package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_espaco_banco
  * @version 14/12/2015 11:36:12
  */
public class Jw_consulta_espaco_banco implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String dg_name;
  private java.lang.String dg_state;
  private double dg_free_mb;
  private double dg_total_mb;
  private double perc_free;
  private java.lang.String dt_data;

  public Jw_consulta_espaco_banco() {
  }

  public java.lang.String getDg_name() {
    return dg_name;
  }

  public void setDg_name(java.lang.String PARAM) {
    this.dg_name = PARAM;
  }

  public java.lang.String getDg_state() {
    return dg_state;
  }

  public void setDg_state(java.lang.String PARAM) {
    this.dg_state = PARAM;
  }

  public double getDg_free_mb() {
    return dg_free_mb;
  }

  public void setDg_free_mb(double PARAM) {
    this.dg_free_mb = PARAM;
  }

  public double getDg_total_mb() {
    return dg_total_mb;
  }

  public void setDg_total_mb(double PARAM) {
    this.dg_total_mb = PARAM;
  }

  public double getPerc_free() {
    return perc_free;
  }

  public void setPerc_free(double PARAM) {
    this.perc_free = PARAM;
  }

  public java.lang.String getDt_data() {
    return dt_data;
  }

  public void setDt_data(java.lang.String PARAM) {
    this.dt_data = PARAM;
  }

}
