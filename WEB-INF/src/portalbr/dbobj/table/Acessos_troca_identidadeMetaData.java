package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_troca_identidade
  * @version 12/12/2017 12:21:32
  */
public class Acessos_troca_identidadeMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ATID_USUA_ID","ATID_TIEN_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACESSOS_TROCA_IDENTIDADE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","atid_usua_id","22","true","text","Atid_usua_id","","","true","","","",},
                            {"int","atid_tien_id","10","true","text","Atid_tien_id","","","true","","","",}
                          };
    return metadata;
  }

}
