package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_preco_aberto
  * @version 22/07/2013 13:21:28
  */
public class Jw_pse0053_total_preco_aberto implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer pro_numero;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private double preco;
  private java.lang.Integer pares;

  public Jw_pse0053_total_preco_aberto() {
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(java.lang.Integer PARAM) {
    this.cab_cdgo = PARAM;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double PARAM) {
    this.preco = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

}
