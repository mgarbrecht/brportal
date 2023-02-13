package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld
  * @version 05/07/2010 07:07:55
  */
public class Jw_titulos_cldMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_reg","22","false","text","codigo_reg","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","codigo_analista","22","false","text","codigo_analista","","","","","","",},
                            {"java.lang.String","nome_analista","40","false","text","nome_analista","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","titulo","8","false","text","titulo","","","","","","",},
                            {"java.sql.Timestamp","data_venc","22","false","text","data_venc","","","","","","",},
                            {"java.sql.Timestamp","data_emissao","22","false","text","data_emissao","","","","","","",},
                            {"double","valor_cld","22","false","text","valor_cld","","","","","","",},
                            {"double","vlpcp","22","false","text","vlpcp","","","","","","",},
                            {"double","vldeb","22","false","text","vldeb","","","","","","",},
                            {"double","saldo","22","false","text","saldo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select DISTINCT ger.codigo_regional codigo_reg, rv.nome_regional, rep_cdgo, rep.rep_rzao, ger.codigo_gerente codigo_analista, ger.nome_gerente nome_analista, c.cli_cdgo, c.cli_rzao, tit.tit_codigo titulo, 	tit.tit_datvenc data_venc, tit.tit_datemi data_emissao, 	sum(tit.tit_valor)valor_cld, 	sum(nvl(tit.tit_vlpcp,0))vlpcp, 	sum(nvl(tit.tit_vldeb,0))vldeb, 	(sum(tit.tit_valor)- 	(sum(nvl(tit.tit_vlpcp,0))+ sum(nvl(tit.tit_vldeb,0))))saldo from titulos tit, rep rep, gerentes_regionais_vendas ger, cli c, regionais_vendas rv where tit.tip_codigo='NTC' AND rv.codigo_regional=ger.codigo_regional and trunc(tit.tit_datemi)between to_date('01/01/1990','dd/mm/yyyy')and to_date('30/05/2006','dd/mm/yyyy')and nvl(tit.tit_status,'X')='A' and tit.rep_codigo=rep.rep_cdgo and tit.cli_codigo=c.cli_cdgo and ger.codigo_gerente IN(Select DISTINCT ger.codigo_gerente	 codigo_ger from gerentes_regionais_vendas ger, regionais_vendas				 reg where ger.codigo_regional=nvl(1,ger.codigo_regional)and reg.codigo_regional=ger.codigo_regional)and rep.rep_gerente_antigo=ger.codigo_gerente and(tit.emp_empresa, tit.fil_filial, tit.tip_codigo , tit.tit_codigo)not in(select m.emp_empresa, m.fil_filial, m.tip_codigo , m.tit_codigo from mov_receber m where nvl(m.emp_empresa,null)	=nvl(tit.emp_empresa,null)and nvl(m.fil_filial,null)	=nvl(tit.fil_filial,null)and nvl(m.tip_codigo,null)	=nvl(tit.tip_codigo,null)and m.tit_codigo 	=nvl(tit.tit_codigo,null)and nvl(m.trn_codigo,null)	 in('DIS','TNC','CON','FAL','NEG','PNE')and trunc(mov_data)			 <=to_date('30/05/2006','dd/mm/yyyy')and nvl(m.mov_data,null)		 <=to_date('30/05/2006','dd/mm/yyyy')and nvl(m.mov_sequencia,0)	=0 and rownum=1)group by tit.tit_codigo,tit.tit_datvenc,tit.tit_datemi ,tit.tit_valor,tit.tit_vlpcp, tit.tit_vldeb,rep_cdgo, rep.rep_rzao,c.cli_cdgo,c.cli_rzao,ger.codigo_regional, ger.codigo_gerente, ger.nome_gerente, rv.nome_regional";
    return query;
  }

}
