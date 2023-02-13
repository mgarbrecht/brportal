package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_lin_exp0400
  * @version 03/04/2013 09:24:06
  */
public class Jw_lv_lin_exp0400MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_cdgo","10","false","text","Lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","Lin_nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select    lin_cdgo   ,lin_nome from lin  where (1=1 or situacao = 'A') order by 1";
    return query;
  }

}
