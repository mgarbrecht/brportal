package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Projetos
  * @version 22/11/2010 11:41:10
  */
public class ProjetosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PROJETO_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PROJETOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","projeto_cdgo","15","true","text","Projeto_cdgo","","","","","","",},
                            {"java.lang.String","projeto_desc","30","true","text","Projeto_desc","","","","","","",},
                            {"java.lang.Integer","codigo_colecao","2","true","text","Codigo_colecao","","","true","","","",},
                            {"java.lang.Integer","codigo_marca","3","true","text","Codigo_marca","","","true","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","Lin_cdgo","","0","true","","","",},
                            {"java.sql.Date","data_inicio","10","false","text","Data_inicio","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_fim","10","false","text","Data_fim","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Integer","tipo_cdgo","4","true","text","Tipo_cdgo","","","true","","","",},
                            {"java.lang.Integer","nro_modelos","2","false","text","Nro_modelos","","","true","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",},
                            {"java.sql.Date","data_criacao","10","false","text","Data_criacao","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Integer","codigo_subdivisao","3","false","text","Codigo_subdivisao","","","true","","","",},
                            {"java.lang.String","fma_cdgo","10","false","text","Fma_cdgo","","","","","","",}
                          };
    return metadata;
  }

}
