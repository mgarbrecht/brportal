package portalbr.dbobj.view;

/** DataBase Object from table .Jw_localestoque
  * @version 03/04/2013 09:25:08
  */
public class Jw_localestoqueMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fil_filial","4","false","text","","","","","","","",},
                            {"int","codigo","5","false","text","","","","","","","",},
                            {"java.lang.String","descricao","40","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT fil_filial                 ,codigo                 ,descricao    FROM dom_local_estoque   ORDER BY descricao";
    return query;
  }

}
