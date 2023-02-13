package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_geral_grafico
  * @version 03/04/2013 09:45:20
  */
public class Jw_clientes_ficha_geral_graficoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ano","22","false","text","ano","","","","","","",},
                            {"double","vlr","22","false","text","vlr","","##,##0.00","","","","",},
                            {"double","qtd","22","false","text","qtd","","0","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT EXTRACT(YEAR FROM ped.ped_daem) ano       ,SUM(fct_valor_pedido(ite.ped_nmro, ite.ite_seqn)) vlr       ,SUM(ite.ite_qtde) qtd   FROM ite       ,ped  WHERE ite.ped_nmro = ped.ped_nmro    AND ped.ped_stat <> 'C'    AND ped.ped_substituicao <> 'S'    AND ped.ped_amostra_brinde IS NULL    AND ((EXTRACT(YEAR FROM ped_daem) = 2011 AND EXTRACT(MONTH FROM ped_daem) BETWEEN 1 AND 12) OR (EXTRACT(YEAR FROM ped_daem) = 2010 AND EXTRACT(MONTH FROM ped_daem) BETWEEN 1 AND 12))    AND ped.cli_cdgo = 5403  GROUP BY EXTRACT(YEAR FROM ped.ped_daem)";
    return query;
  }

}
