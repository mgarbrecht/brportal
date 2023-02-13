package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Componente_detalhe
  * @version 03/04/2013 10:01:32
  */
public class Componente_detalheMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CMP_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "COMPONENTE_DETALHE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cmp_cdgo","5","true","text","Cmp_cdgo","","","true","","","",},
                            {"java.lang.String","cmp_desc","40","true","text","Cmp_desc","","","","","","",},
                            {"java.lang.String","imprime_talao","1","true","text","Imprime_talao","","","","","","",}
                          };
    return metadata;
  }

}
