package portalbr.dbobj.procedure;

/** DataBase Object from table BRIO.Prc_send_email_job
  * @version 05/07/2010 07:00:42
  */
public class Prc_send_email_jobMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_SEND_EMAIL_JOB";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_module_name","100","in","text","P_module_name","","","","","","",},
                            {"java.lang.String","p_from","100","in","text","P_from","","","","","","",},
                            {"java.lang.String","p_to","100","in","text","P_to","","","","","","",},
                            {"java.lang.String","p_subject","200","in","text","P_subject","","","","","","",},
                            {"java.lang.String","p_message_body","4000","in","text","P_message_body","","","","","","",},
                            {"java.lang.String","p_message_style","10","in","text","P_message_style","","","","","","",},
                            {"java.lang.String","p_error","4000","out","text","P_error","","","","","","",},
                            {"java.lang.String","p_send_error_to","4000","in","text","P_send_error_to","","","","","","",}
                          };
    return metadata;
  }

}
