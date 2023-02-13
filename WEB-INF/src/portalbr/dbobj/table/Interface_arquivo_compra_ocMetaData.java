package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arquivo_compra_oc
  * @version 10/08/2015 08:13:46
  */
public class Interface_arquivo_compra_ocMetaData {

  public static final String SCHEMA = "EDI";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"INTERFACE_ARQUIVO_COMPRA_ID","OCO_NUMERO","SEQUENCIA_ITEM"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "INTERFACE_ARQUIVO_COMPRA_OC";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","interface_arquivo_compra_id","22","true","text","Interface_arquivo_compra_id","","","true","","","",},
                            {"java.lang.Integer","oco_numero","22","true","text","Oco_numero","","","true","","","",},
                            {"java.lang.Integer","sequencia_item","22","true","text","Sequencia_item","","##,##0.00","true","","","",},
                            {"java.lang.Long","cnpj_cliente","22","false","text","Cnpj_cliente","","","true","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","Rem_nro","","","true","","","",},
                            {"java.sql.Timestamp","data_compra","19","false","text","Data_compra","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","tipo_operacao","1","false","text","Tipo_operacao","","","","","","",},
                            {"java.sql.Timestamp","data_entrega","19","false","text","Data_entrega","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","local_entrega","2","false","text","Local_entrega","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Fil_filial","","","","","","",},
                            {"java.lang.Integer","ies_codigo","22","false","text","Ies_codigo","","","true","","","",},
                            {"java.lang.Double","quant_comprada","22","false","text","Quant_comprada","","##,##0.00","true","","","",},
                            {"java.lang.String","unm_codigo","3","false","text","Unm_codigo","","","","","","",},
                            {"java.lang.Double","percentual_icms","22","false","text","Percentual_icms","","##,##0.00","true","","","",},
                            {"java.lang.Double","preco_unitario","22","false","text","Preco_unitario","","##,##0.00","true","","","",},
                            {"java.lang.String","moe_codigo","3","false","text","Moe_codigo","","","","","","",},
                            {"java.lang.String","cond_pagto","12","false","text","Cond_pagto","","","","","","",},
                            {"java.lang.Double","desconto","22","false","text","Desconto","","##,##0.00","true","","","",},
                            {"java.lang.String","drawback","1","false","text","Drawback","","","","","","",},
                            {"java.lang.String","uso_cliente","20","false","text","Uso_cliente","","","","","","",},
                            {"java.lang.String","descricao_produto","100","false","text","Descricao_produto","","","","","","",},
                            {"java.lang.Long","cnpj_fornecedor","22","false","text","Cnpj_fornecedor","","","true","","","",},
                            {"java.lang.String","observacoes","44","false","text","Observacoes","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","Cor_cdgo","","","true","","","",},
                            {"java.lang.String","cor_desc","60","false","text","Cor_desc","","","","","","",},
                            {"java.lang.String","tai_codigo","5","false","text","Tai_codigo","","","","","","",},
                            {"java.lang.String","nomenclatura","50","false","text","Nomenclatura","","","","","","",},
                            {"java.lang.String","lote","50","false","text","Lote","","","","","","",},
                            {"java.lang.String","desc_grupo_material","40","false","text","Desc_grupo_material","","","","","","",},
                            {"java.lang.String","nome_comprador","30","false","text","Nome_comprador","","","","","","",},
                            {"java.lang.String","email_comprador","50","false","text","Email_comprador","","","","","","",},
                            {"java.lang.String","marca_cliente","100","false","text","Marca_cliente","","","","","","",},
                            {"java.lang.String","usuario_inclusao","30","true","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","true","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",}
                          };
    return metadata;
  }

}
