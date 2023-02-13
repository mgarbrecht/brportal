package portalbr.dbobj.view;

/** DataBase Object from table .Jw_abastecimento_materiais
  * @version 22/08/2013 10:50:08
  */
public class Jw_abastecimento_materiaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Long","fornecedor_codigo","22","false","text","Fornecedor_codigo","","","","","","",},
                            {"java.lang.Integer","fen_seq","22","false","text","Fen_seq","","","","","","",},
                            {"java.lang.Long","codigo","22","false","text","","","","","","","",},
                            {"java.lang.String","descricao","200","false","text","descricao","","","","","","",},
                            {"java.lang.String","unm_codigo","3","false","text","unm_codigo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","120","false","text","cor_desc","","","","","","",},
                            {"java.lang.Double","saldo","22","false","text","saldo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT fornecedor_codigo      ,fen_seq      ,codigo      ,descricao      ,unm_codigo      ,cor_cdgo      ,cor_desc      ,NVL(SUM(saldo), 0) + saldo_estoque_17_19_1_1 + saldo_estoque_17_19_17_1 saldo  FROM (SELECT tpr.for_codigo fornecedor_codigo              ,tpr.fen_seq              ,i.codigo              ,i.descricao              ,i.unm_codigo              ,s.cor_cdgo              ,c.cor_desc              ,s.sdo_req saldo              ,fct_saldo_reposicao(s.fil_filial, i.codigo, s.cor_cdgo, s.tai_codigo, 1) repos              ,fct_saldo_estoque_atual('01', '17', '01', i.codigo, s.cor_cdgo, s.tai_codigo, 19, 1, 1) saldo_estoque_17_19_1_1              ,fct_saldo_estoque_atual('01', '17', '01', i.codigo, s.cor_cdgo, s.tai_codigo, 19, 17, 1) saldo_estoque_17_19_17_1          FROM req_sdo_abastecimento s              ,filial f              ,cor c              ,dom_item_estoque i              ,dom_tabela_preco tpr              ,for_endere fe              ,dom_item_fornecedor ifo              ,est.dom_grupo_material_x_poi dgmp         WHERE s.emp_empresa = '01'           AND dgmp.gpo_cdgo_poi = NVL(i.gpo_codigo, NULL)           AND s.ies_codigo = i.codigo           AND s.cor_cdgo = c.cor_cdgo           AND s.emp_empresa = f.emp_empresa           AND s.fil_filial = f.fil_filial           AND tpr.ies_codigo = s.ies_codigo           AND tpr.cor_cdgo = s.cor_cdgo           AND tpr.tai_codigo = s.tai_codigo           AND tpr.emp_empresa = s.emp_empresa           AND tpr.fil_filial = s.fil_filial           AND tpr.unn_codigo = f.unn_codigo           AND NVL(tpr.data_liberacao_diretor, NULL) >= TRUNC(SYSDATE)           AND NVL(tpr.status, NULL) = 'A'           AND tpr.for_codigo = 343           AND tpr.data_geracao = (SELECT MAX(tab.data_geracao)                                     FROM dom_tabela_preco tab                                    WHERE tab.ies_codigo = tpr.ies_codigo                                      AND tab.cor_cdgo = tpr.cor_cdgo                                      AND tab.tai_codigo = tpr.tai_codigo                                      AND tab.emp_empresa = tpr.emp_empresa                                      AND tab.fil_filial = tpr.fil_filial                                      AND tab.status = 'A')           AND ifo.for_codigo = tpr.for_codigo           AND ifo.fen_seq = tpr.fen_seq           AND ifo.ies_codigo = tpr.ies_codigo           AND ifo.cor_cdgo = tpr.cor_cdgo           AND ifo.tai_codigo = tpr.tai_codigo           AND ifo.emp_empresa = NVL(tpr.emp_empresa, NULL)           AND ifo.fil_filial = NVL(tpr.fil_filial, NULL)           AND ifo.unn_codigo = NVL(tpr.unn_codigo, NULL)           AND fe.for_codigo = ifo.for_codigo           AND fe.fen_seq = ifo.fen_seq           AND fe.fen_ativo = 'S') GROUP BY fornecedor_codigo         ,fen_seq         ,codigo         ,descricao         ,unm_codigo         ,cor_cdgo         ,cor_desc         ,saldo_estoque_17_19_1_1         ,saldo_estoque_17_19_17_1HAVING SUM(saldo) < 0";
    return query;
  }

}
