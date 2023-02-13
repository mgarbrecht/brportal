package portalbr.dbobj.view;

/** DataBase Object from table .Jw_protestos
  * @version 03/04/2013 09:15:16
  */
public class Jw_protestosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","mv","22","false","text","mv","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select nvl(mov_valor,0)mv from mov_receber where emp_empresa='01' and  fil_filial='5' and  tip_codigo='NTC' and  tit_codigo='N556638A' and  trn_codigo='PRO'";
    return query;
  }

}
