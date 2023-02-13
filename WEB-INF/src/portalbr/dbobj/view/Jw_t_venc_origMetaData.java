package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_venc_orig
  * @version 03/04/2013 09:07:57
  */
public class Jw_t_venc_origMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.util.Date","md","22","false","text","md","","","","","","",},
                            {"java.lang.String","mc","1","false","text","mc","","","","","","",},
                            {"java.lang.String","mo","1","false","text","mo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select mov_datvenc md, mov_cobjur mc, mov_condes mo from mov_receber where emp_empresa='01' and fil_filial='16' and tip_codigo='1' and tit_codigo='1' and trn_codigo='VCT'";
    return query;
  }

}
