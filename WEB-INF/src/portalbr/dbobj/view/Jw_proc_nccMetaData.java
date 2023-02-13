package portalbr.dbobj.view;

/** DataBase Object from table .Jw_proc_ncc
  * @version 03/04/2013 09:15:48
  */
public class Jw_proc_nccMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","mov_valor","24","false","text","mov_valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select mov_valor   from mov_receber  where nvl(emp_empresa,null)='01'  and nvl(fil_filial,null)='16'  and nvl(tip_codigo,null)='DUP'  and nvl(trn_codigo,null)='NCC'  and tit_codigo='12312123'";
    return query;
  }

}
