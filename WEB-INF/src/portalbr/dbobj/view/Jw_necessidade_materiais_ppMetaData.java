package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_materiais_pp
  * @version 15/03/2019 15:00:55
  */
public class Jw_necessidade_materiais_ppMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","material","22","false","text","material","","","","","","",},
                            {"java.lang.String","descricao","32","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","cor","22","false","text","cor","","","","","","",},
                            {"java.lang.String","descricao_cor","32","false","text","descricao_cor","","","","","","",},
                            {"java.lang.Integer","tamanho","22","false","text","tamanho","","","","","","",},
                            {"java.lang.Integer","consumo","22","false","text","consumo","","","","","","",},
                            {"java.lang.String","unidade_medida","32","false","text","unidade_medida","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 material         ,'' descricao         ,0 cor         ,'' descricao_cor         ,0 tamanho         ,0 consumo         ,'' unidade_medida FROM DUAL";
    return query;
  }

}
