package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_lin_ref
  * @version 03/04/2013 09:23:56
  */
public class Jw_lv_lin_refMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.String","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","ref_desc","25","false","text","ref_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct l.lin_cdgo,  l.lin_nome,  r.ref_cdgo,  r.ref_desc  from ref r, lin l  where l.lin_cdgo=r.lin_cdgo  and r.ref_status='A'  and l.situacao='A'  order by 1,3";
    return query;
  }

}
