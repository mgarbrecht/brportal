package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_comb_especial_grade
  * @version 06/02/2012 14:42:37
  */
public class Ref_comb_especial_gradeMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO","NUMERACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REF_COMB_ESPECIAL_GRADE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"java.lang.String","numeracao","5","true","text","Numeracao","","","","","","",},
                            {"java.lang.Integer","qtp_pars","7","true","text","Qtp_pars","","","true","","","",}
                          };
    return metadata;
  }

}
