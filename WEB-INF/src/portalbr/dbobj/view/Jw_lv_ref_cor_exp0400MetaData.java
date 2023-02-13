package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_ref_cor_exp0400
  * @version 03/04/2013 09:23:33
  */
public class Jw_lv_ref_cor_exp0400MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cor_cdgo","10","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","60","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","lin_cdgo","10","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","ref_cdgo","10","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","cab_cdgo","10","false","text","cab_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rcor.cor_cdgo       ,cors.cor_desc       ,rcor.lin_cdgo       ,rcor.ref_cdgo       ,rcor.cab_cdgo   FROM ref_cor rcor       ,cor cors  WHERE cors.cor_cdgo = rcor.cor_cdgo    AND (1=2 or rcor.rfc_status = 'A')  ORDER BY 1";
    return query;
  }

}
