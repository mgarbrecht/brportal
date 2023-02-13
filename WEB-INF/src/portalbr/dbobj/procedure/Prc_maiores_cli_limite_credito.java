package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_maiores_cli_limite_credito
  * @version 17/11/2011 08:34:45
  */
public class Prc_maiores_cli_limite_credito implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_cli_cdgo;
  private java.lang.String p_gre_grupo;
  private java.lang.String p_tipo_mercado;
  private int p_meses;
  private double p_vlr_ped_abe_lib;
  private double p_limite;
  private double p_saldo;
  private double p_qtd_vencer;
  private double p_vlr_vencer;
  private double p_qtd_vencido;
  private double p_vlr_vencido;
  private double p_percentual_pontualidade;
  private double p_vlr_ped_abe_nlib;

  public Prc_maiores_cli_limite_credito() {
  }

  public java.lang.String getP_cli_cdgo() {
    return p_cli_cdgo;
  }

  public void setP_cli_cdgo(java.lang.String PARAM) {
    this.p_cli_cdgo = PARAM;
  }

  public java.lang.String getP_gre_grupo() {
    return p_gre_grupo;
  }

  public void setP_gre_grupo(java.lang.String PARAM) {
    this.p_gre_grupo = PARAM;
  }

  public java.lang.String getP_tipo_mercado() {
    return p_tipo_mercado;
  }

  public void setP_tipo_mercado(java.lang.String PARAM) {
    this.p_tipo_mercado = PARAM;
  }

  public int getP_meses() {
    return p_meses;
  }

  public void setP_meses(int PARAM) {
    this.p_meses = PARAM;
  }

  public double getP_vlr_ped_abe_lib() {
    return p_vlr_ped_abe_lib;
  }

  public void setP_vlr_ped_abe_lib(double PARAM) {
    this.p_vlr_ped_abe_lib = PARAM;
  }

  public double getP_limite() {
    return p_limite;
  }

  public void setP_limite(double PARAM) {
    this.p_limite = PARAM;
  }

  public double getP_saldo() {
    return p_saldo;
  }

  public void setP_saldo(double PARAM) {
    this.p_saldo = PARAM;
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

  public double getP_percentual_pontualidade() {
    return p_percentual_pontualidade;
  }

  public void setP_percentual_pontualidade(double PARAM) {
    this.p_percentual_pontualidade = PARAM;
  }

  public double getP_vlr_ped_abe_nlib() {
    return p_vlr_ped_abe_nlib;
  }

  public void setP_vlr_ped_abe_nlib(double PARAM) {
    this.p_vlr_ped_abe_nlib = PARAM;
  }

}
