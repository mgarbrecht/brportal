package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_usuarios_vw
  * @version 25/05/2015 09:23:57
  */
public class Acessos_usuarios_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACESSOS_USUARIOS_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","usua_id","22","false","text","Usua_id","","","true","","","",},
                            {"java.lang.Integer","doin_id","22","false","text","Doin_id","","","true","","","",},
                            {"java.lang.Integer","dias_consulta_retroativa","22","false","text","Dias_consulta_retroativa","","","true","","","",},
                            {"java.lang.String","negar_acesso","1","false","text","Negar_acesso","","","","","","",}
                          };
    return metadata;
  }

}
