package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_tipo_estoque
  * @version 03/04/2013 09:59:33
  */
public class Dom_tipo_estoqueMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Dom_tipo_estoque";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","2","true","text","Código","","","true","","","",},
                            {"java.lang.String","descricao","40","true","text","Descrição","","","","","","",},
                            {"java.lang.String","tipo_fisico","1","false","text","tipo_fisico","","","","","","",},
                            {"java.lang.String","tipo_cm","1","false","text","tipo_cm","","","","","","",},
                            {"java.lang.String","tipo_oficial","1","false","text","tipo_oficial","","","","","","",},
                            {"java.lang.String","indicador_lancamento_manual","1","false","text","Indicador_lancamento_manual","","","","","","",}
                          };
    return metadata;
  }

}
