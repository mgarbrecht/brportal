package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_usuarios
  * @version 03/04/2013 09:52:12
  */
public class Jw_acessos_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","acus_id","22","false","text","acus_id","","","","","","",},
                            {"java.lang.Integer","acus_usua_id","22","false","text","acus_usua_id","","","","","","",},
                            {"java.lang.Integer","acus_doin_id","22","false","text","acus_doin_id","","","","","","",},
                            {"java.lang.String","acus_negar_acesso","1","false","text","acus_negar_acesso","","","","","","",},
                            {"java.lang.Integer","acus_dias_consulta_retroativa","22","false","text","acus_dias_consulta_retroativa","","","","","","",},
                            {"java.lang.String","doin_nome","80","false","text","doin_nome","","","","","","",},
                            {"java.lang.String","doin_descricao","512","false","text","doin_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select e.*,d.doin_nome,d.doin_descricao from acessos_usuarios e, documentos_interfaces d where e.acus_doin_id=d.doin_id";
    return query;
  }

}
