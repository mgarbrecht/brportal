package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_envia_email_troca_senha
  * @version 09/02/2011 06:52:50
  */
public class Prc_envia_email_troca_senhaMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_ENVIA_EMAIL_TROCA_SENHA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_usua_id","1000","in","text","P_usua_id","","","","","","",},
                            {"java.lang.String","p_senha","1000","in","text","P_senha","","","","","","",}
                          };
    return metadata;
  }

}
