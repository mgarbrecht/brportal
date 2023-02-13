package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_his_pgtos_an
  * @version 18/07/2014 14:23:35
  */
public class Prc_ctr_his_pgtos_anMetaData {

  public static final String SCHEMA = "BRCONREC";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Prc_ctr_his_pgtos_an";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_clientes","10","in","text","P_clientes","","","","","","",},
                            {"double","p_cli_cdgo","22","in","text","P_cli_cdgo","","##,##0.00","true","","","",},
                            {"double","p_grupo_economico","22","in","text","P_grupo_economico","","##,##0.00","true","","","",},
                            {"double","p_meses_atras","22","in","text","P_meses_atras","","##,##0.00","true","","","",},
                            {"java.lang.String","p_emp","10","in","text","P_emp","","","","","","",},
                            {"java.lang.String","p_pri_compra","10","out","text","P_pri_compra","","","","","","",},
                            {"double","p_vlr_pri_compra","24","out","text","P_vlr_pri_compra","","##,##0.00","true","","","",},
                            {"java.lang.String","p_ult_compra","10","out","text","P_ult_compra","","","","","","",},
                            {"double","p_vlr_ult_compra","24","out","text","P_vlr_ult_compra","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mai_compra","10","out","text","P_mai_compra","","","","","","",},
                            {"double","p_vlr_mai_compra","24","out","text","P_vlr_mai_compra","","##,##0.00","true","","","",},
                            {"double","p_qtd_12","22","out","text","P_qtd_12","","##,##0.00","true","","","",},
                            {"double","p_vlr_12","24","out","text","P_vlr_12","","##,##0.00","true","","","",},
                            {"double","p_qtd_6","22","out","text","P_qtd_6","","##,##0.00","true","","","",},
                            {"double","p_vlr_6","24","out","text","P_vlr_6","","##,##0.00","true","","","",},
                            {"double","p_qtd_02","22","out","text","P_qtd_02","","##,##0.00","true","","","",},
                            {"double","p_vlr_02","24","out","text","P_vlr_02","","##,##0.00","true","","","",},
                            {"double","p_perc_02","22","out","text","P_perc_02","","##,##0.00","true","","","",},
                            {"double","p_qtd_36","22","out","text","P_qtd_36","","##,##0.00","true","","","",},
                            {"double","p_vlr_36","24","out","text","P_vlr_36","","##,##0.00","true","","","",},
                            {"double","p_perc_36","22","out","text","P_perc_36","","##,##0.00","true","","","",},
                            {"double","p_qtd_720","22","out","text","P_qtd_720","","##,##0.00","true","","","",},
                            {"double","p_vlr_720","24","out","text","P_vlr_720","","##,##0.00","true","","","",},
                            {"double","p_perc_720","22","out","text","P_perc_720","","##,##0.00","true","","","",},
                            {"double","p_qtd_2130","22","out","text","P_qtd_2130","","##,##0.00","true","","","",},
                            {"double","p_vlr_2130","24","out","text","P_vlr_2130","","##,##0.00","true","","","",},
                            {"double","p_perc_2130","22","out","text","P_perc_2130","","##,##0.00","true","","","",},
                            {"double","p_qtd_a30","22","out","text","P_qtd_a30","","##,##0.00","true","","","",},
                            {"double","p_vlr_a30","24","out","text","P_vlr_a30","","##,##0.00","true","","","",},
                            {"double","p_perc_a30","22","out","text","P_perc_a30","","##,##0.00","true","","","",},
                            {"double","p_qtd_car","22","out","text","P_qtd_car","","##,##0.00","true","","","",},
                            {"double","p_vlr_car","24","out","text","P_vlr_car","","##,##0.00","true","","","",},
                            {"double","p_perc_car","22","out","text","P_perc_car","","##,##0.00","true","","","",},
                            {"double","p_qtd_dev","22","out","text","P_qtd_dev","","##,##0.00","true","","","",},
                            {"double","p_vlr_dev","24","out","text","P_vlr_dev","","##,##0.00","true","","","",},
                            {"double","p_perc_dev","22","out","text","P_perc_dev","","##,##0.00","true","","","",},
                            {"double","p_qtd_pro","22","out","text","P_qtd_pro","","##,##0.00","true","","","",},
                            {"double","p_vlr_pro","24","out","text","P_vlr_pro","","##,##0.00","true","","","",},
                            {"double","p_perc_pro","22","out","text","P_perc_pro","","##,##0.00","true","","","",},
                            {"double","p_qtd_neg_ok","22","out","text","P_qtd_neg_ok","","##,##0.00","true","","","",},
                            {"double","p_vlr_neg_ok","24","out","text","P_vlr_neg_ok","","##,##0.00","true","","","",},
                            {"double","p_perc_neg_ok","22","out","text","P_perc_neg_ok","","##,##0.00","true","","","",},
                            {"double","p_qtd_neg_enc","22","out","text","P_qtd_neg_enc","","##,##0.00","true","","","",},
                            {"double","p_vlr_neg_enc","24","out","text","P_vlr_neg_enc","","##,##0.00","true","","","",},
                            {"double","p_perc_neg_enc","22","out","text","P_perc_neg_enc","","##,##0.00","true","","","",},
                            {"double","p_qtd_neg_abe","22","out","text","P_qtd_neg_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_neg_abe","22","out","text","P_vlr_neg_abe","","##,##0.00","true","","","",},
                            {"double","p_qtd_chd_liq","22","out","text","P_qtd_chd_liq","","##,##0.00","true","","","",},
                            {"double","p_vlr_chd_liq","22","out","text","P_vlr_chd_liq","","##,##0.00","true","","","",},
                            {"double","p_qtd_chd_abe","22","out","text","P_qtd_chd_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_chd_abe","22","out","text","P_vlr_chd_abe","","##,##0.00","true","","","",},
                            {"double","p_qtd_pro_abe","22","out","text","P_qtd_pro_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_pro_abe","22","out","text","P_vlr_pro_abe","","##,##0.00","true","","","",},
                            {"double","p_qtd_dis_abe","22","out","text","P_qtd_dis_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_dis_abe","22","out","text","P_vlr_dis_abe","","##,##0.00","true","","","",},
                            {"double","p_qtd_fora_pend","22","out","text","P_qtd_fora_pend","","##,##0.00","true","","","",},
                            {"double","p_vlr_fora_pend","22","out","text","P_vlr_fora_pend","","##,##0.00","true","","","",},
                            {"double","p_qtd_tit_abe","22","out","text","P_qtd_tit_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_tit_abe","22","out","text","P_vlr_tit_abe","","##,##0.00","true","","","",},
                            {"double","p_qtd_ap_ate","22","out","text","P_qtd_ap_ate","","##,##0.00","true","","","",},
                            {"double","p_vlr_ap_ate","22","out","text","P_vlr_ap_ate","","##,##0.00","true","","","",},
                            {"double","p_qtd_ap_apo","22","out","text","P_qtd_ap_apo","","##,##0.00","true","","","",},
                            {"double","p_vlr_ap_apo","22","out","text","P_vlr_ap_apo","","##,##0.00","true","","","",},
                            {"double","p_qtd_ve_ate","22","out","text","P_qtd_ve_ate","","##,##0.00","true","","","",},
                            {"double","p_vlr_ve_ate","22","out","text","P_vlr_ve_ate","","##,##0.00","true","","","",},
                            {"double","p_qtd_ve_apo","22","out","text","P_qtd_ve_apo","","##,##0.00","true","","","",},
                            {"double","p_vlr_ve_apo","22","out","text","P_vlr_ve_apo","","##,##0.00","true","","","",},
                            {"double","p_qtd_tot_ave","22","out","text","P_qtd_tot_ave","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_ave","22","out","text","P_vlr_tot_ave","","##,##0.00","true","","","",},
                            {"double","p_qtd_tot_ven","22","out","text","P_qtd_tot_ven","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_ven","22","out","text","P_vlr_tot_ven","","##,##0.00","true","","","",},
                            {"double","p_perc_ven","22","out","text","P_perc_ven","","##,##0.00","true","","","",},
                            {"double","p_qtd_tot_ger","22","out","text","P_qtd_tot_ger","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_ger","22","out","text","P_vlr_tot_ger","","##,##0.00","true","","","",},
                            {"double","p_qtd_ped_abe_nlib","22","out","text","P_qtd_ped_abe_nlib","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_nlib","22","out","text","P_vlr_ped_abe_nlib","","##,##0.00","true","","","",},
                            {"double","p_qtd_ped_abe_lib","22","out","text","P_qtd_ped_abe_lib","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_lib","22","out","text","P_vlr_ped_abe_lib","","##,##0.00","true","","","",},
                            {"double","p_limite","22","out","text","P_limite","","##,##0.00","true","","","",},
                            {"double","p_saldo","22","out","text","P_saldo","","##,##0.00","true","","","",},
                            {"double","p_qtd_fis_abe","22","out","text","P_qtd_fis_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_fis_abe","22","out","text","P_vlr_fis_abe","","##,##0.00","true","","","",},
                            {"java.lang.String","p_erro","10","inout","text","P_erro","","","","","","",},
                            {"double","p_qtd_pefin_abe","22","out","text","p_qtd_pefin_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_pefin_abe","22","out","text","p_vlr_pefin_abe","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
