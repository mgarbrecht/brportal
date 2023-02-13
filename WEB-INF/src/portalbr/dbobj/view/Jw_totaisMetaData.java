package portalbr.dbobj.view;

/** DataBase Object from table .Jw_totais
  * @version 06/06/2013 17:09:19
  */
public class Jw_totaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","total_grupos_ativos","22","false","text","total_grupos_ativos","","","","","","",},
                            {"java.lang.Integer","total_grupos_atendidos","22","false","text","total_grupos_atendidos","","","","","","",},
                            {"java.lang.Integer","total_grupos_nao_atendidos","22","false","text","total_grupos_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","total_clientes_ativos","22","false","text","total_clientes_ativos","","","","","","",},
                            {"java.lang.Integer","total_clientes_atendidos","22","false","text","total_clientes_atendidos","","","","","","",},
                            {"java.lang.Integer","total_clientes_atendidosr","22","false","text","total_clientes_atendidosr","","","","","","",},
                            {"java.lang.Integer","total_clientes_nao_atendidos","22","false","text","total_clientes_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","total_cidades_ativas","22","false","text","total_cidades_ativas","","","","","","",},
                            {"java.lang.Integer","total_cidades_atendidas","22","false","text","total_cidades_atendidas","","","","","","",},
                            {"java.lang.Integer","total_cidades_nao_atendidas","22","false","text","total_cidades_nao_atendidas","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select 0 total_grupos_ativos, 0 total_grupos_atendidos,0 total_grupos_nao_atendidos , 0 total_clientes_ativos, 0 total_clientes_atendidos, 0 total_clientes_atendidosr, 0 total_clientes_nao_atendidos, 0 total_cidades_ativas, 0 total_cidades_atendidas, 0 total_cidades_nao_atendidas from dual";
    return query;
  }

}
