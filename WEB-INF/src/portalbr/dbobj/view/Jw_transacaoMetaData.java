package portalbr.dbobj.view;

/** DataBase Object from table .Jw_transacao
  * @version 05/07/2010 07:06:03
  */
public class Jw_transacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","trn_codigo","3","false","text","trn_codigo","","","","","","",},
                            {"java.sql.Timestamp","mov_data","22","false","text","mov_data","","dd/MM/yyyy","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select trn_codigo , mov_data from mov_receber where emp_empresa='01' and fil_filial='4' and tip_codigo='DUP' and tit_codigo='4I01114A' and rownum=1";
    return query;
  }

}
