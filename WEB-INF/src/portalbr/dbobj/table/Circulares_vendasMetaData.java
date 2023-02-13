package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Circulares_vendas
  * @version 03/04/2013 10:05:57
  */
public class Circulares_vendasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NUMERO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CIRCULARES_VENDAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","numero","7","true","text","Numero","","","","","","",},
                            {"java.sql.Timestamp","data","22","true","text","Data","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","remetente","20","true","text","Remetente","","","","","","",},
                            {"int","destinatario","2","true","text","Destinatario","","","true","","","",},
                            {"java.lang.String","assunto","30","true","text","Assunto","","","","","","",},
                            {"java.lang.String","texto","2000","true","text","Texto","","","","","","",},
                            {"java.lang.String","status","1","true","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
