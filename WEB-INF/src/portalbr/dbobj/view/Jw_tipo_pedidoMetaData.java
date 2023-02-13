package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_pedido
  * @version 04/06/2019 08:18:56
  */
public class Jw_tipo_pedidoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","tipo_pedido","10","false","text","tipo_pedido","","","","","","",},
                            {"java.lang.String","descricao_tipo_pedido","240","false","text","descricao_tipo_pedido","","","","","","",},
                            {"int","ordem","10","false","text","ordem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 'PG' tipo_pedido       ,'Programada' descricao_tipo_pedido       ,1 ordem   FROM dual UNION SELECT 'PP' tipo_pedido       ,'Produto Pronto' descricao_tipo_pedido       ,2 ordem   FROM dual UNION SELECT 'EX' tipo_pedido       ,'Exportação' descricao_tipo_pedido       ,3 ordem   FROM dual  ORDER BY ordem";
    return query;
  }

}
