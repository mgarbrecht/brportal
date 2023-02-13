package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_notas_fiscais_linhas
  * @version 03/04/2013 09:38:46
  */
public class Jw_consulta_notas_fiscais_linhasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","linha","22","false","text","linha","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select lin_cdgo linha, nfs_nmro, fil_filial, emp_empresa, nfs_serie  from nf_item   where nfi_seqitem=1  and nfs_nmro=44494  and fil_filial='12'  and nfs_serie='00'";
    return query;
  }

}
