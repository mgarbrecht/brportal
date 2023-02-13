package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_materiais
  * @version 02/04/2015 13:10:30
  */
public class Jw_necessidade_materiaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ies_codigo","22","false","text","ies_codigo","","","","","","",},
                            {"java.lang.String","descricao","240","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","10","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","240","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","tai_codigo","10","false","text","tai_codigo","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","ped_invoice","10","false","text","ped_invoice","","","","","","",},
                            {"java.lang.Double","consumo","22","false","text","consumo","","##,##0.00","","","","",},
                            {"java.lang.String","unm_codigo","240","false","text","unm_codigo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 ies_codigo       ,'' descricao       ,0 cor_cdgo       ,'' cor_desc       ,'' tai_codigo       ,'' fil_filial       ,'' ped_invoice       ,0.0 consumo	   ,'' unm_codigo FROM dual";
    return query;
  }

}
