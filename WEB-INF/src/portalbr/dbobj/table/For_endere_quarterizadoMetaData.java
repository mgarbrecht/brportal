package portalbr.dbobj.table;

/** DataBase Object from table BRIO.For_endere_quarterizado
  * @version 14/01/2015 08:51:42
  */
public class For_endere_quarterizadoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"FOR_CODIGO","FOR_CODIGO_QUARTERIZADO","FEN_SEQ_QUARTERIZADO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FOR_ENDERE_QUARTERIZADO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","9","true","text","For_codigo","","","true","","","",},
                            {"java.lang.Integer","for_codigo_quarterizado","9","true","text","For_codigo_quarterizado","","","true","","","",},
                            {"java.lang.Integer","fen_seq_quarterizado","4","true","text","Fen_seq_quarterizado","","","true","","","",},
                            {"java.lang.String","est_unifed_quarterizado","2","false","text","Est_unifed_quarterizado","","","","","","",},
                            {"java.lang.String","fen_rua_quarterizado","25","false","text","Fen_rua_quarterizado","","","","","","",},
                            {"java.lang.String","fen_nro_quarterizado","5","false","text","Fen_nro_quarterizado","","","","","","",},
                            {"java.lang.String","fen_compto_quarterizado","10","false","text","Fen_compto_quarterizado","","","","","","",},
                            {"java.lang.String","fen_bairro_quarterizado","30","false","text","Fen_bairro_quarterizado","","","","","","",},
                            {"java.lang.String","fen_cidade_quarterizado","60","false","text","Fen_cidade_quarterizado","","","","","","",},
                            {"java.lang.Integer","fen_cep_quarterizado","8","false","text","Fen_cep_quarterizado","","","true","","","",},
                            {"java.lang.Double","fen_cgc_quarterizado","14","false","text","Fen_cgc_quarterizado","","","true","","","",},
                            {"java.lang.String","fen_insmun_quarterizado","15","false","text","Fen_insmun_quarterizado","","","","","","",},
                            {"java.lang.String","fen_insest_quarterizado","15","false","text","Fen_insest_quarterizado","","","","","","",},
                            {"java.lang.String","fen_ativo_quarterizado","1","false","text","Fen_ativo_quarterizado","","","","","","",},
                            {"java.lang.String","fen_email_quarterizado","100","false","text","Fen_email_quarterizado","","","","","","",},
                            {"java.lang.String","fen_gln_quarterizado","14","false","text","Fen_gln_quarterizado","","","","","","",},
                            {"java.lang.String","tipo_log_quarterizado","10","false","text","Tipo_log_quarterizado","","","","","","",},
                            {"java.lang.String","fen_observacao_quarterizado","100","false","text","Fen_observacao_quarterizado","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","false","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.lang.String","for_razsoc","40","false","text","For_razsoc","","","","","","",},
                            {"java.lang.String","for_fant","40","false","text","For_fant","","","","","","",}
                          };
    return metadata;
  }

}
