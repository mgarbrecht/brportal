package acesso.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
public class Filtro implements Filter  {
   public void  init(FilterConfig config) throws ServletException{
 
   }
   public void  doFilter(ServletRequest request, 
                 ServletResponse response,
                 FilterChain chain) 
                 throws java.io.IOException, ServletException {

	   HttpServletRequest req = (HttpServletRequest) request;
	   HttpSession ses = req.getSession();
	   if (ses.getAttribute("User") == null) {
			String sURL = req.getRequestURL().toString();
			int iHost = sURL.indexOf("/", 7);
			if (iHost > 6) {				
			} else {
			}
			ses.setAttribute("URL", sURL);
		}
	   
      chain.doFilter(request,response);
   }
   public void destroy( ){
   }
}