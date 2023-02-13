package portalbr.dbobj.view;

/** DataBase Object from table .Jw_processo_fab_sub_processo 
  * @version 17/08/2015 09:46:34
  */
public class Jw_processo_fab_sub_processo MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","PRO_NUMERO","22","false","text","","","","","","","",},
                            {"java.lang.Integer","PRO_NUMERO_SUB_PROCESSO","22","false","text","","","","","","","",},
                            {"java.lang.String","PRO_NOME","100","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ps.pro_numero       ,ps.pro_numero_sub_processo       ,pck_processo_fab.get_nome(ps.pro_numero_sub_processo) pro_nome   FROM processo_fab_sub_processo ps  WHERE ps.pro_numero = 3 order by pro_numero_sub_processo";
    return query;
  }

}
