package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipos_usuarios
  * @version 07/02/2014 09:30:13
  */
public class Jw_tipos_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","22","false","text","Codigo","","","","","","",},
                            {"java.lang.String","descricao","265","false","text","Descricao","","","","","","",},
                            {"int","tipo","10","false","text","Tipo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT to_char(tien_id) codigo       ,tien_tipo descricao       ,1 tipo   FROM tipos_entidade_negocio t  WHERE tien_id <> 2047 UNION SELECT '#'||e.enne_id codigo       ,e.enne_descricao || ' (INTERNO)' descricao       ,2 tipo   FROM wbrio.entidades_negocio e  WHERE e.enne_tien_id = 2047  ORDER BY tipo          ,descricao";
    return query;
  }

}
