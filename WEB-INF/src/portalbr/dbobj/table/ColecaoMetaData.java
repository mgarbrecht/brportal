package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Colecao
  * @version 03/04/2013 10:01:53
  */
public class ColecaoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "COLECAO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","2","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","30","true","text","Descricao","","","","","","",},
                            {"int","mes_lcto","2","false","text","Mes_lcto","","","true","","","",},
                            {"java.lang.String","descr_lcto","30","false","text","Descr_lcto","","","","","","",},
                            {"int","mes_inicio","2","false","text","Mes_inicio","","","true","","","",},
                            {"int","mes_final","2","false","text","Mes_final","","","true","","","",}
                          };
    return metadata;
  }

}
