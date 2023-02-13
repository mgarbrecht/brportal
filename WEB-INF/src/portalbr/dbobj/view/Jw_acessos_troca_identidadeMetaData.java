package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_troca_identidade
  * @version 12/12/2017 12:47:10
  */
public class Jw_acessos_troca_identidadeMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","atid_usua_id","23","false","text","atid_usua_id","","","","","","",},
                            {"java.lang.String","usua_usuario","240","false","text","usua_usuario","","","","","","",},
                            {"java.lang.String","usua_nome","240","false","text","usua_nome","","","","","","",},
                            {"int","atid_tien_id","11","false","text","atid_tien_id","","","","","","",},
                            {"java.lang.String","tien_tipo","240","false","text","tien_tipo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT atid_usua_id       ,usua.usua_usuario       ,usua.usua_nome       ,atid_tien_id       ,tien.tien_tipo   FROM wbrio.acessos_troca_identidade atid       ,wbrio.usuarios                 usua       ,wbrio.tipos_entidade_negocio   tien  WHERE atid.atid_usua_id = usua.usua_id    AND atid.atid_tien_id = tien.tien_id  ORDER BY atid_usua_id          ,atid_tien_id";
    return query;
  }

}
