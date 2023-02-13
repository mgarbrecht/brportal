package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_atendidos_regionais
  * @version 03/04/2013 10:03:47
  */
public class Clientes_atendidos_regionaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cidade","65","false","text","cidade","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct rep.codigo_regional,  cli.cli_cdgo,  cli.cli_nome,  cli.cli_rzao,  ecl.ecl_cdad||' - '||ecl.est_unifed cidade  from rep,   cliente_representante clr,   cli, ecl,   esc  where rep.codigo_regional> 0 and rep.rep_situ='A' and  clr.codigo_representante=rep.rep_cdgo and clr.situacao='A' and  cli.cli_cdgo=clr.codigo_cliente and cli.cli_situ='A' and  ecl.cli_cdgo=cli.cli_cdgo and ecl.ned_cdgo in('COB', 'UNI')and  esc.cli_cdgo(+)=ecl.cli_cdgo and esc.esc_seqn(+)=ecl.esc_seqn and  esc.esc_situacao(+)='A'";
    return query;
  }

}
