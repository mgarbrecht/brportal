package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Informacoes_cliente
  * @version 21/08/2013 11:21:35
  */
public class Informacoes_clienteMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "INFORMACOES_CLIENTE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","sequencia","22","true","text","Sequencia","","","true","","","",},
                            {"java.sql.Timestamp","data_informacao","19","true","text","Data_informacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario","30","true","text","Usuario","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","esc_seqn","4","false","text","Esc_seqn","","","true","","","",},
                            {"java.lang.String","informacoes","2000","true","text","Informacoes","","","","","","",},
                            {"java.lang.Integer","gre_cdgo","6","false","text","Gre_cdgo","","","true","","","",}
                          };
    return metadata;
  }

}
