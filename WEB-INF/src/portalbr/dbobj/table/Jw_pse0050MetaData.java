package portalbr.dbobj.table;

/** DataBase Object from table .Jw_pse0050
  * @version 27/05/2010 10:15:44
  */
public class Jw_pse0050MetaData {

  public static final String SCHEMA = "";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fornecedor","10","false","text","","","","","","","",},
                            {"java.lang.String","processo","10","false","text","","","","","","","",},
                            {"java.lang.String","remessa","10","false","text","","","","","","","",},
                            {"java.lang.String","talao","10","false","text","","","","","","","",},
                            {"java.lang.String","linha","10","false","text","","","","","","","",},
                            {"java.lang.String","referencia","10","false","text","","","","","","","",},
                            {"java.lang.String","cabedal","10","false","text","","","","","","","",},
                            {"java.lang.String","cor","10","false","text","","","","","","","",},
                            {"double","pares","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

}
