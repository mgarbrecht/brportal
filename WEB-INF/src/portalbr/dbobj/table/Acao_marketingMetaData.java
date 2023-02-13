package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing
  * @version 21/08/2013 11:05:18
  */
public class Acao_marketingMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"SEQ_ACAO_MKT"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MARKETING";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","seq_acao_mkt","22","true","text","Seq_acao_mkt","","","true","","","",},
                            {"java.lang.Integer","rep_cdgo","5","false","text","Rep_cdgo","","","true","","","",},
                            {"java.lang.Integer","gre_grupo","6","false","text","Gre_grupo","","","true","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","esc_seqn","4","false","text","Esc_seqn","","","true","","","",},
                            {"java.lang.Integer","cdgo_tmidia","2","false","text","Cdgo_tmidia","","","true","","","",},
                            {"java.lang.String","especificacao_tmidia","100","false","text","Especificacao_tmidia","","","","","","",},
                            {"java.lang.String","imagem_tmidia","100","false","text","Imagem_tmidia","","","","","","",},
                            {"java.lang.Double","qtde_tmidia","22","false","text","Qtde_tmidia","","##,##0.00","true","","","",},
                            {"java.lang.Double","valor_tmidia","11","false","text","Valor_tmidia","","##,##0.00","true","","","",},
                            {"java.lang.String","obs_acao_mkt","4000","false","text","Obs_acao_mkt","","","","","","",},
                            {"java.lang.String","situacao_acao_mkt","1","false","text","Situacao_acao_mkt","","","","","","",},
                            {"java.lang.Integer","codigo_marca","3","false","text","Codigo_marca","","","true","","","",},
                            {"java.lang.Double","oco_numero","22","false","text","Oco_numero","","##,##0.00","true","","","",},
                            {"java.lang.String","area","1","false","text","Area","","","","","","",},
                            {"java.lang.String","periodo","6","false","text","Periodo","","","","","","",},
                            {"java.lang.Integer","codigo_regional","3","false","text","Codigo_regional","","","true","","","",},
                            {"java.lang.Integer","for_codigo","9","false","text","For_codigo","","","true","","","",},
                            {"java.lang.Integer","fen_seq","4","false","text","Fen_seq","","","true","","","",},
                            {"java.sql.Date","prazo_final","10","false","text","Prazo_final","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Integer","nro_horas_apos_cadastro","3","false","text","Nro_horas_apos_cadastro","","","true","","","",},
                            {"java.lang.Integer","nro_horas_antes_vcto","3","false","text","Nro_horas_antes_vcto","","","true","","","",},
                            {"java.lang.String","email","60","true","text","Email","","","","","","",},
                            {"java.sql.Date","data_transacao","10","true","text","Data_transacao","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario_transacao","60","true","text","Usuario_transacao","","","","","","",}
                          };
    return metadata;
  }

}
