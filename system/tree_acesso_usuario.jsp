<%@ page import="acesso.*, java.sql.*, util.rdb.ConnectionJDBC" %>
<%@ page extends="acesso.web.HttpJspSessao"%>
<%@ page errorPage="/err/errorpage.jsp"%>

<%
//------------------------------------------------
      java.util.Locale locale = null;
      if(session.getAttribute("locale1")==null){
         locale = new java.util.Locale("pt","BR");
      } else {
	     locale = new java.util.Locale((String)session.getAttribute("locale1"),(String)session.getAttribute("locale2"));
	  }
      java.util.Locale.setDefault(locale);
      session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
//------------------------------------------------	
    Connection conn = null;
    try {
		conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
%>
		<jsp:useBean id="treeMenuUsuario" scope="page" class="acesso.web.TreeMenuUsuarioBean">
			<jsp:setProperty name="treeMenuUsuario" property="connection" value="<%= conn %>" />
			<jsp:setProperty name="treeMenuUsuario" property="contextPath" value="<%= request.getContextPath() %>" />
			<jsp:setProperty name="treeMenuUsuario" property="usuario" value="<%= (Usuario) session.getAttribute("User") %>" />
			<jsp:setProperty name="treeMenuUsuario" property="locale" value="<%= locale %>" />
		</jsp:useBean>
		<%= treeMenuUsuario %> 
		<%
        if((((String)session.getAttribute("abre_menu"))+"").equals("s")){
		%>
		   <script>d.openAll();</script>
		<%
		session.removeAttribute("abre_menu");
		}
		%>
		            
<%
   } finally {
		if(conn!=null){
			conn.close();
			conn = null;
		}
   }
%>
