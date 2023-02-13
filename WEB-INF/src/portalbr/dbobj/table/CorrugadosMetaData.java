package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Corrugados
  * @version 03/04/2013 10:00:28
  */
public class CorrugadosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CORRUGADOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","2","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","30","true","text","Descricao","","","","","","",},
                            {"java.lang.Integer","qt_par_corrug","3","true","text","Qt_par_corrug","","","true","","","",},
                            {"java.lang.String","ativo","1","true","text","Ativo","","","","","","",}
                          };
    return metadata;
  }

}
