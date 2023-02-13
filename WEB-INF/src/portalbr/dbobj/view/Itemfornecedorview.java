package portalbr.dbobj.view;

/** DataBase Object from table .Itemfornecedorview
  * @version 03/04/2013 09:55:19
  */
public class Itemfornecedorview implements java.io.Serializable, com.egen.util.jdbc.View {
  private double codigo;
  private java.lang.String descricao;
  private java.lang.String fornecedor;

  public Itemfornecedorview() {
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
