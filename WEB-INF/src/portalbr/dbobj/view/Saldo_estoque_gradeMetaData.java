package portalbr.dbobj.view;

/** DataBase Object from table .Saldo_estoque_grade
  * @version 05/07/2010 06:58:46
  */
public class Saldo_estoque_gradeMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","unn_codigo","3","false","text","unn_codigo","","","","","","",},
                            {"java.lang.Integer","les_codigo","22","false","text","les_codigo","","","","","","",},
                            {"java.lang.String","les_descricao","40","false","text","les_descricao","","","","","","",},
                            {"java.lang.Integer","tes_codigo","22","false","text","tes_codigo","","","","","","",},
                            {"java.lang.String","tes_descricao","40","false","text","tes_descricao","","","","","","",},
                            {"java.lang.Integer","tco_codigo","22","false","text","tco_codigo","","","","","","",},
                            {"java.lang.String","tco_descricao","41","false","text","tco_descricao","","","","","","",},
                            {"java.lang.Integer","ies_codigo","22","false","text","ies_codigo","","","","","","",},
                            {"java.lang.String","ies_descricao","100","false","text","ies_descricao","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","60","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","tai_codigo","5","false","text","tai_codigo","","","","","","",},
                            {"java.lang.Integer","qtde_atual","27","false","text","qtde_atual","","","","","","",},
                            {"java.lang.Integer","gde_cdgo","22","false","text","gde_cdgo","","","","","","",},
                            {"java.lang.Integer","qtd_pars","22","false","text","qtd_pars","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select d.emp_empresa,  d.fil_filial,  d.unn_codigo,  d.les_codigo,  dle.descricao les_descricao,  d.tes_codigo,  dte.descricao tes_descricao,  d.tco_codigo,  dtc.descricao tco_descricao,  d.ies_codigo,  i.descricao ies_descricao,  d.cor_cdgo,  c.cor_desc,  d.tai_codigo,  d.qtde_atual,  d.gde_cdgo,  grade.qtd_pars from dom_local_item_estoque_gre d,  dom_local_estoque dle,  dom_tipo_estoque dte,  dom_tipo_comprometimento dtc,  dom_item_estoque i,  cor c, (  	select qtd_pars,  qtd.gde_cdgo,  qtd.qtd_nume 		from qtd 		where gde_cdgo>0 		and qtd_nume>0)grade where d.emp_empresa=nvl('01',d.emp_empresa) and d.fil_filial=nvl('12', d.fil_filial) and d.les_codigo=nvl(13, d.les_codigo) and d.tes_codigo=nvl(15, d.tes_codigo) and d.tco_codigo=nvl(null, d.tco_codigo) and d.ies_codigo=nvl(null, d.ies_codigo) and d.cor_cdgo=nvl(null, d.cor_cdgo) and d.ies_codigo=i.codigo and i.tipo='A' and d.qtde_atual> 0 and grade.gde_cdgo=d.gde_cdgo and grade.qtd_nume=d.tai_codigo and dle.codigo=d.les_codigo and dte.codigo=d.tes_codigo and dtc.codigo=d.tco_codigo and c.cor_cdgo=d.cor_cdgo and c.cor_cdgo>0";
    return query;
  }

}
