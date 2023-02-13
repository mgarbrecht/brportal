package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_transacao
  * @version 03/04/2013 09:08:10
  */
public class Jw_t_transacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","trn","3","false","text","trn","","","","","","",},
                            {"java.util.Date","dat","22","false","text","dat","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select trn_codigo trn, mov_data dat from mov_receber where emp_empresa='01' and fil_filial='16' and tip_codigo='1' and tit_codigo='1'";
    return query;
  }

}
