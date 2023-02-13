package portalbr.dbobj.view;

/** DataBase Object from table .Jw_analise_credito_gerencial
  * @version 10/09/2021 11:19:25
  */
public class Jw_analise_credito_gerencial implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String mes_ano;
  private java.lang.Double vlr_faturado;
  private java.lang.Double vlr_liquidado;
  private java.lang.Double vlr_pror_a;
  private java.lang.Double vlr_pror_l;
  private java.lang.Double total_vlr_faturado;
  private java.lang.Double total_vlr_liquidado;
  private java.lang.Double total_vlr_pror_a;
  private java.lang.Double total_vlr_pror_l;
  private java.lang.String pag_mercado;

  public Jw_analise_credito_gerencial() {
  }

  public java.lang.String getMes_ano() {
    return mes_ano;
  }

  public void setMes_ano(java.lang.String PARAM) {
    this.mes_ano = PARAM;
  }

  public java.lang.Double getVlr_faturado() {
    return vlr_faturado;
  }

  public void setVlr_faturado(java.lang.Double PARAM) {
    this.vlr_faturado = PARAM;
  }

  public java.lang.Double getVlr_liquidado() {
    return vlr_liquidado;
  }

  public void setVlr_liquidado(java.lang.Double PARAM) {
    this.vlr_liquidado = PARAM;
  }

  public java.lang.Double getVlr_pror_a() {
    return vlr_pror_a;
  }

  public void setVlr_pror_a(java.lang.Double PARAM) {
    this.vlr_pror_a = PARAM;
  }

  public java.lang.Double getVlr_pror_l() {
    return vlr_pror_l;
  }

  public void setVlr_pror_l(java.lang.Double PARAM) {
    this.vlr_pror_l = PARAM;
  }

  public java.lang.Double getTotal_vlr_faturado() {
    return total_vlr_faturado;
  }

  public void setTotal_vlr_faturado(java.lang.Double PARAM) {
    this.total_vlr_faturado = PARAM;
  }

  public java.lang.Double getTotal_vlr_liquidado() {
    return total_vlr_liquidado;
  }

  public void setTotal_vlr_liquidado(java.lang.Double PARAM) {
    this.total_vlr_liquidado = PARAM;
  }

  public java.lang.Double getTotal_vlr_pror_a() {
    return total_vlr_pror_a;
  }

  public void setTotal_vlr_pror_a(java.lang.Double PARAM) {
    this.total_vlr_pror_a = PARAM;
  }

  public java.lang.Double getTotal_vlr_pror_l() {
    return total_vlr_pror_l;
  }

  public void setTotal_vlr_pror_l(java.lang.Double PARAM) {
    this.total_vlr_pror_l = PARAM;
  }

  public java.lang.String getPag_mercado() {
    return pag_mercado;
  }

  public void setPag_mercado(java.lang.String PARAM) {
    this.pag_mercado = PARAM;
  }

}
