package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_linha
  * @version 03/04/2013 09:45:11
  */
public class Jw_clientes_ficha_linhaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","qtd_atual","22","false","text","qtd_atual","","","","","","",},
                            {"java.lang.Double","vlr_atual","22","false","text","vlr_atual","","##,##0.00","","","","",},
                            {"java.lang.Integer","qtd_anterior","22","false","text","qtd_anterior","","","","","","",},
                            {"java.lang.Double","vlr_anterior","22","false","text","vlr_anterior","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT lin_cdgo       ,qtd_atual       ,vlr_atual       ,qtd_anterior       ,vlr_anterior   FROM (SELECT ROWNUM contador               ,lin_cdgo               ,qtd_atual               ,vlr_atual               ,qtd_anterior               ,vlr_anterior           FROM (SELECT lin_cdgo                       ,SUM(qtd_atual) qtd_atual                       ,SUM(vlr_atual) vlr_atual                       ,SUM(qtd_anterior) qtd_anterior                       ,SUM(vlr_anterior) vlr_anterior                   FROM (SELECT ite.lin_cdgo                               ,0 qtd_atual                               ,0 vlr_atual                               ,SUM(ite.ite_qtde) qtd_anterior                               ,SUM(fct_valor_pedido(ite.ped_nmro, ite.ite_seqn)) vlr_anterior                           FROM ite                               ,ped                          WHERE ite.ped_nmro = ped.ped_nmro                            AND ped.ped_stat <> 'C'                            AND ped.ped_substituicao <> 'S'                            AND ped.ped_amostra_brinde IS NULL                            AND EXTRACT(YEAR FROM ped_daem) = 2010                            AND EXTRACT(MONTH FROM ped_daem) BETWEEN 1 AND 12                            AND ped.cli_cdgo = 5403                          GROUP BY ite.lin_cdgo                         UNION                         SELECT ite.lin_cdgo                               ,SUM(ite.ite_qtde) qtd_atual                               ,SUM(fct_valor_pedido(ite.ped_nmro, ite.ite_seqn)) vlr_atual                               ,0 qtd_anterior                               ,0 qtd_anterior                           FROM ite                               ,ped                          WHERE ite.ped_nmro = ped.ped_nmro                            AND ped.ped_stat <> 'C'                            AND ped.ped_substituicao <> 'S'                            AND ped.ped_amostra_brinde IS NULL                            AND EXTRACT(YEAR FROM ped_daem) = 2011                            AND EXTRACT(MONTH FROM ped_daem) BETWEEN 1 AND 12                            AND ped.cli_cdgo = 5403                          GROUP BY ite.lin_cdgo)                  GROUP BY lin_cdgo                  ORDER BY vlr_atual DESC) tab          WHERE ROWNUM <= 10)";
    return query;
  }

}
