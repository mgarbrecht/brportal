package portalbr.dbobj.view;

/** DataBase Object from table .Jw_comunicacao
  * @version 03/04/2013 09:41:22
  */
public class Jw_comunicacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","sequencia","22","false","text","sequencia","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.sql.Clob","descricao_comunicacao","4000","false","text","descricao_comunicacao","","","","","","",},
                            {"java.sql.Timestamp","data_comunicacao","22","false","text","data_comunicacao","","","","","","",},
                            {"java.lang.String","usuario_cadastramento","30","false","text","usuario_cadastramento","","","","","","",},
                            {"java.lang.Integer","codigo_colecao","22","false","text","codigo_colecao","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","codigo_argumento","22","false","text","codigo_argumento","","","","","","",},
                            {"java.lang.String","descricao_argumento","30","false","text","descricao_argumento","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","ref_desc","25","false","text","ref_desc","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","35","false","text","cab_desc","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","60","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","status","2","false","text","status","","","","","","",},
                            {"java.lang.String","status_desc","12","false","text","status_desc","","","","","","",},
                            {"java.lang.Integer","qtd_retornos","22","false","text","qtd_retornos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select sequencia, co.rep_cdgo, r.rep_rzao, r.codigo_regional, co.cli_cdgo, c.cli_rzao, descricao_comunicacao, data_comunicacao, usuario_cadastramento, codigo_colecao, col.descricao, co.codigo_argumento, ta.descricao_argumento, co.codigo_marca, mp.descricao_marca, co.lin_cdgo, l.lin_nome, co.ref_cdgo, rf.ref_desc, co.cab_cdgo, cab.cab_desc, co.cor_cdgo, cor.cor_desc, co.status, decode(co.status,'EA','Em Andamento','EN','Encaminhado','RE','Resolvido',co.status)status_desc, decode((select count(*)from brio.comunicacao_retornos cr where cr.sequencia=co.sequencia),0,0,1)qtd_retornos from comunicacao co, rep r, cli c, colecao col, tipos_argumentos ta, marcas_produtos mp, lin l, ref rf, cabedal cab, cor where co.rep_cdgo=r.rep_cdgo and c.cli_cdgo(+)=co.cli_cdgo and col.codigo(+)=co.codigo_colecao and ta.codigo_argumento(+)=co.codigo_argumento and mp.codigo_marca(+)=co.codigo_marca and l.lin_cdgo(+)=co.lin_cdgo and rf.lin_cdgo(+)=co.lin_cdgo and rf.ref_cdgo(+)=co.ref_cdgo and cab.cab_cdgo(+)=co.cab_cdgo and cor.cor_cdgo(+)=co.cor_cdgo";
    return query;
  }

}
