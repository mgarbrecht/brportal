package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Usuarios_fab251
  * @version 03/04/2013 09:05:57
  */
public class Usuarios_fab251MetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"COD_USUARIO","EMP_EMPRESA","FIL_FILIAL"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "USUARIOS_FAB251";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod_usuario","30","true","text","Cod_usuario","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","22","false","text","Dthr_inclusao","","","true","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","22","false","text","Dthr_alteracao","","","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",},
                            {"java.lang.String","emp_empresa","3","true","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","true","text","Fil_filial","","","","","","",}
                          };
    return metadata;
  }

}
