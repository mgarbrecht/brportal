package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Menus
  * @version 05/07/2010 07:02:30
  */
public class MenusMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"MENU_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "MENUS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","menu_id","10","true","text","Menu_id","","","true","","","",},
                            {"java.lang.String","menu_nome","80","true","text","Menu_nome","","","","","","",},
                            {"java.lang.String","menu_texto","255","true","text","Menu_texto","","","","","","",},
                            {"java.lang.Integer","menu_pai_menu_id","10","false","text","Menu_pai_menu_id","","","true","","","",}
                          };
    return metadata;
  }

}
