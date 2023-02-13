package portalbr.dbobj.view;

/** DataBase Object from table .Jw_agenda_visitas
  * @version 03/04/2013 09:51:24
  */
public class Jw_agenda_visitas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer agvi_id;
  private java.lang.String agvi_rep_cdgo;
  private java.sql.Timestamp agvi_dt_inicial;
  private java.sql.Timestamp agvi_dt_final;
  private java.sql.Timestamp agvi_dt_exclusao;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.Integer codigo_regional;

  public Jw_agenda_visitas() {
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

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

}
