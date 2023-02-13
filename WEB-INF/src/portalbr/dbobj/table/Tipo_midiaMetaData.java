package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tipo_midia
  * @version 03/04/2013 09:07:26
  */
public class Tipo_midiaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CDGO_TMIDIA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TIPO_MIDIA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cdgo_tmidia","2","true","text","Cdgo_tmidia","","","true","","","",},
                            {"java.lang.String","desc_tmidia","40","true","text","Desc_tmidia","","","","","","",}
                          };
    return metadata;
  }

}
