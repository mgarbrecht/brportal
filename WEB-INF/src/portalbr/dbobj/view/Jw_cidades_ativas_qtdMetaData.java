package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cidades_ativas_qtd
  * @version 16/05/2014 08:39:54
  */
public class Jw_cidades_ativas_qtdMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cidades_ativas_qtd","22","false","text","cidades_ativas_qtd","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT COUNT(DISTINCT ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidades_ativas_qtd  FROM ecl      ,cliente_representante cr      ,rep r      ,representante_marca rm      ,cli c WHERE ecl.ned_cdgo IN ('COB', 'UNI')   AND ecl.cli_cdgo = cr.codigo_cliente   AND cr.codigo_representante = r.rep_cdgo   AND r.rep_cdgo = rm.codigo_representante   AND c.cli_cdgo = cr.codigo_cliente   AND cr.codigo_sequencial = ecl.esc_seqn   AND r.rep_situ = 'A'   AND rm.situacao = 'A'   AND c.cli_situ = 'A'";
    return query;
  }

}
