package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_pend_aberta
  * @version 15/05/2012 10:38:31
  */
public class Prc_ctr_pend_abertaMetaData {

  public static final String SCHEMA = "BRCONREC";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Prc_ctr_pend_aberta";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_clientes","10","in","text","P_clientes","","","","","","",},
                            {"double","p_cli_cdgo","22","in","text","P_cli_cdgo","","##,##0.00","true","","","",},
                            {"double","p_grupo_economico","22","in","text","P_grupo_economico","","##,##0.00","true","","","",},
                            {"java.lang.String","p_emp","10","in","text","P_emp","","","","","","",},
                            {"double","p_dias1","22","out","text","P_dias1","","##,##0.00","true","","","",},
                            {"double","p_dias2","22","out","text","P_dias2","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes_1","10","out","text","P_mes_1","","","","","","",},
                            {"java.lang.String","p_mes_2","10","out","text","P_mes_2","","","","","","",},
                            {"java.lang.String","p_mes_3","10","out","text","P_mes_3","","","","","","",},
                            {"double","p_vlr_em_dia_3ma","22","out","text","P_vlr_em_dia_3ma","","##,##0.00","true","","","",},
                            {"double","p_em_dia_3ma","22","out","text","P_em_dia_3ma","","##,##0.00","true","","","",},
                            {"double","p_vlr_em_dia_1mes","22","out","text","P_vlr_em_dia_1mes","","##,##0.00","true","","","",},
                            {"double","p_em_dia_1mes","22","out","text","P_em_dia_1mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_em_dia_2mes","22","out","text","P_vlr_em_dia_2mes","","##,##0.00","true","","","",},
                            {"double","p_em_dia_2mes","22","out","text","P_em_dia_2mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_em_dia_3mes","22","out","text","P_vlr_em_dia_3mes","","##,##0.00","true","","","",},
                            {"double","p_em_dia_3mes","22","out","text","P_em_dia_3mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_atr_me30d_3ma","22","out","text","P_vlr_atr_me30d_3ma","","##,##0.00","true","","","",},
                            {"double","p_atr_me30d_3ma","22","out","text","P_atr_me30d_3ma","","##,##0.00","true","","","",},
                            {"double","p_vlr_ate_1mes","22","out","text","P_vlr_ate_1mes","","##,##0.00","true","","","",},
                            {"double","p_ate_1mes","22","out","text","P_ate_1mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_ate_2mes","22","out","text","P_vlr_ate_2mes","","##,##0.00","true","","","",},
                            {"double","p_ate_2mes","22","out","text","P_ate_2mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_ate_3mes","22","out","text","P_vlr_ate_3mes","","##,##0.00","true","","","",},
                            {"double","p_ate_3mes","22","out","text","P_ate_3mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_atr_ma30d_3ma","22","out","text","P_vlr_atr_ma30d_3ma","","##,##0.00","true","","","",},
                            {"double","p_atr_ma30d_3ma","22","out","text","P_atr_ma30d_3ma","","##,##0.00","true","","","",},
                            {"double","p_vlr_acima_1mes","22","out","text","P_vlr_acima_1mes","","##,##0.00","true","","","",},
                            {"double","p_acima_1mes","22","out","text","P_acima_1mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_acima_2mes","22","out","text","P_vlr_acima_2mes","","##,##0.00","true","","","",},
                            {"double","p_acima_2mes","22","out","text","P_acima_2mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_acima_3mes","22","out","text","P_vlr_acima_3mes","","##,##0.00","true","","","",},
                            {"double","p_acima_3mes","22","out","text","P_acima_3mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_3ma","22","out","text","P_vlr_tot_3ma","","##,##0.00","true","","","",},
                            {"double","p_tot_3ma","22","out","text","P_tot_3ma","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_1mes","22","out","text","P_vlr_tot_1mes","","##,##0.00","true","","","",},
                            {"double","p_tot_1mes","22","out","text","P_tot_1mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_2mes","22","out","text","P_vlr_tot_2mes","","##,##0.00","true","","","",},
                            {"double","p_tot_2mes","22","out","text","P_tot_2mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_tot_3mes","22","out","text","P_vlr_tot_3mes","","##,##0.00","true","","","",},
                            {"double","p_tot_3mes","22","out","text","P_tot_3mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_vct_ab_3ma","22","out","text","P_vlr_vct_ab_3ma","","##,##0.00","true","","","",},
                            {"double","p_vct_ab_3ma","22","out","text","P_vct_ab_3ma","","##,##0.00","true","","","",},
                            {"double","p_vlr_vct_ab_1mes","22","out","text","P_vlr_vct_ab_1mes","","##,##0.00","true","","","",},
                            {"double","p_vct_ab_1mes","22","out","text","P_vct_ab_1mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_vct_ab_2mes","22","out","text","P_vlr_vct_ab_2mes","","##,##0.00","true","","","",},
                            {"double","p_vct_ab_2mes","22","out","text","P_vct_ab_2mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_vct_ab_3mes","22","out","text","P_vlr_vct_ab_3mes","","##,##0.00","true","","","",},
                            {"double","p_vct_ab_3mes","22","out","text","P_vct_ab_3mes","","##,##0.00","true","","","",},
                            {"double","p_vlr_venc_mes_corrente","22","out","text","P_vlr_venc_mes_corrente","","##,##0.00","true","","","",},
                            {"double","p_venc_mes_corrente","22","out","text","P_venc_mes_corrente","","##,##0.00","true","","","",},
                            {"double","p_vlr_avenc_mes_corrente","22","out","text","P_vlr_avenc_mes_corrente","","##,##0.00","true","","","",},
                            {"double","p_avenc_mes_corrente","22","out","text","P_avenc_mes_corrente","","##,##0.00","true","","","",},
                            {"double","p_vlr_pag_mes_corrente","22","out","text","P_vlr_pag_mes_corrente","","##,##0.00","true","","","",},
                            {"double","p_pag_mes_corrente","22","out","text","P_pag_mes_corrente","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes1","10","out","text","P_mes1","","","","","","",},
                            {"double","p_vlr_avenc_m1","22","out","text","P_vlr_avenc_m1","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m1","22","out","text","P_vlr_ped_bloq_m1","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m1","22","out","text","P_vlr_ped_abe_m1","","##,##0.00","true","","","",},
                            {"double","p_avenc_m1","22","out","text","P_avenc_m1","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes2","10","out","text","P_mes2","","","","","","",},
                            {"double","p_vlr_avenc_m2","22","out","text","P_vlr_avenc_m2","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m2","22","out","text","P_vlr_ped_bloq_m2","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m2","22","out","text","P_vlr_ped_abe_m2","","##,##0.00","true","","","",},
                            {"double","p_avenc_m2","22","out","text","P_avenc_m2","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes3","10","out","text","P_mes3","","","","","","",},
                            {"double","p_vlr_avenc_m3","22","out","text","P_vlr_avenc_m3","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m3","22","out","text","P_vlr_ped_bloq_m3","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m3","22","out","text","P_vlr_ped_abe_m3","","##,##0.00","true","","","",},
                            {"double","p_avenc_m3","22","out","text","P_avenc_m3","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes4","10","out","text","P_mes4","","","","","","",},
                            {"double","p_vlr_avenc_m4","22","out","text","P_vlr_avenc_m4","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m4","22","out","text","P_vlr_ped_bloq_m4","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m4","22","out","text","P_vlr_ped_abe_m4","","##,##0.00","true","","","",},
                            {"double","p_avenc_m4","22","out","text","P_avenc_m4","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes5","10","out","text","P_mes5","","","","","","",},
                            {"double","p_vlr_avenc_m5","22","out","text","P_vlr_avenc_m5","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m5","22","out","text","P_vlr_ped_bloq_m5","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m5","22","out","text","P_vlr_ped_abe_m5","","##,##0.00","true","","","",},
                            {"double","p_avenc_m5","22","out","text","P_avenc_m5","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes6","10","out","text","P_mes6","","","","","","",},
                            {"double","p_vlr_avenc_m6","22","out","text","P_vlr_avenc_m6","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m6","22","out","text","P_vlr_ped_bloq_m6","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m6","22","out","text","P_vlr_ped_abe_m6","","##,##0.00","true","","","",},
                            {"double","p_avenc_m6","22","out","text","P_avenc_m6","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes7","10","out","text","P_mes7","","","","","","",},
                            {"double","p_vlr_avenc_m7","22","out","text","P_vlr_avenc_m7","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m7","22","out","text","P_vlr_ped_bloq_m7","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m7","22","out","text","P_vlr_ped_abe_m7","","##,##0.00","true","","","",},
                            {"double","p_avenc_m7","22","out","text","P_avenc_m7","","##,##0.00","true","","","",},
                            {"java.lang.String","p_mes8","10","out","text","P_mes8","","","","","","",},
                            {"double","p_vlr_avenc_m8","22","out","text","P_vlr_avenc_m8","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_bloq_m8","22","out","text","P_vlr_ped_bloq_m8","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_m8","22","out","text","P_vlr_ped_abe_m8","","##,##0.00","true","","","",},
                            {"double","p_avenc_m8","22","out","text","P_avenc_m8","","##,##0.00","true","","","",},
                            {"java.lang.String","p_erro","10","inout","text","P_erro","","","","","","",}
                          };
    return metadata;
  }

}
