package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_permissoes_documentos_interfaces
  * @version 15/08/2016 12:13:45
  */
public class Jw_consulta_permissoes_documentos_interfacesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","doin_id","22","false","text","doin_id","","","","","","",},
                            {"java.lang.String","doin_nome","100","false","text","doin_nome","","","","","","",},
                            {"java.lang.String","quebra","20","false","text","quebra","","","","","","",},
                            {"java.lang.String","descricao","255","false","text","descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT doin_id, doin_nome, quebra, descricao   FROM (SELECT di.doin_id               ,di.doin_nome               ,'TIPO ENTIDADE' quebra               ,t.tien_tipo descricao           FROM wbrio.acessos_tipos_entidade_negocio aten               ,wbrio.tipos_entidade_negocio t               ,wbrio.documentos_interfaces di          WHERE aten.aten_tien_id = t.tien_id            AND aten.aten_doin_id = di.doin_id         UNION         SELECT di.doin_id               ,di.doin_nome               ,'ENTIDADE NEGOCIO' quebra               ,e.enne_descricao descricao           FROM wbrio.acessos_entidades_negocio acen               ,wbrio.entidades_negocio e               ,wbrio.documentos_interfaces di          WHERE acen.acen_enne_id = e.enne_id            AND acen.acen_doin_id = di.doin_id         UNION         SELECT di.doin_id               ,di.doin_nome               ,'USUARIO' quebra               ,u.usua_usuario descricao           FROM wbrio.acessos_usuarios acus               ,wbrio.usuarios u               ,wbrio.documentos_interfaces di          WHERE acus.acus_usua_id = u.usua_id            AND acus.acus_doin_id = di.doin_id            AND acus.acus_negar_acesso = 'N') m       ,wbrio.itens_menus i  WHERE i.itme_doin_id = doin_id  ORDER BY doin_nome          ,quebra";
    return query;
  }

}
