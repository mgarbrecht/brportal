package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_aberto
  * @version 11/02/2014 12:41:33
  */
public class Jw_pse0053_total_abertoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pro_numero","22","false","text","pro_numero","","","","","","",},
                            {"java.lang.String","pro_nome","100","false","text","pro_nome","","","","","","",},
                            {"java.lang.Integer","codigo_item","22","false","text","Codigo_item","","","","","","",},
                            {"java.lang.String","descricao_produtos","400","false","text","descricao_produtos","","","","","","",},
                            {"java.lang.Integer","linha","22","false","text","","","","","","","",},
                            {"java.lang.Integer","referencia","22","false","text","referencia","","","","","","",},
                            {"java.lang.Integer","cabedal","22","false","text","cabedal","","","","","","",},
                            {"java.lang.Double","preco","22","false","text","preco","","##,##0.00","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","total","22","false","text","total","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT pro_numero      ,pck_processo_fab.get_nome(pro_numero) pro_nome	  ,0 codigo_item	  ,'' descricao_produtos      ,linha      ,referencia      ,cabedal      ,preco      ,pares      ,preco * pares total  FROM (SELECT t.pro_numero              ,t.lin_cdgo linha              ,t.ref_cdgo referencia              ,t.cab_cdgo cabedal              ,(SELECT DISTINCT preco_unidade                  FROM tab_preco_atelier t2                 WHERE t.emp_empresa = t2.emp_empresa                   AND t.fil_filial = t2.fil_filial                   AND t.unn_codigo = t2.unn_codigo                   AND t.lin_cdgo = t2.lin_cdgo                   AND t.ref_cdgo = t2.ref_cdgo                   AND t.cab_cdgo = t2.cab_cdgo                   AND t.pro_numero = t2.pro_numero                   AND t.pro_tipo = t2.pro_tipo                   AND t.for_codigo = t2.for_codigo                   AND t.fen_seq = t2.fen_seq                   AND t.codigo_cond_pgto = t2.codigo_cond_pgto                   AND t.data_validade = t2.data_ini_validade) preco              ,tal_pares pares          FROM (SELECT t.emp_empresa                      ,t.fil_filial                      ,t.unn_codigo                      ,t.lin_cdgo                      ,t.ref_cdgo                      ,t.cab_cdgo                      ,t.pro_numero                      ,t.pro_tipo                      ,t.for_codigo                      ,t.fen_seq                      ,t.codigo_cond_pgto                      ,MAX(data_ini_validade) data_validade                      ,SUM(ta.tal_pares) tal_pares                  FROM tab_preco_atelier t                      ,atelier_pre_envio a                      ,talao ta                 WHERE a.fil_filial = '16'                   AND a.for_codigo = 1029765                   AND a.pro_numero = 1                   AND a.data_pre_envio >= TO_DATE('23/06/2013', 'dd/mm/yyyy')                   AND a.data_pre_envio <= TO_DATE('23/07/2013', 'dd/mm/yyyy') + 1                   AND ta.rem_nro = a.rem_nro                   AND ta.tal_nro = a.tal_nro                   AND t.emp_empresa = a.emp_empresa                   AND t.fil_filial = a.fil_filial                   AND t.for_codigo = a.for_codigo                   AND t.pro_numero = a.pro_numero                   AND t.lin_cdgo = a.lin_cdgo                   AND t.ref_cdgo = a.ref_cdgo                   AND unn_codigo = pck_filial.get_unn_codigo(t.fil_filial, t.emp_empresa)                   AND (('E' = 'E' AND a.status IS NULL))                 GROUP BY t.emp_empresa                         ,t.fil_filial                         ,t.unn_codigo                         ,t.lin_cdgo                         ,t.ref_cdgo                         ,t.cab_cdgo                         ,t.pro_numero                         ,t.pro_tipo                         ,t.for_codigo                         ,t.fen_seq                         ,t.codigo_cond_pgto) t)UNIONSELECT pro_numero      ,linha      ,referencia      ,cabedal      ,preco      ,pares      ,preco * pares total  FROM (SELECT a.pro_numero              ,pck_processo_fab.get_nome(pro_numero) pro_nome              ,a.lin_cdgo linha              ,a.ref_cdgo referencia              ,t.cab_cdgo cabedal              ,ioc.preco_unitario preco              ,SUM(a.tal_pares) pares          FROM atelier_pre_envio a              ,talao t              ,cpr.atelier_rem_taloes_oc art              ,cpr.atelier_rem_talao_item_oc arti              ,cpr.dom_item_ordem_compra ioc              ,cpr.dom_ordem_compra oc         WHERE a.fil_filial = '16'           AND a.for_codigo = 1029765           AND t.rem_nro = a.rem_nro           AND t.tal_nro = a.tal_nro           AND a.data_pre_envio >= TO_DATE('23/06/2013', 'dd/mm/yyyy')           AND a.data_pre_envio <= TO_DATE('23/07/2013', 'dd/mm/yyyy') + 1           AND art.aroc_rem_nro = a.rem_nro           AND art.tal_nro = a.tal_nro           AND art.pro_numero = a.pro_numero           AND arti.oco_numero = art.aroc_oco_numero           AND arti.rem_nro = art.aroc_rem_nro           AND arti.tal_nro = art.tal_nro           AND ioc.oco_numero = arti.oco_numero           AND ioc.sequencia = arti.ioc_sequencia           AND oc.numero = ioc.oco_numero           AND ioc.oco_numero = arti.oco_numero           AND ioc.sequencia = arti.ioc_sequencia           AND oc.numero = ioc.oco_numero           AND ('R' = 'R' AND a.status_consiste_atelier = 'C' AND a.status_retorno IS NULL)         GROUP BY a.pro_numero                 ,a.lin_cdgo                 ,a.ref_cdgo                 ,t.cab_cdgo                 ,ioc.preco_unitario) ORDER BY pro_numero         ,linha         ,referencia         ,cabedal";
    return query;
  }

}
