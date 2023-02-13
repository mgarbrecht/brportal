package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_mini_fabrica
  * @version 27/05/2014 11:12:57
  */
public class Dom_mini_fabricaMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOM_MINI_FABRICA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","2","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","40","true","text","Descricao","","","","","","",}
                          };
    return metadata;
  }

}
