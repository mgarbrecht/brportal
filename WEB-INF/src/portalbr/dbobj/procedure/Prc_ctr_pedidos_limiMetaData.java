package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_pedidos_limi
  * @version 05/07/2010 07:01:15
  */
public class Prc_ctr_pedidos_limiMetaData {

  public static final String SCHEMA = "BRCONREC";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Prc_ctr_pedidos_limi";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","p_cli","22","in","text","P_cli","","##,##0.00","true","","","",},
                            {"java.lang.String","p_emp_empresa","10","in","text","P_emp_empresa","","","","","","",},
                            {"double","p_qtd_ped_abe_nlib","22","out","text","P_qtd_ped_abe_nlib","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_nlib","22","out","text","P_vlr_ped_abe_nlib","","##,##0.00","true","","","",},
                            {"double","p_qtd_ped_abe_lib","22","out","text","P_qtd_ped_abe_lib","","##,##0.00","true","","","",},
                            {"double","p_vlr_ped_abe_lib","22","out","text","P_vlr_ped_abe_lib","","##,##0.00","true","","","",},
                            {"double","p_limite","22","out","text","P_limite","","##,##0.00","true","","","",},
                            {"double","p_saldo","22","out","text","P_saldo","","##,##0.00","true","","","",},
                            {"java.lang.String","p_erro","10","inout","text","P_erro","","","","","","",}
                          };
    return metadata;
  }

}
