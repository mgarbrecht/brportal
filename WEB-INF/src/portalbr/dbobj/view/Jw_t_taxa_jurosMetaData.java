package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_taxa_juros
  * @version 03/04/2013 09:08:36
  */
public class Jw_t_taxa_jurosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","taxa_juros","25","false","text","taxa_juros","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select taxa_juros  from taxas_juros  WHERE rownum=1";
    return query;
  }

}
