package portalbr.dbobj.view;

/** DataBase Object from table .Cli_ati_regionais
  * @version 03/04/2013 10:05:04
  */
public class Cli_ati_regionaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_ati","22","false","text","cli_ati","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select count(distinct(cli.cli_cdgo))cli_ati, rep.codigo_regional from rep , cliente_representante clr , cli where rep.codigo_regional>0 and rep.rep_situ='A' and clr.codigo_representante=rep.rep_cdgo and clr.situacao='A' and cli.cli_cdgo=clr.codigo_cliente and cli.cli_situ='A' group by rep.codigo_regional";
    return query;
  }

}
