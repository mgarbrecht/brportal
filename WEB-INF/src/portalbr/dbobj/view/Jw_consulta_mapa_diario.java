package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_mapa_diario
  * @version 13/09/2019 15:23:59
  */
public class Jw_consulta_mapa_diario implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp data_tmp;
  private double entrada_dia_valor;
  private double entrada_dia_ant_valor;
  private double faturamento_dia_valor;
  private double faturamento_dia_ant;

  public Jw_consulta_mapa_diario() {
  }

  public java.sql.Timestamp getData_tmp() {
    return data_tmp;
  }

  public void setData_tmp(java.sql.Timestamp PARAM) {
    this.data_tmp = PARAM;
  }

  public double getEntrada_dia_valor() {
    return entrada_dia_valor;
  }

  public void setEntrada_dia_valor(double PARAM) {
    this.entrada_dia_valor = PARAM;
  }

  public double getEntrada_dia_ant_valor() {
    return entrada_dia_ant_valor;
  }

  public void setEntrada_dia_ant_valor(double PARAM) {
    this.entrada_dia_ant_valor = PARAM;
  }

  public double getFaturamento_dia_valor() {
    return faturamento_dia_valor;
  }

  public void setFaturamento_dia_valor(double PARAM) {
    this.faturamento_dia_valor = PARAM;
  }

  public double getFaturamento_dia_ant() {
    return faturamento_dia_ant;
  }

  public void setFaturamento_dia_ant(double PARAM) {
    this.faturamento_dia_ant = PARAM;
  }

}
