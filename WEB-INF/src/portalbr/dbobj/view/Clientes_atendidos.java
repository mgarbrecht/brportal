package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_atendidos
  * @version 15/05/2014 17:09:54
  */
public class Clientes_atendidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private int pares;
  private double valor;

  public Clientes_atendidos() {
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
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
