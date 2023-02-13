package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cad
  * @version 23/05/2014 11:45:33
  */
public class Jw_clientes_cadMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","est_unifed","2","false","text","est_unifed","","","","","","",},
                            {"java.lang.String","ecl_cdad","60","false","text","ecl_cdad","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","esc_email","100","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","esc_cgc","40","false","text","esc_cgc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct cli_rzao, cli_nome, c.est_unifed, ecl_cdad, b.esc_seqn, a.cli_cdgo, r.rep_cdgo, r.rep_rzao, rv.codigo_regional, rv.Nome_Regional   ,b.esc_email, b.esc_cgc from cli a, esc b, ecl c, cliente_representante cr, rep r, regionais_vendas rv where b.esc_seqn=c.esc_seqn AND rv.codigo_regional=r.codigo_regional AND a.cli_cdgo=b.cli_cdgo AND b.cli_cdgo=c.cli_cdgo AND b.cli_cdgo=cr.codigo_cliente AND b.esc_seqn=cr.codigo_sequencial AND(c.ned_cdgo='UNI' or c.ned_cdgo='ENT')AND cr.codigo_representante=r.rep_cdgo AND r.rep_cdgo=38 AND a.cli_rzao like 'Z%'";
    return query;
  }

}
