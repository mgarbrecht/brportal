package portalbr.dbobj.view;

/** DataBase Object from table .Jw_analise_credito_gerencial
  * @version 10/09/2021 11:19:27
  */
public class Jw_analise_credito_gerencialMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","mes_ano","32","false","text","mes_ano","","","","","","",},
                            {"java.lang.Double","vlr_faturado","22","false","text","vlr_faturado","","","","","","",},
                            {"java.lang.Double","vlr_liquidado","22","false","text","vlr_liquidado","","","","","","",},
                            {"java.lang.Double","vlr_pror_a","22","false","text","vlr_pror_a","","","","","","",},
                            {"java.lang.Double","vlr_pror_l","22","false","text","vlr_pror_l","","","","","","",},
                            {"java.lang.Double","total_vlr_faturado","22","false","text","total_vlr_faturado","","","","","","",},
                            {"java.lang.Double","total_vlr_liquidado","22","false","text","total_vlr_liquidado","","","","","","",},
                            {"java.lang.Double","total_vlr_pror_a","22","false","text","total_vlr_pror_a","","","","","","",},
                            {"java.lang.Double","total_vlr_pror_l","22","false","text","total_vlr_pror_l","","","","","","",},
                            {"java.lang.String","pag_mercado","240","false","text","pag_mercado","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' mes_ano       ,0.0 vlr_faturado       ,0.0 vlr_liquidado       ,0.0 vlr_pror_a       ,0.0 vlr_pror_l       ,0.0 total_vlr_faturado       ,0.0 total_vlr_liquidado       ,0.0 total_vlr_pror_a       ,0.0 total_vlr_pror_l	       ,'' pag_mercado	          from dual";
    return query;
  }

}
