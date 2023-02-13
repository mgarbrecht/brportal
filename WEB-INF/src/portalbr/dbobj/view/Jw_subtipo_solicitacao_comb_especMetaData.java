package portalbr.dbobj.view;

/** DataBase Object from table .Jw_subtipo_solicitacao_comb_espec
  * @version 15/08/2019 08:33:35
  */
public class Jw_subtipo_solicitacao_comb_especMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_tipo","240","false","text","codigo_tipo","","","","","","",},
                            {"java.lang.String","descricao_tipo","240","false","text","descricao_tipo","","","","","","",},
                            {"java.lang.String","codigo_subtipo","240","false","text","codigo_subtipo","","","","","","",},
                            {"java.lang.String","descricao_subtipo","240","false","text","descricao_subtipo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cgt.rv_low_value codigo_tipo        ,cgt.rv_meaning   descricao_tipo        ,cgs.rv_low_value codigo_subtipo        ,cgs.rv_meaning descricao_subtipo    FROM cg_ref_codes cgt       , cg_ref_codes cgs   WHERE cgt.rv_domain = 'TIPO_SOLICITACAO_COMB_ESPECIAL'     and cgs.rv_domain = 'SUBTIPO_SOLICITACAO_COMB_ESPEC'     AND cgt.rv_low_value IN ('1', '2', '3', '5', '13')     and cgs.rv_high_value = cgt.rv_low_value   ORDER BY to_number(cgt.rv_low_value)          , to_number(cgs.rv_low_value)";
    return query;
  }

}
