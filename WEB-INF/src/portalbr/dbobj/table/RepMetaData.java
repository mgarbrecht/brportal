package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Rep
  * @version 22/11/2012 08:09:00
  */
public class RepMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"REP_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REP";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rep_cdgo","5","true","text","Rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","true","text","Rep_rzao","","","","","","",},
                            {"java.lang.String","rep_nome","30","false","text","Rep_nome","","","","","","",},
                            {"java.sql.Timestamp","rep_incl","22","false","text","Rep_incl","","","true","","","",},
                            {"java.lang.String","rep_situ","1","true","text","Rep_situ","","","","","","",},
                            {"double","rep_saldo","13","true","text","Rep_saldo","","","true","","","",},
                            {"java.lang.String","cta_conta","16","false","text","Cta_conta","","","","","","",},
                            {"int","rep_cddis","4","false","text","Rep_cddis","","","true","","","",},
                            {"double","rep_limite_cliente_novo","16","false","text","Rep_limite_cliente_novo","","","true","","","",},
                            {"double","rep_limite_cliente_velho","16","false","text","Rep_limite_cliente_velho","","","true","","","",},
                            {"int","rep_prazo_recolocacao","3","false","text","Rep_prazo_recolocacao","","","true","","","",},
                            {"int","codigo_atendente","4","true","text","Codigo_atendente","","","true","","","",},
                            {"int","codigo_tipo_contrato","2","false","text","Codigo_tipo_contrato","","","true","","","",},
                            {"int","codigo_gerente","10","false","text","Codigo_gerente","","","true","","","",},
                            {"java.lang.String","rep_tipo_marca","1","false","text","Rep_tipo_marca","","","","","","",},
                            {"java.lang.String","rep_endereco_eletronico","50","false","text","Rep_endereco_eletronico","","","","","","",},
                            {"java.lang.String","rep_numero_renpac","15","false","text","Rep_numero_renpac","","","","","","",},
                            {"java.lang.String","rep_usuario_internet","30","false","text","Rep_usuario_internet","","","","","","",},
                            {"int","rep_gerente_antigo","10","false","text","Rep_gerente_antigo","","","true","","","",},
                            {"int","codigo_gerente_allegro","10","false","text","Codigo_gerente_allegro","","","true","","","",},
                            {"int","codigo_gerente_vizzano","10","false","text","Codigo_gerente_vizzano","","","true","","","",},
                            {"int","codigo_regional","3","false","text","Codigo_regional","","","true","","","",},
                            {"java.lang.String","rep_tipo_negocio","2","true","text","Rep_tipo_negocio","","","","","","",},
                            {"java.lang.String","rep_tipo_mercado","2","false","text","Rep_tipo_mercado","","","","","","",},
                            {"java.lang.String","rep_observacao","255","false","text","Rep_observacao","","","","","","",},
                            {"int","codigo_gerente_riva_bianca","10","false","text","Codigo_gerente_riva_bianca","","","true","","","",},
                            {"java.sql.Timestamp","data_primeira_venda","22","false","text","Data_primeira_venda","","","true","","","",},
                            {"double","valor_primeira_venda","16","false","text","Valor_primeira_venda","","","true","","","",},
                            {"java.sql.Timestamp","data_ultima_venda","22","false","text","Data_ultima_venda","","","true","","","",},
                            {"double","valor_ultima_venda","16","false","text","Valor_ultima_venda","","","true","","","",},
                            {"java.sql.Timestamp","data_log_afv","22","false","text","Data_log_afv","","","true","","","",},
                            {"java.lang.String","gera_arquivo_afv","1","false","text","Gera_arquivo_afv","","","","","","",},
                            {"java.lang.String","rep_mail","35","false","text","Rep_mail","","","","","","",}
                          };
    return metadata;
  }

}
