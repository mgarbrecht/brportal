package portalbr.dbobj.view;

/** DataBase Object from table .Jw_venc_orig
  * @version 05/07/2010 07:04:39
  */
public class Jw_venc_origMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","mov_datvenc","22","false","text","mov_datvenc","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","mov_cobjur","1","false","text","mov_cobjur","","","","","","",},
                            {"java.lang.String","mov_condes","1","false","text","mov_condes","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select mov_datvenc ,  mov_cobjur ,  mov_condes   from mov_receber  where emp_empresa='01'  and fil_filial='3'  and tip_codigo='DUS'  and tit_codigo='123123'  and trn_codigo='VCT'";
    return query;
  }

}
