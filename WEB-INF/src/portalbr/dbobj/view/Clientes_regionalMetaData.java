package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_regional
  * @version 13/02/2020 14:10:28
  */
public class Clientes_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","regional","44","false","text","regional","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.sql.Date","mes","22","false","text","mes","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","grupos_ativos","22","false","text","grupos_ativos","","","","","","",},
                            {"java.lang.Integer","grupos_atendidos","22","false","text","grupos_atendidos","","","","","","",},
                            {"java.lang.Integer","grupos_nao_atendidos","22","false","text","grupos_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","clientes_ativos","22","false","text","clientes_ativos","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos","22","false","text","clientes_atendidos","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos_recolocacao","22","false","text","clientes_atendidos_recolocacao","","","","","","",},
                            {"java.lang.Integer","clientes_nao_atendidos","22","false","text","clientes_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","cidades_ativas","22","false","text","cidades_ativas","","","","","","",},
                            {"java.lang.Integer","cidades_atendidas","22","false","text","cidades_atendidas","","","","","","",},
                            {"java.lang.Integer","cidades_nao_atendidas","22","false","text","cidades_nao_atendidas","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT LPAD(res.codigo_regional, 3, 0) || '-' || rv.nome_regional regional      ,res.codigo_regional      ,null mes      ,0 grupos_ativos      ,0 grupos_atendidos      ,0 grupos_nao_atendidos      ,clientes_ativos.cli_ati clientes_ativos      ,COUNT(DISTINCT(cli.cli_cdgo)) clientes_atendidos      ,0 clientes_atendidos_recolocacao      ,(clientes_ativos.cli_ati - COUNT(DISTINCT(cli.cli_cdgo))) clientes_nao_atendidos      ,cidades_ativas.cid_ati cidades_ativas      ,cidades_atendidas.cid_atend cidades_atendidas      ,(cidades_ativas.cid_ati - cidades_atendidas.cid_atend) cidades_nao_atendidas      ,NVL(SUM(res.pares), 0) pares      ,NVL(SUM(res.valor), 0) valor  FROM resumo_ped res      ,cli      ,regionais_vendas rv      ,(SELECT COUNT(DISTINCT(cli.cli_cdgo)) cli_ati              ,rep.codigo_regional          FROM rep              ,cliente_representante clr              ,cli         WHERE rep.codigo_regional > 0           AND rep.rep_situ = 'A'           AND clr.codigo_representante = rep.rep_cdgo           AND clr.situacao = 'A'           AND cli.cli_cdgo = clr.codigo_cliente           AND cli.cli_situ = 'A'         GROUP BY rep.codigo_regional) clientes_ativos      ,(SELECT COUNT(DISTINCT ecl.ecl_cdad || ' - ' || ecl.est_unifed) cid_ati              ,r.codigo_regional          FROM ecl              ,cliente_representante cr              ,rep r              ,representante_marca rm         WHERE ecl.ned_cdgo IN ('COB', 'UNI')           AND ecl.cli_cdgo = cr.codigo_cliente           AND cr.codigo_representante = r.rep_cdgo           AND r.rep_cdgo = rm.codigo_representante           AND ecl.cli_cdgo > 0           AND rm.marca_produto > 0           AND cr.situacao = 'A'           AND r.rep_situ = 'A'           AND rm.situacao = 'A'           AND r.codigo_regional > 0         GROUP BY r.codigo_regional) cidades_ativas      ,(SELECT COUNT(DISTINCT(ecl.ecl_cdad || ' - ' || ecl.est_unifed)) cid_atend              ,res.codigo_regional          FROM resumo_ped res              ,ecl         WHERE ecl.esc_seqn = res.esc_seqn           AND ecl.cli_cdgo = res.cli_cdgo           AND ecl.ned_cdgo IN ('COB', 'UNI')         GROUP BY res.codigo_regional) cidades_atendidas WHERE cli.cli_cdgo = res.cli_cdgo   AND rv.codigo_regional = res.codigo_regional   AND clientes_ativos.codigo_regional = res.codigo_regional   AND cidades_ativas.codigo_regional = res.codigo_regional   AND cidades_atendidas.codigo_regional = res.codigo_regional GROUP BY res.codigo_regional         ,rv.nome_regional         ,clientes_ativos.cli_ati         ,cidades_ativas.cid_ati         ,cidades_atendidas.cid_atend";
    return query;
  }

}
