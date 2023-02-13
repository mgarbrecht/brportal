package portalbr.dbobj.view;

/** DataBase Object from table .Jw_conhecimentos_fretes
  * @version 25/01/2017 15:26:52
  */
public class Jw_conhecimentos_fretesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","3","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.sql.Date","data_ocorrencia","22","false","text","data_ocorrencia","","","","","","",},
                            {"java.lang.Integer","mot_codigo","22","false","text","mot_codigo","","","","","","",},
                            {"java.lang.String","descricao","400","false","text","descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT emp_empresa      ,fil_filial      ,nfs_nmro      ,nfs_serie      ,data_ocorrencia      ,mot_codigo      ,descricao  FROM conhecimentos_fretes_oco_vw ORDER BY data_ocorrencia DESC         ,mot_codigo";
    return query;
  }

}
