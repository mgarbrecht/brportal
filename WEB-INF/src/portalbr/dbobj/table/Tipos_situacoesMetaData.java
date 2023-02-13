package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tipos_situacoes
  * @version 17/06/2014 08:08:32
  */
public class Tipos_situacoesMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_SITUACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TIPOS_SITUACOES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_situacao","3","true","text","Codigo_situacao","","","true","","","",},
                            {"java.lang.String","descricao_situacao","40","true","text","Descricao_situacao","","","","","","",},
                            {"java.sql.Timestamp","dt_cad_situacao","19","true","text","Dt_cad_situacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_situacao","30","true","text","Usuario_situacao","","","","","","",},
                            {"java.lang.String","observ_situacao","100","false","text","Observ_situacao","","","","","","",},
                            {"java.lang.String","indicador_situacao","1","false","text","Indicador_situacao","","","","","","",}
                          };
    return metadata;
  }

}
