package portalbr.dbobj.view;

/** DataBase Object from table .Jw_data_ultima_compra
  * @version 03/04/2013 09:31:38
  */
public class Jw_data_ultima_compraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data_ultima_compra","22","false","text","data_ultima_compra","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT MAX(p.ped_dadg)data_ultima_compra FROM ped p WHERE p.cli_cdgo=10175 AND p.esc_seqn=1 AND p.rep_cdgo='285'";
    return query;
  }

}
