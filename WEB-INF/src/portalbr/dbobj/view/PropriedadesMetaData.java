package portalbr.dbobj.view;

/** DataBase Object from table .Propriedades
  * @version 05/07/2010 06:59:56
  */
public class PropriedadesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","CHAVE","100","false","text","","","","","","","",},
                            {"java.lang.String","VALOR","4000","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select '' chave, '' valor from dual";
    return query;
  }

}
