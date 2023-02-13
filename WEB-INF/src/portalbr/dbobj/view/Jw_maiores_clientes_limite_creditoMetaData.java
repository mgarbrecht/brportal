package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_limite_credito
  * @version 03/04/2013 09:23:03
  */
public class Jw_maiores_clientes_limite_creditoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","razao","80","false","text","razao","","","","","","",},
                            {"java.lang.String","tipo","10","false","text","tipo","","","","","","",},
                            {"double","limite","22","false","text","limite","","","","","","",},
                            {"double","pedidos_producao","22","false","text","pedidos_producao","","","","","","",},
                            {"double","saldo","22","false","text","saldo","","","","","","",},
                            {"double","p_qtd_vencer","22","false","text","p_qtd_vencer","","","","","","",},
                            {"double","p_vlr_vencer","22","false","text","p_vlr_vencer","","","","","","",},
                            {"double","p_qtd_vencido","22","false","text","p_qtd_vencido","","","","","","",},
                            {"double","p_vlr_vencido","22","false","text","p_vlr_vencido","","","","","","",},
                            {"double","percentual_pontualidade","22","false","text","percentual_pontualidade","","","","","","",},
                            {"double","pedidos_nao_liberados","22","false","text","pedidos_nao_liberados","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT g.gre_grupo codigo      , g.gre_descricao razao      , 'Grupo' tipo      , SUM(c.cli_valor_credito_analista) limite      , 0.00 pedidos_producao      , 0.00 saldo	  , 0.00 p_qtd_vencer	  , 0.00 p_vlr_vencer	  , 0.00 p_qtd_vencido	  , 0.00 p_vlr_vencido	  	  , 0.00 percentual_pontualidade	     FROM cli c      , grupo_economico g  WHERE g.cli_cdgo = c.cli_cdgo    AND g.status = 'A'    AND NVL(c.cli_situ, NULL) = 'A'  GROUP BY g.gre_grupo         , g.gre_descricao  UNION SELECT c.cli_cdgo codigo      , c.cli_rzao razao      , 'Cliente' tipo      , c.cli_valor_credito_analista limite      , 0.00 pedidos_producao      , 0.00 saldo	  , 0.00 p_qtd_vencer	  , 0.00 p_vlr_vencer	  , 0.00 p_qtd_vencido	  , 0.00 p_vlr_vencido	 	  	  , 0.00 percentual_pontualidade   FROM cli c  WHERE NVL(c.cli_situ, NULL) = 'A'    AND c.cli_valor_credito_analista IS NOT NULL    AND NOT EXISTS (SELECT 1                      FROM grupo_economico g                     WHERE g.cli_cdgo = c.cli_cdgo                       AND g.status = 'A')  ORDER BY limite DESC";
    return query;
  }

}
