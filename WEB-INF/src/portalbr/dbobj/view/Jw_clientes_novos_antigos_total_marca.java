package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_total_marca
  * @version 16/05/2014 09:01:35
  */
public class Jw_clientes_novos_antigos_total_marca implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.String status;
  private int qtde;
  private int pares;
  private double valor;

  public Jw_clientes_novos_antigos_total_marca() {
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
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
