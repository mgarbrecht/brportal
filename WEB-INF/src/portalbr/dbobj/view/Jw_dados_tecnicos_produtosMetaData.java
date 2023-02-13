package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dados_tecnicos_produtos
  * @version 19/01/2022 11:53:25
  */
public class Jw_dados_tecnicos_produtosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","ped_ped_cliente","100","false","text","ped_ped_cliente","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","240","false","text","cab_desc","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","descricao_cor","60","false","text","descricao_cor","","","","","","",},
                            {"java.lang.String","desc_produto","400","false","text","desc_produto","","","","","","",},
                            {"java.lang.String","qtp_nume","5","false","text","qtp_nume","","","","","","",},
                            {"java.lang.Integer","qtp_pars","22","false","text","qtp_pars","","","","","","",},
                            {"java.lang.Double","ite_prco","22","false","text","ite_prco","","","","","","",},
                            {"java.lang.String","id_produto","400","false","text","id_produto","","","","","","",},
                            {"java.lang.Integer","marca","22","false","text","marca","","","","","","",},
                            {"java.lang.String","marca_descricao","100","false","text","marca_descricao","","","","","","",},
                            {"java.lang.String","filial","10","false","text","filial","","","","","","",},
                            {"java.lang.Long","cnpj","30","false","text","cnpj","","","","","","",},
                            {"java.lang.Long","ean13","100","false","text","ean13","","","","","","",},
                            {"java.lang.String","dun14","100","false","text","dun14","","","","","","",},
                            {"java.lang.String","classificacao_fiscal","100","false","text","classificacao_fiscal","","","","","","",},
                            {"java.lang.String","comp_larg_alt_embalagem","400","false","text","comp_larg_alt_embalagem","","","","","","",},
                            {"java.lang.Double","peso_embalamgem","22","false","text","peso_embalamgem","","","","","","",},
                            {"java.lang.Double","peso_sapato","25","false","text","peso_sapato","","","","","","",},
                            {"java.lang.String","ra_fornecedor","100","false","text","ra_fornecedor","","","","","","",},
                            {"java.lang.String","razao_social","100","false","text","razao_social","","","","","","",},
                            {"java.lang.String","ref_fechamento_sapato","60","false","text","ref_fechamento_sapato","","","","","","",},
                            {"java.lang.String","ref_tipo_salto","60","false","text","ref_tipo_salto","","","","","","",},
                            {"java.lang.String","ref_bota_possui_elastico","10","false","text","ref_bota_possui_elastico","","","","","","",},
                            {"java.lang.Integer","ref_tip_mat_cdgo_palmilha","22","false","text","ref_tip_mat_cdgo_palmilha","","","","","","",},
                            {"java.lang.String","tip_mat_palmilha_descricao","200","false","text","tip_mat_palmilha_descricao","","","","","","",},
                            {"java.lang.Integer","ref_tip_mat_cdgo_entresola","22","false","text","ref_tip_mat_cdgo_entresola","","","","","","",},
                            {"java.lang.String","tip_mat_entresola_descricao","200","false","text","tip_mat_entresola_descricao","","","","","","",},
                            {"java.lang.Integer","ref_tip_mat_cdgo_salto","22","false","text","ref_tip_mat_cdgo_salto","","","","","","",},
                            {"java.lang.String","tip_mat_salto_descricao","200","false","text","tip_mat_salto_descricao","","","","","","",},
                            {"java.lang.Integer","ref_tip_mat_cdgo_meiapata","22","false","text","ref_tip_mat_cdgo_meiapata","","","","","","",},
                            {"java.lang.String","tip_mat_meiapata_descricao","200","false","text","tip_mat_meiapata_descricao","","","","","","",},
                            {"java.lang.String","ref_dimensao_cx_individual","200","false","text","ref_dimensao_cx_individual","","","","","","",},
                            {"java.lang.String","dimensao_caixa_descricao","400","false","text","dimensao_caixa_descricao","","","","","","",},
                            {"java.lang.String","observacao","400","false","text","observacao","","","","","","",},
                            {"java.lang.Double","ref_largura_interna_pe","22","false","text","ref_largura_interna_pe","","","","","","",},
                            {"java.lang.Double","ref_compr_interno_pe","22","false","text","ref_compr_interno_pe","","","","","","",},
                            {"java.lang.Double","ref_altura_sapato","22","false","text","ref_altura_sapato","","","","","","",},
                            {"java.lang.Double","ref_largura_ext_sapato","22","false","text","ref_largura_ext_sapato","","","","","","",},
                            {"java.lang.Double","ref_compr_ext_sapato","22","false","text","ref_largura_ext_sapato","","","","","","",},
                            {"java.lang.Double","ref_altura_salto","22","false","text","ref_altura_salto","","","","","","",},
                            {"java.lang.Double","ref_altura_meiapata","22","false","text","ref_altura_meiapata","","","","","","",},
                            {"java.lang.Double","ref_altura_canobota","22","false","text","ref_altura_canobota","","","","","","",},
                            {"java.lang.Double","ref_diametro_boca_bota","22","false","text","ref_diametro_boca_bota","","","","","","",},
                            {"java.lang.String","grupo_posicao_fabrica","100","false","text","grupo_posicao_fabrica","","","","","","",},
                            {"java.lang.String","tipo_material_predominante","100","false","text","tipo_material_predominante","","","","","","",},
                            {"java.lang.String","tipo_material_solado","100","false","text","tipo_material_solado","","","","","","",},
                            {"java.lang.String","tipo_material_forro","100","false","text","tipo_material_forro","","","","","","",},
                            {"java.lang.Double","ref_perc_cabedal","22","false","text","ref_perc_cabedal","","","","","","",},
                            {"java.lang.Double","ref_perc_solado","22","false","text","ref_perc_soldado","","","","","","",},
                            {"java.lang.String","fci","200","false","text","fct","","","","","","",},
                            {"java.lang.String","cst","60","false","text","cst","","","","","","",},
                            {"java.lang.String","tipo_material_palmilha","200","false","text","tipo_material_palmilha","","","","","","",},
                            {"java.lang.String","tem_etiqueta","200","false","text","tem_etiqueta","","","","","","",},
                            {"java.lang.String","ref_dimensao_cx_individual_descricao","200","false","text","ref_dimensao_cx_individual_descricao","","","","","","",},
                            {"java.lang.String","mix_produtos","400","false","text","mix_produtos","","","","","","",},
                            {"java.lang.String","numero_exterior","60","false","text","numero_exterior","","","","","","",},
                            {"java.lang.Double","preco_pdv","22","false","text","preco_pdv","","","","","","",},
                            {"java.lang.Double","comprimento_embalagem","22","false","text","comprimento_embalagem","","","","","","",},
                            {"java.lang.Double","largura_embalagem","22","false","text","largura_embalagem","","","","","","",},
                            {"java.lang.Double","altura_embalagem","22","false","text","altura_embalagem","","","","","","",},
                            {"java.lang.String","comprimento_caixa","22","false","text","comprimento_caixa","","","","","","",},
                            {"java.lang.String","largura_caixa","22","false","text","largura_caixa","","","","","","",},
                            {"java.lang.String","altura_caixa","22","false","text","altura_caixa","","","","","","",},
                            {"java.lang.String","altura_alca","100","false","text","altura_alca","","","","","","",},
                            {"java.lang.String","altura_bolsa","100","false","text","altura_bolsa","","","","","","",},
                            {"java.lang.String","bolso_interno","100","false","text","bolso_interno","","","","","","",},
                            {"java.lang.String","fechamento_bolsa","100","false","text","fechamento_bolsa","","","","","","",},
                            {"java.lang.String","largura_bolsa","100","false","text","largura_bolsa","","","","","","",},
                            {"java.lang.String","peso_bolsa","100","false","text","peso_bolsa","","","","","","",},
                            {"java.lang.String","profundidade_bolsa","100","false","text","profundidade_bolsa","","","","","","",},
                            {"java.lang.String","quantidade_bolsos","100","false","text","quantidade_bolsos","","","","","","",},
                            {"java.lang.String","regulagem","100","false","text","regulagem","","","","","","",},
                            {"java.lang.String","tipo_alca","100","false","text","tipo_alca","","","","","","",},
                            {"java.lang.Integer","ite_seqn","22","false","text","ite_seqn","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT                  p.ped_nmro				,p.ped_ped_cliente                ,i.lin_cdgo                ,i.ref_cdgo                ,i.cab_cdgo                ,'' cab_desc                ,i.cor_cdgo                ,r.cor_desc descricao_cor                ,pck_item_estoque.get_nome(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)) || ' ' || TO_CHAR(pck_cor.get_nome(i.cor_cdgo)) || ' ' || q.qtp_nume desc_produto                ,q.qtp_nume                ,q.qtp_pars                ,i.ite_prco                ,EST.fct_ies_codigo_nativo(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo),i.cor_cdgo, q.qtp_nume) id_produto                ,fct_marca_produto(i.lin_cdgo, i.ref_cdgo) marca                ,pck_marcas_produtos.get_nome(fct_marca_produto(i.lin_cdgo, i.ref_cdgo)) marca_descricao                ,fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) filial                ,pck_filial.get_cnpj(fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn)) cnpj                ,brio.fct_retorna_cod_barra(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, q.qtp_nume) ean13                ,pck_item_estoque.get_classificacao_fiscal(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo)) classificacao_fiscal                ,TO_CHAR(fe.mat_nro) || '-' || pck_item_estoque.get_nome(fe.mat_nro) comp_larg_alt_embalagem                ,pso.peso_embalagem + pso.peso_sapato + pso.peso_adicional peso_embalamgem                ,pso.peso_sapato peso_sapato                ,TO_CHAR(i.lin_cdgo) || '-' || TO_CHAR(i.ref_cdgo) ra_fornecedor                ,pck_filial.get_nome(fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn)) razao_social                ,ria.ref_fechamento_sapato                ,ria.ref_tipo_salto                ,ria.ref_bota_possui_elastico                ,ria.ref_tip_mat_cdgo_palmilha                ,pck_tipo_material.get_nome(ria.ref_tip_mat_cdgo_palmilha) tip_mat_palmilha_descricao                ,ria.ref_tip_mat_cdgo_entresola                ,pck_tipo_material.get_nome(ria.ref_tip_mat_cdgo_entresola) tip_mat_entresola_descricao                ,ria.ref_tip_mat_cdgo_salto                ,pck_tipo_material.get_nome(ria.ref_tip_mat_cdgo_salto) tip_mat_salto_descricao                ,ria.ref_tip_mat_cdgo_meiapata                ,pck_tipo_material.get_nome(ria.ref_tip_mat_cdgo_meiapata) tip_mat_meiapata_descricao                ,ria.ref_dimensao_cx_individual                ,pck_item_estoque.get_nome(ria.ref_dimensao_cx_individual) dimensao_caixa_descricao                ,ria.observacao                ,rian.ref_largura_interna_pe                ,rian.ref_compr_interno_pe                ,rian.ref_altura_sapato                ,rian.ref_largura_ext_sapato                ,rian.ref_compr_ext_sapato                ,rian.ref_altura_salto                ,rian.ref_altura_meiapata                ,rian.ref_altura_canobota                ,rian.ref_diametro_boca_bota                ,pck_grupo_posicao_fabrica.get_nome(r.ref_grupo_posicao_fab) grupo_posicao_fabrica                ,(SELECT c.tip_mat_cdgo || ' - '|| t.descricao FROM cabedal c,tipo_material t WHERE c.tip_mat_cdgo = t.codigo AND c.cab_cdgo = i.cab_cdgo) tipo_material_predominante                ,(select t.descricao from tipo_material t where T.CODIGO = r.sol_codigo) tipo_material_solado                ,'' tipo_material_forro               ,ria.ref_perc_cabedal               ,ria.ref_perc_solado               , (SELECT x.codigo_controle_fci FROM rdo.dom_item_estoque_cst_imp_calc x WHERE est.fct_ies_codigo_nativo(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo),i.cor_cdgo, q.qtp_nume) = x.id_item) fci               , DECODE((SELECT x.codigo_controle_fci FROM rdo.dom_item_estoque_cst_imp_calc x WHERE est.fct_ies_codigo_nativo(fct_ies_codigo(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo),i.cor_cdgo, q.qtp_nume) = x.id_item),NULL,0,5) cst                            ,(SELECT UPPER(tipo_material.rv_meaning)                          FROM ficha_tec f                              ,(SELECT crc.*                                  FROM cg_ref_codes crc                                 WHERE crc.rv_domain = 'CLASSIFICACAO_NCM') tipo_material                         WHERE f.lin_cdgo = rc.lin_cdgo                           AND f.ref_cdgo = rc.ref_cdgo                           AND f.cab_cdgo = rc.cab_cdgo                           AND f.cor_cdgo = 0                           AND tipo_material.rv_low_value = f.tipo_material_palmilha                           AND NVL(f.fit_status, NULL) = 'A'                           AND ROWNUM = 1) tipo_material_palmilha                        ,'' ref_dimensao_cx_individual_descricao               ,null mix_produtos               ,'' numero_exterior			   ,0.0 preco_pdv			   ,comprimento_embalagem			   ,largura_embalagem			   ,altura_embalagem			   ,'' comprimento_caixa			   ,'' largura_caixa			   ,'' altura_caixa			   ,to_char(ria.altura_alca) altura_alca                ,to_char(ria.altura_bolsa) altura_bolsa                ,to_char(ria.bolso_interno) bolso_interno                ,to_char(ria.tipo_fechamento) fechamento_bolsa               ,to_char(ria.largura_bolsa) largura_bolsa               ,to_char(ria.peso_bolsa) peso_bolsa               ,to_char(ria.profundidade_bolsa) profundidade_bolsa               ,to_char(ria.qtd_bolsos) quantidade_bolsos               ,to_char(ria.regulagem) regulagem               ,to_char(ria.tipo_alca) tipo_alca	               ,null ite_seqn			      FROM ped p       ,ite i       ,qtd_prg q       ,ref r       ,ref_inf_adicionais ria       ,ref_inf_adicionais_num rian       ,peso_numeros pso       ,ficha_embalagem fe       ,grupo_economico ge       ,cor r  WHERE p.ped_nmro = i.ped_nmro    AND i.ped_nmro = q.ped_nmro    AND i.ite_seqn = q.ite_seqn    AND pso.lin_cdgo = i.lin_cdgo    AND pso.ref_cdgo = i.ref_cdgo    AND fe.lin_cdgo = i.lin_cdgo    AND fe.ref_cdgo = i.ref_cdgo    AND r.lin_cdgo = i.lin_cdgo    AND r.ref_cdgo = r.ref_cdgo      AND ria.lin_cdgo(+) = i.lin_cdgo    AND ria.ref_cdgo(+) = i.ref_cdgo    AND rian.lin_cdgo(+) = pso.lin_cdgo    AND rian.ref_cdgo(+) = pso.ref_cdgo    AND rian.rfn_numero(+) = pso.numero    AND NVL(pso.codigo_embalagem, NULL) = 1    AND pso.numero = q.qtp_nume    AND pso.codigo_embalagem = fe.codigo    AND p.cli_cdgo = ge.cli_cdgo    AND r.cor_cdgo = i.cor_cdgo    AND NVL(p.ped_stat, NULL) <> 'C'    AND ROWNUM = 1";
    return query;
  }

}
