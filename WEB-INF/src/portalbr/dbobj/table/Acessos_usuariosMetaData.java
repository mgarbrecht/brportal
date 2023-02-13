package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_usuarios
  * @version 03/04/2013 10:07:37
  */
public class Acessos_usuariosMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ACUS_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACESSOS_USUARIOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","acus_id","10","true","text","Acus_id","","","true","","","",},
                            {"java.lang.Integer","acus_usua_id","22","true","text","Acus_usua_id","","","true","","","",},
                            {"java.lang.Integer","acus_doin_id","10","true","text","Acus_doin_id","","","true","","","",},
                            {"java.lang.String","acus_negar_acesso","1","true","text","Acus_negar_acesso","","","","","","",},
                            {"java.lang.Integer","acus_dias_consulta_retroativa","5","false","text","Acus_dias_consulta_retroativa","","","true","","","",}
                          };
    return metadata;
  }

}
