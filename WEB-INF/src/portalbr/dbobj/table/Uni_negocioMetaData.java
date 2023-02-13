package portalbr.dbobj.table;

/** DataBase Object from table TCONTAB.Uni_negocio
  * @version 03/04/2013 09:06:22
  */
public class Uni_negocioMetaData {

  public static final String SCHEMA = "TCONTAB";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"UNN_CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "UNI_NEGOCIO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","unn_codigo","3","true","text","Unn_codigo","","","","","","",},
                            {"java.lang.String","unn_descri","50","true","text","Unn_descri","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","Situacao","","","","","","",}
                          };
    return metadata;
  }

}
