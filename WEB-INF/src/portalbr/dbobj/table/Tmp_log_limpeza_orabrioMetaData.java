package portalbr.dbobj.table;

/** DataBase Object from table UBIRATAN.Tmp_log_limpeza_orabrio
  * @version 19/02/2015 08:19:12
  */
public class Tmp_log_limpeza_orabrioMetaData {

  public static final String SCHEMA = "UBIRATAN";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TMP_LOG_LIMPEZA_ORABRIO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ocorrencia","80","false","text","Ocorrencia","","","","","","",},
                            {"java.lang.String","data","20","false","text","Data","","","","","","",},
                            {"java.lang.Integer","sequencia","3","false","text","Sequencia","","","true","","","",}
                          };
    return metadata;
  }

}
