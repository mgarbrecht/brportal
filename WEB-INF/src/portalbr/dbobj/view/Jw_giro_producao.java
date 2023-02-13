package portalbr.dbobj.view;

/** DataBase Object from table .Jw_giro_producao
  * @version 21/03/2022 18:10:26
  */
public class Jw_giro_producao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp data;
  private java.lang.String semana;
  private java.lang.String data_descricao;
  private java.lang.String data_abreviada;
  private java.lang.String filial;
  private java.lang.Integer valor_corte;
  private java.lang.Integer valor_costura;
  private java.lang.Integer valor_atelier;
  private java.lang.Integer valor_total_costura;
  private java.lang.Integer valor_montagem;
  private java.lang.Integer valor_corte_dia;
  private java.lang.Integer valor_costura_dia;
  private java.lang.Integer valor_atelier_dia;
  private java.lang.Integer valor_total_costura_dia;
  private java.lang.Integer valor_montagem_dia;
  private java.lang.Integer valor_corte_geral;
  private java.lang.Integer valor_costura_geral;
  private java.lang.Integer valor_atelier_geral;
  private java.lang.Integer valor_total_costura_geral;
  private java.lang.Integer valor_montagem_geral;
  private java.lang.Integer valor_corte_filial;
  private java.lang.Integer valor_costura_filial;
  private java.lang.Integer valor_atelier_filial;
  private java.lang.Integer valor_total_costura_filial;
  private java.lang.Integer valor_montagem_filial;
  private java.lang.Integer valor_corte_filial_semana;
  private java.lang.Integer valor_costura_filial_semana;
  private java.lang.Integer valor_atelier_filial_semana;
  private java.lang.Integer valor_total_costura_filial_semana;
  private java.lang.Integer valor_montagem_filial_semana;
  private java.lang.Integer valor_corte_filial_semana_geral;
  private java.lang.Integer valor_costura_filial_semana_geral;
  private java.lang.Integer valor_atelier_filial_semana_geral;
  private java.lang.Integer valor_total_costura_filial_semana_geral;
  private java.lang.Integer valor_montagem_filial_semana_geral;
  private java.lang.Integer ordem;

  public Jw_giro_producao() {
  }

  public java.sql.Timestamp getData() {
    return data;
  }

  public void setData(java.sql.Timestamp PARAM) {
    this.data = PARAM;
  }

  public java.lang.String getSemana() {
    return semana;
  }

  public void setSemana(java.lang.String PARAM) {
    this.semana = PARAM;
  }

  public java.lang.String getData_descricao() {
    return data_descricao;
  }

  public void setData_descricao(java.lang.String PARAM) {
    this.data_descricao = PARAM;
  }

  public java.lang.String getData_abreviada() {
    return data_abreviada;
  }

  public void setData_abreviada(java.lang.String PARAM) {
    this.data_abreviada = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.Integer getValor_corte() {
    return valor_corte;
  }

  public void setValor_corte(java.lang.Integer PARAM) {
    this.valor_corte = PARAM;
  }

  public java.lang.Integer getValor_costura() {
    return valor_costura;
  }

  public void setValor_costura(java.lang.Integer PARAM) {
    this.valor_costura = PARAM;
  }

  public java.lang.Integer getValor_atelier() {
    return valor_atelier;
  }

  public void setValor_atelier(java.lang.Integer PARAM) {
    this.valor_atelier = PARAM;
  }

  public java.lang.Integer getValor_total_costura() {
    return valor_total_costura;
  }

  public void setValor_total_costura(java.lang.Integer PARAM) {
    this.valor_total_costura = PARAM;
  }

  public java.lang.Integer getValor_montagem() {
    return valor_montagem;
  }

  public void setValor_montagem(java.lang.Integer PARAM) {
    this.valor_montagem = PARAM;
  }

  public java.lang.Integer getValor_corte_dia() {
    return valor_corte_dia;
  }

  public void setValor_corte_dia(java.lang.Integer PARAM) {
    this.valor_corte_dia = PARAM;
  }

  public java.lang.Integer getValor_costura_dia() {
    return valor_costura_dia;
  }

  public void setValor_costura_dia(java.lang.Integer PARAM) {
    this.valor_costura_dia = PARAM;
  }

  public java.lang.Integer getValor_atelier_dia() {
    return valor_atelier_dia;
  }

  public void setValor_atelier_dia(java.lang.Integer PARAM) {
    this.valor_atelier_dia = PARAM;
  }

  public java.lang.Integer getValor_total_costura_dia() {
    return valor_total_costura_dia;
  }

  public void setValor_total_costura_dia(java.lang.Integer PARAM) {
    this.valor_total_costura_dia = PARAM;
  }

  public java.lang.Integer getValor_montagem_dia() {
    return valor_montagem_dia;
  }

  public void setValor_montagem_dia(java.lang.Integer PARAM) {
    this.valor_montagem_dia = PARAM;
  }

  public java.lang.Integer getValor_corte_geral() {
    return valor_corte_geral;
  }

  public void setValor_corte_geral(java.lang.Integer PARAM) {
    this.valor_corte_geral = PARAM;
  }

  public java.lang.Integer getValor_costura_geral() {
    return valor_costura_geral;
  }

  public void setValor_costura_geral(java.lang.Integer PARAM) {
    this.valor_costura_geral = PARAM;
  }

  public java.lang.Integer getValor_atelier_geral() {
    return valor_atelier_geral;
  }

  public void setValor_atelier_geral(java.lang.Integer PARAM) {
    this.valor_atelier_geral = PARAM;
  }

  public java.lang.Integer getValor_total_costura_geral() {
    return valor_total_costura_geral;
  }

  public void setValor_total_costura_geral(java.lang.Integer PARAM) {
    this.valor_total_costura_geral = PARAM;
  }

  public java.lang.Integer getValor_montagem_geral() {
    return valor_montagem_geral;
  }

  public void setValor_montagem_geral(java.lang.Integer PARAM) {
    this.valor_montagem_geral = PARAM;
  }

  public java.lang.Integer getValor_corte_filial() {
    return valor_corte_filial;
  }

  public void setValor_corte_filial(java.lang.Integer PARAM) {
    this.valor_corte_filial = PARAM;
  }

  public java.lang.Integer getValor_costura_filial() {
    return valor_costura_filial;
  }

  public void setValor_costura_filial(java.lang.Integer PARAM) {
    this.valor_costura_filial = PARAM;
  }

  public java.lang.Integer getValor_atelier_filial() {
    return valor_atelier_filial;
  }

  public void setValor_atelier_filial(java.lang.Integer PARAM) {
    this.valor_atelier_filial = PARAM;
  }

  public java.lang.Integer getValor_total_costura_filial() {
    return valor_total_costura_filial;
  }

  public void setValor_total_costura_filial(java.lang.Integer PARAM) {
    this.valor_total_costura_filial = PARAM;
  }

  public java.lang.Integer getValor_montagem_filial() {
    return valor_montagem_filial;
  }

  public void setValor_montagem_filial(java.lang.Integer PARAM) {
    this.valor_montagem_filial = PARAM;
  }

  public java.lang.Integer getValor_corte_filial_semana() {
    return valor_corte_filial_semana;
  }

  public void setValor_corte_filial_semana(java.lang.Integer PARAM) {
    this.valor_corte_filial_semana = PARAM;
  }

  public java.lang.Integer getValor_costura_filial_semana() {
    return valor_costura_filial_semana;
  }

  public void setValor_costura_filial_semana(java.lang.Integer PARAM) {
    this.valor_costura_filial_semana = PARAM;
  }

  public java.lang.Integer getValor_atelier_filial_semana() {
    return valor_atelier_filial_semana;
  }

  public void setValor_atelier_filial_semana(java.lang.Integer PARAM) {
    this.valor_atelier_filial_semana = PARAM;
  }

  public java.lang.Integer getValor_total_costura_filial_semana() {
    return valor_total_costura_filial_semana;
  }

  public void setValor_total_costura_filial_semana(java.lang.Integer PARAM) {
    this.valor_total_costura_filial_semana = PARAM;
  }

  public java.lang.Integer getValor_montagem_filial_semana() {
    return valor_montagem_filial_semana;
  }

  public void setValor_montagem_filial_semana(java.lang.Integer PARAM) {
    this.valor_montagem_filial_semana = PARAM;
  }

  public java.lang.Integer getValor_corte_filial_semana_geral() {
    return valor_corte_filial_semana_geral;
  }

  public void setValor_corte_filial_semana_geral(java.lang.Integer PARAM) {
    this.valor_corte_filial_semana_geral = PARAM;
  }

  public java.lang.Integer getValor_costura_filial_semana_geral() {
    return valor_costura_filial_semana_geral;
  }

  public void setValor_costura_filial_semana_geral(java.lang.Integer PARAM) {
    this.valor_costura_filial_semana_geral = PARAM;
  }

  public java.lang.Integer getValor_atelier_filial_semana_geral() {
    return valor_atelier_filial_semana_geral;
  }

  public void setValor_atelier_filial_semana_geral(java.lang.Integer PARAM) {
    this.valor_atelier_filial_semana_geral = PARAM;
  }

  public java.lang.Integer getValor_total_costura_filial_semana_geral() {
    return valor_total_costura_filial_semana_geral;
  }

  public void setValor_total_costura_filial_semana_geral(java.lang.Integer PARAM) {
    this.valor_total_costura_filial_semana_geral = PARAM;
  }

  public java.lang.Integer getValor_montagem_filial_semana_geral() {
    return valor_montagem_filial_semana_geral;
  }

  public void setValor_montagem_filial_semana_geral(java.lang.Integer PARAM) {
    this.valor_montagem_filial_semana_geral = PARAM;
  }

  public java.lang.Integer getOrdem() {
    return ordem;
  }

  public void setOrdem(java.lang.Integer PARAM) {
    this.ordem = PARAM;
  }

}
