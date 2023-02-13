package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios_alteracao
  * @version 16/09/2015 16:38:39
  */
public class Jw_usuarios_alteracaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","usuario","240","false","text","usuario","","","","","","",},
                            {"java.lang.String","nome","240","false","text","nome","","","","","","",},
                            {"java.sql.Timestamp","data_alteracao","22","false","text","data_alteracao","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","usuario_alteracao","240","false","text","usuario_alteracao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT usua_usuario usuario ,usua_nome nome , dthr_alteracao data_alteracao, usuario_alteracao   FROM wbrio.usuarios   order by data_alteracao";
    return query;
  }

}
