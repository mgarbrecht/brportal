package util.consultas.adm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MaioresClientesVencidos {

	public double getValor(String cliente, String seq, String dias)
			throws Exception {
		double retorno = 0;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder query = new StringBuilder();
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			query.append(" SELECT sum(wtv.valor) valor  ");
			query.append("   FROM (SELECT t.cli_codigo codigo_cliente ");
			query.append("              , t.esc_seqn sequencial ");
			query.append("              , t.rep_codigo rep_cdgo ");
			query.append("              , t.rev_codigo_regional codigo_regional ");
			query.append("              , lpad(round(round(((trunc(sysdate)) - min(trunc(t.tit_datvenc))))),5,' ') dias ");
			query.append("              , sum(fnc_ctr_saldo_negociacao( t.emp_empresa ");
			query.append("                                            , t.fil_filial ");
			query.append("                                            , t.tip_codigo ");
			query.append("                                            , t.tit_codigo ");
			query.append("                                            , t.sit_codigo_situacao_titulo ");
			query.append("                                            , t.tit_vlpcp ");
			query.append("                                            , t.tit_vldeb )) valor ");
			query.append("           FROM titulos t ");
			query.append("          WHERE tit_status = 'A' ");
			query.append("            AND t.emp_empresa = '01' ");
			query.append("            AND nvl(t.tip_codigo, null) IN ( SELECT tit_gru.tip_codigo ");
			query.append("                                               FROM tipos_de_titulo_por_grupo tit_gru ");
			query.append("                                              WHERE tit_gru.gtt_codigo_grupo_tipo_titulo = 4) ");
			query.append("            AND t.tit_datvenc < TRUNC(SYSDATE - ").append(dias).append(") ");
			query.append("            AND t.tipo_de_mercado = 'MI' ");
			query.append("            AND (t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo) NOT IN ( SELECT m.emp_empresa, ");
			query.append("                          m.fil_filial, ");
			query.append("                        m.tip_codigo, ");
			query.append("                        m.tit_codigo ");
			query.append("                   FROM mov_receber m ");
			query.append("                  WHERE m.emp_empresa = t.emp_empresa ");
			query.append("                    AND m.fil_filial = t.fil_filial ");
			query.append("                    AND m.tip_codigo = t.tip_codigo ");
			query.append("                    AND m.tit_codigo = t.tit_codigo ");
			query.append("                    AND m.trn_codigo IN (SELECT trn_gru.trn_codigo ");
			query.append("                                           FROM transacoes_por_grupo trn_gru ");
			query.append("                                          WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
			query.append("                                            AND data_inicial <= SYSDATE ");
			query.append("                                            AND NVL(data_final, SYSDATE) >= SYSDATE) ");
			query.append("                    AND NVL(m.mov_sequencia, 0) = 0 ");
			query.append("                    AND m.mov_data <= TRUNC(SYSDATE - ").append(dias).append(") ");
			query.append("                    AND ROWNUM = 1) ");
			query.append("          GROUP BY t.cli_codigo ");
			query.append("                 , t.esc_seqn ");
			query.append("                 , t.rep_codigo ");
			query.append("                 , t.rev_codigo_regional ");
			query.append("          UNION ");
			query.append("         SELECT c.cli_cdgo codigo_cliente ");
			query.append("              , seq.sequencial sequencial ");
			query.append("              , r.rep_cdgo ");
			query.append("              , r.codigo_regional ");
			query.append("              , lpad(trunc(((sysdate) - min(c.data_de_deposito))), 5, ' ') dias ");
			query.append("              , sum(c.valor_do_cheque - nvl(c.valor_recebido, 0)) valor ");
			query.append("           FROM brconrec.cheques c ");
			query.append("              , cli ");
			query.append("              , rep r ");
			query.append("              , gerentes_regionais_vendas g ");
			query.append("              , (SELECT min(ecl.esc_seqn) sequencial ");
			query.append("                      , ecl.cli_cdgo ");
			query.append("                   FROM ecl ecl ");
			query.append("                  WHERE ecl.ned_cdgo IN ('UNI', 'COB') ");
			query.append("                  GROUP BY ecl.cli_cdgo) seq ");
			query.append("          WHERE c.sit_codigo_situacao_titulo IN ('4') ");
			query.append("            AND seq.cli_cdgo = cli.cli_cdgo ");
			query.append("            AND nvl(c.tip_codigo, null) IN ('CH1', 'CH2') ");
			query.append("            AND r.rep_cdgo = c.rep_cdgo ");
			query.append("            AND g.codigo_gerente = r.rep_gerente_antigo ");
			query.append("            AND cli.cli_cdgo = c.cli_cdgo ");
			query.append("            AND nvl(cli.cli_tipo_mercado, 'MI') = 'MI' ");
			query.append("            AND r.codigo_regional = nvl(null, r.codigo_regional) ");
			query.append("            AND c.data_de_deposito < trunc(sysdate - ").append(dias).append(") ");
			query.append("            AND (c.emp_empresa, c.fil_filial, c.tip_codigo, c.cli_cdgo, ");
			query.append("                 c.prt_codigo_banco, c.age_codigo, c.numero_do_cheque) NOT IN ");
			query.append("                (SELECT m.emp_empresa ");
			query.append("                      , m.fil_filial ");
			query.append("                      , m.tip_codigo ");
			query.append("                      , m.cli_cdgo ");
			query.append("                      , m.prt_codigo_banco ");
			query.append("                      , m.age_codigo ");
			query.append("                      , m.che_numero_do_cheque ");
			query.append("                   FROM movimentos_cheque m ");
			query.append("                  WHERE m.emp_empresa = c.emp_empresa ");
			query.append("                    AND m.fil_filial = c.fil_filial ");
			query.append("                    AND m.tip_codigo = c.tip_codigo ");
			query.append("                    AND m.cli_cdgo = c.cli_cdgo ");
			query.append("                    AND m.prt_codigo_banco = c.prt_codigo_banco ");
			query.append("                    AND m.age_codigo = c.age_codigo ");
			query.append("                    AND m.che_numero_do_cheque = c.numero_do_cheque ");
			query.append("                    AND m.trn_codigo IN (SELECT trn_gru.trn_codigo ");
			query.append("                                           FROM transacoes_por_grupo trn_gru ");
			query.append("                                          WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
			query.append("                                            AND data_inicial <= sysdate ");
			query.append("                                            AND nvl(data_final, sysdate) >= sysdate) ");
			query.append("                    AND m.data_do_movimento <= trunc(sysdate) ");
			query.append("                    AND nvl(m.moc_sequencia, 0) = 0 ");
			query.append("                    AND rownum = 1) ");
			query.append("          GROUP BY c.cli_cdgo ");
			query.append("                 , seq.sequencial ");
			query.append("                 , r.rep_cdgo ");
			query.append("                 , r.codigo_regional ");
			query.append("          UNION ");
			query.append("         SELECT che.cli_cdgo codigo_cliente, ");
			query.append("                seq.sequencial sequencial, ");
			query.append("                che.rep_cdgo, ");
			query.append("                rep.codigo_regional, ");
			query.append("                lpad(round(((sysdate + 1) - min(che.data_de_deposito))),5, ' ') dias, ");
			query.append("                (sum(mov.valor_principal) - sum(nvl(che.che_vlpcp, 0)) - sum(nvl(che.che_VLDEB, 0))) valor ");
			query.append("           FROM brconrec.cheques che, ");
			query.append("                rep rep, ");
			query.append("                movimentos_cheque mov, ");
			query.append("                (SELECT min(ecl.esc_seqn) sequencial, ecl.cli_cdgo ");
			query.append("                   FROM ecl ecl ");
			query.append("                  WHERE ecl.ned_cdgo IN ('UNI', 'COB') ");
			query.append("                  GROUP BY ecl.cli_cdgo) seq ");
			query.append("          WHERE che.emp_empresa = mov.emp_empresa ");
			query.append("            AND mov.cli_cdgo = seq.cli_cdgo ");
			query.append("            AND che.fil_filial = mov.fil_filial ");
			query.append("            AND che.tip_codigo = mov.tip_codigo ");
			query.append("            AND che.cli_cdgo = mov.cli_cdgo ");
			query.append("            AND che.prt_codigo_banco = mov.prt_codigo_banco ");
			query.append("            AND che.age_codigo = mov.age_codigo ");
			query.append("            AND che.numero_do_cheque = mov.che_numero_do_cheque ");
			query.append("            AND rep.rep_cdgo = che.rep_cdgo ");
			query.append("            AND che.emp_empresa = '01' ");
			query.append("            AND che.sit_codigo_situacao_titulo = '7' ");
			query.append("            AND che.data_de_deposito < trunc(sysdate - ").append(dias).append(") ");
			query.append("            AND mov.trn_codigo = 'CLD' ");
			query.append("            AND trunc(mov.data_do_movimento) >= to_date('01/01/2000', 'DD/MM/YYYY') ");
			query.append("            AND NOT EXISTS ( SELECT '1' ");
			query.append("                               FROM movimentos_cheque m ");
			query.append("                              WHERE m.emp_empresa = che.emp_empresa ");
			query.append("                                AND m.fil_filial = che.fil_filial ");
			query.append("                                AND m.tip_codigo = che.tip_codigo ");
			query.append("                                AND m.cli_cdgo = che.cli_cdgo ");
			query.append("                                AND m.prt_codigo_banco = che.prt_codigo_banco ");
			query.append("                                AND m.age_codigo = che.age_codigo ");
			query.append("                                AND m.che_numero_do_cheque = che.numero_do_cheque ");
			query.append("                                AND m.trn_codigo IN ( SELECT trn_gru.trn_codigo ");
			query.append("                                                        FROM transacoes_por_grupo trn_gru ");
			query.append("                                                       WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
			query.append("                                                         AND data_inicial <= sysdate ");
			query.append("                                                         AND nvl(data_final, sysdate) >= sysdate ) ");
			query.append("                                AND m.data_do_movimento <= trunc(sysdate) ");
			query.append("                                AND nvl(m.moc_sequencia, 0) = 0 ");
			query.append("                                AND rownum = 1) ");
			query.append("          GROUP BY che.cli_cdgo, che.che_vlpcp, che.che_vldeb, seq.sequencial, che.rep_cdgo, rep.codigo_regional) wtv, ");
			query.append("        cli cli, ");
			query.append("        ecl ecl ");
			query.append("  WHERE wtv.codigo_cliente = ecl.cli_cdgo ");
			query.append("    AND wtv.sequencial     = decode(ecl.esc_seqn, 0, 1, ecl.esc_seqn) ");
			query.append("    AND ecl.cli_cdgo       = cli.cli_cdgo ");
			query.append("    and wtv.codigo_cliente = ").append(cliente);
			query.append("    and wtv.sequencial     = ").append(seq);
			query.append("    AND ecl.ned_cdgo       IN ('UNI', 'COB') ");
			query.append("  GROUP BY wtv.codigo_cliente ");
			query.append("         , sequencial ");

			pstm = j.getConn().prepareStatement(query.toString());
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno = rset.getDouble(1);
			}
		} catch (Exception e) {
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
		return retorno;
	}

}
