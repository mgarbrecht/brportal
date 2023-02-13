package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Grupo_posicao_fabrica
  * @version 03/04/2013 09:55:39
  */
public class Grupo_posicao_fabricaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO_GRUPO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Grupo_posicao_fabrica";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_grupo","3","true","text","codigo_grupo","","","true","","","",},
                            {"java.lang.String","descricao_grupo","30","true","text","descricao_grupo","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro_grupo","22","true","text","data_cadastro_grupo","","","true","","","",},
                            {"java.lang.String","usuario_grupo","30","true","text","usuario_grupo","","","","","","",},
                            {"java.lang.String","tipo_produto_ncm","2","false","text","tipo_produto_ncm","","","","","","",},
                            {"java.lang.String","unm_codigo","3","false","text","Unm_codigo","","","","","","",}
                          };
    return metadata;
  }

}
