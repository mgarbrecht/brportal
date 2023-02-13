package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_combinacao_especial
  * @version 03/11/2022 09:30:13
  */
public class Ref_combinacao_especialMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REF_COMBINACAO_ESPECIAL";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"java.lang.String","usuario_solicitacao","30","true","text","Usuario_solicitacao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","true","text","Usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","data_solicitacao","19","true","text","Data_solicitacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","codigo_marca","3","false","text","Codigo_marca","","","true","","","",},
                            {"java.lang.String","nova_combinacao","1","true","text","Nova Combinação","","","","","","",},
                            {"java.lang.String","alteracao_modelo","1","true","text","Alteração de Modelo","","","","","","",},
                            {"java.lang.String","amostra","1","true","text","Amostra","","","","","","",},
                            {"java.sql.Timestamp","data_entrega_prevista","19","false","text","Data_entrega_prevista","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","data_entrega_solicitada","19","false","text","Data_entrega_solicitada","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","lin_cdgo","22","true","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","10","false","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","Cab_cdgo","","","true","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","Cor_cdgo","","","true","","","",},
                            {"java.lang.String","observacao","4000","false","text","Observacao","","","","","","",},
                            {"java.lang.String","material_cor1","2000","false","text","Material_cor1","","","","","","",},
                            {"java.lang.String","material_cor2","2000","false","text","Material_cor2","","","","","","",},
                            {"java.lang.String","material_cor3","2000","false","text","Material_cor3","","","","","","",},
                            {"java.lang.String","material_cor4","2000","false","text","Material_cor4","","","","","","",},
                            {"java.lang.String","atacador","2000","false","text","Atacador","","","","","","",},
                            {"java.lang.String","biqueira_debrum","2000","false","text","Biqueira_debrum","","","","","","",},
                            {"java.lang.String","capa_palmilha","2000","false","text","Capa_palmilha","","","","","","",},
                            {"java.lang.String","cacharel","2000","false","text","Cacharel","","","","","","",},
                            {"java.lang.String","forro","2000","false","text","Forro","","","","","","",},
                            {"java.lang.String","metais","2000","false","text","Metais","","","","","","",},
                            {"java.lang.String","taloneira","2000","false","text","Taloneira","","","","","","",},
                            {"java.lang.String","salto","2000","false","text","Salto","","","","","","",},
                            {"java.lang.String","enfeite","2000","false","text","Enfeite","","","","","","",},
                            {"java.lang.String","carimbo_etiqueta","2000","false","text","Carimbo_etiqueta","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Double","prs_negociacao","22","false","text","Prs_negociacao","","##,##0.00","true","","","",},
                            {"java.lang.Double","pares_linha","22","false","text","Pares_linha","","##,##0.00","true","","","",},
                            {"java.lang.Double","pares_alteracao","22","false","text","Pares_alteracao","","##,##0.00","true","","","",},
                            {"java.lang.Double","preco_liguido","22","false","text","Preco_liguido","","##,##0.00","true","","","",},
                            {"java.lang.Double","ll_alteracao_solicitada","22","false","text","Ll_alteracao_solicitada","","##,##0.00","true","","","",},
                            {"java.lang.String","situacao_solicitacao","1","false","text","Situacao_solicitacao","","","","","","",},
                            {"java.sql.Date","data_aceite","19","false","text","Data_aceite","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_aceite","30","false","text","Usuario_aceite","","","","","","",},
                            {"java.lang.String","imagem_produto","200","true","text","Imagem Produto","","","","","","",},
                            {"java.sql.Timestamp","data_entrega_amostra","19","false","text","Data_entrega_amostra","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","gre_grupo","6","false","text","Grupo Econômico","","","true","","","",},
                            {"java.lang.String","rep_cdgo","30","true","text","Rep_cdgo","","","","","","",},
                            {"java.lang.Double","valor_fabricacao","22","false","text","Valor_fabricacao","","##,##0.00","true","","","",},
                            {"java.lang.String","desenvolvimento","1","true","text","Desenvolvimento","","","","","","",},
                            {"java.sql.Timestamp","data_desenvolvimento","19","false","text","Data_desenvolvimento","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","fora_mix","1","true","text","Fora Mix","","","","","","",},
                            {"java.sql.Timestamp","data_fora_mix","19","false","text","Data_fora_mix","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","manipulacao","1","true","text","Manipulação","","","","","","",},
                            {"java.sql.Timestamp","data_manipulacao","19","false","text","Data Manipulação","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","modelo_exclusivo","1","true","text","Modelo Exclusivo","","","","","","",},
                            {"java.lang.String","tipo_solicitacao_comb_especial","100","true","text","tipo_solicitacao_comb_especial","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","Descrição","","","","","","",},
                            {"java.sql.Timestamp","data_aprovacao","19","true","text","Data_aprovacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","material","1","true","text","Material","","","","","","",},
                            {"java.lang.Double","valor_pdv","22","false","text","valor_pdv","","##,##0.00","true","","","",},
                            {"java.lang.Double","ll_0","22","false","text","ll_0","","##,##0.00","true","","","",},
                            {"java.lang.Double","ll_1","22","false","text","ll_1","","##,##0.00","true","","","",},
                            {"java.lang.Double","ll_2","22","false","text","ll_2","","##,##0.00","true","","","",},
                            {"java.lang.Double","ll_3","22","false","text","ll_3","","##,##0.00","true","","","",},
                            {"java.lang.Double","preco_vendor","22","false","text","preco_vendor","","##,##0.00","true","","","",},
                            {"java.lang.String","cepa","2000","false","text","Cepa","","","","","","",},
                            {"java.lang.String","sola","2000","false","text","Sola","","","","","","",},
                            {"java.lang.String","subtipo_solicitacao_comb_espec","2000","false","text","Subtipo","","","","","","",},
                            {"java.lang.Integer","ped_nmro","2000","false","text","Pedido","","","","","","",},
                            {"java.lang.Integer","ite_seqn","2000","false","text","Item","","","","","","",},
                            {"java.lang.String","material_cor5","2000","false","text","Material_cor5","","","","","","",},
                            {"java.lang.String","material_cor6","2000","false","text","Material_cor6","","","","","","",},
                            {"java.lang.String","material_cor7","2000","false","text","Material_cor7","","","","","","",},
                            {"java.lang.String","material_cor8","2000","false","text","Material_cor8","","","","","","",},
                            {"java.lang.String","material_cor9","2000","false","text","Material_cor9","","","","","","",},
                            {"java.lang.String","material_cor10","2000","false","text","Material_cor10","","","","","","",}
                          };
    return metadata;
  }

}
