package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Agenda_visitas
  * @version 03/04/2013 10:07:18
  */
public class Agenda_visitas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer agvi_id;
  private java.lang.String agvi_rep_cdgo;
  private java.sql.Timestamp agvi_dt_inicial;
  private java.sql.Timestamp agvi_dt_final;
  private java.sql.Timestamp agvi_dt_exclusao;

  public Agenda_visitas() {
  }

  public java.lang.Integer getAgvi_id() {
    return agvi_id;
  }

  public void setAgvi_id(java.lang.Integer PARAM) {
    this.agvi_id = PARAM;
  }

  public java.lang.String getAgvi_rep_cdgo() {
    return agvi_rep_cdgo;
  }

  public void setAgvi_rep_cdgo(java.lang.String PARAM) {
    this.agvi_rep_cdgo = PARAM;
  }

  public java.sql.Timestamp getAgvi_dt_inicial() {
    return agvi_dt_inicial;
  }

  public void setAgvi_dt_inicial(java.sql.Timestamp PARAM) {
    this.agvi_dt_inicial = PARAM;
  }

  public java.sql.Timestamp getAgvi_dt_final() {
    return agvi_dt_final;
  }

  public void setAgvi_dt_final(java.sql.Timestamp PARAM) {
    this.agvi_dt_final = PARAM;
  }

  public java.sql.Timestamp getAgvi_dt_exclusao() {
    return agvi_dt_exclusao;
  }

  public void setAgvi_dt_exclusao(java.sql.Timestamp PARAM) {
    this.agvi_dt_exclusao = PARAM;
  }

}
