package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Livro
  * @version 05/07/2010 07:03:19
  */
public class Livro implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int liv_codigo;
  private java.lang.String liv_descri;
  private java.lang.String liv_status;
  private java.lang.String tipo_mercado;
  private java.lang.String aceita_desconto;
  private java.lang.String tipo_comissao;
  private double percentual_desconto;
  private double bonificacao_maxima;
  private java.lang.String liv_vendor;
  private java.lang.String liv_status_afv;

  public Livro() {
  }

  public int getLiv_codigo() {
    return liv_codigo;
  }

  public void setLiv_codigo(int PARAM) {
    this.liv_codigo = PARAM;
  }

  public java.lang.String getLiv_descri() {
    return liv_descri;
  }

  public void setLiv_descri(java.lang.String PARAM) {
    this.liv_descri = PARAM;
  }

  public java.lang.String getLiv_status() {
    return liv_status;
  }

  public void setLiv_status(java.lang.String PARAM) {
    this.liv_status = PARAM;
  }

  public java.lang.String getTipo_mercado() {
    return tipo_mercado;
  }

  public void setTipo_mercado(java.lang.String PARAM) {
    this.tipo_mercado = PARAM;
  }

  public java.lang.String getAceita_desconto() {
    return aceita_desconto;
  }

  public void setAceita_desconto(java.lang.String PARAM) {
    this.aceita_desconto = PARAM;
  }

  public java.lang.String getTipo_comissao() {
    return tipo_comissao;
  }

  public void setTipo_comissao(java.lang.String PARAM) {
    this.tipo_comissao = PARAM;
  }

  public double getPercentual_desconto() {
    return percentual_desconto;
  }

  public void setPercentual_desconto(double PARAM) {
    this.percentual_desconto = PARAM;
  }

  public double getBonificacao_maxima() {
    return bonificacao_maxima;
  }

  public void setBonificacao_maxima(double PARAM) {
    this.bonificacao_maxima = PARAM;
  }

  public java.lang.String getLiv_vendor() {
    return liv_vendor;
  }

  public void setLiv_vendor(java.lang.String PARAM) {
    this.liv_vendor = PARAM;
  }

  public java.lang.String getLiv_status_afv() {
    return liv_status_afv;
  }

  public void setLiv_status_afv(java.lang.String PARAM) {
    this.liv_status_afv = PARAM;
  }

}
