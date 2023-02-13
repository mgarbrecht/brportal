package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Agenda_visitas_clientes
  * @version 03/04/2013 10:07:09
  */
public class Agenda_visitas_clientes implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer agvc_id;
  private java.lang.Integer agvc_agvi_id;
  private java.lang.Integer agvc_cli_cdgo;
  private java.lang.Integer agvc_esc_seqn;
  private java.lang.String agvc_tipo;
  private java.sql.Timestamp agvc_dt_exclusao;

  public Agenda_visitas_clientes() {
  }

  public java.lang.Integer getAgvc_id() {
    return agvc_id;
  }

  public void setAgvc_id(java.lang.Integer PARAM) {
    this.agvc_id = PARAM;
  }

  public java.lang.Integer getAgvc_agvi_id() {
    return agvc_agvi_id;
  }

  public void setAgvc_agvi_id(java.lang.Integer PARAM) {
    this.agvc_agvi_id = PARAM;
  }

  public java.lang.Integer getAgvc_cli_cdgo() {
    return agvc_cli_cdgo;
  }

  public void setAgvc_cli_cdgo(java.lang.Integer PARAM) {
    this.agvc_cli_cdgo = PARAM;
  }

  public java.lang.Integer getAgvc_esc_seqn() {
    return agvc_esc_seqn;
  }

  public void setAgvc_esc_seqn(java.lang.Integer PARAM) {
    this.agvc_esc_seqn = PARAM;
  }

  public java.lang.String getAgvc_tipo() {
    return agvc_tipo;
  }

  public void setAgvc_tipo(java.lang.String PARAM) {
    this.agvc_tipo = PARAM;
  }

  public java.sql.Timestamp getAgvc_dt_exclusao() {
    return agvc_dt_exclusao;
  }

  public void setAgvc_dt_exclusao(java.sql.Timestamp PARAM) {
    this.agvc_dt_exclusao = PARAM;
  }

}
