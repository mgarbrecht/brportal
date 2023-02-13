package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cheques_cld
  * @version 03/04/2013 09:49:45
  */
public class Jw_cheques_cldMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","numero","22","false","text","numero","","","","","","",},
                            {"java.lang.String","agencia","5","false","text","agencia","","","","","","",},
                            {"java.lang.String","portador","4","false","text","portador","","","","","","",},
                            {"java.lang.String","cod_repres","5","false","text","cod_repres","","","","","","",},
                            {"java.lang.String","rep_razao","35","false","text","rep_razao","","","","","","",},
                            {"java.lang.String","cliente","22","false","text","cliente","","","","","","",},
                            {"java.lang.String","nome","35","false","text","nome","","","","","","",},
                            {"java.lang.String","tipo","3","false","text","tipo","","","","","","",},
                            {"java.lang.String","codigo_gerente","22","false","text","codigo_gerente","","","","","","",},
                            {"double","valor_pcp","22","false","text","valor_pcp","","##,##0.00","","","","",},
                            {"double","valor_deb","22","false","text","valor_deb","","##,##0.00","","","","",},
                            {"double","saldo","22","false","text","saldo","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 codigo_regional      ,'' nome_regional      ,0 numero      ,'' agencia      ,'' portador      ,'' cod_repres      ,'' rep_razao      ,0 cliente      ,'' nome      ,'' tipo      ,0 codigo_gerente      ,0 valor_pcp      ,0 valor_deb      ,0 saldo  FROM dual";
    return query;
  }

}
