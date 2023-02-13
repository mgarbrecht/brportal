package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fluxo
  * @version 24/03/2020 15:23:58
  */
public class Jw_fluxoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","quantidade_meses","22","false","text","quantidade_meses","","","","","","",},
                            {"java.lang.String","descricao_quantidade_meses","60","false","text","descricao_quantidade_meses","","","","","","",},
                            {"java.lang.Integer","clientes","22","false","text","clientes","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */        quantidade_meses       ,quantidade_meses ||' '|| case when quantidade_meses = 1 then 'Mês' else 'Meses' end descricao_quantidade_meses       ,COUNT(DISTINCT cli_Cdgo) clientes   FROM (SELECT           cli_cdgo         ,COUNT(DISTINCT mes_ano) quantidade_meses           FROM (SELECT cli.cli_cdgo                       ,to_char(data_dig, 'mm/yyyy') mes_ano                   FROM resumo_ped            res                       ,cli                       ,rep                       ,cliente_representante clr                       ,representante_marca   rm                  WHERE res.data_dig >= to_date('01/01/2020', 'dd/MM/yyyy')                    AND res.data_dig < to_date('30/03/2020', 'dd/MM/yyyy') + 1                    AND cli.cli_cdgo = res.cli_cdgo                    AND rep.rep_cdgo = res.rep_cdgo                    AND res.esc_seqn = clr.codigo_sequencial                    AND rm.marca_produto = res.codigo_marca                    AND clr.codigo_representante = rep.rep_cdgo                    AND cli.cli_cdgo = clr.codigo_cliente                    AND rm.codigo_representante = rep.rep_cdgo                    AND res.codigo_regional = NVL(NULL, res.codigo_regional)                    AND cli.cli_situ = NVL('A', cli.cli_situ)                    AND cli.seg_cdgo NOT IN (9, 153)                    AND rep.rep_situ = NVL('A', rep.rep_situ)                    AND clr.situacao = NVL('A', clr.situacao)                    AND rm.situacao = NVL('A', rm.situacao)                 UNION ALL                 SELECT cli.cli_cdgo                       ,to_char(data_dig, 'mm/yyyy') mes_ano                   FROM resumo_pedidos        res                       ,cli                       ,rep                       ,cliente_representante clr                       ,representante_marca   rm                  WHERE res.data_dig >= to_date('01/10/2019', 'dd/MM/yyyy')                    AND res.data_dig < to_date('30/03/2020', 'dd/MM/yyyy') + 1                    AND cli.cli_cdgo = res.cli_cdgo                    AND rep.rep_cdgo = res.rep_cdgo                    AND res.esc_seqn = clr.codigo_sequencial                    AND rm.marca_produto = res.codigo_marca                    AND clr.codigo_representante = rep.rep_cdgo                    AND cli.cli_cdgo = clr.codigo_cliente                    AND rm.codigo_representante = rep.rep_cdgo                    AND res.codigo_regional = NVL(NULL, res.codigo_regional)                    AND cli.cli_situ = NVL('A', cli.cli_situ)                    AND cli.seg_cdgo NOT IN (9, 153)                    AND rep.rep_situ = NVL('A', rep.rep_situ)                    AND clr.situacao = NVL('A', clr.situacao)                    AND rm.situacao = NVL('A', rm.situacao))          GROUP BY cli_cdgo)  GROUP BY quantidade_meses  ORDER BY quantidade_meses";
    return query;
  }

}
