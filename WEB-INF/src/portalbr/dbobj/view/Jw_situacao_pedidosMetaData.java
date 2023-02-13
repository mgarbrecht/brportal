package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacao_pedidos
  * @version 05/07/2016 13:02:04
  */
public class Jw_situacao_pedidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","240","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","240","false","text","descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.rv_abbreviation codigo ,UPPER(c.rv_meaning) descricao FROM cg_ref_codes c WHERE c.rv_domain LIKE '%ITE_SITU%'";
    return query;
  }

}
