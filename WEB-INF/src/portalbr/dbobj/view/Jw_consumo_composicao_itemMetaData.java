package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consumo_composicao_item
  * @version 11/08/2017 14:48:14
  */
public class Jw_consumo_composicao_itemMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","400","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","400","false","text","cor_desc","","","","","","",},
                            {"java.lang.Integer","cod_peca","22","false","text","cod_peca","","","","","","",},
                            {"java.lang.String","descricao_peca","4000","false","text","descricao_peca","","","","","","",},
                            {"java.lang.Integer","material","22","false","text","material","","","","","","",},
                            {"java.lang.String","descricao_material","4000","false","text","descricao_material","","","","","","",},
                            {"java.lang.String","unm_codigo","10","false","text","unm_codigo","","","","","","",},
                            {"java.lang.Integer","cor_mater","22","false","text","cor_mater","","","","","","",},
                            {"java.lang.String","descricao_cor_material","400","false","text","descricao_cor_material","","","","","","",},
                            {"java.lang.String","set_cdgo","20","false","text","set_cdgo","","","","","","",},
                            {"java.lang.Double","com_consum","22","false","text","com_consum","","","","","","",},
                            {"java.lang.String","com_espess","40","false","text","com_espess","","","","","","",},
                            {"java.lang.Double","dimensao_placa","22","false","text","dimensao_placa","","","","","","",},
                            {"java.lang.Double","mao_de_obra","22","false","text","mao_de_obra","","","","","","",},
                            {"java.lang.String","oc","10","false","text","oc","","","","","","",},
                            {"java.lang.String","rm","10","false","text","rm","","","","","","",},
                            {"java.lang.String","destino_mat","40","false","text","destino_mat","","","","","","",},
                            {"java.lang.String","com_compra","1","false","text","com_compra","","","","","","",},
                            {"java.lang.String","com_gerarm","1","false","text","com_gerarm","","","","","","",},
                            {"java.lang.String","com_destin","1","false","text","com_destin","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */  die.codigo ,die.descricao ,c.cor_cdgo ,c.cor_desc ,cc.cod_peca ,pck_pecas.get_nome(cc.cod_peca) descricao_peca ,cc.mat_nro material ,pck_item_estoque.get_nome(cc.mat_nro) descricao_material ,pck_item_estoque.get_unm_codigo(cc.mat_nro) unm_codigo ,cc.cor_mater ,pck_cor.get_nome(cc.cor_mater) descricao_cor_material ,cc.set_cdgo ,com_consum ,com_espess ,cc.dimensao_placa ,cc.mao_de_obra ,DECODE(NVL(com_compra, 'n'), 's', 'sim', 'não') oc ,DECODE(NVL(com_gerarm, 'n'), 's', 'sim', 'não') rm ,DECODE(com_destin, 'i', 'uso interno', 'f', 'uso outra filial', 't', 'uso terceiros') destino_mat ,com_compra ,com_gerarm ,com_destin   FROM dom_item_estoque      die       ,dom_item_cor          dic       ,cor                   c       ,componente_composicao cc  WHERE dic.ies_codigo = die.codigo    AND cc.ies_codigo = dic.ies_codigo    AND c.cor_cdgo = dic.cor_cdgo    AND cc.cor_cdgo = dic.cor_cdgo";
    return query;
  }

}
