package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ativos
  * @version 16/05/2014 08:45:58
  */
public class Jw_clientes_ativosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cidade","10","false","text","cidade","","","","","","",},
                            {"java.sql.Timestamp","cli_dult","22","false","text","cli_dult","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","email","10","false","text","email","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT cli.cli_cdgo               ,cli.cli_nome               ,cli.cli_rzao               ,'' cidade               ,cli_dult               ,'' email  FROM rep      ,cliente_representante clr      ,cli      ,representante_marca rm WHERE clr.codigo_representante = rep.rep_cdgo   AND cli.cli_cdgo = clr.codigo_cliente   AND clr.situacao = 'A'   AND rep.rep_situ = 'A'   AND cli.cli_situ = 'A'   AND rm.situacao = 'A'   AND rm.codigo_representante = rep.rep_cdgo ORDER BY cli_cdgo";
    return query;
  }

}
