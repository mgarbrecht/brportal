package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_verifica_nota_credito
  * @version 03/04/2013 09:07:47
  */
public class Jw_t_verifica_nota_creditoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ncc","1","false","text","ncc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select decode(trn_codigo,'NCC','*',' ')ncc from mov_receber where tit_codigo='1' and nvl(trn_codigo,null)='NCC'";
    return query;
  }

}
