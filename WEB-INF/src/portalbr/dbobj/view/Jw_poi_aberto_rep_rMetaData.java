package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_aberto_rep_r
  * @version 16/02/2017 13:11:53
  */
public class Jw_poi_aberto_rep_rMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","marca","71","false","text","marca","","","","","","",},
                            {"java.lang.String","unidade_negocio","3","false","text","unidade_negocio","","","","","","",},
                            {"double","media_dia","22","false","text","media_dia","","","","","","",},
                            {"double","media_rep","22","false","text","media_rep","","","","","","",},
                            {"double","preco_previsto","22","false","text","preco_previsto","","","","","","",},
                            {"double","preco_realizado","22","false","text","preco_realizado","","","","","","",},
                            {"double","dif_preco","22","false","text","dif_preco","","","","","","",},
                            {"double","reais_faturado","22","false","text","reais_faturado","","","","","","",},
                            {"double","reais_a_faturar","22","false","text","reais_a_faturar","","","","","","",},
                            {"double","reais_previsto","22","false","text","reais_previsto","","","","","","",},
                            {"double","reais_realizado","22","false","text","reais_realizado","","","","","","",},
                            {"double","dif_reais","22","false","text","dif_reais","","","","","","",},
                            {"double","pares_faturado","22","false","text","pares_faturado","","","","","","",},
                            {"double","pares_previsto","22","false","text","pares_previsto","","","","","","",},
                            {"double","pares_realizado","22","false","text","pares_realizado","","","","","","",},
                            {"double","pares_a_faturar","22","false","text","pares_a_faturar","","","","","","",},
                            {"double","dif_pares","22","false","text","dif_pares","","","","","","",},
                            {"double","prazo_medio","22","false","text","prazo_medio","","","","","","",},
                            {"double","reais_realizado_anterior","22","false","text","reais_realizado_anterior","","","","","","",},
                            {"int","pares_realizado_anterior","22","false","text","pares_realizado_anterior","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select t.codigo_representante, r.rep_rzao, mp.codigo_marca||'-'||mp.descricao_marca marca, t.unidade_negocio, decode(nvl(dias_uteis.dias,0),0,0, decode(sign(decode(nvl(dias_uteis.dias,0),0,0,((sum(t.total_pares_previsto))-(sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))))/nvl(dias_uteis.dias,0)),0,0,-1,0, decode(nvl(dias_uteis.dias,0),0,0,((sum(t.total_pares_previsto))-(sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))))/nvl(dias_uteis.dias,0)))media_dia, decode(nvl(dias_uteis.dias,0),0,0,(decode(sign(decode(sign(decode(nvl(dias_uteis.dias,0),0,0,((sum(t.total_pares_previsto))-(sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))))/nvl(dias_uteis.dias,0)),0,0,-1,0, decode(nvl(dias_uteis.dias,0),0,0,((sum(t.total_pares_previsto))-(sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))))/nvl(dias_uteis.dias,0))/count(*)),0,0,-1,0,(decode(sign(decode(nvl(dias_uteis.dias,0),0,0,((sum(t.total_pares_previsto))-(sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))))/nvl(dias_uteis.dias,0)),0,0,-1,0, decode(nvl(dias_uteis.dias,0),0,0,((sum(t.total_pares_previsto))-(sum(t.total_pares_faturado)+sum(t.total_pares_a_faturar)-sum(t.total_pares_atraso))))/nvl(dias_uteis.dias,0))/count(*)))))media_rep, sum(t.total_reais_previsto)/ decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto))preco_previsto,(sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar))/ decode((sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar)), 0, 1, sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar))preco_realizado, round(((sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar))/ decode(sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar), 0, 1, sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar))* 100)/(decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto))/ decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto)))- 100)dif_preco, sum(t.total_reais_faturado)reais_faturado, sum(t.total_reais_a_faturar)reais_a_faturar, sum(t.total_reais_previsto)reais_previsto, sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)reais_realizado,((sum(t.total_reais_faturado)+ sum(t.total_reais_a_faturar))* 100)/(decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto)))dif_reais, sum(t.total_pares_faturado)pares_faturado, sum(t.total_pares_previsto)pares_previsto, sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar)- sum(t.total_pares_atraso)pares_realizado, sum(t.total_pares_a_faturar)pares_a_faturar,((sum(t.total_pares_faturado)+ sum(t.total_pares_a_faturar))* 100)/ decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto))dif_pares, avg(prazo_medio)prazo_medio from brio.cotas_linhas_reais t, brio.marcas_produtos mp, brio.rep,(Select count(*)dias, unidade_negocio unidade_negocio, mes_fechamento_tonel from calendarios_semanal, data_fechamento_toneis where cod_filial='MT' and data> sysdate - 1 and feriado='N' and data <=data_cadastro group by unidade_negocio, mes_fechamento_tonel)dias_uteis, rep r where t.codigo_linha=999 and t.emp_empresa='01' and rep.rep_cdgo=t.codigo_representante and t.codigo_gerente=nvl(782, t.codigo_gerente)and t.mes_venda_reais=2 and t.ano_venda_reais=2006 and t.unidade_negocio=nvl(null, t.unidade_negocio)and rep.rep_cdgo=nvl(null,rep.rep_cdgo)and t.unidade_negocio> 0 and t.codigo_marca=mp.codigo_marca and t.unidade_negocio=dias_uteis.unidade_negocio(+)and t.mes_venda_reais=dias_uteis.mes_fechamento_tonel(+)and r.rep_cdgo=t.codigo_representante group by t.unidade_negocio, t.codigo_marca, mp.codigo_marca, mp.descricao_marca ,dias_uteis.dias ,t.codigo_representante, r.rep_rzao";
    return query;
  }

}
