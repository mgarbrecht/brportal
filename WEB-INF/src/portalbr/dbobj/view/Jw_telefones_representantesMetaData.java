package portalbr.dbobj.view;

/** DataBase Object from table .Jw_telefones_representantes
  * @version 05/07/2010 07:09:05
  */
public class Jw_telefones_representantesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","fone","46","false","text","fone","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select rep_cdgo,to_char(ffs_ddd, '0000')||'-'||ffs_nmro fone from fax_fon where rep_cdgo> 0";
    return query;
  }

}
