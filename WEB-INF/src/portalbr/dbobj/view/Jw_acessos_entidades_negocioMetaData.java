package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_entidades_negocio
  * @version 03/04/2013 09:52:32
  */
public class Jw_acessos_entidades_negocioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","acen_id","22","false","text","acen_id","","","","","","",},
                            {"java.lang.Integer","acen_enne_id","22","false","text","acen_enne_id","","","","","","",},
                            {"java.lang.Integer","acen_doin_id","22","false","text","acen_doin_id","","","","","","",},
                            {"java.lang.Integer","acen_dias_consulta_retroativa","22","false","text","acen_dias_consulta_retroativa","","","","","","",},
                            {"java.lang.String","doin_nome","80","false","text","doin_nome","","","","","","",},
                            {"java.lang.String","doin_descricao","512","false","text","doin_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select e.*,d.doin_nome,d.doin_descricao from acessos_entidades_negocio e, documentos_interfaces d where e.acen_doin_id=d.doin_id";
    return query;
  }

}
