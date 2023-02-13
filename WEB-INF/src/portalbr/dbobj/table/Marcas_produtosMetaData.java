package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Marcas_produtos
  * @version 05/07/2010 07:02:48
  */
public class Marcas_produtosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_MARCA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "MARCAS_PRODUTOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_marca","3","true","text","Codigo_marca","","","true","","","",},
                            {"java.lang.String","descricao_marca","30","true","text","Descricao_marca","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro","22","true","text","Data_cadastro","","","true","","","",},
                            {"java.lang.String","usuario","30","true","text","Usuario","","","","","","",}
                          };
    return metadata;
  }

}
