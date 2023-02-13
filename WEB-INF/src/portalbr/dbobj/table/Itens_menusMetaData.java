package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Itens_menus
  * @version 03/04/2013 09:55:11
  */
public class Itens_menusMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ITME_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Itens_menus";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","itme_id","10","true","text","itme_id","","","true","","","",},
                            {"java.lang.String","itme_nome","80","true","text","Nome","","","","","","",},
                            {"java.lang.String","itme_texto","255","true","text","Texto","","","","","","",},
                            {"java.lang.String","itme_comando","255","true","text","itme_comando","","","","","","",},
                            {"java.lang.Integer","itme_menu_id","10","true","text","itme_menu_id","","","true","","","",},
                            {"java.lang.Integer","itme_doin_id","10","false","text","itme_doin_id","","","true","","","",}
                          };
    return metadata;
  }

}
