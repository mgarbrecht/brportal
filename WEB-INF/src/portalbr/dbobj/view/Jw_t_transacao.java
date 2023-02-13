package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_transacao
  * @version 03/04/2013 09:08:08
  */
public class Jw_t_transacao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String trn;
  private java.util.Date dat;

  public Jw_t_transacao() {
  }

  public java.lang.String getTrn() {
    return trn;
  }

  public void setTrn(java.lang.String PARAM) {
    this.trn = PARAM;
  }

  public java.util.Date getDat() {
    return dat;
  }

  public void setDat(java.util.Date PARAM) {
    this.dat = PARAM;
  }

}
