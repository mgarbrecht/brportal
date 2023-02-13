package portalbr.dbobj.view;

/** DataBase Object from table .Jw_atelier_fabricas
  * @version 28/05/2014 13:19:25
  */
public class Jw_atelier_fabricasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","22","false","text","","","","","","","",},
                            {"java.lang.String","for_razsoc","40","false","text","","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","","","","","","","",},
                            {"java.lang.Integer","mfa_codigo","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT v.for_codigo       ,v.for_razsoc       ,f.emp_empresa       ,f.fil_filial       ,f.mfa_codigo   FROM dom_mini_fab_filial f       ,atelier_vw v  WHERE v.for_codigo = f.for_codigo";
    return query;
  }

}
