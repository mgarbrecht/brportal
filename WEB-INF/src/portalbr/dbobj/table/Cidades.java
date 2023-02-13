package portalbr.dbobj.table;

/** DataBase Object from table .Cidades
  * @version 27/05/2010 10:32:26
  */
public class Cidades implements java.io.Serializable, com.egen.util.jdbc.Table {
  private double cli_cdgo;
  private java.lang.String cidade;

  public Cidades() {
  }

  public double getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(double PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

}
