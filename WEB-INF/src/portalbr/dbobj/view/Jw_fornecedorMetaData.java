package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fornecedor
  * @version 03/04/2013 09:28:30
  */
public class Jw_fornecedorMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","for_codigo","22","false","text","for_codigo","","","","","","",},
                            {"java.lang.String","for_razsoc","40","false","text","for_razsoc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT f.for_codigo, f.for_razsoc FROM brio.fornecedor f";
    return query;
  }

}
