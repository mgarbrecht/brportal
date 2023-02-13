package portalbr.dbobj.view;

/** DataBase Object from table .Jw_continentes
  * @version 14/09/2018 17:14:57
  */
public class Jw_continentesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","con_codigo","10","false","text","con_codigo","","","","","","",},
                            {"java.lang.String","con_descricao","240","false","text","con_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.con_codigo      , c.con_descricao   FROM continentes c  ORDER BY con_codigo         , con_descricao";
    return query;
  }

}
