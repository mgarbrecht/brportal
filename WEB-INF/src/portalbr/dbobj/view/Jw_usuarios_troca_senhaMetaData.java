package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios_troca_senha
  * @version 03/02/2011 07:49:58
  */
public class Jw_usuarios_troca_senhaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","usua_id","22","false","text","usua_id","","","","","","",},
                            {"java.lang.String","usua_usuario","30","false","text","usua_usuario","","","","","","",},
                            {"java.lang.String","usua_nome","40","false","text","usua_nome","","","","","","",},
                            {"java.lang.String","usua_email","100","false","text","usua_email","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT u.usua_id, u.usua_usuario, u.usua_nome, u.usua_email   FROM wbrio.usuarios u  WHERE usua_email is not NULL";
    return query;
  }

}
