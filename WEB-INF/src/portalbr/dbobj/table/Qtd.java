package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Qtd
  * @version 03/09/2010 08:00:07
  */
public class Qtd implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer gde_cdgo;
  private java.lang.String qtd_nume;
  private java.lang.Integer qtd_pars;

  public Qtd() {
  }

  public java.lang.Integer getGde_cdgo() {
    return gde_cdgo;
  }

  public void setGde_cdgo(java.lang.Integer PARAM) {
    this.gde_cdgo = PARAM;
  }

  public java.lang.String getQtd_nume() {
    return qtd_nume;
  }

  public void setQtd_nume(java.lang.String PARAM) {
    this.qtd_nume = PARAM;
  }

  public java.lang.Integer getQtd_pars() {
    return qtd_pars;
  }

  public void setQtd_pars(java.lang.Integer PARAM) {
    this.qtd_pars = PARAM;
  }

}
