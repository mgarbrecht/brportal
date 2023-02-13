package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_total_regional
  * @version 16/05/2014 09:02:31
  */
public class Jw_clientes_novos_antigos_total_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_regional","22","false","text","","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","","","","","","","",},
                            {"java.lang.String","status","10","false","text","","","","","","","",},
                            {"int","qtde","22","false","text","","","","","","","",},
                            {"int","pares","22","false","text","","","","","","","",},
                            {"double","valor","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_regional      ,nome_regional      ,status      ,COUNT(DISTINCT cli_cdgo) qtde      ,SUM(pares) pares      ,SUM(valor) valor  FROM (SELECT cli.cli_cdgo              ,cli.cli_nome              ,cli.status              ,rv.codigo_regional              ,rv.nome_regional              ,SUM(ite.ite_qtde) pares              ,fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor          FROM ped              ,(SELECT cli.*                      ,CASE                         WHEN (cli.cli_dtin BETWEEN TO_DATE('01/09/2009', 'dd/mm/yyyy') AND TO_DATE('30/09/2009', 'dd/mm/yyyy')) THEN                          'Novos'                         WHEN (cli.cli_data_reativacao BETWEEN TO_DATE('01/09/2009', 'dd/mm/yyyy') AND TO_DATE('30/09/2009', 'dd/mm/yyyy')) THEN                          'Reativados'                         ELSE                          'Antigos'                       END status                  FROM cli) cli              ,ite              ,rep r              ,regionais_vendas rv         WHERE ped.ped_stat <> 'C'           AND r.rep_cdgo = ped.rep_cdgo           AND NVL(ped.ped_amostra_brinde, 'X') <> 'B'           AND NVL(ped.ped_substituicao, 'N') <> 'S'           AND ped.ped_especie_pedido IN ('N', 'X', 'F', 'P')           AND cli.cli_cdgo = ped.cli_cdgo           AND ite.ped_nmro = ped.ped_nmro           AND rv.codigo_regional = r.codigo_regional         GROUP BY cli.cli_cdgo                 ,cli.cli_nome                 ,cli.status                 ,ite.ped_nmro                 ,ite.ite_seqn                 ,rv.codigo_regional                 ,rv.nome_regional) GROUP BY codigo_regional         ,nome_regional         ,status ORDER BY codigo_regional         ,nome_regional         ,status";
    return query;
  }

}
