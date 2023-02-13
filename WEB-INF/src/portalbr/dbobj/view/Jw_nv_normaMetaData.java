package portalbr.dbobj.view;

/** DataBase Object from table .Jw_nv_norma
  * @version 03/04/2013 09:20:33
  */
public class Jw_nv_normaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_norma_venda","22","false","text","id_norma_venda","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","submarca_cdgo","200","false","text","submarca_cdgo","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","item_id","22","false","text","item_id","","","","","","",},
                            {"java.lang.String","desc_item","4000","false","text","desc_item","","","","","","",},
                            {"java.lang.Integer","id_material","22","false","text","id_material","","","","","","",},
                            {"java.lang.String","material","100","false","text","material","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT n.id_norma_venda      , n.codigo_marca      , pck_marcas_produtos.get_nome(n.codigo_marca) descricao_marca      , n.submarca_cdgo      , n.lin_cdgo      , i.item_id      , replace(i.descr_item,CHR(10),'<br>') desc_item      , m.id_material      , pck_cabedal.get_nome(m.id_material) || ' - ' || m.id_material material   FROM nv_norma_venda n      , nv_item_norma_venda i      , nv_materiais_norma_venda m	    WHERE n.id_norma_venda = i.id_norma_venda    AND m.id_norma_venda = i.id_norma_venda    AND m.item_id = i.item_id    ORDER BY n.id_norma_venda, i.item_id, id_material";
    return query;
  }

}
