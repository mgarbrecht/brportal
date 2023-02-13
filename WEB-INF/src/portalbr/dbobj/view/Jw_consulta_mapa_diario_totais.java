package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_mapa_diario_totais
  * @version 04/03/2015 10:35:02
  */
public class Jw_consulta_mapa_diario_totais implements java.io.Serializable, com.egen.util.jdbc.View {
  private double total_para_mes_valor;
  private double carteira_atual_valor;
  private double carteira_anterior_valor;
  private double variacao_carteira_valor;

  public Jw_consulta_mapa_diario_totais() {
  }

  public double getTotal_para_mes_valor() {
    return total_para_mes_valor;
  }

  public void setTotal_para_mes_valor(double PARAM) {
    this.total_para_mes_valor = PARAM;
  }

  public double getCarteira_atual_valor() {
    return carteira_atual_valor;
  }

  public void setCarteira_atual_valor(double PARAM) {
    this.carteira_atual_valor = PARAM;
  }

  public double getCarteira_anterior_valor() {
    return carteira_anterior_valor;
  }

  public void setCarteira_anterior_valor(double PARAM) {
    this.carteira_anterior_valor = PARAM;
  }

  public double getVariacao_carteira_valor() {
    return variacao_carteira_valor;
  }

  public void setVariacao_carteira_valor(double PARAM) {
    this.variacao_carteira_valor = PARAM;
  }

}
