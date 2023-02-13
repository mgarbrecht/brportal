package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fluxo_representante
  * @version 25/03/2020 16:16:23
  */
public class Jw_fluxo_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","120","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","rep_cdgo","20","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","120","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Integer","quantidade_meses","22","false","text","quantidade_meses","","","","","","",},
                            {"java.lang.String","descricao_quantidade_meses","60","false","text","descricao_quantidade_meses","","","","","","",},
                            {"java.lang.Integer","clientes","22","false","text","clientes","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */        codigo_regional       ,pck_regionais_vendas.get_nome(codigo_regional) nome_regional       ,rep_cdgo       ,rep_rzao       ,quantidade_meses       ,COUNT(DISTINCT cli_Cdgo) clientes   FROM (SELECT cli_cdgo               ,codigo_regional               ,rep_cdgo               ,rep_rzao               ,COUNT(DISTINCT mes_ano) quantidade_meses           FROM (SELECT cli.cli_cdgo                       ,res.codigo_regional                       ,rep.rep_cdgo                       ,rep.rep_rzao                       ,to_char(data_dig, 'mm/yyyy') mes_ano                   FROM resumo_ped            res                       ,cli                       ,rep                       ,cliente_representante clr                       ,representante_marca   rm                  WHERE res.data_dig >= to_date('01/01/2020', 'dd/MM/yyyy')                    AND res.data_dig < to_date('30/03/2020', 'dd/MM/yyyy') + 1                    AND cli.cli_cdgo = res.cli_cdgo                    AND rep.rep_cdgo = res.rep_cdgo                    AND res.esc_seqn = clr.codigo_sequencial                    AND rm.marca_produto = res.codigo_marca                    AND clr.codigo_representante = rep.rep_cdgo                    AND cli.cli_cdgo = clr.codigo_cliente                    AND rm.codigo_representante = rep.rep_cdgo                    AND res.codigo_regional = NVL(NULL, res.codigo_regional)                    AND cli.cli_situ = NVL('A', cli.cli_situ)                    AND cli.seg_cdgo NOT IN (9, 153)                    AND rep.rep_situ = NVL('A', rep.rep_situ)                    AND clr.situacao = NVL('A', clr.situacao)                    AND rm.situacao = NVL('A', rm.situacao)                 UNION ALL                 SELECT cli.cli_cdgo                       ,res.codigo_regional                       ,rep.rep_cdgo                       ,rep.rep_rzao                       ,to_char(data_dig, 'mm/yyyy') mes_ano                   FROM resumo_pedidos        res                       ,cli                       ,rep                       ,cliente_representante clr                       ,representante_marca   rm                  WHERE res.data_dig >= to_date('01/10/2019', 'dd/MM/yyyy')                    AND res.data_dig < to_date('30/03/2020', 'dd/MM/yyyy') + 1                    AND cli.cli_cdgo = res.cli_cdgo                    AND rep.rep_cdgo = res.rep_cdgo                    AND res.esc_seqn = clr.codigo_sequencial                    AND rm.marca_produto = res.codigo_marca                    AND clr.codigo_representante = rep.rep_cdgo                    AND cli.cli_cdgo = clr.codigo_cliente                    AND rm.codigo_representante = rep.rep_cdgo                    AND res.codigo_regional = NVL(NULL, res.codigo_regional)                    AND cli.cli_situ = NVL('A', cli.cli_situ)                    AND cli.seg_cdgo NOT IN (9, 153)                    AND rep.rep_situ = NVL('A', rep.rep_situ)                    AND clr.situacao = NVL('A', clr.situacao)                    AND rm.situacao = NVL('A', rm.situacao))          GROUP BY cli_cdgo                  ,codigo_regional                  ,rep_cdgo                  ,rep_rzao)  GROUP BY quantidade_meses          ,codigo_regional          ,rep_cdgo          ,rep_rzao  ORDER BY codigo_regional          ,rep_cdgo          ,quantidade_meses";
    return query;
  }

}
