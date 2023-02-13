package portalbr.dbobj.view;

/** DataBase Object from table .Jw_relatorio_normas
  * @version 03/04/2013 09:13:23
  */
public class Jw_relatorio_normasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","4000","false","text","descricao_marca","","","","","","",},
                            {"int","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","4000","false","text","lin_nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT         nv.codigo_marca      , pck_marcas_produtos.get_nome(nv.codigo_marca) descricao_marca      , nv.lin_cdgo      , pck_linha.get_nome(nv.lin_cdgo) lin_nome   FROM nv_linha_materiais li      , nv_coluna_materiais col      , nv_item_norma_venda it      , nv_norma_venda nv      , nv_tipo_colunas nvtc  WHERE li.id_coluna_material = col.id_coluna_material    AND li.item_id = col.item_id    AND li.id_norma_venda = col.id_norma_venda    AND col.item_id = it.item_id    AND col.id_norma_venda = it.id_norma_venda    AND it.id_norma_venda = nv.id    AND nvtc.id = col.id_tipos_colunas  ORDER BY codigo_marca         , lin_cdgo";
    return query;
  }

}
