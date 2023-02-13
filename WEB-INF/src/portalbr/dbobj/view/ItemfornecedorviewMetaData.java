package portalbr.dbobj.view;

/** DataBase Object from table .Itemfornecedorview
  * @version 03/04/2013 09:55:22
  */
public class ItemfornecedorviewMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","descricao","","","","","","",},
                            {"java.lang.String","fornecedor","10","false","text","fornecedor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct(die.codigo) codigo,         die.descricao        descricao,          ''                   fornecedor     from dom_item_estoque     die,          dom_item_fornecedor  dif    where die.codigo     = dif.ies_codigo      and dif.for_codigo > 0      and die.codigo = 1   order by descricao";
    return query;
  }

}
