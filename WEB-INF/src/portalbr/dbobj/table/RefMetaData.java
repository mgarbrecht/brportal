package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref
  * @version 11/08/2014 10:27:20
  */
public class RefMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIN_CDGO","REF_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REF";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","true","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","10","true","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.Integer","ipi_codred","22","true","text","Ipi_codred","","","true","","","",},
                            {"java.lang.String","ref_desc","25","true","text","Ref_desc","","","","","","",},
                            {"java.lang.String","ref_tipo","2","false","text","Ref_tipo","","","","","","",},
                            {"java.lang.String","ref_status","1","true","text","Ref_status","","","","","","",},
                            {"java.lang.Double","ref_pesbru","9","true","text","Ref_pesbru","","","true","","","",},
                            {"java.lang.Double","ref_pesliq","9","true","text","Ref_pesliq","","","true","","","",},
                            {"java.lang.String","ref_lista_rel","1","false","text","Ref_lista_rel","","","","","","",},
                            {"java.lang.String","ref_revenda","1","false","text","Ref_revenda","","","","","","",},
                            {"java.lang.String","ref_descricao_exportacao","100","false","text","Ref_descricao_exportacao","","","","","","",},
                            {"java.lang.String","ref_produto_estoque","1","false","text","Ref_produto_estoque","","","","","","",},
                            {"java.lang.Integer","gpr_codigo","3","false","text","Gpr_codigo","","","true","","","",},
                            {"java.lang.Integer","sol_codigo","2","false","text","Sol_codigo","","","true","","","",},
                            {"java.lang.Integer","codigo_marca","3","true","text","Codigo_marca","","","true","","","",},
                            {"java.lang.Integer","lin_cdgo_mestre","22","false","text","Lin_cdgo_mestre","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo_mestre","10","false","text","Ref_cdgo_mestre","","","true","","","",},
                            {"java.lang.Integer","ref_grupo_fabril","22","false","text","Ref_grupo_fabril","","","true","","","",},
                            {"java.lang.Integer","ref_grupo_posicao_fab","2","false","text","Ref_grupo_posicao_fab","","","true","","","",},
                            {"java.lang.Double","cncm_codigo_ncm","10","false","text","Cncm_codigo_ncm","","","true","","","",},
                            {"java.sql.Timestamp","data_log_afv","10","false","text","Data_log_afv","","","true","","","",},
                            {"java.lang.String","ref_ref_cli","12","false","text","Ref_ref_cli","","","","","","",},
                            {"java.lang.String","ref_venda_exportacao","1","false","text","Ref_venda_exportacao","","","","","","",},
                            {"java.lang.String","ref_libera_pp_afv","1","false","text","Ref_libera_pp_afv","","","","","","",},
                            {"java.lang.String","ref_indicador_site","1","false","text","Ref_indicador_site","","","","","","",},
                            {"java.lang.Integer","ref_class_segmento","1","false","text","Ref_class_segmento","","","true","","","",},
                            {"java.lang.Integer","ref_tipo_material_predominante","1","false","text","Ref_tipo_material_predominante","","","true","","","",},
                            {"java.lang.Integer","ref_partal","5","false","text","Ref_partal","","","true","","","",},
                            {"java.lang.Integer","ref_parrem","5","false","text","Ref_parrem","","","true","","","",},
                            {"java.lang.Integer","ref_minimo","3","false","text","Ref_minimo","","","true","","","",},
                            {"java.lang.Integer","ref_dias_almoxarifado","3","false","text","Ref_dias_almoxarifado","","","true","","","",},
                            {"java.lang.Integer","ref_dias_costura","3","false","text","Ref_dias_costura","","","true","","","",},
                            {"java.lang.Integer","ref_dias_montagem","3","false","text","Ref_dias_montagem","","","true","","","",},
                            {"java.lang.Integer","ref_dias_expedicao","3","false","text","Ref_dias_expedicao","","","true","","","",},
                            {"java.lang.Integer","codigo_mini_fabs","3","false","text","Codigo_mini_fabs","","","true","","","",},
                            {"java.lang.String","destaque_site","1","false","text","Destaque_site","","","","","","",},
                            {"java.lang.Integer","ref_cdgo_pai","10","false","text","Ref_cdgo_pai","","","true","","","",},
                            {"java.lang.String","lin_path_img","150","false","text","Lin_path_img","","","","","","",},
                            {"java.lang.String","engenharia_atm","1","false","text","Engenharia_atm","","","","","","",},
                            {"java.lang.Double","investimento","16","false","text","Investimento","","","true","","","",},
                            {"java.lang.Double","p_equilibrio","16","false","text","P_equilibrio","","","true","","","",},
                            {"java.lang.Double","peso_embalagem","8","false","text","Peso_embalagem","","","true","","","",},
                            {"java.lang.Double","altura_embalagem","11","false","text","Altura_embalagem","","","true","","","",},
                            {"java.lang.Double","largura_embalagem","11","false","text","Largura_embalagem","","","true","","","",},
                            {"java.lang.Double","comprimento_embalagem","11","false","text","Comprimento_embalagem","","","true","","","",},
                            {"java.lang.String","incluso_sapato","1","false","text","Incluso_sapato","","","","","","",},
                            {"java.lang.String","incluso_vareta","1","false","text","Incluso_vareta","","","","","","",},
                            {"java.lang.String","incluso_presilha","1","false","text","Incluso_presilha","","","","","","",},
                            {"java.lang.String","incluso_papel_bucha","1","false","text","Incluso_papel_bucha","","","","","","",},
                            {"java.lang.String","incluso_papel_seda","1","false","text","Incluso_papel_seda","","","","","","",},
                            {"java.lang.String","incluso_bula","1","false","text","Incluso_bula","","","","","","",},
                            {"java.lang.String","incluso_silica_gel","1","false","text","Incluso_silica_gel","","","","","","",},
                            {"java.lang.String","incluso_gancho","1","false","text","Incluso_gancho","","","","","","",},
                            {"java.lang.String","incluso_saco_plastico","1","false","text","Incluso_saco_plastico","","","","","","",},
                            {"java.lang.String","incluso_protetor_bucha","1","false","text","Incluso_protetor_bucha","","","","","","",},
                            {"java.lang.String","incluso_pino_anel","1","false","text","Incluso_pino_anel","","","","","","",},
                            {"java.lang.String","usuario_alteracao_med_emb","30","false","text","Usuario_alteracao_med_emb","","","","","","",},
                            {"java.sql.Timestamp","data_alteracao_med_emb","22","false","text","Data_alteracao_med_emb","","","true","","","",},
                            {"java.lang.Double","versao_alteracao_med_emb","10","false","text","Versao_alteracao_med_emb","","","true","","","",},
                            {"java.lang.String","usuario_alteracao_num","30","false","text","Usuario_alteracao_num","","","","","","",},
                            {"java.sql.Timestamp","data_alteracao_num","22","false","text","Data_alteracao_num","","","true","","","",},
                            {"java.lang.Double","versao_alteracao_num","10","false","text","Versao_alteracao_num","","","true","","","",},
                            {"java.lang.String","usuario_alteracao_corrug","30","false","text","Usuario_alteracao_corrug","","","","","","",},
                            {"java.sql.Timestamp","data_alteracao_corrug","22","false","text","Data_alteracao_corrug","","","true","","","",},
                            {"java.lang.Double","versao_alteracao_corrug","10","false","text","Versao_alteracao_corrug","","","true","","","",},
                            {"java.sql.Timestamp","data_embarque","22","false","text","Data_embarque","","","true","","","",}
                          };
    return metadata;
  }

}
