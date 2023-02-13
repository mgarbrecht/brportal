package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grade_total_linha
  * @version 03/04/2013 09:12:02
  */
public class Jw_saldo_estoque_grade_total_linha implements java.io.Serializable, com.egen.util.jdbc.View {
  private int lin_cdgo;
  private int gde_cdgo;
  private double total;

  public Jw_saldo_estoque_grade_total_linha() {
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public int getGde_cdgo() {
    return gde_cdgo;
  }

  public void setGde_cdgo(int PARAM) {
    this.gde_cdgo = PARAM;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double PARAM) {
    this.total = PARAM;
  }

}
