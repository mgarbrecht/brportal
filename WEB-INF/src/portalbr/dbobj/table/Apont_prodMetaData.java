package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Apont_prod
  * @version 02/07/2015 08:41:39
  */
public class Apont_prodMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"REM_NRO","TAL_NRO","SET_CDGO","APP_SEQ"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "APONT_PROD";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","rem_nro","22","true","text","Rem_nro","","","true","","","",},
                            {"java.lang.Integer","tal_nro","3","true","text","Tal_nro","","","true","","","",},
                            {"java.lang.String","set_cdgo","5","true","text","Set_cdgo","","","","","","",},
                            {"java.lang.Integer","app_seq","2","true","text","App_seq","","","true","","","",},
                            {"java.lang.String","app_minfab","5","false","text","App_minfab","","","","","","",},
                            {"java.sql.Timestamp","app_data","19","true","text","App_data","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","app_parbom","5","true","text","App_parbom","","","true","","","",},
                            {"java.lang.Integer","app_parrej","3","true","text","App_parrej","","","true","","","",},
                            {"java.lang.Integer","app_tempo","6","false","text","App_tempo","","","true","","","",},
                            {"java.lang.String","app_observ","2000","false","text","App_observ","","","","","","",},
                            {"java.lang.String","app_observ1","2000","false","text","App_observ1","","","","","","",},
                            {"java.lang.String","usuario_inclusao","100","false","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dtrh_corrente","19","false","text","Dtrh_corrente","","dd/MM/yyyy HH:mm:ss","true","","","",}
                          };
    return metadata;
  }

}
