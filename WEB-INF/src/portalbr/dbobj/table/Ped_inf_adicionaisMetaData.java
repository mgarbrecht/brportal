package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_inf_adicionais
  * @version 20/01/2022 10:59:40
  */
public class Ped_inf_adicionaisMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PED_NMRO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_INF_ADICIONAIS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.String","etiquetas","200","false","text","Etiquetas","","","","","","",},
                            {"java.lang.String","obse_adicionais","130","false","text","Obse_adicionais","","","","","","",},
                            {"java.lang.String","emp_empresa","3","true","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial_fat","4","false","text","Fil_filial_fat","","","","","","",},
                            {"java.sql.Date","dt_fatur_filial","19","false","text","Dt_fatur_filial","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_etiquetagem","19","false","text","Data_etiquetagem","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","carimbo","200","false","text","Carimbo","","","","","","",},
                            {"java.lang.String","rotulos","200","false","text","Rotulos","","","","","","",},
                            {"java.sql.Date","dt_envio_amostras","19","false","text","Dt_envio_amostras","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","dt_agendamento","19","false","text","Dt_agendamento","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","agendamento_cdgo","20","false","text","Agendamento_cdgo","","","true","","","",},
                            {"java.lang.String","horario_entrega","20","false","text","Horario_entrega","","","","","","",},
                            {"java.lang.String","senha_entrega","20","false","text","Senha_entrega","","","","","","",},
                            {"java.lang.String","seq_acao_mkt","20","false","text","Seq_acao_mkt","","","","","","",},
                            {"java.lang.Double","valor_bonificado","20","false","text","Valor_bonificado","","","","","","",},
                            {"java.lang.String","id_showroom","20","false","text","Id_showroom","","","","","","",},
                            {"java.sql.Date","dt_showroom","19","false","text","Dt_showroom","","dd/MM/yyyy","","","","",},
                            {"java.sql.Date","dt_inspecao","19","false","text","Dt. Inspeção","","dd/MM/yyyy","","","","",},
                            {"java.sql.Date","dt_entrega_etiqueta","19","false","text","Dt_entrega_etiqueta","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","cabide","200","false","text","Cabide","","","","","","",},
                            {"java.lang.Integer","sp_ped_nmro","22","false","text","sp_ped_nmro","","","","","","",},
                            {"java.lang.Integer","sp_ts_cdgo_situacao","3","false","text","sp_ts_cdgo_situacao","","","","","","",},
                            {"java.sql.Date","sp_dt_cad_situacao","19","false","text","sp_dt_cad_situacao","","","","","","",},
                            {"java.lang.Integer","sp_ite_seqn","22","false","text","sp_ite_seqn","","","","","","",},
                            {"java.sql.Date","dt_ent_amostra_comercial","19","false","text","dt_ent_amostra_comercial","","","","","","",},
                            {"java.sql.Date","dt_ent_amostra_pcp","19","false","text","dt_ent_amostra_pcp","","","","","","",},
                            {"java.lang.String","encarte","4000","false","text","encarte","","","","","","",},
                            {"java.lang.String","portao","60","false","text","Portão de Entrega","","","","","","",},
                            {"java.lang.String","cd_entrega","60","false","text","CD de Entrega","","","","","","",},
                            {"java.sql.Date","dt_rec_etiqueta_filial","19","false","text","dt_rec_etiqueta_filial","","","","","","",},
                            {"java.lang.String","prioridade_embarque","1","false","text","Prioridade_embarque","","","","","","",},
                            {"java.sql.Date","dt_solicitacao_alarme","19","false","text","dt_solicitacao_alarme","","","","","","",},
                            {"java.sql.Date","dt_rec_alarme_pcp","19","false","text","dt_rec_alarme_pcp","","","","","","",},
                            {"java.sql.Date","dt_rec_alarme_filial","19","false","text","dt_rec_alarme_filial","","","","","","",},
                            {"java.lang.Integer","nfe_numero","22","true","text","Nfe_numero","","","true","","","",},
                            {"java.lang.String","gerar_requisicao","10","false","text","Gerar_requisicao","","","","","","",},
                            {"java.lang.String","modelo_alarme","200","false","text","Modelo_alarme","","","","","","",}
                          };
    return metadata;
  }

}
