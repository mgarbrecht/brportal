package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ativos
  * @version 16/05/2014 08:45:56
  */
public class Jw_clientes_ativos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String cidade;
  private java.sql.Timestamp cli_dult;
  private java.lang.String email;

  public Jw_clientes_ativos() {
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_nome() {
    return cli_nome;
  }

  public void setCli_nome(java.lang.String PARAM) {
    this.cli_nome = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

  public java.sql.Timestamp getCli_dult() {
    return cli_dult;
  }

  public void setCli_dult(java.sql.Timestamp PARAM) {
    this.cli_dult = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

}
