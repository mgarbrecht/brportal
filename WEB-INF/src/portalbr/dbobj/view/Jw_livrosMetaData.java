package portalbr.dbobj.view;

/** DataBase Object from table .Jw_livros
  * @version 03/04/2013 09:25:18
  */
public class Jw_livrosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","liv_codigo","10","false","text","liv_codigo","","","","","","",},
                            {"java.lang.String","liv_descri","30","false","text","liv_descri","","","","","","",},
                            {"java.lang.String","liv_status","1","false","text","liv_status","","","","","","",},
                            {"java.lang.String","tipo_mercado","2","false","text","tipo_mercado","","","","","","",},
                            {"java.lang.String","aceita_desconto","1","false","text","aceita_desconto","","","","","","",},
                            {"java.lang.String","tipo_comissao","1","false","text","tipo_comissao","","","","","","",},
                            {"double","percentual_desconto","24","false","text","PERCENTUAL_DESCONTO","","","","","","",},
                            {"double","bonificacao_maxima","24","false","text","bonificacao_maxima","","","","","","",},
                            {"java.lang.String","liv_vendor","1","false","text","liv_vendor","","","","","","",},
                            {"java.lang.String","liv_status_afv","1","false","text","liv_status_afv","","","","","","",},
                            {"java.lang.String","tipo_pedido","2","false","text","tipo_pedido","","","","","","",},
                            {"java.lang.String","permiti_alterar_preco","1","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT * FROM livro WHERE liv_status = 'A'";
    return query;
  }

}
