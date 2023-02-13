package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_eventos_i
  * @version 03/04/2013 09:53:24
  */
public class Jw_acao_marketing_eventos_iMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","seq_acao_mkt","22","false","text","","","","","","","",},
                            {"java.lang.String","email_origem","60","false","text","","","","","","","",},
                            {"java.lang.String","email","60","false","text","","","","","","","",},
                            {"java.lang.Integer","cracha_usuario","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.seq_acao_mkt      ,e.seq_evento      ,a.email email_origem      ,e.email      ,e.cracha_usuario  FROM acao_marketing a      ,acao_marketing_eventos e WHERE a.seq_acao_mkt = e.seq_acao_mkt   AND seq_evento = (SELECT MAX(seq_evento)                       FROM acao_marketing_eventos am                      WHERE am.seq_acao_mkt = e.seq_acao_mkt)";
    return query;
  }

}
