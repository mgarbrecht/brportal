package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Parametros
  * @version 01/08/2014 12:32:08
  */
public class ParametrosMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NOME"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PARAMETROS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nome","400","true","text","Nome","","","","","","",},
                            {"java.lang.String","valor","4000","true","text","Valor","","","","","","",},
                            {"java.lang.String","par_sist_codigo","4000","true","text","Par_sist_codigo","","","","","","",},
                            {"java.lang.String","email","100","false","text","Email","","","","","","",}
                          };
    return metadata;
  }

}
