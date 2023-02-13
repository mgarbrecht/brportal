package portalbr.dbobj.table;

/** DataBase Object from table EXP.Emula_faturas_proformas
  * @version 03/04/2013 09:58:59
  */
public class Emula_faturas_proformasMetaData {

  public static final String SCHEMA = "EXP";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NUMERO_PEDIDO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "EMULA_FATURAS_PROFORMAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","numero_pedido","6","true","text","Numero_pedido","","","true","","","",},
                            {"java.lang.Integer","codigo_cliente","5","true","text","Codigo_cliente","","","true","","","",},
                            {"java.lang.Integer","estabelecimento_cliente","4","false","text","Estabelecimento_cliente","","","true","","","",},
                            {"java.sql.Date","data_pedido","10","true","text","Data_pedido","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_entrega","10","true","text","Data_entrega","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Integer","codigo_destino","5","false","text","Codigo_destino","","","true","","","",},
                            {"java.lang.Integer","codigo_composicao","2","false","text","Codigo_composicao","","","true","","","",},
                            {"java.lang.Integer","codigo_condicao_pagamento","22","false","text","Codigo_condicao_pagamento","","","true","","","",},
                            {"java.lang.Integer","codigo_via_transporte","2","false","text","Codigo_via_transporte","","","true","","","",},
                            {"java.lang.Integer","codigo_pessoa_consignado","6","false","text","Codigo_pessoa_consignado","","","true","","","",},
                            {"java.lang.Integer","codigo_pessoa_notificado","6","false","text","Codigo_pessoa_notificado","","","true","","","",},
                            {"java.lang.Integer","codigo_pessoa_despachante","6","false","text","Codigo_pessoa_despachante","","","true","","","",},
                            {"java.lang.String","codigo_moeda","3","false","text","Codigo_moeda","","","","","","",},
                            {"java.lang.Integer","codigo_livro","22","false","text","Codigo_livro","","","true","","","",},
                            {"java.lang.String","empresa_fatura_proforma","3","false","text","Empresa_fatura_proforma","","","","","","",},
                            {"java.lang.Integer","ano_fatura_proforma","4","false","text","Ano_fatura_proforma","","","true","","","",},
                            {"java.lang.Integer","numero_fatura_proforma","4","false","text","Numero_fatura_proforma","","","true","","","",},
                            {"java.lang.String","nome_planilha","30","false","text","Nome_planilha","","","","","","",},
                            {"java.sql.Date","versao_tabela","10","false","text","Versao_tabela","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Integer","codigo_pais_tabela","3","false","text","Codigo_pais_tabela","","","true","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
