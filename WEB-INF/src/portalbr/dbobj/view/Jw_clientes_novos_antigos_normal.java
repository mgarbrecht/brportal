package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_normal
  * @version 16/05/2014 08:59:19
  */
public class Jw_clientes_novos_antigos_normal implements java.io.Serializable, com.egen.util.jdbc.View {
  private int cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String status;
  private int pares;
  private double valor;

  public Jw_clientes_novos_antigos_normal() {
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

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
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
