package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tipo_midia
  * @version 03/04/2013 09:07:24
  */
public class Tipo_midia implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer cdgo_tmidia;
  private java.lang.String desc_tmidia;

  public Tipo_midia() {
  }

  public java.lang.Integer getCdgo_tmidia() {
    return cdgo_tmidia;
  }

  public void setCdgo_tmidia(java.lang.Integer PARAM) {
    this.cdgo_tmidia = PARAM;
  }

  public java.lang.String getDesc_tmidia() {
    return desc_tmidia;
  }

  public void setDesc_tmidia(java.lang.String PARAM) {
    this.desc_tmidia = PARAM;
  }

}
