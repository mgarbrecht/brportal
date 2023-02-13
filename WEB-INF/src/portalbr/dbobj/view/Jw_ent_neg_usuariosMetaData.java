package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ent_neg_usuarios
  * @version 03/04/2013 09:31:00
  */
public class Jw_ent_neg_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","enne_id","22","false","text","enne_id","","","","","","",},
                            {"java.lang.String","enne_descricao","255","false","text","enne_descricao","","","","","","",},
                            {"java.lang.String","enne_chave","255","false","text","enne_chave","","","","","","",},
                            {"java.lang.Integer","enne_tien_id","22","false","text","enne_tien_id","","","","","","",},
                            {"java.lang.String","usuarios","22","false","text","usuarios","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select e.*, t.usuarios from wbrio.entidades_negocio e,(select count(1)usuarios, u.usua_enne_id teste from wbrio.usuarios u group by usua_enne_id)t where t.teste(+)=e.enne_id";
    return query;
  }

}
