package portalbr.dbobj.view;

/** DataBase Object from table .Cli_ati_marcas
  * @version 03/04/2013 10:05:33
  */
public class Cli_ati_marcas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_ati;
  private java.lang.String codigo_marca;

  public Cli_ati_marcas() {
  }

  public java.lang.String getCli_ati() {
    return cli_ati;
  }

  public void setCli_ati(java.lang.String PARAM) {
    this.cli_ati = PARAM;
  }

  public java.lang.String getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.String PARAM) {
    this.codigo_marca = PARAM;
  }

}
