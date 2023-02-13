package portalbr.dbobj.table;

/** DataBase Object from table CPR.Atelier_pre_envio_quarterizado
  * @version 02/07/2015 08:41:23
  */
public class Atelier_pre_envio_quarterizadoMetaData {

  public static final String SCHEMA = "CPR";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"FOR_CODIGO","FOR_CODIGO_QUARTERIZADO","FEN_SEQ_QUARTERIZADO","PRO_NUMERO","REM_NRO","TAL_NRO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ATELIER_PRE_ENVIO_QUARTERIZADO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","9","true","text","For_codigo","","","true","","","",},
                            {"java.lang.Integer","for_codigo_quarterizado","9","true","text","For_codigo_quarterizado","","","true","","","",},
                            {"java.lang.Integer","fen_seq_quarterizado","4","true","text","Fen_seq_quarterizado","","","true","","","",},
                            {"java.lang.Integer","pro_numero","3","true","text","Pro_numero","","","true","","","",},
                            {"java.sql.Timestamp","data_envio","19","false","text","Data_envio","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","data_retorno","19","false","text","Data_retorno","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","rem_nro","22","true","text","Rem_nro","","","true","","","",},
                            {"java.lang.Integer","tal_nro","4","true","text","Tal_nro","","","true","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",},
                            {"java.lang.String","usuario_inclusao","50","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","50","false","text","Usuario_alteracao","","","","","","",}
                          };
    return metadata;
  }

}
