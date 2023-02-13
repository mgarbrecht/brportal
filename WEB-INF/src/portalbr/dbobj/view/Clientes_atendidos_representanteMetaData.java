package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_atendidos_representante
  * @version 15/05/2014 17:14:05
  */
public class Clientes_atendidos_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cidade","65","false","text","cidade","","","","","","",},
                            {"java.sql.Timestamp","cli_dult","22","false","text","cli_dult","","dd/MM/yyyy","","","","",},
                            {"int","pares","22","false","text","pares","","","","","","",},
                            {"double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cli.cli_cdgo      ,cli.cli_nome      ,cli.cli_rzao      ,ecl.ecl_cdad || ' - ' || ecl.est_unifed cidade      ,cli.cli_dult      ,NVL(SUM(res.pares), 0) pares      ,NVL(SUM(res.valor), 0) valor  FROM resumo_ped res      ,cli      ,ecl      ,esc WHERE cli.cli_cdgo = res.cli_cdgo   AND ecl.cli_cdgo = cli.cli_cdgo   AND ecl.ned_cdgo IN ('COB', 'UNI')   AND esc.cli_cdgo(+) = ecl.cli_cdgo   AND esc.esc_seqn(+) = ecl.esc_seqn   AND esc.esc_situacao(+) = 'A' GROUP BY cli.cli_cdgo         ,cli.cli_nome         ,cli.cli_rzao         ,ecl.ecl_cdad || ' - ' || ecl.est_unifed         ,cli.cli_dult";
    return query;
  }

}
