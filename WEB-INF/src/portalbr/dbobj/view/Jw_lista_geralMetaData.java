package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lista_geral
  * @version 03/04/2013 09:25:52
  */
public class Jw_lista_geralMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","products_model","10","false","text","products_model","","","","","","",},
                            {"java.lang.String","products_image","10","false","text","products_image","","","","","","",},
                            {"double","products_price","22","false","text","products_price","","","","","","",},
                            {"java.lang.String","products_options_values_name","10","false","text","products_options_values_name","","","","","","",},
                            {"java.lang.String","cor","10","false","text","cor","","","","","","",},
                            {"int","estoque_atual","22","false","text","estoque_atual","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select '' products_model, '' products_image, 0 products_price, '' products_options_values_name, '' cor, 0 estoque_atual from dual";
    return query;
  }

}
