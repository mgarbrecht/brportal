package portalbr.dbobj.table;

/** DataBase Object from table BRCONREC.Titulos
  * @version 02/07/2015 10:48:43
  */
public class TitulosMetaData {

  public static final String SCHEMA = "BRCONREC";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"EMP_EMPRESA","FIL_FILIAL","TIP_CODIGO","TIT_CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TITULOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","true","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","true","text","Fil_filial","","","","","","",},
                            {"java.lang.String","tip_codigo","3","true","text","Tip_codigo","","","","","","",},
                            {"java.lang.String","tit_codigo","8","true","text","Tit_codigo","","","","","","",},
                            {"java.lang.Integer","cli_codigo","5","true","text","Cli_codigo","","","true","","","",},
                            {"java.lang.Integer","esc_seqn","4","true","text","Esc_seqn","","","true","","","",},
                            {"java.lang.String","trn_codigo","3","false","text","Trn_codigo","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","Prt_codigo","","","","","","",},
                            {"java.lang.String","rep_codigo","5","false","text","Rep_codigo","","","","","","",},
                            {"java.lang.String","car_codigo","4","false","text","Car_codigo","","","","","","",},
                            {"java.sql.Timestamp","tit_datemi","19","true","text","Tit_datemi","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","tit_datvenc","19","true","text","Tit_datvenc","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Double","tit_valor","16","true","text","Tit_valor","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_dsante","10","true","text","Tit_dsante","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_dspont","10","true","text","Tit_dspont","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_vlrec","16","true","text","Tit_vlrec","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_abatim","14","true","text","Tit_abatim","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_vldesc","12","true","text","Tit_vldesc","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_vljuro","12","true","text","Tit_vljuro","","##,##0.00","true","","","",},
                            {"java.lang.String","tit_status","1","false","text","Tit_status","","","","","","",},
                            {"java.lang.String","tit_envcob","1","false","text","Tit_envcob","","","","","","",},
                            {"java.lang.String","tit_cheque","1","false","text","Tit_cheque","","","","","","",},
                            {"java.lang.String","tit_altvct","1","false","text","Tit_altvct","","","","","","",},
                            {"java.lang.String","tit_condes","1","false","text","Tit_condes","","","","","","",},
                            {"java.lang.String","tit_cobjur","1","false","text","Tit_cobjur","","","","","","",},
                            {"java.sql.Timestamp","tit_datrec","19","false","text","Tit_datrec","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","tit_datcre","19","false","text","Tit_datcre","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","tit_agecob","5","false","text","Tit_agecob","","","","","","",},
                            {"java.sql.Timestamp","tit_dtutrans","19","false","text","Tit_dtutrans","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","tit_numbco","12","false","text","Tit_numbco","","","","","","",},
                            {"java.lang.String","tit_observa","50","false","text","Tit_observa","","","","","","",},
                            {"java.lang.Double","tit_vlcor","14","true","text","Tit_vlcor","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_outval","12","true","text","Tit_outval","","##,##0.00","true","","","",},
                            {"java.sql.Timestamp","tit_dt_emissao_triplicata","19","false","text","Tit_dt_emissao_triplicata","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","tit_dt_emissao_anuencia","19","false","text","Tit_dt_emissao_anuencia","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","tit_representante_antigo","3","false","text","Tit_representante_antigo","","","","","","",},
                            {"java.lang.String","tit_ageced","5","false","text","Tit_ageced","","","","","","",},
                            {"java.lang.String","tit_quality","1","false","text","Tit_quality","","","","","","",},
                            {"java.sql.Timestamp","tit_dt_emissao_ins_protesto","19","false","text","Tit_dt_emissao_ins_protesto","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","tit_dt_receb_protesto","19","false","text","Tit_dt_receb_protesto","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Double","tit_vlpcp","14","false","text","Tit_vlpcp","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_vldeb","14","false","text","Tit_vldeb","","##,##0.00","true","","","",},
                            {"java.lang.Double","tit_vlliq","14","false","text","Tit_vlliq","","##,##0.00","true","","","",},
                            {"java.lang.String","tipo_de_mercado","2","false","text","Tipo_de_mercado","","","","","","",},
                            {"java.lang.String","sit_codigo_situacao_titulo","3","false","text","Sit_codigo_situacao_titulo","","","","","","",},
                            {"java.sql.Timestamp","data_de_vencimento_original","19","false","text","Data_de_vencimento_original","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","protestar","1","false","text","Protestar","","","","","","",},
                            {"java.lang.Integer","numero_dias_para_protesto","3","false","text","Numero_dias_para_protesto","","","true","","","",},
                            {"java.lang.Double","valor_despesa_bancaria","16","false","text","Valor_despesa_bancaria","","##,##0.00","true","","","",},
                            {"java.lang.Double","valor_atualizacao_cambial","16","false","text","Valor_atualizacao_cambial","","##,##0.00","true","","","",},
                            {"java.lang.Double","valor_variacao_cambial","16","false","text","Valor_variacao_cambial","","##,##0.00","true","","","",},
                            {"java.lang.Integer","rev_codigo_regional","3","false","text","Rev_codigo_regional","","","true","","","",},
                            {"java.lang.Integer","grv_codigo_gerente","5","false","text","Grv_codigo_gerente","","","true","","","",},
                            {"java.lang.Double","taxa_de_juros","7","false","text","Taxa_de_juros","","##,##0.00","true","","","",},
                            {"java.sql.Timestamp","data_log_afv","19","false","text","Data_log_afv","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Double","percentual_comissao_venda","7","false","text","Percentual_comissao_venda","","##,##0.00","true","","","",},
                            {"java.lang.Double","percentual_comissao_fat","7","false","text","Percentual_comissao_fat","","##,##0.00","true","","","",},
                            {"java.lang.Double","percentual_comissao_neg_tit","7","false","text","Percentual_comissao_neg_tit","","##,##0.00","true","","","",},
                            {"java.lang.Double","percentual_comissao_bonif","7","false","text","Percentual_comissao_bonif","","##,##0.00","true","","","",},
                            {"java.lang.String","prt_codigo_cobranca","4","false","text","Prt_codigo_cobranca","","","","","","",},
                            {"java.lang.Double","cob_numero_da_conta_bancaria","15","false","text","Cob_numero_da_conta_bancaria","","##,##0.00","true","","","",},
                            {"java.lang.String","cob_digito_da_conta_bancaria","2","false","text","Cob_digito_da_conta_bancaria","","","","","","",},
                            {"java.lang.String","prt_codigo_pagamento","4","false","text","Prt_codigo_pagamento","","","","","","",},
                            {"java.lang.String","tic_codigo","4","false","text","Tic_codigo","","","","","","",},
                            {"java.lang.String","variacao","4","false","text","Variacao","","","","","","",},
                            {"java.lang.Integer","cac_sequencia","3","false","text","Cac_sequencia","","","true","","","",},
                            {"java.lang.Integer","numero_da_remessa","10","false","text","Numero_da_remessa","","","true","","","",},
                            {"java.lang.Double","taxa_vendor_comprador","8","false","text","Taxa_vendor_comprador","","##,##0.00","true","","","",},
                            {"java.lang.Integer","numero_do_bordero","8","false","text","Numero_do_bordero","","","true","","","",},
                            {"java.lang.Double","valor_titulo_vencimento","16","false","text","Valor_titulo_vencimento","","##,##0.00","true","","","",},
                            {"java.lang.String","digito_num_bco","2","false","text","Digito_num_bco","","","","","","",},
                            {"java.lang.String","codigo_barras","50","false","text","Codigo_barras","","","","","","",},
                            {"java.lang.Integer","codigo_marca","3","false","text","Codigo_marca","","","true","","","",},
                            {"java.lang.Double","multa_atraso","11","false","text","Multa_atraso","","##,##0.00","true","","","",},
                            {"java.lang.String","empresa_fatura_proforma","3","false","text","Empresa_fatura_proforma","","","","","","",},
                            {"java.lang.Integer","ano_fatura_proforma","4","false","text","Ano_fatura_proforma","","","true","","","",},
                            {"java.lang.Integer","numero_fatura_proforma","4","false","text","Numero_fatura_proforma","","","true","","","",},
                            {"java.lang.Integer","tab_codigo","6","false","text","Tab_codigo","","","true","","","",}
                          };
    return metadata;
  }

}
