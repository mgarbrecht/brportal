package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Fc_acao_marketing_cliente_vw
  * @version 21/08/2013 11:18:22
  */
public class Fc_acao_marketing_cliente_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FC_ACAO_MARKETING_CLIENTE_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.String","marca","4000","false","text","Marca","","","","","","",},
                            {"java.lang.String","erc","4000","false","text","Erc","","","","","","",},
                            {"java.lang.String","desc_tmidia","40","true","text","Desc_tmidia","","","","","","",},
                            {"java.lang.Double","valor_tmidia","11","false","text","Valor_tmidia","","##,##0.00","true","","","",},
                            {"java.lang.String","obs_acao_mkt","4000","false","text","Obs_acao_mkt","","","","","","",},
                            {"java.sql.Timestamp","data_transacao","19","true","text","Data_transacao","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
