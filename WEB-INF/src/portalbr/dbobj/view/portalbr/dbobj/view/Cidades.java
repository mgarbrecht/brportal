package portalbr.dbobj.view;

import java.lang.reflect.*;

/*** DataBase Object from view Cidades
     Version: 2.7 -  Date: 27/12/2005 10:54:00 */
public class Cidades implements java.io.Serializable, com.egen.util.jdbc.View {
  private double Cli_cdgo;
  private java.lang.String Cidade;

  public Cidades() {
  }

  public double getCli_cdgo() {
    return Cli_cdgo;
  }

  public void setCli_cdgo(double CLI_CDGO) {
    Cli_cdgo = CLI_CDGO;
  }

  public java.lang.String getCidade() {
    return Cidade;
  }

  public void setCidade(java.lang.String CIDADE) {
    Cidade = CIDADE;
  }

}
