package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grupos_ativos
  * @version 03/04/2013 09:27:22
  */
public class Jw_grupos_ativosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","gre_grupo","6","false","text","gre_grupo","","","","","","",},
                            {"java.lang.String","gre_descricao","30","false","text","gre_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' GRE_GRUPO, '' gre_descricao from dual";
    return query;
  }

}
