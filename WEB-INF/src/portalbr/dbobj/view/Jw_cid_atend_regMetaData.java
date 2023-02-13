package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cid_atend_reg
  * @version 16/05/2014 08:36:48
  */
public class Jw_cid_atend_regMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","cidade","65","false","text","cidade","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT res.codigo_regional      ,(ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade  FROM resumo_ped res      ,ecl      ,esc WHERE ecl.cli_cdgo = res.cli_cdgo   AND ecl.ned_cdgo IN ('COB', 'UNI')   AND esc.cli_cdgo(+) = ecl.cli_cdgo   AND esc.esc_seqn(+) = ecl.esc_seqn   AND esc.esc_situacao(+) = 'A' GROUP BY res.codigo_regional         ,(ecl.ecl_cdad || ' - ' || ecl.est_unifed)";
    return query;
  }

}
