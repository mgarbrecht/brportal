package portalbr.dbobj.procedure;

/** DataBase Object from table BRIO.Prc_troca_status_acao_mkt
  * @version 05/07/2010 07:00:22
  */
public class Prc_troca_status_acao_mktMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_TROCA_STATUS_ACAO_MKT";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","p_acao_mkt","22","in","text","P_acao_mkt","","","true","","","",},
                            {"java.lang.String","p_status","10","in","text","P_status","","","","","","",}
                          };
    return metadata;
  }

}
