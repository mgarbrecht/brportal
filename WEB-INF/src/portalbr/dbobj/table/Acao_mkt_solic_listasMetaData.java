package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_solic_listas
  * @version 03/04/2013 10:08:12
  */
public class Acao_mkt_solic_listasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO","ID_LISTA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MKT_SOLIC_LISTAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"int","id_lista","22","true","text","Id_lista","","","true","","","",}
                          };
    return metadata;
  }

}
