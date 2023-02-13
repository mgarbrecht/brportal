package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_tec_imagem
  * @version 03/04/2013 09:28:52
  */
public class Jw_ficha_tec_imagemMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"int","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","fit_imagem","400","false","text","fit_imagem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct lin_cdgo,ref_cdgo, fct_retorna_fit_imagem(lin_cdgo,ref_cdgo) fit_imagem from ficha_tec";
    return query;
  }

}
