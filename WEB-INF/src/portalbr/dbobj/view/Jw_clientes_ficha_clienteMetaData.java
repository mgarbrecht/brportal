package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_cliente
  * @version 03/04/2013 09:45:41
  */
public class Jw_clientes_ficha_clienteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","gre_grupo","22","false","text","gre_grupo","","","","","","",},
                            {"java.lang.String","gre_descricao","50","false","text","gre_descricao","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cnpj","20","false","text","cnpj","","","","","","",},
                            {"java.lang.String","cidade","80","false","text","cidade","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT c.cli_cdgo       ,e.esc_seqn       ,c.cli_rzao       ,fct_formata_cnpj(e.esc_cgc) cnpj       ,l.ecl_cdad || ' - ' || l.est_unifed cidade   FROM ped p       ,rep r       ,ite i       ,cli c       ,esc e       ,ecl l       ,regionais_vendas rv       ,grupo_economico ge  WHERE p.ped_nmro = i.ped_nmro    AND p.cli_cdgo = c.cli_cdgo    AND e.esc_seqn = p.esc_seqn    AND e.cli_cdgo = p.cli_cdgo    AND r.rep_cdgo = p.rep_cdgo    AND l.cli_cdgo = e.cli_cdgo    AND l.esc_seqn = e.esc_seqn    AND rv.codigo_regional = r.codigo_regional    AND ge.cli_cdgo = c.cli_cdgo    AND l.ned_cdgo IN ('COB', 'UNI')    AND p.cli_cdgo = 5403    AND p.ped_daem > '01-jan-2011'    AND p.ped_substituicao <> 'S'    AND p.ped_stat <> 'C'    AND p.ped_amostra_brinde IS NULL";
    return query;
  }

}
