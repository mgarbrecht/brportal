package portalbr.dbobj.view;

/** DataBase Object from table .Jw_representante_cli_marca
  * @version 25/08/2021 15:03:44
  */
public class Jw_representante_cli_marcaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","4000","false","text","cli_rzao","","","","","","",},
                            {"int","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","rep_cdgo","4000","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","4000","false","text","rep_rzao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT qry.cli_cdgo,       qry.cli_rzao,       qry.codigo_marca,       qry.rep_cdgo,       rep.rep_rzao  FROM (SELECT cli.cli_cdgo,               cli.cli_rzao,               mp.codigo_marca,			   CASE WHEN cli_cdgo <> 40000 THEN               pck_representante.get_rep_by_cli_marca(cli.cli_cdgo,                                                      (SELECT min(codigo_sequencial)                                                      from (                                                        select nvl(cr.codigo_sequencial,99999999) codigo_sequencial                                                        FROM cliente_representante cr, representante_marca rm, rep                                                       WHERE cr.codigo_representante = rm.codigo_representante                                                         AND rm.codigo_representante = rep.rep_cdgo                                                         AND cr.codigo_cliente = cli.cli_cdgo                                                         AND rm.marca_produto = mp.codigo_marca                                                         AND cr.situacao = 'A'                                                         AND rm.situacao = 'A'                                                         AND rep.codigo_tipo_contrato NOT IN (1, 4, 6)                                                         UNION ALL                                                         SELECT cr.codigo_sequencial                                                        FROM cliente_representante cr, representante_marca rm, rep                                                       WHERE cr.codigo_representante = rm.codigo_representante                                                         AND rm.codigo_representante = rep.rep_cdgo                                                         AND cr.codigo_cliente = cli.cli_cdgo                                                         AND rm.marca_produto = mp.codigo_marca                                                         AND cr.situacao = 'A'                                                         AND rm.situacao = 'A'                                                         AND rep.codigo_tipo_contrato = 4                                                         AND rep.rep_cdgo <> 19                                                         AND NOT EXISTS(SELECT cr.codigo_sequencial                                                        FROM cliente_representante cr, representante_marca rm, rep                                                       WHERE cr.codigo_representante = rm.codigo_representante                                                         AND rm.codigo_representante = rep.rep_cdgo                                                         AND cr.codigo_cliente = cli.cli_cdgo                                                         AND rm.marca_produto = mp.codigo_marca                                                         AND cr.situacao = 'A'                                                         AND rm.situacao = 'A'                                                         AND rep.codigo_tipo_contrato NOT IN (1, 4, 6)))														 ),                                                      mp.codigo_marca) else '19' end rep_cdgo          FROM cli, marcas_produtos mp         WHERE mp.status = 'A'           AND cli.cli_situ = 'A') qry,       rep WHERE rep.rep_cdgo = qry.rep_cdgo";
    return query;
  }

}
