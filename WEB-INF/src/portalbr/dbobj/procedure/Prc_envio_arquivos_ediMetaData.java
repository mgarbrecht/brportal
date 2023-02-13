package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_envio_arquivos_edi
  * @version 01/06/2011 15:55:28
  */
public class Prc_envio_arquivos_ediMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_ENVIO_ARQUIVOS_EDI";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_tipo","10","in","text","P_tipo","","","","","","",},
                            {"java.lang.String","p_filial","10","in","text","P_filial","","","","","","",},
                            {"java.sql.Date","p_data","19","in","text","P_data","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","p_erro","10","out","text","P_erro","","","","","","",}
                          };
    return metadata;
  }

}
