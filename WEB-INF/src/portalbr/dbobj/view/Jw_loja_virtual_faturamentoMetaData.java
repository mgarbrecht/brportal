package portalbr.dbobj.view;

/** DataBase Object from table .Jw_loja_virtual_faturamento
  * @version 03/04/2013 09:24:48
  */
public class Jw_loja_virtual_faturamentoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","filial","10","false","text","filial","","","","","","",},
                            {"java.lang.String","products_model","12","false","text","products_model","","","","","","",},
                            {"java.lang.String","products_name","65","false","text","products_name","","","","","","",},
                            {"double","qtde","17","false","text","qtde","","","","","","",},
                            {"double","valor","21","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ''filial       ,'' products_model       ,'' products_name       ,0.0 qtde       ,0.0 valor FROM dual";
    return query;
  }

}
