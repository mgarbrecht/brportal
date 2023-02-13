package portalbr.dbobj.view;

/** DataBase Object from table .Jw_venc_orig
  * @version 05/07/2010 07:04:36
  */
public class Jw_venc_orig implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp mov_datvenc;
  private java.lang.String mov_cobjur;
  private java.lang.String mov_condes;

  public Jw_venc_orig() {
  }

  public java.sql.Timestamp getMov_datvenc() {
    return mov_datvenc;
  }

  public void setMov_datvenc(java.sql.Timestamp PARAM) {
    this.mov_datvenc = PARAM;
  }

  public java.lang.String getMov_cobjur() {
    return mov_cobjur;
  }

  public void setMov_cobjur(java.lang.String PARAM) {
    this.mov_cobjur = PARAM;
  }

  public java.lang.String getMov_condes() {
    return mov_condes;
  }

  public void setMov_condes(java.lang.String PARAM) {
    this.mov_condes = PARAM;
  }

}
