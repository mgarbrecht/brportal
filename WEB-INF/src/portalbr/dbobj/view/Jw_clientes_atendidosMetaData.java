package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atendidos
  * @version 25/03/2020 14:48:43
  */
public class Jw_clientes_atendidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","10","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_nome","10","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_rzao","10","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cidade","10","false","text","cidade","","","","","","",},
                            {"java.sql.Timestamp","cli_dult","22","false","text","cli_dult","","dd/MM/yyyy","","","","",},
                            {"int","pares","22","false","text","pares","","","","","","",},
                            {"double","valor","22","false","text","valor","","","","","","",},
                            {"int","pares_recolocado","22","false","text","pares_recolocado","","","","","","",},
                            {"double","valor_recolocado","22","false","text","valor_recolocado","","","","","","",},
                            {"java.lang.String","email","10","false","text","email","","","","","","",},
                            {"java.lang.Double","saldo","22","false","text","Saldo","","","","","","",},
                            {"java.lang.Double","limite_credito","22","false","text","Limite Crédito","","","","","","",},
                            {"java.lang.String","fones","200","false","text","fones","","","","","","",},
                            {"int","quantidade_meses","22","false","text","quantidade_meses","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select '' cli_cdgo,   '' cli_nome,   '' cli_rzao,   '' cidade,  sysdate cli_dult,   0 pares,   0 valor, 0 pares_recolocado, 0 valor_recolocado, '' email, 0 saldo, 0 limite_credito, '' fones, 0 quantidade_meses  from dual";
    return query;
  }

}
