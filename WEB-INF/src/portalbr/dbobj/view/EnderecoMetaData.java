package portalbr.dbobj.view;

/** DataBase Object from table .Endereco
  * @version 03/05/2018 10:07:10
  */
public class EnderecoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","ecl_cdad","60","false","text","ecl_cdad","","","","","","",},
                            {"java.lang.String","cnpj","50","false","text","cnpj","","","","","","",},
                            {"java.lang.String","endereco","100","false","text","endereco","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */         DISTINCT ecl.cli_cdgo                 ,ecl.esc_seqn                 ,ecl.ecl_cdad                 ,esc.esc_cgc cnpj                 ,ecl.ecl_nome || ',' || ecl.ecl_nmro || ', Bairro: ' || ecl.ecl_bair || ' , CEP: ' || ecl.ecl_cep endereco    FROM ecl        ,esc   WHERE ecl.ned_cdgo IN ('COB', 'UNI')     AND esc.cli_cdgo(+) = ecl.cli_cdgo     AND esc.esc_seqn(+) = ecl.esc_seqn     AND esc.esc_situacao(+) = 'A'   ORDER BY ecl.ecl_cdad";
    return query;
  }

}
