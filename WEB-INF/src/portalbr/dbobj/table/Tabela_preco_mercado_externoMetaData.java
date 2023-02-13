package portalbr.dbobj.table;

/** DataBase Object from table EXP.Tabela_preco_mercado_externo
  * @version 05/08/2014 12:07:05
  */
public class Tabela_preco_mercado_externoMetaData {

  public static final String SCHEMA = "EXP";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_LIVRO","CODIGO_PAIS","VERSAO_TABELA","CODIGO_LINHA","CODIGO_REFERENCIA","CODIGO_CABEDAL"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TABELA_PRECO_MERCADO_EXTERNO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_livro","10","true","text","Codigo_livro","","","true","","","",},
                            {"java.lang.Integer","codigo_pais","3","true","text","Codigo_pais","","","true","","","",},
                            {"java.sql.Timestamp","versao_tabela","19","true","text","Versao_tabela","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","codigo_linha","10","true","text","Codigo_linha","","","true","","","",},
                            {"java.lang.Integer","codigo_referencia","10","true","text","Codigo_referencia","","","true","","","",},
                            {"java.lang.Double","preco_unitario","11","true","text","Preco_unitario","","##,##0.00","true","","","",},
                            {"java.lang.String","status","1","true","text","Status","","","","","","",},
                            {"java.lang.Integer","codigo_cabedal","10","true","text","Codigo_cabedal","","","true","","","",}
                          };
    return metadata;
  }

}
