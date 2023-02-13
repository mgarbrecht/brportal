package util.consultas.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.servlet.http.HttpServletRequest;
import portalbr.com.AcompanhamentoDiarioVendasActionForm;
import portalbr.dbobj.view.Jw_acompanhamento_diario_vendas;
import portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_marcas;
import portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais;

public class AcompanhamentoDiarioVendas {

	private AcompanhamentoDiarioVendasActionForm f;
	private HttpServletRequest request;
	private List<Acompanhamento> listaAcompanhamentos;
	private List<ClientesAtendidos> listaClientesAtendidos;
	private CountDownLatch executionCompleted;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CountDownLatch getExecutionCompleted() {
		return executionCompleted;
	}

	public void setExecutionCompleted(CountDownLatch executionCompleted) {
		this.executionCompleted = executionCompleted;
	}

	public List<Acompanhamento> getListaAcompanhamentos() {
		return listaAcompanhamentos;
	}

	public void setListaAcompanhamentos(List<Acompanhamento> listaAcompanhamentos) {
		this.listaAcompanhamentos = listaAcompanhamentos;
	}

	public List<ClientesAtendidos> getListaClientesAtendidos() {
		return listaClientesAtendidos;
	}

	public void setListaClientesAtendidos(List<ClientesAtendidos> listaClientesAtendidos) {
		this.listaClientesAtendidos = listaClientesAtendidos;
	}

	public AcompanhamentoDiarioVendas() {
	}

	public AcompanhamentoDiarioVendas(HttpServletRequest req, AcompanhamentoDiarioVendasActionForm f) {
		this.request = req;
		this.f = f;
	}

	public void processar() {
		this.executionCompleted = new CountDownLatch(2);
		try {
			ConsultaGeralThread consultaGeralThread = new ConsultaGeralThread();
			consultaGeralThread.start();
			ConsultaClientesAtendidosThread consultaClientesAtendidosThread = new ConsultaClientesAtendidosThread();
			consultaClientesAtendidosThread.start();
			this.executionCompleted.await();
			processarRegistros();
		} catch (InterruptedException e) {
			e.printStackTrace(System.err);
		}
	}

	public String diferencaParesAno(Double previsto, Double realizado) {
		double total = 0d;
		try {
			if (realizado == 0) {
				realizado = 1.0;
			}
			if (previsto == 0) {
				previsto = realizado;
			}
			total = (realizado * 100) / previsto;
		} catch (Exception e) {
		}
		String resultado = com.egen.util.text.FormatNumber.format(total, "##,##0.00");
		return resultado;
	}

	public String diferencaParesAno(int prev, int realiz) {
		double realizado = 0d;
		double previsto = 0d;
		double total = 0d;
		try {
			realizado = Double.parseDouble(realiz + "");
			previsto = Double.parseDouble(prev + "");
			if (realizado == 0) {
				realizado = 1.0;
			}
			if (previsto == 0) {
				previsto = realizado;
			}
			total = (realizado * 100) / previsto;
		} catch (Exception e) {
		}
		String resultado = com.egen.util.text.FormatNumber.format(total, "##,##0.00");
		return resultado;
	}

	public String diferencaReaisAno(Double previsto, Double realizado) {
		double total = 0d;
		try {
			if (realizado == 0) {
				realizado = 1.0;
			}
			if (previsto == 0) {
				previsto = realizado;
			}
			total = (realizado * 100) / previsto;
		} catch (Exception e) {
		}
		String resultado = com.egen.util.text.FormatNumber.format(total, "##,##0.00");
		return resultado;
	}

	public String diferencaReaisAno(int prev, int realiz) {
		double realizado = 0d;
		double previsto = 0d;
		double total = 0d;
		try {
			realizado = Double.parseDouble(realiz + "");
			previsto = Double.parseDouble(prev + "");
			if (realizado == 0) {
				realizado = 1.0;
			}
			if (previsto == 0) {
				previsto = realizado;
			}
			total = (realizado * 100) / previsto;
		} catch (Exception e) {
		}
		String resultado = com.egen.util.text.FormatNumber.format(total, "##,##0.00");
		return resultado;
	}

