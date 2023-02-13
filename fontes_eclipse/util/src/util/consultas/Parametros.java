package util.consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Parametros {

	public String retornaParametro(String nome) throws SQLException {
		
		String realPath = System.getProperty("realpathbrportal");
		StringBuilder retorno = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(
					new StringBuilder(" SELECT valor ")
							  .append("   FROM wbrio.parametros ")
							  .append("  WHERE nome = ? ")
							  .append("    AND par_sist_codigo = 'BRNET'").toString());
			pstm.setString(1, nome);
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno.append(rset.getString(1).replace("<real_path>",	realPath));
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
				j = null;
			}
		}
		return retorno.toString();
	}
	
	public String retornaParametro(String nome, String valor) throws SQLException {
		String realPath = System.getProperty("realpathbrportal");
		StringBuilder retorno = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(
					new StringBuilder(" SELECT valor ")
							  .append("   FROM wbrio.parametros ")
							  .append("  WHERE nome = ? ")
							  .append("    AND valor = ? ")
							  .append("    AND par_sist_codigo = 'BRNET'").toString());
			pstm.setString(1, nome);
			pstm.setString(2, valor);
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno.append(rset.getString(1).replace("<real_path>",	realPath));
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
				j = null;
			}
		}
		return retorno.toString();
	}
}
