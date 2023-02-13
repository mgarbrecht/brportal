package portalbr.dbobj.view;

/** DataBase Object from table .Jw_desp_pro
  * @version 03/04/2013 09:31:28
  */
public class Jw_desp_proMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","mov_valor","24","false","text","mov_valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 mov_valor FROM dual";
    return query;
  }

}
