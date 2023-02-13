package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Usuarios
  * @version 02/03/2015 12:16:09
  */
public class UsuariosMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"USUA_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Usuarios";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","usua_id","10","true","text","usua_id","","","true","","","",},
                            {"java.lang.String","usua_nome","40","true","text","Nome","","","","","","",},
                            {"java.lang.String","usua_email","100","false","text","Email","","","","","","",},
                            {"java.lang.String","usua_usuario","30","true","text","Usuário","","","","","","",},
                            {"java.lang.String","usua_senha","32","true","text","Senha","","","","","","",},
                            {"java.lang.String","usua_super","1","true","text","Super","","","","","","",},
                            {"java.lang.Integer","usua_enne_id","10","false","text","Tipo","","","true","","","",},
                            {"java.sql.Timestamp","usua_dt_senha","22","true","text","usua_dt_senha","","","true","","","",},
                            {"java.lang.Integer","usua_acessos","10","true","text","usua_acessos","","","true","","","",},
                            {"java.sql.Timestamp","usua_dt_ultimo_acesso","22","false","text","usua_dt_ultimo_acesso","","","true","","","",},
                            {"java.lang.String","situacao","1","false","text","situacao","","","","","","",},
                            {"java.lang.Integer","dias_consulta_retroativa","4","false","text","dias_consulta_retroativa","","","true","","","",},
                            {"java.lang.String","usua_expira_senha","1","true","text","Usua_expira_senha","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","22","true","text","dthr_inclusao","","","true","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","22","true","text","dthr_alteracao","","","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","true","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","true","text","Usuario_alteracao","","","","","","",}
                          };
    return metadata;
  }

}
