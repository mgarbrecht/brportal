package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_solicitacao_comb_espec
  * @version 14/08/2019 16:42:07
  */
public class Jw_tipo_solicitacao_comb_especMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_tipo","240","false","text","codigo_tipo","","","","","","",},
                            {"java.lang.String","descricao_tipo","240","false","text","descricao_tipo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rv_low_value codigo_tipo       ,rv_meaning   descricao_tipo   FROM cg_ref_codes  WHERE rv_domain = 'TIPO_SOLICITACAO_COMB_ESPECIAL'    AND rv_low_value IN ('1', '2', '3', '5', '13')  ORDER BY to_number(rv_high_value)";
    return query;
  }

}
