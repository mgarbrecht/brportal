package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grade_total_linha
  * @version 03/04/2013 09:12:04
  */
public class Jw_saldo_estoque_grade_total_linhaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"int","gde_cdgo","22","false","text","gde_cdgo","","","","","","",},
                            {"double","total","22","false","text","total","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct  rc.lin_cdgo,  l.gde_cdgo,  sum(l.qtde_atual)total  from ref_cor rc,   cor c,   cabedal ca,  dom_local_item_estoque_gre l,  dom_item_estoque i  where rc.ref_cdgo=nvl(null, rc.ref_cdgo)  and rc.cab_cdgo=nvl(null, rc.cab_cdgo)  and rc.cor_cdgo=c.cor_cdgo   and ca.cab_cdgo=rc.cab_cdgo   and l.ies_codigo=i.codigo   and i.ref_cdgo=rc.ref_cdgo   and i.cab_cdgo=rc.cab_cdgo   and i.lin_cdgo=rc.lin_cdgo  and l.tco_codigo=nvl(1, l.tco_codigo)  and l.cor_cdgo=rc.cor_cdgo   and nvl(i.tipo, null)='A'   and l.tes_codigo in(15,21)  and l.qtde_atual> 0   and i.lin_cdgo=301 group by rc.lin_cdgo, l.gde_cdgo";
    return query;
  }

}
