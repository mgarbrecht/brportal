package brportal.ind;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import portalbr.dbobj.view.Jw_pse0053_total_fechado;

public class Pse0053 {

	public int getTotal_ref(String filial, String fornecedor, String processo, String referencia, String data_inicial,
			String data_final, String status, double preco) throws Exception {

		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int total = 0;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn()
					.prepareStatement(new StringBuilder("SELECT pares from ( ").append(" SELECT SUM(tal_pares) pares ")
							.append("      , pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq) preco")
							.append("   FROM atelier_pre_envio a ").append("  WHERE fil_filial = ? ")
							.append("	 AND for_codigo = ? ").append("	 AND pro_numero = ? ")
							.append("	 AND ref_cdgo   = ? ")
							.append("	 AND data_pre_envio >= to_date(?,'dd/mm/yyyy') ")
							.append("	 AND data_pre_envio  < to_date(?,'dd/mm/yyyy') + 1 ")
							.append("	 AND ((? = 'E' AND status IS NULL) OR (? = 'R' AND status_consiste_atelier = 'C' AND status_retorno IS NULL)) ")
							.append("  GROUP BY a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq ) ")
							.append("  WHERE preco = ?  ").toString());
			pstm.setString(1, filial);
			pstm.setString(2, fornecedor);
			pstm.setString(3, processo);
			pstm.setString(4, referencia);
			pstm.setString(5, data_inicial);
			pstm.setString(6, data_final);
			pstm.setString(7, status);
			pstm.setString(8, status);
			pstm.setDouble(9, preco);

			rset = pstm.executeQuery();

			if (rset.next()) {
				total = Integer.parseInt(com.egen.util.text.FormatNumber.format(rset.getDouble(1), "0"));
			}
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
		return total;
	}

	public double getProcesso_fab_custo(String processo, String filial) throws Exception {

		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		double total = 0;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(
					new StringBuilder(" select pck_processo_fab.get_custo(?,'01',?) from dual ").toString());
			pstm.setString(1, processo);
			pstm.setString(2, filial);

			rset = pstm.executeQuery();

			if (rset.next()) {
				total = rset.getDouble(1);
			}
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
		return total;
	}

	public double getTotal_notas(String processo, String filial, String fornecedor, String dataInicial,
			String dataFinal, String tipo) throws Exception {

		// util.consultas.Query query = new util.consultas.Query();
		double total = 0;
		PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT total ");
			sb.append("      , pares ");
			sb.append("   FROM (SELECT SUM(pares * preco) total ");
			sb.append("              , sum(pares) pares ");
			sb.append("           FROM (SELECT a.pro_numero ");
			sb.append("                      , tal_pares pares ");
			sb.append("                      , fil_filial ");
			sb.append(
					"                      , pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, NULL, a.pro_numero, a.for_codigo, a.fen_seq) preco ");
			sb.append("                   FROM (SELECT * ");
			sb.append("                           FROM atelier_pre_envio a ");
			sb.append("                          WHERE a.data_pre_envio >= TO_DATE('").append(dataInicial)
					.append("', 'dd/mm/yyyy') ");
			sb.append("                            AND a.data_pre_envio < TO_DATE('").append(dataFinal)
					.append("', 'dd/mm/yyyy') + 1 ");
			sb.append("                            AND a.fil_filial = '").append(filial).append("' ");
			sb.append("                            AND a.for_codigo = ").append(fornecedor);
			sb.append("                            AND a.pro_numero = ").append(processo).append(") a ");
			sb.append("                  WHERE (('").append(tipo).append(
					"' = 'E' AND (a.status = 'E' AND nvl(A.status_consiste_atelier,'1') <> 'C'  and a.status_retorno IS NULL)))) ");
			sb.append("          GROUP BY pro_numero ");
			sb.append("                 , pck_processo_fab.get_custo(pro_numero, '01', fil_filial) ");
			sb.append("         UNION ");
			sb.append("         SELECT SUM(pares * preco) total ");
			sb.append("              , sum(pares) pares ");
			sb.append("           FROM (SELECT a.pro_numero ");
			sb.append("                      , a.tal_pares pares ");
			sb.append("                      , a.fil_filial ");
			sb.append("                      , ioc.preco_unitario preco ");
			sb.append("                   FROM (SELECT * ");
			sb.append("                           FROM atelier_pre_envio a ");
			sb.append("                          WHERE a.data_pre_envio >= TO_DATE('").append(dataInicial)
					.append("', 'dd/mm/yyyy') ");
			sb.append("                            AND a.data_pre_envio < TO_DATE('").append(dataFinal)
					.append("', 'dd/mm/yyyy') + 1 ");
			sb.append("                            AND a.fil_filial = '").append(filial).append("' ");
			sb.append("                            AND a.for_codigo = ").append(fornecedor);
			sb.append("                            AND a.pro_numero = ").append(processo).append(") a ");
			sb.append("                      , talao t ");
			sb.append("                      , cpr.atelier_rem_taloes_oc art ");
			sb.append("                      , cpr.atelier_rem_talao_item_oc arti ");
			sb.append("                      , cpr.dom_item_ordem_compra ioc ");
			sb.append("                      , cpr.dom_ordem_compra oc ");
			sb.append("                  WHERE t.rem_nro = a.rem_nro ");
			sb.append("                    AND t.tal_nro = a.tal_nro ");
			sb.append("                    AND art.aroc_rem_nro = a.rem_nro ");
			sb.append("                    AND art.tal_nro = a.tal_nro ");
			sb.append("                    AND art.pro_numero = a.pro_numero ");
			sb.append("                    AND arti.oco_numero = art.aroc_oco_numero ");
			sb.append("                    AND arti.rem_nro = art.aroc_rem_nro ");
			sb.append("                    AND arti.tal_nro = art.tal_nro ");
			sb.append("                    AND ioc.oco_numero = arti.oco_numero ");
			sb.append("                    AND ioc.sequencia = arti.ioc_sequencia ");
			sb.append("                    AND oc.numero = ioc.oco_numero ");
			sb.append("                    AND ioc.oco_numero = arti.oco_numero ");
			sb.append("                    AND ioc.sequencia = arti.ioc_sequencia ");
			sb.append("                    AND oc.numero = ioc.oco_numero ");
			sb.append("                    AND ('").append(tipo)
					.append("' = 'R' AND nvl(a.status_consiste_atelier,'1') = 'C' and a.status_retorno IS NULL)) ");
			sb.append("          GROUP BY pro_numero ");
			sb.append("                 , pck_processo_fab.get_custo(pro_numero, '01', fil_filial)) ");

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();

			if (rset.next()) {
				total = rset.getDouble("total");
				total += totalSubProcessos(processo, filial, rset.getInt("pares"));
			}
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
		return total;
	}

