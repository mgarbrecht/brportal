package util.consultas.com;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class FichaCliente {

	private String tipoConsulta;
	private Integer chave;
	private Integer sequencial;
	private List<Integer> listaClientesGrupoEconomico;
	private Double limite;
	private Double saldo;
	private Integer paresPedLiberados;
	private Double valorPedLiberados;
	private Integer paresPedNaoLiberados;
	private Double valorPedNaoLiberados;
	private Double valorVencido;
	private Integer diasVencido;
	private Double valorUtilizadoMarketing;
	private Double valorDisponivelMarketing;
    private HttpServletRequest request;	

	public FichaCliente(HttpServletRequest req) {
		this.request = req;
		tipoConsulta = "C";
		reset();
	}

	public FichaCliente(HttpServletRequest req, String tipo) {
		this.request = req;
		reset();
		tipoConsulta = tipo.toUpperCase();
	}

	public FichaCliente(HttpServletRequest req,String tipo, Integer chave) {
		this.request = req;
		reset();
		this.chave = chave;
		this.tipoConsulta = tipo.toUpperCase();
	}
	
	public FichaCliente(HttpServletRequest req,String tipo, Integer chave, Integer sequencial) {
		this.request = req;
		reset();
		this.chave = chave;
		this.sequencial = sequencial;
		this.tipoConsulta = tipo.toUpperCase();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public void setParesPedLiberados(Integer paresPedLiberados) {
		this.paresPedLiberados = paresPedLiberados;
	}

	public void setValorPedLiberados(Double valorPedLiberados) {
		this.valorPedLiberados = valorPedLiberados;
	}

	public void setParesPedNaoLiberados(Integer paresPedNaoLiberados) {
		this.paresPedNaoLiberados = paresPedNaoLiberados;
	}

	public void setValorPedNaoLiberados(Double valorPedNaoLiberados) {
		this.valorPedNaoLiberados = valorPedNaoLiberados;
	}

	public Double getValorUtilizadoMarketing() {
		return valorUtilizadoMarketing;
	}

	public void setValorUtilizadoMarketing(Double valorUtilizadoMarketing) {
		this.valorUtilizadoMarketing = valorUtilizadoMarketing;
	}

	public Double getValorDisponivelMarketing() {
		return valorDisponivelMarketing;
	}

	public void setValorDisponivelMarketing(Double valorDisponivelMarketing) {
		this.valorDisponivelMarketing = valorDisponivelMarketing;
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public Double getValorVencido() {
		return valorVencido;
	}

	public void setValorVencido(Double valorVencido) {
		this.valorVencido = valorVencido;
	}

	public Integer getDiasVencido() {
		return diasVencido;
	}

	public void setDiasVencido(Integer diasVencido) {
		this.diasVencido = diasVencido;
	}

	public List<Integer> getListaClientesGrupoEconomico() {
		return listaClientesGrupoEconomico;
	}

	public void setListaClientesGrupoEconomico(
			List<Integer> listaClientesGrupoEconomico) {
		this.listaClientesGrupoEconomico = listaClientesGrupoEconomico;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getParesPedLiberados() {
		return paresPedLiberados;
	}

	public void setParesPedLiberados(int paresPedLiberados) {
		this.paresPedLiberados = paresPedLiberados;
	}

	public double getValorPedLiberados() {
		return valorPedLiberados;
	}

	public void setValorPedLiberados(double valorPedLiberados) {
		this.valorPedLiberados = valorPedLiberados;
	}

	public int getParesPedNaoLiberados() {
		return paresPedNaoLiberados;
	}

	public void setParesPedNaoLiberados(int paresPedNaoLiberados) {
		this.paresPedNaoLiberados = paresPedNaoLiberados;
	}

	public double getValorPedNaoLiberados() {
		return valorPedNaoLiberados;
	}

	public void setValorPedNaoLiberados(double valorPedNaoLiberados) {
		this.valorPedNaoLiberados = valorPedNaoLiberados;
	}

	public void populaClientesGrupoEconomico(int grupo) throws Exception {
		this.listaClientesGrupoEconomico = new java.util.ArrayList<Integer>();
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			query.append(" SELECT cli_cdgo ");
			query.append("   FROM grupo_economico ge ");
			query.append("  WHERE gre_grupo = ? ");
			query.append("    AND nvl(ge.status,'I') = 'A' ");
			query.append("  ORDER BY cli_cdgo ");
			pstm = j.getConn().prepareStatement(query.toString());
			pstm.setInt(1, grupo);
			rset = pstm.executeQuery();
			while (rset.next()) {
				listaClientesGrupoEconomico.add(rset.getInt("cli_cdgo"));
			}
		} catch (Exception e) {
		} finally {
			if (rset != null)
				rset.close();
			if (pstm != null)
				pstm.close();
			if (j != null)
				j.close();
		}
	}

	public void somaValoresPedidos(com.egen.util.jdbc.JdbcUtil j, int cliCdgo)
			throws Exception {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		try {
		    acesso.Sessao sessao = new acesso.Sessao(request.getSession());
		    boolean temRestricao = false;
		    StringBuilder parametros = new StringBuilder();

		    if((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) ||
		       (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) ||
		       (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))){
		       temRestricao= true;
		    }

		    if(temRestricao){
		       parametros.append("  AND EXISTS (SELECT 1 ");
		       parametros.append("                FROM rep r ");
		       parametros.append("                   , cliente_representante cr ");
		       parametros.append("                   , analistas_regionais a ");
		       parametros.append("               WHERE rep_situ = 'A' ");
		       parametros.append("                 AND cr.situacao = 'A' ");
		       parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
		       parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");

		       if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
		          parametros.append("              AND r.codigo_regional = " + sessao.getChave());
		          parametros.append("              AND r.rep_cdgo = p.rep_cdgo ");
		       }

		       if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")){
		          parametros.append("              AND r.rep_cdgo = '"+sessao.getChave()+"' ");
		          parametros.append("              AND r.rep_cdgo = p.rep_cdgo ");
		       }

		       if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
		          parametros.append("              AND a.codigo_gerente = '"+sessao.getChave()+"' ");
		          parametros.append("              AND r.rep_cdgo = p.rep_cdgo ");
		       }

		       parametros.append("                 AND cr.codigo_cliente = p.cli_cdgo ");
		       parametros.append("                 AND cr.codigo_sequencial = p.esc_seqn) ");
		    }			
			
			query.append(" SELECT NVL(SUM(ped_lib_pares), 0) ped_lib_pares ");
			query.append("      , NVL(SUM(ped_lib_valor), 0) ped_lib_valor ");
			query.append("      , NVL(SUM(ped_nao_lib_pares), 0) ped_nao_lib_pares ");
			query.append("      , NVL(SUM(ped_nao_lib_valor), 0) ped_nao_lib_valor ");
			query.append("  FROM (SELECT NVL(COUNT(DISTINCT p.ped_nmro), 0) ped_lib_pares ");
			query.append("             , NVL(SUM((NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0)) - (NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0) * p.ped_boni / 100) - (((NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0)) - (NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0)) * p.ped_boni / 100) * NVL(p.ped_boni2, 0) / 100)), 0) ped_lib_valor ");
			query.append("             , 0 ped_nao_lib_pares ");
			query.append("             , 0 ped_nao_lib_valor ");
			query.append("          FROM ped p ");
			query.append("             , ite i ");
			query.append("         WHERE i.ped_nmro = NVL(p.ped_nmro, NULL) ");
			query.append("           AND p.ped_stat IN ('A', 'L') ");
			query.append("           AND p.cli_cdgo = ? ");
			
			query.append(parametros.toString());
			
			query.append("         GROUP BY cli_cdgo ");
			query.append("         UNION ALL ");
			query.append("        SELECT 0 ped_lib_pares ");
			query.append("             , 0 ped_lib_valor ");
			query.append("             , NVL(COUNT(DISTINCT p.ped_nmro), 0) ped_nao_lib_pares ");
			query.append("             , NVL(SUM((NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0)) - (NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0) * p.ped_boni / 100) - (((NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0)) - (NVL(i.ite_qtde, 0) * NVL(i.ite_prco, 0)) * p.ped_boni / 100) * NVL(p.ped_boni2, 0) / 100)), 0) ped_nao_lib_valor ");
			query.append("          FROM ped p ");
			query.append("             , ite i ");
			query.append("         WHERE i.ped_nmro = NVL(p.ped_nmro, NULL) ");
			query.append("           AND p.ped_stat IN ('B', 'P', 'T', 'R') ");
			query.append("           AND p.cli_cdgo = ? ");
			
			query.append(parametros.toString());
			
			query.append("         GROUP BY cli_cdgo) ");
			pstm = j.getConn().prepareStatement(query.toString());
			pstm.setInt(1, cliCdgo);
			pstm.setInt(2, cliCdgo);
			rset = pstm.executeQuery();
			if (rset.next()) {
				this.paresPedLiberados += rset.getInt("ped_lib_pares");
				this.valorPedLiberados += rset.getDouble("ped_lib_valor");
				this.paresPedNaoLiberados += rset.getInt("ped_nao_lib_pares");
				this.valorPedNaoLiberados += rset.getDouble("ped_nao_lib_valor");
			}
		} catch (Exception e) {
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void somaValoresLimiteSaldo(com.egen.util.jdbc.JdbcUtil j, int cliCdgo) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		try {
			query.append(" SELECT fnc_ctr_saldo_limite(c.cli_cdgo, '01') saldo ");
			query.append("      , cli_valor_credito_analista limite ");
			query.append("   FROM cli c ");
			query.append("  WHERE c.cli_cdgo = ? ");
			pstm = j.getConn().prepareStatement(query.toString());
			pstm.setInt(1, cliCdgo);
			rset = pstm.executeQuery();
			if (rset.next()) {
				this.saldo += rset.getDouble("saldo");
				this.limite += rset.getDouble("limite");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void somaValoresVencidos(com.egen.util.jdbc.JdbcUtil j, Integer chave)
			throws Exception {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		try {
			query.append(" SELECT MAX(tot.dd) dias ");
			query.append("      , SUM(tot.valor) valor ");
			query.append("   FROM (SELECT ROUND(((TRUNC(SYSDATE)) - MIN(t.tit_datvenc))) dd ");
			query.append("              , SUM(fnc_ctr_saldo_negociacao(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo, t.sit_codigo_situacao_titulo, t.tit_vlpcp, t.tit_vldeb)) valor ");
			query.append("           FROM titulos t ");
			query.append("          WHERE tit_status = 'A' ");
			query.append("            AND EXISTS (SELECT 1 ");
			query.append("                          FROM tipos_de_titulo_por_grupo tit_gru ");
			query.append("                         WHERE tit_gru.gtt_codigo_grupo_tipo_titulo = 4 ");
			query.append("                           AND NVL(tit_gru.tip_codigo, NULL) = t.tip_codigo) ");
			query.append("            AND NVL(t.tit_datvenc, NULL) <= TRUNC(SYSDATE - 1) ");
			query.append("            AND NVL(t.tipo_de_mercado, NULL) = 'MI' ");

			if (this.getTipoConsulta().equalsIgnoreCase("C")) {
				query.append("            AND t.cli_codigo = " + chave);
			} else {
				query.append("            AND t.cli_codigo IN (SELECT ge.cli_cdgo FROM grupo_economico ge WHERE ge.status = 'A' AND ge.gre_grupo = " + chave + " AND ge.cli_cdgo = t.cli_codigo) ");
			}

			query.append("            AND NOT EXISTS (SELECT 1 ");
			query.append("                   FROM mov_receber m ");
			query.append("                  WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL) ");
			query.append("                    AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL) ");
			query.append("                    AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL) ");
			query.append("                    AND m.tit_codigo = NVL(t.tit_codigo, NULL) ");
			query.append("                    AND EXISTS (SELECT 1 ");
			query.append("                                  FROM transacoes_por_grupo trn_gru ");
			query.append("                                 WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
			query.append("                                   AND trn_gru.trn_codigo = m.trn_codigo ");
			query.append("                                   AND data_inicial <= SYSDATE ");
			query.append("                                   AND NVL(data_final, SYSDATE) >= SYSDATE) ");
			query.append("                    AND NVL(m.mov_sequencia, 0) = 0 ");
			query.append("                    AND m.mov_data <= TRUNC(SYSDATE - 1) ");
			query.append("                    AND ROWNUM = 1) ");
			query.append("         UNION ");
			query.append("         SELECT ROUND(((TRUNC(SYSDATE) + 1) - MIN(c.data_de_deposito))) dd ");
			query.append("               ,SUM(brconrec.fnc_ctr_saldo_cheque(c.numero_do_cheque, c.age_codigo, c.prt_codigo_banco, c.cli_cdgo, c.tip_codigo, c.fil_filial, c.emp_empresa, c.sit_codigo_situacao_titulo, c.che_vlpcp, c.che_vldeb, c.valor_do_cheque, c.valor_recebido)) valor ");
			query.append("           FROM cheques c ");
			query.append("               ,rep r ");
			query.append("               ,gerentes_regionais_vendas g ");
			query.append("          WHERE c.sit_codigo_situacao_titulo = '4' ");
			query.append("            AND EXISTS (SELECT 1 ");
			query.append("                          FROM tipos_de_titulo_por_grupo tit_gru ");
			query.append("                         WHERE tit_gru.gtt_codigo_grupo_tipo_titulo = 4 ");
			query.append("                           AND NVL(tit_gru.tip_codigo, NULL) = c.tip_codigo) ");
			query.append("            AND r.rep_cdgo = c.rep_cdgo ");
			query.append("            AND g.codigo_gerente = r.rep_gerente_antigo ");

			if (this.getTipoConsulta().equalsIgnoreCase("C")) {
				query.append("            AND NVL(c.cli_cdgo, NULL) = " + chave);
			} else {
				query.append("            AND NVL(c.cli_cdgo, NULL) IN (SELECT ge.cli_cdgo FROM grupo_economico ge WHERE ge.status = 'A' AND ge.gre_grupo = " + chave + " AND ge.cli_cdgo = c.cli_cdgo) ");
			}

			query.append("            AND c.data_de_deposito < TRUNC(SYSDATE - 1) ");
			query.append("            AND NOT EXISTS (SELECT '1' ");
			query.append("                   FROM movimentos_cheque m ");
			query.append("                  WHERE m.emp_empresa = c.emp_empresa ");
			query.append("                    AND m.fil_filial = c.fil_filial ");
			query.append("                    AND m.tip_codigo = c.tip_codigo ");
			query.append("                    AND m.cli_cdgo = c.cli_cdgo ");
			query.append("                    AND m.prt_codigo_banco = c.prt_codigo_banco ");
			query.append("                    AND m.age_codigo = c.age_codigo ");
			query.append("                    AND m.che_numero_do_cheque = c.numero_do_cheque ");
			query.append("                    AND EXISTS (SELECT 1 ");
			query.append("                           FROM transacoes_por_grupo trn_gru ");
			query.append("                          WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
			query.append("                            AND trn_gru.trn_codigo = m.trn_codigo ");
			query.append("                            AND data_inicial <= SYSDATE ");
			query.append("                            AND NVL(data_final, SYSDATE) >= SYSDATE) ");
			query.append("                    AND m.data_do_movimento <= TRUNC(SYSDATE) ");
			query.append("                    AND NVL(m.moc_sequencia, 0) = 0 ");
			query.append("                    AND ROWNUM = 1) ");
			query.append("         UNION ");
			query.append("         SELECT ROUND(((TRUNC(SYSDATE) + 1) - MIN(che.data_de_deposito))) dd ");
			query.append("              , SUM(brconrec.fnc_ctr_saldo_cheque(che.numero_do_cheque, che.age_codigo, che.prt_codigo_banco, che.cli_cdgo, che.tip_codigo, che.fil_filial, che.emp_empresa, che.sit_codigo_situacao_titulo, che.che_vlpcp, che.che_vldeb, che.valor_do_cheque, che.valor_recebido)) valor ");
			query.append("           FROM cheques che ");
			query.append("              , rep rep ");
			query.append("              , movimentos_cheque mov ");
			query.append("          WHERE che.emp_empresa = mov.emp_empresa ");
			query.append("            AND che.fil_filial = mov.fil_filial ");
			query.append("            AND che.tip_codigo = mov.tip_codigo ");
			query.append("            AND che.cli_cdgo = mov.cli_cdgo ");
			query.append("            AND che.prt_codigo_banco = mov.prt_codigo_banco ");
			query.append("            AND che.age_codigo = mov.age_codigo ");
			query.append("            AND che.numero_do_cheque = mov.che_numero_do_cheque ");
			query.append("            AND rep.rep_cdgo = che.rep_cdgo ");
			query.append("            AND che.sit_codigo_situacao_titulo = '7' ");
			if (this.getTipoConsulta().equalsIgnoreCase("C")) {
				query.append("            AND NVL(che.cli_cdgo, NULL) = "	+ chave);
			} else {
				query.append("            AND NVL(che.cli_cdgo, NULL) IN (SELECT ge.cli_cdgo FROM grupo_economico ge WHERE ge.status = 'A' AND ge.gre_grupo = "	+ chave + " AND ge.cli_cdgo = che.cli_cdgo) ");
			}
			query.append("            AND che.data_de_deposito <= TRUNC(SYSDATE - 1) ");
			query.append("            AND mov.trn_codigo = 'CLD' ");
			query.append("            AND TRUNC(mov.data_do_movimento) >= TO_DATE('01/01/2000', 'DD/MM/YYYY') ");
			query.append("            AND NOT EXISTS (SELECT '1' ");
			query.append("                   FROM movimentos_cheque m ");
			query.append("                  WHERE m.emp_empresa = che.emp_empresa ");
			query.append("                    AND m.fil_filial = che.fil_filial ");
			query.append("                    AND m.tip_codigo = che.tip_codigo ");
			query.append("                    AND m.cli_cdgo = che.cli_cdgo ");
			query.append("                    AND m.prt_codigo_banco = che.prt_codigo_banco ");
			query.append("                    AND m.age_codigo = che.age_codigo ");
			query.append("                    AND m.che_numero_do_cheque = che.numero_do_cheque ");
			query.append("                    AND EXISTS (SELECT 1 ");
			query.append("                                  FROM transacoes_por_grupo trn_gru ");
			query.append("                                 WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
			query.append("                                   AND trn_gru.trn_codigo = m.trn_codigo ");
			query.append("                                   AND data_inicial <= SYSDATE ");
			query.append("                                   AND NVL(data_final, SYSDATE) >= SYSDATE) ");
			query.append("                    AND m.data_do_movimento <= TRUNC(SYSDATE) ");
			query.append("                    AND NVL(m.moc_sequencia, 0) = 0 ");
			query.append("                    AND ROWNUM = 1)) tot ");

			pstm = j.getConn().prepareStatement(query.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				this.diasVencido = rset.getInt("dias");
				this.valorVencido += rset.getDouble("valor");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	private void buscaDadosCliente(int chave) {
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			somaValoresLimiteSaldo(j, chave);
			somaValoresPedidos(j, chave);
			somaValoresVencidos(j, chave);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	private void buscaDadosGrupo(int grupoEconomico) {
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			populaClientesGrupoEconomico(grupoEconomico);
			for (Integer chave : this.listaClientesGrupoEconomico) {
				somaValoresLimiteSaldo(j, chave);
				somaValoresPedidos(j, chave);
				somaValoresVencidos(j, chave);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	public void buscaInformacoesFinanceiras() {
		if (this.tipoConsulta.equalsIgnoreCase("C")) {
			buscaDadosCliente(this.chave);
		} else {
			buscaDadosGrupo(this.chave);
		}
	}

	public void buscaInformacoesMarketing() throws Exception {
		com.egen.util.jdbc.JdbcUtil j = null;
		Integer grupoEconomico = 0;
		if (this.tipoConsulta.equalsIgnoreCase("C")) {
			grupoEconomico = 0;
		} else {
			grupoEconomico = chave;
		}

		PreparedStatement pstm = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			sb.append(" SELECT valor_utilizado ");
			sb.append("      , (valor_disp - valor_utilizado) valor_disponivel ");
			sb.append("   FROM (SELECT NVL(valor * 1.5 / 100, 0) valor_disp ");

			if (this.tipoConsulta.equalsIgnoreCase("C")) {
				sb.append("  , pck_acao_marketing.get_valor_acao_ano("+chave+", NULL, NULL) valor_utilizado ");				

			} else {
				sb.append("  , pck_acao_marketing.get_valor_acao_ano(null, "+ chave + ", NULL) valor_utilizado ");
			}

			sb.append("           FROM (SELECT SUM(qry.prs) pares ");
			sb.append("                      , SUM(qry.vlr) valor ");
			sb.append("                   FROM (SELECT ROUND(SUM(qry.vlr), 2) vlr ");
			sb.append("                              , SUM(qry.prs) prs ");
			sb.append("                           FROM (SELECT SUM(rp.valor) vlr ");
			sb.append("                                      , SUM(rp.pares) prs ");
			sb.append("                                   FROM resumo_ped rp ");

			if (this.tipoConsulta.equalsIgnoreCase("C")) {
				sb.append("                              WHERE rp.cli_cdgo = " + chave);
			} else {
				sb.append("                              WHERE rp.cli_cdgo = -1 ");
			}

			sb.append("                                    AND rp.data_dig >= TRUNC(ADD_MONTHS(SYSDATE, -6), 'mm') ");
			sb.append("                                  UNION ");
			sb.append("                                 SELECT SUM(rps.valor) vlr ");
			sb.append("                                      , SUM(rps.pares) prs ");
			sb.append("                                   FROM resumo_pedidos rps ");

			if (this.tipoConsulta.equalsIgnoreCase("C")) {
				sb.append("                              WHERE rps.cli_cdgo = " + chave);
			} else {
				sb.append("                              WHERE rps.cli_cdgo = -1 ");
			}
			sb.append("                                    AND rps.data_dig >= TRUNC(ADD_MONTHS(SYSDATE, -6), 'mm')) qry ");
			sb.append("                          WHERE NVL(" + grupoEconomico+ ", 0) = 0 ");
			sb.append("                         UNION ");
			sb.append("                         SELECT ROUND(SUM(qry.vlr), 2) vlr ");
			sb.append("                              , SUM(qry.prs) prs ");
			sb.append("                           FROM (SELECT SUM(rp.valor) vlr ");
			sb.append("                                       ,SUM(rp.pares) prs ");
			sb.append("                                   FROM resumo_ped rp ");
			sb.append("                                  WHERE rp.cli_cdgo IN (SELECT cli_cdgo ");
			sb.append("                                                          FROM grupo_economico ");
			sb.append("                                                         WHERE gre_grupo = "	+ grupoEconomico + ") ");
			sb.append("                                    AND rp.data_dig >= TRUNC(ADD_MONTHS(SYSDATE, -6), 'mm') ");
			sb.append("                                  UNION ");
			sb.append("                                 SELECT SUM(rps.valor) vlr ");
			sb.append("                                      , SUM(rps.pares) prs ");
			sb.append("                                   FROM resumo_pedidos rps ");
			sb.append("                                  WHERE rps.cli_cdgo IN (SELECT cli_cdgo ");
			sb.append("                                                           FROM grupo_economico ");
			sb.append("                                                          WHERE gre_grupo = "+ grupoEconomico + ") ");
			sb.append("                                    AND rps.data_dig >= TRUNC(ADD_MONTHS(SYSDATE, -6), 'mm')) qry ");
			sb.append("                          WHERE NVL(" + grupoEconomico+ ", 0) <> 0) qry)) ");

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			if (rset.next()) {
				this.valorUtilizadoMarketing = rset.getDouble("valor_utilizado");
				this.valorDisponivelMarketing += rset.getDouble("valor_disponivel");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (j != null) {
				j.close();
			}
		}
	}

	public List<String> getImagensAcaoMarketing() throws Exception {
	    acesso.Sessao sessao = new acesso.Sessao(request.getSession());
	    StringBuilder parametros = new StringBuilder();
	    if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
	    	parametros.append(" AND EXISTS (SELECT 1  ");
	    	parametros.append("	              FROM rep r  ");
	    	parametros.append("	                 , cliente_representante cr "); 
	    	parametros.append("	             WHERE rep_situ = 'A'  ");
	    	parametros.append("	               AND cr.situacao = 'A'  ");
	    	parametros.append("	               AND a.codigo_regional = r.codigo_regional  ");
	    	parametros.append("	               AND r.rep_cdgo = cr.codigo_representante "); 
	    	parametros.append("	               AND r.codigo_regional = " + sessao.getChave());
	    	parametros.append("	               AND r.rep_cdgo = a.rep_cdgo ) ");	    	
	    }
	    
	    if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) ||
	       (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
	    	parametros.append(" AND EXISTS (SELECT 1  ");
	    	parametros.append("	              FROM rep r  ");
	    	parametros.append("	                 , cliente_representante cr "); 
	    	parametros.append("	             WHERE rep_situ = 'A'  ");
	    	parametros.append("	               AND cr.situacao = 'A'  ");
	    	parametros.append("	               AND a.codigo_regional = r.codigo_regional  ");
	    	parametros.append("	               AND r.rep_cdgo = cr.codigo_representante "); 
	    	parametros.append("	               AND r.rep_cdgo = '"+sessao.getChave()+"' ");
	    	parametros.append("	               AND r.rep_cdgo = a.rep_cdgo ) ");	    	
	    }	    
	    
	    if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
	 	    	parametros.append(" AND EXISTS (SELECT 1  ");
	 	    	parametros.append("	              FROM rep r  ");
	 	    	parametros.append("	                 , cliente_representante cr "); 
	 	    	parametros.append("	             WHERE rep_situ = 'A'  ");
	 	    	parametros.append("	               AND cr.situacao = 'A'  ");
	 	    	parametros.append("	               AND a.codigo_regional = r.codigo_regional  ");
	 	    	parametros.append("	               AND r.rep_cdgo = cr.codigo_representante "); 
	 	    	parametros.append("	               AND r.codigo_regional = (SELECT codigo_regional FROM wbrio.analistas_regionais an WHERE an.codigo_gerente = "+sessao.getChave()+")+");
	 	    	parametros.append("	               AND r.rep_cdgo = a.rep_cdgo ) ");	    	
	 	    }	 	    
        
		List<String> listaImagens = new ArrayList<String>();
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rset = null;
		try { 
			j = new com.egen.util.jdbc.JdbcUtil();
			sb.append(" SELECT imagem ");
			sb.append("   FROM (SELECT a.data_transacao ");
			sb.append("              , i.nome_arquivo imagem ");
			sb.append("           FROM acao_marketing a ");
			sb.append("              , acao_marketing_imagem i ");
			sb.append("          WHERE a.situacao_acao_mkt <> 9 ");
			sb.append("            AND i.seq_acao_mkt = a.seq_acao_mkt ");
			
			   parametros.append("  AND a.data_transacao >= to_date('"+((String)request.getSession().getAttribute("DATA_INICIAL"))+"','dd/mm/yyyy') ");
			   parametros.append("  AND a.data_transacao <= to_date('"+((String)request.getSession().getAttribute("DATA_FINAL"))+"','dd/mm/yyyy') ");
	
			if (this.tipoConsulta.equalsIgnoreCase("C")) {
				sb.append(" AND cli_cdgo = " + this.chave);
				sb.append(" AND esc_seqn = " + this.sequencial);
			} else {
				sb.append(" AND gre_grupo = " + this.chave);
			}			
			
			sb.append(parametros.toString());
			sb.append("    ORDER BY a.seq_acao_mkt DESC) ");
			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			int contadorImagens = 0;
			while (rset.next()) {
				File f = new File("/home/loja_brportal/imagens/acoes_cooperadas/"+rset.getString("imagem"));
				if(f.exists()){
					contadorImagens++;
					listaImagens.add(rset.getString("imagem"));
				}
				if(contadorImagens == 10){
					break;
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (j != null) {
				j.close();
			}
		}
		return listaImagens;
	}
	
	public void reset() {
		this.diasVencido = 0;
		this.valorVencido = 0.0;
		this.limite = 0.0;
		this.saldo = 0.0;
		this.chave = null;
		this.paresPedLiberados = 0;
		this.paresPedNaoLiberados = 0;
		this.valorPedLiberados = 0.0;
		this.valorPedNaoLiberados = 0.0;
		this.valorUtilizadoMarketing = 0.0;
		this.valorDisponivelMarketing = 0.0;
	}

}
