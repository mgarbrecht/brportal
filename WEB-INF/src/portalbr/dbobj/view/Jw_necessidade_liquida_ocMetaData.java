package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_liquida_oc
  * @version 03/04/2013 09:21:06
  */
public class Jw_necessidade_liquida_ocMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Double","FORNECEDOR","22","false","text","","","","","","","",},
                            {"java.lang.Double","FEN_SEQ","22","false","text","","","","","","","",},
                            {"java.lang.Double","IES_CODIGO","22","false","text","","","","","","","",},
                            {"java.lang.Double","COR_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.String","TAI_CODIGO","10","false","text","","","","","","","",},
                            {"java.lang.Double","OC","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA1","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA2","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA3","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA4","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCMES1","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCMES2","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCMES3","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select  fornecedor      , fen_seq      , ies_codigo      , cor_cdgo      , tai_codigo      , nvl(sum(oc.compra),0) oc,        nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE, 'WW/YYYY'),                    NVL(oc.compra, 0), 0)),0) OCSemana1,         nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 7, 'WW/YYYY'),                    NVL(oc.compra, 0), 0)),0) OCSemana2,         nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 14, 'WW/YYYY'),                    NVL(oc.compra, 0), 0)),0) OCSemana3,         nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 21, 'WW/YYYY'),                    NVL(oc.compra, 0), 0)),0) OCSemana4,         nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'MM/YYYY'), TO_CHAR(SYSDATE, 'MM/YYYY'),                    NVL(oc.compra, 0), 0)),0) OCMes1,         nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' ||                     TO_CHAR(SYSDATE, 'MM/YYYY'), 'DD/MM/YYYY'), 1),'MM/YYYY'),NVL(oc.compra, 0),0)),0) OCMes2,          nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' ||                     TO_CHAR(ADD_MONTHS(TO_DATE('01/' || TO_CHAR(SYSDATE,'MM/YYYY'),'DD/MM/YYYY'),1),                     'MM/YYYY'),'DD/MM/YYYY'),1),'MM/YYYY'),NVL(oc.compra, 0),0)),0) OCMes3 from ( SELECT o.for_codigo fornecedor,        o.fen_seq,        dio.ies_codigo,        dio.cor_cdgo,        dio.tai_codigo,        dei.data_entrega,            SUM(nvl(dio.quant_comprada, 0) - nvl(dio.quant_recebida, 0)) compra   FROM dom_ordem_compra      o,        dom_item_ordem_compra dio,        dom_item_estoque      i,        dom_data_entrega_item dei  WHERE o.numero = dio.oco_numero     AND i.codigo = dio.ies_codigo    and dio.oco_numero = dei.oco_numero    and dio.sequencia  = dei.ioc_sequencia    AND nvl(o.situacao, null) = 0 group by o.for_codigo,          o.fen_seq,          dio.ies_codigo,          dio.cor_cdgo,          dio.tai_codigo,          dei.data_entrega ) oc group by         fornecedor      , fen_seq      , ies_codigo      , cor_cdgo      , tai_codigo";
    return query;
  }

}
