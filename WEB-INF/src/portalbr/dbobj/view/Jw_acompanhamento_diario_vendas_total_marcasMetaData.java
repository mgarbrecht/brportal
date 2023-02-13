package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acompanhamento_diario_vendas_total_marcas
  * @version 03/10/2019 15:41:09
  */
public class Jw_acompanhamento_diario_vendas_total_marcasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","-105","false","text","","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cli_atend_marca_ano","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cli_atend_marca_ant","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_regional       ,codigo_marca       ,SUM(cli_atend_marca_ano) cli_atend_marca_ano       ,SUM(cli_atend_marca_ant) cli_atend_marca_ant   FROM (SELECT DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14) codigo_regional               ,tmdap.codigo_marca               ,COUNT(DISTINCT tmdap.cli_cdgo) cli_atend_marca_ano               ,0 cli_atend_marca_ant           FROM tmp_mapa_diario_automatico_poi tmdap               ,rep rpp          WHERE tmdap.data BETWEEN TO_DATE('01/01/2019', 'dd/mm/yyyy') AND TO_DATE('30/06/2019', 'dd/mm/yyyy')            AND NVL(tmdap.cli_cdgo, 0) <> 0            AND (TRUNC(tmdap.data, 'MM') < TO_DATE('092009', 'MMYYYY') OR NVL(tmdap.entped_pp_pares, 0) + NVL(tmdap.entped_pg_pares, 0) + NVL(tmdap.entped_rr_pares, 0) > 0)            AND rpp.rep_cdgo = TO_CHAR(tmdap.codigo_representante)          GROUP BY DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14)                  ,tmdap.codigo_marca         UNION         SELECT DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14) codigo_regional               ,tmdap.codigo_marca               ,0 cli_atend_marca_ano               ,COUNT(DISTINCT tmdap.cli_cdgo) cli_atend_marca_ant           FROM tmp_mapa_diario_automatico_poi tmdap               ,rep rpp          WHERE tmdap.data BETWEEN TO_DATE('01/01/2018', 'dd/mm/yyyy') AND TO_DATE('30/06/2018', 'dd/mm/yyyy')            AND NVL(tmdap.cli_cdgo, 0) <> 0            AND (TRUNC(tmdap.data, 'MM') < TO_DATE('092009', 'MMYYYY') OR NVL(tmdap.entped_pp_pares, 0) + NVL(tmdap.entped_pg_pares, 0) + NVL(tmdap.entped_rr_pares, 0) > 0)            AND rpp.rep_cdgo = TO_CHAR(tmdap.codigo_representante)          GROUP BY DECODE(INSTR('*15*16*17*19*20*21*22*', '*' || rpp.codigo_regional || '*'), 0, rpp.codigo_regional, 14)                  ,tmdap.codigo_marca)  GROUP BY codigo_regional          ,codigo_marca";
    return query;
  }

}
