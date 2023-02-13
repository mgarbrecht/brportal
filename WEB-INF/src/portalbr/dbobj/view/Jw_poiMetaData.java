package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi
  * @version 03/04/2013 09:18:13
  */
public class Jw_poiMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
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
    String query = "select r.codigo_regional, r.nome_regional, gr.codigo_gerente, gr.nome_gerente, gr.endereco_gerente||', '||gr.numero_gerente endereco, gr.estado_gerente, t.unidade_negocio, u.unn_descri from cotas_linhas_reais t, regionais_vendas r, gerentes_regionais_vendas gr, uni_negocio u where t.codigo_linha=999 and t.emp_empresa='01' and t.codigo_gerente=nvl(null,t.codigo_gerente)and r.codigo_regional=2 and t.codigo_representante=nvl(null,t.codigo_representante)and t.mes_venda_reais=2 and t.ano_venda_reais=2006 and t.unidade_negocio=1 	and t.codigo_marca=1 and gr.codigo_regional=r.codigo_regional and gr.codigo_gerente=t.codigo_gerente and u.unn_codigo=t.unidade_negocio group by t.unidade_negocio, r.codigo_regional, r.nome_regional, gr.codigo_gerente, gr.nome_gerente, gr.endereco_gerente, gr.numero_gerente, r.ender_regional, gr.estado_gerente, u.unn_descri";
    return query;
  }

}
