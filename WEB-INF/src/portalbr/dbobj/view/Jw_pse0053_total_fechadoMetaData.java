package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_fechado
  * @version 10/03/2020 14:17:03
  */
public class Jw_pse0053_total_fechadoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pro_numero","22","false","text","pro_numero","","","","","","",},
                            {"java.lang.String","pro_nome","100","false","text","pro_nome","","","","","","",},
                            {"java.lang.Double","pares","22","false","text","pares","","##,##0.00","","","","",},
                            {"java.lang.Double","preco","22","false","text","preco","","##,##0.00","","","","",},
                            {"java.lang.Double","total","22","false","text","total","","##,##0.00","","","","",},
                            {"java.lang.Integer","fen_seq","22","false","text","fen_seq","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT pro_numero      ,pck_processo_fab.get_nome(pro_numero) pro_nome      ,pares      ,preco      ,pares * preco total	  ,0 fen_seq  FROM (SELECT a.pro_numero              ,SUM(tal_pares) pares              ,pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq) preco          FROM atelier_pre_envio a         WHERE a.fil_filial = '16'           AND a.for_codigo = 1029765           AND a.pro_numero = 1           AND a.data_pre_envio >= TO_DATE('23/06/2013', 'dd/mm/yyyy')           AND a.data_pre_envio < TO_DATE('23/07/2013', 'dd/mm/yyyy') + 1           AND (('E' = 'E' AND a.status IS NULL))         GROUP BY a.pro_numero                 ,pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq))UNIONSELECT pro_numero      ,pck_processo_fab.get_nome(pro_numero) pro_nome      ,pares      ,preco      ,pares * preco total  FROM (SELECT a.pro_numero              ,SUM(a.tal_pares) pares              ,ioc.preco_unitario preco          FROM atelier_pre_envio a              ,talao t              ,cpr.atelier_rem_taloes_oc art              ,cpr.atelier_rem_talao_item_oc arti              ,cpr.dom_item_ordem_compra ioc              ,cpr.dom_ordem_compra oc         WHERE a.fil_filial = '16'           AND a.for_codigo = 1029765           AND a.pro_numero = 1           AND t.rem_nro = a.rem_nro           AND t.tal_nro = a.tal_nro           AND a.data_pre_envio >= TO_DATE('23/06/2013', 'dd/mm/yyyy')           AND a.data_pre_envio <= TO_DATE('23/07/2013', 'dd/mm/yyyy') + 1           AND art.aroc_rem_nro = a.rem_nro           AND art.tal_nro = a.tal_nro           AND art.pro_numero = a.pro_numero           AND arti.oco_numero = art.aroc_oco_numero           AND arti.rem_nro = art.aroc_rem_nro           AND arti.tal_nro = art.tal_nro           AND ioc.oco_numero = arti.oco_numero           AND ioc.sequencia = arti.ioc_sequencia           AND oc.numero = ioc.oco_numero           AND ioc.oco_numero = arti.oco_numero           AND ioc.sequencia = arti.ioc_sequencia           AND oc.numero = ioc.oco_numero           AND ('R' = 'R' AND a.status_consiste_atelier = 'C' AND a.status_retorno IS NULL)         GROUP BY a.pro_numero                 ,ioc.preco_unitario) ORDER BY pro_numero         ,preco";
    return query;
  }

}
