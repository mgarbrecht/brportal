package portalbr.dbobj.view;

/** DataBase Object from table .Jw_administrador_pedidos_periodos
  * @version 03/04/2013 09:51:59
  */
public class Jw_administrador_pedidos_periodos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer mes;
  private java.lang.Integer ano;
  private java.lang.Integer periodo;
  private java.sql.Date data_inicial;
  private java.sql.Date data_final;

  public Jw_administrador_pedidos_periodos() {
  }

  public java.lang.Integer getMes() {
    return mes;
  }

  public void setMes(java.lang.Integer PARAM) {
    this.mes = PARAM;
  }

  public java.lang.Integer getAno() {
    return ano;
  }

  public void setAno(java.lang.Integer PARAM) {
    this.ano = PARAM;
  }

  public java.lang.Integer getPeriodo() {
    return periodo;
  }

  public void setPeriodo(java.lang.Integer PARAM) {
    this.periodo = PARAM;
  }

  public java.sql.Date getData_inicial() {
    return data_inicial;
  }

  public void setData_inicial(java.sql.Date PARAM) {
    this.data_inicial = PARAM;
  }

  public java.sql.Date getData_final() {
    return data_final;
  }

  public void setData_final(java.sql.Date PARAM) {
    this.data_final = PARAM;
  }

}
