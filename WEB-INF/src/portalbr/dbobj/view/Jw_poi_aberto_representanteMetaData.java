package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_aberto_representante
  * @version 03/04/2013 09:17:22
  */
public class Jw_poi_aberto_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","desc_marca","71","false","text","desc_marca","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.Integer","codigo_gerente","22","false","text","codigo_gerente","","","","","","",},
                            {"java.lang.String","nome_gerente","40","false","text","nome_gerente","","","","","","",},
                            {"java.lang.String","endereco","74","false","text","endereco","","","","","","",},
                            {"java.lang.String","estado_gerente","2","false","text","estado_gerente","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select rep.rep_cdgo, rep.rep_rzao, t.codigo_marca||'-'||mp.descricao_marca desc_marca, r.codigo_regional, r.nome_regional, gr.codigo_gerente, gr.nome_gerente, gr.endereco_gerente||', '||gr.numero_gerente endereco, gr.estado_gerente from cotas_linhas_reais t, regionais_vendas r, gerentes_regionais_vendas gr, uni_negocio u, marcas_produtos mp, rep where t.codigo_linha=999 and t.emp_empresa='01' and t.codigo_gerente=nvl(null,t.codigo_gerente)and r.codigo_regional=nvl(6,r.codigo_regional)and t.mes_venda_reais=8 and t.ano_venda_reais=2007 and t.unidade_negocio> 0 and t.unidade_negocio=nvl(null,t.unidade_negocio)and t.codigo_marca> 0 and gr.codigo_regional=r.codigo_regional and gr.codigo_gerente=t.codigo_gerente and u.unn_codigo=t.unidade_negocio and t.codigo_marca=mp.codigo_marca and t.codigo_representante=rep.rep_cdgo and t.codigo_representante='271' group by rep.rep_cdgo, rep.rep_rzao, t.codigo_gerente, t.unidade_negocio, r.codigo_regional, r.nome_regional, gr.codigo_gerente, gr.nome_gerente, gr.endereco_gerente, gr.numero_gerente, r.ender_regional, gr.estado_gerente, t.codigo_marca, mp.descricao_marca order by r.codigo_regional, t.codigo_gerente, rep.rep_cdgo, t.codigo_marca, t.unidade_negocio";
    return query;
  }

}
