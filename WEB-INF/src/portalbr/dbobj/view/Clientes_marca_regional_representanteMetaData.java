package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_marca_regional_representante
  * @version 15/05/2014 17:17:19
  */
public class Clientes_marca_regional_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","marca","34","false","text","","","","","","","",},
                            {"java.lang.String","codigo_marca","22","false","text","","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","","","","","","","",},
                            {"java.lang.String","regional","44","false","text","","","","","","","",},
                            {"java.lang.String","rep_cdgo","20","false","text","","","","","","","",},
                            {"java.lang.String","rep_nome","35","false","text","","","","","","","",},
                            {"java.lang.Integer","grupos_ativos","22","false","text","","","","","","","",},
                            {"java.lang.Integer","grupos_atendidos","22","false","text","","","","","","","",},
                            {"java.lang.Integer","grupos_nao_atendidos","22","false","text","","","","","","","",},
                            {"java.lang.Integer","clientes_ativos","22","false","text","","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos","22","false","text","","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos_recolocacao","22","false","text","clientes_atendidos_recolocacao","","","","","","",},
                            {"java.lang.Integer","clientes_nao_atendidos","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cidades_ativas","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cidades_atendidas","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cidades_nao_atendidas","22","false","text","","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT LPAD(res.codigo_marca, 3, 0) || '-' || mp.descricao_marca marca      ,res.codigo_marca      ,res.codigo_regional      ,LPAD(res.codigo_regional, 3, 0) || '-' || rv.nome_regional regional      ,res.rep_cdgo      ,rep.rep_nome      ,0 grupos_ativos      ,0 grupos_atendidos      ,0 grupos_nao_atendidos      ,NVL(clientes_ativos.cli_ati, 0) clientes_ativos      ,COUNT(DISTINCT(cli.cli_cdgo)) clientes_atendidos      ,0 clientes_atendidos_recolocacao      ,(NVL(clientes_ativos.cli_ati, 0) - COUNT(DISTINCT(cli.cli_cdgo))) clientes_nao_atendidos      ,NVL(cidades_ativas.cid_ati, 0) cidades_ativas      ,NVL(cidades_atendidas.cid_atend, 0) cidades_atendidas      ,(NVL(cidades_ativas.cid_ati, 0) - NVL(cidades_atendidas.cid_atend, 0)) cidades_nao_atendidas      ,NVL(SUM(res.pares), 0) pares      ,NVL(SUM(res.valor), 0) valor  FROM resumo_ped res      ,cli      ,marcas_produtos mp      ,regionais_vendas rv      ,rep      ,(SELECT COUNT(DISTINCT cli.cli_cdgo) cli_ati              ,rem.marca_produto codigo_marca              ,rep.codigo_regional codigo_regional              ,rep.rep_cdgo          FROM representante_marca rem              ,rep              ,cliente_representante clr              ,cli         WHERE rem.marca_produto > 0           AND rem.situacao = 'A'           AND rep.rep_cdgo = rem.codigo_representante           AND rep.rep_situ = 'A'           AND clr.codigo_representante = rep.rep_cdgo           AND clr.situacao = 'A'           AND cli.cli_cdgo = clr.codigo_cliente           AND cli.cli_situ = 'A'           AND rep.codigo_regional > 0           AND rem.marca_produto > 0         GROUP BY rem.marca_produto                 ,rep.codigo_regional                 ,rep.rep_cdgo) clientes_ativos      ,(SELECT COUNT(DISTINCT ecl.ecl_cdad || ' - ' || ecl.est_unifed) cid_ati              ,rm.marca_produto codigo_marca              ,r.codigo_regional codigo_regional              ,r.rep_cdgo          FROM ecl              ,cliente_representante cr              ,rep r              ,representante_marca rm         WHERE ecl.ned_cdgo IN ('COB', 'UNI')           AND ecl.cli_cdgo = cr.codigo_cliente           AND cr.codigo_representante = r.rep_cdgo           AND r.rep_cdgo = rm.codigo_representante           AND ecl.cli_cdgo > 0           AND rm.marca_produto > 0           AND cr.situacao = 'A'           AND r.rep_situ = 'A'           AND rm.situacao = 'A'           AND r.codigo_regional > 0           AND rm.marca_produto > 0         GROUP BY rm.marca_produto                 ,r.codigo_regional                 ,r.rep_cdgo) cidades_ativas      ,(SELECT COUNT(DISTINCT(ecl.ecl_cdad || ' - ' || ecl.est_unifed)) cid_atend              ,res.codigo_marca              ,res.codigo_regional              ,res.rep_cdgo          FROM resumo_ped res              ,ecl         WHERE ecl.cli_cdgo = res.cli_cdgo           AND ecl.ned_cdgo IN ('COB', 'UNI')           AND ecl.esc_seqn = res.esc_seqn           AND res.rep_cdgo > 0         GROUP BY res.codigo_marca                 ,res.codigo_regional                 ,res.rep_cdgo) cidades_atendidas WHERE rv.codigo_regional = res.codigo_regional   AND cli.cli_cdgo = res.cli_cdgo   AND mp.codigo_marca = res.codigo_marca   AND rep.rep_cdgo = res.rep_cdgo   AND clientes_ativos.codigo_marca(+) = res.codigo_marca   AND clientes_ativos.codigo_regional(+) = res.codigo_regional   AND clientes_ativos.rep_cdgo(+) = res.rep_cdgo   AND cidades_ativas.codigo_marca(+) = res.codigo_marca   AND cidades_ativas.codigo_regional(+) = res.codigo_regional   AND cidades_ativas.rep_cdgo(+) = res.rep_cdgo   AND cidades_atendidas.codigo_marca(+) = res.codigo_marca   AND cidades_atendidas.codigo_regional(+) = res.codigo_regional   AND cidades_atendidas.rep_cdgo(+) = res.rep_cdgo GROUP BY res.codigo_marca         ,res.codigo_regional         ,res.rep_cdgo         ,rep.rep_nome         ,mp.descricao_marca         ,rv.nome_regional         ,clientes_ativos.cli_ati         ,cidades_ativas.cid_ati         ,cidades_atendidas.cid_atend";
    return query;
  }

}
