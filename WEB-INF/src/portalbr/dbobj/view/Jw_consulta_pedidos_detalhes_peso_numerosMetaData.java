package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_detalhes_peso_numeros
  * @version 03/04/2013 09:33:30
  */
public class Jw_consulta_pedidos_detalhes_peso_numerosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.String","numero","5","false","text","numero","","","","","","",},
                            {"java.lang.Double","peso_embalagem","25","false","text","peso_embalagem","","##,##0.00","","","","",},
                            {"java.lang.Double","peso_sapato","25","false","text","peso_sapato","","##,##0.00","","","","",},
                            {"java.lang.Double","peso_adicional","25","false","text","peso_adicional","","##,##0.00","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_embalagem","22","false","text","codigo_embalagem","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT e.codigo      , e.descricao      , pn.numero      , pn.peso_embalagem      , pn.peso_sapato	  , pn.peso_adicional      , pn.lin_cdgo      , pn.ref_cdgo      , pn.codigo_embalagem   FROM peso_numeros pn      , embalagens e  WHERE e.codigo = pn.codigo_embalagem";
    return query;
  }

}
