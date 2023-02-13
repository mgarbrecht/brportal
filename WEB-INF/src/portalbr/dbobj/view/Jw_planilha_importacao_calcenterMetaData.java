package portalbr.dbobj.view;

/** DataBase Object from table .Jw_planilha_importacao_calcenter
  * @version 11/12/2017 10:40:12
  */
public class Jw_planilha_importacao_calcenterMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","COLUNA1","400","false","text","","","","","","","",},
                            {"java.lang.String","COLUNA2","400","false","text","","","","","","","",},
                            {"java.lang.String","TT","400","false","text","","","","","","","",},
                            {"java.lang.String","PEDIDO_IGUAL","400","false","text","","","","","","","",},
                            {"java.lang.String","HIERARQUIA","400","false","text","","","","","","","",},
                            {"java.lang.String","TEXTO_MATERIAL","400","false","text","","","","","","","",},
                            {"java.lang.String","NOME","400","false","text","","","","","","","",},
                            {"java.lang.String","MARCA","400","false","text","","","","","","","",},
                            {"java.lang.String","REFERENCIA","400","false","text","","","","","","","",},
                            {"java.lang.String","COR_BASE","400","false","text","","","","","","","",},
                            {"java.lang.String","CLUSTER_CLIMA","400","false","text","","","","","","","",},
                            {"java.lang.String","EPOCA","400","false","text","","","","","","","",},
                            {"java.lang.String","COLECAO","400","false","text","","","","","","","",},
                            {"java.lang.String","CVP","400","false","text","","","","","","","",},
                            {"java.lang.Double","PRECO_COMPRA","22","false","text","","","","","","","",},
                            {"java.lang.Double","PRECO_VENDA","22","false","text","","","","","","","",},
                            {"java.lang.String","SEMANA","400","false","text","","","","","","","",},
                            {"java.lang.String","ANO","400","false","text","","","","","","","",},
                            {"java.lang.String","NUMERACAO","400","false","text","","","","","","","",},
                            {"java.lang.Integer","VOLUMES","22","false","text","","","","","","","",},
                            {"java.lang.String","LOCAL_ENTREGA","400","false","text","","","","","","","",},
                            {"java.lang.String","FORMA_COMPRA","400","false","text","","","","","","","",},
                            {"java.lang.String","CD_OU_FT","400","false","text","","","","","","","",},
                            {"java.lang.String","PROMOCIONAL","400","false","text","","","","","","","",},
                            {"java.lang.String","COND_PAGAMENTO","400","false","text","","","","","","","",},
                            {"java.lang.String","IMPORTADO","400","false","text","","","","","","","",},
                            {"java.lang.String","ESTOQUE_NO_CD","400","false","text","","","","","","","",},
                            {"java.lang.String","ARMAZENAGEM","400","false","text","","","","","","","",},
                            {"java.lang.String","ALTURA_DO_CANO","400","false","text","","","","","","","",},
                            {"java.lang.String","COR_FORNECEDOR","400","false","text","","","","","","","",},
                            {"java.lang.String","ESTAMPA","400","false","text","","","","","","","",},
                            {"java.lang.String","ESTILO_DO_PRODUTO","400","false","text","","","","","","","",},
                            {"java.lang.String","TIPO_MATERIAL","400","false","text","","","","","","","",},
                            {"java.lang.String","CABEDAL","400","false","text","","","","","","","",},
                            {"java.lang.String","CONSTRUCAO_DO_SALTO","400","false","text","","","","","","","",},
                            {"java.lang.String","TEMA_COLECAO","400","false","text","","","","","","","",},
                            {"java.lang.String","ALTURA_SALTO","400","false","text","","","","","","","",},
                            {"java.lang.String","BICO","400","false","text","","","","","","","",},
                            {"java.lang.String","ENFEITE","400","false","text","","","","","","","",},
                            {"java.lang.String","MATERIAL_SOLA","400","false","text","","","","","","","",},
                            {"java.lang.String","NCM","400","false","text","","","","","","","",},
                            {"java.lang.String","OBS","400","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT NULL coluna1       ,NULL coluna2       ,NULL tt       ,NULL pedido_igual       ,NULL hierarquia       ,'' texto_material       ,'' nome       ,'' marca       ,'' referencia       ,NULL cor_base        ,'' cluster_clima       ,'' epoca       ,'' colecao       ,'' cvp       ,null preco_compra       ,null preco_venda       ,'' semana       ,'' ano       ,NULL numeracao        ,null volumes        ,'' local_entrega        ,'' forma_compra        ,'' cd_ou_ft        ,'' promocional        ,'' cond_pagamento        ,'' importado        ,'' estoque_no_cd        ,'' armazenagem        ,'' altura_do_cano        ,t.descricao_cor cor_fornecedor        ,NULL estampa         ,NULL estilo_do_produto        ,'' tipo_material        ,NULL cabedal         ,'' construcao_do_salto        ,NULL tema_colecao        ,'' altura_salto        ,NULL bico         ,NULL enfeite         ,'' material_sola        ,'' ncm        ,'' obs   FROM ped       ,ite       ,cat_produtos_table          t       ,corrugados                  c       ,ecl       ,cat_produtos_dados_tecnicos cpdt  WHERE cpdt.lin_cdgo = ite.lin_cdgo    AND cpdt.ref_cdgo = ite.ref_cdgo    AND ped.cli_cdgo = ecl.cli_cdgo    AND ped.esc_seqn = ecl.esc_seqn    AND ecl.ned_cdgo IN ('ENT', 'UNI')    AND ite.codigo_corrugado = c.codigo    AND ped.ped_nmro = ite.ped_nmro    AND t.linha = ite.lin_cdgo    AND t.referencia = ite.ref_cdgo    AND t.cabedal = ite.cab_cdgo    AND t.cor = ite.cor_cdgo    AND t.codigo_idioma = 3    AND ped.ped_nmro IN (15396665)";
    return query;
  }

}
