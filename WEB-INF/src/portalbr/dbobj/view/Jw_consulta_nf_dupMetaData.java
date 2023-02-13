package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_nf_dup
  * @version 02/10/2019 10:37:46
  */
public class Jw_consulta_nf_dupMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","duplicatas","8","false","text","duplicatas","","","","","","",},
                            {"java.lang.String","tip_codigo","3","false","text","tip_codigo","","","","","","",},
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nsa_numero","22","false","text","nsa_numero","","","","","","",},
                            {"java.lang.String","nsa_serie","3","false","text","nsa_serie","","","","","","",},
                            {"java.lang.String","pedido","22","false","text","pedido","","","","","","",},
                            {"java.lang.String","data_vencimento","22","false","text","data_vencimento","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' duplicatas      ,'' tip_codigo      ,0 ped_nmro      ,'' emp_empresa      ,'' fil_filial      ,0 nsa_numero      ,'' nsa_serie      ,0 pedido	  ,'' data_vencimento  FROM dual";
    return query;
  }

}
