package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipoestoque
  * @version 05/07/2010 07:08:07
  */
public class Jw_tipoestoqueMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","5","false","text","","","","","","","",},
                            {"java.lang.String","descricao","40","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo        ,descricao    FROM dom_tipo_estoque   ORDER BY descricao";
    return query;
  }

}
