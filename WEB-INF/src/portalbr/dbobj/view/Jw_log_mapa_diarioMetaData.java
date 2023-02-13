package portalbr.dbobj.view;

/** DataBase Object from table .Jw_log_mapa_diario
  * @version 18/11/2014 12:51:01
  */
public class Jw_log_mapa_diarioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ocorrencia","200","false","text","ocorrencia","","","","","","",},
                            {"java.lang.String","data_ocorrencia","20","false","text","data_ocorrencia","","","","","","",},
                            {"java.lang.Integer","sequencia","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ocorrencia,data data_ocorrencia,sequencia FROM brger.tmp_mapa_diario_log ORDER BY DATA,sequencia";
    return query;
  }

}
