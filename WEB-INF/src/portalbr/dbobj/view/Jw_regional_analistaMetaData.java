package portalbr.dbobj.view;

/** DataBase Object from table .Jw_regional_analista
  * @version 03/04/2013 09:13:34
  */
public class Jw_regional_analistaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_gerente","5","false","text","codigo_gerente","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT r.rep_cdgo codigo_gerente, u.codigo_regional FROM gerentes_regionais_vendas u, rep r WHERE u.situacao_gerente='A' AND u.codigo_gerente <>1 AND r.rep_cdgo=u.codigo_gerente";
    return query;
  }

}
