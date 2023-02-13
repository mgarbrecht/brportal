package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_combinacao_especial
  * @version 05/11/2020 09:45:13
  */
public class Jw_ref_combinacao_especialMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","false","text","id_solicitacao","","","","","","",},
                            {"java.lang.String","usuario_solicitacao","30","false","text","usuario_solicitacao","","","","","","",},
                            {"java.sql.Timestamp","data_solicitacao","22","false","text","data_solicitacao","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","nome_marca","60","false","text","nome_marca","","","","","","",},
                            {"java.lang.String","nova_combinacao","1","false","text","Nova Combina��o","","","","","","",},
                            {"java.lang.String","alteracao_modelo","1","false","text","Altera��o de Modelo","","","","","","",},
                            {"java.lang.String","amostra","1","false","text","Amostra","","","","","","",},
                            {"java.sql.Timestamp","data_entrega_prevista","22","false","text","data_entrega_prevista","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.sql.Timestamp","data_entrega_solicitada","22","false","text","data_entrega_solicitada","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.sql.Timestamp","data_entrega_amostra","22","false","text","data_entrega_amostra","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","80","false","text","lin_nome","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","ref_desc","80","false","text","ref_desc","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","80","false","text","cab_desc","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","80","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","observacao","4000","false","text","observacao","","","","","","",},
                            {"java.lang.String","material_cor1","2000","false","text","material_cor1","","","","","","",},
                            {"java.lang.String","material_cor2","2000","false","text","material_cor2","","","","","","",},
                            {"java.lang.String","material_cor3","2000","false","text","material_cor3","","","","","","",},
                            {"java.lang.String","biqueira_debrum","2000","false","text","biqueira_debrum","","","","","","",},
                            {"java.lang.String","capa_palmilha","2000","false","text","capa_palmilha","","","","","","",},
                            {"java.lang.String","cacharel","2000","false","text","cacharel","","","","","","",},
                            {"java.lang.String","forro","2000","false","text","forro","","","","","","",},
                            {"java.lang.String","metais","2000","false","text","metais","","","","","","",},
                            {"java.lang.String","taloneira","2000","false","text","taloneira","","","","","","",},
                            {"java.lang.String","salto","2000","false","text","salto","","","","","","",},
                            {"java.lang.String","enfeite","2000","false","text","enfeite","","","","","","",},
                            {"java.lang.String","carimbo_etiqueta","2000","false","text","carimbo_etiqueta","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","80","false","text","cli_rzao","","","","","","",},
                            {"java.lang.Integer","gre_grupo","6","false","text","Grupo Econ�mico","","","","","","",},
                            {"java.lang.String","gre_descricao","30","false","text","gre_descricao","","","","","","",},
                            {"java.lang.String","rep_cdgo","6","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","30","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","regional","3","false","text","regional","","","","","","",},
                            {"java.lang.Integer","prs_negociacao","22","false","text","prs_negociacao","","","","","","",},
                            {"java.lang.Integer","pares_linha","22","false","text","pares_linha","","","","","","",},
                            {"java.lang.Integer","pares_alteracao","22","false","text","pares_alteracao","","","","","","",},
                            {"java.lang.Double","preco_liguido","22","false","text","preco_liguido","","","","","","",},
                            {"java.lang.Double","ll_alteracao_solicitada","22","false","text","ll_alteracao_solicitada","","","","","","",},
                            {"java.lang.String","situacao_solicitacao","1","false","text","situacao_solicitacao","","","","","","",},
                            {"java.lang.String","situacao_solicitacao_desc","9","false","text","situacao_solicitacao_desc","","","","","","",},
                            {"java.sql.Date","data_aceite","22","false","text","data_aceite","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","usuario_aceite","30","false","text","usuario_aceite","","","","","","",},
                            {"java.lang.String","imagem_produto","200","false","text","Imagem Produto","","","","","","",},
                            {"java.lang.String","imagem","200","false","text","imagem","","","","","","",},
                            {"java.lang.String","cliente_grupo_economico","2000","false","text","cliente_grupo_economico","","","","","","",},
                            {"java.lang.String","desenvolvimento","1","false","text","Desenvolvimento","","","","","","",},
                            {"java.sql.Timestamp","data_desenvolvimento","22","false","text","data_desenvolvimento","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","fora_mix","1","false","text","Fora Mix","","","","","","",},
                            {"java.sql.Timestamp","data_fora_mix","22","false","text","data_fora_mix","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","manipulacao","1","false","text","Manipula��o","","","","","","",},
                            {"java.sql.Timestamp","data_manipulacao","22","false","text","Data Manipula��o","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","modelo_exclusivo","1","false","text","Modelo Exclusivo","","","","","","",},
                            {"java.lang.String","tipo_solicitacao_comb_especial","100","false","text","tipo_solicitacao_comb_especial","","","","","","",},
                            {"java.lang.String","subtipo_solicitacao_comb_espec","100","false","text","subtipo_solicitacao_comb_espec","","","","","","",},
                            {"java.lang.String","desc_solicitacao_comb_especial","1000","false","text","desc_solicitacao_comb_especial","","","","","","",},
                            {"java.lang.String","desc_subtipo_comb_espec","1000","false","text","desc_subtipo_comb_espec","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","Descri��o","","","","","","",},
                            {"java.sql.Timestamp","data_aprovacao","22","false","text","data_aprovacao","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","material","1","false","text","Material","","","","","","",},
                            {"java.lang.Double","valor_fabricacao","22","false","text","valor_fabricacao","","","","","","",},
                            {"java.lang.Double","valor_pdv","22","false","text","valor_pdv","","","","","","",},
                            {"java.lang.Double","ll_0","22","false","text","ll_0","","","","","","",},
                            {"java.lang.Double","ll_1","22","false","text","ll_1","","","","","","",},
                            {"java.lang.Double","ll_2","22","false","text","ll_2","","","","","","",},
                            {"java.lang.Double","ll_3","22","false","text","ll_3","","","","","","",},
                            {"java.lang.Double","preco_vendor","22","false","text","preco_vendor","","","","","","",},
                            {"java.lang.Integer","pares_vendidos","22","false","text","pares_vendidos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rce.id_solicitacao      , rce.usuario_solicitacao      , rce.data_solicitacao      , rce.codigo_marca      , pck_marcas_produtos.get_nome(rce.codigo_marca) nome_marca      , rce.nova_combinacao      , rce.alteracao_modelo      , rce.amostra      , rce.data_entrega_prevista      , rce.data_entrega_solicitada	  , rce.data_entrega_amostra      , rce.lin_cdgo      , pck_linha.get_nome(rce.lin_cdgo) lin_nome      , rce.ref_cdgo      , pck_referencia.get_nome(rce.lin_cdgo, rce.ref_cdgo) ref_desc      , rce.cab_cdgo      , pck_cabedal.get_nome(rce.cab_cdgo) cab_desc      , rce.cor_cdgo      , pck_cor.get_nome(rce.cor_cdgo) cor_desc      , rce.observacao      , rce.material_cor1      , rce.material_cor2      , rce.material_cor3      , rce.biqueira_debrum      , rce.capa_palmilha      , rce.cacharel      , rce.forro      , rce.metais      , rce.taloneira      , rce.salto      , rce.enfeite      , rce.carimbo_etiqueta      , rce.cli_cdgo      , pck_cliente.get_nome(rce.cli_cdgo) cli_rzao      , rce.gre_grupo      , pck_grupo_economico.get_nome(rce.gre_grupo) gre_descricao 	  , rce.rep_cdgo	  , pck_representante.get_razao_social(rce.rep_cdgo) rep_rzao	  , pck_regionais_vendas.get_sigla(pck_representante.get_regional(rce.rep_cdgo)) regional      , rce.prs_negociacao      , rce.pares_linha      , rce.pares_alteracao      , rce.preco_liguido      , rce.ll_alteracao_solicitada      , rce.situacao_solicitacao      , decode(rce.situacao_solicitacao, 'A','Aprovada','P','Pendente','R','Reprovada','E','Em Aprova��o','') situacao_solicitacao_desc      , rce.data_aceite      , rce.usuario_aceite	  , rce.imagem_produto    , rcei.imagem      , decode(rce.gre_grupo,null,(rce.cli_cdgo||' - '||pck_cliente.get_nome(rce.cli_cdgo) ),rce.gre_grupo || ' - ' || pck_grupo_economico.get_nome(rce.gre_grupo) || ' (<small>' || replace(rowtocol('SELECT cli_Cdgo FROM grupo_economico ge WHERE ge.gre_grupo = '||rce.gre_grupo||' AND status = ''A'''),',',', ') || '</small>)') cliente_grupo_economico   	  , rce.desenvolvimento	  , rce.data_desenvolvimento	  , rce.fora_mix	  , rce.data_fora_mix      , rce.manipulacao      , rce.data_manipulacao	  	  , rce.modelo_exclusivo	  , rce.tipo_solicitacao_comb_especial	  , rce.subtipo_solicitacao_comb_espec      , cgr.rv_meaning desc_solicitacao_comb_especial      , crc.rv_meaning desc_subtipo_comb_espec	  , rce.descricao      , rce.data_aprovacao      , rce.material	        , rce.valor_fabricacao		  , rce.valor_pdv      , rce.ll_0	  	  , rce.ll_1	  , rce.ll_2	  , rce.ll_3	  , rce.preco_vendor	  , 0 pares_vendidos  FROM brio.ref_combinacao_especial rce      ,brio.ref_combinacao_especial_img rcei      ,cg_ref_codes                 cgr      ,cg_ref_codes                 crc WHERE rce.id_solicitacao = rcei.id_solicitacao(+)   AND cgr.rv_domain(+) = 'TIPO_SOLICITACAO_COMB_ESPECIAL'   AND cgr.rv_low_value(+) = rce.tipo_solicitacao_comb_especial   AND cgr.rv_domain(+) = 'SUBTIPO_SOLICITACAO_COMB_ESPEC'   AND cgr.rv_low_value(+) = rce.subtipo_solicitacao_comb_espec  ORDER BY id_solicitacao DESC";
    return query;
  }

}
