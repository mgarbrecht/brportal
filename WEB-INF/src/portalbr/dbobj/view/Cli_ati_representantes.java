package portalbr.dbobj.view;

/** DataBase Object from table .Cli_ati_representantes
  * @version 15/05/2014 17:08:06
  */
public class Cli_ati_representantes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_ati;
  private java.lang.String rep_cdgo;

  public Cli_ati_representantes() {
  }

  public java.lang.String getCli_ati() {
    return cli_ati;
  }

  public void setCli_ati(java.lang.String PARAM) {
    this.cli_ati = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

}
