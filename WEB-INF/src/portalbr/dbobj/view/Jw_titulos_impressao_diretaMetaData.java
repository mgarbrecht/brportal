package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_impressao_direta
  * @version 09/06/2015 08:24:56
  */
public class Jw_titulos_impressao_diretaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","tit_codigo","8","false","text","tit_codigo","","","","","","",},
                            {"java.lang.String","tip_codigo","3","false","text","tip_codigo","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","prt_codigo","","","","","","",},
                            {"java.lang.String","chave","100","false","text","chave","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT t.emp_empresa       ,t.fil_filial       ,t.tit_codigo       ,t.tip_codigo	   ,t.prt_codigo       ,md5(t.emp_empresa || t.fil_filial || t.tit_codigo || t.tip_codigo) chave   FROM titulos t";
    return query;
  }

}
