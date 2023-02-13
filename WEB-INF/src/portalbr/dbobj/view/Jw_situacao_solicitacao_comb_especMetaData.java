package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacao_solicitacao_comb_espec
  * @version 07/11/2022 14:24:45
  */
public class Jw_situacao_solicitacao_comb_especMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_situacao","240","false","text","codigo_situacao","","","","","","",},
                            {"java.lang.String","descricao_situacao","240","false","text","descricao_situacao","","","","","","",},
                            {"java.lang.String","rv_high_value","240","false","text","rv_high_value","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rv_low_value codigo_situacao, rv_meaning descricao_situacao, rv_high_value   FROM cg_ref_codes  WHERE rv_domain = 'SITUACAO_SOLICITACAO_COMB_ESPEC'  ORDER BY to_number(rv_high_value)";
    return query;
  }

}
