package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Municipios_prazos
  * @version 18/11/2013 16:00:12
  */
public class Municipios_prazosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "MUNICIPIOS_PRAZOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","5","false","text","Codigo","","","true","","","",},
                            {"java.lang.String","codigo_ibge","7","false","text","Codigo_ibge","","","","","","",},
                            {"java.lang.Integer","prazo_entrega","20","false","text","Prazo_entrega","","","true","","","",},
                            {"java.lang.String","sigla_transportadora","20","false","text","Sigla_transportadora","","","","","","",},
                            {"java.lang.String","est_unifed","4","false","text","Est_unifed","","","","","","",},
                            {"java.lang.String","segunda","1","false","text","Segunda","","","","","","",},
                            {"java.lang.String","terca","1","false","text","Terca","","","","","","",},
                            {"java.lang.String","quarda","1","false","text","Quarda","","","","","","",},
                            {"java.lang.String","quinta","1","false","text","Quinta","","","","","","",},
                            {"java.lang.String","sexta","1","false","text","Sexta","","","","","","",},
                            {"java.lang.String","sabado","1","false","text","Sabado","","","","","","",},
                            {"java.lang.String","domingo","1","false","text","Domingo","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","false","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","false","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.lang.String","descricao","60","false","text","Descricao","","","","","","",},
                            {"java.lang.Integer","id","22","true","text","Id","","","true","","","",}
                          };
    return metadata;
  }

}
