package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_resumo_marcas
  * @version 19/09/2022 10:42:47
  */
public class Jw_entrada_atual_pedidos_resumo_marcasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","atualizacao","20","false","text","atualizacao","","","","","","",},
                            {"java.lang.String","datam","20","false","text","datam","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","100","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","mes","20","false","text","mes","","","","","","",},
                            {"java.lang.Integer","pr_mes","22","false","text","pr_mes","","","","","","",},
                            {"java.lang.Double","vlr_mes","22","false","text","vlr_mes","","","","","","",},
                            {"java.lang.String","mes1","20","false","text","mes1","","","","","","",},
                            {"java.lang.Integer","pr_mes1","22","false","text","pr_mes1","","","","","","",},
                            {"java.lang.Double","vlr_mes1","22","false","text","vlr_mes1","","","","","","",},
                            {"java.lang.String","mes2","20","false","text","mes2","","","","","","",},
                            {"java.lang.Integer","pr_mes2","22","false","text","pr_mes2","","","","","","",},
                            {"java.lang.Double","vlr_mes2","22","false","text","vlr_mes2","","","","","","",},
                            {"java.lang.String","mesn","20","false","text","mesn","","","","","","",},
                            {"java.lang.Integer","pr_mesn","22","false","text","pr_mesn","","","","","","",},
                            {"java.lang.Double","vlr_mesn","22","false","text","vlr_mesn","","","","","","",},
                            {"java.lang.Integer","total_pares","22","false","text","total_pares","","","","","","",},
                            {"java.lang.Double","total_valor","22","false","text","total_valor","","","","","","",},
                            {"java.lang.Integer","clientes","22","false","text","clientes","","","","","","",},
                            {"java.lang.Integer","total_pares_ano","22","false","text","total_pares_ano","","","","","","",},
                            {"java.lang.Double","total_valor_ano","22","false","text","total_valor_ano","","##,##0.00","","","","",},
                            {"java.lang.Integer","clientes_atendidos_ano","22","false","text","clientes_atendidos_ano","","","","","","",},
                            {"java.lang.Integer","clientes_mes1","22","false","text","clientes_mes1","","","","","","",},
                            {"java.lang.Integer","clientes_mes2","22","false","text","clientes_mes2","","","","","","",},
                            {"java.lang.Integer","clientes_mesn","22","false","text","clientes_mesn","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos_geral_ano","22","false","text","clientes_atendidos_geral_ano","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT atualizacao      ,datam      ,codigo_marca      ,descricao_marca      ,mes      ,pr_mes      ,vlr_mes      ,mes1      ,pr_mes1      ,vlr_mes1      ,mes2      ,pr_mes2      ,vlr_mes2      ,mesn      ,pr_mesn      ,vlr_mesn      ,pr_mes + pr_mes1 + pr_mes2 + pr_mesn total_pares      ,vlr_mes + vlr_mes1 + vlr_mes2 + vlr_mesn total_valor	  ,clientes      ,total_pares_ano 	  ,total_valor_ano	  	  ,clientes_atendidos_ano  FROM (SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao              ,TO_CHAR(data, 'DD/MM/YYYY') datam              ,mar.codigo_marca              ,mar.descricao_marca              ,INITCAP(RTRIM(TO_CHAR(TO_DATE('17/09/2014','dd/mm/yyyy'), 'Mon', 'nls_date_language = portuguese')) || '/' || TO_CHAR(TO_DATE('17/09/2014','dd/mm/yyyy'), 'yyyy')) mes              ,SUM(NVL(ctl.entped_nomes_pares, 0)) pr_mes              ,SUM(NVL(ctl.entped_nomes_vlr, 0)) vlr_mes              ,INITCAP(RTRIM(TO_CHAR(ADD_MONTHS(TO_DATE('17/09/2014','dd/mm/yyyy'), 1), 'Mon', 'nls_date_language = portuguese')) || '/' || TO_CHAR(ADD_MONTHS(TO_DATE('17/09/2014','dd/mm/yyyy'), 1), 'yyyy')) mes1              ,SUM(NVL(ctl.entped_proxmes1_pares, 0)) pr_mes1              ,SUM(NVL(ctl.entped_proxmes1_vlr, 0)) vlr_mes1              ,INITCAP(RTRIM(TO_CHAR(ADD_MONTHS(TO_DATE('17/09/2014','dd/mm/yyyy'), 2), 'Mon', 'nls_date_language = portuguese')) || '/' || TO_CHAR(ADD_MONTHS(TO_DATE('17/09/2014','dd/mm/yyyy'), 2), 'yyyy')) mes2              ,SUM(NVL(ctl.entped_proxmes2_pares, 0)) pr_mes2              ,SUM(NVL(ctl.entped_proxmes2_vlr, 0)) vlr_mes2              ,INITCAP(RTRIM(TO_CHAR(ADD_MONTHS(TO_DATE('17/09/2014','dd/mm/yyyy'), 3), 'Mon', 'nls_date_language = portuguese')) || '/' || TO_CHAR(ADD_MONTHS(TO_DATE('17/09/2014','dd/mm/yyyy'), 3), 'yyyy')) mesn              ,SUM(NVL(ctl.entped_proxmesn_pares, 0)) pr_mesn              ,SUM(NVL(ctl.entped_proxmesn_vlr, 0)) vlr_mesn			  ,count(distinct ctl.cli_cdgo) clientes			  ,0 total_pares_ano			  ,0.0 total_valor_ano			  ,0 clientes_atendidos_ano          FROM tmp_mapa_automatico_resumo ctl              ,gerentes_regionais_vendas ger              ,regionais_vendas reg              ,rep rep              ,marcas_produtos mar         WHERE empresa = '01'           AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK')           AND data = to_date('17/09/2014','dd/mm/yyyy')           AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente           AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional           AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0)) > 0           AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0)) > 0           AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional           AND NVL(rep.rep_situ, NULL) = 'A'           AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo           AND NVL(ctl.codigo_marca, NULL) = mar.codigo_marca         GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI')                 ,TO_CHAR(data, 'DD/MM/YYYY')                 ,mar.codigo_marca                 ,mar.descricao_marca)";
    return query;
  }

}
