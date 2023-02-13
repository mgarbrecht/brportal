package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_marca
  * @version 03/04/2013 09:16:56
  */
public class Jw_poi_marcaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","codigo_marca","22","false","text","codigo_marca","","0","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"double","media_dia","22","false","text","media_dia","","","","","","",},
                            {"double","media_rep","22","false","text","media_rep","","","","","","",},
                            {"double","preco_previsto","22","false","text","preco_previsto","","","","","","",},
                            {"double","preco_realizado","22","false","text","preco_realizado","","","","","","",},
                            {"double","dif_preco","22","false","text","dif_preco","","","","","","",},
                            {"double","reais_previsto","22","false","text","reais_previsto","","","","","","",},
                            {"double","reais_realizado","22","false","text","reais_realizado","","","","","","",},
                            {"double","dif_reais","22","false","text","dif_reais","","","","","","",},
                            {"double","reais_faturado","22","false","text","reais_faturado","","","","","","",},
                            {"double","reais_a_faturar","22","false","text","reais_a_faturar","","","","","","",},
                            {"double","pares_previsto","22","false","text","pares_previsto","","","","","","",},
                            {"double","pares_faturado","22","false","text","pares_faturado","","","","","","",},
                            {"double","pares_a_faturar","22","false","text","pares_a_faturar","","","","","","",},
                            {"double","pares_realizado","22","false","text","pares_realizado","","","","","","",},
                            {"double","dif_pares","22","false","text","dif_pares","","","","","","",},
                            {"double","prazo_medio","22","false","text","prazo_medio","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select mp.codigo_marca,  mp.descricao_marca,  decode(nvl(dias_uteis.dias,0),0,0,  decode(sign(decode(nvl(dias_uteis.dias,0),0,0, ((sum(t.total_pares_previsto))- (sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))) )/nvl(dias_uteis.dias,0)),0,0,-1,0, decode(nvl(dias_uteis.dias,0),0,0, ((sum(t.total_pares_previsto))- (sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))) )/nvl(dias_uteis.dias,0)))media_dia,  decode(nvl(dias_uteis.dias,0),0,0, (decode(sign(decode(sign(decode(nvl(dias_uteis.dias,0),0,0, ((sum(t.total_pares_previsto))- (sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))) )/nvl(dias_uteis.dias,0)),0,0,-1,0, decode(nvl(dias_uteis.dias,0),0,0,  ((sum(t.total_pares_previsto))-  (sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))) )/nvl(dias_uteis.dias,0))/count(*)),0,0,-1,0, (decode(sign(decode(nvl(dias_uteis.dias,0),0,0, ((sum(t.total_pares_previsto))- (sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))) )/nvl(dias_uteis.dias,0)),0,0,-1,0, decode(nvl(dias_uteis.dias,0),0,0, ((sum(t.total_pares_previsto))- (sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))) )/nvl(dias_uteis.dias,0))/count(*)))))media_rep,  sum(t.total_reais_previsto)/  decode(sum(t.total_pares_previsto), 0, 1,  sum(t.total_pares_previsto))preco_previsto, (sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar))/  decode((sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar)), 0, 1,  sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar))preco_realizado,  round(((sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar))/  decode(sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar),  0, 1, sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar))* 100)/ (decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto))/  decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto)))- 100)dif_preco,  sum(t.total_reais_previsto)reais_previsto,  sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)reais_realizado, ((sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso))* 100)/ (decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto)))dif_reais,  sum(t.total_reais_faturado)reais_faturado,  sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)reais_a_faturar,  sum(t.total_pares_previsto)pares_previsto,  sum(t.total_pares_faturado)pares_faturado,  sum(t.total_pares_a_faturar)pares_a_faturar,  sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar)pares_realizado, ((sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar))* 100)/  decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto))dif_pares,  avg(prazo_medio)prazo_medio  from brio.cotas_linhas_reais t,  brio.marcas_produtos mp,  brio.rep, (Select count(*)dias,  unidade_negocio unidade_negocio,  mes_fechamento_tonel  from calendarios_semanal,  data_fechamento_toneis  where cod_filial='MT'  and data> sysdate - 1  and feriado='N'  and data <=data_cadastro  group by unidade_negocio, mes_fechamento_tonel )dias_uteis,  rep r,  regionais_vendas rv  where t.codigo_linha=999  and t.emp_empresa='01'  and rv.codigo_regional=r.codigo_regional  and rep.rep_cdgo=t.codigo_representante  and t.codigo_gerente=nvl(910, t.codigo_gerente)  and t.mes_venda_reais=8  and t.ano_venda_reais=2007  and t.unidade_negocio=nvl(null, t.unidade_negocio)  and t.unidade_negocio> 0  and t.codigo_marca=mp.codigo_marca  and t.unidade_negocio=dias_uteis.unidade_negocio(+)  and t.mes_venda_reais=dias_uteis.mes_fechamento_tonel(+)  and r.rep_cdgo=t.codigo_representante  group by mp.codigo_marca,  mp.descricao_marca,  dias_uteis.dias  order by mp.codigo_marca";
    return query;
  }

}
