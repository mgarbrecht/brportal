package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_origem
  * @version 19/11/2014 09:04:33
  */
public class Jw_entrada_origemMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","dt_digitacao","22","false","text","dt_digitacao","","","","","","",},
                            {"java.lang.String","dt_cad_situacao","16","false","text","dt_cad_situacao","","","","","","",},
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","pedido_origem","100","false","text","pedido_origem","","","","","","",},
                            {"java.lang.String","maquina","100","false","text","maquina","","","","","","",},
                            {"java.lang.String","representante","100","false","text","representante","","","","","","",},
                            {"java.lang.String","regional","100","false","text","regional","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.ped_dadg dt_digitacao       ,SUBSTR(TO_CHAR(d.dt_cad_situacao, 'dd/mm/yyyy hh24:mi'), 1, 20) dt_cad_situacao       ,a.ped_nmro       ,inf.pedido_origem       ,a.ped_sequencial_maquina maquina       ,rep_rzao representante       ,f.nome_regional regional       ,SUM(ite_qtde) pares   FROM ped a       ,ite b       ,cli c       ,situacoes_pedidos d       ,rep e       ,regionais_vendas f       ,ped_inf_adicionais inf  WHERE a.ped_nmro = b.ped_nmro    AND a.cli_cdgo = c.cli_cdgo    AND a.ped_nmro = d.ped_nmro    AND a.rep_cdgo = e.rep_cdgo    AND e.codigo_regional = f.codigo_regional    AND NVL(a.ped_nmro, NULL) = inf.ped_nmro    AND a.ped_dadg >= TRUNC(SYSDATE - 1)    AND a.ped_dadg < TRUNC(SYSDATE + 1)    AND NVL(a.ped_stat, NULL) <> 'C'    AND NVL(ts_codigo_situacao, NULL) = 8  GROUP BY a.ped_dadg          ,TO_CHAR(dt_cad_situacao, 'dd/mm/yyyy hh24:mi')          ,a.ped_nmro          ,inf.pedido_origem          ,a.ped_sequencial_maquina          ,rep_rzao          ,f.nome_regional  ORDER BY 2 DESC";
    return query;
  }

}
