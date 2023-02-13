package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grade_tipo_estoque
  * @version 22/06/2015 10:34:16
  */
public class Jw_saldo_estoque_grade_tipo_estoqueMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","200","false","text","descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo       ,descricao   FROM dom_tipo_estoque  WHERE codigo IN        (SELECT to_number(valor)           FROM wbrio.parametros          WHERE par_sist_codigo = 'BRNET'            AND nome = 'saldo_estoque_grade_tipo_estoque')			ORDER BY codigo";
    return query;
  }

}
