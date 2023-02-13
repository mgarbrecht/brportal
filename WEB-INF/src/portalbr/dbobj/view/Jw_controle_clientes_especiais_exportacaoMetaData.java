package portalbr.dbobj.view;

/** DataBase Object from table .Jw_controle_clientes_especiais_exportacao
  * @version 19/12/2017 17:54:03
  */
public class Jw_controle_clientes_especiais_exportacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data_entrega_fatura","22","false","text","data_entrega_fatura","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","numero_fatura_proforma","22","false","text","numero_fatura_proforma","","","","","","",},
                            {"java.lang.Integer","ano_fatura_proforma","22","false","text","ano_fatura_proforma","","","","","","",},
                            {"java.lang.Integer","empresa_fatura_proforma","22","false","text","empresa_fatura_proforma","","","","","","",},
                            {"java.lang.Integer","codigo_cliente","22","false","text","codigo_cliente","","","","","","",},
                            {"java.lang.Integer","estabelecimento_cliente","22","false","text","estabelecimento_cliente","","","","","","",},
                            {"java.lang.String","razao_cliente","50","false","text","razao_cliente","","","","","","",},
                            {"java.lang.String","pais","100","false","text","pais","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","##,##0.00","","","","",},
                            {"java.lang.String","data_fatura","100","false","text","data_fatura","","","","","","",},
                            {"java.lang.String","data_prev_faturamento","100","false","text","data_prev_faturamento","","","","","","",},
                            {"java.lang.String","data_prev_embarque","100","false","text","data_prev_embarque","","","","","","",},
                            {"java.lang.String","data_deposito","100","false","text","data_deposito","","","","","","",},
                            {"java.lang.String","data_embarque","100","false","text","data_embarque","","","","","","",},
                            {"java.lang.String","dias_deposito","100","false","text","dias_deposito","","","","","","",},
                            {"java.lang.String","etiquetas","100","false","text","etiquetas","","","","","","",},
                            {"java.lang.String","dt_rec_etiqueta_filial","100","false","text","dt_rec_etiqueta_filial","","","","","","",},
                            {"java.lang.String","dt_entrega_etiquetas","100","false","text","dt_entrega_etiquetas","","","","","","",},
                            {"java.lang.String","dt_entrega_etiqueta","100","false","text","dt_entrega_etiqueta","","","","","","",},
                            {"java.lang.Object","filiais","100","false","text","filiais","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","50","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","codigo_representante","22","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","razao_representante","50","false","text","razao_representante","","","","","","",},
                            {"java.lang.String","codigo_transportadora","22","false","text","codigo_transportadora","","","","","","",},
                            {"java.lang.String","razao_transportadora","50","false","text","razao_transportadora","","","","","","",},
                            {"java.lang.String","especie_fatura","10","false","text","especie_fatura","","","","","","",},
                            {"java.lang.String","descricao_especie_fatura","100","false","text","descricao_especie_fatura","","","","","","",},
                            {"java.lang.String","status_fatura","10","false","text","status_fatura","","","","","","",},
                            {"java.lang.String","descricao_status_fatura","100","false","text","descricao_status_fatura","","","","","","",},
                            {"java.lang.String","obs_fatura","2000","false","text","obs_fatura","","","","","","",},
                            {"java.lang.String","dt_inspecao","10","false","text","dt_inspecao","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","data_embarque_cargovision","10","false","text","data_embarque_cargovision","","dd/MM/yyyy","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' data_entrega_fatura      ,'' numero_fatura_proforma      ,'' ano_fatura_proforma      ,'' empresa_fatura_proforma      ,'' data_fatura      ,'' data_prev_faturamento      ,'' data_prev_embarque      ,'' data_deposito      ,'' data_embarque      ,'' dias_deposito      ,'' codigo_cliente      ,'' estabelecimento_cliente      ,'' razao_cliente      ,'' codigo_representante      ,'' razao_representante      ,'' codigo_transportadora      ,'' razao_transportadora      ,'' pais      ,'' pares      ,'' valor      ,'' etiquetas      ,'' dt_rec_etiqueta_filial      ,'' dt_entrega_etiquetas      ,'' filiais      ,'' codigo_regional      ,'' nome_regional      ,'' especie_fatura      ,'' descricao_especie_fatura      ,'' status_fatura      ,'' descricao_status_fatura      ,'' obs_fatura      ,'' dt_inspecao      ,'' data_embarque_cargovision  FROM dual";
    return query;
  }

}
