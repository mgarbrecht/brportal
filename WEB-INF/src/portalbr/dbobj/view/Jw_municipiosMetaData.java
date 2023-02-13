package portalbr.dbobj.view;

/** DataBase Object from table .Jw_municipios
  * @version 18/11/2013 12:41:02
  */
public class Jw_municipiosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","Código","","","","","","",},
                            {"java.lang.String","est_unifed","2","false","text","UF","","","","","","",},
                            {"java.lang.String","descricao","60","false","text","Municipio","","","","","","",},
                            {"java.lang.String","codigo_ibge","10","false","text","Codigo_ibge","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo,est_unifed, descricao, codigo_ibge FROM municipios WHERE est_pais_codigo = 55 ORDER BY descricao";
    return query;
  }

}
