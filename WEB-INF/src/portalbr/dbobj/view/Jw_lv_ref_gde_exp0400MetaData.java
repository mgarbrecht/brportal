package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_ref_gde_exp0400
  * @version 03/04/2013 09:23:12
  */
public class Jw_lv_ref_gde_exp0400MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","gde_cdgo","10","false","text","gde_cdgo","","","","","","",},
                            {"java.lang.String","gde_numi","5","false","text","gde_numi","","","","","","",},
                            {"java.lang.String","gde_numf","5","false","text","gde_numf","","","","","","",},
                            {"java.lang.String","lin_cdgo","10","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","ref_cdgo","10","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","codigo_corrug","10","false","text","ref_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rgde.gde_cdgo       ,grde.gde_numi       ,grde.gde_numf       ,rgde.lin_cdgo       ,rgde.ref_cdgo       ,p.codigo_corrug  FROM ref_gde rgde      ,gre grde      ,peso_corrugados p WHERE grde.gde_cdgo = rgde.gde_cdgo   AND (1 = 1 OR rgde.rfg_status = 'A')   AND p.lin_cdgo = rgde.lin_cdgo   and p.ref_cdgo = rgde.ref_cdgo   and MOD(grde.gde_tota, p.qt_par_corrug) = 0   ORDER BY 1";
    return query;
  }

}
