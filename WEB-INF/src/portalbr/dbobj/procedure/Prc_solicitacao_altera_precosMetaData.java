package portalbr.dbobj.procedure;

/** DataBase Object from table BRIO.Prc_solicitacao_altera_precos
  * @version 05/07/2010 07:00:31
  */
public class Prc_solicitacao_altera_precosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_SOLICITACAO_ALTERA_PRECOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_nmro_solicitacao","32","in","text","P_nmro_solicitacao","","","true","","","",},
                            {"java.lang.String","p_libera","10","in","text","P_libera","","","","","","",}
                          };
    return metadata;
  }

}
