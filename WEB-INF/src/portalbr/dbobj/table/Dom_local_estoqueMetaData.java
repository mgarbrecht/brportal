package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_local_estoque
  * @version 21/08/2013 11:16:40
  */
public class Dom_local_estoqueMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOM_LOCAL_ESTOQUE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","5","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","40","true","text","Descricao","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","les_codigo","5","false","text","Les_codigo","","","true","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Fil_filial","","","","","","",},
                            {"java.lang.Integer","for_codigo","9","false","text","For_codigo","","","true","","","",},
                            {"java.lang.Integer","les_codigo2","5","false","text","Les_codigo2","","","true","","","",}
                          };
    return metadata;
  }

}
