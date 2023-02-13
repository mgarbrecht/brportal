package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ac_clientes_grupo
  * @version 03/04/2013 09:54:24
  */
public class Jw_ac_clientes_grupoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","gre_descricao","30","false","text","gre_descricao","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","ecl_cdad","60","false","text","ecl_cdad","","","","","","",},
                            {"java.lang.String","est_unifed","2","false","text","est_unifed","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct  ge.gre_descricao ,  cli.cli_cdgo ,  ecl.esc_seqn esc_seqn ,  cli.cli_rzao ,  ecl.ecl_cdad ecl_cdad ,  ecl.est_unifed est_unifed  from cli ,  ecl ,  grupo_economico ge  where cli.cli_cdgo=ge.cli_cdgo  and ecl.cli_cdgo=cli.cli_cdgo  and ge.gre_grupo=(select min(gre_grupo)  from grupo_economico  where cli_cdgo=6678)  and cli.cli_cdgo=6678";
    return query;
  }

}
