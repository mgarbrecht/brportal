package portalbr.dbobj.view;

/** DataBase Object from table .Jw_administrador_pedidos_periodos
  * @version 03/04/2013 09:52:02
  */
public class Jw_administrador_pedidos_periodosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","mes","22","false","text","mes","","","","","","",},
                            {"java.lang.Integer","ano","22","false","text","ano","","","","","","",},
                            {"java.lang.Integer","periodo","22","false","text","periodo","","","","","","",},
                            {"java.sql.Date","data_inicial","22","false","text","data_inicial","","","","","","",},
                            {"java.sql.Date","data_final","22","false","text","data_final","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cs.mes       ,cs.ano       ,t.periodo       ,data_inicial       ,data_final   FROM toneis t       ,lin l       ,(SELECT DISTINCT cod_empresa                        ,cod_filial                        ,periodo                        ,EXTRACT(YEAR FROM data) ano                        ,EXTRACT(MONTH FROM data) mes                        ,MIN(data) data_inicial                        ,MAX(data) data_final           FROM calendarios_semanal          GROUP BY cod_empresa                  ,cod_filial                  ,periodo                  ,EXTRACT(YEAR FROM data)                  ,EXTRACT(MONTH FROM data)) cs  WHERE cs.cod_empresa = t.cod_empresa    AND cs.cod_filial = t.cod_filial    AND cs.periodo = t.periodo    AND t.ano = cs.ano    AND t.lin_codigo = l.lin_cdgo  GROUP BY cs.mes          ,cs.ano          ,t.periodo          ,data_inicial          ,data_final  ORDER BY cs.ano          ,cs.mes          ,t.periodo";
    return query;
  }

}
