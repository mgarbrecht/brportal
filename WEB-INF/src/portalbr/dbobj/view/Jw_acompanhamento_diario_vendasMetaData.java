package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acompanhamento_diario_vendas
  * @version 03/05/2016 16:01:59
  */
public class Jw_acompanhamento_diario_vendasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","periodo","100","false","text","periodo","","","","","","",},
                            {"java.lang.String","periodo_ano_anterior","100","false","text","periodo_ano_anterior","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","100","false","text","nome_regional","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","100","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","rep_cdgo","10","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","100","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Integer","pares_previsto_ano","22","false","text","pares_previsto_ano","","","","","","",},
                            {"java.lang.Integer","pares_realizado_ano","22","false","text","pares_realizado_ano","","","","","","",},
                            {"java.lang.Double","reais_previsto_ano","22","false","text","reais_previsto_ano","","##,##0.00","","","","",},
                            {"java.lang.Double","reais_realizado_ano","22","false","text","reais_realizado_ano","","##,##0.00","","","","",},
                            {"java.lang.Integer","pares_realizado_ant","22","false","text","pares_realizado_ant","","","","","","",},
                            {"java.lang.Double","reais_realizado_ant","22","false","text","reais_realizado_ant","","##,##0.00","","","","",},
                            {"java.lang.Integer","cli_atend_ano","22","false","text","cli_atend_ano","","","","","","",},
                            {"java.lang.Integer","cli_atend_ant","22","false","text","cli_atend_ant","","","","","","",},
                            {"java.lang.Integer","dif_cli_atend","22","false","text","dif_cli_atend","","","","","","",},
                            {"java.lang.Double","valor_meta","22","false","text","valor_meta","","##,##0.00","","","","",},
                            {"java.lang.Double","valor_ano_ant","22","false","text","valor_ano_ant","","##,##0.00","","","","",},
                            {"java.lang.Integer","cli_atend_regional_ano","22","false","text","cli_atend_regional_ano","","","","","","",},
                            {"java.lang.Integer","cli_atend_regional_ant","22","false","text","cli_atend_regional_ant","","","","","","",},
                            {"java.lang.Integer","dif_cli_regional_atend","22","false","text","dif_cli_regional_atend","","","","","","",},
                            {"java.lang.Double","dif_pares_ano","22","false","text","dif_pares_ano","","##,##0.00","","","","",},
                            {"java.lang.Double","dif_reais_ano","22","false","text","dif_reais_ano","","##,##0.00","","","","",},
                            {"java.lang.Double","dif_pares_realizado","22","false","text","dif_pares_realizado","","##,##0.00","","","","",},
                            {"java.lang.Double","dif_reais_realizado","22","false","text","dif_reais_realizado","","##,##0.00","","","","",},
                            {"java.lang.Double","dif_clientes_atendidos","22","false","text","dif_clientes_atendidos","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT        ,'' periodo       ,'' periodo_ano_anterior       ,0 codigo_regional       ,'' nome_regional       ,0 codigo_marca       ,'' descricao_marca       ,'' rep_cdgo       ,'' rep_rzao       ,0 pares_previsto_ano       ,0 pares_realizado_ano       ,0.0 reais_previsto_ano       ,0.0 reais_realizado_ano       ,0 pares_realizado_ant       ,0.0 reais_realizado_ant       ,0 cli_atend_ano       ,0 cli_atend_ant        ,0 dif_cli_atend       ,0.0 valor_meta       ,0.0 valor_ano_ant       ,0 cli_atend_regional_ano       ,0 cli_atend_regional_ant       ,0 dif_cli_regional_atend	          ,0.0 dif_pares_ano       ,0.0 dif_reais_ano       ,0.0 dif_pares_realizado       ,0.0 dif_reais_realizado	   	   ,0.0 dif_clientes_atendidos   FROM dual";
    return query;
  }

}
