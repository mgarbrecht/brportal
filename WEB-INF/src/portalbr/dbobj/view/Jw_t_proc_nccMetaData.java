package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_proc_ncc
  * @version 03/04/2013 09:08:45
  */
public class Jw_t_proc_nccMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","mv","24","false","text","mv","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select mov_valor mv from mov_receber where nvl(emp_empresa,null)='1' and nvl(fil_filial,null)='1' and nvl(tip_codigo,null)='1' and nvl(trn_codigo,null)='NCC' and tit_codigo='1'";
    return query;
  }

}
