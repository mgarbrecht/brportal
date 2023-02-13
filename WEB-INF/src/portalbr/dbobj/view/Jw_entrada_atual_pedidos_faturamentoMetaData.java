package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_faturamento
  * @version 05/11/2020 20:10:45
  */
public class Jw_entrada_atual_pedidos_faturamentoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","atualizacao","20","false","text","atualizacao","","","","","","",},
                            {"java.lang.String","datam","20","false","text","datam","","","","","","",},
                            {"java.lang.Integer","pares_pp","22","false","text","pares_pp","","","","","","",},
                            {"java.lang.Integer","pares_pg","22","false","text","pares_pg","","","","","","",},
                            {"java.lang.Double","valor_pp","22","false","text","valor_pp","","##,##0.00","","","","",},
                            {"java.lang.Double","valor_pg","22","false","text","valor_pg","","##,##0.00","","","","",},
                            {"java.lang.Integer","pares_total","22","false","text","pares_total","","","","","","",},
                            {"java.lang.Double","valor_total","22","false","text","valor_total","","##,##0.00","","","","",},
                            {"java.lang.String","tipo","20","false","text","tipo","","","","","","",},
                            {"java.lang.String","ped_tipo","20","false","text","ped_tipo","","","","","","",},
                            {"java.lang.String","regional","100","false","text","regional","","","","","","",},
                            {"java.lang.String","tipo_mercado","20","false","text","tipo_mercado","","","","","","",},
                            {"java.lang.Integer","pares_ano","22","false","text","pares_ano","","","","","","",},
                            {"java.lang.Double","valor_ano","22","false","text","valor_ano","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao      ,TO_CHAR(data, 'DD/MM/YYYY') datam      ,SUM(NVL(ctl.fat_real_pares, 0)) pares      ,SUM(NVL(ctl.fat_real_vlr, 0)) valor      ,'dia_anterior' tipo  FROM tmp_mapa_automatico_resumo ctl WHERE empresa = '01'   AND data = NVL((SELECT sem.data_mapa                    FROM semanas sem                   WHERE data = (SELECT sem.data_mapa                                   FROM semanas sem                                  WHERE data = TRUNC(SYSDATE)) - 1), TRUNC(SYSDATE) - 1) GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI')         ,TO_CHAR(data, 'DD/MM/YYYY')		 ,ctl.ped_tipo      UNIONSELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao      ,TO_CHAR(data, 'DD/MM/YYYY') datam      ,SUM(NVL(ctl.fat_real_pares, 0)) pares      ,SUM(NVL(ctl.fat_real_vlr, 0)) valor      ,'dia_atual' tipo      ,ctl.ped_tipo      	    FROM tmp_mapa_automatico_resumo ctl WHERE empresa = '01'   AND data = NVL((SELECT sem.data_mapa                    FROM semanas sem                   WHERE data = TRUNC(SYSDATE)), TRUNC(SYSDATE)) GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI')         ,TO_CHAR(data, 'DD/MM/YYYY')         ,ctl.ped_tipo      		 UNIONSELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao      ,'MES' datam      ,SUM(NVL(ctl.fat_real_pares, 0)) pares      ,SUM(NVL(ctl.fat_real_vlr, 0)) valor      ,'mes' tipo      ,ctl.ped_tipo      	    FROM tmp_mapa_automatico_resumo ctl WHERE empresa = '01' GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI')         ,'MES'";
    return query;
  }

}
