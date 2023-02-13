package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_mapa_diario_anterior
  * @version 13/09/2019 15:21:51
  */
public class Jw_consulta_mapa_diario_anteriorMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","entrada_mes_ant_valor","22","false","text","entrada_mes_ant_valor","","##,##0.00","","","","",},
                            {"double","variacao_entrada_valor","22","false","text","variacao_entrada_valor","","##,##0.00","","","","",},
                            {"double","faturamento_mes_ant","22","false","text","faturamento_mes_ant","","##,##0.00","","","","",},
                            {"double","variacao_faturamento_valor","22","false","text","variacao_faturamento_valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT SUM(entped_ano_anterior_valor) entrada_mes_ant_valor      ,CASE         WHEN SUM(entped_ano_anterior_valor) = 0 THEN          100         ELSE          ((SUM(entped_atual) * 100) / SUM(entped_ano_anterior_valor)) - 100       END variacao_entrada_valor      ,SUM(faturamento_ano_anterior_valor) faturamento_mes_ant      ,CASE         WHEN SUM(faturamento_ano_anterior_valor) = 0 THEN          100         ELSE          ((SUM(fat_real_vlr) * 100) / SUM(faturamento_ano_anterior_valor)) - 100       END variacao_faturamento_valor  FROM (SELECT SUM(0) entped_ano_anterior_valor              ,SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0)) entped_atual              ,SUM(faturamento_ano_anterior_valor) faturamento_ano_anterior_valor              ,SUM(fat_real_vlr) fat_real_vlr          FROM brger.tmp_mapa_diario_automatico         WHERE filial = 'GER'        UNION ALL        SELECT SUM(NVL(valor, 0)) entped_ano_anterior_valor              ,0              ,0              ,0          FROM ubiratan.tmp_mapa_diario_data_anterior a         WHERE valor > 0           AND filial = 'GER'           AND data_mapa BETWEEN (SELECT MIN(data)                                    FROM brger.tmp_mapa_diario_automatico                                   WHERE filial = 'GER'                                     AND ROWNUM = 1)           AND TRUNC(SYSDATE) - 1)";
    return query;
  }

}
