package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Numeracoes_grades_validas
  * @version 06/02/2012 11:14:51
  */
public class Numeracoes_grades_validasMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "NUMERACOES_GRADES_VALIDAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","true","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","numeracao_inicial","22","false","text","Numeracao_inicial","","","true","","","",},
                            {"java.lang.Integer","numeracao_final","22","false","text","Numeracao_final","","","true","","","",}
                          };
    return metadata;
  }

}
