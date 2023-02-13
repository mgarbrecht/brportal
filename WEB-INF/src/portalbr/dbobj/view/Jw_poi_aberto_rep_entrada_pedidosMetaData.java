package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_aberto_rep_entrada_pedidos
  * @version 19/12/2022 14:50:22
  */
public class Jw_poi_aberto_rep_entrada_pedidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_regional","22","false","text","","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","","","","","","","",},
                            {"int","codigo_gerente","22","false","text","","","","","","","",},
                            {"java.lang.String","nome_gerente","40","false","text","","","","","","","",},
                            {"java.lang.String","endereco","200","false","text","","","","","","","",},
                            {"java.lang.String","estado_gerente","10","false","text","","","","","","","",},
                            {"int","codigo_marca","22","false","text","","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","","","","","","","",},
                            {"java.lang.String","codigo_representante","10","false","text","","","","","","","",},
                            {"java.lang.String","rep_rzao","40","false","text","","","","","","","",},
                            {"double","preco_previsto","22","false","text","","","","","","","",},
                            {"double","preco_realizado","22","false","text","","","","","","","",},
                            {"double","dif_preco","22","false","text","","","##,##0.00","","","","",},
                            {"double","reais_previsto","22","false","text","","","##,##0.00","","","","",},
                            {"double","reais_realizado","22","false","text","","","##,##0.00","","","","",},
                            {"double","dif_reais","22","false","text","","","##,##0.00","","","","",},
                            {"double","reais_faturado","22","false","text","","","##,##0.00","","","","",},
                            {"double","reais_a_faturar","22","false","text","","","##,##0.00","","","","",},
                            {"int","pares_previsto","22","false","text","","","","","","","",},
                            {"int","pares_realizado","22","false","text","","","","","","","",},
                            {"double","dif_pares","22","false","text","","","##,##0.00","","","","",},
                            {"int","pares_faturado","22","false","text","","","","","","","",},
                            {"int","pares_a_faturar","22","false","text","","","","","","","",},
                            {"double","reais_realizado_anterior","22","false","text","reais_realizado_anterior","","","","","","",},
                            {"int","pares_realizado_anterior","22","false","text","pares_realizado_anterior","","","","","","",},
                            {"java.lang.String","ref_grupo_posicao_fab_descricao","240","false","text","ref_grupo_posicao_fab_descricao","","","","","","",},
                            {"double","dif_pares_pos","22","false","text","dif_pares_pos","","##,##0.00","","","","",},
                            {"double","dif_reais_pos","22","false","text","dif_reais_pos","","##,##0.00","","","","",},
                            {"double","dif_preco_pos","22","false","text","dif_preco_pos","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT 0 codigo_regional       , '' nome_regional       , 0 codigo_gerente       , '' nome_gerente       , '' endereco       , '' estado_gerente       , 0 codigo_marca       , '' descricao_marca       , '' codigo_representante        , '' rep_rzao       , 0.0 preco_previsto        , 0.0 preco_realizado        , 0.0 dif_preco        , 0.0 reais_previsto       , 0.0 reais_realizado       , 0.0 dif_reais              , 0.0 reais_faturado        , 0.0 reais_a_faturar        , 0 pares_previsto        , 0 pares_realizado        , 0.0 dif_pares              , 0 pares_faturado        , 0 pares_a_faturar        , 0.0 reais_realizado	          , 0 pares_realizado        , '' ref_grupo_posicao_fab_descricao	       FROM dual";
    return query;
  }

}
