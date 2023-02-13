package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arq_compra_oc_log
  * @version 22/09/2016 08:45:01
  */
public class Interface_arq_compra_oc_logMetaData {

  public static final String SCHEMA = "EDI";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"INTERFACE_ARQ_COMPRA_ID","OCO_NUMERO","DATA_TRANSACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "INTERFACE_ARQ_COMPRA_OC_LOG";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","interface_arq_compra_id","22","true","text","Interface_arq_compra_id","","","true","","","",},
                            {"java.lang.Integer","oco_numero","22","true","text","Oco_numero","","","true","","","",},
                            {"java.lang.String","situacao","100","false","text","Situacao","","","","","","",},
                            {"java.sql.Timestamp","data_transacao","19","true","text","Data_transacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario","100","false","text","Usuario","","","","","","",}
                          };
    return metadata;
  }

}
