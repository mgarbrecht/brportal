package portalbr.dbobj.view;

/** DataBase Object from table .Jw_abastecimento_materiais_fornec
  * @version 22/08/2013 09:51:29
  */
public class Jw_abastecimento_materiais_fornecMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Long","fornecedor_codigo","22","false","text","fornecedor_codigo","","","","","","",},
                            {"java.lang.Integer","fen_seq","22","false","text","fen_seq","","","","","","",},
                            {"java.lang.Long","ies_codigo","22","false","text","ies_codigo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","tai_codigo","5","false","text","tai_codigo","","","","","","",},
                            {"java.lang.Integer","cod_min_fabr","22","false","text","cod_min_fabr","","","","","","",},
                            {"java.lang.Double","quantidade_transito","22","false","text","quantidade_transito","","","","","","",},
                            {"java.lang.Double","quantidade_produzida","22","false","text","quantidade_produzida","","","","","","",},
                            {"java.lang.Double","quantidade_atraso","22","false","text","quantidade_atraso","","","","","","",},
                            {"java.sql.Date","data_entrega","22","false","text","data_entrega","","","","","","",},
                            {"java.sql.Timestamp","data_atualizacao","22","false","text","data_atualizacao","","","","","","",},
                            {"java.lang.Integer","id","22","false","text","id","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT         r.for_codigo fornecedor_codigo       ,r.fen_seq             ,r.ies_codigo       ,r.cor_cdgo       ,r.tai_codigo       ,r.cod_min_fabr       ,r.quantidade_transito       ,r.quantidade_produzida       ,r.quantidade_atraso       ,r.data_entrega	   ,r.data_atualizacao	   ,r.id   FROM req_sdo_abastecimento_fornec r  WHERE data_atualizacao = (SELECT MAX(data_atualizacao)                              FROM req_sdo_abastecimento_fornec                             WHERE ies_codigo = r.ies_codigo                               AND cor_cdgo = r.cor_cdgo                               AND tai_codigo = r.tai_codigo                               AND cod_min_fabr = r.cod_min_fabr                               AND for_codigo = r.for_codigo                               AND fen_seq = r.fen_seq							   and id = r.id)";
    return query;
  }

}
