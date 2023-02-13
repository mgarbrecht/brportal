package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cep_logradouro
  * @version 03/04/2013 09:50:07
  */
public class Jw_cep_logradouroMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","logradouro","60","false","text","logradouro","","","","","","",},
                            {"java.lang.String","cidade","60","false","text","cidade","","","","","","",},
                            {"java.lang.String","bairro","30","false","text","bairro","","","","","","",},
                            {"java.lang.String","cep","22","false","text","cep","","","","","","",},
                            {"java.lang.String","uf","2","false","text","uf","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT nome_log logradouro, local_log cidade, bairro_1_log bairro, cep_log cep, uf_log uf FROM cep_logradouros";
    return query;
  }

}
