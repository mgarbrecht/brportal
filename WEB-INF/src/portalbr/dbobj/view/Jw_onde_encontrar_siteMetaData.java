package portalbr.dbobj.view;

/** DataBase Object from table .Jw_onde_encontrar_site
  * @version 03/04/2013 09:20:23
  */
public class Jw_onde_encontrar_siteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_marca","22","false","text","","","","","","","",},
                            {"java.lang.String","descricao_marca","50","false","text","","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","","","","","","","",},
                            {"java.lang.String","cliente","50","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","","","","","","","",},
                            {"java.lang.String","estado","50","false","text","","","","","","","",},
                            {"java.lang.String","cidade","50","false","text","","","","","","","",},
                            {"java.lang.String","bairro","50","false","text","","","","","","","",},
                            {"java.lang.String","logradouro","50","false","text","","","","","","","",},
                            {"java.lang.String","nro","50","false","text","","","","","","","",},
                            {"java.lang.String","cep","50","false","text","","","","","","","",},
                            {"java.lang.String","fone","50","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT '' codigo_marca                ,'' descricao_marca                ,'' cli_cdgo                ,'' esc_seqn                ,'' cliente				,'' cli_rzao                ,'' estado                ,'' cidade                ,'' bairro                ,'' logradouro                ,'' nro                ,'' cep                ,'' fone   FROM dual";
    return query;
  }

}
