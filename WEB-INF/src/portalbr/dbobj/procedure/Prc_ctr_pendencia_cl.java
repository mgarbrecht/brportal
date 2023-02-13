package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_pendencia_cl
  * @version 11/08/2014 08:07:51
  */
public class Prc_ctr_pendencia_cl implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private double p_cli;
  private java.lang.String p_emp_empresa;
  private double p_qtd_neg_abe;
  private double p_vlr_neg_abe;
  private double p_qtd_chd_liq;
  private double p_vlr_chd_liq;
  private double p_qtd_chd_abe;
  private double p_vlr_chd_abe;
  private double p_qtd_pro_abe;
  private double p_vlr_pro_abe;
  private double p_qtd_dis_abe;
  private double p_vlr_dis_abe;
  private double p_qtd_fora_pend;
  private double p_vlr_fora_pend;
  private double p_qtd_tit_abe;
  private double p_vlr_tit_abe;
  private double p_qtd_ap_ate;
  private double p_vlr_ap_ate;
  private double p_qtd_ap_apo;
  private double p_vlr_ap_apo;
  private double p_qtd_ve_ate;
  private double p_vlr_ve_ate;
  private double p_qtd_ve_apo;
  private double p_vlr_ve_apo;
  private double p_qtd_tot_ave;
  private double p_vlr_tot_ave;
  private double p_qtd_tot_ven;
  private double p_vlr_tot_ven;
  private double p_qtd_tot_ger;
  private double p_vlr_tot_ger;
  private double p_qtd_fis_abe;
  private double p_vlr_fis_abe;
  private java.lang.String p_erro;
  private double p_qtd_pefin_abe;
  private double p_vlr_pefin_abe;

  public Prc_ctr_pendencia_cl() {
  }

  public double getP_cli() {
    return p_cli;
  }

  public void setP_cli(double PARAM) {
    this.p_cli = PARAM;
  }

  public java.lang.String getP_emp_empresa() {
    return p_emp_empresa;
  }

  public void setP_emp_empresa(java.lang.String PARAM) {
    this.p_emp_empresa = PARAM;
  }

  public double getP_qtd_neg_abe() {
    return p_qtd_neg_abe;
  }

  public void setP_qtd_neg_abe(double PARAM) {
    this.p_qtd_neg_abe = PARAM;
  }

  public double getP_vlr_neg_abe() {
    return p_vlr_neg_abe;
  }

  public void setP_vlr_neg_abe(double PARAM) {
    this.p_vlr_neg_abe = PARAM;
  }

  public double getP_qtd_chd_liq() {
    return p_qtd_chd_liq;
  }

  public void setP_qtd_chd_liq(double PARAM) {
    this.p_qtd_chd_liq = PARAM;
  }

  public double getP_vlr_chd_liq() {
    return p_vlr_chd_liq;
  }

  public void setP_vlr_chd_liq(double PARAM) {
    this.p_vlr_chd_liq = PARAM;
  }

  public double getP_qtd_chd_abe() {
    return p_qtd_chd_abe;
  }

  public void setP_qtd_chd_abe(double PARAM) {
    this.p_qtd_chd_abe = PARAM;
  }

  public double getP_vlr_chd_abe() {
    return p_vlr_chd_abe;
  }

  public void setP_vlr_chd_abe(double PARAM) {
    this.p_vlr_chd_abe = PARAM;
  }

  public double getP_qtd_pro_abe() {
    return p_qtd_pro_abe;
  }

  public void setP_qtd_pro_abe(double PARAM) {
    this.p_qtd_pro_abe = PARAM;
  }

  public double getP_vlr_pro_abe() {
    return p_vlr_pro_abe;
  }

  public void setP_vlr_pro_abe(double PARAM) {
    this.p_vlr_pro_abe = PARAM;
  }

  public double getP_qtd_dis_abe() {
    return p_qtd_dis_abe;
  }

  public void setP_qtd_dis_abe(double PARAM) {
    this.p_qtd_dis_abe = PARAM;
  }

  public double getP_vlr_dis_abe() {
    return p_vlr_dis_abe;
  }

  public void setP_vlr_dis_abe(double PARAM) {
    this.p_vlr_dis_abe = PARAM;
  }

  public double getP_qtd_fora_pend() {
    return p_qtd_fora_pend;
  }

  public void setP_qtd_fora_pend(double PARAM) {
    this.p_qtd_fora_pend = PARAM;
  }

  public double getP_vlr_fora_pend() {
    return p_vlr_fora_pend;
  }

  public void setP_vlr_fora_pend(double PARAM) {
    this.p_vlr_fora_pend = PARAM;
  }

  public double getP_qtd_tit_abe() {
    return p_qtd_tit_abe;
  }

  public void setP_qtd_tit_abe(double PARAM) {
    this.p_qtd_tit_abe = PARAM;
  }

  public double getP_vlr_tit_abe() {
    return p_vlr_tit_abe;
  }

  public void setP_vlr_tit_abe(double PARAM) {
    this.p_vlr_tit_abe = PARAM;
  }

  public double getP_qtd_ap_ate() {
    return p_qtd_ap_ate;
  }

  public void setP_qtd_ap_ate(double PARAM) {
    this.p_qtd_ap_ate = PARAM;
  }

  public double getP_vlr_ap_ate() {
    return p_vlr_ap_ate;
  }

  public void setP_vlr_ap_ate(double PARAM) {
    this.p_vlr_ap_ate = PARAM;
  }

  public double getP_qtd_ap_apo() {
    return p_qtd_ap_apo;
  }

  public void setP_qtd_ap_apo(double PARAM) {
    this.p_qtd_ap_apo = PARAM;
  }

  public double getP_vlr_ap_apo() {
    return p_vlr_ap_apo;
  }

  public void setP_vlr_ap_apo(double PARAM) {
    this.p_vlr_ap_apo = PARAM;
  }

  public double getP_qtd_ve_ate() {
    return p_qtd_ve_ate;
  }

  public void setP_qtd_ve_ate(double PARAM) {
    this.p_qtd_ve_ate = PARAM;
  }

  public double getP_vlr_ve_ate() {
    return p_vlr_ve_ate;
  }

  public void setP_vlr_ve_ate(double PARAM) {
    this.p_vlr_ve_ate = PARAM;
  }

  public double getP_qtd_ve_apo() {
    return p_qtd_ve_apo;
  }

  public void setP_qtd_ve_apo(double PARAM) {
    this.p_qtd_ve_apo = PARAM;
  }

  public double getP_vlr_ve_apo() {
    return p_vlr_ve_apo;
  }

  public void setP_vlr_ve_apo(double PARAM) {
    this.p_vlr_ve_apo = PARAM;
  }

  public double getP_qtd_tot_ave() {
    return p_qtd_tot_ave;
  }

  public void setP_qtd_tot_ave(double PARAM) {
    this.p_qtd_tot_ave = PARAM;
  }

  public double getP_vlr_tot_ave() {
    return p_vlr_tot_ave;
  }

  public void setP_vlr_tot_ave(double PARAM) {
    this.p_vlr_tot_ave = PARAM;
  }

  public double getP_qtd_tot_ven() {
    return p_qtd_tot_ven;
  }

  public void setP_qtd_tot_ven(double PARAM) {
    this.p_qtd_tot_ven = PARAM;
  }

  public double getP_vlr_tot_ven() {
    return p_vlr_tot_ven;
  }

  public void setP_vlr_tot_ven(double PARAM) {
    this.p_vlr_tot_ven = PARAM;
  }

  public double getP_qtd_tot_ger() {
    return p_qtd_tot_ger;
  }

  public void setP_qtd_tot_ger(double PARAM) {
    this.p_qtd_tot_ger = PARAM;
  }

  public double getP_vlr_tot_ger() {
    return p_vlr_tot_ger;
  }

  public void setP_vlr_tot_ger(double PARAM) {
    this.p_vlr_tot_ger = PARAM;
  }

  public double getP_qtd_fis_abe() {
    return p_qtd_fis_abe;
  }

  public void setP_qtd_fis_abe(double PARAM) {
    this.p_qtd_fis_abe = PARAM;
  }

  public double getP_vlr_fis_abe() {
    return p_vlr_fis_abe;
  }

  public void setP_vlr_fis_abe(double PARAM) {
    this.p_vlr_fis_abe = PARAM;
  }

  public java.lang.String getP_erro() {
    return p_erro;
  }

  public void setP_erro(java.lang.String PARAM) {
    this.p_erro = PARAM;
  }

  public double getP_qtd_pefin_abe() {
    return p_qtd_pefin_abe;
  }

  public void setP_qtd_pefin_abe(double PARAM) {
    this.p_qtd_pefin_abe = PARAM;
  }

  public double getP_vlr_pefin_abe() {
    return p_vlr_pefin_abe;
  }

  public void setP_vlr_pefin_abe(double PARAM) {
    this.p_vlr_pefin_abe = PARAM;
  }

}
