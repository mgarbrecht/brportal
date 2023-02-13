package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_grupos_economicos
  * @version 31/10/2019 16:40:32
  */
public class Jw_clientes_grupos_economicosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","gre_grupo","22","false","text","gre_grupo","","","","","","",},
                            {"java.lang.String","gre_descricao","30","false","text","gre_descricao","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_situ","1","false","text","cli_situ","","","","","","",},
                            {"java.lang.String","status","1","false","text","status","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","situacao","","","","","","",},
                            {"java.lang.Integer","codigo_sequencial","22","false","text","codigo_sequencial","","","","","","",},
                            {"java.lang.String","cidade","240","false","text","cidade","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT grec.gre_grupo, grec.gre_descricao, c.cli_cdgo, c.cli_nome, c.cli_rzao, c.cli_situ, grec.status, '' situacao        ,grec.gre_seqn codigo_sequencial, '' cidade   FROM grupo_economico grec, cli c WHERE grec.cli_cdgo=c.cli_cdgo  and grec.status='A' order by 2,4";
    return query;
  }

}
