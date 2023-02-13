package portalbr.dbobj.view;

/** DataBase Object from table .Jw_despachante
  * @version 22/08/2017 11:14:06
  */
public class Jw_despachanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_pessoa","22","false","text","codigo_pessoa","","","","","","",},
                            {"java.lang.String","nome_pessoa","400","false","text","nome_pessoa","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_pessoa      , nome_pessoa   FROM pessoas  WHERE tipo_despachante = 'S'  ORDER BY codigo_pessoa";
    return query;
  }

}
