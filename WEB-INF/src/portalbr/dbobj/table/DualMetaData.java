package portalbr.dbobj.table;

/** DataBase Object from table SYS.Dual
  * @version 03/04/2013 09:59:24
  */
public class DualMetaData {

  public static final String SCHEMA = "SYS";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DUAL";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","dummy","1","false","text","Dummy","","","","","","",}
                          };
    return metadata;
  }

}
