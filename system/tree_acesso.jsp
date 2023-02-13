<%@ page import="acesso.*, java.sql.*, util.rdb.ConnectionJDBC" %>
<%@ page extends="acesso.web.HttpJspSessao"%>
<%@ page errorPage="/err/errorpage.jsp"%>
<%
    Connection conn = null;
    try {
		conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
		%>
		<jsp:useBean id="treeAcesso" scope="session" class="acesso.web.TreeAcessoBean">
			<jsp:setProperty name="treeAcesso" property="connection" value="<%= conn %>" />
			<jsp:setProperty name="treeAcesso" property="contextPath" value="<%= request.getContextPath() %>" />
		</jsp:useBean>
		<%= treeAcesso.getOut() %>
		<%
   } finally {
		if(conn!=null){
			conn.close();
			conn = null;
		}
   }
%>