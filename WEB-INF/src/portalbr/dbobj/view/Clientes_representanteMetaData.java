package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_representante
  * @version 06/06/2013 16:00:55
  */
public class Clientes_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","regional","10","false","text","regional","","","","","","",},
                            {"java.lang.Integer","codigo_regional","10","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","rep_cdgo","22","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_nome","10","false","text","rep_nome","","","","","","",},
                            {"java.lang.Integer","grupos_ativos","22","false","text","grupos_ativos","","","","","","",},
                            {"java.lang.Integer","grupos_atendidos","22","false","text","grupos_atendidos","","","","","","",},
                            {"java.lang.Integer","grupos_nao_atendidos","22","false","text","grupos_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","clientes_ativos","22","false","text","clientes_ativos","","","","","","",},
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
    String query = "select '' regional, '' codigo_regional, 0 rep_cdgo,'' rep_nome, 0 grupos_ativos, 0 grupos_atendidos, 0 grupos_nao_atendidos, 0 clientes_ativos, 0 clientes_atendidos, 0 clientes_atendidos_recolocacao, 0 clientes_nao_atendidos, 0 cidades_ativas, 0 cidades_atendidas, 0 cidades_nao_atendidas, 0 pares, 0 valor from dual";
    return query;
  }

}
