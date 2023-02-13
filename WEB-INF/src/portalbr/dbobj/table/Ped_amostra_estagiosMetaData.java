package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_estagios
  * @version 27/12/2010 08:54:25
  */
public class Ped_amostra_estagiosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ESTAGIO_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_AMOSTRA_ESTAGIOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","estagio_cdgo","22","true","text","Estagio_cdgo","","","true","","","",},
                            {"java.lang.String","descricao","60","true","text","Descricao","","","","","","",},
                            {"int","ordem","22","true","text","Ordem","","","true","","","",}
                          };
    return metadata;
  }

}
