package portalbr.dbobj.view;

/** DataBase Object from table .Jw_administrador_pedidos_sintetico
  * @version 29/08/2022 12:42:35
  */
public class Jw_administrador_pedidos_sinteticoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","240","false","text","lin_nome","","","","","","",},
                            {"java.sql.Date","data_inicial","22","false","text","data_inicial","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select lin_cdgo, lin_nome, min(data_inicial) data_inicial from ( SELECT t.lin_codigo lin_cdgo,        l.lin_nome,        min(data_inicial) data_inicial   FROM toneis t,        lin l,        ref r,        (SELECT DISTINCT cod_empresa,                         cod_filial,                         periodo,                         extract(YEAR FROM data) ano,                         LPAD(extract(MONTH FROM data), 2, 0) mes,                         MIN(DATA) data_inicial,                         MAX(data) data_final           FROM calendarios_semanal          WHERE data > sysdate -1          GROUP BY cod_empresa,                   cod_filial,                   periodo,                   EXTRACT(YEAR FROM DATA),                   LPAD(EXTRACT(MONTH FROM data), 2, 0)) cs  WHERE cs.cod_empresa = t.cod_empresa    AND cs.cod_filial = t.cod_filial    AND cs.periodo = t.periodo    and l.lin_cdgo = r.lin_cdgo    AND t.ano = cs.ano    AND t.lin_codigo = l.lin_cdgo    AND t.lin_codigo = nvl(520, t.lin_codigo)  having(sum(capacidade_pares) - sum(venda_pares)) > 0  GROUP BY t.lin_codigo,           l.lin_nome,           cs.data_inicial  ORDER BY t.lin_codigo, t.ref_codigo, l.lin_nome, t.periodo )group by lin_cdgo, lin_nome order by lin_cdgo, data_inicial";
    return query;
  }

}
