package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_mapa_diario_anterior
  * @version 13/09/2019 15:21:50
  */
public class Jw_consulta_mapa_diario_anterior implements java.io.Serializable, com.egen.util.jdbc.View {
  private double entrada_mes_ant_valor;
  private double variacao_entrada_valor;
  private double faturamento_mes_ant;
  private double variacao_faturamento_valor;

  public Jw_consulta_mapa_diario_anterior() {
  }

  public double getEntrada_mes_ant_valor() {
    return entrada_mes_ant_valor;
  }

  public void setEntrada_mes_ant_valor(double PARAM) {
    this.entrada_mes_ant_valor = PARAM;
  }

  public double getVariacao_entrada_valor() {
    return variacao_entrada_valor;
  }

  public void setVariacao_entrada_valor(double PARAM) {
    this.variacao_entrada_valor = PARAM;
  }

  public double getFaturamento_mes_ant() {
    return faturamento_mes_ant;
  }

  public void setFaturamento_mes_ant(double PARAM) {
    this.faturamento_mes_ant = PARAM;
  }

  public double getVariacao_faturamento_valor() {
    return variacao_faturamento_valor;
  }

  public void setVariacao_faturamento_valor(double PARAM) {
    this.variacao_faturamento_valor = PARAM;
  }

}
