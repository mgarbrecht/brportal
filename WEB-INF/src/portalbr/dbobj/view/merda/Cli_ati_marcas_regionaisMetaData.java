package portalbr.dbobj.view;

/** DataBase Object from table .Cli_ati_marcas_regionais
  * @version 27/05/2010 11:40:30
  */
public class Cli_ati_marcas_regionaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","CLI_ATI","22","false","text","","","","","","","",},
                            {"java.lang.String","CODIGO_MARCA","22","false","text","","","","","","","",},
                            {"java.lang.String","CODIGO_REGIONAL","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select count(distinct cli.cli_cdgo)cli_ati,   rem.marca_produto codigo_marca,  rep.codigo_regional codigo_regional  from representante_marca rem, rep, cliente_representante clr, cli  where rem.marca_produto>0 and rem.situacao='A' and  rep.rep_cdgo=rem.codigo_representante and rep.rep_situ='A' and  clr.codigo_representante=rep.rep_cdgo and clr.situacao='A' and  cli.cli_cdgo=clr.codigo_cliente and cli.cli_situ='A'  and rep.codigo_regional>0  group by rem.marca_produto,  rep.codigo_regional";
    return query;
  }

}
