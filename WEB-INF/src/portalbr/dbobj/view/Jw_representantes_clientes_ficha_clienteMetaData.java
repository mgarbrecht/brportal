package portalbr.dbobj.view;

/** DataBase Object from table .Jw_representantes_clientes_ficha_cliente
  * @version 03/04/2013 09:13:12
  */
public class Jw_representantes_clientes_ficha_clienteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","codigo_cliente","22","false","text","codigo_cliente","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","50","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","rep_nome","30","false","text","rep_nome","","","","","","",},
                            {"java.lang.String","cliente_desde","30","false","text","cliente_desde","","","","","","",},
                            {"java.lang.String","ultima_compra","30","false","text","ultima_compra","","","","","","",},
                            {"java.lang.String","email_cliente","100","false","text","email_cliente","","","","","","",},
                            {"java.lang.String","fone_cliente","100","false","text","fone_cliente","","","","","","",},
                            {"java.lang.String","gre_grupo","10","false","text","gre_grupo","","","","","","",},
                            {"java.lang.String","gre_descricao","100","false","text","gre_descricao","","","","","","",},
                            {"java.lang.String","marcas_representante","400","false","text","marcas_representante","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT rv.codigo_regional                ,rv.nome_regional                ,cr.codigo_cliente                ,c.cli_rzao                ,c.cli_nome                ,s.esc_seqn                ,cr.codigo_representante                ,r.rep_rzao                ,r.rep_nome                ,'' cliente_desde				,'' ultima_compra				,'' email_cliente				,'' fone_cliente				,'' gre_grupo				,'' gre_descricao				,'' marcas_representante   FROM cliente_representante cr       ,regionais_vendas rv       ,rep r       ,cli c       ,esc s  WHERE cr.codigo_representante = r.rep_cdgo    AND s.cli_cdgo = c.cli_cdgo    AND cr.codigo_cliente = c.cli_cdgo    AND rv.codigo_regional = r.codigo_regional    AND r.rep_situ = 'A'    AND cr.situacao = 'A'    AND cr.codigo_sequencial = s.esc_seqn";
    return query;
  }

}
