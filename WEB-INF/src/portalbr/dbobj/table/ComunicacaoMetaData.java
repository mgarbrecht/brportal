package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Comunicacao
  * @version 03/04/2013 10:01:24
  */
public class ComunicacaoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"SEQUENCIA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "COMUNICACAO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","sequencia","6","true","text","Sequencia","","","true","","","",},
                            {"java.lang.String","rep_cdgo","5","true","text","Rep_cdgo","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.sql.Clob","descricao_comunicacao","4000","true","text","Descricao_comunicacao","","","","","","",},
                            {"java.sql.Timestamp","data_comunicacao","22","true","text","Data_comunicacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_cadastramento","30","true","text","Usuario_cadastramento","","","","","","",},
                            {"java.lang.Integer","codigo_colecao","22","false","text","Codigo_colecao","","","true","","","",},
                            {"java.lang.Integer","codigo_argumento","22","false","text","Codigo_argumento","","","true","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","Codigo_marca","","","true","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","Cab_cdgo","","","true","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","Cor_cdgo","","","true","","","",},
                            {"java.lang.String","status","2","false","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
