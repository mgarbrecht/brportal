package portalbr.dbobj.view;

/** DataBase Object from table .Jw_log_acessos_usuarios
  * @version 03/04/2013 09:24:58
  */
public class Jw_log_acessos_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","TIEN_ID","22","false","text","","","","","","","",},
                            {"java.lang.String","TIEN_TIPO","40","false","text","","","","","","","",},
                            {"int","ENNE_ID","22","false","text","","","","","","","",},
                            {"java.lang.String","ENNE_DESCRICAO","255","false","text","","","","","","","",},
                            {"int","USUA_ID","22","false","text","","","","","","","",},
                            {"java.lang.String","USUA_USUARIO","30","false","text","","","","","","","",},
                            {"java.lang.String","USUA_NOME","40","false","text","","","","","","","",},
                            {"java.lang.String","SITUACAO","7","false","text","","","","","","","",},
                            {"java.sql.Timestamp","DATA_ACESSO","12","false","text","","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","IP","100","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select te.tien_id,        te.tien_tipo,        en.enne_id,        en.enne_descricao,        l.usua_id,        u.usua_usuario,        u.usua_nome,        decode(u.situacao,'A','Ativo','I','Inativo','') situacao,        l.data_acesso,        l.ip   from log_acessos_usuarios   l,        usuarios               u,        entidades_negocio      en,        tipos_entidade_negocio te  where l.usua_id = u.usua_id    and u.usua_enne_id = en.enne_id(+)    and te.tien_id(+) = en.enne_tien_id";
    return query;
  }

}
