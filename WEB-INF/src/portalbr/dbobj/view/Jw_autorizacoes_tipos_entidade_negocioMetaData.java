package portalbr.dbobj.view;

/** DataBase Object from table .Jw_autorizacoes_tipos_entidade_negocio
  * @version 03/04/2013 09:50:31
  */
public class Jw_autorizacoes_tipos_entidade_negocioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","tien_id","22","false","text","tien_id","","","","","","",},
                            {"java.lang.String","tien_tipo","40","false","text","tien_tipo","","","","","","",},
                            {"int","doin_id","22","false","text","doin_id","","","","","","",},
                            {"java.lang.String","doin_nome","80","false","text","doin_nome","","","","","","",},
                            {"java.lang.String","doin_descricao","512","false","text","doin_descricao","","","","","","",},
                            {"int","aten_dias_consulta_retroativa","22","false","text","aten_dias_consulta_retroativa","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select t.tien_id, t.tien_tipo,d.doin_id, d.doin_nome, d.doin_descricao, e.aten_dias_consulta_retroativa  from wbrio.acessos_tipos_entidade_negocio e, wbrio.documentos_interfaces d, wbrio.tipos_entidade_negocio t  where e.aten_doin_id=d.doin_id  and t.tien_id=e.aten_tien_id  order by 4";
    return query;
  }

}
