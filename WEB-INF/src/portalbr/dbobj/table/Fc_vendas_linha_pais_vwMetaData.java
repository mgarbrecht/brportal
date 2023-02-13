package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Fc_vendas_linha_pais_vw
  * @version 21/08/2013 11:19:06
  */
public class Fc_vendas_linha_pais_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FC_VENDAS_LINHA_PAIS_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","mes","19","true","text","Mes","","","true","","","",},
                            {"java.lang.Integer","ano","19","true","text","Ano","","","true","","","",},
                            {"java.lang.Integer","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Double","lin_cdgo","22","false","text","Lin_cdgo","","0","true","","","",},
                            {"java.lang.Double","qtd","0","false","text","Qtd","","0","true","","","",},
                            {"java.lang.Double","vlr","22","false","text","Vlr","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
