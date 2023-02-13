package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_dados
  * @version 05/07/2010 07:06:48
  */
public class Jw_titulos_dadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","tip_codigo","3","false","text","tip_codigo","","","","","","",},
                            {"java.sql.Timestamp","tit_datvenc","22","false","text","tit_datvenc","","dd/MM/yyyy","","","","",},
                            {"double","tit_valor","24","false","text","tit_valor","","","","","","",},
                            {"double","tit_vlrec","24","false","text","tit_vlrec","","","","","","",},
                            {"int","w_dias","22","false","text","w_dias","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select emp_empresa, fil_filial, tip_codigo,  tit_datvenc, tit_valor, tit_vlrec,  trunc(to_date('10/2/2006','dd/mm/yyyy'))- tit_datvenc w_dias from titulos t where tit_codigo='N556638A'";
    return query;
  }

}
