package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_limite_credito
  * @version 03/04/2013 09:23:00
  */
public class Jw_maiores_clientes_limite_credito implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String razao;
  private java.lang.String tipo;
  private double limite;
  private double pedidos_producao;
  private double saldo;
  private double p_qtd_vencer;
  private double p_vlr_vencer;
  private double p_qtd_vencido;
  private double p_vlr_vencido;
  private double percentual_pontualidade;
  private double pedidos_nao_liberados;

  public Jw_maiores_clientes_limite_credito() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getRazao() {
    return razao;
  }

  public void setRazao(java.lang.String PARAM) {
    this.razao = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public double getLimite() {
    return limite;
  }

  public void setLimite(double PARAM) {
    this.limite = PARAM;
  }

  public double getPedidos_producao() {
    return pedidos_producao;
  }

  public void setPedidos_producao(double PARAM) {
    this.pedidos_producao = PARAM;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double PARAM) {
    this.saldo = PARAM;
  }

  public double getP_qtd_vencer() {
    return p_qtd_vencer;
  }

  public void setP_qtd_vencer(double PARAM) {
    this.p_qtd_vencer = PARAM;
  }

  public double getP_vlr_vencer() {
    return p_vlr_vencer;
  }

  public void setP_vlr_vencer(double PARAM) {
    this.p_vlr_vencer = PARAM;
  }

  public double getP_qtd_vencido() {
    return p_qtd_vencido;
  }

  public void setP_qtd_vencido(double PARAM) {
    this.p_qtd_vencido = PARAM;
  }

  public double getP_vlr_vencido() {
    return p_vlr_vencido;
  }

  public void setP_vlr_vencido(double PARAM) {
    this.p_vlr_vencido = PARAM;
  }

  public double getPercentual_pontualidade() {
    return percentual_pontualidade;
  }

  public void setPercentual_pontualidade(double PARAM) {
    this.percentual_pontualidade = PARAM;
  }

  public double getPedidos_nao_liberados() {
    return pedidos_nao_liberados;
  }

  public void setPedidos_nao_liberados(double PARAM) {
    this.pedidos_nao_liberados = PARAM;
  }

}
