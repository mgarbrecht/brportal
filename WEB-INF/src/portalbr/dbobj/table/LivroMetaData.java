package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Livro
  * @version 05/07/2010 07:03:22
  */
public class LivroMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIV_CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "LIVRO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","liv_codigo","22","true","text","Liv_codigo","","","true","","","",},
                            {"java.lang.String","liv_descri","30","true","text","Liv_descri","","","","","","",},
                            {"java.lang.String","liv_status","1","true","text","Liv_status","","","","","","",},
                            {"java.lang.String","tipo_mercado","2","false","text","Tipo_mercado","","","","","","",},
                            {"java.lang.String","aceita_desconto","1","false","text","Aceita_desconto","","","","","","",},
                            {"java.lang.String","tipo_comissao","1","false","text","Tipo_comissao","","","","","","",},
                            {"double","percentual_desconto","6","false","text","Percentual_desconto","","","true","","","",},
                            {"double","bonificacao_maxima","6","false","text","Bonificacao_maxima","","","true","","","",},
                            {"java.lang.String","liv_vendor","1","false","text","Liv_vendor","","","","","","",},
                            {"java.lang.String","liv_status_afv","1","false","text","Liv_status_afv","","","","","","",}
                          };
    return metadata;
  }

}
