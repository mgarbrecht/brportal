package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_marca
  * @version 13/02/2020 14:34:56
  */
public class Clientes_marcaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","marca","34","false","text","marca","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.sql.Date","mes","34","false","text","mes","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","clientes_ativos","22","false","text","clientes_ativos","","","","","","",},
                            {"java.lang.Integer","grupos_ativos","22","false","text","grupos_ativos","","","","","","",},
                            {"java.lang.Integer","grupos_atendidos","22","false","text","grupos_atendidos","","","","","","",},
                            {"java.lang.Integer","grupos_nao_atendidos","22","false","text","grupos_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos","22","false","text","clientes_atendidos","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos_recolocacao","22","false","text","clientes_atendidos_recolocacao","","","","","","",},
                            {"java.lang.Integer","clientes_nao_atendidos","22","false","text","clientes_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","cidades_ativas","22","false","text","cidades_ativas","","","","","","",},
                            {"java.lang.Integer","cidades_atendidas","22","false","text","cidades_atendidas","","","","","","",},
                            {"java.lang.Integer","cidades_nao_atendidas","22","false","text","cidades_nao_atendidas","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' marca       ,0 codigo_marca	   ,null mes       ,0 clientes_ativos       ,0 grupos_ativos       ,0 grupos_atendidos       ,0 grupos_nao_atendidos       ,0 clientes_atendidos	   ,0 clientes_atendidos_recolocacao       ,0 clientes_nao_atendidos       ,0 cidades_ativas       ,0 cidades_atendidas       ,0 cidades_nao_atendidas       ,0 pares       ,0.00 valor FROM dual";
    return query;
  }

}
