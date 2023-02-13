package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_maiores_cli_limite_credito
  * @version 17/11/2011 08:34:49
  */
public class Prc_maiores_cli_limite_creditoMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_MAIORES_CLI_LIMITE_CREDITO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_cli_cdgo","22","in","text","P_cli_cdgo","","","true","","","",},
                            {"java.lang.String","p_gre_grupo","22","in","text","P_gre_grupo","","","true","","","",},
                            {"java.lang.String","p_tipo_mercado","10","in","text","P_tipo_mercado","","","","","","",},
                            {"int","p_meses","22","in","text","P_meses","","","true","","","",},
                            {"double","p_vlr_ped_abe_lib","22","out","text","P_vlr_ped_abe_lib","","##,##0.00","true","","","",},
                            {"double","p_limite","22","out","text","P_limite","","##,##0.00","true","","","",},
                            {"double","p_saldo","22","out","text","P_saldo","","##,##0.00","true","","","",},
                            {"double","p_qtd_vencer","22","out","text","P_qtd_vencer","","##,##0.00","true","","","",},
                            {"double","p_vlr_vencer","22","out","text","P_vlr_vencer","","##,##0.00","true","","","",},
                            {"double","p_qtd_vencido","22","out","text","P_qtd_vencido","","##,##0.00","true","","","",},
                            {"double","p_vlr_vencido","22","out","text","P_vlr_vencido","","##,##0.00","true","","","",},
                            {"double","p_percentual_pontualidade","22","out","text","P_percentual_pontualidade","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_nlib","22","out","text","P_vlr_ped_abe_nlib","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
