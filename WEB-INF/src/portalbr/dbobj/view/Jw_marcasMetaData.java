package portalbr.dbobj.view;

/** DataBase Object from table .Jw_marcas
  * @version 14/08/2019 14:17:42
  */
public class Jw_marcasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_marca","5","false","text","","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select codigo_marca, descricao_marca from marcas_produtos WHERE status = 'A' order by ordenacao";
    return query;
  }

}
