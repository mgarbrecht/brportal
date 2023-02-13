package util.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {

	public String select(String query) throws Exception {
		StringBuilder retorno = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		j = new com.egen.util.jdbc.JdbcUtil();
		pstm = j.getConn().prepareStatement(query);
		rset = pstm.executeQuery();
		if (rset.next()) {
			retorno.append(rset.getString(1));
		}
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
		return retorno.toString();
	}

	public String retorna(String query) throws SQLException {
		StringBuilder retorno = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(query);
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno.append(rset.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return retorno.toString();
	}

	public String retorna(com.egen.util.jdbc.JdbcUtil j, String query) throws SQLException {
		StringBuilder retorno = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			pstm = j.getConn().prepareStatement(query);
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno.append(rset.getString(1));
			}
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return retorno.toString();
	}

	public String retorna(Connection con, String query) throws SQLException {
		StringBuilder retorno = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			pstm = con.prepareStatement(query);
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno.append(rset.getString(1));
			}
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return retorno.toString();
	}

	public void execute(String query) throws Exception {
		PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(query);
			pstm.execute();
		} finally {
			if (pstm != null) {
				pstm.close();
			}
			if (j != null) {
				j.close();
			}
		}
	}

	public void execute(com.egen.util.jdbc.JdbcUtil j, String query) throws Exception {
		PreparedStatement pstm = null;
		try {
			pstm = j.getConn().prepareStatement(query);
			pstm.execute();
		} finally {
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void execute(Connection con, String query) throws Exception {
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement(query);
			pstm.execute();
		} finally {
			if (pstm != null) {
				pstm.close();
			}
		}
	}

}
