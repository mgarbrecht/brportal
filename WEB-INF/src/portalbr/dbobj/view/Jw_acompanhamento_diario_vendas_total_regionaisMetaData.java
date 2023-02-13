package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acompanhamento_diario_vendas_total_regionais
  * @version 26/01/2016 07:52:50
  */
public class Jw_acompanhamento_diario_vendas_total_regionaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.Integer","cli_atend_regional_ano","22","false","text","cli_atend_regional_ano","","","","","","",},
                            {"java.lang.Integer","cli_atend_regional_ant","22","false","text","cli_atend_regional_ant","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_regional       ,sum(cli_atend_regional_ano) cli_atend_regional_ano       ,sum(cli_atend_regional_ant) cli_atend_regional_ant   FROM (SELECT DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14) codigo_regional               ,COUNT(DISTINCT tmdap.cli_cdgo) cli_atend_regional_ano               , 0 cli_atend_regional_ant           FROM tmp_mapa_diario_automatico_poi tmdap               ,rep                            rpp          WHERE tmdap.data BETWEEN TO_DATE('01/12/2015', 'dd/mm/yyyy') AND                TO_DATE('31/12/2015', 'dd/mm/yyyy')            AND NVL(tmdap.cli_cdgo, 0) <> 0            AND (TRUNC(tmdap.data, 'MM') < TO_DATE('092009', 'MMYYYY') OR                NVL(tmdap.entped_pp_pares, 0) +                NVL(tmdap.entped_pg_pares, 0) +                NVL(tmdap.entped_rr_pares, 0) > 0)            AND rpp.rep_cdgo = TO_CHAR(tmdap.codigo_representante)          GROUP BY DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14)          UNION         SELECT DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14) codigo_regional               ,0 cli_atend_regional_ano               ,COUNT(DISTINCT tmdap.cli_cdgo) cli_atend_regional_ant           FROM tmp_mapa_diario_automatico_poi tmdap               ,rep                            rpp          WHERE tmdap.data BETWEEN TO_DATE('01/12/2014', 'dd/mm/yyyy') AND                TO_DATE('31/12/2014', 'dd/mm/yyyy')            AND NVL(tmdap.cli_cdgo, 0) <> 0            AND (TRUNC(tmdap.data, 'MM') < TO_DATE('092009', 'MMYYYY') OR                NVL(tmdap.entped_pp_pares, 0) +                NVL(tmdap.entped_pg_pares, 0) +                NVL(tmdap.entped_rr_pares, 0) > 0)            AND rpp.rep_cdgo = TO_CHAR(tmdap.codigo_representante)          GROUP BY DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14) ) group by codigo_regional";
    return query;
  }

}
