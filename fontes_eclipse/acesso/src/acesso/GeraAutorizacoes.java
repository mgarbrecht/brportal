package acesso;

import java.sql.*;
import util.rdb.ConnectionJDBC;

public class GeraAutorizacoes {

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select doin_id from documentos_interfaces");
			if (rset.next()) {
				AcessoDocumentoInterfaceAPI acdi = new AcessoDocumentoInterfaceAPI(conn);
				do acdi.geraAutorizacoes(rset.getInt(1));
				while (rset.next());
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			conn.commit();
			conn.close();
		}
		System.exit(0);
	}
}