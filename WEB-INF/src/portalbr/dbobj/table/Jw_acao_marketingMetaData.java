package portalbr.dbobj.table;

/** DataBase Object from table .Jw_acao_marketing
  * @version 27/05/2010 09:41:42
  */
public class Jw_acao_marketingMetaData {

  public static final String SCHEMA = "";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Date","data_entrega","12","false","text","","","","","","","",},
                            {"java.sql.Date","data_entrada","12","false","text","","","","","","","",},
                            {"int","acao","-22","false","text","","","","","","","",},
                            {"int","codigo_material","22","false","text","","","","","","","",},
                            {"java.lang.String","desc_material","40","false","text","","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","","","","","","","",},
                            {"java.lang.String","formato","100","false","text","","","","","","","",},
                            {"java.lang.String","observacao","4000","false","text","","","","","","","",},
                            {"int","cracha_usuario","-22","false","text","","","","","","","",},
                            {"int","codigo_regional","3","false","text","Código Regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","Nome Regional","","","","","","",},
                            {"java.lang.String","email","100","false","text","email","","","","","","",},
                            {"int","codigo_marca","3","false","text","Código Marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","Descrição Marca","","","","","","",}
                          };
    return metadata;
  }

}
