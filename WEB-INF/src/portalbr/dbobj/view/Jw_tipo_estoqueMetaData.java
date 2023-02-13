package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_estoque
  * @version 19/09/2014 12:01:39
  */
public class Jw_tipo_estoqueMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","4","false","text","","","","","","","",},
                            {"java.lang.String","descricao","40","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo        ,descricao    FROM dom_tipo_estoque   ORDER BY codigo";
    return query;
  }

}
