package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_processa_cod_barra
  * @version 26/02/2018 09:23:10
  */
public class Prc_processa_cod_barraMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_PROCESSA_COD_BARRA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_codigo_barra","100","in","text","P_codigo_barra","","","","","","",},
                            {"java.lang.String","p_setor","100","in","text","P_setor","","","","","","",},
                            {"java.lang.String","p_usuario","100","inout","text","P_usuario","","","","","","",},
                            {"java.lang.Integer","p_rem_nro","22","out","text","P_rem_nro","","","true","","","",},
                            {"java.lang.Integer","p_tal_nro","22","out","text","P_tal_nro","","","true","","","",},
                            {"java.lang.String","p_set_cdgo","100","out","text","P_set_cdgo","","","","","","",},
                            {"java.lang.String","p_mensagem","2000","out","text","P_mensagem","","","","","","",}
                          };
    return metadata;
  }

}
