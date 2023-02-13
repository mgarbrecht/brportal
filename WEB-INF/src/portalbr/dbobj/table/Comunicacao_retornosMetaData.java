package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Comunicacao_retornos
  * @version 03/04/2013 10:01:15
  */
public class Comunicacao_retornosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"SEQUENCIA","SEQUENCIA_RETORNOS"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "COMUNICACAO_RETORNOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","sequencia","6","true","text","Sequencia","","","true","","","",},
                            {"int","sequencia_retornos","6","true","text","Sequencia_retornos","","","true","","","",},
                            {"java.sql.Clob","descricao_retorno","4000","false","text","Descricao_retorno","","","","","","",},
                            {"java.sql.Timestamp","data_retorno","22","false","text","Data_retorno","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario_retorno","30","false","text","Usuario_retorno","","","","","","",}
                          };
    return metadata;
  }

}
