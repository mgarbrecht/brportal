package portalbr.dbobj.view;

/** DataBase Object from table .Jw_vendas_principais
  * @version 05/07/2010 07:04:22
  */
public class Jw_vendas_principais implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String marca;
  private java.lang.String periodo;
  private int pares;
  private double valor;

  public Jw_vendas_principais() {
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getPeriodo() {
    return periodo;
  }

  public void setPeriodo(java.lang.String PARAM) {
    this.periodo = PARAM;
  }

  public int getPares() {
    return pares;
  }

  public void setPares(int PARAM) {
    this.pares = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

}
