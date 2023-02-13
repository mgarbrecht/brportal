package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consumo_composicao_cor
  * @version 17/08/2017 09:32:10
  */
public class Jw_consumo_composicao_corMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","400","false","text","cor_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT          /*+ all_rows */        cc.cor_cdgo      , c.cor_desc   FROM componente_composicao cc      , dom_item_estoque      die      , cor                   c  WHERE cc.mat_nro = die.codigo    AND c.cor_cdgo = cc.cor_cdgo    AND cc.ies_codigo = 57180  ORDER BY cor_cdgo";
    return query;
  }

}
