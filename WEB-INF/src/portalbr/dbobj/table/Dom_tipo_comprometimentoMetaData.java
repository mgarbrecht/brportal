package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_tipo_comprometimento
  * @version 03/04/2013 09:59:41
  */
public class Dom_tipo_comprometimentoMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Dom_tipo_comprometimento";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","2","true","text","Código","","","true","","","",},
                            {"java.lang.String","descricao","41","true","text","Descrição","","","","","","",},
                            {"java.lang.String","tipo_empenhavel","1","true","text","tipo_empenhavel","","","","","","",}
                          };
    return metadata;
  }

}
