package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing_estagios
  * @version 03/04/2013 10:08:51
  */
public class Acao_marketing_estagiosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ESTAGIO_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MARKETING_ESTAGIOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","estagio_cdgo","22","true","text","Estágio","","","true","","","",},
                            {"java.lang.String","descricao","60","true","text","Descrição","","","","","","",},
                            {"java.lang.Integer","ordem","22","true","text","Ordem","","0","true","","","",}
                          };
    return metadata;
  }

}
