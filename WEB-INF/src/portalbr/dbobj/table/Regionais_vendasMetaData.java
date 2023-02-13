package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Regionais_vendas
  * @version 05/07/2010 06:59:24
  */
public class Regionais_vendasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_REGIONAL"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REGIONAIS_VENDAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_regional","3","true","text","Codigo_regional","","","true","","","",},
                            {"java.lang.String","nome_regional","40","true","text","Nome_regional","","","","","","",},
                            {"java.lang.String","ender_eletronico_regional","30","true","text","Ender_eletronico_regional","","","","","","",},
                            {"java.lang.String","ender_regional","65","true","text","Ender_regional","","","","","","",},
                            {"java.lang.String","numero_regional","7","true","text","Numero_regional","","","","","","",},
                            {"java.lang.String","complemento_regional","6","false","text","Complemento_regional","","","","","","",},
                            {"java.lang.String","bairro_regional","30","false","text","Bairro_regional","","","","","","",},
                            {"java.lang.String","estado_regional","2","false","text","Estado_regional","","","","","","",},
                            {"java.lang.String","cidade_regional","60","true","text","Cidade_regional","","","","","","",},
                            {"java.lang.String","cep_regional","8","false","text","Cep_regional","","","","","","",},
                            {"int","caixa_postal_regional","6","false","text","Caixa_postal_regional","","","true","","","",},
                            {"int","fone_ddd_regional","4","false","text","Fone_ddd_regional","","","true","","","",},
                            {"int","fone_numero_regional","8","false","text","Fone_numero_regional","","","true","","","",},
                            {"int","fax_ddd_regional","4","false","text","Fax_ddd_regional","","","true","","","",},
                            {"int","fax_numero_regional","8","false","text","Fax_numero_regional","","","true","","","",},
                            {"java.lang.String","usuario_regional","30","true","text","Usuario_regional","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro_regional","22","true","text","Data_cadastro_regional","","","true","","","",},
                            {"java.lang.String","assistente_venda_regional","40","false","text","Assistente_venda_regional","","","","","","",},
                            {"java.lang.String","observacoes_regional","80","false","text","Observacoes_regional","","","","","","",},
                            {"double","ipc_brasil_vizzano_regional","6","false","text","Ipc_brasil_vizzano_regional","","","true","","","",},
                            {"double","ipc_brasil_allegro_regional","6","false","text","Ipc_brasil_allegro_regional","","","true","","","",},
                            {"double","ipc_brio_vizzano_regional","6","false","text","Ipc_brio_vizzano_regional","","","true","","","",},
                            {"double","ipc_brio_allegro_regional","6","false","text","Ipc_brio_allegro_regional","","","true","","","",},
                            {"int","total_cidades_regional","4","false","text","Total_cidades_regional","","","true","","","",},
                            {"int","ordem_impressao_poi","2","false","text","Ordem_impressao_poi","","","true","","","",},
                            {"java.lang.String","sigla_regional","8","false","text","Sigla_regional","","","","","","",},
                            {"java.lang.String","regional_mail","35","false","text","Regional_mail","","","","","","",},
                            {"java.lang.String","atendente_comercial_mail","35","false","text","Atendente_comercial_mail","","","","","","",}
                          };
    return metadata;
  }

}
