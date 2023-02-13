package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lista_geral
  * @version 03/04/2013 09:25:50
  */
public class Jw_lista_geral implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String products_model;
  private java.lang.String products_image;
  private double products_price;
  private java.lang.String products_options_values_name;
  private java.lang.String cor;
  private int estoque_atual;

  public Jw_lista_geral() {
  }

  public java.lang.String getProducts_model() {
    return products_model;
  }

  public void setProducts_model(java.lang.String PARAM) {
    this.products_model = PARAM;
  }

  public java.lang.String getProducts_image() {
    return products_image;
  }

  public void setProducts_image(java.lang.String PARAM) {
    this.products_image = PARAM;
  }

  public double getProducts_price() {
    return products_price;
  }

  public void setProducts_price(double PARAM) {
    this.products_price = PARAM;
  }

  public java.lang.String getProducts_options_values_name() {
    return products_options_values_name;
  }

  public void setProducts_options_values_name(java.lang.String PARAM) {
    this.products_options_values_name = PARAM;
  }

  public java.lang.String getCor() {
    return cor;
  }

  public void setCor(java.lang.String PARAM) {
    this.cor = PARAM;
  }

  public int getEstoque_atual() {
    return estoque_atual;
  }

  public void setEstoque_atual(int PARAM) {
    this.estoque_atual = PARAM;
  }

}
