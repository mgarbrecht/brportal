package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_marcas
  * @version 03/04/2013 09:16:45
  */
public class Jw_poi_marcasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","descr_marca","22","false","text","descr_marca","","","","","","",},
                            {"java.lang.Integer","cod_marca","22","false","text","cod_marca","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct decode(m.codigo_marca,0,'POR UNIDADE DE NEGÓCIO',substr(m.descricao_marca,1,21))descr_marca, m.codigo_marca cod_marca from cotas_linhas_reais c, gerentes_regionais_vendas g, rep r, uni_negocio n, marcas_produtos m where c.mes_venda_reais=2 and c.ano_venda_reais=2006 and c.emp_empresa='01' and c.codigo_gerente=g.codigo_gerente and c.codigo_representante=r.rep_cdgo and c.unidade_negocio=n.unn_codigo and g.codigo_regional=nvl(2,g.codigo_regional)and r.rep_cdgo=nvl(null,r.rep_cdgo)and n.unn_codigo=nvl('01',r.rep_tipo_negocio)and c.codigo_marca=m.codigo_marca";
    return query;
  }

}
