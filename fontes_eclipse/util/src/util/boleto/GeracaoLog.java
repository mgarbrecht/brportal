package util.boleto;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class GeracaoLog {

	public void gerar(HttpServletRequest req, String empresa, String filial,
			String tipCodigo, String titCodigo, String dataVencimento,
			String prtCodigo, String valor) throws SQLException {

		com.egen.util.jdbc.JdbcUtil j = null;
		acesso.Sessao sessao = new acesso.Sessao(req.getSession());
		java.sql.CallableStatement call = null;
		java.sql.CallableStatement call2 = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
		call = j.getConn().prepareCall("{ call pck_ctr_gera_trn_tit.prc_ctr_ins_mov_tit(?,?,?,?,'OBS',sysdate,to_date(?,'dd/mm/yyyy'),?,?,'N',null,?,null,null,null,null,null,sysdate,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,null,null,null,null,null,null,null,?)	 }");
		call.registerOutParameter(9, java.sql.Types.VARCHAR);
		call.setString(1, empresa);
		call.setString(2, filial);
		call.setString(3, tipCodigo);
		call.setString(4, titCodigo);
		call.setString(5, dataVencimento);
		call.setDouble(6, com.egen.util.text.FormatNumber.toDouble(valor));
		call.setString(7, "BRCONREC");
		call.setString(8, prtCodigo);
		call.execute();
		call.getString(9);
		call.close();
		util.consultas.Query query = new util.consultas.Query();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT sequencia ");
		sb.append("   FROM mov_receber ");
		sb.append("  WHERE emp_empresa = '").append(empresa).append("'");
		sb.append("    AND fil_filial  = '").append(filial).append("' ");
		sb.append("    AND tip_codigo  = '").append(tipCodigo).append("' ");
		sb.append("    AND tit_codigo  = '").append(titCodigo).append("' ");
		sb.append("    AND mov_data    = trunc(sysdate) ");
		int sequencia = Integer.parseInt(query.retorna(sb.toString()));

		StringBuilder sbc = new StringBuilder();
		sbc.append(" SELECT cli_codigo ");
		sbc.append("   FROM titulos ");
		sbc.append("  WHERE emp_empresa = '").append(empresa).append("' ");
		sbc.append("    AND fil_filial  = '").append(filial).append("' ");
		sbc.append("    AND tip_codigo  = '").append(tipCodigo).append("' ");
		sbc.append("    AND tit_codigo  = '").append(titCodigo).append("' ");
		int cli_cdgo = Integer.parseInt(query.retorna(sbc.toString()));

		StringBuilder sbs = new StringBuilder();
		sbs.append(" SELECT esc_seqn");
		sbs.append("   FROM titulos ");
		sbs.append("  WHERE emp_empresa = '").append(empresa).append("' ");
		sbs.append("    AND fil_filial  = '").append(filial).append("' ");
		sbs.append("    AND tip_codigo  = '").append(tipCodigo).append("' ");
		sbs.append("    AND tit_codigo  = '").append(titCodigo).append("' ");
		int esc_seqn = Integer.parseInt(query.retorna(sbs.toString()));

		StringBuilder sbd = new StringBuilder();
		sbd.append(" SELECT 'Gerado via link BRPortal / ' || DECODE(t.tien_tipo, NULL, '', ('Tipo: ' || t.tien_tipo || ' (' || e.enne_descricao || ')')) || ' / Usuário: ' || u.usua_usuario || ' / Código: ' || e.enne_chave ");
		sbd.append("   FROM wbrio.tipos_entidade_negocio t ");
		sbd.append("      , wbrio.entidades_negocio e ");
		sbd.append("      , wbrio.usuarios u ");
		sbd.append("  WHERE t.tien_id(+) = e.enne_tien_id ");
		sbd.append("    AND e.enne_id(+) = u.usua_enne_id ");
		sbd.append("    AND u.usua_usuario = '").append(sessao.getUsuario()).append("' ");
		String descricao = query.retorna(sbd.toString());

		call2 = j.getConn().prepareCall("{ call pck_ctr_gera_trn_tit.prc_ctr_ins_observa(?,?,?,?,'OBS',sysdate,?,?,?,?,?,54,?) }");
		call2.registerOutParameter(10, java.sql.Types.VARCHAR);
		call2.setString(1, empresa);
		call2.setString(2, filial);
		call2.setString(3, tipCodigo);
		call2.setString(4, titCodigo);
		call2.setInt(5, sequencia);
		call2.setInt(6, cli_cdgo);
		call2.setInt(7, esc_seqn);
		call2.setDouble(8, com.egen.util.text.FormatNumber.toDouble(valor));
		call2.setString(9, descricao);
		call2.execute();
		call2.getString(10);
		call2.close();
		j.close();
	}
}
 