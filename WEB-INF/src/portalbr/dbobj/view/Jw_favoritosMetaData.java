package portalbr.dbobj.view;

/** DataBase Object from table .Jw_favoritos
  * @version 16/05/2014 09:25:18
  */
public class Jw_favoritosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","menu_nome","80","false","text","menu_nome","","","","","","",},
                            {"java.lang.String","acdi_usua_id","22","false","text","acdi_usua_id","","","","","","",},
                            {"java.lang.String","itme_id","22","false","text","itme_id","","","","","","",},
                            {"java.lang.String","itme_texto","255","false","text","itme_texto","","","","","","",},
                            {"java.lang.String","link","4000","false","text","link","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT m.menu_nome      ,adi.acdi_usua_id      ,i.itme_id      ,i.itme_texto      ,REPLACE(REPLACE(i.itme_comando, '<doc_interface>', di.doin_nome), '<app_context>', '..') link  FROM acessos_documentos_interfaces adi      ,documentos_interfaces di      ,wbrio.itens_menus i      ,wbrio.menus m WHERE adi.acdi_doin_id = di.doin_id   AND i.itme_doin_id = di.doin_id   AND adi.acdi_usua_id > 0   AND m.menu_id = i.itme_menu_id   AND adi.acdi_favorito = 'S'   AND NVL(m.menu_codigo_sistema, 'BRNET') = 'BRNET'   AND NVL(i.itme_menu_codigo_sistema, 'BRNET') = 'BRNET'";
    return query;
  }

}
