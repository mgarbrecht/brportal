package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_nao_atendidos
  * @version 24/03/2014 09:46:30
  */
public class Jw_clientes_nao_atendidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String cnpj;
  private java.lang.String cidade;
  private java.lang.String endereco;
  private java.sql.Timestamp cli_dult;
  private java.lang.String email;
  private java.lang.Double saldo;
  private java.lang.Double limite_credito;
  private java.lang.String fones;

  public Jw_clientes_nao_atendidos() {
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

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
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

  public java.lang.Double getSaldo() {
    return saldo;
  }

  public void setSaldo(java.lang.Double PARAM) {
    this.saldo = PARAM;
  }

  public java.lang.Double getLimite_credito() {
    return limite_credito;
  }

  public void setLimite_credito(java.lang.Double PARAM) {
    this.limite_credito = PARAM;
  }

  public java.lang.String getFones() {
    return fones;
  }

  public void setFones(java.lang.String PARAM) {
    this.fones = PARAM;
  }

}
