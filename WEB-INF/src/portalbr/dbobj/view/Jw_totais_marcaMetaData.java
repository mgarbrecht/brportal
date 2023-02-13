package portalbr.dbobj.view;

/** DataBase Object from table .Jw_totais_marca
  * @version 05/07/2010 07:06:13
  */
public class Jw_totais_marcaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.Integer","total_grupos_ativos","22","false","text","total_grupos_ativos","","","","","","",},
                            {"java.lang.Integer","total_clientes_ativos","22","false","text","total_clientes_ativos","","","","","","",},
                            {"java.lang.Integer","total_clientes_atendidos","22","false","text","total_clientes_atendidos","","","","","","",},
                            {"java.lang.Integer","total_clientes_nao_atendidos","22","false","text","total_clientes_nao_atendidos","","","","","","",},
                            {"java.lang.Integer","total_cidades_ativas","22","false","text","total_cidades_ativas","","","","","","",},
                            {"java.lang.Integer","total_cidades_atendidas","22","false","text","total_cidades_atendidas","","","","","","",},
                            {"java.lang.Integer","total_cidades_nao_atendidas","22","false","text","total_cidades_nao_atendidas","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT 0 codigo_marca                ,0 total_grupos_ativos                ,0 total_clientes_ativos                ,0 total_clientes_atendidos                ,0 total_clientes_nao_atendidos                ,0 total_cidades_ativas                ,0 total_cidades_atendidas                ,0 total_cidades_nao_atendidas FROM dual";
    return query;
  }

}
