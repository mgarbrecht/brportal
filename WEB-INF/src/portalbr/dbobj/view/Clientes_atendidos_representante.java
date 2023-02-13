package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_atendidos_representante
  * @version 15/05/2014 17:14:03
  */
public class Clientes_atendidos_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String cidade;
  private java.sql.Timestamp cli_dult;
  private int pares;
  private double valor;

  public Clientes_atendidos_representante() {
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
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

}
