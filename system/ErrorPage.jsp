<%@ include file="../system/HeaderStrutsForm.jsp" %>
<%@ page isErrorPage="true" %> 
<html><head>
<title><bean:message key="page.title"/></title>
<bean:message key="page.css"/>
<bean:message key="page.script"/>
</head>
<center><body>
<table  class="mainTable" style='width:99%;'>
<tr><td>
<table class="headerTable" style='width:99%'><tr><td><div class='div10'><%= com.egen.util.text.FormatDate.getTimestamp() %></div></td></tr></table>
<table class="bannerTable" style='width:99%;'><tr><td class=portlet_bar><b><bean:message key="errors.page"/></b></td></tr></table>
<% if (request.getAttribute("javax.servlet.error.status_code")!=null) { %>
<table border=0 style=width:99%;margin-top:10;><tr><td style=font-size:12px;>
<table border=1 style=width:99%;margin-top:10;>
<tr><td><bean:message key="jsp.error"/>:</td>
<td style="text-align:center">
<%= request.getAttribute("javax.servlet.error.status_code")%>
</td></tr>
<% if (request.getAttribute("javax.servlet.error.message")!=null) { %>
<tr><td>Message:</td>
<td style="text-align:center">
<%= request.getAttribute("javax.servlet.error.message")%>
</td></tr>
<% } %>
<% if (request.getAttribute("javax.servlet.error.servlet_name")!=null) { %>
<tr><td>Servlet Name:</td>
<td style="text-align:center">
<%= request.getAttribute("javax.servlet.error.servlet_name")%>
</td></tr>
<% } %>
<% if (request.getAttribute("javax.servlet.error.exception_type")!=null) { %>
<tr><td>Exception Type:</td>
<td style="text-align:center">
<%= request.getAttribute("javax.servlet.error.exception_type")%>
</td></tr>
<% } %>
<% if (request.getAttribute("javax.servlet.error.exception")!=null) { %>
<tr><td><bean:message key="jsp.exception"/>:</td>
<td style="text-align:center">
<%= request.getAttribute("javax.servlet.error.exception")%>
</td></tr>
<% } %>
</table>
</td></tr></table>
<% } %>

<% String exception_local = (String)session.getAttribute("exception");
   if (exception_local!=null) {
      %>
<table style=width:99%;margin-top:10;><tr><td style=font-size:12px;>
      <%= exception_local %>
</td></tr></table>
      <%
   }
%>
<table style=width:99%;><tr><td style=border-color:black;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;text-align:center;></td></tr></table>
</body></html>