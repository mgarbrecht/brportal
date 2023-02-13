package portalbr.dbobj.view;

/** DataBase Object from table .Jw_categorias
  * @version 03/04/2013 09:50:19
  */
public class Jw_categoriasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_grupo","22","false","text","codigo_grupo","","","","","","",},
                            {"java.lang.String","descricao","30","false","text","descricao","","","","","","",},
                            {"java.lang.Integer","numero","22","false","text","numero","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT gpf.codigo_grupo,gpf.descricao_grupo descricao , count(distinct lpad(substr(dlie.ies_codigo, 1, 3),3,'0')||lpad(substr(dlie.ies_codigo, 4, 3),3,'0'))numero FROM ref, grupo_posicao_fabrica gpf, marcas_produtos mar, dom_local_item_estoque dlie,(select t.lin_cdgo, t.ref_cdgo FROM tabela_precos t WHERE t.liv_codigo=28 GROUP BY t.lin_cdgo, t.ref_cdgo)tabela WHERE mar.codigo_marca=ref.codigo_marca AND gpf.codigo_grupo=ref.ref_grupo_posicao_fab AND tabela.lin_cdgo(+)=substr(dlie.ies_codigo, 1, 3)AND tabela.ref_cdgo(+)=substr(dlie.ies_codigo, 4, 3)AND ref.lin_cdgo=substr(dlie.ies_codigo, 1, 3)AND ref.ref_cdgo=substr(dlie.ies_codigo, 4, 3)AND dlie.qtde_atual> 0 AND dlie.tes_codigo=49 AND les_codigo=32 and gpf.codigo_grupo> 0 group by gpf.codigo_grupo,gpf.descricao_grupo order by 2";
    return query;
  }

}
