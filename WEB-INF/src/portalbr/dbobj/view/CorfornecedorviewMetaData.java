package portalbr.dbobj.view;

/** DataBase Object from table .Corfornecedorview
  * @version 03/04/2013 10:00:37
  */
public class CorfornecedorviewMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.String","fornecedor","10","false","text","fornecedor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct(dif.cor_cdgo) codigo,             c.cor_desc             descricao,          ''                     fornecedor     from cor                    c,                  dom_item_fornecedor    dif           where dif.for_codigo > 0      and dif.for_codigo = 1                    and dif.cor_cdgo   = c.cor_cdgo    order by descricao";
    return query;
  }

}
