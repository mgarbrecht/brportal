package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_ref_exp0400
  * @version 03/04/2013 09:23:23
  */
public class Jw_lv_ref_exp0400MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_cdgo","10","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","ref_cdgo","10","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","ref_descricao_exportacao","100","false","text","ref_descricao_exportacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct    refe.lin_cdgo   ,refe.ref_cdgo   ,refe.ref_descricao_exportacao from ref refe WHERE (1=1 or refe.ref_status = 'A') order by ref_cdgo";
    return query;
  }

}
