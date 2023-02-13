package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_geral
  * @version 03/04/2013 09:45:30
  */
public class Jw_clientes_ficha_geralMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ano","22","false","text","ano","","","","","","",},
                            {"java.lang.Double","vlr_atual","22","false","text","vlr_atual","","##,##0.00","","","","",},
                            {"java.lang.Integer","qtd_atual","22","false","text","qtd_atual","","","","","","",},
                            {"java.lang.Integer","vlr_anterior","22","false","text","vlr_anterior","","##,##0.00","","","","",},
                            {"java.lang.Integer","qtd_anterior","22","false","text","qtd_anterior","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ano       ,SUM(vlr_atual) vlr_atual       ,SUM(qtd_atual) qtd_atual       ,SUM(vlr_anterior) vlr_anterior       ,SUM(qtd_anterior) qtd_anterior   FROM (SELECT EXTRACT(YEAR FROM ped.ped_daem) ano               ,SUM(fct_valor_pedido(ite.ped_nmro, ite.ite_seqn)) vlr_atual               ,SUM(ite.ite_qtde) qtd_atual               ,0 vlr_anterior               ,0 qtd_anterior           FROM ite               ,ped          WHERE ite.ped_nmro = ped.ped_nmro            AND ped.ped_stat <> 'C'            AND ped.ped_substituicao <> 'S'            AND ped.ped_amostra_brinde IS NULL            AND EXTRACT(YEAR FROM ped_daem) = 2011            AND EXTRACT(MONTH FROM ped_daem) BETWEEN 1 AND 12            AND ped.cli_cdgo = 5403          GROUP BY EXTRACT(YEAR FROM ped.ped_daem)         UNION         SELECT EXTRACT(YEAR FROM ped.ped_daem) ano               ,0 vlr_atual               ,0 qtd_atual               ,SUM(fct_valor_pedido(ite.ped_nmro, ite.ite_seqn)) vlr_anterior               ,SUM(ite.ite_qtde) qtd_anterior           FROM ite               ,ped          WHERE ite.ped_nmro = ped.ped_nmro            AND ped.ped_stat <> 'C'            AND ped.ped_substituicao <> 'S'            AND ped.ped_amostra_brinde IS NULL            AND EXTRACT(YEAR FROM ped_daem) = 2010            AND EXTRACT(MONTH FROM ped_daem) BETWEEN 1 AND 12            AND ped.cli_cdgo = 5403          GROUP BY EXTRACT(YEAR FROM ped.ped_daem))          GROUP BY ano";
    return query;
  }

}
