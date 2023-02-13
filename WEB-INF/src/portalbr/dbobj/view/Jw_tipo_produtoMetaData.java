package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_produto
  * @version 05/07/2010 07:08:18
  */
public class Jw_tipo_produtoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","descricao_grupo","30","false","text","","","","","","","",},
                            {"int","codigo_grupo","3","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT gpf.descricao_grupo        ,gpf.codigo_grupo    FROM grupo_posicao_fabrica gpf   ORDER BY 1";
    return query;
  }

}
