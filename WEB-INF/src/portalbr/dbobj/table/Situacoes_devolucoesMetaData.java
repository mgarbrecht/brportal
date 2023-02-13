package portalbr.dbobj.table;

/** DataBase Object from table DEV.Situacoes_devolucoes
  * @version 05/07/2010 06:58:32
  */
public class Situacoes_devolucoesMetaData {

  public static final String SCHEMA = "DEV";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "SITUACOES_DEVOLUCOES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","2","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","50","true","text","Descricao","","","","","","",},
                            {"java.sql.Date","data_cad","10","true","text","Data_cad","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario_cad","30","true","text","Usuario_cad","","","","","","",}
                          };
    return metadata;
  }

}
