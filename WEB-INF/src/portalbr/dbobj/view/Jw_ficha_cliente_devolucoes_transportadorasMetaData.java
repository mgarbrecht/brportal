package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_devolucoes_transportadoras
  * @version 03/04/2013 09:29:59
  */
public class Jw_ficha_cliente_devolucoes_transportadorasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","gre_grupo","22","false","text","gre_grupo","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"int","pares","22","false","text","pares","","","","","","",},
                            {"double","valor","22","false","text","valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT gre_grupo       ,cli_cdgo       ,esc_seqn       ,SUM(pares) pares       ,SUM(valor) valor   FROM fc_devol_em_transportadora  GROUP BY gre_grupo          ,cli_cdgo          ,esc_seqn";
    return query;
  }

}
