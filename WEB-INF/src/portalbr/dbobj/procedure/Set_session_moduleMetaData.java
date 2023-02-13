package portalbr.dbobj.procedure;

/** DataBase Object from table LOJA.Set_session_module
  * @version 15/07/2010 13:38:51
  */
public class Set_session_moduleMetaData {

  public static final String SCHEMA = "LOJA";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "SET_SESSION_MODULE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","modulo","100","in","text","Modulo","","","","","","",},
                            {"java.lang.String","action","200","in","text","Action","","","","","","",}
                          };
    return metadata;
  }

}
