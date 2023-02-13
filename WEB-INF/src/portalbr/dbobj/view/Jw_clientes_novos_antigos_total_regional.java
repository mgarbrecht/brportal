package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_total_regional
  * @version 16/05/2014 09:02:28
  */
public class Jw_clientes_novos_antigos_total_regional implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String status;
  private int qtde;
  private int pares;
  private double valor;

  public Jw_clientes_novos_antigos_total_regional() {
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
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
