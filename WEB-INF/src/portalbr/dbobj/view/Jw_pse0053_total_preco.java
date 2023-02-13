package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_preco
  * @version 03/04/2013 09:14:29
  */
public class Jw_pse0053_total_preco implements java.io.Serializable, com.egen.util.jdbc.View {
  private int pares;
  private double preco;
  private double total;

  public Jw_pse0053_total_preco() {
  }

  public int getPares() {
    return pares;
  }

  public void setPares(int PARAM) {
    this.pares = PARAM;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double PARAM) {
    this.preco = PARAM;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double PARAM) {
    this.total = PARAM;
  }

}
