package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_solic_mailing
  * @version 03/04/2013 10:08:06
  */
public class Acao_mkt_solic_mailingMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MKT_SOLIC_MAILING";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"java.lang.String","email_retorno","65","true","text","Email_retorno","","","","","","",},
                            {"java.lang.String","assunto","200","true","text","Assunto","","","","","","",},
                            {"java.sql.Timestamp","data_envio","19","true","text","Data_envio","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","nome_arquivo","90","false","text","Nome_arquivo","","","","","","",},
                            {"java.lang.String","situacao","1","true","text","Situacao","","","","","","",},
                            {"java.lang.String","observacoes","2000","false","text","Observacoes","","","","","","",},
                            {"java.sql.Timestamp","data_encerramento","19","true","text","Data_encerramento","","dd/MM/yyyy HH:mm:ss","true","","","",}
                          };
    return metadata;
  }

}
