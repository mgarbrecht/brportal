package portalbr.dbobj.view;

/** DataBase Object from table .Jw_web_poi_filtro
  * @version 17/10/2012 16:07:54
  */
public class Jw_web_poi_filtroMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_ref","81","false","text","lin_ref","","","","","","",},
                            {"java.lang.Integer","linha","22","false","text","linha","","","","","","",},
                            {"java.lang.String","ref_codigo","40","false","text","ref_codigo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.Integer","mes","22","false","text","mes","","","","","","",},
                            {"java.lang.Integer","ano","22","false","text","ano","","","","","","",},
                            {"java.lang.Integer","periodos","22","false","text","periodos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT t.lin_codigo || DECODE(t.ref_codigo, 0, NULL, '.') || DECODE(t.ref_codigo, 0, NULL, t.ref_codigo) lin_ref       ,t.lin_codigo linha       ,DECODE(t.ref_codigo, 0, '', t.ref_codigo) ref_codigo       ,l.lin_nome       ,cs.mes       ,cs.ano       ,COUNT(DISTINCT t.periodo) periodos   FROM toneis t       ,lin l       ,(SELECT DISTINCT cod_empresa                        ,cod_filial                        ,periodo                        ,EXTRACT(YEAR FROM data) ano                        ,EXTRACT(MONTH FROM DATA) mes                        ,MIN(data) data_inicial                        ,MAX(data) data_final           FROM calendarios_semanal          WHERE data BETWEEN NVL(TO_DATE('1112', 'mmrr'), data) AND NVL(LAST_DAY(TO_DATE('1112', 'mmrr')), data)          GROUP BY cod_empresa                  ,cod_filial                  ,periodo                  ,EXTRACT(YEAR FROM data)                  ,EXTRACT(MONTH FROM data)) cs  WHERE cs.cod_empresa = t.cod_empresa    AND cs.cod_filial = t.cod_filial    AND cs.periodo = t.periodo    AND t.ano = cs.ano    AND t.lin_codigo = l.lin_cdgo    AND t.ref_codigo = NVL(NULL, t.ref_codigo)    AND t.lin_codigo = NVL(NULL, t.lin_codigo)    AND t.lin_codigo = NVL(NULL, t.lin_codigo)  GROUP BY cs.ano          ,cs.mes          ,t.lin_codigo          ,t.ref_codigo          ,l.lin_nome  ORDER BY cs.ano          ,cs.mes          ,t.lin_codigo          ,t.ref_codigo          ,l.lin_nome";
    return query;
  }

}
