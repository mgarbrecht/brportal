package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_ref_cab_exp0400
  * @version 03/04/2013 09:23:46
  */
public class Jw_lv_ref_cab_exp0400MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cab_cdgo","10","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","35","false","text","cab_desc","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","","","","","","","",},
                            {"java.lang.String","lin_cdgo","10","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","ref_cdgo","10","false","text","ref_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rcab.cab_cdgo        ,cabe.cab_desc        ,dies.descricao       ,rcab.lin_cdgo       ,rcab.ref_cdgo   FROM ref_cab rcab       ,dom_item_estoque dies       ,cabedal cabe  WHERE dies.lin_cdgo = rcab.lin_cdgo    AND dies.ref_cdgo = rcab.ref_cdgo    AND dies.cab_cdgo = rcab.cab_cdgo    AND cabe.cab_cdgo = rcab.cab_cdgo    AND (1=2 or rcab.rfb_status = 'A')  ORDER BY 1";
    return query;
  }

}
