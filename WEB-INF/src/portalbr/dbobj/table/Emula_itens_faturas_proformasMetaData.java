package portalbr.dbobj.table;

/** DataBase Object from table EXP.Emula_itens_faturas_proformas
  * @version 05/08/2014 09:46:39
  */
public class Emula_itens_faturas_proformasMetaData {

  public static final String SCHEMA = "EXP";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NUMERO_PEDIDO","NUMERO_ITEM"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "EMULA_ITENS_FATURAS_PROFORMAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","numero_pedido","6","true","text","Numero_pedido","","","true","","","",},
                            {"java.lang.Integer","numero_item","4","true","text","Numero_item","","","true","","","",},
                            {"java.lang.Integer","codigo_linha","22","false","text","Codigo_linha","","","true","","","",},
                            {"java.lang.Integer","codigo_referencia","10","false","text","Codigo_referencia","","","true","","","",},
                            {"java.lang.Integer","codigo_cabedal","22","false","text","Codigo_cabedal","","","true","","","",},
                            {"java.lang.Integer","codigo_cor","22","false","text","Codigo_cor","","","true","","","",},
                            {"java.lang.Integer","codigo_grade","22","false","text","Codigo_grade","","","true","","","",},
                            {"java.lang.Double","quantidade_pares","15","false","text","Quantidade_pares","","","true","","","",},
                            {"java.lang.Double","preco_unitario","15","false","text","Preco_unitario","","##,##0.00","true","","","",},
                            {"java.lang.String","descricao_item","70","false","text","Descricao_item","","","","","","",},
                            {"java.lang.String","descricao_erro","300","false","text","Descricao_erro","","","","","","",},
                            {"java.lang.String","loja_cliente","25","false","text","loja_cliente","","","","","","",},
                            {"java.lang.Integer","codigo_corrugado","22","false","text","Codigo_corrugado","","","true","","","",}
                          };
    return metadata;
  }

}
