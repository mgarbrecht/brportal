package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grade_total_tamanho
  * @version 03/04/2013 09:11:52
  */
public class Jw_saldo_estoque_grade_total_tamanho implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String tai_codigo;
  private int lin_cdgo;
  private double total;

  public Jw_saldo_estoque_grade_total_tamanho() {
  }

  public java.lang.String getTai_codigo() {
    return tai_codigo;
  }

  public void setTai_codigo(java.lang.String PARAM) {
    this.tai_codigo = PARAM;
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double PARAM) {
    this.total = PARAM;
  }

}
