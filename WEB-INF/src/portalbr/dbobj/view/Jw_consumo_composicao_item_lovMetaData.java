package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consumo_composicao_item_lov
  * @version 14/08/2017 11:20:34
  */
public class Jw_consumo_composicao_item_lovMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","200","false","text","descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */               codigo             , descricao          FROM dom_item_estoque         ORDER BY codigo";
    return query;
  }

}
