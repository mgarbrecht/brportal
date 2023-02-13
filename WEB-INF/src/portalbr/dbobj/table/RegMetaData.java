package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Reg
  * @version 10/08/2017 14:35:53
  */
public class RegMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"REG_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REG";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","reg_cdgo","3","true","text","Reg_cdgo","","","","","","",},
                            {"java.lang.String","reg_nome","30","true","text","Reg_nome","","","","","","",},
                            {"java.lang.String","reg_cdgo_macro","3","false","text","Reg_cdgo_macro","","","","","","",}
                          };
    return metadata;
  }

}
