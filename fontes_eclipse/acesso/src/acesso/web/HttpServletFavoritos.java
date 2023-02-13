package acesso.web;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import java.sql.*;

import acesso.*;
import util.rdb.ConnectionJDBC;

public class HttpServletFavoritos extends HttpServlet implements java.io.Serializable {
  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = null;
		HttpSession se = null;
		Connection conn = null;
		ResultSet rset = null;
		PreparedStatement pstm = null;
		try {
			out = resp.getWriter();
			se = req.getSession();
			Usuario usua = (Usuario) se.getAttribute("User");
			String doin_id = req.getParameter("doin_id");
			String action = req.getParameter("action");
			if (action.equals("add") || action.equals("del"))
				try {
					conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
					AcessoDocumentoInterfaceAPI acdi = new AcessoDocumentoInterfaceAPI(conn);
					pstm = conn.prepareStatement(
							new StringBuilder(" SELECT acdi_id ")
									  .append("   FROM acessos_documentos_interfaces ")
									  .append("  WHERE acdi_usua_id = ? ")
									  .append("    AND acdi_doin_id = ? ").toString());
					
					pstm.setInt(1, usua.getId());
					pstm.setString(2, doin_id);
					rset = pstm.executeQuery();
					if (rset.next()) {
						acdi.select(rset.getInt(1));
						acdi.setFavorito(action.equals("add"));
						acdi.update();
					}
					else if (action.equals("add")) {
						acdi.setUsuario(usua);
						acdi.setDocumentoInterface(new DocumentoInterfaceAPI(conn, Integer.parseInt(doin_id)));
						acdi.setFavorito(true);
						acdi.insert(0);
					}
					conn.commit();
					out.print("<html><body>"+java.util.ResourceBundle.getBundle("ApplicationResources").getString("header.favoritos")+"</body></html>");
				}
			catch (Exception e) {
				e.printStackTrace();
				out.print("<html><body>" + e.toString() + "</body></html>");
			}		
		} finally {
			try {
				if(rset!=null){
					rset.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstm!=null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}