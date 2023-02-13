package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cor_compo
  * @version 03/04/2013 09:32:02
  */
public class Jw_cor_compoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","60","false","text","cor_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct c.cor_cdgo, c.cor_desc from cor_compo cr, cor c where c.cor_cdgo=cr.cor_ref";
    return query;
  }

}
