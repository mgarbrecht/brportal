package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cor
  * @version 03/04/2013 10:00:45
  */
public class CorMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"COR_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "COR";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cor_cdgo","22","true","text","Cor_cdgo","","","true","","","",},
                            {"java.lang.String","cor_desc","60","true","text","Cor_desc","","","","","","",},
                            {"java.lang.String","cor_nomesp","60","true","text","Cor_nomesp","","","","","","",},
                            {"java.lang.String","cor_nome_ingles","60","false","text","Cor_nome_ingles","","","","","","",}
                          };
    return metadata;
  }

}
