package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_sem_representante
  * @version 16/05/2014 09:04:47
  */
public class Jw_clientes_sem_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","endereco","81","false","text","endereco","","","","","","",},
                            {"java.lang.String","ecl_cdad","60","false","text","ecl_cdad","","","","","","",},
                            {"java.lang.String","uf","2","false","text","uf","","","","","","",},
                            {"java.lang.String","est_descri","30","false","text","est_descri","","","","","","",},
                            {"java.lang.String","bairro","30","false","text","bairro","","","","","","",},
                            {"java.lang.String","cep","9","false","text","cep","","","","","","",},
                            {"java.lang.String","email","100","false","text","email","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT c.cli_cdgo               ,esc.esc_seqn               ,c.cli_rzao               ,(l.ecl_nome || ', ' || l.ecl_nmro || ' ' || l.ecl_cpto) endereco               ,l.ecl_cdad               ,l.est_unifed uf               ,e.est_descri               ,l.ecl_bair bairro               ,SUBSTR(l.ecl_cep, 1, 5) || '-' || SUBSTR(l.ecl_cep, 6, 8) cep               ,esc.esc_email email  FROM ecl l      ,esc      ,cli c      ,cliente_representante cr      ,estados e WHERE c.cli_cdgo = l.cli_cdgo   AND c.cli_cdgo = cr.codigo_cliente(+)   AND l.esc_seqn = esc.esc_seqn   AND c.cli_cdgo = esc.cli_cdgo   AND l.ned_cdgo IN ('UNI', 'ENT')   AND c.cli_situ = 'A'   AND cr.codigo_cliente IS NULL   AND e.est_unifed = l.est_unifed ORDER BY e.est_descri         ,esc.esc_seqn";
    return query;
  }

}
