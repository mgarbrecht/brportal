package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0050
  * @version 03/04/2013 09:15:03
  */
public class Jw_pse0050MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fornecedor","10","false","text","","","","","","","",},
                            {"java.lang.String","processo","10","false","text","","","","","","","",},
                            {"java.lang.String","remessa","10","false","text","","","","","","","",},
                            {"java.lang.String","talao","10","false","text","","","","","","","",},
                            {"java.lang.String","linha","10","false","text","","","","","","","",},
                            {"java.lang.String","referencia","10","false","text","","","","","","","",},
                            {"java.lang.String","cabedal","10","false","text","","","","","","","",},
                            {"java.lang.String","cor","10","false","text","","","","","","","",},
                            {"double","pares","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select '' fornecedor      , '' processo      , '' remessa , '' talao , '' linha , '' referencia , '' cabedal , '' cor , 0.0 pares from dual";
    return query;
  }

}
