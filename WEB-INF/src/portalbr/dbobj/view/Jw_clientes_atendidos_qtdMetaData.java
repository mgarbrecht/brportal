package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atendidos_qtd
  * @version 16/05/2014 08:43:10
  */
public class Jw_clientes_atendidos_qtdMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","atendidos_qtd","22","false","text","atendidos_qtd","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT COUNT(DISTINCT cli_cdgo) atendidos_qtd  FROM (SELECT cli.cli_cdgo              ,cli.cli_nome              ,cli.cli_rzao              ,cli.cli_dult              ,NVL(SUM(res.pares), 0) pares              ,NVL(SUM(res.valor), 0) valor          FROM resumo_ped res              ,cli              ,rep              ,cliente_representante clr              ,representante_marca rm         WHERE cli.cli_cdgo = res.cli_cdgo           AND rep.rep_cdgo = res.rep_cdgo           AND res.esc_seqn = clr.codigo_sequencial           AND rm.marca_produto = res.codigo_marca           AND clr.codigo_representante = rep.rep_cdgo           AND cli.cli_cdgo = clr.codigo_cliente           AND rm.codigo_representante = rep.rep_cdgo         GROUP BY cli.cli_cdgo                 ,cli.cli_nome                 ,cli.cli_rzao                 ,cli_dult        UNION        SELECT cli.cli_cdgo              ,cli.cli_nome              ,cli.cli_rzao              ,cli.cli_dult              ,NVL(SUM(res.pares), 0) pares              ,NVL(SUM(res.valor), 0) valor          FROM resumo_pedidos res              ,cli              ,rep              ,cliente_representante clr              ,representante_marca rm         WHERE cli.cli_cdgo = res.cli_cdgo           AND rep.rep_cdgo = res.rep_cdgo           AND res.esc_seqn = clr.codigo_sequencial           AND rm.marca_produto = res.codigo_marca           AND clr.codigo_representante = rep.rep_cdgo           AND cli.cli_cdgo = clr.codigo_cliente           AND rm.codigo_representante = rep.rep_cdgo         GROUP BY cli.cli_cdgo                 ,cli.cli_nome                 ,cli.cli_rzao                 ,cli_dult)";
    return query;
  }

}
