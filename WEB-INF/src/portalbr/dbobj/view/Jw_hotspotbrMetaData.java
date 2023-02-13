package portalbr.dbobj.view;

/** DataBase Object from table .Jw_hotspotbr
  * @version 03/03/2017 10:00:41
  */
public class Jw_hotspotbrMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data","22","false","text","data","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","senha","40","false","text","senha","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select data, senha from wbrio.hotspotbr where data = trunc(sysdate)";
    return query;
  }

}
