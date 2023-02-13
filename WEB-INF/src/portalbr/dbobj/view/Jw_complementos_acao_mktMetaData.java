package portalbr.dbobj.view;

/** DataBase Object from table .Jw_complementos_acao_mkt
  * @version 03/04/2013 09:41:44
  */
public class Jw_complementos_acao_mktMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","acao","22","false","text","","","","","","","",},
                            {"java.lang.String","tipo_complemento","60","false","text","","","","","","","",},
                            {"java.lang.String","complemento","60","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.seq_acao_mkt acao      , t.tipo_complemento      , c.complemento   FROM acao_market_dados_adicionais a       ,acao_marketing_complemento c       ,acao_marketing_tipo_compl t  WHERE t.situacao = 'A'    AND c.situacao = 'A'    AND t.id = c.id_tipo    AND a.id_complemento = c.id";
    return query;
  }

}
