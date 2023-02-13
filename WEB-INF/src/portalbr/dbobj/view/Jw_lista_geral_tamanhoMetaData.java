package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lista_geral_tamanho
  * @version 03/04/2013 09:25:42
  */
public class Jw_lista_geral_tamanhoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","products_options_values_name","10","false","text","products_options_values_name","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select '' products_options_values_name from dual";
    return query;
  }

}
