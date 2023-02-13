package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_estados
  * @version 03/04/2013 09:24:16
  */
public class Jw_lv_estadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","est_unifed","2","false","text","est_unifed","","","","","","",},
                            {"java.lang.String","est_descri","30","false","text","est_descri","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct l.est_unifed, e.est_descri from ecl l, estados e where e.est_unifed(+)=l.est_unifed and e.est_exportador='N' union select distinct l.est_unifed, e.est_descri from ecl l, estados e where e.est_unifed(+)=l.est_unifed and e.est_exportador='S'";
    return query;
  }

}
