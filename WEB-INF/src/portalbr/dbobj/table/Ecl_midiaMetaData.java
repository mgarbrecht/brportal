package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ecl_midia
  * @version 03/04/2013 09:59:15
  */
public class Ecl_midiaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_MARCA","CODIGO_REGIONAL","CODIGO_CLIENTE","CODIGO_SEQUENCIAL"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ECL_MIDIA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","3","true","text","Codigo_marca","","","true","","","",},
                            {"java.lang.Integer","codigo_regional","3","true","text","Codigo_regional","","","true","","","",},
                            {"java.lang.Integer","codigo_cliente","5","true","text","Codigo_cliente","","","true","","","",},
                            {"java.lang.Integer","codigo_sequencial","4","true","text","Codigo_sequencial","","","true","","","",}
                          };
    return metadata;
  }

}
