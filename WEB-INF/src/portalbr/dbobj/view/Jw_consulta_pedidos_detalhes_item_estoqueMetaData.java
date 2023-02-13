package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_detalhes_item_estoque
  * @version 03/04/2013 09:38:05
  */
public class Jw_consulta_pedidos_detalhes_item_estoqueMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_embalagem","22","false","text","codigo_embalagem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT d.codigo      , d.descricao      , f.lin_cdgo      , f.ref_cdgo      , f.codigo codigo_embalagem   FROM ficha_embalagem f      , dom_item_estoque d  WHERE f.mat_nro = d.codigo";
    return query;
  }

}
