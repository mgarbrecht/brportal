package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Documentos_interfaces
  * @version 03/04/2013 10:00:17
  */
public class Documentos_interfacesMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"DOIN_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOCUMENTOS_INTERFACES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","doin_id","10","true","text","Doin_id","","","true","","","",},
                            {"java.lang.String","doin_nome","80","true","text","Doin_nome","","","","","","",},
                            {"java.lang.String","doin_descricao","512","false","text","Doin_descricao","","","","","","",}
                          };
    return metadata;
  }

}
