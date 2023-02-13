package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cgc
  * @version 03/04/2013 09:46:25
  */
public class Jw_clientes_cgc implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String esc_seqn;

  public Jw_clientes_cgc() {
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.String PARAM) {
    this.esc_seqn = PARAM;
  }

}
