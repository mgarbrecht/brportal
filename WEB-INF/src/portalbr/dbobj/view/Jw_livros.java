package portalbr.dbobj.view;

/** DataBase Object from table .Jw_livros
  * @version 03/04/2013 09:25:16
  */
public class Jw_livros implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer liv_codigo;
  private java.lang.String liv_descri;
  private java.lang.String liv_status;
  private java.lang.String tipo_mercado;
  private java.lang.String aceita_desconto;
  private java.lang.String tipo_comissao;
  private double percentual_desconto;
  private double bonificacao_maxima;
  private java.lang.String liv_vendor;
  private java.lang.String liv_status_afv;
  private java.lang.String tipo_pedido;
  private java.lang.String permiti_alterar_preco;

  public Jw_livros() {
  }

  public java.lang.Integer getLiv_codigo() {
    return liv_codigo;
  }

  public void setLiv_codigo(java.lang.Integer PARAM) {
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

  public java.lang.String getTipo_pedido() {
    return tipo_pedido;
  }

  public void setTipo_pedido(java.lang.String PARAM) {
    this.tipo_pedido = PARAM;
  }

  public java.lang.String getPermiti_alterar_preco() {
    return permiti_alterar_preco;
  }

  public void setPermiti_alterar_preco(java.lang.String PARAM) {
    this.permiti_alterar_preco = PARAM;
  }

}
