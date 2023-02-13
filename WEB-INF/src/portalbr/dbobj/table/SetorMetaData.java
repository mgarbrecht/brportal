package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Setor
  * @version 23/05/2014 10:29:38
  */
public class SetorMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"SET_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "SETOR";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","set_cdgo","5","true","text","Set_cdgo","","","","","","",},
                            {"java.lang.String","set_nome","40","false","text","Set_nome","","","","","","",}
                          };
    return metadata;
  }

}
