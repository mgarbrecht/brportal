package util.consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sequence {

    public int nextValue(String tabela, String campo){
    	int proximoValor = 0;
		PreparedStatement pstm = null;
		ResultSet rset = null;    	
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
        	StringBuilder query = new StringBuilder();
      	  	query.append(" SELECT MAX(proximoquebrado) proximoquebrado, MAX(proximonormal) proximonormal ");
            query.append("   FROM (SELECT TO_NUMBER(proximo) proximoquebrado, NULL proximonormal ");
            query.append("   FROM (SELECT proximo ");
            query.append("           FROM (SELECT LEVEL proximo ");
            query.append("                   FROM dual ");
            query.append("                 CONNECT BY LEVEL <= (SELECT MAX(").append(campo).append(") ");
            query.append("                                        FROM ").append(tabela).append(")) ");
            query.append("         MINUS ");
            query.append("         SELECT ").append(campo);
            query.append("           FROM ").append(tabela).append(") ");
            query.append("  WHERE ROWNUM = 1 ");
            query.append(" UNION (SELECT NULL proximoquebrado, nvl(TO_NUMBER(MAX(").append(campo).append(") + 1),1) proximonormal FROM ").append(tabela).append(")) ");
			pstm = j.getConn().prepareStatement(query.toString());
			rset = pstm.executeQuery();
			if (rset.next()) {
				if(rset.getString("proximoquebrado")!=null){
					proximoValor = Integer.parseInt(rset.getString("proximoquebrado"));
				} else {
					proximoValor = Integer.parseInt(rset.getString("proximonormal"));
				}
			}            
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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
		return proximoValor;
    }

}
