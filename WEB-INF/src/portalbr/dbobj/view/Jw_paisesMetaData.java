package portalbr.dbobj.view;

/** DataBase Object from table .Jw_paises
  * @version 16/10/2015 12:18:01
  */
public class Jw_paisesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","descricao","50","false","text","descricao","","","","","","",},
                            {"java.lang.String","sigla","4","false","text","sigla","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT p.descricao       ,p.sigla   FROM paises p  ORDER BY descricao";
    return query;
  }

}
