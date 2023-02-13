package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_total_geral
  * @version 16/05/2014 09:00:40
  */
public class Jw_clientes_novos_antigos_total_geral implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String status;
  private int qtde;
  private int pares;
  private double valor;

  public Jw_clientes_novos_antigos_total_geral() {
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public int getQtde() {
    return qtde;
  }

  public void setQtde(int PARAM) {
    this.qtde = PARAM;
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
