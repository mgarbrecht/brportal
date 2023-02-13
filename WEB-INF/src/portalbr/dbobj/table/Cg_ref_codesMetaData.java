package portalbr.dbobj.table;

/** DataBase Object from table ACESSOS.Cg_ref_codes
  * @version 03/04/2013 10:06:15
  */
public class Cg_ref_codesMetaData {

  public static final String SCHEMA = "ACESSOS";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CG_REF_CODES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rv_domain","100","false","text","Rv_domain","","","","","","",},
                            {"java.lang.String","rv_low_value","240","false","text","Rv_low_value","","","","","","",},
                            {"java.lang.String","rv_high_value","240","false","text","Rv_high_value","","","","","","",},
                            {"java.lang.String","rv_abbreviation","240","false","text","Rv_abbreviation","","","","","","",},
                            {"java.lang.String","rv_meaning","240","false","text","Rv_meaning","","","","","","",}
                          };
    return metadata;
  }

}
