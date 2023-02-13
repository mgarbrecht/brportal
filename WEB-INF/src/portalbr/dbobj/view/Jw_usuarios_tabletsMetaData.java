package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios_tablets
  * @version 01/11/2011 09:00:01
  */
public class Jw_usuarios_tabletsMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_usuario","40","false","text","codigo_usuario","","","","","","",},
                            {"java.lang.String","nome_usuario","30","false","text","nome_usuario","","","","","","",},
                            {"java.lang.String","senha_usuario","30","false","text","senha_usuario","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","email","50","false","text","email","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT t.codigo_usuario       ,t.nome_usuario       ,t.senha_usuario       ,t.codigo_regional       ,t.email   FROM webstore.wt_usuarios_tablets@sadig t";
    return query;
  }

}
