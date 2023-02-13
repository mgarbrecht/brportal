package portalbr.dbobj.view;

/** DataBase Object from table .Jw_relatorio_atelier_pre_envio_quarterizado
  * @version 15/01/2015 16:49:40
  */
public class Jw_relatorio_atelier_pre_envio_quarterizadoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","fornecedor_codigo","22","false","text","fornecedor_codigo","","","","","","",},
                            {"java.lang.Integer","fornecedor_codigo_quarterizado","22","false","text","fornecedor_codigo_quarterizado","","","","","","",},
                            {"java.lang.Integer","fen_seq_quarterizado","22","false","text","fen_seq_quarterizado","","","","","","",},
                            {"java.lang.String","fornecedor_razsoc","100","false","text","fornecedor_razsoc","","","","","","",},
                            {"java.lang.Integer","pro_numero","22","false","text","pro_numero","","","","","","",},
                            {"java.lang.String","pro_nome","100","false","text","pro_nome","","","","","","",},
                            {"java.sql.Timestamp","data_envio","22","false","text","data_envio","","","","","","",},
                            {"java.sql.Timestamp","data_retorno","22","false","text","data_retorno","","","","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.lang.Integer","tal_nro","22","false","text","tal_nro","","","","","","",},
                            {"java.lang.String","status","1","false","text","status","","","","","","",},
                            {"java.lang.String","status_descricao","20","false","text","status_descricao","","","","","","",},
                            {"java.lang.String","usuario_inclusao","50","false","text","usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","50","false","text","usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","data_ordenacao","22","false","text","data_ordenacao","","","","","","",},
                            {"java.lang.Integer","tal_pares","22","false","text","tal_pares","","","","","","",},
                            {"java.lang.Integer","tal_parbom","22","false","text","tal_parbom","","","","","","",},
                            {"java.lang.Integer","tal_parrej","22","false","text","tal_parrej","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","100","false","text","cab_desc","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","100","false","text","cor_desc","","","","","","",},
                            {"java.sql.Timestamp","data_corte","22","false","text","data_corte","","","","","","",},
                            {"java.sql.Timestamp","data_cost","22","false","text","data_cost","","","","","","",},
                            {"java.sql.Timestamp","data_mont","22","false","text","data_mont","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ape.for_codigo fornecedor_codigo       ,ape.for_codigo_quarterizado fornecedor_codigo_quarterizado       ,ape.fen_seq_quarterizado       ,f.for_razsoc fornecedor_razsoc       ,ape.pro_numero       ,p.pro_nome       ,ape.data_envio       ,ape.data_retorno       ,ape.rem_nro       ,ape.tal_nro       ,ape.status       ,DECODE(ape.status, 'E', 'Envio', 'R', 'Retorno', 'Envio') status_descricao       ,ape.usuario_inclusao       ,ape.usuario_alteracao       ,CASE          WHEN data_envio > NVL(data_retorno, '01-jan-1970') THEN           data_envio          ELSE           data_retorno        END data_ordenacao       ,t.tal_pares       ,t.tal_parbom       ,t.tal_parrej       ,r.lin_cdgo       ,t.ref_cdgo       ,t.cab_cdgo       ,cab.cab_desc       ,t.cor_cdgo       ,c.cor_desc       ,(SELECT DISTINCT tlf_fim FROM talao_fase tf WHERE rem_nro = r.rem_nro AND tal_nro = t.tal_nro AND r.fil_filial = tf.fil_filial AND set_cdgo = 'CORTE') data_corte       ,(SELECT DISTINCT tlf_fim FROM talao_fase tf WHERE rem_nro = r.rem_nro AND tal_nro = t.tal_nro AND r.fil_filial = tf.fil_filial AND set_cdgo = 'COST') data_cost       ,(SELECT DISTINCT tlf_fim FROM talao_fase tf WHERE rem_nro = r.rem_nro AND tal_nro = t.tal_nro AND r.fil_filial = tf.fil_filial AND set_cdgo = 'MONT') data_mont   FROM cpr.atelier_pre_envio_quarterizado ape       ,talao t       ,remessa r       ,for_endere_quarterizado f       ,processo_fab p       ,cor c       ,cabedal cab  WHERE ape.for_codigo = f.for_codigo    AND t.rem_nro = ape.rem_nro    AND t.tal_nro = ape.tal_nro    AND t.rem_nro = r.rem_nro    AND c.cor_cdgo = t.cor_cdgo    AND cab.cab_cdgo = t.cab_cdgo    AND ape.for_codigo_quarterizado = f.for_codigo_quarterizado    AND ape.fen_seq_quarterizado = f.fen_seq_quarterizado    AND ape.pro_numero = p.pro_numero  ORDER BY data_ordenacao DESC";
    return query;
  }

}
