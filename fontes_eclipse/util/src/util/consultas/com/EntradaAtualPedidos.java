package util.consultas.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import portalbr.dbobj.view.Jw_giro_producao;

public class EntradaAtualPedidos {
	
	private List<GiroProducao> listaGiroProducao;
	
	public List<GiroProducao> getListaGiroProducao() {
		return listaGiroProducao;
	}

	public void setListaGiroProducao(List<GiroProducao> listaGiroProducao) {
		this.listaGiroProducao = listaGiroProducao;
	}

	public EntradaAtualPedidos() {
	}

	public EntradaAtualPedidos(List<GiroProducao> listaGiroProducao) {
		this.listaGiroProducao = listaGiroProducao;
	}
	


	public void gerarDados(com.egen.util.jdbc.JdbcUtil j, String periodo, HttpServletRequest req) {
		java.util.Vector<?> res_Jw_giro_producao = null;
		this.listaGiroProducao = new ArrayList<GiroProducao>();
		List<Datas> listaDatas = new ArrayList<Datas>();
		int meses = periodo!=null?(periodo.equalsIgnoreCase("atual")?0:-1):0;
		try {
			Jw_giro_producao table = new Jw_giro_producao();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT DISTINCT "); 
			sb.append("        qry.data ");
			sb.append("      , to_char(s.semana) semana ");
			sb.append("      , to_char(qry.data,'dd/mm/yyyy') data_descricao ");
			sb.append("      , to_char(qry.data,'dd/mon','nls_date_language=portuguese') data_abreviada ");     
			sb.append("      , filial ");
			sb.append("		 , sum(valor_corte) over(partition by qry.data,filial) valor_corte ");
			sb.append(" 	 , sum(valor_costura) over(partition by qry.data,filial) valor_costura ");
			sb.append(" 	 , sum(valor_atelier) over(partition by qry.data,filial) valor_atelier ");
			sb.append(" 	 , sum(valor_costura) over(partition by qry.data,filial) + sum(valor_atelier) over(partition by qry.data,filial) valor_total_costura ");
			sb.append("  	 , sum(valor_montagem) over(partition by qry.data,filial) valor_montagem ");
			sb.append("  	 , sum(valor_corte) over(partition by qry.data) valor_corte_dia ");
			sb.append(" 	 , sum(valor_costura) over(partition by qry.data) valor_costura_dia ");
			sb.append("	 	 , sum(valor_atelier) over(partition by qry.data) valor_atelier_dia ");
			sb.append("  	 , sum(valor_costura) over(partition by qry.data) + sum(valor_atelier) over(partition by qry.data) valor_total_costura_dia ");
			sb.append(" 	 , sum(valor_montagem) over(partition by qry.data) valor_montagem_dia ");
			sb.append(" 	 , sum(valor_corte) over() valor_corte_geral ");
			sb.append(" 	 , sum(valor_costura) over() valor_costura_geral ");
			sb.append(" 	 , sum(valor_atelier) over() valor_atelier_geral ");
			sb.append(" 	 , sum(valor_costura) over() + sum(valor_atelier) over() valor_total_costura_geral ");
			sb.append(" 	 , sum(valor_montagem) over() valor_montagem_geral ");
			sb.append("      , sum(valor_corte) over(partition by filial) valor_corte_filial ");
			sb.append("      , sum(valor_costura) over(partition by filial) valor_costura_filial ");
			sb.append("      , sum(valor_atelier) over(partition by filial) valor_atelier_filial ");
			sb.append("      , sum(valor_costura) over(partition by filial) + sum(valor_atelier) over(partition by filial) valor_total_costura_filial ");
			sb.append("      , sum(valor_montagem) over(partition by filial) valor_montagem_filial ");
		    sb.append("      , sum(valor_corte) over(partition by to_char(s.semana),filial) valor_corte_filial_semana ");
		    sb.append("      , sum(valor_costura) over(partition by to_char(s.semana),filial) valor_costura_filial_semana ");
		    sb.append("      , sum(valor_atelier) over(partition by to_char(s.semana),filial) valor_atelier_filial_semana ");
		    sb.append("      , sum(valor_costura) over(partition by to_char(s.semana),filial) + sum(valor_atelier) over(partition by to_char(s.semana),filial) valor_total_costura_filial_semana ");
		    sb.append("      , sum(valor_montagem) over(partition by to_char(s.semana),filial) valor_montagem_filial_semana ");
		    sb.append("      , sum(valor_corte) over(partition by to_char(s.semana)) valor_corte_filial_semana_geral ");
		    sb.append("      , sum(valor_costura) over(partition by to_char(s.semana)) valor_costura_filial_semana_geral ");
		    sb.append("      , sum(valor_atelier) over(partition by to_char(s.semana)) valor_atelier_filial_semana_geral ");
		    sb.append("      , sum(valor_costura) over(partition by to_char(s.semana)) + sum(valor_atelier) over(partition by to_char(s.semana)) valor_total_costura_filial_semana_geral ");
		    sb.append("      , sum(valor_montagem) over(partition by to_char(s.semana)) valor_montagem_filial_semana_geral ");		    
			sb.append(" 	 , dense_rank() over (order by qry.data) ordem "); 
			sb.append("   FROM ( SELECT DECODE(null, NULL, TRUNC(ap.app_data), TO_DATE(TO_CHAR(ap.dtrh_corrente, 'DD/MM/RR HH24'), 'DD/MM/RR HH24')) data "); 
			sb.append(" 		      , DECODE('S', 'S', tf.fil_filial, NULL) filial  ");
			sb.append(" 		                    , sum(DECODE(ap.set_cdgo, 'CORTE', ap.app_parbom, 0)) valor_corte  ");
			sb.append(" 		                    , sum(DECODE(ap.set_cdgo, 'COST', ap.app_parbom, 0)) valor_costura ");
			sb.append(" 		                    , sum(DECODE(ap.set_cdgo, 'ATEL.', ap.app_parbom, 0)) valor_atelier ");          
			sb.append(" 		                    , sum(DECODE(ap.set_cdgo, 'MONT', ap.app_parbom, 0)) valor_montagem ");                    
			sb.append(" 		                 FROM remessa    rem  ");
			sb.append(" 		                    , talao      tal  ");
			sb.append(" 		                    , apont_prod ap  ");
			sb.append(" 		                    , talao_fase tf  ");
			sb.append(" 		                WHERE rem.rem_nro = tal.rem_nro  ");
			sb.append(" 		                  AND tal.rem_nro = ap.rem_nro  ");
			sb.append(" 		                  AND tal.tal_nro = ap.tal_nro  ");
			sb.append(" 		                  AND ap.rem_nro = tf.rem_nro  ");
			sb.append(" 		                  AND ap.tal_nro = tf.tal_nro  ");
			sb.append(" 		                  AND ap.set_cdgo = tf.set_cdgo "); 
			sb.append(" 		                  AND rem.emp_empresa = NVL('01', rem.emp_empresa)  ");
			sb.append(" 		                  AND tf.fil_filial = NVL(null, tf.fil_filial)  ");
     	    sb.append(" 		                  AND ap.app_data BETWEEN trunc(add_months(sysdate,").append(meses).append("),'MM') AND last_day(add_months(sysdate,").append(meses).append("))  ");
			sb.append(" 		                  AND (null IS NULL OR TO_CHAR(ap.dtrh_corrente, 'hh24:mi') >= TO_CHAR(null, 'hh24:mi') AND TO_CHAR(ap.dtrh_corrente, 'hh24:mi') < TO_CHAR(null, 'hh24:mi')) ");
			
            sb.append(" GROUP BY DECODE(null, NULL, TRUNC(ap.app_data), TO_DATE(TO_CHAR(ap.dtrh_corrente, 'DD/MM/RR HH24'), 'DD/MM/RR HH24')) ");
            sb.append(" ,DECODE('S', 'S', tf.fil_filial, NULL) ");
			
			sb.append(" union ");
			sb.append(" select c.data ");
			sb.append(" ,f.fil_filial filial ");
			sb.append("  ,  0 valor_corte  ");
			sb.append(" , 0 valor_costura ");
			sb.append("  , 0 valor_atelier               ");
			sb.append("  , 0 valor_montagem                     ");
			sb.append(" from calendarios_semanal c, (select fil_filial from filial f where f.status = 'A' union select 'Geral' fil_filial from dual) f ");
			sb.append(" where cod_empresa = '01'  and cod_filial = '16' ");
      	    sb.append(" and data between trunc(add_months(sysdate,").append(meses).append("),'MM') and last_day(add_months(sysdate,").append(meses).append(")) ");
			sb.append(" 		) qry  ");
			sb.append("    , semanas s ");
			sb.append(" WHERE s.data = qry.data ");
			sb.append(" and (((valor_corte + valor_costura + valor_atelier +  valor_montagem) > 0) or filial = 'Geral') ");
			sb.append(" 		order by qry.data, filial ");		
			res_Jw_giro_producao = j.select(table, sb.toString(), null);

			int i_bl_report_Jw_giro_producao = 0;
			while (i_bl_report_Jw_giro_producao < res_Jw_giro_producao.size()) {
				Jw_giro_producao t_jw_giro_producao = (Jw_giro_producao) res_Jw_giro_producao.elementAt(i_bl_report_Jw_giro_producao);
			
				boolean contemData = false;
				for(Datas data : listaDatas) {
					if(data.getData().equalsIgnoreCase(t_jw_giro_producao.getData_abreviada())) {
						contemData = true;
						break;
					}
				}
				if(!contemData) {
					listaDatas.add(new Datas(t_jw_giro_producao.getOrdem(), t_jw_giro_producao.getData_abreviada(), t_jw_giro_producao.getSemana()));
				}
				
				boolean contem = false;
				for (GiroProducao giro : this.listaGiroProducao) {
					if (giro.getFilial().equalsIgnoreCase(t_jw_giro_producao.getFilial())
							&& giro.getData().equalsIgnoreCase(t_jw_giro_producao.getData_abreviada())) {
						giro.getDados().add(t_jw_giro_producao);
						contem = true;
						break;
					}
				}
				if (!contem) {
					List<Jw_giro_producao> listaJwGiroProducao = new ArrayList<Jw_giro_producao>();
					listaJwGiroProducao.add(t_jw_giro_producao);
					this.listaGiroProducao.add(new GiroProducao(t_jw_giro_producao.getFilial(), t_jw_giro_producao.getData_abreviada(), t_jw_giro_producao.getSemana(), listaJwGiroProducao));
				}
				i_bl_report_Jw_giro_producao++;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		req.getSession().setAttribute("EntradaAtualPedidosDatasGiroProducao", listaDatas);
	}
	
	
	public StringBuilder retornaQueryDadosGeral(String tipo, String regional, String representante, String analista, String data, String filtroSegmento) {
		StringBuilder sbGeral = new StringBuilder();
		try {
			String filtroSegmentoAno = filtroSegmento.replaceAll("ctl.", "");
			sbGeral.append(" SELECT * FROM ( ");
			sbGeral.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("              , TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("              , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("              , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("              , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("              , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("              , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("              , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("              , 'GERAL' tipo ");
			sbGeral.append("              , NULL codigo_gerente ");
			sbGeral.append("              , NULL codigo_regional ");
			sbGeral.append("              , '' rep_cdgo ");
			sbGeral.append("              , NULL rep_rzao ");
			sbGeral.append("              , NULL sigla_regional ");
			sbGeral.append("              , NULL codigo_marca ");
			sbGeral.append("              , NULL descricao_marca ");
			sbGeral.append("              , COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("              , 0 total_pares_ano ");
			sbGeral.append("              , 0.0 total_valor_ano ");
			sbGeral.append("              , 0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = (SELECT sem.data_mapa ");
			sbGeral.append("                                            FROM semanas sem ");
			sbGeral.append("                                           WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) - 1), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END) - 1) ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'GERAL' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,'' rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'MÊS' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'GERAL' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,'' rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
			sbGeral.append("                    NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo WHERE 1=1 "+filtroSegmentoAno+") total_pares_ano ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
			sbGeral.append("                    NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo WHERE 1=1 "+filtroSegmentoAno+") total_valor_ano ");
			sbGeral.append("               ,(SELECT COUNT(DISTINCT cli_cdgo) FROM tmp_mapa_automatico_resumo WHERE 1=1 "+filtroSegmentoAno+") clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'MÊS' ");
			sbGeral.append("  UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'SEMANA ATUAL' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'GERAL' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,'' rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
			sbGeral.append("                                                FROM semanas sem ");
			sbGeral.append("                                               WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("          GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'SEMANA ATUAL' ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REGIONAL' tipo ");
			sbGeral.append("               ,ger.codigo_gerente ");
			sbGeral.append("               ,ger.codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,pck_regionais_vendas.get_sigla(ger.codigo_regional) sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = (SELECT sem.data_mapa ");
			sbGeral.append("                                            FROM semanas sem ");
			sbGeral.append("                                           WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) - 1), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END) - 1) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY ger.codigo_gerente ");
			sbGeral.append("                  ,ger.codigo_regional ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REGIONAL' tipo ");
			sbGeral.append("               ,ger.codigo_gerente ");
			sbGeral.append("               ,ger.codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,pck_regionais_vendas.get_sigla(ger.codigo_regional) sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY ger.codigo_gerente ");
			sbGeral.append("                  ,ger.codigo_regional ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'MÊS' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REGIONAL' tipo ");
			sbGeral.append("               ,ger.codigo_gerente ");
			sbGeral.append("               ,ger.codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,pck_regionais_vendas.get_sigla(ger.codigo_regional) sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
			sbGeral.append("                    NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo where codigo_gerente = ger.codigo_gerente) total_pares_ano ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
			sbGeral.append("                    NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo where codigo_gerente = ger.codigo_gerente) total_valor_ano ");
			sbGeral.append("               ,(SELECT COUNT(DISTINCT cli_cdgo) FROM tmp_mapa_automatico_resumo where codigo_gerente = ger.codigo_gerente) clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY ger.codigo_gerente ");
			sbGeral.append("                  ,ger.codigo_regional ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'MÊS' ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'SEMANA ATUAL' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REGIONAL' tipo ");
			sbGeral.append("               ,ger.codigo_gerente ");
			sbGeral.append("               ,ger.codigo_regional ");
			sbGeral.append("               ,'' rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,pck_regionais_vendas.get_sigla(ger.codigo_regional) sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
			sbGeral.append("                                                FROM semanas sem ");
			sbGeral.append("                                               WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("          GROUP BY ger.codigo_gerente ");
			sbGeral.append("                  ,ger.codigo_regional ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'SEMANA ATUAL' ");
			sbGeral.append("          UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REPRESENTANTE' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,rep.rep_cdgo ");
			sbGeral.append("               ,rep.rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = (SELECT sem.data_mapa ");
			sbGeral.append("                                            FROM semanas sem ");
			sbGeral.append("                                           WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) - 1), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END) - 1) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY rep_cdgo ");
			sbGeral.append("                  ,rep_rzao ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REPRESENTANTE' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,rep.rep_cdgo ");
			sbGeral.append("               ,rep.rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marcamarca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY rep_cdgo ");
			sbGeral.append("                  ,rep_rzao ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'MÊS' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REPRESENTANTE' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,rep.rep_cdgo ");
			sbGeral.append("               ,rep.rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
			sbGeral.append("                    NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo where codigo_representante = rep.rep_cdgo "+filtroSegmentoAno+" ) total_pares_ano ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
			sbGeral.append("                    NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo  where codigo_representante = rep.rep_cdgo "+filtroSegmentoAno+") total_valor_ano ");
            sbGeral.append("              , (SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc where codigo_representante = rep.rep_cdgo UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE codigo_representante = rep.rep_cdgo)) clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");            
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY rep_cdgo ");
			sbGeral.append("                  ,rep_rzao ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'MÊS' ");
			sbGeral.append("          UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'SEMANA ATUAL' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'REPRESENTANTE' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,rep.rep_cdgo ");
			sbGeral.append("               ,rep.rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,NULL codigo_marca ");
			sbGeral.append("               ,NULL descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
			sbGeral.append("                                                FROM semanas sem ");
			sbGeral.append("                                               WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY rep_cdgo ");
			sbGeral.append("                  ,rep_rzao ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'SEMANA ATUAL' ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'MARCA' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,NULL rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,ctl.codigo_marca ");
			sbGeral.append("               ,pck_marcas_produtos.get_nome(ctl.codigo_marca) descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = (SELECT sem.data_mapa ");
			sbGeral.append("                                            FROM semanas sem ");
			sbGeral.append("                                           WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) - 1), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END) - 1) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY ctl.codigo_marca ");
			sbGeral.append("                  ,pck_marcas_produtos.get_nome(ctl.codigo_marca) ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,TO_CHAR(data, 'DD/MM/YYYY') datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'MARCA' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,NULL rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,ctl.codigo_marca ");
			sbGeral.append("               ,pck_marcas_produtos.get_nome(ctl.codigo_marca) descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND data = NVL((SELECT sem.data_mapa ");
			sbGeral.append("                             FROM semanas sem ");
			sbGeral.append("                            WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY ctl.codigo_marca ");
			sbGeral.append("                  ,pck_marcas_produtos.get_nome(ctl.codigo_marca) ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,TO_CHAR(data, 'DD/MM/YYYY') ");
			sbGeral.append("         UNION ");
			sbGeral.append("         SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'MÊS' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'MARCA' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,NULL rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,ctl.codigo_marca ");
			sbGeral.append("               ,pck_marcas_produtos.get_nome(ctl.codigo_marca) descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + ");
			sbGeral.append("                    NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo where codigo_marca = ctl.codigo_marca ) total_pares_ano ");
			sbGeral.append("               ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + ");
			sbGeral.append("                    NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo  where codigo_marca = ctl.codigo_marca) total_valor_ano ");
			sbGeral.append("               ,(SELECT COUNT(DISTINCT cli_cdgo) FROM tmp_mapa_automatico_resumo  where codigo_marca = ctl.codigo_marca) clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY ctl.codigo_marca ");
			sbGeral.append("                  ,pck_marcas_produtos.get_nome(ctl.codigo_marca) ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'MÊS' ");
			sbGeral.append(" UNION ");
			sbGeral.append("   SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
			sbGeral.append("               ,'SEMANA ATUAL' datam ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
			sbGeral.append("               ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
			sbGeral.append("               ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
			sbGeral.append("               ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
			sbGeral.append("               ,'MARCA' tipo ");
			sbGeral.append("               ,NULL codigo_gerente ");
			sbGeral.append("               ,NULL codigo_regional ");
			sbGeral.append("               ,NULL rep_cdgo ");
			sbGeral.append("               ,NULL rep_rzao ");
			sbGeral.append("               ,NULL sigla_regional ");
			sbGeral.append("               ,ctl.codigo_marca ");
			sbGeral.append("               ,pck_marcas_produtos.get_nome(ctl.codigo_marca) descricao_marca ");
			sbGeral.append("               ,COUNT(DISTINCT cli_cdgo) clientes ");
			sbGeral.append("               ,0 total_pares_ano ");
			sbGeral.append("               ,0.0 total_valor_ano ");
			sbGeral.append("               ,0 clientes_atendidos_ano ");
            sbGeral.append("              , count(distinct case when faltas not in (7, 17, 26) then ctl.cli_cdgo else null end) clientes_calcados ");
            sbGeral.append("              , count(distinct case when faltas in (7, 17) then ctl.cli_cdgo else null end) clientes_botas ");
            sbGeral.append("              , count(distinct case when faltas = 26 then ctl.cli_cdgo else null end) clientes_meias ");			
			sbGeral.append("           FROM tmp_mapa_automatico_resumo ctl ");
			sbGeral.append("               ,gerentes_regionais_vendas ger ");
			sbGeral.append("               ,regionais_vendas reg ");
			sbGeral.append("               ,rep rep ");
			sbGeral.append("          WHERE empresa = '01' ");
			sbGeral.append(filtroSegmento);
			sbGeral.append("            AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
			sbGeral.append("            AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
			sbGeral.append("                                                FROM semanas sem ");
			sbGeral.append("                                               WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<13) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
			sbGeral.append("            AND NVL(ctl.codigo_gerente, NULL) = ger.codigo_gerente ");
			sbGeral.append("            AND NVL(ger.codigo_regional, NULL) = reg.codigo_regional ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
			sbGeral.append("            AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
			sbGeral.append("            AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
			sbGeral.append("            AND NVL(rep.rep_situ, NULL) = 'A' ");
			sbGeral.append("            AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
			sbGeral.append("          GROUP BY ctl.codigo_marca ");
			sbGeral.append("                  ,pck_marcas_produtos.get_nome(ctl.codigo_marca) ");
			sbGeral.append("                  ,TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
			sbGeral.append("                  ,'SEMANA ATUAL' ");
			sbGeral.append(" ) ");
			sbGeral.append(" WHERE 1=1 ");
			if (tipo != null) {
				sbGeral.append(" AND tipo = '").append(tipo).append("' ");
			}
			if (regional != null) {
				sbGeral.append(" AND codigo_regional = ").append(regional);
			}
			if (representante != null) {
				sbGeral.append(" AND rep_cdgo = '").append(representante).append("' ");
			}
			// if(representante != null) {
			// sbGeral.append(" AND rep_cdgo =
			// '").append(representante).append("' ");
			// }
			if (data != null) {
				sbGeral.append(" AND datam = '").append(data).append("' ");
			}
		} catch (Exception e) {
			
		}
		return sbGeral;
	}
	
	
	public int getValorCorteBySemanaFilial(String semana, String filial) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana) && giro.getFilial().equalsIgnoreCase(filial)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_corte_filial_semana() > 0) {
						return jwGiro.getValor_corte_filial_semana();
					}
				}
			}
		}
		return 0;
	}
	
	public int getValorCosturaBySemanaFilial(String semana, String filial) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana) && giro.getFilial().equalsIgnoreCase(filial)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_costura_filial_semana() > 0) {
						return jwGiro.getValor_costura_filial_semana();
					}
				}
			}
		}
		return 0;		
	}

	public int getValorAtelierBySemanaFilial(String semana, String filial) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana) && giro.getFilial().equalsIgnoreCase(filial)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_atelier_filial_semana() > 0) {
						return jwGiro.getValor_atelier_filial_semana();
					}
				}
			}
		}
		return 0;	
	}
	
	public int getValorTotalCosturaBySemanaFilial(String semana, String filial) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana) && giro.getFilial().equalsIgnoreCase(filial)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_total_costura_filial_semana() > 0) {
						return jwGiro.getValor_total_costura_filial_semana();
					}
				}
			}
		}
		return 0;
	}

	public int getValorMontagemBySemanaFilial(String semana, String filial) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana) && giro.getFilial().equalsIgnoreCase(filial)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_montagem_filial_semana() > 0) {
						return jwGiro.getValor_montagem_filial_semana();
					}
				}
			} 
		}
		return 0;
	}
	

	public int getValorCorteBySemana(String semana) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_corte_filial_semana_geral() > 0) {
						return jwGiro.getValor_corte_filial_semana_geral();
					}
				}
			}
		}
		return 0;
	}
	
	public int getValorCosturaBySemana(String semana) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_costura_filial_semana_geral() > 0) {
						return jwGiro.getValor_costura_filial_semana_geral();
					}
				}
			}
		}
		return 0;		
	}

	public int getValorAtelierBySemana(String semana) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_atelier_filial_semana_geral() > 0) {
						return jwGiro.getValor_atelier_filial_semana_geral();
					}
				}
			}
		}
		return 0;	
	}
	
	public int getValorTotalCosturaBySemana(String semana) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_total_costura_filial_semana_geral() > 0) {
						return jwGiro.getValor_total_costura_filial_semana_geral();
					}
				}
			}
		}
		return 0;
	}

	public int getValorMontagemBySemana(String semana) {
		for (GiroProducao giro : this.listaGiroProducao) {
			if (giro.getSemana().equalsIgnoreCase(semana)) {
				for (Jw_giro_producao jwGiro : giro.getDados()) {
					if (jwGiro.getValor_montagem_filial_semana_geral() > 0) {
						return jwGiro.getValor_montagem_filial_semana_geral();
					}
				}
			} 
		}
		return 0;
	}
	
	
	public class Datas {
		
		private int ordem;
		private String data;
		private String semana;

		public Datas(int ordem) {
		}

		public Datas(int ordem, String data, String semana) {
			super();
			this.ordem = ordem;
			this.data = data;
			this.semana = semana;
		}

		public int getOrdem() {
			return ordem;
		}

		public void setOrdem(int ordem) {
			this.ordem = ordem;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getSemana() {
			return semana;
		}

		public void setSemana(String semana) {
			this.semana = semana;
		}

	}

	public class GiroProducao {

		private String filial;
		private String data;
		private String semana;
		private List<Jw_giro_producao> dados;

		public GiroProducao() {
		}

		public GiroProducao(String filial, String data, String semana) {
			this.filial = filial;
			this.data = data;
			this.semana = semana;
		}

		public GiroProducao(String filial, String data, String semana, List<Jw_giro_producao> dados) {
			super();
			this.filial = filial;
			this.data = data;
			this.semana = semana;
			this.dados = dados;
		}
		
	
		
		public String getFilial() {
			return filial;
		}

		public void setFilial(String filial) {
			this.filial = filial;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getSemana() {
			return semana;
		}

		public void setSemana(String semana) {
			this.semana = semana;
		}

		public List<Jw_giro_producao> getDados() {
			return dados;
		}

		public void setDados(List<Jw_giro_producao> dados) {
			this.dados = dados;
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((filial == null) ? 0 : filial.hashCode());
			return result;
		}
		

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final GiroProducao other = (GiroProducao) obj;
			if (!Objects.equals(this.filial, other.filial)) {
				return false;
			}
			return true;
		}

		private EntradaAtualPedidos getOuterType() {
			return EntradaAtualPedidos.this;
		}

	}
}
