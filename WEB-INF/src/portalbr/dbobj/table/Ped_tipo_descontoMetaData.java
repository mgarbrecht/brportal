package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_tipo_desconto
  * @version 15/03/2011 13:52:38
  */
public class Ped_tipo_descontoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"TIPO_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_TIPO_DESCONTO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","tipo_cdgo","22","true","text","Tipo_cdgo","","","true","","","",},
                            {"java.lang.String","descr_tipo","35","true","text","Descr_tipo","","","","","","",},
                            {"java.lang.String","situacao","1","true","text","Situacao","","","","","","",}
                          };
    return metadata;
  }

}
