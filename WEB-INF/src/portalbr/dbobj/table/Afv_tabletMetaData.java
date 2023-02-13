package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Afv_tablet
  * @version 03/04/2013 10:07:28
  */
public class Afv_tabletMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "AFV_TABLET";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id","22","true","text","Id","","","true","","","",},
                            {"java.lang.String","nome_equipamento","200","false","text","Nome_equipamento","","","","","","",},
                            {"java.lang.String","versão_so","20","false","text","Versão_so","","","","","","",}
                          };
    return metadata;
  }

}
