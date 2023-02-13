package portalbr.dbobj.table;

/** DataBase Object from table ACESSO.Resumo_ped
  * @version 05/08/2014 12:03:38
  */
public class Resumo_pedMetaData {

  public static final String SCHEMA = "ACESSO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "RESUMO_PED";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"int","esc_seqn","4","true","text","Esc_seqn","","","true","","","",},
                            {"java.lang.String","rep_cdgo","5","true","text","Rep_cdgo","","","","","","",},
                            {"java.sql.Timestamp","data_dig","22","true","text","Data_dig","","","true","","","",},
                            {"int","codigo_marca","3","false","text","Codigo_marca","","","true","","","",},
                            {"double","pares","22","false","text","Pares","","","true","","","",},
                            {"double","valor","22","false","text","Valor","","","true","","","",},
                            {"int","codigo_regional","3","false","text","Codigo_regional","","","true","","","",},
                            {"int","lin_cdgo","22","false","text","Lin_cdgo","","","true","","","",},
                            {"int","ref_cdgo","10","false","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.String","ped_tipo","2","true","text","Ped_tipo","","","","","","",}
                          };
    return metadata;
  }

}
