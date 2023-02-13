package portalbr.dbobj.table;

/** DataBase Object from table CTB.Fornecedores
  * @version 03/04/2013 09:56:01
  */
public class FornecedoresMetaData {

  public static final String SCHEMA = "CTB";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Fornecedores";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","9","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","nome","40","true","text","Nome","","","","","","",}
                          };
    return metadata;
  }

}
