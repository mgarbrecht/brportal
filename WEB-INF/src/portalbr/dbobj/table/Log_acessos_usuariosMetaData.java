package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Log_acessos_usuarios
  * @version 05/07/2010 07:03:10
  */
public class Log_acessos_usuariosMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"USUA_ID","IP"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "LOG_ACESSOS_USUARIOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","usua_id","22","true","text","Usua_id","","##,##0.00","true","","","",},
                            {"java.lang.String","ip","100","true","text","Ip","","","","","","",},
                            {"java.sql.Timestamp","data_acesso","22","true","text","Data_acesso","","dd/MM/yyyy HH:mm:ss","true","","","",}
                          };
    return metadata;
  }

}
