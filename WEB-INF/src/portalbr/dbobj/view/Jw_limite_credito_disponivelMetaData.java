package portalbr.dbobj.view;

/** DataBase Object from table .Jw_limite_credito_disponivel
  * @version 03/04/2013 09:26:32
  */
public class Jw_limite_credito_disponivelMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_codigo","22","false","text","cli_codigo","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","grupo_economico","10","false","text","grupo_economico","","","","","","",},
                            {"double","valor_analista","22","false","text","valor_analista","","","","","","",},
                            {"double","valor_saldo","22","false","text","valor_saldo","","","","","","",},
                            {"double","disponivel","22","false","text","disponivel","","","","","","",},
                            {"double","perc","22","false","text","perc","","","","","","",},
                            {"java.lang.String","rep_cdgo","10","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","10","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","codigo_regional","10","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","10","false","text","nome_regional","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select DISTINCT c.cli_cdgo cli_codigo, c.cli_rzao, '' grupo_economico, 0 valor_analista, 0 valor_saldo, 0 disponivel, 0 perc, '' rep_cdgo, '' rep_rzao, '' codigo_regional, '' nome_regional from cli c, cliente_representante cr, rep r where c.cli_cdgo=cr.codigo_cliente and r.rep_cdgo=cr.codigo_representante and c.cli_situ='A' and r.codigo_regional=nvl(null,r.codigo_regional)and r.rep_cdgo=nvl(null,r.rep_cdgo)order by 4 DESC";
    return query;
  }

}
