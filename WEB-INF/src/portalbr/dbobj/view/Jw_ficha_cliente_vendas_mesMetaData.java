package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_vendas_mes
  * @version 03/04/2013 09:29:20
  */
public class Jw_ficha_cliente_vendas_mesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","marca","30","false","text","marca","","","","","","",},
                            {"int","pares","22","false","text","pares","","","","","","",},
                            {"double","valor","22","false","text","valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT mar.descricao_marca marca       ,SUM(ite.ite_qtde) pares       ,ROUND(SUM(fct_valor_pedido(ped.ped_nmro)), 2) valor   FROM ped ped       ,ite ite       ,marcas_produtos mar       ,rep rep  WHERE ped.ped_dadg >= TRUNC(SYSDATE, 'MM')    AND ped.ped_dadg < TO_DATE(TRUNC(ADD_MONTHS(SYSDATE, 1), 'MM'))    AND NVL(ped.ped_nmro, NULL) = ite.ped_nmro    AND NVL(ped.ped_stat, NULL) <> 'C'    AND NVL(ped.ped_especie_pedido, NULL) IN ('F', 'N', 'M', 'P', 'X', 'R', 'C')    AND NVL(ite.codigo_marca, NULL) = mar.codigo_marca    AND NVL(ped.rep_cdgo, NULL) = NVL(NULL, ped.rep_cdgo)    AND NVL(ped.rep_cdgo, NULL) = rep.rep_cdgo    AND ped.cli_cdgo = 70    and ped.esc_seqn = 2    AND NVL(rep.codigo_gerente, NULL) = NVL(NULL, rep.codigo_gerente)  GROUP BY mar.descricao_marca";
    return query;
  }

}
