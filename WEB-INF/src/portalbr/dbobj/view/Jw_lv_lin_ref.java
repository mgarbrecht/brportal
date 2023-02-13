package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_lin_ref
  * @version 03/04/2013 09:23:53
  */
public class Jw_lv_lin_ref implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lin_cdgo;
  private java.lang.String lin_nome;
  private java.lang.String ref_cdgo;
  private java.lang.String ref_desc;

  public Jw_lv_lin_ref() {
  }

  public java.lang.String getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.String PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.String getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.String PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.String getRef_desc() {
    return ref_desc;
  }

  public void setRef_desc(java.lang.String PARAM) {
    this.ref_desc = PARAM;
  }

}
