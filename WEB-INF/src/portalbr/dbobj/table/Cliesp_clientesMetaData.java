package portalbr.dbobj.table;

/** DataBase Object from table ESP.Cliesp_clientes
  * @version 03/04/2013 10:02:27
  */
public class Cliesp_clientesMetaData {

  public static final String SCHEMA = "ESP";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CLIESP_CLIENTES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","6","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","cliente","100","false","text","Cliente","","","","","","",},
                            {"java.lang.String","tipo_cliente","1","false","text","Tipo_cliente","","","","","","",},
                            {"int","codigo_regional","3","false","text","Codigo_regional","","","true","","","",}
                          };
    return metadata;
  }

}
