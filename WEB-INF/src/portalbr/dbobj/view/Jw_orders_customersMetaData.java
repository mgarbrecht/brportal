package portalbr.dbobj.view;

/** DataBase Object from table .Jw_orders_customers
  * @version 05/07/2010 07:20:16
  */
public class Jw_orders_customersMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","orders_id","5","false","text","orders_id","","","","","","",},
                            {"java.lang.String","customers_id","5","false","text","customers_id","","","","","","",},
                            {"java.lang.String","customers_name","64","false","text","customers_name","","","","","","",},
                            {"java.lang.String","cracha","6","false","text","cracha","","","","","","",},
                            {"java.lang.String","filial","4","false","text","filial","","","","","","",},
                            {"java.lang.String","orders_status","10","false","text","orders_status","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' orders_id       ,'' customers_id       ,'' customers_name       ,'' cracha       ,'' filial       ,'' orders_status   FROM dual";
    return query;
  }

}
