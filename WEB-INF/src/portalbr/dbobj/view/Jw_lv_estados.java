package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_estados
  * @version 03/04/2013 09:24:14
  */
public class Jw_lv_estados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String est_unifed;
  private java.lang.String est_descri;

  public Jw_lv_estados() {
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.String getEst_descri() {
    return est_descri;
  }

  public void setEst_descri(java.lang.String PARAM) {
    this.est_descri = PARAM;
  }

}
