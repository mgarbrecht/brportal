package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consumo_composicao_material
  * @version 14/08/2017 09:28:26
  */
public class Jw_consumo_composicao_materialMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","mat_nro","22","false","text","mat_nro","","","","","","",},
                            {"java.lang.String","descricao","200","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","ies_codigo","22","false","text","ies_codigo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */        cc.mat_nro      , die.descricao      , cc.ies_codigo      , cc.cor_cdgo   FROM componente_composicao cc      , dom_item_estoque      die  WHERE cc.mat_nro = die.codigo";
    return query;
  }

}
