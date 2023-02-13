package portalbr.dbobj.view;

/** DataBase Object from table .Jw_xxxxx
  * @version 27/05/2010 10:12:13
  */
public class Jw_xxxxx implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cod_empresa;
  private java.lang.String cod_filial;
  private java.sql.Date data;
  private java.lang.String feriado;
  private double dia_semana;
  private double periodo;

  public Jw_xxxxx() {
  }

  public java.lang.String getCod_empresa() {
    return cod_empresa;
  }

  public void setCod_empresa(java.lang.String PARAM) {
    this.cod_empresa = PARAM;
  }

  public java.lang.String getCod_filial() {
    return cod_filial;
  }

  public void setCod_filial(java.lang.String PARAM) {
    this.cod_filial = PARAM;
  }

  public java.sql.Date getData() {
    return data;
  }

  public void setData(java.sql.Date PARAM) {
    this.data = PARAM;
  }

  public java.lang.String getFeriado() {
    return feriado;
  }

  public void setFeriado(java.lang.String PARAM) {
    this.feriado = PARAM;
  }

  public double getDia_semana() {
    return dia_semana;
  }

  public void setDia_semana(double PARAM) {
    this.dia_semana = PARAM;
  }

  public double getPeriodo() {
    return periodo;
  }

  public void setPeriodo(double PARAM) {
    this.periodo = PARAM;
  }

}
