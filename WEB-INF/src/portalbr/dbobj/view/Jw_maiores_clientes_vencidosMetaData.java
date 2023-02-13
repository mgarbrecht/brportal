package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_vencidos
  * @version 03/04/2013 09:22:53
  */
public class Jw_maiores_clientes_vencidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_regional","22","false","text","","","","","","","",},
                            {"java.lang.String","grupo_economico","100","false","text","","","","","","","",},
                            {"java.lang.String","codigo","22","false","text","","","","","","","",},
                            {"java.lang.String","sequencial","22","false","text","","","","","","","",},
                            {"java.lang.String","fone","10","false","text","","","","","","","",},
                            {"java.lang.String","cliente","35","false","text","","","","","","","",},
                            {"java.lang.String","ecl_cdad","33","false","text","","","","","","","",},
                            {"java.lang.String","dias","22","false","text","","","","","","","",},
                            {"double","valor","22","false","text","","","","","","","",},
                            {"java.lang.String","observacao","1000","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 codigo_regional      ,'' grupo_economico      ,0 codigo      ,0.0 sequencial      ,'' fone      ,'' cliente      ,'' ecl_cdad      ,0 dias      ,0 valor	  ,'' observacao  FROM dual";
    return query;
  }

}
