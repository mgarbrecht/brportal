package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_filtro_estilos
  * @version 21/01/2019 15:10:03
  */
public class Jw_entrada_atual_pedidos_filtro_estilosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_tipo_estilos","22","false","text","id_tipo_estilos","","","","","","",},
                            {"java.lang.String","descricao_estilos","400","false","text","descricao_estilos","","","","","","",},
                            {"java.lang.Integer","total","22","false","text","total","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT id_tipo_estilos       ,descricao_estilos       ,SUM(NVL(entped_pg_pares, 0) + NVL(entped_pp_pares, 0) +            NVL(entped_rr_pares, 0)) total   FROM ubiratan.tmp_mapa_automatico_resumo a  WHERE NVL(entped_pg_pares, 0) + NVL(entped_pp_pares, 0) +        NVL(entped_rr_pares, 0) > 0  GROUP BY id_tipo_estilos          ,descricao_estilos  ORDER BY descricao_estilos";
    return query;
  }

}
