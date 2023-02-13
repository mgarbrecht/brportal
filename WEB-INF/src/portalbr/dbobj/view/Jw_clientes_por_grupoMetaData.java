package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_por_grupo
  * @version 03/04/2013 09:42:59
  */
public class Jw_clientes_por_grupoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","data_ultima_compra","10","false","text","data_ultima_compra","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT cli.cli_cdgo,  cli.cli_nome,  cli.cli_rzao,  to_char(MAX(rp.data_dig),'dd/mm/yyyy')data_ultima_compra  FROM CLIENTE_REPRESENTANTE CLRE,  GRUPO_ECONOMICO GREC,  REPRESENTANTE_MARCA REMA,  REP REPR,  REGIONAIS_VENDAS REVE,  MARCAS_PRODUTOS MAPR,  cli,  resumo_ped rp  WHERE CLRE.CODIGO_REPRESENTANTE=REPR.REP_CDGO   AND CLRE.SITUACAO='A' AND  repr.rep_cdgo='54' AND  grec.gre_grupo=163 AND  cli.cli_cdgo=clre.codigo_cliente AND  GREC.CLI_CDGO=CLRE.CODIGO_CLIENTE AND  REMA.CODIGO_REPRESENTANTE=REPR.REP_CDGO AND REMA.SITUACAO='A' AND  REVE.CODIGO_REGIONAL=REPR.CODIGO_REGIONAL AND  MAPR.CODIGO_MARCA=REMA.MARCA_PRODUTO  AND rp.cli_cdgo=cli.cli_cdgo GROUP BY   cli.cli_cdgo,  cli.cli_nome,  cli.cli_rzao";
    return query;
  }

}
