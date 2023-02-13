package portalbr.dbobj.view;

/** DataBase Object from table .Jw_produtos
  * @version 03/04/2013 09:15:38
  */
public class Jw_produtosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","preco","43","false","text","preco","","","","","","",},
                            {"java.lang.String","ref_desc","25","false","text","ref_desc","","","","","","",},
                            {"java.lang.Integer","codigo_grupo","22","false","text","codigo_grupo","","","","","","",},
                            {"java.lang.String","descricao_grupo","30","false","text","descricao_grupo","","","","","","",},
                            {"java.lang.String","fit_imagem","300","false","text","fit_imagem","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ft.lin_cdgo, ft.ref_cdgo, nvl(tabela.preco, '0.00')preco, ref.ref_desc, gpf.codigo_grupo, gpf.descricao_grupo, ft.fit_imagem, mar.descricao_marca FROM ref, ficha_tec ft, grupo_posicao_fabrica gpf, marcas_produtos mar, dom_local_item_estoque dlie,(select substr(min(preco_mercado_interno)* 100, 1, length(min(preco_mercado_interno)* 100)- 2)||'.'||substr(min(preco_mercado_interno)* 100, length(min(preco_mercado_interno)* 100)- 1, 2)preco, t.lin_cdgo, t.ref_cdgo FROM tabela_precos t WHERE t.liv_codigo=28 GROUP BY t.lin_cdgo, t.ref_cdgo)tabela WHERE mar.codigo_marca=ref.codigo_marca AND gpf.codigo_grupo=ref.ref_grupo_posicao_fab AND tabela.lin_cdgo(+)=substr(dlie.ies_codigo, 1, 3)AND tabela.ref_cdgo(+)=substr(dlie.ies_codigo, 4, 3)AND ref.lin_cdgo=substr(dlie.ies_codigo, 1, 3)AND ref.ref_cdgo=substr(dlie.ies_codigo, 4, 3)AND dlie.qtde_atual> 0 AND dlie.tes_codigo=49 AND les_codigo=32 and ft.lin_cdgo=lpad(substr(dlie.ies_codigo, 1, 3), 3, '0')and ft.ref_cdgo=lpad(substr(dlie.ies_codigo, 4, 3), 3, '0')GROUP BY ft.lin_cdgo, ft.ref_cdgo, ref.ref_desc, gpf.codigo_grupo, gpf.descricao_grupo, ft.fit_imagem, mar.descricao_marca, tabela.preco ORDER BY ft.lin_cdgo, ft.ref_cdgo";
    return query;
  }

}
