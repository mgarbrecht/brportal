package portalbr.dbobj.table;

/** DataBase Object from table CPR.Processo_fab
  * @version 05/07/2010 07:00:06
  */
public class Processo_fabMetaData {

  public static final String SCHEMA = "CPR";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PRO_NUMERO","PRO_TIPO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PROCESSO_FAB";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pro_numero","3","true","text","Pro_numero","","","true","","","",},
                            {"java.lang.String","pro_tipo","1","true","text","Pro_tipo","","","","","","",},
                            {"java.lang.String","pro_nome","40","true","text","Pro_nome","","","","","","",},
                            {"java.lang.String","unm_cdgo","3","false","text","Unm_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_ncm","10","false","text","Codigo_ncm","","","true","","","",},
                            {"java.lang.String","conserto","1","true","text","Conserto","","","","","","",}
                          };
    return metadata;
  }

}
