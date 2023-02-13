<%@ page import="java.util.Date, java.text.SimpleDateFormat, acesso.*"%>
<%
  Date data = new Date();
  SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat fHora = new SimpleDateFormat("HH:mm:ss");
  Usuario user = (Usuario) session.getAttribute("User");
  EntidadeNegocio entidadeNegocio = user.getEntidadeNegocio();
  TipoEntidadeNegocio tipoEntidade = null;
  if (entidadeNegocio != null)
	  tipoEntidade = entidadeNegocio.getTipoEntidadeNegocio();
%>
<table width="100%">
	<tr>
		<td width="10%"><img src="<%= request.getContextPath() %>/img/lg_SA.jpg"></td>
		<td VALIGN=BOTTOM align=center>
	      <b><font color="#C40000" size=3><script>document.write(document.title);</script></font><b>
		</td>
		<td align="right" width="30%">
		<table>
			<tr>
				<th align="right"><font color="#8D0000" size=1>Data:</font></th>
				<td><font color="#8D0000" size=1><%= fData.format(data) %></font></td>
			</tr>
			<tr>
				<th align="right"><font color="#8D0000" size=1>Hora:</font></th>
				<td><font color="#8D0000" size=1><%= fHora.format(data) %></font></td>
			</tr>
			<tr>
				<th align="right"><font color="#8D0000" size=1>Usu�rio:</font></th>
				<td><font color="#8D0000" size=1><%= user.getNome() %></font></td>
			</tr>
			<% if (tipoEntidade != null) { %>
			<tr>
				<th align="right"><font color="#8D0000" size=1><%= tipoEntidade.getTipo() %>:</font></th>
				<td><font color="#8D0000" size=1><%= entidadeNegocio.getChave() %></font></td>
			</tr>
			<% } %>
		</table>
		</td>
	</tr>
</table>
<hr width="100%">
<table width="100%">
<tr align="right"><td>
<button onclick="window.open('../system/MainMenu.jsp','_self')"><img src="c:\img\menunova.png" width="54" height="16"></button><button onclick="window.open('../system/MainMenu.do?logout_action=','_self')"><img src="c:\img\logoutnova.png" width="67" height="16"></button>
</td></tr>
</table>
<hr width="100%">
<b><font color="#C40000">Per�odo de <%= (String)session.getAttribute("dt_inicial") %> at� 
                                 <%= (String)session.getAttribute("dt_final") %></font><b>