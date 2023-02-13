package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Agendamento_clientes
  * @version 21/08/2013 11:09:25
  */
public class Agendamento_clientes implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id_agendamento;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer nro_semana;
  private java.sql.Date dt_inicial;
  private java.sql.Date dt_final;

  public Agendamento_clientes() {
  }

  public java.lang.Integer getId_agendamento() {
    return id_agendamento;
  }

  public void setId_agendamento(java.lang.Integer PARAM) {
    this.id_agendamento = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getNro_semana() {
    return nro_semana;
  }

  public void setNro_semana(java.lang.Integer PARAM) {
    this.nro_semana = PARAM;
  }

  public java.sql.Date getDt_inicial() {
    return dt_inicial;
  }

  public void setDt_inicial(java.sql.Date PARAM) {
    this.dt_inicial = PARAM;
  }

  public java.sql.Date getDt_final() {
    return dt_final;
  }

  public void setDt_final(java.sql.Date PARAM) {
    this.dt_final = PARAM;
  }

}
