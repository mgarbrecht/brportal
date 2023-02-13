package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cf_dias_uteis
  * @version 03/04/2013 09:49:57
  */
public class Jw_cf_dias_uteisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","dias","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 dias FROM dual";
    return query;
  }

}
