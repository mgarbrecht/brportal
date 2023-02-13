package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lov_cabedal
  * @version 03/04/2013 09:24:37
  */
public class Jw_lov_cabedalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cab_cdgo","21","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","35","false","text","cab_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT rc.cab_cdgo,  c.cab_desc  FROM ref_cab rc,  cabedal c  WHERE c.cab_cdgo=rc.cab_cdgo  AND rc.lin_cdgo=nvl(NULL,rc.lin_cdgo)  AND rc.ref_cdgo=nvl(NULL,rc.ref_cdgo)  AND c.cab_cdgo>=0";
    return query;
  }

}
