package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_vendas_tres_meses
  * @version 03/04/2013 09:29:09
  */
public class Jw_ficha_cliente_vendas_tres_meses implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String marca;
  private int pares;
  private double valor;

  public Jw_ficha_cliente_vendas_tres_meses() {
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
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
