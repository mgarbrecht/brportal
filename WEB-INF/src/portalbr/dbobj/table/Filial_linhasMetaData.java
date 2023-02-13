package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Filial_linhas
  * @version 05/08/2014 09:56:07
  */
public class Filial_linhasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"COD_EMPRESA","COD_FILIAL","LIN_CODIGO","REF_CODIGO","INDICADOR"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Filial_linhas";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod_empresa","3","true","text","cod_empresa","","","","","","",},
                            {"java.lang.String","cod_filial","4","true","text","cod_filial","","","","","","",},
                            {"int","lin_codigo","6","true","text","lin_codigo","","","true","","","",},
                            {"int","ref_codigo","10","true","text","ref_codigo","","","true","","","",},
                            {"int","indicador","1","true","text","indicador","","","true","","","",},
                            {"int","capacidade","7","true","text","capacidade","","","true","","","",},
                            {"java.lang.String","ativa","1","false","text","ativa","","","","","","",},
                            {"java.lang.String","cod_filial_gerencial","4","false","text","cod_filial_gerencial","","","","","","",},
                            {"java.lang.String","ativa_gerencial","1","false","text","ativa_gerencial","","","","","","",},
                            {"java.sql.Timestamp","data_cadastro","22","false","text","data_cadastro","","","true","","","",},
                            {"java.lang.String","usuario","20","false","text","usuario","","","","","","",},
                            {"java.lang.String","suprimentos","1","false","text","suprimentos","","","","","","",}
                          };
    return metadata;
  }

}
