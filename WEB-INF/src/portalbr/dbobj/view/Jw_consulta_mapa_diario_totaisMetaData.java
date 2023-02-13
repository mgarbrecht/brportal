package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_mapa_diario_totais
  * @version 04/03/2015 10:35:04
  */
public class Jw_consulta_mapa_diario_totaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","total_para_mes_valor","22","false","text","total_para_mes_valor","","##,##0.00","","","","",},
                            {"double","carteira_atual_valor","22","false","text","carteira_atual_valor","","##,##0.00","","","","",},
                            {"double","carteira_anterior_valor","22","false","text","carteira_anterior_valor","","##,##0.00","","","","",},
                            {"double","variacao_carteira_valor","22","false","text","variacao_carteira_valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT (SUM(atraso_original_vlr) + (SUM(entped_nomes_geral_vlr) + SUM(entped_rr_geral_vlr) + SUM(fat_prev_vlr_ant))) total_para_mes_valor       ,((SUM(atraso_original_vlr) + (SUM(entped_nomes_geral_vlr) + SUM(entped_rr_geral_vlr) + SUM(fat_prev_vlr_ant))) + (SUM(entped_proxmes1_vlr) + SUM(entped_proxmes2_vlr) + SUM(entped_proxmesn_vlr)) - SUM(fat_real_vlr)) carteira_atual_valor       ,SUM(carteira_anterior_vlr) carteira_anterior_valor       ,TRUNC(((((SUM(atraso_original_vlr) + (SUM(entped_nomes_geral_vlr) + SUM(entped_rr_geral_vlr) + SUM(fat_prev_vlr_ant))) + (SUM(entped_proxmes1_vlr) + SUM(entped_proxmes2_vlr) + SUM(entped_proxmesn_vlr)) - SUM(fat_real_vlr)) * 100) / SUM(carteira_anterior_vlr)) - 100,2) variacao_carteira_valor   FROM brger.tmp_mapa_diario_automatico  WHERE filial = 'GER'";
    return query;
  }

}
