package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_permissoes
  * @version 03/04/2013 09:32:45
  */
public class Jw_consulta_permissoesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","doin_id","22","false","text","","","","","","","",},
                            {"java.lang.String","doin_nome","80","false","text","","","","","","","",},
                            {"java.lang.String","doin_descricao","512","false","text","","","","","","","",},
                            {"int","dias_consulta_retroativa","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select di.*, at.aten_dias_consulta_retroativa dias_consulta_retroativa   from wbrio.tipos_entidade_negocio t      , wbrio.entidades_negocio e      , wbrio.usuarios u      , wbrio.acessos_tipos_entidade_negocio at      , wbrio.documentos_interfaces di  where t.tien_id = e.enne_tien_id    and e.enne_id = u.usua_enne_id    and at.aten_tien_id = t.tien_id    and at.aten_doin_id = di.doin_id    and u.usua_id = 732    and not exists (select 1                      from wbrio.acessos_entidades_negocio ae                     where ae.acen_enne_id = e.enne_id                       and ae.acen_doin_id = at.aten_doin_id)    and not exists (select 1                      from wbrio.acessos_usuarios au                     where au.acus_usua_id = u.usua_id                       and au.acus_doin_id = at.aten_doin_id) UNION select di.*, ae.acen_dias_consulta_retroativa dias_consulta_retroativa   from wbrio.entidades_negocio e      , wbrio.usuarios u      , wbrio.acessos_entidades_negocio ae      , wbrio.documentos_interfaces di  where e.enne_id = u.usua_enne_id    and ae.acen_enne_id = e.enne_id    and ae.acen_doin_id = di.doin_id    and u.usua_id = 732    and not exists (select 1                      from wbrio.acessos_usuarios au                     where au.acus_usua_id = u.usua_id                       and au.acus_doin_id = ae.acen_doin_id) UNION select di.*, au.acus_dias_consulta_retroativa dias_consulta_retroativa   from wbrio.usuarios u      , wbrio.acessos_usuarios au      , wbrio.documentos_interfaces di  where au.acus_usua_id = u.usua_id    and au.acus_doin_id = di.doin_id    and u.usua_id = 732    and au.acus_negar_acesso = 'N'";
    return query;
  }

}
