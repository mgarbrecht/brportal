package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entidades_negocio
  * @version 03/04/2013 09:30:48
  */
public class Jw_entidades_negocioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","enne_id","10","false","text","enne_id","","","","","","",},
                            {"java.lang.String","enne_descricao","255","false","text","enne_descricao","","","","","","",},
                            {"java.lang.String","enne_chave","255","false","text","enne_chave","","","","","","",},
                            {"java.lang.Integer","enne_tien_id","10","false","text","enne_tien_id","","","","","","",},
                            {"java.lang.Integer","tien_dias_consulta_retroativa","10","false","text","tien_dias_consulta_retroativa","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select en.*, tien.tien_dias_consulta_retroativa   from wbrio.entidades_negocio en      , wbrio.tipos_entidade_negocio tien  where tien.tien_id = en.enne_tien_id";
    return query;
  }

}
