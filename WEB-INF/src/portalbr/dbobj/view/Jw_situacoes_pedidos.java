package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacoes_pedidos
  * @version 03/04/2013 09:09:31
  */
public class Jw_situacoes_pedidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.util.Date dat;
  private java.lang.String trn;

  public Jw_situacoes_pedidos() {
  }

  public java.util.Date getDat() {
    return dat;
  }

  public void setDat(java.util.Date PARAM) {
    this.dat = PARAM;
  }

  public java.lang.String getTrn() {
    return trn;
  }

  public void setTrn(java.lang.String PARAM) {
    this.trn = PARAM;
  }

}
