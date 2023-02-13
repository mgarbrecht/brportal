package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cliente_representante
  * @version 03/04/2013 10:04:14
  */
public class Cliente_representanteMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_CLIENTE","CODIGO_SEQUENCIAL","CODIGO_REPRESENTANTE"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CLIENTE_REPRESENTANTE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_cliente","5","true","text","Codigo_cliente","","","true","","","",},
                            {"int","codigo_sequencial","4","true","text","Codigo_sequencial","","","true","","","",},
                            {"java.lang.String","codigo_representante","5","true","text","Codigo_representante","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro","22","true","text","Data_cadastro","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario","30","true","text","Usuario","","","","","","",},
                            {"java.lang.String","sequencia_visita","2","false","text","Sequencia_visita","","","","","","",},
                            {"java.lang.String","situacao","1","true","text","Situacao","","","","","","",},
                            {"java.lang.String","observacao","80","false","text","Observacao","","","","","","",},
                            {"java.lang.String","sequencia_visita2","2","false","text","Sequencia_visita2","","","","","","",},
                            {"java.lang.String","sequencia_visita3","2","false","text","Sequencia_visita3","","","","","","",},
                            {"java.lang.String","sequencia_visita4","2","false","text","Sequencia_visita4","","","","","","",},
                            {"java.lang.String","codigo_representante_adicional","5","false","text","Codigo_representante_adicional","","","","","","",},
                            {"double","percentual_adicional","7","false","text","Percentual_adicional","","","true","","","",},
                            {"java.sql.Timestamp","data_log_afv","22","false","text","Data_log_afv","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
