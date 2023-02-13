package portalbr.dbobj.view;

/** DataBase Object from table .Jw_mix_materiais_dia
  * @version 01/11/2022 13:54:27
  */
public class Jw_mix_materiais_diaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_material","22","false","text","codigo_material","","","","","","",},
                            {"java.lang.String","descricao_material","240","false","text","descricao_material","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","240","false","text","descricao_marca","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT        ies_codigo codigo_material      , pck_item_estoque.get_nome(ies_codigo) descricao_material      , codigo_marca      , pck_marcas_produtos.get_nome(codigo_marca) descricao_marca   FROM mix_materiais_dia  WHERE data_posicao = trunc(sysdate) - 1 ORDER BY TRIM(descricao_material)";
    return query;
  }

}
