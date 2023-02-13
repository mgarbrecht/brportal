package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_gde
  * @version 03/04/2013 09:14:00
  */
public class Jw_ref_gdeMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","grade","10","false","text","grade","","","","","","",},
                            {"java.lang.String","no_inicial","5","false","text","no_inicial","","","","","","",},
                            {"java.lang.String","no_final","5","false","text","no_final","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select rgde.gde_cdgo Grade, grde.gde_numi No_inicial, grde.gde_numf No_final from ref_gde rgde, gre grde where grde.gde_cdgo = rgde.gde_cdgo and rgde.rfg_status = 'A' order by 1";
    return query;
  }

}
