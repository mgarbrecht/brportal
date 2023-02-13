package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_pendencia_cl
  * @version 11/08/2014 08:07:55
  */
public class Prc_ctr_pendencia_clMetaData {

  public static final String SCHEMA = "BRCONREC";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Prc_ctr_pendencia_cl";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","p_cli","22","in","text","P_cli","","##,##0.00","true","","","",},
                            {"java.lang.String","p_emp_empresa","10","in","text","P_emp_empresa","","","","","","",},
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
                            {"double","p_qtd_tot_ger","22","out","text","P_qtd_tot_ger","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_ger","22","out","text","P_vlr_tot_ger","","##,##0.00","true","","","",},
                            {"double","p_qtd_fis_abe","22","out","text","P_qtd_fis_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_fis_abe","22","out","text","P_vlr_fis_abe","","##,##0.00","true","","","",},
                            {"java.lang.String","p_erro","10","inout","text","P_erro","","","","","","",},
                            {"double","p_qtd_pefin_abe","22","out","text","p_qtd_pefin_abe","","##,##0.00","true","","","",},
                            {"double","p_vlr_pefin_abe","22","out","text","p_vlr_pefin_abe","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
