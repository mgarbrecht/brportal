package portalbr.dbobj.view;

/** DataBase Object from table .Jw_orders_status
  * @version 05/07/2010 07:20:05
  */
public class Jw_orders_statusMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","orders_status_id","5","false","text","orders_status_id","","","","","","",},
                            {"java.lang.String","language_id","5","false","text","language_id","","","","","","",},
                            {"java.lang.String","orders_status_name","32","false","text","orders_status_name","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' orders_status_id, '' language_id, '' orders_status_name  FROM dual";
    return query;
  }

}
