package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_mapa_diario
  * @version 13/09/2019 15:23:59
  */
public class Jw_consulta_mapa_diarioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data_tmp","22","false","text","data_tmp","","dd/MM/yyyy","","","","",},
                            {"double","entrada_dia_valor","22","false","text","entrada_dia_valor","","##,##0.00","","","","",},
                            {"double","entrada_dia_ant_valor","22","false","text","entrada_dia_ant_valor","","##,##0.00","","","","",},
                            {"double","faturamento_dia_valor","22","false","text","faturamento_dia_valor","","##,##0.00","","","","",},
                            {"double","faturamento_dia_ant","22","false","text","faturamento_dia_ant","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT data_tmp      ,SUM(entrada_dia_valor) entrada_dia_valor      ,SUM(entrada_dia_ant_valor) entrada_dia_ant_valor      ,SUM(faturamento_dia_valor) faturamento_dia_valor      ,SUM(faturamento_dia_ant) faturamento_dia_ant  FROM (SELECT data data_tmp              ,SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0)) entrada_dia_valor              ,SUM(0) entrada_dia_ant_valor              ,SUM(fat_real_vlr) faturamento_dia_valor              ,SUM(faturamento_total_ano_ant_vlr) faturamento_dia_ant          FROM brger.tmp_mapa_diario_automatico         WHERE filial = 'GER'         GROUP BY data        UNION        SELECT a.data_mapa              ,0              ,SUM(NVL(valor, 0))              ,0              ,0          FROM ubiratan.tmp_mapa_diario_data_anterior a         WHERE valor > 0           AND filial = 'GER'           AND TRUNC(data_mapa, 'MM') = (SELECT TRUNC(data, 'MM')                                           FROM brger.tmp_mapa_diario_automatico                                          WHERE filial = 'GER'                                            AND ROWNUM = 1)         GROUP BY data_mapa) GROUP BY data_tmp ORDER BY data_tmp";
    return query;
  }

}
