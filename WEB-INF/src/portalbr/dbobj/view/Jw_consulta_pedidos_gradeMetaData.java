package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_grade
  * @version 15/02/2021 15:55:33
  */
public class Jw_consulta_pedidos_gradeMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","filial_pedido","22","false","text","filial_pedido","","","","","","",},
                            {"java.lang.Integer","grade","22","false","text","grade","","","","","","",},
                            {"java.lang.Integer","item","22","false","text","item","","","","","","",},
                            {"java.lang.String","refer","4000","false","text","refer","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.String","cor","103","false","text","cor","","","","","","",},
                            {"double","quant","22","false","text","quant","","","","","","",},
                            {"java.lang.Double","preco","27","false","text","preco","","","","","","",},
                            {"java.lang.Double","item_preco","27","false","text","item_preco","","","","","","",},
                            {"java.lang.Double","total","22","false","text","total","","","","","","",},
                            {"java.lang.String","cabedal","78","false","text","cabedal","","","","","","",},
                            {"java.lang.String","imagem","300","false","text","imagem","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","les_codigo","22","false","text","les_codigo","","","","","","",},
                            {"java.lang.Integer","codigo_corrugado","22","false","text","codigo_corrugado","","","","","","",},
                            {"java.lang.String","descricao_corrugado","22","false","text","descricao_corrugado","","","","","","",},
                            {"java.lang.String","ite_situ","100","false","text","ite_situ","","","","","","",},
                            {"java.lang.String","distribuicao","100","false","text","distribuicao","","","","","","",},
                            {"java.lang.String","ncm","100","false","text","ncm","","","","","","",},
                            {"java.lang.String","aceita_descontos","100","false","text","aceita_descontos","","","","","","",},
                            {"java.lang.Integer","tes_codigo","22","false","text","tes_codigo","","","","","","",},
                            {"java.lang.Double","preco_pdv","22","false","text","preco_pdv","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select ped_nmro,       fct_retorna_fil_producao(ped_nmro, i.ite_seqn) filial_pedido,       i.gde_cdgo grade,       ite_seqn item,       fct_mask_modelo(i.lin_cdgo, i.ref_cdgo) refer,       substr(ite_descricao, 1, 30) descricao,       c.cor_cdgo || ' - ' || cor_desc Cor,       ite_qtde Quant,       ite_prco Preco,       ite_prco * ite_qtde Total,       cab.cab_cdgo || ' - ' || cab.cab_desc cabedal,       ft.fit_imagem imagem,       0 lin_cdgo,       0 ref_cdgo,       0 les_codigo,       0 codigo_corrugado,       '' descricao_corrugado,       '' ite_situ,       '' distribuicao,       '' ncm,       '' aceita_descontos,       0 tes_codigo,       i.ite_preco_venda,	   '' preco_pdv  from ite i, cor c, cabedal cab, ficha_tec ft where ped_nmro = 18596578   and cab.cab_cdgo = i.cab_cdgo   and i.cor_cdgo = c.cor_cdgo   and ft.lin_cdgo = i.lin_cdgo   and ft.ref_cdgo = i.ref_cdgo   and ft.cab_cdgo = i.cab_cdgo group by ite_seqn,          i.lin_cdgo,          i.ref_cdgo,          ite_descricao,          ite_qtde,          ite_prco,          c.cor_cdgo,          cor_desc,          i.gde_cdgo,          ped_nmro,          cab.cab_cdgo,          cab.cab_desc,          ft.fit_imagem,          i.ite_preco_venda";
    return query;
  }

}
