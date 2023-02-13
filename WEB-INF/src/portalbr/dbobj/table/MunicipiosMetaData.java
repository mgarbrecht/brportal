package portalbr.dbobj.table;

/** DataBase Object from table DEV.Municipios
  * @version 18/11/2013 11:35:26
  */
public class MunicipiosMetaData {

  public static final String SCHEMA = "DEV";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO","EST_UNIFED","EST_PAIS_CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "MUNICIPIOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","5","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","est_unifed","2","true","text","Est_unifed","","","","","","",},
                            {"java.lang.Integer","est_pais_codigo","3","true","text","Est_pais_codigo","","","true","","","",},
                            {"java.lang.String","descricao","60","true","text","Descricao","","","","","","",},
                            {"java.lang.String","usuario_cad","30","true","text","Usuario_cad","","","","","","",},
                            {"java.sql.Timestamp","data_cad","19","true","text","Data_cad","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","complemento","60","false","text","Complemento","","","","","","",},
                            {"java.lang.Integer","populacao","8","false","text","Populacao","","","true","","","",},
                            {"java.lang.Integer","eleitores","8","false","text","Eleitores","","","true","","","",},
                            {"java.lang.Integer","votos","8","false","text","Votos","","","true","","","",},
                            {"java.lang.Integer","prc_numero_praca_compensacao","6","false","text","Prc_numero_praca_compensacao","","","true","","","",},
                            {"java.lang.String","indicador_comissao","1","false","text","Indicador_comissao","","","","","","",},
                            {"java.sql.Timestamp","data_log_afv","19","false","text","Data_log_afv","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Double","ipc","14","false","text","Ipc","","##,##0.00","true","","","",},
                            {"java.lang.String","codigo_ibge","7","false","text","Codigo_ibge","","","","","","",},
                            {"java.lang.String","reg_cdgo","3","false","text","Reg_cdgo","","","","","","",}
                          };
    return metadata;
  }

}
