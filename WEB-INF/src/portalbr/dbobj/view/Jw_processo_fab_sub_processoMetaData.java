package portalbr.dbobj.view;

/** DataBase Object from table .Jw_processo_fab_sub_processo
  * @version 17/08/2015 09:53:33
  */
public class Jw_processo_fab_sub_processoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pro_numero","22","false","text","pro_numero","","","","","","",},
                            {"java.lang.Integer","pro_numero_sub_processo","22","false","text","pro_numero_sub_processo","","","","","","",},
                            {"java.lang.String","pro_nome","100","false","text","pro_nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ps.pro_numero       ,ps.pro_numero_sub_processo       ,pck_processo_fab.get_nome(ps.pro_numero_sub_processo) pro_nome   FROM processo_fab_sub_processo ps order by pro_numero_sub_processo";
    return query;
  }

}
