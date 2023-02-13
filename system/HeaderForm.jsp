<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, acesso.*"%>
<%
//------------------------------------------------
      java.util.Locale locale = null;
      if(session.getAttribute("locale1")==null){
         locale = new java.util.Locale("pt","BR");
      } else {
	     locale = new java.util.Locale((String)session.getAttribute("locale1"),(String)session.getAttribute("locale2"));
	  }
      Locale.setDefault(locale);
      session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
//------------------------------------------------	
  portalbr.system.HeaderActionForm HeaderActionForm = (portalbr.system.HeaderActionForm)session.getAttribute("HeaderActionForm");
  Date data = new Date();
  SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat fHora = new SimpleDateFormat("HH:mm:ss");
  Usuario user = (Usuario) session.getAttribute("User");
  EntidadeNegocio entidadeNegocio = user.getEntidadeNegocio();
  TipoEntidadeNegocio tipoEntidade = null;
  if (entidadeNegocio != null)
	  tipoEntidade = entidadeNegocio.getTipoEntidadeNegocio();
	
  String x="647px";  
  String y="120px";
%>
<link rel=stylesheet href="../style.css" type=text/css>
<html>
  <head>
    <title>
      <bean:message key="page.title"/>
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>

<table width="100%">
	<tr> 
		<td width="10%"><img src="<%= request.getContextPath() %>/img/lg_SA.jpg">
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
				<th align="right"><font color="#8D0000" size=1>Usuário:</font></th>
				<td><font color="#8D0000" size=1><%= user.getNome() %></font></td>
			</tr>
			<% if (tipoEntidade != null) { %>
			<tr>
				<th align="right"><font color="#8D0000" size=1><%= tipoEntidade.getTipo() %>:</font></th>
				<td><font color="#8D0000" size=1><%= entidadeNegocio.getChave() %></font></td>
			</tr>
			<% } %>
                 
        </tr>
		</table>
</table> 
<table width="100%" background-color="#CC2E2B";>
<tr><td style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
<tr><td style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;></td></tr>
<tr><td style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
<tr align="right"><td>
<button onclick="document.forms[0].blank_action.click();" style="background-color:#d0c4d8;cursor:hand;" value="Favoritos"><img src="c:/43.gif" height="16"><font color="#000000" style="font-family:Arial,Verdana;" ><b> Favoritos</b></font></button>
<button style="background-color:#d0c4d8;cursor:hand;" onclick="top.location.href='../system/MainMenu.do?refresh_action='" value="Menu"><img src="../img/menu.jpg" height="16"><font color="#000000" style="font-family:Arial,Verdana;" ><b> Menu</b></font></button>
<button style="background-color:#d0c4d8;cursor:hand;" onclick="wopen('../doc/<%= request.getServletPath() %>','_blank',900,400)" value="Ajuda"><img src="../img/ajuda.gif" height="16"><font color="#000000" style="font-family:Arial,Verdana;" ><b> Ajuda</b></font></button>
<button style="background-color:#d0c4d8;cursor:hand;" onclick="top.location.href='../system/MainMenu.do?logout_action='" value="Logout"><img src="../img/logout.jpg" height="16"><font color="#00000" style="font-family:Arial,Verdana;" ><b> Sair</b></font></button>
</td></tr>
<tr><td style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
<tr><td style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;></td></tr>
</table>
<script>

<!--
function wopen(url, name, w, h)
{
  w += 32;
  h += 96;
  wleft = (screen.width - w) / 2;
  wtop = (screen.height - h) / 2;
  var win = window.open(url,
    name,
    'width=' + w + ', height=' + h + ', ' +
    'left=' + wleft + ', top=' + wtop + ', ' +
    'location=no, menubar=no, ' +
    'status=no, toolbar=no, scrollbars=no, resizable=no');
  win.resizeTo(w, h);
  win.moveTo(wleft, wtop);
  win.focus();
}
// -->

</script> 
<% if(HeaderActionForm.getFavorito().equals("1")){ %>
<div style="display:block" id="favoritos" style=" POSITION: absolute; TOP: <%= y %>; left: <%= x %>; z-index: 0">
<table>
<tr>
<td>
<h1>xxxxxxxxxxxxxxxxxxxxxxxxxx</h1>
</td>
</tr>
</table>
</div>
 <% } %>



































            <html:form action="system/HeaderForm.do" method="POST" styleClass="baseForm">
              <table class="bannerTable" style='width:99%;'>
                <tr>
                  <td class=tableHeader>

                  </td>
                </tr>
              </table>
                           <table class="itemTable" style='width:99%;'>
                <tr>
                  <td class="formField">
                      <html:hidden property="favorito"/>
                   
                  </td>
                </tr>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit value="Blank" styleClass="myhidden" property="blank_action">
                    </html:submit>
                  </td>
                </tr>
              </table>
            </html:form>

                      </td>
        </tr>
      </table>





    </body>
  </center>

</html>

