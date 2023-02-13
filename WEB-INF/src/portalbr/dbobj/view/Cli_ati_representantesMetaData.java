package portalbr.dbobj.view;

/** DataBase Object from table .Cli_ati_representantes
  * @version 15/05/2014 17:08:09
  */
public class Cli_ati_representantesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_ati","22","false","text","cli_ati","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT NVL(COUNT(DISTINCT(cli.cli_cdgo)), 0) cli_ati      ,rep.rep_cdgo  FROM cliente_representante clr      ,cli      ,rep WHERE clr.codigo_representante = rep.rep_cdgo   AND cli.cli_cdgo = clr.codigo_cliente   AND cli.cli_situ = 'A'   AND rep.rep_situ = 'A'   AND clr.situacao = 'A' GROUP BY rep.rep_cdgo";
    return query;
  }

}
