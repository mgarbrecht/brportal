package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_i
  * @version 25/05/2010 12:56:39
  */
public class Jw_acao_marketing_iMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","SEQ_ACAO_MKT","22","false","text","","","","","","","",},
                            {"java.lang.String","EMAIL","60","false","text","","","","","","","",},
                            {"java.lang.String","EMAIL","60","false","text","","","","","","","",},
                            {"java.lang.Integer","CRACHA_USUARIO","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.seq_acao_mkt       ,a.email       ,e.email       ,e.cracha_usuario   FROM acao_marketing a       ,acao_marketing_eventos e  WHERE a.seq_acao_mkt = e.seq_acao_mkt    AND e.seq_evento = 1";
    return query;
  }

}
