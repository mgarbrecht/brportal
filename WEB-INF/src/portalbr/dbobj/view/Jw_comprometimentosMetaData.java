package portalbr.dbobj.view;

/** DataBase Object from table .Jw_comprometimentos
  * @version 03/04/2013 09:41:34
  */
public class Jw_comprometimentosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","5","false","text","","","","","","","",},
                            {"java.lang.String","descricao","41","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo        ,descricao    FROM dom_tipo_comprometimento   ORDER BY descricao";
    return query;
  }

}
