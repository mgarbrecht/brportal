package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Atelier_vw
  * @version 23/01/2015 11:30:07
  */
public class Atelier_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ATELIER_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","9","true","text","For_codigo","","","true","","","",},
                            {"java.lang.String","for_razsoc","40","true","text","For_razsoc","","","","","","",}
                          };
    return metadata;
  }

}
