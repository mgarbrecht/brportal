package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usu_entidades
  * @version 05/07/2010 07:05:01
  */
public class Jw_usu_entidadesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","total","22","false","text","total","","","","","","",},
                            {"java.lang.Integer","enne_id","22","false","text","enne_id","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select nvl(count(*),0)total, e.enne_id from wbrio.entidades_negocio e, wbrio.usuarios u where e.enne_id>0 and e.enne_id=u.usua_enne_id group by e.enne_id";
    return query;
  }

}
