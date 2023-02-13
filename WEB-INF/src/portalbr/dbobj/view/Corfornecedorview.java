package portalbr.dbobj.view;

/** DataBase Object from table .Corfornecedorview
  * @version 03/04/2013 10:00:34
  */
public class Corfornecedorview implements java.io.Serializable, com.egen.util.jdbc.View {
  private double codigo;
  private java.lang.String descricao;
  private java.lang.String fornecedor;

  public Corfornecedorview() {
  }

  public double getCodigo() {
    return codigo;
  }

  public void setCodigo(double PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(java.lang.String PARAM) {
    this.fornecedor = PARAM;
  }

}
