package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Normativa
  * @version 26/09/2014 08:54:48
  */
public class NormativaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NRO_NORMATIVA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "NORMATIVA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","nro_normativa","22","true","text","Nro_normativa","","","true","","","",},
                            {"java.lang.String","descricao","100","true","text","Descricao","","","","","","",},
                            {"java.lang.String","observacao","100","false","text","Observacao","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","false","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_inclusao","100","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","100","false","text","Usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","data_log_afv","19","false","text","Data_log_afv","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
