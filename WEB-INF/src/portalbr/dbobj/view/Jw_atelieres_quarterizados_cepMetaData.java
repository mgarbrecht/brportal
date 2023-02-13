package portalbr.dbobj.view;

/** DataBase Object from table .Jw_atelieres_quarterizados_cep
  * @version 14/01/2015 09:39:58
  */
public class Jw_atelieres_quarterizados_cepMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rua","60","false","text","rua","","","","","","",},
                            {"java.lang.String","cidade","60","false","text","cidade","","","","","","",},
                            {"java.lang.String","bairro","30","false","text","bairro","","","","","","",},
                            {"java.lang.String","uf","2","false","text","uf","","","","","","",},
                            {"java.lang.String","cep1","8","false","text","cep1","","","","","","",},
                            {"double","cep2","22","false","text","cep2","","","","","","",},
                            {"java.lang.String","tipo","10","false","text","tipo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT SUBSTR(a.nome_log, 1, DECODE(INSTR(a.nome_log, ' - '), 0, 41, INSTR(a.nome_log, ' - ')) - 1) rua                ,a.local_log cidade                ,a.bairro_1_log bairro                ,a.uf_log uf                ,a.cep8_log cep1                ,a.cep_log cep2                ,a.tipo_log tipo                  FROM estados b       ,cep_logradouros a  WHERE (a.cep8_log = TO_CHAR(TO_NUMBER(93542388)) OR a.cep_log = TO_NUMBER(93542388))    AND a.uf_log = b.est_unifed";
    return query;
  }

}
