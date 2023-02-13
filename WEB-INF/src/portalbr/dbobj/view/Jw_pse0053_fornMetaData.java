package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_forn
  * @version 03/04/2013 09:14:53
  */
public class Jw_pse0053_fornMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fil_filial","10","false","text","","","","","","","",},
                            {"int","for_codigo","22","false","text","","","","","","","",},
                            {"int","pro_numero","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT pck_remessa.get_filial(rem_nro) fil_filial                    ,for_codigo                    ,pro_numero       FROM atelier_pre_envio      WHERE data_pre_envio >= to_date('03082009','ddmmyyyy')        AND data_pre_envio < to_date('02092009','ddmmyyyy') + 1        AND ('16' IS NULL OR fil_filial = '16')        AND (('E' = 'E' AND status IS NULL) OR ('E' = 'R' AND status_retorno = 'C'))";
    return query;
  }

}
