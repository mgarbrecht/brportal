package portalbr.dbobj.view;

/** DataBase Object from table .Cli_ati_regionais
  * @version 03/04/2013 10:05:02
  */
public class Cli_ati_regionais implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer cli_ati;
  private java.lang.Integer codigo_regional;

  public Cli_ati_regionais() {
  }

  public java.lang.Integer getCli_ati() {
    return cli_ati;
  }

  public void setCli_ati(java.lang.Integer PARAM) {
    this.cli_ati = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

}
