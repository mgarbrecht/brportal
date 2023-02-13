package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atendidos
  * @version 25/03/2020 14:48:42
  */
public class Jw_clientes_atendidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String cidade;
  private java.sql.Timestamp cli_dult;
  private int pares;
  private double valor;
  private int pares_recolocado;
  private double valor_recolocado;
  private java.lang.String email;
  private java.lang.Double saldo;
  private java.lang.Double limite_credito;
  private java.lang.String fones;
  private int quantidade_meses;

  public Jw_clientes_atendidos() {
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

  public int getPares() {
    return pares;
  }

  public void setPares(int PARAM) {
    this.pares = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

  public int getPares_recolocado() {
    return pares_recolocado;
  }

  public void setPares_recolocado(int PARAM) {
    this.pares_recolocado = PARAM;
  }

  public double getValor_recolocado() {
    return valor_recolocado;
  }

  public void setValor_recolocado(double PARAM) {
    this.valor_recolocado = PARAM;
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

  public int getQuantidade_meses() {
    return quantidade_meses;
  }

  public void setQuantidade_meses(int PARAM) {
    this.quantidade_meses = PARAM;
  }

}
