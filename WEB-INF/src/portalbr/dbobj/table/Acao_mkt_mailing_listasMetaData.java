package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_mailing_listas
  * @version 03/04/2013 10:08:30
  */
public class Acao_mkt_mailing_listasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_LISTA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MKT_MAILING_LISTAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id_lista","22","true","text","Id_lista","","","true","","","",},
                            {"java.lang.String","nome_lista","35","false","text","Nome_lista","","","","","","",},
                            {"java.lang.String","situacao_lista","1","false","text","Situacao_lista","","","","","","",}
                          };
    return metadata;
  }

}
