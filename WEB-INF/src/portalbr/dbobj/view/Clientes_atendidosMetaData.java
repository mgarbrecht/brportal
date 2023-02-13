package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_atendidos
  * @version 15/05/2014 17:09:56
  */
public class Clientes_atendidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"int","pares","22","false","text","pares","","","","","","",},
                            {"double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cli.cli_cdgo      ,cli.cli_nome      ,cli.cli_rzao      ,NVL(SUM(res.pares), 0) pares      ,NVL(SUM(res.valor), 0) valor  FROM resumo_ped res      ,cli WHERE cli.cli_cdgo = res.cli_cdgo GROUP BY cli.cli_cdgo         ,cli.cli_nome         ,cli.cli_rzao";
    return query;
  }

}
