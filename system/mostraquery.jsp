<%
if(((String)session.getAttribute("mostraquery")+"").equals("S")) {
	session.setAttribute("mostraquery","N");
} else {
	session.setAttribute("mostraquery","S");
}
%>
<script>
	top.location = '<%= request.getParameter("tela") %>';
</script>
