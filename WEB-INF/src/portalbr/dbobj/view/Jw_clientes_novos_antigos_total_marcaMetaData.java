package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_total_marca
  * @version 16/05/2014 09:01:38
  */
public class Jw_clientes_novos_antigos_total_marcaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_marca","22","false","text","","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","","","","","","","",},
                            {"java.lang.String","status","10","false","text","","","","","","","",},
                            {"int","qtde","22","false","text","","","","","","","",},
                            {"int","pares","22","false","text","","","","","","","",},
                            {"double","valor","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_marca      ,descricao_marca      ,status      ,COUNT(DISTINCT cli_cdgo) qtde      ,SUM(pares) pares      ,SUM(valor) valor  FROM (SELECT cli.cli_cdgo              ,cli.cli_nome              ,cli.status              ,fct_marca_produto(ite.lin_cdgo, ite.ref_cdgo) codigo_marca              ,mp.descricao_marca              ,SUM(ite.ite_qtde) pares              ,fct_valor_pedido(ite.ped_nmro, ite.ite_seqn) valor          FROM ped              ,(SELECT cli.*                      ,CASE                         WHEN (cli.cli_dtin BETWEEN TO_DATE('01/09/2009', 'dd/mm/yyyy') AND TO_DATE('30/09/2009', 'dd/mm/yyyy')) THEN                          'Novos'                         WHEN (cli.cli_data_reativacao BETWEEN TO_DATE('01/09/2009', 'dd/mm/yyyy') AND TO_DATE('30/09/2009', 'dd/mm/yyyy')) THEN                          'Reativados'                         ELSE                          'Antigos'                       END status                  FROM cli) cli              ,ite              ,rep r              ,regionais_vendas rv              ,marcas_produtos mp         WHERE ped.ped_stat <> 'C'           AND r.rep_cdgo = ped.rep_cdgo           AND NVL(ped.ped_amostra_brinde, 'X') <> 'B'           AND NVL(ped.ped_substituicao, 'N') <> 'S'           AND ped.ped_especie_pedido IN ('N', 'X', 'F', 'P')           AND NVL(ped.rep_cdgo, NULL) = NVL(NULL, ped.rep_cdgo)           AND cli.cli_cdgo = ped.cli_cdgo           AND ite.ped_nmro = ped.ped_nmro           AND rv.codigo_regional = r.codigo_regional           AND mp.codigo_marca = fct_marca_produto(ite.lin_cdgo, ite.ref_cdgo)         GROUP BY cli.cli_cdgo                 ,cli.cli_nome                 ,cli.status                 ,ite.ped_nmro                 ,ite.ite_seqn                 ,fct_marca_produto(ite.lin_cdgo, ite.ref_cdgo)                 ,mp.descricao_marca) GROUP BY codigo_marca         ,descricao_marca         ,status ORDER BY codigo_marca         ,descricao_marca         ,status";
    return query;
  }

}