	public String diferencaAnoAtualAnterior(Double atual, Double anterior) {
		double total = 0d;
		try {
			if (anterior.doubleValue() == 0 && atual.doubleValue() == 0) {
				total = 0d;
			} else if (anterior.doubleValue() == 0 && atual.doubleValue() > 0) {
				total = 100d;
			} else {
				total = (atual / anterior * 100) - 100;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		String resultado = com.egen.util.text.FormatNumber.format(total, "##,##0.00");
		return resultado;
	}

	public String diferencaAnoAtualAnterior(int atual, int anterior) {
		double total = 0d;
		try {
			if (anterior == 0 && atual == 0) {
				total = 0d;
			} else if (anterior == 0 && atual > 0) {
				total = 100d;
			} else {
				total = (Double.parseDouble(atual + "") / Double.parseDouble(anterior + "") * 100) - 100;
			}
		} catch (Exception e) {
		}
		String resultado = com.egen.util.text.FormatNumber.format(total, "##,##0.00");
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void consultar() {
		
		String codigoMarca = "null";
		String codigoRegional = "null";
		String repCdgo = "null";
		StringBuilder sbr1 = new StringBuilder();
		StringBuilder sbr2 = new StringBuilder();		
		
		if (f.getCodigo_marca() != "") {
			codigoMarca = f.getCodigo_marca();
		}
		if (f.getCodigo_regional() != "") {
			codigoRegional = f.getCodigo_regional();
		}
		if (f.getRep_cdgo() != "") {
			repCdgo = f.getRep_cdgo();
		}
		
		if(!f.getSituacao_representantes().equalsIgnoreCase("T")){
		     sbr1.append(" AND EXISTS (SELECT 1 ");
		     sbr1.append("               FROM representante_marca rm ");
		     sbr1.append("              WHERE rm.codigo_representante = rep.rep_cdgo ");
		     sbr1.append("                AND rm.marca_produto = clre.codigo_marca ");
		     sbr1.append("                AND rm.situacao = '"+f.getSituacao_representantes()+"') ");
		     sbr2.append(" AND EXISTS (SELECT 1 "); 
		     sbr2.append("               FROM representante_marca rm ");
		     sbr2.append("              WHERE rm.codigo_representante = rep.rep_cdgo ");
		     sbr2.append("                AND rm.marca_produto = tmdap.codigo_marca ");
		     sbr2.append("                AND rm.situacao = '"+f.getSituacao_representantes()+"') ");
		  }

		this.listaAcompanhamentos = new ArrayList();
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT '"+f.getData_inicial()+" a "+f.getData_final()+"' periodo ");
			sb.append("      , '"+f.getData_anterior_inicial()+" a "+f.getData_anterior_final()+"' periodo_ano_anterior ");			
			sb.append("      , codigo_regional ");
			sb.append("      , nome_regional ");
			sb.append("      , codigo_marca ");
			sb.append("      , descricao_marca ");
			sb.append("      , rep_cdgo ");
			sb.append("      , rep_rzao ");
			sb.append("      , pares_previsto_ano ");
			sb.append("      , pares_realizado_ano ");
			sb.append("      , reais_previsto_ano ");
			sb.append("      , reais_realizado_ano ");
			sb.append("      , pares_realizado_ant ");
			sb.append("      , reais_realizado_ant ");
			sb.append("      , cli_atend_ano ");
			sb.append("      , cli_atend_ant ");
			sb.append("      , dif_cli_atend ");
			sb.append("      , cli_atend_regional_ano ");
			sb.append("      , cli_atend_regional_ant ");
			sb.append("      , dif_cli_regional_atend ");
			sb.append("      , valor_meta ");
			sb.append("      , valor_ano_ant ");
			sb.append("      , ROUND(((pares_realizado_ano) * 100) / DECODE((pares_previsto_ano), 0, DECODE(pares_realizado_ano, 0, 1, pares_realizado_ano), (pares_previsto_ano)), 2) dif_pares_ano ");
			sb.append("      , ROUND(((reais_realizado_ano) * 100) / DECODE((reais_previsto_ano), 0, DECODE(reais_realizado_ano, 0, 1, reais_realizado_ano), (reais_previsto_ano)), 2) dif_reais_ano ");
			sb.append("      , ROUND(CASE WHEN pares_realizado_ano = 0 AND pares_realizado_ant = 0 THEN 0 WHEN pares_realizado_ant = 0 AND pares_realizado_ano > 0 THEN 100 ELSE (pares_realizado_ano / pares_realizado_ant * 100) - 100 END, 2) dif_pares_realizado ");
			sb.append("      , ROUND(CASE WHEN reais_realizado_ano = 0 AND reais_realizado_ant = 0 THEN 0 WHEN reais_realizado_ant = 0 AND reais_realizado_ano > 0 THEN 100 ELSE (reais_realizado_ano / reais_realizado_ant * 100) - 100 END, 2) dif_reais_realizado ");
			sb.append("      , ROUND(CASE WHEN cli_atend_ant = 0 AND cli_atend_ano = 0 THEN 0 WHEN cli_atend_ant = 0 AND cli_atend_ano > 0 THEN 100 ELSE (cli_atend_ano / cli_atend_ant * 100) - 100 END, 2) dif_clientes_atendidos ");
			sb.append("   FROM (SELECT qry.codigo_regional ");
			sb.append("              , reg.nome_regional ");
			sb.append("              , qry.codigo_marca ");
			sb.append("              , mar.descricao_marca ");
			sb.append("              , qry.rep_cdgo ");
			sb.append("              , qry.rep_rzao ");
			sb.append("              , ROUND(SUM(qry.pares_previsto_ano), 2) pares_previsto_ano ");
			sb.append("              , SUM(qry.pares_realizado_ano) pares_realizado_ano ");
			sb.append("              , ROUND(SUM(qry.reais_previsto_ano), 2) reais_previsto_ano ");
			sb.append("              , SUM(qry.reais_realizado_ano) reais_realizado_ano ");
			sb.append("              , SUM(qry.pares_realizado_ant) pares_realizado_ant ");
			sb.append("              , SUM(qry.reais_realizado_ant) reais_realizado_ant ");
			sb.append("              , SUM(DISTINCT cli_atend_ano) cli_atend_ano ");
			sb.append("              , SUM(DISTINCT cli_atend_ant) cli_atend_ant ");
			sb.append("              , SUM(DISTINCT cli_atend_ano) - SUM(DISTINCT cli_atend_ant) dif_cli_atend ");
			sb.append("              , 0 cli_atend_regional_ano ");
			sb.append("              , 0 cli_atend_regional_ant ");
			sb.append("              , 0 dif_cli_regional_atend ");
			sb.append("                , (SUM(ROUND(((qry.reais_previsto_ano / (last_day(to_date('"+f.getData_final()+"', 'dd/mm/yyyy')) - (last_day(add_months(to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy'), -1)) + 1))) * DECODE((to_date('"+f.getData_final()+"', 'dd/mm/yyyy') - to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy')), 0, 1, (to_date('"+f.getData_final()+"', 'dd/mm/yyyy') - to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy')))), 2))) - SUM(qry.reais_realizado_ano) valor_meta ");
			sb.append("              , (SUM(qry.reais_realizado_ano) - SUM(qry.reais_realizado_ant)) valor_ano_ant ");
			sb.append("           FROM (SELECT TO_DATE(clre.mes_venda_reais || '/' || clre.ano_venda_reais, 'MM/YYYY') periodo ");
			sb.append("                      , clre.codigo_marca ");
			sb.append("                      , rep.codigo_regional codigo_regional ");
			sb.append("                      , clre.codigo_representante rep_cdgo ");
			sb.append("                      , rep.rep_rzao ");
			sb.append("                      , clre.total_pares_previsto pares_previsto_ano ");
			sb.append("                      , 0 pares_realizado_ano ");
			sb.append("                      , 0 pares_realizado_ant ");
			sb.append("                      , clre.total_reais_previsto reais_previsto_ano ");
			sb.append("                      , 0 reais_realizado_ano ");
			sb.append("                      , 0 reais_realizado_ant ");
			sb.append("                      , 0 cli_atend_ano ");
			sb.append("                      , 0 cli_atend_ant ");
			sb.append("                   FROM cotas_linhas_reais_entrada clre ");
			sb.append("                      , rep ");
			sb.append("                  WHERE to_date(clre.mes_venda_reais || '/' || clre.ano_venda_reais, 'MM/YYYY') BETWEEN ");
			sb.append("                        TRUNC(to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy'), 'MM') AND TRUNC(to_date('"+f.getData_final()+"', 'dd/mm/yyyy'), 'MM') ");
			sb.append(sbr1.toString());
			sb.append("                    AND clre.codigo_marca = NVL(").append(codigoMarca).append(", clre.codigo_marca) ");
			sb.append("                    AND clre.codigo_representante = NVL("+repCdgo+", clre.codigo_representante) ");
			sb.append("                    AND rep.rep_cdgo = clre.codigo_representante ");
			sb.append("                    AND rep.codigo_regional = NVL("+codigoRegional+", rep.codigo_regional) ");
			sb.append("                  UNION ALL ");
			sb.append("                 SELECT tgt.periodo ");
			sb.append("                      , tgt.codigo_marca ");
			sb.append("                      , tgt.codigo_regional ");
			sb.append("                      , tgt.rep_cdgo ");
			sb.append("                      , tgt.rep_rzao ");
			sb.append("                      , 0 total_pares_previsto_ano ");
			sb.append("                      , SUM(CASE ");
			sb.append("                              WHEN (tgt.periodo >= ");
			sb.append("                                   TRUNC(to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy'), 'mm')) THEN ");
			sb.append("                               tgt.pares_realizados ");
			sb.append("                              ELSE ");
			sb.append("                               0 ");
			sb.append("                            END) pares_realizado_ano ");
			sb.append("                      , SUM(CASE ");
			sb.append("                              WHEN (tgt.periodo <= ");
			sb.append("                                   last_day(to_date('"+f.getData_anterior_final()+"', 'dd/mm/yyyy'))) THEN ");
			sb.append("                               tgt.pares_realizados ");
			sb.append("                              ELSE ");
			sb.append("                               0 ");
			sb.append("                            END) pares_realizado_ant ");
			sb.append("                      , 0 reais_previsto_ano ");
			sb.append("                      , SUM(CASE ");
			sb.append("                              WHEN (tgt.periodo >= ");
			sb.append("                                   TRUNC(to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy'), 'mm')) THEN ");
			sb.append("                               tgt.reais_realizados ");
			sb.append("                              ELSE ");
			sb.append("                               0 ");
			sb.append("                            END) reais_realizado_ano ");
			sb.append("                      , SUM(CASE ");
			sb.append("                              WHEN (tgt.periodo <= ");
			sb.append("                                   last_day(to_date('"+f.getData_anterior_final()+"', 'dd/mm/yyyy'))) THEN ");
			sb.append("                               tgt.reais_realizados ");
			sb.append("                              ELSE ");
			sb.append("                               0 ");
			sb.append("                            END) reais_realizado_ant ");
			sb.append("                      , COUNT(DISTINCT cli_atend_ano) OVER(PARTITION BY tgt.codigo_marca, tgt.codigo_regional, tgt.rep_cdgo, tgt.rep_rzao) cli_atend_ano ");
			sb.append("                      , COUNT(DISTINCT cli_atend_ant) OVER(PARTITION BY tgt.codigo_marca, tgt.codigo_regional, tgt.rep_cdgo, tgt.rep_rzao) cli_atend_ant ");
			sb.append("                   FROM (SELECT TRUNC(tmdap.data, 'MM') periodo ");
			sb.append("                              , tmdap.codigo_marca ");
			sb.append("                              , rep.codigo_regional codigo_regional ");
			sb.append("                              , TO_CHAR(tmdap.codigo_representante) rep_cdgo ");
			sb.append("                              , rep.rep_rzao ");
			sb.append("                              , (NVL(tmdap.entped_pp_pares, 0) + NVL(tmdap.entped_pg_pares, 0) + NVL(tmdap.entped_rr_pares, 0)) pares_realizados ");
			sb.append("                              , (NVL(tmdap.entped_pp_vlr, 0) + NVL(tmdap.entped_pg_vlr, 0) + NVL(tmdap.entped_rr_vlr, 0)) reais_realizados ");
			sb.append("                              , CASE ");
			sb.append("                                  WHEN tmdap.data BETWEEN ");
			sb.append("                                       to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy') AND ");
			sb.append("                                       to_date('"+f.getData_final()+"', 'dd/mm/yyyy') AND ");
			sb.append("                                       NVL(tmdap.cli_cdgo, 0) <> 0 AND ");
			sb.append("                                       (TRUNC(tmdap.data, 'MM') < ");
			sb.append("                                       TO_DATE('092009', 'MMYYYY') OR ");
			sb.append("                                       NVL(tmdap.entped_pp_pares, 0) + ");
			sb.append("                                       NVL(tmdap.entped_pg_pares, 0) + ");
			sb.append("                                       NVL(tmdap.entped_rr_pares, 0) > 0) THEN ");
			sb.append("                                   tmdap.cli_cdgo ");
			sb.append("                                  ELSE ");
			sb.append("                                   NULL ");
			sb.append("                                END cli_atend_ano ");
			sb.append("                              , CASE ");
			sb.append("                                  WHEN tmdap.data BETWEEN ");
			sb.append("                                       to_date('"+f.getData_anterior_inicial()+"', 'dd/mm/yyyy') AND ");
			sb.append("                                       to_date('"+f.getData_anterior_final()+"', 'dd/mm/yyyy') AND ");
			sb.append("                                       NVL(tmdap.cli_cdgo, 0) <> 0 AND ");
			sb.append("                                       (TRUNC(tmdap.data, 'MM') < ");
			sb.append("                                       TO_DATE('092009', 'MMYYYY') OR ");
			sb.append("                                       NVL(tmdap.entped_pp_pares, 0) + ");
			sb.append("                                       NVL(tmdap.entped_pg_pares, 0) + ");
			sb.append("                                       NVL(tmdap.entped_rr_pares, 0) > 0) THEN ");
			sb.append("                                   tmdap.cli_cdgo ");
			sb.append("                                  ELSE ");
			sb.append("                                   NULL ");
			sb.append("                                END cli_atend_ant ");
			sb.append("                          FROM (SELECT tmdap.* ");
			sb.append("                                  FROM tmp_mapa_diario_automatico_poi tmdap ");
			sb.append("                                 WHERE tmdap.data BETWEEN ");
			sb.append("                                       to_date('"+f.getData_anterior_inicial()+"', 'dd/mm/yyyy') AND ");
			sb.append("                                       to_date('"+f.getData_anterior_final()+"', 'dd/mm/yyyy') ");
			sb.append("                                 UNION ALL ");
			sb.append("                                SELECT tmdap.* ");
			sb.append("                                  FROM tmp_mapa_diario_automatico_poi tmdap ");
			sb.append("                                 WHERE tmdap.data BETWEEN ");
			sb.append("                                        to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy') AND ");
			sb.append("                                        to_date('"+f.getData_final()+"', 'dd/mm/yyyy')) tmdap ");
			sb.append("                               ,rep ");
			sb.append("                          WHERE NVL(tmdap.filial, NULL) IN ('10', '30', 'MT', '3', '9', '12', '16', '6', '8', '17', '18', '23', '11') ");
			sb.append("                            AND tmdap.codigo_representante =  NVL("+repCdgo+", tmdap.codigo_representante) ");
			sb.append("                            AND tmdap.codigo_marca =  NVL("+codigoMarca+", tmdap.codigo_marca) ");
			sb.append("                            AND rep.rep_cdgo =  TO_CHAR(tmdap.codigo_representante) ");
			sb.append(sbr2.toString());
			sb.append("                            AND rep.codigo_regional = NVL("+codigoRegional+", rep.codigo_regional) ");
			sb.append("                            ) tgt ");
			sb.append("                  GROUP BY tgt.periodo ");
			sb.append("                         , tgt.codigo_marca ");
			sb.append("                         , tgt.codigo_regional ");
			sb.append("                         , tgt.rep_cdgo ");
			sb.append("                         , tgt.rep_rzao ");
			sb.append("                         , cli_atend_ano ");
			sb.append("                         , cli_atend_ant) qry ");
			sb.append("              , marcas_produtos mar ");
			sb.append("              , regionais_vendas reg ");
			
			if((f.getCb_somente_marcas_ativas()+"").equalsIgnoreCase("S")){
				  sb.append("        , representante_marca rm ");
			}			
			
			sb.append("          WHERE qry.codigo_marca = mar.codigo_marca ");
			sb.append("            AND qry.codigo_regional = reg.codigo_regional ");
			

			if((f.getCb_somente_marcas_ativas()+"").equalsIgnoreCase("S")){
			  sb.append("  AND rm.codigo_representante  = qry.rep_cdgo ");
			  sb.append("  AND rm.situacao = 'A' ");
			  sb.append("  AND rm.marca_produto = mar.codigo_marca ");
			}			
			
			sb.append("          GROUP BY TO_CHAR(qry.codigo_regional) || ' - ' || reg.nome_regional ");
			sb.append("                 , qry.codigo_marca ");
			sb.append("                 , mar.descricao_marca ");
			sb.append("                 , qry.rep_cdgo ");
			sb.append("                 , qry.rep_rzao ");
			sb.append("                 , qry.codigo_regional ");
			sb.append("                 , reg.nome_regional ");
			sb.append("          ORDER BY codigo_regional ");
			sb.append("                 , codigo_marca) ");

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();

			while (rset.next()) {
				Dados dados = new Dados();
				dados.setParesPrevistoAno(rset.getInt("pares_previsto_ano"));
				dados.setParesRealizadoAno(rset.getInt("pares_realizado_ano"));
				dados.setReaisPrevistoAno(rset.getDouble("reais_previsto_ano"));
				dados.setReaisRealizadoAno(rset.getDouble("reais_realizado_ano"));
				dados.setParesRealizadoAnt(rset.getInt("pares_realizado_ant"));
				dados.setReaisRealizadoAnt(rset.getDouble("reais_realizado_ant"));
				dados.setCliAtendAno(rset.getInt("cli_atend_ano"));
				dados.setCliAtendAnt(rset.getInt("cli_atend_ant"));
				dados.setDifCliAtend(rset.getInt("dif_cli_atend"));
				dados.setCliAtendRegionalAno(rset.getInt("cli_atend_regional_ano"));
				dados.setCliAtendRegionalAnt(rset.getInt("cli_atend_regional_ant"));
				dados.setDifCliRegionalAtend(rset.getDouble("dif_cli_regional_atend"));
				dados.setValorMeta(rset.getDouble("valor_meta"));
				dados.setValorAnoAnt(rset.getDouble("valor_ano_ant"));
				dados.setDifParesAno(rset.getDouble("dif_pares_ano"));
				dados.setDifReaisAno(rset.getDouble("dif_reais_ano"));
				dados.setDifParesRealizado(rset.getDouble("dif_pares_realizado"));
				dados.setDifReaisRealizado(rset.getDouble("dif_reais_realizado"));
				dados.setDifClientesAtendidos(rset.getDouble("dif_clientes_atendidos"));
				Acompanhamento acompanhamento = new Acompanhamento();
				acompanhamento.setPeriodo(rset.getString("periodo"));
				acompanhamento.setPeriodoAnoAnterior(rset.getString("periodo_ano_anterior"));
				acompanhamento.setCodigoRegional(rset.getInt("codigo_regional"));
				acompanhamento.setNomeRegional(rset.getString("nome_regional"));
				acompanhamento.setCodigoMarca(rset.getInt("codigo_marca"));
				acompanhamento.setDescricaoMarca(rset.getString("descricao_marca"));
				acompanhamento.setRepCdgo(rset.getString("rep_cdgo"));
				acompanhamento.setRepRzao(rset.getString("rep_rzao"));
				if (!this.listaAcompanhamentos.contains(acompanhamento)) {
					acompanhamento.setListaDados(new ArrayList<Dados>());
					acompanhamento.getListaDados().add(dados);
					this.listaAcompanhamentos.add(acompanhamento);
				} else {
					this.listaAcompanhamentos.add(acompanhamento);
				}
			} 
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
			}
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
			}
			if (j != null) {
				j.close();
			}
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void consultarClientes() {
		
		String codigoMarca = "null";
		String codigoRegional = "null";
		String repCdgo = "null";
		
		if (f.getCodigo_marca() != "") {
			codigoMarca = f.getCodigo_marca();
		}
		if (f.getCodigo_regional() != "") {
			codigoRegional = f.getCodigo_regional();
		}
		if (f.getRep_cdgo() != "") {
			repCdgo = f.getRep_cdgo();
		}

		this.listaClientesAtendidos = new ArrayList();
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT DISTINCT cli_cdgo ");
			sb.append("               , codigo_marca ");
			sb.append("               , r.codigo_regional ");
			sb.append("               , rep_cdgo ");
			sb.append("               , 'ANTERIOR' periodo ");
			sb.append("   FROM tmp_mapa_diario_automatico_poi tmdap ");
			sb.append("      , rep                            r ");
			sb.append("  WHERE tmdap.data BETWEEN to_date('"+f.getData_anterior_inicial()+"', 'dd/mm/yyyy') AND to_date('"+f.getData_anterior_final()+"', 'dd/mm/yyyy') ");
			sb.append("    AND tmdap.cli_cdgo IS NOT NULL ");
			sb.append("    AND r.codigo_regional = nvl("+codigoRegional+", r.codigo_regional) ");
			sb.append("    AND tmdap.codigo_marca = nvl("+codigoMarca+", tmdap.codigo_marca) ");
			sb.append("    AND tmdap.codigo_representante = nvl("+repCdgo+", tmdap.codigo_representante) ");
			sb.append("    AND r.rep_cdgo = to_char(tmdap.codigo_representante) ");
			sb.append("    AND NVL(tmdap.filial, NULL) IN ('10', '30', 'MT', '3', '9', '12', '16', '6', '8', '17', '18', '23', '11') ");
			sb.append("    AND NVL(tmdap.cli_cdgo, 0) <> 0 ");
			sb.append("    AND (TRUNC(tmdap.data, 'MM') < TO_DATE('092009', 'MMYYYY') OR NVL(tmdap.entped_pp_pares, 0) + NVL(tmdap.entped_pg_pares, 0) + NVL(tmdap.entped_rr_pares, 0) > 0) ");
			if(!f.getSituacao_representantes().equalsIgnoreCase("T")){ 
			   sb.append(" AND EXISTS (SELECT 1 ");
			   sb.append("               FROM representante_marca rm ");
		       sb.append("              WHERE rm.codigo_representante = r.rep_cdgo ");
			   sb.append("                AND rm.marca_produto = tmdap.codigo_marca ");
			   sb.append("                AND rm.situacao = '"+f.getSituacao_representantes()+"') ");    
			}			
			sb.append("  UNION ");
			sb.append(" SELECT DISTINCT cli_cdgo ");
			sb.append("               , codigo_marca ");
			sb.append("               , r.codigo_regional ");
			sb.append("               , rep_cdgo ");
			sb.append(" 	          , 'ATUAL' periodo ");
			sb.append("   FROM tmp_mapa_diario_automatico_poi tmdap ");
			sb.append("      , rep                            r ");
			sb.append("  WHERE tmdap.data BETWEEN to_date('"+f.getData_inicial()+"', 'dd/mm/yyyy') AND to_date('"+f.getData_final()+"', 'dd/mm/yyyy') ");
			sb.append("    AND tmdap.cli_cdgo IS NOT NULL ");
			sb.append("    AND r.codigo_regional = nvl("+codigoRegional+", r.codigo_regional) ");
			sb.append("    AND tmdap.codigo_marca = nvl("+codigoMarca+", tmdap.codigo_marca) ");
			sb.append("    AND tmdap.codigo_representante = nvl("+repCdgo+", tmdap.codigo_representante) ");
			sb.append("    AND r.rep_cdgo = to_char(tmdap.codigo_representante) ");
			sb.append("    AND NVL(tmdap.filial, NULL) IN ('10', '30', 'MT', '3', '9', '12', '16', '6', '8', '17', '18', '23', '11') ");
			sb.append("    AND NVL(tmdap.cli_cdgo, 0) <> 0 ");
			if(!f.getSituacao_representantes().equalsIgnoreCase("T")){ 
			   sb.append(" AND EXISTS (SELECT 1 ");
			   sb.append("               FROM representante_marca rm ");
			   sb.append("              WHERE rm.codigo_representante = r.rep_cdgo ");
			   sb.append("                AND rm.marca_produto = tmdap.codigo_marca ");
			   sb.append("                AND rm.situacao = '"+f.getSituacao_representantes()+"') ");    
			}			
			sb.append("    AND (TRUNC(tmdap.data, 'MM') < TO_DATE('092009', 'MMYYYY') OR NVL(tmdap.entped_pp_pares, 0) + NVL(tmdap.entped_pg_pares, 0) + NVL(tmdap.entped_rr_pares, 0) > 0) ");

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				ClientesAtendidos clientesAtendidos = new ClientesAtendidos();
				clientesAtendidos.setCliCdgo(rset.getInt("cli_cdgo"));
				clientesAtendidos.setCodigoMarca(rset.getInt("codigo_marca"));
				clientesAtendidos.setCodigoRegional(rset.getInt("codigo_regional"));
				clientesAtendidos.setRepCdgo(rset.getString("rep_cdgo"));
				clientesAtendidos.setPeriodo(rset.getString("periodo"));
				this.listaClientesAtendidos.add(clientesAtendidos);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
			}
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
			}
			if (j != null) {
				j.close();
			}
		}
	}

	public class ClientesAtendidos {
		private int cliCdgo;
		private int codigoMarca;
		private int codigoRegional;
		private String repCdgo;
		private String periodo;

		public int getCliCdgo() {
			return cliCdgo;
		}

		public void setCliCdgo(int cliCdgo) {
			this.cliCdgo = cliCdgo;
		}

		public int getCodigoMarca() {
			return codigoMarca;
		}

		public void setCodigoMarca(int codigoMarca) {
			this.codigoMarca = codigoMarca;
		}

		public int getCodigoRegional() {
			return codigoRegional;
		}

		public void setCodigoRegional(int codigoRegional) {
			this.codigoRegional = codigoRegional;
		}

		public String getRepCdgo() {
			return repCdgo;
		}

		public void setRepCdgo(String repCdgo) {
			this.repCdgo = repCdgo;
		}

		public String getPeriodo() {
			return periodo;
		}

		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + cliCdgo;
			result = prime * result + codigoMarca;
			result = prime * result + codigoRegional;
			result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
			result = prime * result + ((repCdgo == null) ? 0 : repCdgo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ClientesAtendidos other = (ClientesAtendidos) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (cliCdgo != other.cliCdgo)
				return false;
			if (codigoMarca != other.codigoMarca)
				return false;
			if (codigoRegional != other.codigoRegional)
				return false;
			if (periodo == null) {
				if (other.periodo != null)
					return false;
			} else if (!periodo.equals(other.periodo))
				return false;
			if (repCdgo == null) {
				if (other.repCdgo != null)
					return false;
			} else if (!repCdgo.equals(other.repCdgo))
				return false;
			return true;
		}

		private AcompanhamentoDiarioVendas getOuterType() {
			return AcompanhamentoDiarioVendas.this;
		}

	}

	public class Acompanhamento {
		private String periodo;
		private String periodoAnoAnterior;
		private Integer codigoRegional;
		private String nomeRegional;
		private Integer codigoMarca;
		private String descricaoMarca;
		private String repCdgo;
		private String repRzao;
		private List<Dados> listaDados;
		
		public String getPeriodo() {
			return periodo;
		}

		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}

		public String getPeriodoAnoAnterior() {
			return periodoAnoAnterior;
		}

		public void setPeriodoAnoAnterior(String periodoAnoAnterior) {
			this.periodoAnoAnterior = periodoAnoAnterior;
		}

		public Integer getCodigoRegional() {
			return codigoRegional;
		}

		public void setCodigoRegional(Integer codigoRegional) {
			this.codigoRegional = codigoRegional;
		}

		public String getNomeRegional() {
			return nomeRegional;
		}

		public void setNomeRegional(String nomeRegional) {
			this.nomeRegional = nomeRegional;
		}

		public Integer getCodigoMarca() {
			return codigoMarca;
		}

		public void setCodigoMarca(Integer codigoMarca) {
			this.codigoMarca = codigoMarca;
		}

		public String getDescricaoMarca() {
			return descricaoMarca;
		}

		public void setDescricaoMarca(String descricaoMarca) {
			this.descricaoMarca = descricaoMarca;
		}

		public String getRepCdgo() {
			return repCdgo;
		}

		public void setRepCdgo(String repCdgo) {
			this.repCdgo = repCdgo;
		}

		public String getRepRzao() {
			return repRzao;
		}

		public void setRepRzao(String repRzao) {
			this.repRzao = repRzao;
		}

		public List<Dados> getListaDados() {
			return listaDados;
		}

		public void setListaDados(List<Dados> listaDados) {
			this.listaDados = listaDados;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((codigoMarca == null) ? 0 : codigoMarca.hashCode());
			result = prime * result + ((codigoRegional == null) ? 0 : codigoRegional.hashCode());
			result = prime * result + ((repCdgo == null) ? 0 : repCdgo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Acompanhamento other = (Acompanhamento) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (codigoMarca == null) {
				if (other.codigoMarca != null)
					return false;
			} else if (!codigoMarca.equals(other.codigoMarca))
				return false;
			if (codigoRegional == null) {
				if (other.codigoRegional != null)
					return false;
			} else if (!codigoRegional.equals(other.codigoRegional))
				return false;
			if (repCdgo == null) {
				if (other.repCdgo != null)
					return false;
			} else if (!repCdgo.equals(other.repCdgo))
				return false;
			return true;
		}

		private AcompanhamentoDiarioVendas getOuterType() {
			return AcompanhamentoDiarioVendas.this;
		}

	}

	public class AcompanhamentoDiarioVendasTotalGeral {

		private List<Integer> listaCliAtendRegionalAno;
		private List<Integer> listaCliAtendRegionalAnt;

		public List<Integer> getListaCliAtendRegionalAno() {
			return listaCliAtendRegionalAno;
		}

		public void setListaCliAtendRegionalAno(List<Integer> listaCliAtendRegionalAno) {
			this.listaCliAtendRegionalAno = listaCliAtendRegionalAno;
		}

		public List<Integer> getListaCliAtendRegionalAnt() {
			return listaCliAtendRegionalAnt;
		}

		public void setListaCliAtendRegionalAnt(List<Integer> listaCliAtendRegionalAnt) {
			this.listaCliAtendRegionalAnt = listaCliAtendRegionalAnt;
		}
	}
	
	public class AcompanhamentoDiarioVendasTotalRegionalMarca {

		private int codigoRegional;
		private int codigoMarca;
		private List<Integer> listaCliAtendRegionalAno;
		private List<Integer> listaCliAtendRegionalAnt;
		
		
		public int getCodigoRegional() {
			return codigoRegional;
		}
		public void setCodigoRegional(int codigoRegional) {
			this.codigoRegional = codigoRegional;
		}
		public int getCodigoMarca() {
			return codigoMarca;
		}
		public void setCodigoMarca(int codigoMarca) {
			this.codigoMarca = codigoMarca;
		}
		public List<Integer> getListaCliAtendRegionalAno() {
			return listaCliAtendRegionalAno;
		}
		public void setListaCliAtendRegionalAno(List<Integer> listaCliAtendRegionalAno) {
			this.listaCliAtendRegionalAno = listaCliAtendRegionalAno;
		}
		public List<Integer> getListaCliAtendRegionalAnt() {
			return listaCliAtendRegionalAnt;
		}
		public void setListaCliAtendRegionalAnt(List<Integer> listaCliAtendRegionalAnt) {
			this.listaCliAtendRegionalAnt = listaCliAtendRegionalAnt;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + codigoMarca;
			result = prime * result + codigoRegional;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AcompanhamentoDiarioVendasTotalRegionalMarca other = (AcompanhamentoDiarioVendasTotalRegionalMarca) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (codigoMarca != other.codigoMarca)
				return false;
			if (codigoRegional != other.codigoRegional)
				return false;
			return true;
		}
		private AcompanhamentoDiarioVendas getOuterType() {
			return AcompanhamentoDiarioVendas.this;
		}
		
	}
	
	
	public class AcompanhamentoDiarioVendasTotalRegional {

		private int codigoRegional;
		private List<Integer> listaCliAtendRegionalAno;
		private List<Integer> listaCliAtendRegionalAnt;

		public int getCodigoRegional() {
			return codigoRegional;
		}

		public void setCodigoRegional(int codigoRegional) {
			this.codigoRegional = codigoRegional;
		}

		public List<Integer> getListaCliAtendRegionalAno() {
			return listaCliAtendRegionalAno;
		}

		public void setListaCliAtendRegionalAno(List<Integer> listaCliAtendRegionalAno) {
			this.listaCliAtendRegionalAno = listaCliAtendRegionalAno;
		}

		public List<Integer> getListaCliAtendRegionalAnt() {
			return listaCliAtendRegionalAnt;
		}

		public void setListaCliAtendRegionalAnt(List<Integer> listaCliAtendRegionalAnt) {
			this.listaCliAtendRegionalAnt = listaCliAtendRegionalAnt;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + codigoRegional;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AcompanhamentoDiarioVendasTotalRegional other = (AcompanhamentoDiarioVendasTotalRegional) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (codigoRegional != other.codigoRegional)
				return false;
			return true;
		}

		private AcompanhamentoDiarioVendas getOuterType() {
			return AcompanhamentoDiarioVendas.this;
		}
		
	}

	public class Dados {

		private Integer paresPrevistoAno;
		private Integer paresRealizadoAno;
		private Double reaisPrevistoAno;
		private Double reaisRealizadoAno;
		private Integer paresRealizadoAnt;
		private Double reaisRealizadoAnt;
		private Integer cliAtendAno;
		private Integer cliAtendAnt;
		private Integer difCliAtend;
		private Integer cliAtendRegionalAno;
		private Integer cliAtendRegionalAnt;
		private Double difCliRegionalAtend;
		private Double valorMeta;
		private Double valorAnoAnt;
		private Double difParesAno;
		private Double difReaisAno;
		private Double difParesRealizado;
		private Double difReaisRealizado;
		private Double difClientesAtendidos;

		public Integer getParesPrevistoAno() {
			return paresPrevistoAno;
		}

		public void setParesPrevistoAno(Integer paresPrevistoAno) {
			this.paresPrevistoAno = paresPrevistoAno;
		}

		public Integer getParesRealizadoAno() {
			return paresRealizadoAno;
		}

		public void setParesRealizadoAno(Integer paresRealizadoAno) {
			this.paresRealizadoAno = paresRealizadoAno;
		}

		public Double getReaisPrevistoAno() {
			return reaisPrevistoAno;
		}

		public void setReaisPrevistoAno(Double reaisPrevistoAno) {
			this.reaisPrevistoAno = reaisPrevistoAno;
		}

		public Double getReaisRealizadoAno() {
			return reaisRealizadoAno;
		}

		public void setReaisRealizadoAno(Double reaisRealizadoAno) {
			this.reaisRealizadoAno = reaisRealizadoAno;
		}

		public Integer getParesRealizadoAnt() {
			return paresRealizadoAnt;
		}

		public void setParesRealizadoAnt(Integer paresRealizadoAnt) {
			this.paresRealizadoAnt = paresRealizadoAnt;
		}

		public Double getReaisRealizadoAnt() {
			return reaisRealizadoAnt;
		}

		public void setReaisRealizadoAnt(Double reaisRealizadoAnt) {
			this.reaisRealizadoAnt = reaisRealizadoAnt;
		}

		public Integer getCliAtendAno() {
			return cliAtendAno;
		}

		public void setCliAtendAno(Integer cliAtendAno) {
			this.cliAtendAno = cliAtendAno;
		}

		public Integer getCliAtendAnt() {
			return cliAtendAnt;
		}

		public void setCliAtendAnt(Integer cliAtendAnt) {
			this.cliAtendAnt = cliAtendAnt;
		}

		public Integer getDifCliAtend() {
			return difCliAtend;
		}

		public void setDifCliAtend(Integer difCliAtend) {
			this.difCliAtend = difCliAtend;
		}

		
		public Integer getCliAtendRegionalAno() {
			return cliAtendRegionalAno;
		}

		public void setCliAtendRegionalAno(Integer cliAtendRegionalAno) {
			this.cliAtendRegionalAno = cliAtendRegionalAno;
		}

		public Integer getCliAtendRegionalAnt() {
			return cliAtendRegionalAnt;
		}

		public void setCliAtendRegionalAnt(Integer cliAtendRegionalAnt) {
			this.cliAtendRegionalAnt = cliAtendRegionalAnt;
		}

		public Double getDifCliRegionalAtend() {
			return difCliRegionalAtend;
		}

		public void setDifCliRegionalAtend(Double difCliRegionalAtend) {
			this.difCliRegionalAtend = difCliRegionalAtend;
		}

		public Double getValorMeta() {
			return valorMeta;
		}

		public void setValorMeta(Double valorMeta) {
			this.valorMeta = valorMeta;
		}

		public Double getValorAnoAnt() {
			return valorAnoAnt;
		}

		public void setValorAnoAnt(Double valorAnoAnt) {
			this.valorAnoAnt = valorAnoAnt;
		}

		public Double getDifParesAno() {
			return difParesAno;
		}

		public void setDifParesAno(Double difParesAno) {
			this.difParesAno = difParesAno;
		}

		public Double getDifReaisAno() {
			return difReaisAno;
		}

		public void setDifReaisAno(Double difReaisAno) {
			this.difReaisAno = difReaisAno;
		}

		public Double getDifParesRealizado() {
			return difParesRealizado;
		}

		public void setDifParesRealizado(Double difParesRealizado) {
			this.difParesRealizado = difParesRealizado;
		}

		public Double getDifReaisRealizado() {
			return difReaisRealizado;
		}

		public void setDifReaisRealizado(Double difReaisRealizado) {
			this.difReaisRealizado = difReaisRealizado;
		}

		public Double getDifClientesAtendidos() {
			return difClientesAtendidos;
		}

		public void setDifClientesAtendidos(Double difClientesAtendidos) {
			this.difClientesAtendidos = difClientesAtendidos;
		}
	}

	public class ConsultaGeralThread implements Runnable {

		private Thread thread;

		@Override
		public void run() {
			try {
				consultar();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			} finally {
				executionCompleted.countDown();
			}
		}

		public void start() {
			if (thread == null) {
				thread = new Thread(this, "consultaGeral");
				thread.start();
			}
		}
	}

	public class ConsultaClientesAtendidosThread implements Runnable {

		private Thread thread;

		@Override
		public void run() {

			try {
				consultarClientes();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			} finally {
				executionCompleted.countDown();
			}
		}

		public void start() {
			if (thread == null) {
				thread = new Thread(this, "consultaClientesAtendidos");
				thread.start();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void processarRegistros() {
		AcompanhamentoDiarioVendasTotalGeral acompanhamentoDiarioVendasTotalGeral = new AcompanhamentoDiarioVendasTotalGeral();
		acompanhamentoDiarioVendasTotalGeral.setListaCliAtendRegionalAno(new ArrayList<Integer>());
		acompanhamentoDiarioVendasTotalGeral.setListaCliAtendRegionalAnt(new ArrayList<Integer>());
		
		List<AcompanhamentoDiarioVendasTotalRegional> listaAcompanhamentoDiarioVendasTotalRegional = new ArrayList();
		List<AcompanhamentoDiarioVendasTotalRegionalMarca> listaAcompanhamentoDiarioVendasTotalRegionalMarca = new ArrayList();
		
		java.util.Vector res_Jw_acompanhamento_diario_vendas = new java.util.Vector();
		java.util.Vector res_Jw_acompanhamento_diario_vendas_total_geral = new java.util.Vector();
		java.util.Vector res_Jw_acompanhamento_diario_vendas_total_regionais = new java.util.Vector();
		java.util.Vector res_Jw_acompanhamento_diario_vendas_total_marcas = new java.util.Vector();
		try {

			for (Acompanhamento acompanhamento : this.listaAcompanhamentos) {

				for (Dados dados : acompanhamento.getListaDados()) {
					Jw_acompanhamento_diario_vendas jw = new Jw_acompanhamento_diario_vendas();
					jw.setCli_atend_ano(dados.getCliAtendAno());
					jw.setCli_atend_ant(dados.getCliAtendAnt());
					jw.setCli_atend_regional_ano(0);
					jw.setCli_atend_regional_ant(0);
					jw.setCodigo_marca(acompanhamento.getCodigoMarca());
					jw.setCodigo_regional(acompanhamento.getCodigoRegional());
					jw.setDescricao_marca(acompanhamento.getDescricaoMarca());
					jw.setDif_cli_atend(dados.getDifCliAtend());
					jw.setDif_cli_regional_atend(0);
					jw.setDif_clientes_atendidos(dados.getDifClientesAtendidos());
					jw.setDif_pares_ano(dados.getDifParesAno());
					jw.setDif_pares_realizado(dados.getDifParesRealizado());
					jw.setDif_reais_ano(dados.getDifReaisAno());
					jw.setDif_reais_realizado(dados.getDifReaisRealizado());
					jw.setNome_regional(acompanhamento.getNomeRegional());
					jw.setPares_previsto_ano(dados.getParesPrevistoAno());
					jw.setPares_realizado_ano(dados.getParesRealizadoAno());
					jw.setPares_realizado_ant(dados.getParesRealizadoAnt());
					jw.setPeriodo(acompanhamento.getPeriodo());
					jw.setPeriodo_ano_anterior(acompanhamento.getPeriodoAnoAnterior());
					jw.setReais_previsto_ano(dados.getReaisPrevistoAno());
					jw.setReais_realizado_ano(dados.getReaisRealizadoAno());
					jw.setReais_realizado_ant(dados.getReaisRealizadoAnt());
					jw.setRep_cdgo(acompanhamento.getRepCdgo());
					jw.setRep_rzao(acompanhamento.getRepRzao());
					jw.setValor_ano_ant(dados.getValorAnoAnt());
					jw.setValor_meta(dados.getValorMeta());
					res_Jw_acompanhamento_diario_vendas.add(jw);
				}
			}

			for (ClientesAtendidos clientesAtendidos : this.listaClientesAtendidos) {
				AcompanhamentoDiarioVendasTotalRegional acompanhamentoDiarioVendasTotalRegional = new AcompanhamentoDiarioVendasTotalRegional();
				acompanhamentoDiarioVendasTotalRegional.setCodigoRegional(clientesAtendidos.getCodigoRegional());
				acompanhamentoDiarioVendasTotalRegional.setListaCliAtendRegionalAnt(new ArrayList<Integer>());
				acompanhamentoDiarioVendasTotalRegional.setListaCliAtendRegionalAno(new ArrayList<Integer>());
				
				AcompanhamentoDiarioVendasTotalRegionalMarca acompanhamentoDiarioVendasTotalRegionalMarca = new AcompanhamentoDiarioVendasTotalRegionalMarca();
				acompanhamentoDiarioVendasTotalRegionalMarca.setCodigoMarca(clientesAtendidos.getCodigoMarca());
				acompanhamentoDiarioVendasTotalRegionalMarca.setCodigoRegional(clientesAtendidos.getCodigoRegional());
				acompanhamentoDiarioVendasTotalRegionalMarca.setListaCliAtendRegionalAnt(new ArrayList<Integer>());
				acompanhamentoDiarioVendasTotalRegionalMarca.setListaCliAtendRegionalAno(new ArrayList<Integer>());
				
				if (clientesAtendidos.getPeriodo().equalsIgnoreCase("anterior")) {
					if (!acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAnt().contains(clientesAtendidos.getCliCdgo())) {
						acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAnt().add(clientesAtendidos.getCliCdgo());
					}
					if(listaAcompanhamentoDiarioVendasTotalRegional.contains(acompanhamentoDiarioVendasTotalRegional)) {
						AcompanhamentoDiarioVendasTotalRegional regional = listaAcompanhamentoDiarioVendasTotalRegional.get(listaAcompanhamentoDiarioVendasTotalRegional.indexOf(acompanhamentoDiarioVendasTotalRegional));
						if (!regional.getListaCliAtendRegionalAnt().contains(clientesAtendidos.getCliCdgo())) {
							regional.getListaCliAtendRegionalAnt().add(clientesAtendidos.getCliCdgo());
						}
					} else {
						acompanhamentoDiarioVendasTotalRegional.getListaCliAtendRegionalAnt().add(clientesAtendidos.getCliCdgo());
						listaAcompanhamentoDiarioVendasTotalRegional.add(acompanhamentoDiarioVendasTotalRegional);
					}
			
					if(listaAcompanhamentoDiarioVendasTotalRegionalMarca.contains(acompanhamentoDiarioVendasTotalRegionalMarca)) {
						AcompanhamentoDiarioVendasTotalRegionalMarca marca = listaAcompanhamentoDiarioVendasTotalRegionalMarca.get(listaAcompanhamentoDiarioVendasTotalRegionalMarca.indexOf(acompanhamentoDiarioVendasTotalRegionalMarca));
						if (!marca.getListaCliAtendRegionalAnt().contains(clientesAtendidos.getCliCdgo())) {
							marca.getListaCliAtendRegionalAnt().add(clientesAtendidos.getCliCdgo());
						}
					} else {
						acompanhamentoDiarioVendasTotalRegionalMarca.getListaCliAtendRegionalAnt().add(clientesAtendidos.getCliCdgo());
						listaAcompanhamentoDiarioVendasTotalRegionalMarca.add(acompanhamentoDiarioVendasTotalRegionalMarca);
					}
					
				} else if (clientesAtendidos.getPeriodo().equalsIgnoreCase("atual")) {
					if (!acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAno().contains(clientesAtendidos.getCliCdgo())) {
						acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAno().add(clientesAtendidos.getCliCdgo());
					}
					if(listaAcompanhamentoDiarioVendasTotalRegional.contains(acompanhamentoDiarioVendasTotalRegional)) {
						AcompanhamentoDiarioVendasTotalRegional poder = listaAcompanhamentoDiarioVendasTotalRegional.get(listaAcompanhamentoDiarioVendasTotalRegional.indexOf(acompanhamentoDiarioVendasTotalRegional));
						if (!poder.getListaCliAtendRegionalAno().contains(clientesAtendidos.getCliCdgo())) {
							poder.getListaCliAtendRegionalAno().add(clientesAtendidos.getCliCdgo());
						}
					} else {
						acompanhamentoDiarioVendasTotalRegional.getListaCliAtendRegionalAno().add(clientesAtendidos.getCliCdgo());
						listaAcompanhamentoDiarioVendasTotalRegional.add(acompanhamentoDiarioVendasTotalRegional);
					}
					
					
					if(listaAcompanhamentoDiarioVendasTotalRegionalMarca.contains(acompanhamentoDiarioVendasTotalRegionalMarca)) {
						AcompanhamentoDiarioVendasTotalRegionalMarca marca = listaAcompanhamentoDiarioVendasTotalRegionalMarca.get(listaAcompanhamentoDiarioVendasTotalRegionalMarca.indexOf(acompanhamentoDiarioVendasTotalRegionalMarca));
						if (!marca.getListaCliAtendRegionalAno().contains(clientesAtendidos.getCliCdgo())) {
							marca.getListaCliAtendRegionalAno().add(clientesAtendidos.getCliCdgo());
						}
					} else {
						acompanhamentoDiarioVendasTotalRegionalMarca.getListaCliAtendRegionalAno().add(clientesAtendidos.getCliCdgo());
						listaAcompanhamentoDiarioVendasTotalRegionalMarca.add(acompanhamentoDiarioVendasTotalRegionalMarca);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		// Query Geral
		this.request.getSession().setAttribute("res_Jw_acompanhamento_diario_vendas", res_Jw_acompanhamento_diario_vendas);
		
		// Query Total Regional
		for(AcompanhamentoDiarioVendasTotalRegional totalRegional : listaAcompanhamentoDiarioVendasTotalRegional) {
			Jw_acompanhamento_diario_vendas_total_regionais jwTotalGeral = new Jw_acompanhamento_diario_vendas_total_regionais();
			jwTotalGeral.setCodigo_regional(totalRegional.getCodigoRegional());
			jwTotalGeral.setCli_atend_regional_ant(totalRegional.getListaCliAtendRegionalAnt() != null ? totalRegional.getListaCliAtendRegionalAnt().size() : 0);
			jwTotalGeral.setCli_atend_regional_ano(totalRegional.getListaCliAtendRegionalAno() != null ? totalRegional.getListaCliAtendRegionalAno().size() : 0);
			res_Jw_acompanhamento_diario_vendas_total_regionais.add(jwTotalGeral);
		}
		this.request.getSession().setAttribute("res_Jw_acompanhamento_diario_vendas_total_regionais", res_Jw_acompanhamento_diario_vendas_total_regionais);
		
		// Query Total Marcas
		for(AcompanhamentoDiarioVendasTotalRegionalMarca totalRegionalMarca : listaAcompanhamentoDiarioVendasTotalRegionalMarca) {
			Jw_acompanhamento_diario_vendas_total_marcas jwTotalMarca = new Jw_acompanhamento_diario_vendas_total_marcas();
			jwTotalMarca.setCodigo_regional(totalRegionalMarca.getCodigoRegional());
			jwTotalMarca.setCodigo_marca(totalRegionalMarca.getCodigoMarca());
			jwTotalMarca.setCli_atend_marca_ant(totalRegionalMarca.getListaCliAtendRegionalAnt() != null ? totalRegionalMarca.getListaCliAtendRegionalAnt().size() : 0);
			jwTotalMarca.setCli_atend_marca_ano(totalRegionalMarca.getListaCliAtendRegionalAno() != null ? totalRegionalMarca.getListaCliAtendRegionalAno().size() : 0);
			res_Jw_acompanhamento_diario_vendas_total_marcas.add(jwTotalMarca);
		}		
		this.request.getSession().setAttribute("res_Jw_acompanhamento_diario_vendas_total_marcas", res_Jw_acompanhamento_diario_vendas_total_marcas);
		
		// Query Total Geral
		Jw_acompanhamento_diario_vendas_total_regionais jwTotalGeral = new Jw_acompanhamento_diario_vendas_total_regionais();
		jwTotalGeral.setCodigo_regional(99);
		jwTotalGeral.setCli_atend_regional_ant(acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAnt() != null ? acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAnt().size() : 0);
		jwTotalGeral.setCli_atend_regional_ano(acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAno() != null ? acompanhamentoDiarioVendasTotalGeral.getListaCliAtendRegionalAno().size() : 0);
		res_Jw_acompanhamento_diario_vendas_total_geral.add(jwTotalGeral);
		this.request.getSession().setAttribute("res_Jw_acompanhamento_diario_vendas_total_geral",res_Jw_acompanhamento_diario_vendas_total_geral);
		
		
	}

}
