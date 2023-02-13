package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_bloqueios
  * @version 16/05/2014 08:52:51
  */
public class Jw_clientes_bloqueiosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","codigo_bloqueio","22","false","text","codigo_bloqueio","","","","","","",},
                            {"java.lang.String","descricao_bloqueio","50","false","text","descricao_bloqueio","","","","","","",},
                            {"java.sql.Timestamp","data_inclusao","22","false","text","data_inclusao","","dd/MM/yyyy HH:mm:ss","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cli_cdgo      ,bloq.blo_codigo_bloqueio codigo_bloqueio      ,blo_descricao_bloqueio descricao_bloqueio      ,cli_bloq.data_inclusao  FROM bloqueio bloq      ,cli_bloqueio cli_bloq WHERE data_inclusao = (SELECT MAX(cb.data_inclusao)                          FROM cli_bloqueio cb                         WHERE cb.cli_cdgo = cli_bloq.cli_cdgo                           AND blo_codigo_bloqueio <> 999)   AND bloq.blo_codigo_bloqueio = cli_bloq.blo_codigo_bloqueio   AND bloq.blo_codigo_bloqueio <> 999   AND cli_bloq.cli_cdgo IN (26733, 29690, 30512, 33832, 44753, 48098, 48099)";
    return query;
  }

}
