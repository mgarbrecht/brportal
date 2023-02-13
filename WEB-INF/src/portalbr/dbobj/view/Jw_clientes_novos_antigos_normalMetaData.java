package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_normal
  * @version 16/05/2014 08:59:21
  */
public class Jw_clientes_novos_antigos_normalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","","","","","","","",},
                            {"java.lang.String","status","10","false","text","","","","","","","",},
                            {"int","pares","22","false","text","","","","","","","",},
                            {"double","valor","22","false","text","","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cli_cdgo      ,cli_nome      ,status      ,SUM(pares) pares      ,SUM(valor) valor  FROM (SELECT cli.cli_cdgo              ,cli.cli_nome              ,cli.status              ,SUM(ite.ite_qtde) pares              ,fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor          FROM ped              ,(SELECT cli.*                      ,CASE                         WHEN (cli.cli_dtin BETWEEN TO_DATE('01/09/2009', 'dd/mm/yyyy') AND TO_DATE('30/09/2009', 'dd/mm/yyyy')) THEN                          'Novos'                         WHEN (cli.cli_data_reativacao BETWEEN TO_DATE('01/09/2009', 'dd/mm/yyyy') AND TO_DATE('30/09/2009', 'dd/mm/yyyy')) THEN                          'Reativados'                         ELSE                          'Antigos'                       END status                  FROM cli) cli              ,ite              ,rep r              ,regionais_vendas rv         WHERE ped.ped_stat <> 'C'           AND r.rep_cdgo = ped.rep_cdgo           AND NVL(ped.ped_amostra_brinde, 'X') <> 'B'           AND NVL(ped.ped_substituicao, 'N') <> 'S'           AND ped.ped_especie_pedido IN ('N', 'X', 'F', 'P')           AND cli.cli_cdgo = ped.cli_cdgo           AND ite.ped_nmro = ped.ped_nmro           AND rv.codigo_regional = r.codigo_regional         GROUP BY cli.cli_cdgo                 ,cli.cli_nome                 ,cli.status                 ,ite.ped_nmro                 ,ite.ite_seqn) GROUP BY cli_cdgo         ,cli_nome         ,status ORDER BY status         ,cli_cdgo";
    return query;
  }

}
