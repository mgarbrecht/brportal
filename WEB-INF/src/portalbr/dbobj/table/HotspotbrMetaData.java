package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Hotspotbr
  * @version 03/03/2017 09:53:31
  */
public class HotspotbrMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "HOTSPOTBR";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data","19","false","text","Data","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","senha","40","false","text","Senha","","","","","","",}
                          };
    return metadata;
  }

}
