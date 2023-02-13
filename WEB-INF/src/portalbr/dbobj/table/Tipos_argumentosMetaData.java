package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tipos_argumentos
  * @version 03/04/2013 09:07:07
  */
public class Tipos_argumentosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_ARGUMENTO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TIPOS_ARGUMENTOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_argumento","2","true","text","Codigo_argumento","","","true","","","",},
                            {"java.lang.String","descricao_argumento","30","true","text","Descricao_argumento","","","","","","",},
                            {"java.lang.String","usuario_argumento","30","true","text","Usuario_argumento","","","","","","",},
                            {"java.sql.Date","data_argumento","10","true","text","Data_argumento","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
