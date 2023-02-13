package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_posicao_entrega_compras
  * @version 07/05/2015 13:00:14
  */
public class Jw_consulta_posicao_entrega_comprasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","for_codigo","40","false","text","for_codigo","","","","","","",},
                            {"java.lang.String","fornecedor","200","false","text","fornecedor","","","","","","",},
                            {"java.sql.Timestamp","data_compra","22","false","text","data_compra","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","ies_codigo","40","false","text","ies_codigo","","","","","","",},
                            {"java.lang.String","descricao_item","200","false","text","descricao_item","","","","","","",},
                            {"java.lang.String","cor_cdgo","40","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","200","false","text","cor_desc","","","","","","",},
                            {"java.sql.Timestamp","data_entrega","22","false","text","data_entrega","","dd/MM/yyyy","","","","",},
                            {"double","quant_comprada","27","false","text","quant_comprada","","","","","","",},
                            {"double","quant_recebida","27","false","text","quant_recebida","","","","","","",},
                            {"java.lang.Integer","oco_numero","22","false","text","oco_numero","","","","","","",},
                            {"double","saldo","27","false","text","saldo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT d.fil_filial       ,to_char(d.for_codigo) for_codigo       ,pck_fornecedor.get_nome(d.for_codigo) fornecedor       ,d.data_compra       ,to_char(o.ies_codigo) ies_codigo       ,pck_item_estoque.get_nome(o.ies_codigo) descricao_item       ,to_char(o.cor_cdgo) cor_cdgo       ,pck_cor.get_nome(o.cor_cdgo) cor_desc       ,i.data_entrega       ,i.quant_comprada       ,i.quant_recebida       ,o.oco_numero       ,i.quant_comprada - i.quant_recebida saldo	      FROM dom_data_entrega_item     i       ,dom_item_ordem_compra     o       ,dom_ordem_compra          d       ,dom_ordem_compra_mini_fab f  WHERE d.numero = i.oco_numero    AND o.oco_numero = i.oco_numero    AND o.sequencia = i.ioc_sequencia    AND fct_grupo_material(o.ies_codigo) = 2    AND i.quant_comprada - i.quant_recebida > 0	    AND i.quant_comprada <> i.quant_recebida  ORDER BY i.data_entrega          ,d.for_codigo          ,d.data_compra";
    return query;
  }

}
