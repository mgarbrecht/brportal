package acesso.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class HttpServletSessao extends HttpServlet implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	protected final void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
		HttpSession ses = req.getSession();
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
		}
		else if (req.getMethod().equals("GET")) doGet(req, res);
		else if (req.getMethod().equals("POST")) doPost(req, res);
		return;
	}
}