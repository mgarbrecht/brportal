package portalbr.dbobj.view;

/** DataBase Object from table .Cidades
  * @version 24/03/2014 10:01:38
  */
public class Cidades implements java.io.Serializable, com.egen.util.jdbc.View {
  private double cli_cdgo;
  private java.lang.String cidade;
  private java.lang.String esc_email;
  private java.lang.String fones;

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

  public java.lang.String getEsc_email() {
    return esc_email;
  }

  public void setEsc_email(java.lang.String PARAM) {
    this.esc_email = PARAM;
  }

  public java.lang.String getFones() {
    return fones;
  }

  public void setFones(java.lang.String PARAM) {
    this.fones = PARAM;
  }

}
