package portalbr.dbobj.view;

/** DataBase Object from table .Jw_comunicacao_rel
  * @version 16/05/2014 09:10:39
  */
public class Jw_comunicacao_relMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Date","data_comunicacao","12","false","text","data_comunicacao","","","","","","",},
                            {"java.lang.Integer","sequencia","22","false","text","sequencia","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Integer","codigo_argumento","-105","false","text","codigo_argumento","","","","","","",},
                            {"java.lang.String","descricao_argumento","30","false","text","descricao_argumento","","","","","","",},
                            {"java.lang.Integer","codigo_colecao","-105","false","text","codigo_colecao","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","codigo_marca","-105","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","-105","false","text","lin_cdgo","","","","","","",},
                            {"java.sql.Clob","descricao_comunicacao","4000","false","text","descricao_comunicacao","","","","","","",},
                            {"java.sql.Date","data_retorno","12","false","text","data_retorno","","","","","","",},
                            {"java.lang.String","usuario_retorno","30","false","text","usuario_retorno","","","","","","",},
                            {"java.sql.Clob","descricao_retorno","4000","false","text","descricao_retorno","","","","","","",},
                            {"java.lang.Integer","qtd_retornos","22","false","text","qtd_retornos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT TRUNC(com.data_comunicacao) data_comunicacao      ,com.sequencia      ,com.rep_cdgo      ,NVL(r.rep_rzao, r.rep_nome) rep_rzao      ,com.codigo_argumento      ,t.descricao_argumento      ,com.codigo_colecao      ,c.descricao descricao      ,com.codigo_marca      ,mp.descricao_marca      ,com.lin_cdgo      ,com.descricao_comunicacao      ,cr.data_retorno      ,cr.usuario_retorno      ,cr.descricao_retorno      ,DECODE((SELECT COUNT(*)                FROM brio.comunicacao_retornos cr               WHERE cr.sequencia = com.sequencia), 0, 0, 1) qtd_retornos  FROM comunicacao com      ,marcas_produtos mp      ,colecao c      ,tipos_argumentos t      ,rep r      ,brio.comunicacao_retornos cr WHERE com.sequencia = cr.sequencia(+)   AND com.codigo_marca = mp.codigo_marca(+)   AND com.codigo_colecao = c.codigo(+)   AND com.codigo_argumento = t.codigo_argumento(+)   AND com.rep_cdgo = r.rep_cdgo(+) ORDER BY data_comunicacao         ,com.sequencia         ,rep_rzao         ,t.descricao_argumento         ,c.descricao         ,mp.descricao_marca";
    return query;
  }

}
