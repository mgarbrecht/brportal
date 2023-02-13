package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_apaga_talao_fase
  * @version 18/06/2014 08:29:41
  */
public class Prc_apaga_talao_faseMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_APAGA_TALAO_FASE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","p_rem_nro","22","in","text","P_rem_nro","","##,##0.00","true","","","",},
                            {"double","p_tal_nro","22","in","text","P_tal_nro","","##,##0.00","true","","","",},
                            {"java.lang.String","p_set_cdgo","5","in","text","P_set_cdgo","","","","","","",},
                            {"double","p_app_seq","22","in","text","P_app_seq","","##,##0.00","true","","","",},
                            {"java.lang.String","p_app_observ1","200","in","text","P_app_observ1","","","","","","",}
                          };
    return metadata;
  }

}
