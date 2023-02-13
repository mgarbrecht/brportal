package portalbr.dbobj.view;

/** DataBase Object from table .Jw_gerente_ativo
  * @version 03/04/2013 09:27:54
  */
public class Jw_gerente_ativoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_gerente","22","false","text","codigo_gerente","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select codigo_gerente from gerentes_regionais_vendas grv where grv.codigo_regional=1  and grv.situacao_gerente='A'";
    return query;
  }

}
