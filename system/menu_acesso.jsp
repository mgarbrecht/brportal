<%@ page import="acesso.*, java.sql.*, util.rdb.ConnectionJDBC" %>
<%@ page extends="acesso.web.HttpJspSessao"%>
<%@ page errorPage="/err/errorpage.jsp"%>
<%
    Connection conn = null;
    try {
		conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");    
		%>
		<jsp:useBean id="treeMenu" scope="request" class="acesso.web.TreeMenuBean">
			<jsp:setProperty name="treeMenu" property="connection" value="<%= conn %>" />
			<jsp:setProperty name="treeMenu" property="contextPath" value="<%= request.getContextPath() %>" />
		</jsp:useBean>
		<%=treeMenu %> 
<%
   } finally {
        conn.close();
   }
%>
