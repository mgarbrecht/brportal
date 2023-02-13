package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_detalhes_peso_corrugados
  * @version 03/04/2013 09:33:41
  */
public class Jw_consulta_pedidos_detalhes_peso_corrugadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.Double","peso_corrug","25","false","text","peso_corrug","","##,##0.00","","","","",},
                            {"java.lang.Double","comprimento","26","false","text","comprimento","","##,##0.00","","","","",},
                            {"java.lang.Double","largura","26","false","text","largura","","##,##0.00","","","","",},
                            {"java.lang.Double","altura","26","false","text","altura","","##,##0.00","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.codigo      , c.descricao      , pc.peso_corrug      , pc.comprimento      , pc.largura      , pc.altura	  , pc.lin_cdgo	  , pc.ref_cdgo  FROM peso_corrugados pc     , corrugados c WHERE c.codigo = pc.codigo_corrug";
    return query;
  }

}
