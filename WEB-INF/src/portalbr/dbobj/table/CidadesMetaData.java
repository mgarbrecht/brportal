package portalbr.dbobj.table;

/** DataBase Object from table .Cidades
  * @version 27/05/2010 10:32:28
  */
public class CidadesMetaData {

  public static final String SCHEMA = "";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","cidade","65","false","text","","","","","","","",}
                          };
    return metadata;
  }

}
