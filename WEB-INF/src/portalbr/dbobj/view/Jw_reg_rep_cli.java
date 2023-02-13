package portalbr.dbobj.view;

/** DataBase Object from table .Jw_reg_rep_cli
  * @version 03/04/2013 09:13:46
  */
public class Jw_reg_rep_cli implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_regional;
  private java.lang.String rep_cdgo;
  private java.lang.String cli_cdgo;

  public Jw_reg_rep_cli() {
  }

  public java.lang.String getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.String PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

}
