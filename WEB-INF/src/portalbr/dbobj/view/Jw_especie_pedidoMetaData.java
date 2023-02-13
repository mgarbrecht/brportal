package portalbr.dbobj.view;

/** DataBase Object from table .Jw_especie_pedido
  * @version 31/07/2013 11:59:56
  */
public class Jw_especie_pedidoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","10","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","240","false","text","descricao","","","","","","",},
                            {"int","ordem","10","false","text","ordem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.rv_abbreviation codigo       ,UPPER(c.rv_meaning) descricao       ,1 ordem   FROM cg_ref_codes c  WHERE c.rv_domain LIKE '%PED_ESPECIE_PEDIDO%' UNION SELECT 'AC'       ,'AMOSTRA DE CONFIRMAÇÃO'       ,2 ordem   FROM dual  ORDER BY 3          ,1";
    return query;
  }

}
