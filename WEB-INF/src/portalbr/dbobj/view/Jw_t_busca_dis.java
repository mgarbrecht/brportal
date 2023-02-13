package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_busca_dis
  * @version 03/04/2013 09:09:12
  */
public class Jw_t_busca_dis implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.util.Date dat;
  private java.lang.String trn;

  public Jw_t_busca_dis() {
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
