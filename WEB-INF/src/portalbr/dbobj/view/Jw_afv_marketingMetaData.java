package portalbr.dbobj.view;

/** DataBase Object from table .Jw_afv_marketing
  * @version 03/04/2013 09:51:48
  */
public class Jw_afv_marketingMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","CodMarketing","22","false","text","","","","","","","",},
                            {"int","CodTipoMarketing","22","false","text","","","","","","","",},
                            {"java.lang.String","Titulo","100","false","text","","","","","","","",},
                            {"java.lang.String","Descricao","4000","false","text","","","","","","","",},
                            {"java.lang.String","TipoArquivo","4","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT \"CodMarketing\", \"CodTipoMarketing\", \"Titulo\", \"Descricao\",\"TipoArquivo\" FROM afv_marketing@afvsql";
    return query;
  }

}
