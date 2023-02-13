package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cad_dados_clientes
  * @version 16/05/2014 08:54:05
  */
public class Jw_clientes_cad_dados_clientesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","endereco","95","false","text","endereco","","","","","","",},
                            {"java.lang.String","cgc","19","false","text","cgc","","","","","","",},
                            {"java.lang.String","inscricao","18","false","text","inscricao","","","","","","",},
                            {"java.lang.String","pessoa","35","false","text","pessoa","","","","","","",},
                            {"java.lang.String","classificacao","3","false","text","classificacao","","","","","","",},
                            {"java.lang.String","ind_prote","3","false","text","ind_prote","","","","","","",},
                            {"java.lang.String","nro_dias_prote","22","false","text","nro_dias_prote","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT e.ecl_nome || ', ' || e.ecl_nmro || ' - ' || DECODE(ecl_cpto, NULL, '', ecl_cpto || ' - ') || SUBSTR(e.ecl_cep, 1, 5) || '-' || SUBSTR(e.ecl_cep, 6, 3) endereco      ,SUBSTR(TO_CHAR(s.esc_cgc, '00000000000000'), 0, 3) || '.' || SUBSTR(TO_CHAR(s.esc_cgc, '00000000000000'), 4, 3) || '.' || SUBSTR(TO_CHAR(s.esc_cgc, '00000000000000'), 7, 3) || '/' || SUBSTR(TO_CHAR(s.esc_cgc, '00000000000000'), 10, 4) || '-' || SUBSTR(TO_CHAR(s.esc_cgc, '00000000000000'), 14, 2) cgc      ,s.esc_inse inscricao      ,p.pec_nome pessoa      ,DECODE(NVL(c.classificacao, '@'), 'C', 'SIM', 'NÃO') classificacao      ,esc_indic_prote ind_prote      ,esc_num_dias_prote nro_dias_prote  FROM ecl e      ,esc s      ,pec p      ,parametros_cobranca_cliente c WHERE e.cli_cdgo = s.cli_cdgo   AND e.esc_seqn = s.esc_seqn   AND p.cli_cdgo(+) = e.cli_cdgo   AND p.esc_seqn(+) = e.esc_seqn   AND e.cli_cdgo = c.cli_cdgo   AND e.esc_seqn = c.esc_seqn   AND (e.ned_cdgo = 'UNI' OR e.ned_cdgo = 'ENT')";
    return query;
  }

}
