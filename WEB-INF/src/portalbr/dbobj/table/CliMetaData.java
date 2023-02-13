package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cli
  * @version 21/08/2013 11:10:49
  */
public class CliMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CLI_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CLI";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.String","cla_cdgo","3","false","text","Cla_cdgo","","","","","","",},
                            {"int","seg_cdgo","3","true","text","Seg_cdgo","","","true","","","",},
                            {"java.lang.String","cli_situ","1","true","text","Cli_situ","","","","","","",},
                            {"java.lang.String","cli_rzao","35","true","text","Cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","35","true","text","Cli_nome","","","","","","",},
                            {"java.sql.Timestamp","cli_dtin","22","true","text","Cli_dtin","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","cli_tipo","1","true","text","Cli_tipo","","","","","","",},
                            {"java.sql.Timestamp","cli_dult","22","false","text","Cli_dult","","dd/MM/yyyy","true","","","",},
                            {"double","cli_vlor","13","false","text","Cli_vlor","","","true","","","",},
                            {"double","cli_mvlo","13","false","text","Cli_mvlo","","","true","","","",},
                            {"int","cli_dias","3","true","text","Cli_dias","","","true","","","",},
                            {"double","cli_totv","13","true","text","Cli_totv","","","true","","","",},
                            {"double","cli_tott","13","true","text","Cli_tott","","","true","","","",},
                            {"int","cli_totq","3","true","text","Cli_totq","","","true","","","",},
                            {"int","cli_prot","3","true","text","Cli_prot","","","true","","","",},
                            {"double","cli_tota","13","true","text","Cli_tota","","","true","","","",},
                            {"double","cli_toqt","13","true","text","Cli_toqt","","","true","","","",},
                            {"java.lang.String","niv_cdgo","1","true","text","Niv_cdgo","","","","","","",},
                            {"double","cli_limcre","13","true","text","Cli_limcre","","","true","","","",},
                            {"java.sql.Timestamp","cli_pricom","22","false","text","Cli_pricom","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Timestamp","cli_ultpro","22","false","text","Cli_ultpro","","dd/MM/yyyy","true","","","",},
                            {"double","cli_maicom","13","true","text","Cli_maicom","","","true","","","",},
                            {"double","cli_dupve5","13","true","text","Cli_dupve5","","","true","","","",},
                            {"double","cli_dupvm5","13","true","text","Cli_dupvm5","","","true","","","",},
                            {"double","cli_pagpon","13","true","text","Cli_pagpon","","","true","","","",},
                            {"double","cli_pagatr","13","true","text","Cli_pagatr","","","true","","","",},
                            {"double","cli_pagcar","13","true","text","Cli_pagcar","","","true","","","",},
                            {"double","cli_protes","13","true","text","Cli_protes","","","true","","","",},
                            {"double","cli_devolu","13","true","text","Cli_devolu","","","true","","","",},
                            {"double","cli_debrep","13","true","text","Cli_debrep","","","true","","","",},
                            {"double","cli_atra15","13","true","text","Cli_atra15","","","true","","","",},
                            {"double","cli_atrm15","13","true","text","Cli_atrm15","","","true","","","",},
                            {"double","cli_chqdel","13","true","text","Cli_chqdel","","","true","","","",},
                            {"double","cli_chqabe","13","true","text","Cli_chqabe","","","true","","","",},
                            {"double","cli_totpag","13","false","text","Cli_totpag","","","true","","","",},
                            {"double","cli_totfat","13","false","text","Cli_totfat","","","true","","","",},
                            {"java.lang.String","cli_conta","16","false","text","Cli_conta","","","","","","",},
                            {"int","cli_qtpagpon","8","true","text","Cli_qtpagpon","","","true","","","",},
                            {"int","cli_qtpagatr","8","true","text","Cli_qtpagatr","","","true","","","",},
                            {"int","cli_qtpagcar","8","true","text","Cli_qtpagcar","","","true","","","",},
                            {"int","cli_qtprotes","4","true","text","Cli_qtprotes","","","true","","","",},
                            {"int","cli_qtdevolu","8","true","text","Cli_qtdevolu","","","true","","","",},
                            {"int","cli_qtdebrep","8","true","text","Cli_qtdebrep","","","true","","","",},
                            {"int","cli_qtatra15","4","true","text","Cli_qtatra15","","","true","","","",},
                            {"int","cli_qtatrm15","4","true","text","Cli_qtatrm15","","","true","","","",},
                            {"int","cli_qtdupve5","4","true","text","Cli_qtdupve5","","","true","","","",},
                            {"int","cli_qtdupvm5","4","true","text","Cli_qtdupvm5","","","true","","","",},
                            {"int","cli_qtchqdev","4","true","text","Cli_qtchqdev","","","true","","","",},
                            {"int","cli_qtchqabe","4","true","text","Cli_qtchqabe","","","true","","","",},
                            {"int","cli_qtdupabe","4","true","text","Cli_qtdupabe","","","true","","","",},
                            {"double","cli_vlultcom","13","true","text","Cli_vlultcom","","","true","","","",},
                            {"double","cli_vlpricom","13","true","text","Cli_vlpricom","","","true","","","",},
                            {"java.sql.Timestamp","cli_dtmaicom","22","false","text","Cli_dtmaicom","","dd/MM/yyyy","true","","","",},
                            {"double","cli_valor_credito_analista","16","false","text","Cli_valor_credito_analista","","","true","","","",},
                            {"java.lang.String","cli_ind_credito_bloqueado","1","false","text","Cli_ind_credito_bloqueado","","","","","","",},
                            {"int","blo_codigo_bloqueio","5","false","text","Blo_codigo_bloqueio","","","true","","","",},
                            {"int","cli_nro_dias_atraso_credito","3","false","text","Cli_nro_dias_atraso_credito","","","true","","","",},
                            {"java.lang.String","cli_banco_obrigatorio","1","false","text","Cli_banco_obrigatorio","","","","","","",},
                            {"java.lang.String","cli_compra_consignada","1","false","text","Cli_compra_consignada","","","","","","",},
                            {"int","cli_dias_tolerancia_atraso","2","false","text","Cli_dias_tolerancia_atraso","","","true","","","",},
                            {"java.lang.String","cli_emissao_bloquete","1","false","text","Cli_emissao_bloquete","","","","","","",},
                            {"java.lang.String","cli_exige_pc","1","false","text","Cli_exige_pc","","","","","","",},
                            {"java.lang.String","cli_aceita_antecipacao","1","true","text","Cli_aceita_antecipacao","","","","","","",},
                            {"int","cli_dia_vencimento_1","2","false","text","Cli_dia_vencimento_1","","","true","","","",},
                            {"int","cli_dia_vencimento_2","2","false","text","Cli_dia_vencimento_2","","","true","","","",},
                            {"int","cli_dia_vencimento_3","2","false","text","Cli_dia_vencimento_3","","","true","","","",},
                            {"int","cli_dia_vencimento_4","2","false","text","Cli_dia_vencimento_4","","","true","","","",},
                            {"int","cli_dia_vencimento_5","2","false","text","Cli_dia_vencimento_5","","","true","","","",},
                            {"java.sql.Timestamp","cli_data_recadastramento","22","false","text","Cli_data_recadastramento","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","cli_observacao","80","false","text","Cli_observacao","","","","","","",},
                            {"java.lang.String","cli_bloqueio_credito","1","false","text","Cli_bloqueio_credito","","","","","","",},
                            {"java.lang.String","cli_aceita_antecipacao_allegro","1","false","text","Cli_aceita_antecipacao_allegro","","","","","","",},
                            {"java.lang.String","codigo_representante_abertura","5","false","text","Codigo_representante_abertura","","","","","","",},
                            {"java.lang.String","cli_carta_cobranca","1","false","text","Cli_carta_cobranca","","","","","","",},
                            {"java.lang.String","cli_agrupa_notas","1","false","text","Cli_agrupa_notas","","","","","","",},
                            {"java.lang.String","cli_tipo_mercado","2","false","text","Cli_tipo_mercado","","","","","","",},
                            {"double","cli_desconto","7","false","text","Cli_desconto","","","true","","","",},
                            {"java.lang.String","cli_obsfatura","255","false","text","Cli_obsfatura","","","","","","",},
                            {"java.lang.String","cli_obspack","255","false","text","Cli_obspack","","","","","","",},
                            {"int","cli_qtpedcanc","4","false","text","Cli_qtpedcanc","","","true","","","",},
                            {"double","cli_vlpedcanc","13","false","text","Cli_vlpedcanc","","","true","","","",},
                            {"int","cli_qtcheliq","4","false","text","Cli_qtcheliq","","","true","","","",},
                            {"double","cli_vlcheliq","13","false","text","Cli_vlcheliq","","","true","","","",},
                            {"double","cpf_proprietario","11","false","text","Cpf_proprietario","","","true","","","",},
                            {"java.lang.String","cli_aceita_antecipacao_riva","1","true","text","Cli_aceita_antecipacao_riva","","","","","","",},
                            {"int","codigo_motivo","2","false","text","Codigo_motivo","","","true","","","",},
                            {"java.sql.Timestamp","data_ultima_alteracao","22","false","text","Data_ultima_alteracao","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","cli_data_reativacao","10","false","text","Cli_data_reativacao","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
