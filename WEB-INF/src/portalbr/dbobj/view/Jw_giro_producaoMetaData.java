package portalbr.dbobj.view;

/** DataBase Object from table .Jw_giro_producao
  * @version 21/03/2022 18:10:30
  */
public class Jw_giro_producaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data","22","false","text","data","","","","","","",},
                            {"java.lang.String","semana","22","false","text","semana","","","","","","",},
                            {"java.lang.String","data_descricao","19","false","text","data_descricao","","","","","","",},
                            {"java.lang.String","data_abreviada","20","false","text","data_abreviada","","","","","","",},
                            {"java.lang.String","filial","80","false","text","filial","","","","","","",},
                            {"java.lang.Integer","valor_corte","22","false","text","valor_corte","","","","","","",},
                            {"java.lang.Integer","valor_costura","22","false","text","valor_costura","","","","","","",},
                            {"java.lang.Integer","valor_atelier","22","false","text","valor_atelier","","","","","","",},
                            {"java.lang.Integer","valor_total_costura","22","false","text","valor_total_costura","","","","","","",},
                            {"java.lang.Integer","valor_montagem","22","false","text","valor_montagem","","","","","","",},
                            {"java.lang.Integer","valor_corte_dia","22","false","text","valor_corte_dia","","","","","","",},
                            {"java.lang.Integer","valor_costura_dia","22","false","text","valor_costura_dia","","","","","","",},
                            {"java.lang.Integer","valor_atelier_dia","22","false","text","valor_atelier_dia","","","","","","",},
                            {"java.lang.Integer","valor_total_costura_dia","22","false","text","valor_total_costura_dia","","","","","","",},
                            {"java.lang.Integer","valor_montagem_dia","22","false","text","valor_montagem_dia","","","","","","",},
                            {"java.lang.Integer","valor_corte_geral","22","false","text","valor_corte_geral","","","","","","",},
                            {"java.lang.Integer","valor_costura_geral","22","false","text","valor_costura_geral","","","","","","",},
                            {"java.lang.Integer","valor_atelier_geral","22","false","text","valor_atelier_geral","","","","","","",},
                            {"java.lang.Integer","valor_total_costura_geral","22","false","text","valor_total_costura_geral","","","","","","",},
                            {"java.lang.Integer","valor_montagem_geral","22","false","text","valor_montagem_geral","","","","","","",},
                            {"java.lang.Integer","valor_corte_filial","22","false","text","valor_corte_filial","","","","","","",},
                            {"java.lang.Integer","valor_costura_filial","22","false","text","valor_costura_filial","","","","","","",},
                            {"java.lang.Integer","valor_atelier_filial","22","false","text","valor_atelier_filial","","","","","","",},
                            {"java.lang.Integer","valor_total_costura_filial","22","false","text","valor_total_costura_filial","","","","","","",},
                            {"java.lang.Integer","valor_montagem_filial","22","false","text","valor_montagem_filial","","","","","","",},
                            {"java.lang.Integer","valor_corte_filial_semana","22","false","text","valor_corte_filial_semana","","","","","","",},
                            {"java.lang.Integer","valor_costura_filial_semana","22","false","text","valor_costura_filial_semana","","","","","","",},
                            {"java.lang.Integer","valor_atelier_filial_semana","22","false","text","valor_atelier_filial_semana","","","","","","",},
                            {"java.lang.Integer","valor_total_costura_filial_semana","22","false","text","valor_total_costura_filial_semana","","","","","","",},
                            {"java.lang.Integer","valor_montagem_filial_semana","22","false","text","valor_montagem_filial_semana","","","","","","",},
                            {"java.lang.Integer","valor_corte_filial_semana_geral","22","false","text","valor_corte_filial_semana_geral","","","","","","",},
                            {"java.lang.Integer","valor_costura_filial_semana_geral","22","false","text","valor_costura_filial_semana_geral","","","","","","",},
                            {"java.lang.Integer","valor_atelier_filial_semana_geral","22","false","text","valor_atelier_filial_semana_geral","","","","","","",},
                            {"java.lang.Integer","valor_total_costura_filial_semana_geral","22","false","text","valor_total_costura_filial_semana_geral","","","","","","",},
                            {"java.lang.Integer","valor_montagem_filial_semana_geral","22","false","text","valor_montagem_filial_semana_geral","","","","","","",},
                            {"java.lang.Integer","ordem","22","false","text","ordem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT sysdate data       ,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') data_descricao       ,to_char(sysdate,'dd/mon','nls_date_language=portuguese') data_abreviada             ,0       valor_corte       ,0       valor_costura       ,0       valor_atelier       ,0       valor_total_costura       ,0       valor_montagem       ,0       valor_corte_dia       ,0       valor_costura_dia       ,0       valor_atelier_dia       ,0       valor_total_costura_dia       ,0       valor_montagem_dia       ,0       valor_corte_geral       ,0       valor_costura_geral       ,0       valor_atelier_geral       ,0       valor_total_costura_geral       ,0       valor_montagem_geral       ,0       valor_corte_filial       ,0       valor_costura_filial       ,0       valor_atelier_filial       ,0       valor_total_costura_filial       ,0       valor_montagem_filial        ,0 	 	ordem   FROM dual";
    return query;
  }

}
