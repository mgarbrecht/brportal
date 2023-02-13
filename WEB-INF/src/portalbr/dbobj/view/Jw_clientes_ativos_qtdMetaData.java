package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ativos_qtd
  * @version 16/05/2014 08:46:57
  */
public class Jw_clientes_ativos_qtdMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ativos_qtd","22","false","text","ativos_qtd","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT COUNT(DISTINCT cli.cli_cdgo) ativos_qtd  FROM rep      ,cliente_representante clr      ,cli      ,representante_marca rm WHERE clr.codigo_representante = rep.rep_cdgo   AND cli.cli_cdgo = clr.codigo_cliente   AND cli.cli_situ = 'A'   AND rep.rep_situ = 'A'   AND rm.situacao = 'A'   AND rm.codigo_representante = rep.rep_cdgo";
    return query;
  }

}
