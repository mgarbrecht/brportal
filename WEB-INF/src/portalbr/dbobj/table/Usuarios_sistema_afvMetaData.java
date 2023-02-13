package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Usuarios_sistema_afv
  * @version 03/04/2013 09:05:23
  */
public class Usuarios_sistema_afvMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_USUARIO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "USUARIOS_SISTEMA_AFV";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_usuario","30","true","text","Codigo_usuario","","","","","","",},
                            {"java.lang.String","nome_usuario","30","true","text","Nome_usuario","","","","","","",},
                            {"java.lang.String","senha_usuario","30","true","text","Senha_usuario","","","","","","",},
                            {"java.lang.Integer","codigo_regional","3","false","text","Codigo_regional","","","true","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","Codigo_representante","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro","19","false","text","Data_cadastro","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario","30","true","text","Usuario","","","","","","",},
                            {"java.lang.Integer","id_tablet","22","false","text","Id_tablet","","","true","","","",}
                          };
    return metadata;
  }

}
