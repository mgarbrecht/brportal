package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tmp_mapa_diario_msn
  * @version 19/07/2016 10:52:04
  */
public class Jw_tmp_mapa_diario_msnMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","texto","300","false","text","texto","","","","","","",},
                            {"int","ordem","10","false","text","ordem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT texto      ,ordem  FROM (SELECT to_char(data) texto              ,0 ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto1 texto              ,1      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto2 texto              ,2      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto3 texto              ,3      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto4 texto              ,4      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto5 texto              ,5      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto6 texto              ,6      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto7 texto              ,7      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto8 texto              ,8      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto9 texto              ,9      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto10 texto              ,10      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto11 texto              ,11      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto12 texto              ,12      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto13 texto              ,13      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto14 texto              ,14      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto15 texto              ,15      ordem          FROM brger.tmp_mapa_diario_msn        UNION        SELECT texto16 texto              ,16      ordem          FROM brger.tmp_mapa_diario_msn) ORDER BY ordem";
    return query;
  }

}
