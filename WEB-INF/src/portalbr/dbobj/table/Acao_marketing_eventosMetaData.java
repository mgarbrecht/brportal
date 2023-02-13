package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing_eventos
  * @version 03/04/2013 10:08:43
  */
public class Acao_marketing_eventosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"SEQ_ACAO_MKT","SEQ_EVENTO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MARKETING_EVENTOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","seq_acao_mkt","22","true","text","Seq_acao_mkt","","","true","","","",},
                            {"int","seq_evento","22","true","text","Seq_evento","","","true","","","",},
                            {"java.lang.String","email","60","true","text","Email","","","","","","",},
                            {"java.lang.String","obs_evento","60","true","text","Obs_evento","","","","","","",},
                            {"java.sql.Date","data_transacao","10","true","text","Data_transacao","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario_transacao","60","true","text","Usuario_transacao","","","","","","",},
                            {"java.lang.String","email2","60","false","text","Email2","","","","","","",},
                            {"java.lang.String","obs_evento2","60","false","text","Obs_evento2","","","","","","",},
                            {"java.lang.String","email3","60","false","text","Email3","","","","","","",},
                            {"java.lang.String","obs_evento3","60","false","text","Obs_evento3","","","","","","",},
                            {"int","cracha_usuario","22","false","text","Cracha_usuario","","","true","","","",}
                          };
    return metadata;
  }

}
