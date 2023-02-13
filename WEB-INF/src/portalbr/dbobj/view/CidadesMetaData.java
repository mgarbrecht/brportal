package portalbr.dbobj.view;

/** DataBase Object from table .Cidades
  * @version 24/03/2014 10:01:41
  */
public class CidadesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","cidade","65","false","text","","","","","","","",},
                            {"java.lang.String","esc_email","200","false","text","","","","","","","",},
                            {"java.lang.String","fones","200","false","text","fones","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT ecl.cli_cdgo               ,ecl.ecl_cdad || ' - ' || ecl.est_unifed cidade               ,NVL(esc.esc_email, '-') esc_email               ,nvl(rowtocol('SELECT ffs_ddd2 || '' - '' || ffs_nmro2 fone FROM fax_fon2 WHERE cli_cdgo = ' || ecl.cli_cdgo || '  AND esc_seqn = ' || ecl.esc_seqn || '  AND ned_cdgo = ''' || ecl.ned_cdgo || '''  AND cli_cdgo > 0'),'-') fones  FROM ecl      ,esc WHERE ecl.ned_cdgo IN ('ENT', 'UNI')   AND esc.cli_cdgo = ecl.cli_cdgo   AND esc.esc_seqn = ecl.esc_seqn   AND esc.esc_situacao = 'A' ORDER BY 2";
    return query;
  }

}
