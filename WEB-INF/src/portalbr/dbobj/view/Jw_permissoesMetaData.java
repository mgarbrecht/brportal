package portalbr.dbobj.view;

/** DataBase Object from table .Jw_permissoes
  * @version 03/04/2013 09:18:44
  */
public class Jw_permissoesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","acdi_doin_id","22","false","text","acdi_doin_id","","","","","","",},
                            {"java.lang.String","usua_usuario","30","false","text","usua_usuario","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select i.acdi_doin_id,  u.usua_usuario  from wbrio.acessos_documentos_interfaces i,  wbrio.usuarios u  where i.acdi_usua_id=u.usua_id";
    return query;
  }

}