	private double totalSubProcessos(String processo, String filial, int quantidadePares) {
		Double totalSubProcessos = 0d;
		PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT SUM(").append(quantidadePares).append(" * valor) totalSubProcessos ");
			sb.append("   FROM (SELECT pck_processo_fab.get_custo(ps.pro_numero_sub_processo, '01', '").append(filial)
					.append("') valor ");
			sb.append("           FROM processo_fab_sub_processo ps ");
			sb.append("          WHERE pro_numero = ").append(processo);
			sb.append("          UNION ");
			sb.append("         SELECT pck_processo_fab.get_custo(").append(processo).append(", '01', '").append(filial)
					.append("') valor FROM dual) ");
			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			if (rset.next()) {
				totalSubProcessos = rset.getDouble("totalSubProcessos");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			totalSubProcessos = 0d;
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (j != null) {
				j.close();
			}
		}
		return totalSubProcessos;

	}

	public Vector<?> getDescontos(Integer processo, String filial, javax.servlet.http.HttpSession session)
			throws Exception {
		Jw_pse0053_total_fechado table_fechado = new Jw_pse0053_total_fechado();
		PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT pro_numero ");
			sb.append("      , descr_material pro_nome  ");
			sb.append("      , qtd_mat_pendentes_desconto pares ");
			sb.append("      , preco  ");
			sb.append("      , valor_mat_pendentes_desconto total ");
			sb.append("   FROM (SELECT rnf.for_codigo ");
			sb.append("              , ns.nfs_nmro ");
			sb.append("              , decode(1, 1, accf.descricao) descr_material ");
			sb.append("              , IREQ.ITEST_CODIGO pro_numero ");
			sb.append("              , ACCF.VALOR_UNITARIO preco ");
			sb.append("              , SUM(NVL(DECODE(accf.retornar_valor, 'N', (SELECT CASE ");
			sb.append("                                     WHEN (accfv.reqnf_numero > ");
			sb.append("                                          1255482) THEN ");
			sb.append("                                      ROUND(accfv.quantidade_pendente, 2) ");
			sb.append("                                     ELSE ");
			sb.append("                                      TRUNC(accfv.quantidade_pendente, 2) ");
			sb.append("                                   END ");
			sb.append("                              FROM atelier_conta_corrente_forn_v accfv ");
			sb.append(
					"                             WHERE accfv.id_lancamento_cc = accf.id_lancamento_cc)), 0)) qtd_mat_pendentes_desconto ");
			sb.append("              , SUM(NVL(DECODE(accf.retornar_valor, 'N', (SELECT CASE ");
			sb.append("                                     WHEN (accfv.reqnf_numero > ");
			sb.append("                                          1255482) THEN ");
			sb.append("                                      ROUND(accfv.quantidade_pendente * ");
			sb.append("                                            accfv.valor_unitario, 2) ");
			sb.append("                                     ELSE ");
			sb.append("                                      TRUNC(accfv.quantidade_pendente * ");
			sb.append("                                            accfv.valor_unitario, 2) ");
			sb.append("                                   END ");
			sb.append("                              FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                             WHERE accfv.id_lancamento_cc = ");
			sb.append("                                   accf.id_lancamento_cc)), 0)) valor_mat_pendentes_desconto ");
			sb.append("           FROM requisicoes_notas_fiscais rnf ");
			sb.append("              , notas_fiscais_saida_requis nfsr ");
			sb.append("               ,FAT.ITENS_REQ_NOTAS_FISCAIS ireq ");
			sb.append("              , nf_saida ns ");
			sb.append("              , (SELECT accf.* ");
			sb.append("                   FROM atelier_conta_corrente_fornec accf ");
			sb.append("                  WHERE accf.operacao = pck_atelier.get_operacao_envio ");
			sb.append(
					"                    AND accf.natureza_lancamento = pck_atelier.get_natureza_materia_prima) accf ");
			sb.append("          WHERE rnf.data_requisicao >= to_date('")
					.append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("		       AND rnf.data_requisicao < to_date('")
					.append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("            AND NVL(rnf.emp_empresa, NULL) = NVL('01', rnf.emp_empresa) ");
			sb.append("            AND NVL(rnf.fil_filial, NULL) = NVL('").append(filial).append("', rnf.fil_filial) ");
			sb.append("            AND NVL(rnf.for_codigo, NULL) = NVL(")
					.append((String) session.getAttribute("pse0053_fornecedor")).append(", rnf.for_codigo) ");
			sb.append("            AND NVL(rnf.fen_seq, NULL) = NVL(1, rnf.fen_seq) ");
			sb.append(
					"            AND NVL(rnf.stat_codigo, NULL) IN (pck_requisicao_nota_fiscal.get_status_digitada, pck_requisicao_nota_fiscal.get_status_faturada) ");
			sb.append("            AND nfsr.reqnf_numero = rnf.numero ");
			sb.append("            AND ns.emp_empresa = nfsr.emp_empresa ");
			sb.append("            AND ns.fil_filial = nfsr.fil_filial ");
			sb.append("            AND ns.nfs_nmro = nfsr.nfs_nmro ");
			sb.append("            AND ns.nfs_serie = nfsr.nfs_serie ");
			sb.append("            AND RNF.NUMERO = IREQ.REQNF_NUMERO ");
			sb.append("            AND ACCF.REQNF_NUMERO = ireq.reqnf_numero ");
			sb.append("            AND ACCF.ITEREQNF_SEQUENCIA = IREQ.SEQUENCIA ");
			sb.append("            AND NVL(ns.stat_codigo, NULL) IN (pck_nf_saida.get_status_emitida) ");
			sb.append("            AND accf.reqnf_numero(+) = rnf.numero ");
			sb.append("          GROUP BY rnf.for_codigo ");
			sb.append("                 , rnf.fen_seq ");
			sb.append("                 , pck_fornecedor.get_nome(rnf.for_codigo) ");
			sb.append("                 , ns.fil_filial ");
			sb.append("                 , ns.nfs_nmro ");
			sb.append("                 , ns.nfs_serie ");
			sb.append("                 , ns.nfs_dtemis ");
			sb.append("                 , IREQ.ITEST_CODIGO ");
			sb.append("                 , DECODE(1, 1, accf.descricao) ");
			sb.append("                 , accf.valor_unitario ");
			sb.append("        HAVING SUM(NVL(accf.valor_total, 0)) > 0) qry ");
			sb.append("  ,(SELECT DISTINCT n.nfs_nmro ");
			sb.append("      FROM atelier_pre_envio                  a ");
			sb.append("         , cpr.dom_item_ordem_item_requisicao i ");
			sb.append("         , atelier_rem_taloes_oc              o ");
			sb.append("         , fat.notas_fiscais_saida_requis     n ");
			sb.append("     WHERE a.fil_filial = '").append(filial).append("' ");
			sb.append("       AND a.for_codigo = ").append((String) session.getAttribute("pse0053_fornecedor"));
			sb.append("        and a.pro_numero = ").append(processo);
			sb.append("       AND a.data_pre_envio >= to_date('")
					.append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("       AND a.data_pre_envio < to_date('")
					.append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("       AND a.rem_nro = o.aroc_rem_nro  ");
			sb.append("       AND a.tal_nro = o.tal_nro ");
			sb.append("       AND a.pro_numero = o.pro_numero ");
			sb.append("       AND a.for_codigo = o.for_codigo ");
			sb.append("       AND o.aroc_oco_numero = i.oco_numero ");
			sb.append("       AND (('").append((String) session.getAttribute("pse0053_tipo"))
					.append("' = 'E' AND (a.status = 'E' AND NVL(A.status_consiste_atelier, '1') <> 'C' AND ");
			sb.append("            a.status_retorno IS NULL)) OR ");
			sb.append("            ('").append((String) session.getAttribute("pse0053_tipo"))
					.append("' = 'R' AND NVL(a.status_consiste_atelier, '1') = 'C' AND a.status_retorno IS NULL)) ");
			sb.append("       AND i.reqnf_numero = n.reqnf_numero) notas ");
			sb.append(" WHERE qry.nfs_nmro = notas.nfs_nmro ");
			sb.append("   AND (qry.valor_mat_pendentes_desconto > 0) ");
			Vector<?> res_Jw_pse0053_total_fechado_itens = j.select(table_fechado, sb.toString(), null);
			return res_Jw_pse0053_total_fechado_itens;
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

	public Vector<?> getRetorno_simbolico_itens(Integer processo, String filial, javax.servlet.http.HttpSession session)
			throws Exception {
		Jw_pse0053_total_fechado table_fechado = new Jw_pse0053_total_fechado();
		PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT pro_numero  ");
			sb.append("      , descr_material pro_nome  ");
			sb.append("      , qtd_mat_pendentes_retorno pares ");
			sb.append("      , preco  ");
			sb.append("      , valor_mat_pendentes_retorno total ");
			sb.append("   FROM (SELECT rnf.for_codigo ");
			sb.append("              , ns.nfs_nmro ");
			sb.append("              , decode(1, 1, accf.descricao) descr_material ");
			sb.append("              , IREQ.ITEST_CODIGO pro_numero ");
			sb.append("              , ACCF.VALOR_UNITARIO preco ");
			sb.append("              , SUM(NVL(DECODE(accf.retornar_valor, 'S', (SELECT CASE ");
			sb.append("                                     WHEN (accfv.reqnf_numero > ");
			sb.append("                                          1255482) THEN ");
			sb.append("                                      ROUND(accfv.quantidade_pendente, 2) ");
			sb.append("                                     ELSE ");
			sb.append("                                      TRUNC(accfv.quantidade_pendente, 2) ");
			sb.append("                                   END ");
			sb.append("                              FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                             WHERE accfv.id_lancamento_cc = accf.id_lancamento_cc)), 0)) qtd_mat_pendentes_retorno ");
			sb.append("              , SUM(NVL(DECODE(accf.retornar_valor, 'S', (SELECT CASE ");
			sb.append("                                     WHEN (accfv.reqnf_numero > ");
			sb.append("                                          1255482) THEN ");
			sb.append("                                      ROUND(accfv.quantidade_pendente * ");
			sb.append("                                            accfv.valor_unitario, 2) ");
			sb.append("                                     ELSE ");
			sb.append("                                      TRUNC(accfv.quantidade_pendente * ");
			sb.append("                                            accfv.valor_unitario, 2) ");
			sb.append("                                   END ");
			sb.append("                              FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                             WHERE accfv.id_lancamento_cc = ");
			sb.append("                                   accf.id_lancamento_cc)), 0)) valor_mat_pendentes_retorno ");
			sb.append("           FROM requisicoes_notas_fiscais rnf ");
			sb.append("              , notas_fiscais_saida_requis nfsr ");
			sb.append("               ,FAT.ITENS_REQ_NOTAS_FISCAIS ireq ");
			sb.append("              , nf_saida ns ");
			sb.append("              , (SELECT accf.* ");
			sb.append("                   FROM atelier_conta_corrente_fornec accf ");
			sb.append("                  WHERE accf.operacao = pck_atelier.get_operacao_envio ");
			sb.append("                    AND accf.natureza_lancamento = pck_atelier.get_natureza_materia_prima) accf ");
			sb.append("          WHERE rnf.data_requisicao >= to_date('").append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("		       AND rnf.data_requisicao < to_date('").append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("            AND NVL(rnf.emp_empresa, NULL) = NVL('01', rnf.emp_empresa) ");
			sb.append("            AND NVL(rnf.fil_filial, NULL) = NVL('").append(filial).append("', rnf.fil_filial) ");
			sb.append("            AND NVL(rnf.for_codigo, NULL) = NVL(").append((String) session.getAttribute("pse0053_fornecedor")).append(", rnf.for_codigo) ");
			sb.append("            AND NVL(rnf.fen_seq, NULL) = NVL(1, rnf.fen_seq) ");
			sb.append("            AND NVL(rnf.stat_codigo, NULL) IN (pck_requisicao_nota_fiscal.get_status_digitada, pck_requisicao_nota_fiscal.get_status_faturada) ");
			sb.append("            AND nfsr.reqnf_numero = rnf.numero ");
			sb.append("            AND ns.emp_empresa = nfsr.emp_empresa ");
			sb.append("            AND ns.fil_filial = nfsr.fil_filial ");
			sb.append("            AND ns.nfs_nmro = nfsr.nfs_nmro ");
			sb.append("            AND ns.nfs_serie = nfsr.nfs_serie ");
			sb.append("            AND RNF.NUMERO = IREQ.REQNF_NUMERO ");
			sb.append("            AND ACCF.REQNF_NUMERO = ireq.reqnf_numero ");
			sb.append("            AND ACCF.ITEREQNF_SEQUENCIA = IREQ.SEQUENCIA ");
			sb.append("            AND NVL(ns.stat_codigo, NULL) IN (pck_nf_saida.get_status_emitida) ");
			sb.append("            AND accf.reqnf_numero(+) = rnf.numero ");
			sb.append("          GROUP BY rnf.for_codigo ");
			sb.append("                 , rnf.fen_seq ");
			sb.append("                 , pck_fornecedor.get_nome(rnf.for_codigo) ");
			sb.append("                 , ns.fil_filial ");
			sb.append("                 , ns.nfs_nmro ");
			sb.append("                 , ns.nfs_serie ");
			sb.append("                 , ns.nfs_dtemis ");
			sb.append("                 , IREQ.ITEST_CODIGO ");
			sb.append("                 , DECODE(1, 1, accf.descricao) ");
			sb.append("                 , accf.valor_unitario ");
			sb.append("        HAVING SUM(NVL(accf.valor_total, 0)) > 0) qry ");
			sb.append("  ,(SELECT DISTINCT n.nfs_nmro ");
			sb.append("      FROM atelier_pre_envio                  a ");
			sb.append("         , cpr.dom_item_ordem_item_requisicao i ");
			sb.append("         , atelier_rem_taloes_oc              o ");
			sb.append("         , fat.notas_fiscais_saida_requis     n ");
			sb.append("     WHERE a.fil_filial = '").append(filial).append("' ");
			sb.append("       AND a.for_codigo = ").append((String) session.getAttribute("pse0053_fornecedor"));
			sb.append("        and a.pro_numero = ").append(processo);
			sb.append("       AND a.data_pre_envio >= to_date('").append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("       AND a.data_pre_envio < to_date('").append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("       AND a.rem_nro = o.aroc_rem_nro  ");
			sb.append("       AND a.tal_nro = o.tal_nro ");
			sb.append("       AND a.pro_numero = o.pro_numero ");
			sb.append("       AND a.for_codigo = o.for_codigo ");
			sb.append("       AND o.aroc_oco_numero = i.oco_numero ");
			sb.append("       AND (('").append((String) session.getAttribute("pse0053_tipo")).append("' = 'E' AND (a.status = 'E' AND NVL(A.status_consiste_atelier, '1') <> 'C' AND ");
			sb.append("            a.status_retorno IS NULL)) OR ");
			sb.append("            ('").append((String) session.getAttribute("pse0053_tipo")).append("' = 'R' AND NVL(a.status_consiste_atelier, '1') = 'C' AND a.status_retorno IS NULL)) ");
			sb.append("       AND i.reqnf_numero = n.reqnf_numero) notas ");
			sb.append(" WHERE qry.nfs_nmro = notas.nfs_nmro ");
			sb.append("   AND (qry.valor_mat_pendentes_retorno > 0) ");
			Vector<?> res_Jw_pse0053_total_fechado_itens = j.select(table_fechado, sb.toString(), null);
			return res_Jw_pse0053_total_fechado_itens;
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

	public Vector<?> getRetorno_simbolico_itens_resumo(Integer processo, String filial,
			javax.servlet.http.HttpSession session) throws Exception {
		Jw_pse0053_total_fechado table_fechado = new Jw_pse0053_total_fechado();

		PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT pro_numero ");
			sb.append("       ,pro_nome ");
			sb.append("       ,CASE WHEN valor_restante > 0 THEN quantidade_total - 1 ELSE quantidade_total END pares ");
			sb.append("       ,valor_medio preco ");
			sb.append("       ,CASE WHEN valor_restante > 0 THEN valor_parcial ELSE valor_total END total ");
			sb.append("   FROM (SELECT 18709838 pro_numero ");
			sb.append("               ,'MATERIAIS PARA INDUSTRIALIZACAO' pro_nome ");
			sb.append("               ,SUM(pares) quantidade_total ");
			sb.append("               ,trunc(SUM(pares * preco), 2) valor_total ");
			sb.append("               ,trunc(SUM(pares * preco) / SUM(pares), 2) valor_medio ");
			sb.append("               ,trunc(SUM(pares) * trunc(SUM(pares * preco) / SUM(pares), 2), 2) valor_parcial ");
			sb.append("               ,trunc(SUM(pares * preco), 2) - ");
			sb.append("                trunc(SUM(pares) * trunc(SUM(pares * preco) / SUM(pares), 2), 2) valor_restante ");
			sb.append("           FROM (SELECT pro_numero ");
			sb.append("                       ,descr_material              pro_nome ");
			sb.append("                       ,qtd_mat_pendentes_retorno   pares ");
			sb.append("                       ,preco ");
			sb.append("                       ,valor_mat_pendentes_retorno total ");
			sb.append("                   FROM (SELECT rnf.for_codigo ");
			sb.append("                               ,ns.nfs_nmro ");
			sb.append("                               ,decode(1, 1, accf.descricao) descr_material ");
			sb.append("                               ,IREQ.ITEST_CODIGO pro_numero ");
			sb.append("                               ,ACCF.VALOR_UNITARIO preco ");
			sb.append("                               ,SUM(NVL(DECODE(accf.retornar_valor, 'S', (SELECT CASE ");
			sb.append("                                                          WHEN (accfv.reqnf_numero > ");
			sb.append("                                                               1255482) THEN ");
			sb.append("                                                           ROUND(accfv.quantidade_pendente, 2) ");
			sb.append("                                                          ELSE ");
			sb.append("                                                           TRUNC(accfv.quantidade_pendente, 2) ");
			sb.append("                                                        END ");
			sb.append("                                                   FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                                                  WHERE accfv.id_lancamento_cc = ");
			sb.append("                                                        accf.id_lancamento_cc)), 0)) qtd_mat_pendentes_retorno ");
			sb.append("                               ,SUM(NVL(DECODE(accf.retornar_valor, 'S', (SELECT CASE ");
			sb.append("                                                          WHEN (accfv.reqnf_numero > ");
			sb.append("                                                               1255482) THEN ");
			sb.append("                                                           ROUND(accfv.quantidade_pendente * ");
			sb.append("                                                                 accfv.valor_unitario, 2) ");
			sb.append("                                                          ELSE ");
			sb.append("                                                           TRUNC(accfv.quantidade_pendente * ");
			sb.append("                                                                 accfv.valor_unitario, 2) ");
			sb.append("                                                        END ");
			sb.append("                                                   FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                                                  WHERE accfv.id_lancamento_cc = ");
			sb.append("                                                        accf.id_lancamento_cc)), 0)) valor_mat_pendentes_retorno ");
			sb.append("                           FROM requisicoes_notas_fiscais rnf ");
			sb.append("                               ,notas_fiscais_saida_requis nfsr ");
			sb.append("                               ,FAT.ITENS_REQ_NOTAS_FISCAIS ireq ");
			sb.append("                               ,nf_saida ns ");
			sb.append("                               ,(SELECT accf.* ");
			sb.append("                                   FROM atelier_conta_corrente_fornec accf ");
			sb.append("                                  WHERE accf.operacao = ");
			sb.append("                                        pck_atelier.get_operacao_envio ");
			sb.append("                                    AND accf.natureza_lancamento = ");
			sb.append("                                        pck_atelier.get_natureza_materia_prima) accf ");
			sb.append("             			 WHERE rnf.data_requisicao >= to_date('").append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("		    				   AND rnf.data_requisicao < to_date('").append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("   				           AND NVL(rnf.emp_empresa, NULL) = NVL('01', rnf.emp_empresa) ");
			sb.append("      				       AND NVL(rnf.fil_filial, NULL) = NVL('").append(filial).append("', rnf.fil_filial) ");
			sb.append("         				   AND NVL(rnf.for_codigo, NULL) = NVL(").append((String) session.getAttribute("pse0053_fornecedor")).append(", rnf.for_codigo) ");
			sb.append("                            AND NVL(rnf.fen_seq, NULL) = NVL(1, rnf.fen_seq) ");
			sb.append("                            AND NVL(rnf.stat_codigo, NULL) IN (pck_requisicao_nota_fiscal.get_status_digitada, pck_requisicao_nota_fiscal.get_status_faturada) ");
			sb.append("                            AND nfsr.reqnf_numero = rnf.numero ");
			sb.append("                            AND ns.emp_empresa = nfsr.emp_empresa ");
			sb.append("                            AND ns.fil_filial = nfsr.fil_filial ");
			sb.append("                            AND ns.nfs_nmro = nfsr.nfs_nmro ");
			sb.append("                            AND ns.nfs_serie = nfsr.nfs_serie ");
			sb.append("                            AND RNF.NUMERO = IREQ.REQNF_NUMERO ");
			sb.append("                            AND ACCF.REQNF_NUMERO = ireq.reqnf_numero ");
			sb.append("                            AND ACCF.ITEREQNF_SEQUENCIA = IREQ.SEQUENCIA ");
			sb.append("                            AND NVL(ns.stat_codigo, NULL) IN (pck_nf_saida.get_status_emitida) ");
			sb.append("                            AND accf.reqnf_numero(+) = rnf.numero ");
			sb.append("                          GROUP BY rnf.for_codigo ");
			sb.append("                                  ,rnf.fen_seq ");
			sb.append("                                  ,pck_fornecedor.get_nome(rnf.for_codigo) ");
			sb.append("                                  ,ns.fil_filial ");
			sb.append("                                  ,ns.nfs_nmro ");
			sb.append("                                  ,ns.nfs_serie ");
			sb.append("                                  ,ns.nfs_dtemis ");
			sb.append("                                  ,IREQ.ITEST_CODIGO ");
			sb.append("                                  ,DECODE(1, 1, accf.descricao) ");
			sb.append("                                  ,accf.valor_unitario ");
			sb.append("                         HAVING SUM(NVL(accf.valor_total, 0)) > 0) qry ");
			sb.append("                       ,(SELECT DISTINCT n.nfs_nmro ");
			sb.append("                           FROM atelier_pre_envio                  a ");
			sb.append("                               ,cpr.dom_item_ordem_item_requisicao i ");
			sb.append("                               ,atelier_rem_taloes_oc              o ");
			sb.append("                               ,fat.notas_fiscais_saida_requis     n ");
			sb.append("     WHERE a.fil_filial = '").append(filial).append("' ");
			sb.append("       AND a.for_codigo = ").append((String) session.getAttribute("pse0053_fornecedor"));
			sb.append("        and a.pro_numero = ").append(processo);
			sb.append("       AND a.data_pre_envio >= to_date('").append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("       AND a.data_pre_envio < to_date('").append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("       AND a.rem_nro = o.aroc_rem_nro  ");
			sb.append("       AND a.tal_nro = o.tal_nro ");
			sb.append("       AND a.pro_numero = o.pro_numero ");
			sb.append("       AND a.for_codigo = o.for_codigo ");
			sb.append("       AND o.aroc_oco_numero = i.oco_numero ");
			sb.append("       AND (('").append((String) session.getAttribute("pse0053_tipo")).append("' = 'E' AND (a.status = 'E' AND NVL(A.status_consiste_atelier, '1') <> 'C' AND ");
			sb.append("            a.status_retorno IS NULL)) OR ");
			sb.append("            ('").append((String) session.getAttribute("pse0053_tipo")).append("' = 'R' AND NVL(a.status_consiste_atelier, '1') = 'C' AND a.status_retorno IS NULL)) ");
			sb.append("       AND i.reqnf_numero = n.reqnf_numero) notas ");
			sb.append("                  WHERE qry.nfs_nmro = notas.nfs_nmro ");
			sb.append("                    AND (qry.valor_mat_pendentes_retorno > 0))) ");
			sb.append(" union all ");
			sb.append(" SELECT pro_numero ");
			sb.append("       ,pro_nome ");
			sb.append("       ,quantidade_total pares ");
			sb.append("       ,valor_restante preco ");
			sb.append("       ,valor_restante total ");
			sb.append("   FROM (SELECT 18709838 pro_numero ");
			sb.append("               ,'MATERIAIS PARA INDUSTRIALIZACAO' pro_nome ");
			sb.append("               ,1 quantidade_total ");
			sb.append("               ,trunc(SUM(pares * preco), 2) valor_total ");
			sb.append("               ,trunc(SUM(pares * preco) / SUM(pares), 2) valor_medio ");
			sb.append("               ,trunc(SUM(pares) * trunc(SUM(pares * preco) / SUM(pares), 2), 2) valor_parcial ");
			sb.append("               ,trunc(SUM(pares * preco), 2) - trunc(SUM(pares) * trunc(SUM(pares * preco) / SUM(pares), 2), 2) valor_restante ");
			sb.append("           FROM (SELECT pro_numero ");
			sb.append("                       ,descr_material              pro_nome ");
			sb.append("                       ,qtd_mat_pendentes_retorno   pares ");
			sb.append("                       ,preco ");
			sb.append("                       ,valor_mat_pendentes_retorno total ");
			sb.append("                   FROM (SELECT rnf.for_codigo ");
			sb.append("                               ,ns.nfs_nmro ");
			sb.append("                               ,decode(1, 1, accf.descricao) descr_material ");
			sb.append("                               ,IREQ.ITEST_CODIGO pro_numero ");
			sb.append("                               ,ACCF.VALOR_UNITARIO preco ");
			sb.append("                               ,SUM(NVL(DECODE(accf.retornar_valor, 'S', (SELECT CASE ");
			sb.append("                                                          WHEN (accfv.reqnf_numero > ");
			sb.append("                                                               1255482) THEN ");
			sb.append("                                                           ROUND(accfv.quantidade_pendente, 2) ");
			sb.append("                                                          ELSE ");
			sb.append("                                                           TRUNC(accfv.quantidade_pendente, 2) ");
			sb.append("                                                        END ");
			sb.append("                                                   FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                                                  WHERE accfv.id_lancamento_cc = ");
			sb.append("                                                        accf.id_lancamento_cc)), 0)) qtd_mat_pendentes_retorno ");
			sb.append("                               ,SUM(NVL(DECODE(accf.retornar_valor, 'S', (SELECT CASE ");
			sb.append("                                                          WHEN (accfv.reqnf_numero > ");
			sb.append("                                                               1255482) THEN ");
			sb.append("                                                           ROUND(accfv.quantidade_pendente * ");
			sb.append("                                                                 accfv.valor_unitario, 2) ");
			sb.append("                                                          ELSE ");
			sb.append("                                                           TRUNC(accfv.quantidade_pendente * ");
			sb.append("                                                                 accfv.valor_unitario, 2) ");
			sb.append("                                                        END ");
			sb.append("                                                   FROM atelier_conta_corrente_forn_v accfv ");
			sb.append("                                                  WHERE accfv.id_lancamento_cc = ");
			sb.append("                                                        accf.id_lancamento_cc)), 0)) valor_mat_pendentes_retorno ");
			sb.append("                           FROM requisicoes_notas_fiscais rnf ");
			sb.append("                               ,notas_fiscais_saida_requis nfsr ");
			sb.append("                               ,FAT.ITENS_REQ_NOTAS_FISCAIS ireq ");
			sb.append("                               ,nf_saida ns ");
			sb.append("                               ,(SELECT accf.* ");
			sb.append("                                   FROM atelier_conta_corrente_fornec accf ");
			sb.append("                                  WHERE accf.operacao = ");
			sb.append("                                        pck_atelier.get_operacao_envio ");
			sb.append("                                    AND accf.natureza_lancamento = ");
			sb.append("                                        pck_atelier.get_natureza_materia_prima) accf ");
			sb.append("             			 WHERE rnf.data_requisicao >= to_date('").append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("		    				   AND rnf.data_requisicao < to_date('").append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("   				           AND NVL(rnf.emp_empresa, NULL) = NVL('01', rnf.emp_empresa) ");
			sb.append("      				       AND NVL(rnf.fil_filial, NULL) = NVL('").append(filial).append("', rnf.fil_filial) ");
			sb.append("         				   AND NVL(rnf.for_codigo, NULL) = NVL(").append((String) session.getAttribute("pse0053_fornecedor")).append(", rnf.for_codigo) ");
			sb.append("                            AND NVL(rnf.fen_seq, NULL) = NVL(1, rnf.fen_seq) ");
			sb.append("                            AND NVL(rnf.stat_codigo, NULL) IN ");
			sb.append("                                (pck_requisicao_nota_fiscal.get_status_digitada, pck_requisicao_nota_fiscal.get_status_faturada) ");
			sb.append("                            AND nfsr.reqnf_numero = rnf.numero ");
			sb.append("                            AND ns.emp_empresa = nfsr.emp_empresa ");
			sb.append("                            AND ns.fil_filial = nfsr.fil_filial ");
			sb.append("                            AND ns.nfs_nmro = nfsr.nfs_nmro ");
			sb.append("                            AND ns.nfs_serie = nfsr.nfs_serie ");
			sb.append("                            AND RNF.NUMERO = IREQ.REQNF_NUMERO ");
			sb.append("                            AND ACCF.REQNF_NUMERO = ireq.reqnf_numero ");
			sb.append("                            AND ACCF.ITEREQNF_SEQUENCIA = IREQ.SEQUENCIA ");
			sb.append("                            AND NVL(ns.stat_codigo, NULL) IN ");
			sb.append("                                (pck_nf_saida.get_status_emitida) ");
			sb.append("                            AND accf.reqnf_numero(+) = rnf.numero ");
			sb.append("                          GROUP BY rnf.for_codigo ");
			sb.append("                                  ,rnf.fen_seq ");
			sb.append("                                  ,pck_fornecedor.get_nome(rnf.for_codigo) ");
			sb.append("                                  ,ns.fil_filial ");
			sb.append("                                  ,ns.nfs_nmro ");
			sb.append("                                  ,ns.nfs_serie ");
			sb.append("                                  ,ns.nfs_dtemis ");
			sb.append("                                  ,IREQ.ITEST_CODIGO ");
			sb.append("                                  ,DECODE(1, 1, accf.descricao) ");
			sb.append("                                  ,accf.valor_unitario ");
			sb.append("                         HAVING SUM(NVL(accf.valor_total, 0)) > 0) qry ");
			sb.append("                       ,(SELECT DISTINCT n.nfs_nmro ");
			sb.append("                           FROM atelier_pre_envio                  a ");
			sb.append("                               ,cpr.dom_item_ordem_item_requisicao i ");
			sb.append("                               ,atelier_rem_taloes_oc              o ");
			sb.append("                               ,fat.notas_fiscais_saida_requis     n ");
			sb.append("     WHERE a.fil_filial = '").append(filial).append("' ");
			sb.append("       AND a.for_codigo = ").append((String) session.getAttribute("pse0053_fornecedor"));
			sb.append("       and a.pro_numero = ").append(processo);
			sb.append("       AND a.data_pre_envio >= to_date('").append((String) session.getAttribute("pse0053_dt_inicial")).append("', 'dd/mm/yyyy') ");
			sb.append("       AND a.data_pre_envio < to_date('").append((String) session.getAttribute("pse0053_dt_final")).append("', 'dd/mm/yyyy') + 1 ");
			sb.append("       AND a.rem_nro = o.aroc_rem_nro  ");
			sb.append("       AND a.tal_nro = o.tal_nro ");
			sb.append("       AND a.pro_numero = o.pro_numero ");
			sb.append("       AND a.for_codigo = o.for_codigo ");
			sb.append("       AND o.aroc_oco_numero = i.oco_numero ");
			sb.append("       AND (('").append((String) session.getAttribute("pse0053_tipo")).append("' = 'E' AND (a.status = 'E' AND NVL(A.status_consiste_atelier, '1') <> 'C' AND ");
			sb.append("            a.status_retorno IS NULL)) OR ");
			sb.append("            ('").append((String) session.getAttribute("pse0053_tipo")).append("' = 'R' AND NVL(a.status_consiste_atelier, '1') = 'C' AND a.status_retorno IS NULL)) ");
			sb.append("       AND i.reqnf_numero = n.reqnf_numero) notas ");
			sb.append("                  WHERE qry.nfs_nmro = notas.nfs_nmro ");
			sb.append("                    AND (qry.valor_mat_pendentes_retorno > 0)) ");
			sb.append("                 having trunc(SUM(pares * preco), 2) - trunc(SUM(pares) * trunc(SUM(pares * preco) / SUM(pares), 2), 2) > 0) ");

			Vector<?> res_Jw_pse0053_total_fechado_itens = j.select(table_fechado, sb.toString(), null);
			return res_Jw_pse0053_total_fechado_itens;
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

}