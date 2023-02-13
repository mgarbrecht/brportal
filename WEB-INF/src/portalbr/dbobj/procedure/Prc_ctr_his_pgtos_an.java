package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_his_pgtos_an
  * @version 18/07/2014 14:23:33
  */
public class Prc_ctr_his_pgtos_an implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_clientes;
  private double p_cli_cdgo;
  private double p_grupo_economico;
  private double p_meses_atras;
  private java.lang.String p_emp;
  private java.lang.String p_pri_compra;
  private double p_vlr_pri_compra;
  private java.lang.String p_ult_compra;
  private double p_vlr_ult_compra;
  private java.lang.String p_mai_compra;
  private double p_vlr_mai_compra;
  private double p_qtd_12;
  private double p_vlr_12;
  private double p_qtd_6;
  private double p_vlr_6;
  private double p_qtd_02;
  private double p_vlr_02;
  private double p_perc_02;
  private double p_qtd_36;
  private double p_vlr_36;
  private double p_perc_36;
  private double p_qtd_720;
  private double p_vlr_720;
  private double p_perc_720;
  private double p_qtd_2130;
  private double p_vlr_2130;
  private double p_perc_2130;
  private double p_qtd_a30;
  private double p_vlr_a30;
  private double p_perc_a30;
  private double p_qtd_car;
  private double p_vlr_car;
  private double p_perc_car;
  private double p_qtd_dev;
  private double p_vlr_dev;
  private double p_perc_dev;
  private double p_qtd_pro;
  private double p_vlr_pro;
  private double p_perc_pro;
  private double p_qtd_neg_ok;
  private double p_vlr_neg_ok;
  private double p_perc_neg_ok;
  private double p_qtd_neg_enc;
  private double p_vlr_neg_enc;
  private double p_perc_neg_enc;
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
  private double p_perc_ven;
  private double p_qtd_tot_ger;
  private double p_vlr_tot_ger;
  private double p_qtd_ped_abe_nlib;
  private double p_vlr_ped_abe_nlib;
  private double p_qtd_ped_abe_lib;
  private double p_vlr_ped_abe_lib;
  private double p_limite;
  private double p_saldo;
  private double p_qtd_fis_abe;
  private double p_vlr_fis_abe;
  private java.lang.String p_erro;
  private double p_qtd_pefin_abe;
  private double p_vlr_pefin_abe;

  public Prc_ctr_his_pgtos_an() {
  }

  public java.lang.String getP_clientes() {
    return p_clientes;
  }

  public void setP_clientes(java.lang.String PARAM) {
    this.p_clientes = PARAM;
  }

  public double getP_cli_cdgo() {
    return p_cli_cdgo;
  }

  public void setP_cli_cdgo(double PARAM) {
    this.p_cli_cdgo = PARAM;
  }

  public double getP_grupo_economico() {
    return p_grupo_economico;
  }

  public void setP_grupo_economico(double PARAM) {
    this.p_grupo_economico = PARAM;
  }

  public double getP_meses_atras() {
    return p_meses_atras;
  }

  public void setP_meses_atras(double PARAM) {
    this.p_meses_atras = PARAM;
  }

  public java.lang.String getP_emp() {
    return p_emp;
  }

  public void setP_emp(java.lang.String PARAM) {
    this.p_emp = PARAM;
  }

  public java.lang.String getP_pri_compra() {
    return p_pri_compra;
  }

  public void setP_pri_compra(java.lang.String PARAM) {
    this.p_pri_compra = PARAM;
  }

  public double getP_vlr_pri_compra() {
    return p_vlr_pri_compra;
  }

  public void setP_vlr_pri_compra(double PARAM) {
    this.p_vlr_pri_compra = PARAM;
  }

  public java.lang.String getP_ult_compra() {
    return p_ult_compra;
  }

  public void setP_ult_compra(java.lang.String PARAM) {
    this.p_ult_compra = PARAM;
  }

  public double getP_vlr_ult_compra() {
    return p_vlr_ult_compra;
  }

  public void setP_vlr_ult_compra(double PARAM) {
    this.p_vlr_ult_compra = PARAM;
  }

  public java.lang.String getP_mai_compra() {
    return p_mai_compra;
  }

  public void setP_mai_compra(java.lang.String PARAM) {
    this.p_mai_compra = PARAM;
  }

  public double getP_vlr_mai_compra() {
    return p_vlr_mai_compra;
  }

  public void setP_vlr_mai_compra(double PARAM) {
    this.p_vlr_mai_compra = PARAM;
  }

  public double getP_qtd_12() {
    return p_qtd_12;
  }

  public void setP_qtd_12(double PARAM) {
    this.p_qtd_12 = PARAM;
  }

  public double getP_vlr_12() {
    return p_vlr_12;
  }

  public void setP_vlr_12(double PARAM) {
    this.p_vlr_12 = PARAM;
  }

  public double getP_qtd_6() {
    return p_qtd_6;
  }

  public void setP_qtd_6(double PARAM) {
    this.p_qtd_6 = PARAM;
  }

  public double getP_vlr_6() {
    return p_vlr_6;
  }

  public void setP_vlr_6(double PARAM) {
    this.p_vlr_6 = PARAM;
  }

  public double getP_qtd_02() {
    return p_qtd_02;
  }

  public void setP_qtd_02(double PARAM) {
    this.p_qtd_02 = PARAM;
  }

  public double getP_vlr_02() {
    return p_vlr_02;
  }

  public void setP_vlr_02(double PARAM) {
    this.p_vlr_02 = PARAM;
  }

  public double getP_perc_02() {
    return p_perc_02;
  }

  public void setP_perc_02(double PARAM) {
    this.p_perc_02 = PARAM;
  }

  public double getP_qtd_36() {
    return p_qtd_36;
  }

  public void setP_qtd_36(double PARAM) {
    this.p_qtd_36 = PARAM;
  }

  public double getP_vlr_36() {
    return p_vlr_36;
  }

  public void setP_vlr_36(double PARAM) {
    this.p_vlr_36 = PARAM;
  }

  public double getP_perc_36() {
    return p_perc_36;
  }

  public void setP_perc_36(double PARAM) {
    this.p_perc_36 = PARAM;
  }

  public double getP_qtd_720() {
    return p_qtd_720;
  }

  public void setP_qtd_720(double PARAM) {
    this.p_qtd_720 = PARAM;
  }

  public double getP_vlr_720() {
    return p_vlr_720;
  }

  public void setP_vlr_720(double PARAM) {
    this.p_vlr_720 = PARAM;
  }

  public double getP_perc_720() {
    return p_perc_720;
  }

  public void setP_perc_720(double PARAM) {
    this.p_perc_720 = PARAM;
  }

  public double getP_qtd_2130() {
    return p_qtd_2130;
  }

  public void setP_qtd_2130(double PARAM) {
    this.p_qtd_2130 = PARAM;
  }

  public double getP_vlr_2130() {
    return p_vlr_2130;
  }

  public void setP_vlr_2130(double PARAM) {
    this.p_vlr_2130 = PARAM;
  }

  public double getP_perc_2130() {
    return p_perc_2130;
  }

  public void setP_perc_2130(double PARAM) {
    this.p_perc_2130 = PARAM;
  }

  public double getP_qtd_a30() {
    return p_qtd_a30;
  }

  public void setP_qtd_a30(double PARAM) {
    this.p_qtd_a30 = PARAM;
  }

  public double getP_vlr_a30() {
    return p_vlr_a30;
  }

  public void setP_vlr_a30(double PARAM) {
    this.p_vlr_a30 = PARAM;
  }

  public double getP_perc_a30() {
    return p_perc_a30;
  }

  public void setP_perc_a30(double PARAM) {
    this.p_perc_a30 = PARAM;
  }

  public double getP_qtd_car() {
    return p_qtd_car;
  }

  public void setP_qtd_car(double PARAM) {
    this.p_qtd_car = PARAM;
  }

  public double getP_vlr_car() {
    return p_vlr_car;
  }

  public void setP_vlr_car(double PARAM) {
    this.p_vlr_car = PARAM;
  }

  public double getP_perc_car() {
    return p_perc_car;
  }

  public void setP_perc_car(double PARAM) {
    this.p_perc_car = PARAM;
  }

  public double getP_qtd_dev() {
    return p_qtd_dev;
  }

  public void setP_qtd_dev(double PARAM) {
    this.p_qtd_dev = PARAM;
  }

  public double getP_vlr_dev() {
    return p_vlr_dev;
  }

  public void setP_vlr_dev(double PARAM) {
    this.p_vlr_dev = PARAM;
  }

  public double getP_perc_dev() {
    return p_perc_dev;
  }

  public void setP_perc_dev(double PARAM) {
    this.p_perc_dev = PARAM;
  }

  public double getP_qtd_pro() {
    return p_qtd_pro;
  }

  public void setP_qtd_pro(double PARAM) {
    this.p_qtd_pro = PARAM;
  }

  public double getP_vlr_pro() {
    return p_vlr_pro;
  }

  public void setP_vlr_pro(double PARAM) {
    this.p_vlr_pro = PARAM;
  }

  public double getP_perc_pro() {
    return p_perc_pro;
  }

  public void setP_perc_pro(double PARAM) {
    this.p_perc_pro = PARAM;
  }

  public double getP_qtd_neg_ok() {
    return p_qtd_neg_ok;
  }

  public void setP_qtd_neg_ok(double PARAM) {
    this.p_qtd_neg_ok = PARAM;
  }

  public double getP_vlr_neg_ok() {
    return p_vlr_neg_ok;
  }

  public void setP_vlr_neg_ok(double PARAM) {
    this.p_vlr_neg_ok = PARAM;
  }

  public double getP_perc_neg_ok() {
    return p_perc_neg_ok;
  }

  public void setP_perc_neg_ok(double PARAM) {
    this.p_perc_neg_ok = PARAM;
  }

  public double getP_qtd_neg_enc() {
    return p_qtd_neg_enc;
  }

  public void setP_qtd_neg_enc(double PARAM) {
    this.p_qtd_neg_enc = PARAM;
  }

  public double getP_vlr_neg_enc() {
    return p_vlr_neg_enc;
  }

  public void setP_vlr_neg_enc(double PARAM) {
    this.p_vlr_neg_enc = PARAM;
  }

  public double getP_perc_neg_enc() {
    return p_perc_neg_enc;
  }

  public void setP_perc_neg_enc(double PARAM) {
    this.p_perc_neg_enc = PARAM;
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

  public double getP_perc_ven() {
    return p_perc_ven;
  }

  public void setP_perc_ven(double PARAM) {
    this.p_perc_ven = PARAM;
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

  public double getP_qtd_ped_abe_nlib() {
    return p_qtd_ped_abe_nlib;
  }

  public void setP_qtd_ped_abe_nlib(double PARAM) {
    this.p_qtd_ped_abe_nlib = PARAM;
  }

  public double getP_vlr_ped_abe_nlib() {
    return p_vlr_ped_abe_nlib;
  }

  public void setP_vlr_ped_abe_nlib(double PARAM) {
    this.p_vlr_ped_abe_nlib = PARAM;
  }

  public double getP_qtd_ped_abe_lib() {
    return p_qtd_ped_abe_lib;
  }

  public void setP_qtd_ped_abe_lib(double PARAM) {
    this.p_qtd_ped_abe_lib = PARAM;
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
