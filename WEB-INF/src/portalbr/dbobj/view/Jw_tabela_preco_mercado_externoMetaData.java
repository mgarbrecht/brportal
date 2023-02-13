package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tabela_preco_mercado_externo
  * @version 09/10/2015 10:07:02
  */
public class Jw_tabela_preco_mercado_externoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_livro","22","false","text","Livro","","","","","","",},
                            {"java.sql.Timestamp","versao_tabela","22","false","text","versao_tabela","","dd/MM/yyyy HH:mm:ss","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_livro      ,tp.versao_tabela  FROM tabela_preco tp WHERE tp.codigo_livro NOT IN (0, 55)   AND tp.codigo_pais = 1 ORDER BY tp.codigo_livro, tp.versao_tabela DESC";
    return query;
  }

}
