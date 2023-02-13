package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing_situacoes
  * @version 03/04/2013 10:08:37
  */
public class Acao_marketing_situacoesMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MARKETING_SITUACOES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","3","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","200","true","text","Descricao","","","","","","",}
                          };
    return metadata;
  }

}
