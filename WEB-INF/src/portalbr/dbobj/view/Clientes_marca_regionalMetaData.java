package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_marca_regional
  * @version 15/05/2014 17:15:37
  */
public class Clientes_marca_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","marca","34","false","text","marca","","","","","","",},
                            {"java.lang.String","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","regional","44","false","text","regional","","","","","","",},
                            {"java.lang.Integer","clientes_ativos","22","false","text","clientes_ativos","","","","","","",},
                            {"java.lang.Integer","grupos_ativos","22","false","text","grupos_ativos","","","","","","",},
                            {"java.lang.Integer","grupos_atendidos","22","false","text","grupos_atendidos","","","","","","",},
                            {"java.lang.Integer","grupos_nao_atendidos","22","false","text","grupos_nao_atendidos","","","","","","",},
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
    String query = "SELECT LPAD(res.codigo_marca, 3, 0) || '-' || mp.descricao_marca marca      ,res.codigo_marca      ,res.codigo_regional      ,LPAD(res.codigo_regional, 3, 0) || '-' || rv.nome_regional regional      ,NVL(clientes_ativos.cli_ati, 0) clientes_ativos      ,0 grupos_ativos      ,0 grupos_atendidos      ,0 grupos_nao_atendidos      ,NVL(COUNT(DISTINCT(cli.cli_cdgo)), 0) clientes_atendidos      ,0 clientes_atendidos_recolocacao      ,(NVL(clientes_ativos.cli_ati, 0) - NVL(COUNT(DISTINCT(cli.cli_cdgo)), 0)) clientes_nao_atendidos      ,NVL(cidades_ativas.cid_ati, 0) cidades_ativas      ,NVL(cidades_atendidas.cid_atend, 0) cidades_atendidas      ,(NVL(cidades_ativas.cid_ati, 0) - NVL(cidades_atendidas.cid_atend, 0)) cidades_nao_atendidas      ,NVL(SUM(res.pares), 0) pares      ,NVL(SUM(res.valor), 0) valor  FROM resumo_ped res      ,cli      ,marcas_produtos mp      ,regionais_vendas rv      ,(SELECT COUNT(DISTINCT cli.cli_cdgo) cli_ati              ,rem.marca_produto codigo_marca              ,rep.codigo_regional codigo_regional          FROM representante_marca rem              ,rep              ,cliente_representante clr              ,cli         WHERE rem.marca_produto > 0           AND rem.situacao = 'A'           AND rep.rep_cdgo = rem.codigo_representante           AND rep.rep_situ = 'A'           AND clr.codigo_representante = rep.rep_cdgo           AND clr.situacao = 'A'           AND cli.cli_cdgo = clr.codigo_cliente           AND cli.cli_situ = 'A'           AND rep.codigo_regional > 0         GROUP BY rem.marca_produto                 ,rep.codigo_regional) clientes_ativos      ,(SELECT COUNT(DISTINCT ecl.ecl_cdad || ' - ' || ecl.est_unifed) cid_ati              ,r.codigo_regional              ,rm.marca_produto codigo_marca          FROM ecl              ,cliente_representante cr              ,rep r              ,representante_marca rm         WHERE ecl.ned_cdgo IN ('COB', 'UNI')           AND ecl.cli_cdgo = cr.codigo_cliente           AND cr.codigo_representante = r.rep_cdgo           AND r.rep_cdgo = rm.codigo_representante           AND ecl.cli_cdgo > 0           AND rm.marca_produto > 0           AND cr.situacao = 'A'           AND r.rep_situ = 'A'           AND rm.situacao = 'A'           AND r.codigo_regional > 0           AND rm.marca_produto > 0         GROUP BY r.codigo_regional                 ,rm.marca_produto) cidades_ativas      ,(SELECT res.codigo_marca              ,res.codigo_regional              ,COUNT(DISTINCT(ecl.ecl_cdad || ' - ' || ecl.est_unifed)) cid_atend          FROM resumo_ped res              ,ecl         WHERE ecl.cli_cdgo = res.cli_cdgo           AND ecl.esc_seqn = res.esc_seqn           AND ecl.ned_cdgo IN ('COB', 'UNI')         GROUP BY res.codigo_marca                 ,res.codigo_regional) cidades_atendidas WHERE rv.codigo_regional = res.codigo_regional   AND cli.cli_cdgo = res.cli_cdgo   AND mp.codigo_marca = res.codigo_marca   AND clientes_ativos.codigo_marca(+) = res.codigo_marca   AND clientes_ativos.codigo_regional(+) = res.codigo_regional   AND cidades_ativas.codigo_marca(+) = res.codigo_marca   AND cidades_ativas.codigo_regional(+) = res.codigo_regional   AND cidades_atendidas.codigo_marca(+) = res.codigo_marca   AND cidades_atendidas.codigo_regional(+) = res.codigo_regional GROUP BY res.codigo_marca         ,res.codigo_regional         ,mp.descricao_marca         ,rv.nome_regional         ,clientes_ativos.cli_ati         ,cidades_ativas.cid_ati         ,cidades_atendidas.cid_atend";
    return query;
  }

}
