package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_envia_email_emula_faturas
  * @version 07/10/2010 07:05:05
  */
public class Prc_envia_email_emula_faturasMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_ENVIA_EMAIL_EMULA_FATURAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_numero_pedido","22","in","text","P_numero_pedido","","","true","","","",}
                          };
    return metadata;
  }

}
