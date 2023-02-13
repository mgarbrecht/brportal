package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ultimo_acesso
  * @version 05/07/2010 07:05:45
  */
public class Jw_ultimo_acesso implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer cli;
  private java.lang.String razao;
  private java.sql.Timestamp data_ultimo;
  private java.lang.String cli_situ;

  public Jw_ultimo_acesso() {
  }

  public java.lang.Integer getCli() {
    return cli;
  }

  public void setCli(java.lang.Integer PARAM) {
    this.cli = PARAM;
  }

  public java.lang.String getRazao() {
    return razao;
  }

  public void setRazao(java.lang.String PARAM) {
    this.razao = PARAM;
  }

  public java.sql.Timestamp getData_ultimo() {
    return data_ultimo;
  }

  public void setData_ultimo(java.sql.Timestamp PARAM) {
    this.data_ultimo = PARAM;
  }

  public java.lang.String getCli_situ() {
    return cli_situ;
  }

  public void setCli_situ(java.lang.String PARAM) {
    this.cli_situ = PARAM;
  }

}
