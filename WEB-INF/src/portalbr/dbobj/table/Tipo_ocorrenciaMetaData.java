package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Tipo_ocorrencia
  * @version 03/04/2013 09:07:16
  */
public class Tipo_ocorrenciaMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TIPO_OCORRENCIA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","CODIGO","10","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","DESCRICAO","255","true","text","Descricao","","","","","","",},
                            {"java.lang.String","DESCONSIDERAR","1","true","text","Desconsiderar","","","","","","",}
                          };
    return metadata;
  }

}
