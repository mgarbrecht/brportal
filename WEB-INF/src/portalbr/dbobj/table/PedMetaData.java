package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped
  * @version 21/08/2013 11:32:23
  */
public class PedMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PED_NMRO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.String","ped_nped","7","false","text","Ped_nped","","","","","","",},
                            {"int","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"int","esc_seqn","4","true","text","Esc_seqn","","","true","","","",},
                            {"int","cnd_cdgo","22","true","text","Cnd_cdgo","","","true","","","",},
                            {"int","tra_cdgo","22","true","text","Tra_cdgo","","","true","","","",},
                            {"int","liv_codigo","22","true","text","Liv_codigo","","","true","","","",},
                            {"java.sql.Timestamp","ped_daem","10","true","text","Ped_daem","","","true","","","",},
                            {"java.sql.Timestamp","ped_dadg","10","true","text","Ped_dadg","","","true","","","",},
                            {"java.sql.Timestamp","ped_det","10","true","text","Ped_det","","","true","","","",},
                            {"java.lang.String","ped_stat","2","true","text","Ped_stat","","","","","","",},
                            {"double","ped_boni","6","true","text","Ped_boni","","","true","","","",},
                            {"java.sql.Timestamp","ped_emba","10","false","text","Ped_emba","","","true","","","",},
                            {"java.lang.String","ped_tipo","2","true","text","Ped_tipo","","","","","","",},
                            {"double","ped_desc","6","true","text","Ped_desc","","","true","","","",},
                            {"double","ped_comr","6","true","text","Ped_comr","","","true","","","",},
                            {"java.lang.String","ped_roma","1","true","text","Ped_roma","","","","","","",},
                            {"java.lang.String","ped_frepag","25","false","text","Ped_frepag","","","","","","",},
                            {"java.lang.String","ped_obse","130","false","text","Ped_obse","","","","","","",},
                            {"int","ped_cons","22","false","text","Ped_cons","","","true","","","",},
                            {"double","ped_boni2","6","false","text","Ped_boni2","","","true","","","",},
                            {"java.lang.String","ped_usulib","30","false","text","Ped_usulib","","","","","","",},
                            {"java.sql.Timestamp","ped_datlib","10","false","text","Ped_datlib","","","true","","","",},
                            {"java.sql.Timestamp","ped_datpro","10","false","text","Ped_datpro","","","true","","","",},
                            {"java.sql.Timestamp","ped_datant","10","false","text","Ped_datant","","","true","","","",},
                            {"java.lang.String","ped_redg","1","false","text","Ped_redg","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","true","text","Rep_cdgo","","","","","","",},
                            {"java.lang.String","ped_pedido_consignado","1","false","text","Ped_pedido_consignado","","","","","","",},
                            {"java.sql.Timestamp","ped_data_faturamento","10","false","text","Ped_data_faturamento","","","true","","","",},
                            {"java.lang.String","ped_invoice","11","false","text","Ped_invoice","","","","","","",},
                            {"int","ped_recolocado","7","false","text","Ped_recolocado","","","true","","","",},
                            {"java.lang.String","ped_pino_anel","1","false","text","Ped_pino_anel","","","","","","",},
                            {"java.lang.String","ped_ped_cliente","20","false","text","Ped_ped_cliente","","","","","","",},
                            {"int","ped_tipo_corrugado","2","false","text","Ped_tipo_corrugado","","","true","","","",},
                            {"int","ped_forma_embalagem","2","false","text","Ped_forma_embalagem","","","true","","","",},
                            {"java.lang.String","moe_codigo","3","false","text","Moe_codigo","","","","","","",},
                            {"int","tipcob_codigo","2","false","text","Tipcob_codigo","","","true","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Fil_filial","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","Prt_codigo","","","","","","",},
                            {"java.lang.String","emp_empresa","3","true","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","ped_refaturamento","1","false","text","Ped_refaturamento","","","","","","",},
                            {"java.sql.Timestamp","ped_det_ant","10","false","text","Ped_det_ant","","","true","","","",},
                            {"java.lang.String","ped_liberacao_credito","1","false","text","Ped_liberacao_credito","","","","","","",},
                            {"java.lang.String","ped_indicador_credito","1","false","text","Ped_indicador_credito","","","","","","",},
                            {"java.sql.Timestamp","ped_data_prev_ind","10","false","text","Ped_data_prev_ind","","","true","","","",},
                            {"java.sql.Timestamp","ped_data_entra_tonel","10","false","text","Ped_data_entra_tonel","","","true","","","",},
                            {"java.lang.String","ped_observacoes_nf","1","false","text","Ped_observacoes_nf","","","","","","",},
                            {"java.lang.String","ped_especie_pedido","1","false","text","Ped_especie_pedido","","","","","","",},
                            {"java.lang.String","ped_proximo_tonel","1","false","text","Ped_proximo_tonel","","","","","","",},
                            {"java.sql.Timestamp","ped_data_aproximada_fatur","10","false","text","Ped_data_aproximada_fatur","","","true","","","",},
                            {"int","ped_total_pares","6","false","text","Ped_total_pares","","","true","","","",},
                            {"java.lang.String","ped_devolver_repres","1","false","text","Ped_devolver_repres","","","","","","",},
                            {"java.lang.String","ped_enviado_repres","1","false","text","Ped_enviado_repres","","","","","","",},
                            {"double","ped_peso_liquido","13","false","text","Ped_peso_liquido","","","true","","","",},
                            {"double","ped_peso_bruto","13","false","text","Ped_peso_bruto","","","true","","","",},
                            {"int","codigo_atendente","6","false","text","Codigo_atendente","","","true","","","",},
                            {"java.lang.String","ped_marca_segmento","1","false","text","Ped_marca_segmento","","","","","","",},
                            {"java.lang.String","ped_bloqueio_frete","1","false","text","Ped_bloqueio_frete","","","","","","",},
                            {"java.lang.String","ped_substituicao","1","false","text","Ped_substituicao","","","","","","",},
                            {"java.lang.String","ped_pacote","1","false","text","Ped_pacote","","","","","","",},
                            {"int","oco_numero","22","false","text","Oco_numero","","","true","","","",},
                            {"int","cod_min_fabr","2","false","text","Cod_min_fabr","","","true","","","",},
                            {"java.lang.String","ped_indic_super","1","false","text","Ped_indic_super","","","","","","",},
                            {"java.sql.Timestamp","ped_data_solicitada_cliente","10","false","text","Ped_data_solicitada_cliente","","","true","","","",},
                            {"java.sql.Timestamp","data_impressao_carta","10","false","text","Data_impressao_carta","","","true","","","",},
                            {"java.sql.Timestamp","data_embarque_porto","10","false","text","Data_embarque_porto","","","true","","","",},
                            {"java.lang.String","codigo_representante_adicional","5","false","text","Codigo_representante_adicional","","","","","","",},
                            {"double","percentual_comissao_adicional","6","false","text","Percentual_comissao_adicional","","","true","","","",},
                            {"java.lang.String","ped_usuario_liber_credito","30","false","text","Ped_usuario_liber_credito","","","","","","",},
                            {"java.lang.String","ped_libera_bonif","1","false","text","Ped_libera_bonif","","","","","","",},
                            {"java.lang.String","ped_empenho_direto","1","false","text","Ped_empenho_direto","","","","","","",},
                            {"java.lang.String","ped_amostra_brinde","1","false","text","Ped_amostra_brinde","","","","","","",},
                            {"int","les_codigo","5","false","text","Les_codigo","","","true","","","",},
                            {"java.lang.String","nf_ind_edi","1","false","text","Nf_ind_edi","","","","","","",},
                            {"int","ano_carta_credito","4","false","text","Ano_carta_credito","","","true","","","",},
                            {"java.lang.String","numero_carta_credito","30","false","text","Numero_carta_credito","","","","","","",},
                            {"java.lang.String","ped_carta_credito","1","false","text","Ped_carta_credito","","","","","","",},
                            {"double","mark_up","9","false","text","Mark_up","","","true","","","",},
                            {"java.sql.Timestamp","alteracao_sadig","10","false","text","Alteracao_sadig","","","true","","","",},
                            {"int","tipo_expositor1","2","false","text","Tipo_expositor1","","","true","","","",},
                            {"int","quantidade_expositor1","3","false","text","Quantidade_expositor1","","","true","","","",},
                            {"int","tipo_expositor2","2","false","text","Tipo_expositor2","","","true","","","",},
                            {"int","quantidade_expositor2","3","false","text","Quantidade_expositor2","","","true","","","",},
                            {"java.lang.String","ped_sequencial_maquina","15","false","text","Ped_sequencial_maquina","","","","","","",},
                            {"java.lang.String","ped_flag_credito","1","false","text","Ped_flag_credito","","","","","","",},
                            {"java.lang.String","ped_flag_tonel","1","false","text","Ped_flag_tonel","","","","","","",},
                            {"java.lang.String","ped_flag_estoque","1","false","text","Ped_flag_estoque","","","","","","",},
                            {"java.lang.String","ped_flag_cotas","1","false","text","Ped_flag_cotas","","","","","","",},
                            {"java.sql.Timestamp","data_log_afv","10","false","text","Data_log_afv","","","true","","","",},
                            {"java.lang.String","sinaliza_compra","1","false","text","Sinaliza_compra","","","","","","",},
                            {"double","percentual_comissao_venda","7","false","text","Percentual_comissao_venda","","","true","","","",},
                            {"double","percentual_comissao_fat","7","false","text","Percentual_comissao_fat","","","true","","","",},
                            {"double","percentual_comissao_neg_tit","7","false","text","Percentual_comissao_neg_tit","","","true","","","",},
                            {"java.lang.String","ped_codigo_vendedor","15","false","text","Ped_codigo_vendedor","","","","","","",},
                            {"java.lang.String","ped_forma_pagamento","1","false","text","Ped_forma_pagamento","","","","","","",},
                            {"double","ped_valor_bloqueto","16","false","text","Ped_valor_bloqueto","","","true","","","",},
                            {"double","percentual_comissao_bonif","7","false","text","Percentual_comissao_bonif","","","true","","","",},
                            {"double","taxa_vendor_comprador","8","false","text","Taxa_vendor_comprador","","","true","","","",},
                            {"java.lang.String","tipo_kit","1","false","text","Tipo_kit","","","","","","",},
                            {"java.sql.Timestamp","data_entrega_cliente","10","false","text","Data_entrega_cliente","","","true","","","",},
                            {"int","tra_cdgo_internar","22","false","text","Tra_cdgo_internar","","","true","","","",}
                          };
    return metadata;
  }

}
