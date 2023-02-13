package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_estilos
  * @version 10/04/2019 12:56:51
  */
public class Jw_entrada_atual_pedidos_estilosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","atualizacao","16","false","text","atualizacao","","","","","","",},
                            {"java.lang.String","datam","10","false","text","datam","","","","","","",},
                            {"double","pr_pp","22","false","text","pr_pp","","","","","","",},
                            {"double","vlr_pp","22","false","text","vlr_pp","","","","","","",},
                            {"double","pr_pg","22","false","text","pr_pg","","","","","","",},
                            {"double","vlr_pg","22","false","text","vlr_pg","","","","","","",},
                            {"double","tot_pares","22","false","text","tot_pares","","","","","","",},
                            {"double","tot_vlr","22","false","text","tot_vlr","","","","","","",},
                            {"java.lang.Integer","id_tipo_estilos","22","false","text","Id_tipo_estilos","","","","","","",},
                            {"java.lang.String","descricao_estilos","400","false","text","descricao_estilos","","","","","","",},
                            {"java.lang.Integer","clientes","22","false","text","Clientes","","","","","","",},
                            {"java.lang.Integer","total_pares_ano","22","false","text","total_pares_ano","","","","","","",},
                            {"java.lang.Double","total_valor_ano","22","false","text","total_valor_ano","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos_ano","22","false","text","clientes_atendidos_ano","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao       ,TO_CHAR(data, 'DD/MM/YYYY') datam       ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp       ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp       ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg       ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg       ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares       ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr       ,0 id_tipo_estilos       ,null descricao_estilos       ,COUNT(DISTINCT ctl.cli_cdgo) clientes	   ,0 total_pares_ano	   ,0.0 total_valor_ano	   ,0 clientes_atendidos_ano   FROM tmp_mapa_automatico_resumo ctl       ,gerentes_regionais_vendas ger       ,regionais_vendas reg       ,rep rep       ,cli  WHERE empresa = '01'    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK')    AND cli.cli_cdgo = ctl.cli_cdgo    AND data = NVL((SELECT sem.data_mapa                     FROM semanas sem                    WHERE data = (SELECT sem.data_mapa                                    FROM semanas sem                                   WHERE data = TRUNC(SYSDATE)) - 1), TRUNC(SYSDATE) - 1)    AND NVL(ctl.codigo_gerente, NULL) = NVL(ger.codigo_gerente, NULL)    AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0)) > 0    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0)) > 0    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo  GROUP BY       ctl.gre_descricao          ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI')          ,TO_CHAR(data, 'DD/MM/YYYY')  ORDER BY tot_vlr DESC";
    return query;
  }

}
