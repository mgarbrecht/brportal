package acesso.web;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.Vector;

public class HttpJspSessao extends HttpServlet implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public void _jspService(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
			throw new ServletException("Security Fail.");
	}

  	protected final void service(HttpServletRequest req, HttpServletResponse res)
  		throws IOException, ServletException {
  		HttpSession ses = req.getSession();
		if (req.getParameter("login") != null) {
			com.egen.util.jdbc.JdbcUtil j = null;
			try {
				j = new com.egen.util.jdbc.JdbcUtil();
				portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
				String[][] select = null;
				  Object[][] where = {{"usua_super","=", "S"},{"situacao","=", "A"}};
				  Vector<?> res_Usuarios = j.select(table, select, where, null, null, null);
				  if (res_Usuarios != null && res_Usuarios.size() > 0) {
					  portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
					  acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
					  usuario.select(r.getUsua_id());
   					  ses.setAttribute("User", (acesso.Usuario) usuario);
				  }
			} catch (Exception e) {
			} finally {
				if (j != null) {
					j.close();
					j = null;
				}
			}
  		}
  		if (ses.getAttribute("User") == null) {
  			String sURL = req.getRequestURL().toString();
  			int iHost = sURL.indexOf("/", 7);
  			String sHostURL;
  			if (iHost > 6) {
  				sHostURL = sURL.substring(0, iHost);
  			} else {
  				sHostURL = sURL;  
  			}
  			ses.setAttribute("URL", sURL);
  			res.sendRedirect(sHostURL + req.getContextPath() + "/acesso/login");
  		} else { 
  			_jspService(req, res);
  		}
  		return;
  	}
}
