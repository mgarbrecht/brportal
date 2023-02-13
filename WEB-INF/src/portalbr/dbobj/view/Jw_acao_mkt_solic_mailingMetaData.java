package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_mkt_solic_mailing
  * @version 03/04/2013 09:52:43
  */
public class Jw_acao_mkt_solic_mailingMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id_solicitacao","22","false","text","id_solicitacao","","","","","","",},
                            {"java.lang.String","email_retorno","65","false","text","email_retorno","","","","","","",},
                            {"java.lang.String","assunto","200","false","text","assunto","","","","","","",},
                            {"java.sql.Timestamp","data_envio","22","false","text","data_envio","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","nome_arquivo","90","false","text","nome_arquivo","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","situacao","","","","","","",},
                            {"java.lang.String","situacao_desc","240","false","text","situacao_desc","","","","","","",},
                            {"java.lang.String","observacoes","2000","false","text","observacoes","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT am.id_solicitacao      , am.email_retorno      , am.assunto      , am.data_envio      , am.nome_arquivo      , am.situacao      , cg.rv_abbreviation situacao_desc      , am.observacoes   FROM acao_mkt_solic_mailing am      , cg_ref_codes cg  WHERE am.situacao = cg.rv_low_value    AND cg.rv_domain = 'STATUS_MAILING_MARKETING'";
    return query;
  }

}
