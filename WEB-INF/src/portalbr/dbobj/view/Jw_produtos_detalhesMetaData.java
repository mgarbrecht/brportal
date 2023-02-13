package portalbr.dbobj.view;

/** DataBase Object from table .Jw_produtos_detalhes
  * @version 03/04/2013 09:15:28
  */
public class Jw_produtos_detalhesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","ref_desc","25","false","text","ref_desc","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","2","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","35","false","text","cab_desc","","","","","","",},
                            {"java.lang.String","preco","43","false","text","preco","","","","","","",},
                            {"java.lang.Integer","codigo_grupo","22","false","text","codigo_grupo","","","","","","",},
                            {"java.lang.String","descricao_grupo","30","false","text","descricao_grupo","","","","","","",},
                            {"java.lang.String","imagem","11","false","text","imagem","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","60","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","tai_codigo","5","false","text","tai_codigo","","","","","","",},
                            {"double","qtde_atual","27","false","text","qtde_atual","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT die.lin_cdgo,  lin_nome,  die.ref_cdgo,  ref.ref_desc,  die.cab_cdgo,  cab.cab_desc,  nvl(tabela.preco,'0.00')preco,   gpf.codigo_grupo,  gpf.descricao_grupo,  lpad(substr(dlie.ies_codigo, 1, 3),3,'0')||'-'||lpad(substr(dlie.ies_codigo, 4, 3),3,'0')||'.gif' imagem,  mar.codigo_marca,  mar.descricao_marca,  dlie.cor_cdgo,  cor.cor_desc,  dlie.tai_codigo,  dlie.qtde_atual  FROM ref,  cor,  cabedal cab,   lin,  grupo_posicao_fabrica gpf,   marcas_produtos mar,   dom_local_item_estoque dlie,  dom_item_estoque die, (select substr(min(preco_mercado_interno)* 100,1,length(min(preco_mercado_interno)* 100)- 2)||'.'||  substr(min(preco_mercado_interno)* 100,length(min(preco_mercado_interno)* 100)- 1, 2)preco,   t.lin_cdgo,   t.ref_cdgo   FROM tabela_precos t   WHERE t.liv_codigo=28   GROUP BY t.lin_cdgo, t.ref_cdgo)tabela  WHERE mar.codigo_marca=ref.codigo_marca   AND gpf.codigo_grupo=ref.ref_grupo_posicao_fab   AND tabela.lin_cdgo(+)=substr(dlie.ies_codigo, 1, 3)  AND tabela.ref_cdgo(+)=substr(dlie.ies_codigo, 4, 3)  AND ref.lin_cdgo=substr(dlie.ies_codigo, 1, 3)  AND ref.ref_cdgo=substr(dlie.ies_codigo, 4, 3)  AND dlie.qtde_atual> 0   AND dlie.tes_codigo=49   AND les_codigo=32   AND die.lin_cdgo=substr(dlie.ies_codigo, 1, 3)  and die.ref_cdgo=substr(dlie.ies_codigo, 4, 3)  and die.cab_cdgo=substr(lpad(dlie.ies_codigo, 9, '0'), 7, 3)  and die.cab_cdgo=cab.cab_cdgo  and lin.lin_cdgo=die.lin_cdgo  and dlie.cor_cdgo=cor.cor_cdgo   AND tabela.lin_cdgo(+)=substr(dlie.ies_codigo, 1, 3)  AND tabela.ref_cdgo(+)=substr(dlie.ies_codigo, 4, 3) GROUP BY die.lin_cdgo,  lin_nome,  die.ref_cdgo,  die.cab_cdgo,  cab.cab_desc,  ref.ref_desc,   gpf.codigo_grupo,  gpf.descricao_grupo,   lpad(substr(dlie.ies_codigo, 1, 3),3,'0')||'-'||lpad(substr(dlie.ies_codigo, 4, 3),3,'0')||'.gif',  mar.codigo_marca,  mar.descricao_marca,   dlie.cor_cdgo,  cor.cor_desc,  dlie.tai_codigo,  dlie.qtde_atual,  tabela.preco  ORDER BY 2,14,15";
    return query;
  }

}
