package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Entrada_pedidos_atual_datas_vw
  * @version 01/04/2015 10:28:16
  */
public class Entrada_pedidos_atual_datas_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String dia_anterior;
  private java.lang.String dia_atual;
  private java.lang.String mes;
  private java.lang.String semana_atual;

  public Entrada_pedidos_atual_datas_vw() {
  }

  public java.lang.String getDia_anterior() {
    return dia_anterior;
  }

  public void setDia_anterior(java.lang.String PARAM) {
    this.dia_anterior = PARAM;
  }

  public java.lang.String getDia_atual() {
    return dia_atual;
  }

  public void setDia_atual(java.lang.String PARAM) {
    this.dia_atual = PARAM;
  }

  public java.lang.String getMes() {
    return mes;
  }

  public void setMes(java.lang.String PARAM) {
    this.mes = PARAM;
  }

  public java.lang.String getSemana_atual() {
    return semana_atual;
  }

  public void setSemana_atual(java.lang.String PARAM) {
    this.semana_atual = PARAM;
  }

}
