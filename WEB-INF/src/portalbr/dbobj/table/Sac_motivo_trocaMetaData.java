package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Sac_motivo_troca
  * @version 05/12/2019 13:21:56
  */
public class Sac_motivo_trocaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "SAC_MOTIVO_TROCA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","10","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","240","true","text","Descricao","","","","","","",},
                            {"java.lang.Integer","codigo_grupo","22","false","text","Codigo_grupo","","","true","","","",},
                            {"java.lang.String","status","240","false","text","Status","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro","19","false","text","Data_cadastro","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_cadastro","240","false","text","Usuario_cadastro","","","","","","",},
                            {"java.sql.Timestamp","data_alteracao","19","false","text","Data_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_alteracao","240","false","text","Usuario_alteracao","","","","","","",}
                          };
    return metadata;
  }

}
