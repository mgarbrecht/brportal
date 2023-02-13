package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios
  * @version 02/03/2015 13:01:58
  */
public class Jw_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","usua_id","22","false","text","","","","","","","",},
                            {"java.lang.String","usua_usuario","30","false","text","","","","","","","",},
                            {"java.lang.String","usua_nome","40","false","text","","","","","","","",},
                            {"java.lang.String","usua_email","100","false","text","","","","","","","",},
                            {"java.lang.Integer","usua_enne_id","22","false","text","","","","","","","",},
                            {"java.lang.String","usua_super","1","false","text","","","","","","","",},
                            {"java.lang.String","enne_descricao","255","false","text","","","","","","","",},
                            {"java.lang.Integer","tien_id","22","false","text","","","","","","","",},
                            {"java.lang.String","tien_tipo","40","false","text","","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","","","","","","","",},
                            {"java.lang.Integer","dias_consulta_retroativa","22","false","text","","","","","","","",},
                            {"java.lang.String","usua_expira_senha","1","false","text","","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","22","false","text","dthr_inclusao","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","22","false","text","dthr_alteracao","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","usuario_inclusao","100","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","100","false","text","Usuario_alteracao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT u.usua_id      ,u.usua_usuario      ,u.usua_nome      ,u.usua_email      ,u.usua_enne_id      ,u.usua_super      ,e.enne_descricao      ,t.tien_id      ,t.tien_tipo      ,u.situacao      ,u.dias_consulta_retroativa      ,u.usua_expira_senha      ,u.dthr_inclusao      ,u.dthr_alteracao      ,u.usuario_inclusao      ,u.usuario_alteracao	    FROM wbrio.usuarios u      ,wbrio.tipos_entidade_negocio t      ,wbrio.entidades_negocio e WHERE u.usua_enne_id = e.enne_id(+)   AND e.enne_tien_id = t.tien_id(+)";
    return query;
  }

}
