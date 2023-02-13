package portalbr.dbobj.view;

/** DataBase Object from table .Jw_atelier_pre_envio_quarterizado
  * @version 16/01/2015 11:16:44
  */
public class Jw_atelier_pre_envio_quarterizadoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","fornecedor_codigo","22","false","text","fornecedor_codigo","","","","","","",},
                            {"java.lang.Integer","fornecedor_codigo_quarterizado","22","false","text","","","","","","","",},
                            {"java.lang.Integer","fen_seq_quarterizado","22","false","text","fen_seq_quarterizado","","","","","","",},
                            {"java.lang.String","fornecedor_razsoc","100","false","text","fornecedor_razsoc","","","","","","",},
                            {"java.lang.Integer","pro_numero","22","false","text","","","","","","","",},
                            {"java.lang.String","pro_nome","100","false","text","pro_nome","","","","","","",},
                            {"java.sql.Timestamp","data_envio","22","false","text","data_envio","","","","","","",},
                            {"java.sql.Timestamp","data_retorno","22","false","text","data_retorno","","","","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.lang.Integer","tal_nro","22","false","text","","","","","","","",},
                            {"java.lang.String","status","1","false","text","status","","","","","","",},
                            {"java.lang.String","status_descricao","20","false","text","status_descricao","","","","","","",},
                            {"java.lang.String","usuario_inclusao","100","false","text","usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","100","false","text","usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","data_ordenacao","22","false","text","data_ordenacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ape.for_codigo fornecedor_codigo       ,ape.for_codigo_quarterizado fornecedor_codigo_quarterizado       ,ape.fen_seq_quarterizado       ,f.for_razsoc fornecedor_razsoc       ,ape.pro_numero       ,p.pro_nome       ,ape.data_envio       ,ape.data_retorno       ,ape.rem_nro       ,ape.tal_nro       ,ape.status       ,decode(ape.status, 'E', 'Envio', 'R', 'Retorno','Envio') status_descricao        ,ape.usuario_inclusao       ,ape.usuario_alteracao	   ,CASE WHEN data_envio > nvl(data_retorno,'01-jan-1970') THEN data_envio ELSE data_retorno END data_ordenacao   FROM cpr.atelier_pre_envio_quarterizado ape       ,for_endere_quarterizado f       ,processo_fab p  WHERE ape.for_codigo = f.for_codigo    AND ape.for_codigo_quarterizado = f.for_codigo_quarterizado    AND ape.fen_seq_quarterizado = f.fen_seq_quarterizado    AND ape.pro_numero = p.pro_numero	AND CASE WHEN data_envio > nvl(data_retorno,'01-jan-1970') THEN data_envio ELSE data_retorno END >= trunc(SYSDATE)";
    return query;
  }

}
