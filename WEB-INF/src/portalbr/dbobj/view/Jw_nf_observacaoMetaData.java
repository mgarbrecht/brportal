package portalbr.dbobj.view;

/** DataBase Object from table .Jw_nf_observacao
  * @version 23/05/2014 14:08:52
  */
public class Jw_nf_observacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.lang.String","observacao","4000","false","text","observacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT n.emp_empresa       ,n.fil_filial       ,n.nfs_nmro       ,n.nfs_serie       ,(REPLACE(rowtocol('SELECT texto                    FROM observacoes_nf_saida                   WHERE emp_empresa = ''' || n.emp_empresa || '''                     AND fil_filial = ''' || n.fil_filial || '''                     AND nfs_nmro = ' || n.nfs_nmro || '                     and nfs_serie = ''' || n.nfs_serie || '''                   ORDER BY emp_empresa                          , fil_filial                          , nfs_nmro                          , nfs_serie                          , numero'), ',', '<br>')) observacao   FROM nf_saida n";
    return query;
  }

}
