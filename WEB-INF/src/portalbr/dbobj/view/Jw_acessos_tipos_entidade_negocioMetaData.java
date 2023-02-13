package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_tipos_entidade_negocio
  * @version 03/04/2013 09:52:22
  */
public class Jw_acessos_tipos_entidade_negocioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","aten_id","22","false","text","","","","","","","",},
                            {"java.lang.Integer","aten_tien_id","22","false","text","","","","","","","",},
                            {"java.lang.Integer","aten_doin_id","22","false","text","","","","","","","",},
                            {"java.lang.Integer","aten_dias_consulta_retroativa","22","false","text","","","","","","","",},
                            {"java.lang.String","doin_nome","80","false","text","","","","","","","",},
                            {"java.lang.String","doin_descricao","512","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select e.*,d.doin_nome,d.doin_descricao from acessos_tipos_entidade_negocio e, documentos_interfaces d where e.aten_doin_id=d.doin_id";
    return query;
  }

}
