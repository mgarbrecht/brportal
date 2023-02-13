package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Grupo_economico
  * @version 21/08/2013 11:20:51
  */
public class Grupo_economicoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"GRE_GRUPO","GRE_SEQN"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Grupo_economico";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","gre_grupo","6","true","text","gre_grupo","","","true","","","",},
                            {"java.lang.String","gre_descricao","30","true","text","gre_descricao","","","","","","",},
                            {"int","gre_seqn","5","true","text","gre_seqn","","","true","","","",},
                            {"int","cli_cdgo","22","false","text","cli_cdgo","","","true","","","",},
                            {"int","for_codigo","9","false","text","for_codigo","","","true","","","",},
                            {"java.lang.String","gre_tipo","1","false","text","gre_tipo","","","","","","",},
                            {"java.sql.Timestamp","data_cad","22","true","text","data_cad","","","true","","","",},
                            {"java.lang.String","usuario_cad","30","true","text","usuario_cad","","","","","","",},
                            {"java.lang.String","controla_producao","1","false","text","controla_producao","","","","","","",},
                            {"java.sql.Timestamp","data_log_afv","22","false","text","data_log_afv","","","true","","","",},
                            {"java.sql.Timestamp","data_inativacao","22","false","text","data_inativacao","","","true","","","",},
                            {"java.lang.String","usuario_inativacao","30","false","text","usuario_inativacao","","","","","","",},
                            {"java.lang.String","status","1","true","text","status","","","","","","",}
                          };
    return metadata;
  }

}
