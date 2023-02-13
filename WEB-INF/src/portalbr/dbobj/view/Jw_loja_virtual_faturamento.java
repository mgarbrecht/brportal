package portalbr.dbobj.view;

/** DataBase Object from table .Jw_loja_virtual_faturamento
  * @version 03/04/2013 09:24:45
  */
public class Jw_loja_virtual_faturamento implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String filial;
  private java.lang.String products_model;
  private java.lang.String products_name;
  private double qtde;
  private double valor;

  public Jw_loja_virtual_faturamento() {
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getProducts_model() {
    return products_model;
  }

  public void setProducts_model(java.lang.String PARAM) {
    this.products_model = PARAM;
  }

  public java.lang.String getProducts_name() {
    return products_name;
  }

  public void setProducts_name(java.lang.String PARAM) {
    this.products_name = PARAM;
  }

  public double getQtde() {
    return qtde;
  }

  public void setQtde(double PARAM) {
    this.qtde = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

}
