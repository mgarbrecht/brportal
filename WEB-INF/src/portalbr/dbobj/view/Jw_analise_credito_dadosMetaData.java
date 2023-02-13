package portalbr.dbobj.view;

/** DataBase Object from table .Jw_analise_credito_dados
  * @version 16/02/2016 11:12:15
  */
public class Jw_analise_credito_dadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_codigo","22","false","text","cli_codigo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.Integer","ddn_qtde","22","false","text","ddn_qtde","","","","","","",},
                            {"java.lang.Double","ddn_valor","22","false","text","ddn_valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT t.cli_codigo     , t.esc_seqn     , COUNT(*) ddn_qtde     , NVL(SUM(fnc_ctr_saldo_titulo(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo, t.sit_codigo_situacao_titulo, t.tit_vlpcp, t.tit_vldeb)), 0) ddn_valor  FROM titulos t WHERE t.tip_codigo = 'DDN'   AND t.tit_status = 'A'   AND t.cli_codigo IN (SELECT gre.cli_cdgo                          FROM grupo_economico gre                         WHERE gre.gre_grupo = 1234567890                           AND gre.status = 'A') GROUP BY t.cli_codigo        , t.esc_seqn";
    return query;
  }

}
