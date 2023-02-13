package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_materiais_faturas
  * @version 19/03/2015 14:50:21
  */
public class Jw_necessidade_materiais_faturasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fatura","20","false","text","fatura","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select '' fatura, 0 pares from dual";
    return query;
  }

}
