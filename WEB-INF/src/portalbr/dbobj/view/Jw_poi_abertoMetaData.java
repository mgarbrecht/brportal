package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_aberto
  * @version 03/04/2013 09:18:03
  */
public class Jw_poi_abertoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","desc_marca","71","false","text","desc_marca","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.Integer","codigo_gerente","22","false","text","codigo_gerente","","","","","","",},
                            {"java.lang.String","nome_gerente","40","false","text","nome_gerente","","","","","","",},
                            {"java.lang.String","endereco","74","false","text","endereco","","","","","","",},
                            {"java.lang.String","estado_gerente","2","false","text","estado_gerente","","","","","","",},
                            {"java.lang.String","unidade_negocio","3","false","text","unidade_negocio","","","","","","",},
                            {"java.lang.String","unn_descri","50","false","text","unn_descri","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select t.codigo_marca||'-'||mp.descricao_marca desc_marca,r.codigo_regional, r.nome_regional, gr.codigo_gerente, gr.nome_gerente,   gr.endereco_gerente||', '||gr.numero_gerente endereco,   gr.estado_gerente, t.unidade_negocio, u.unn_descri   from cotas_linhas_reais t, regionais_vendas r,gerentes_regionais_vendas gr, uni_negocio u  , marcas_produtos mp   where t.codigo_linha=999   and t.emp_empresa='01'   and t.codigo_gerente=nvl(null,t.codigo_gerente)  and r.codigo_regional=nvl('01',r.codigo_regional)  and t.codigo_representante=nvl(null,t.codigo_representante)  and t.mes_venda_reais=2  and t.ano_venda_reais=2006  and t.unidade_negocio> 0   and t.unidade_negocio=nvl(null,t.unidade_negocio)  and t.codigo_marca> 0   and gr.codigo_regional=r.codigo_regional   and gr.codigo_gerente=t.codigo_gerente   and u.unn_codigo=t.unidade_negocio   and t.codigo_marca=mp.codigo_marca  group by t.unidade_negocio,   r.codigo_regional,   r.nome_regional,   gr.codigo_gerente,   gr.nome_gerente,   gr.endereco_gerente,   gr.numero_gerente,   r.ender_regional,   gr.estado_gerente,   u.unn_descri,  t.codigo_marca,  mp.descricao_marca";
    return query;
  }

}
