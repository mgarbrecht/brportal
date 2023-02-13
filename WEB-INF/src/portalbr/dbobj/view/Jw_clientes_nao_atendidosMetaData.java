package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_nao_atendidos
  * @version 24/03/2014 09:46:33
  */
public class Jw_clientes_nao_atendidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","10","false","text","","","","","","","",},
                            {"java.lang.String","cli_nome","50","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","","","","","","","",},
                            {"java.lang.String","cnpj","15","false","text","","","","","","","",},
                            {"java.lang.String","cidade","20","false","text","","","","","","","",},
                            {"java.lang.String","endereco","50","false","text","","","","","","","",},
                            {"java.sql.Timestamp","cli_dult","12","false","text","","","","","","","",},
                            {"java.lang.String","email","20","false","text","email","","","","","","",},
                            {"java.lang.Double","saldo","22","false","text","Saldo","","","","","","",},
                            {"java.lang.Double","limite_credito","22","false","text","Limite Crédito","","","","","","",},
                            {"java.lang.String","fones","200","false","text","fones","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' cli_cdgo        ,'' cli_nome        ,'' cli_rzao        ,'' cnpj        ,'' cidade        ,'' endereco		,'' email		,0 saldo		,0 limite_credito        ,SYSDATE cli_dult		,'' fones    FROM dual";
    return query;
  }

}
