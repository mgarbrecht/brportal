package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_taxa_juros
  * @version 03/04/2013 09:08:33
  */
public class Jw_t_taxa_juros implements java.io.Serializable, com.egen.util.jdbc.View {
  private double taxa_juros;

  public Jw_t_taxa_juros() {
  }

  public double getTaxa_juros() {
    return taxa_juros;
  }

  public void setTaxa_juros(double PARAM) {
    this.taxa_juros = PARAM;
  }

}
