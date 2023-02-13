package portalbr.dbobj.view;

/** DataBase Object from table .Jw_web_poi
  * @version 16/10/2012 10:05:50
  */
public class Jw_web_poiMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_ref","81","false","text","lin_ref","","","","","","",},
                            {"java.lang.String","linha","22","false","text","linha","","","","","","",},
                            {"java.lang.String","ref_codigo","40","false","text","ref_codigo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.String","mes_ano_venda","22","false","text","mes_ano_venda","","","","","","",},
                            {"double","total_pares_venda","22","false","text","total_pares_venda","","","","","","",},
                            {"double","capacidade","22","false","text","capacidade","","","","","","",},
                            {"double","vendas","22","false","text","vendas","","","","","","",},
                            {"double","disponivel","22","false","text","disponivel","","","","","","",},
                            {"double","pares_ret_credito","22","false","text","pares_ret_credito","","","","","","",},
                            {"java.lang.String","periodo","10","false","text","lin_ref","","","","","","",},
                            {"java.sql.Date","data_inicial","12","false","text","Data Inicial","","dd/MM/yyyy","","","","",},
                            {"java.sql.Date","data_final","12","false","text","Data Final","","dd/MM/yyyy","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT t.lin_codigo || DECODE(t.ref_codigo, 0, NULL, '.') || DECODE(t.ref_codigo, 0, NULL, t.ref_codigo) lin_ref      ,t.lin_codigo linha      ,DECODE(t.ref_codigo, 0, '', t.ref_codigo) ref_codigo      ,l.lin_nome      ,mes || SUBSTR(cs.ano, 3, 4) mes_ano_venda      ,0 total_pares_venda      ,SUM(capacidade_pares) capacidade      ,SUM(venda_pares) vendas      ,SUM(capacidade_pares) - SUM(venda_pares) disponivel      ,fnc_pares_retidos_credito(TO_DATE(mes || cs.ano, 'mmyyyy'), TRUNC(LAST_DAY(TO_DATE(mes || cs.ano, 'mmyyyy'))), t.lin_codigo) pares_ret_credito      ,t.periodo      ,data_inicial      ,data_final        FROM toneis t      ,lin l      ,(SELECT DISTINCT cod_empresa                       ,cod_filial                       ,periodo                       ,EXTRACT(YEAR FROM data) ano                       ,LPAD(EXTRACT(MONTH FROM data), 2, 0) mes                       ,MIN(DATA) data_inicial, MAX(data) data_final          FROM calendarios_semanal         WHERE data BETWEEN NVL(TO_DATE('1112', 'mmrr'), data) AND NVL(LAST_DAY(TO_DATE('1112', 'mmrr')), data)         GROUP BY cod_empresa                       ,cod_filial                       ,periodo                       ,EXTRACT(YEAR FROM DATA)                       ,LPAD(EXTRACT(MONTH FROM data), 2, 0)) cs WHERE cs.cod_empresa = t.cod_empresa   AND cs.cod_filial = t.cod_filial   AND cs.periodo = t.periodo   AND t.ano = cs.ano   AND t.lin_codigo = l.lin_cdgo   AND t.ref_codigo = NVL(NULL, t.ref_codigo)   AND t.lin_codigo = NVL(NULL, t.lin_codigo)   AND t.lin_codigo = NVL(NULL, t.lin_codigo) GROUP BY cs.ano         ,cs.mes         ,t.periodo         ,cs.data_inicial         ,cs.data_final         ,t.lin_codigo         ,t.ref_codigo         ,l.lin_nome ORDER BY cs.ano         ,cs.mes         ,t.lin_codigo         ,t.ref_codigo         ,l.lin_nome";
    return query;
  }

}
