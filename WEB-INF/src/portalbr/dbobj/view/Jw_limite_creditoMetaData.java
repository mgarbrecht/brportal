package portalbr.dbobj.view;

/** DataBase Object from table .Jw_limite_credito
  * @version 19/12/2016 09:34:54
  */
public class Jw_limite_creditoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","","","","","","","",},
                            {"double","limite","22","false","text","","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","","","","","","","",},
                            {"java.lang.String","situacao_cr","1","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */         DISTINCT         rv.codigo_regional,         rv.nome_regional,          r.rep_cdgo,          r.rep_rzao,          c.cli_cdgo cli_cdgo,          c.cli_rzao cli_rzao,          decode(c.cli_valor_credito_analista,null,0,c.cli_valor_credito_analista,c.cli_valor_credito_analista)  limite,          nvl(e.esc_situacao,'A') situacao,          a.situacao situacao_cr     FROM cliente_representante a,          cli c,          esc e,          rep r,          regionais_vendas rv    WHERE a.codigo_cliente       =  c.cli_cdgo      AND c.cli_cdgo             =  e.cli_cdgo      AND a.codigo_cliente       =  e.cli_cdgo      AND a.codigo_sequencial    =  e.esc_seqn      AND a.codigo_cliente       not in (5239,20698,5248,3284,10758,5247,5236,25126,5256,5271)      AND r.rep_cdgo             =  a.codigo_representante      AND r.codigo_regional      =  rv.codigo_regional    ORDER BY          codigo_regional,         rep_cdgo,          situacao,          cli_rzao,          cli_cdgo";
    return query;
  }

}
