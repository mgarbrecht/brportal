<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-33772085-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>


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
  Date data = new Date();
  SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat fHora = new SimpleDateFormat("HH:mm:ss");
  Usuario user = (Usuario) session.getAttribute("User");
  EntidadeNegocio entidadeNegocio = user.getEntidadeNegocio();
  TipoEntidadeNegocio tipoEntidade = null;
  if (entidadeNegocio != null) 
	  tipoEntidade = entidadeNegocio.getTipoEntidadeNegocio();
  if(user.getAcessos()==0){
  %><script>top.location='../acesso/TrocaSenhaForm.jsp';</script><%
  }
  if(user.getSituacao().equals("I")){
  %><script>top.location='../system/Bloqueio.jsp';</script><%
  }  
  if(session.getAttribute("senha_venceu")=="S"){
  %>
  <script>
	 alert('A sua senha venceu em: <%= session.getAttribute("data_vencimento") %>. Efetue a troca da mesma.');
     top.location='../acesso/TrocaSenhaForm.do?pop_action=&fl=2';
  </script>
  <%
  }
  
  if(session.getAttribute("data_vencimento")!=null){
  %>
  <script>if(confirm('A sua senha irá vencer em: <%= session.getAttribute("dias_vencimento") %> dia(s). (<%= session.getAttribute("data_vencimento") %>). Gostaria de alterá-la agora?')){
     top.location='../acesso/TrocaSenhaForm.do?pop_action=&fl=2';
  };</script>
  <%
  session.removeAttribute("data_vencimento");
  session.removeAttribute("dias_vencimento");
  }
%>

<table width="100%" border=0  >
	<tr> 
		<td width="10%">
		<img src="<%= request.getContextPath() %>/img/lg_SA.jpg">
		<td VALIGN=BOTTOM align=center>
	      <b><font color="#C40000" size=3><script>document.write(document.title);</script></font><b>
		</td>
		<td align="right" width="35%">

		<table border = 0>

			<tr>
				<th align="right"><font color="#8D0000" size=1><bean:message bundle="ApplicationResources" key="header.data"/></font></th>
				<td><font color="#8D0000" size=1><%= fData.format(data) %></font></td>
			</tr>
			<!--
			<tr>
				<th align="right"><font color="#8D0000" size=1><bean:message bundle="ApplicationResources" key="header.hora"/></font></th>
				<td><font color="#8D0000" size=1><%= fHora.format(data) %></font></td>
			</tr>
			-->
			<tr>
				<th align="right"><font color="#8D0000" size=1><bean:message bundle="ApplicationResources" key="header.usuario"/></font></th>
				<td><font color="#8D0000" size=1><%= user.getUsuario() %></font></td>
			</tr>
			<% if (tipoEntidade != null) { %>
			<tr>
				<th align="right"><font color="#8D0000" size=1><%= tipoEntidade.getTipo() %>:</font></th>
				<td><font color="#8D0000" size=1><%= entidadeNegocio.getChave() %></font></td>

			</tr>
			<% } %>
                 


</tr>

		</table>

		</td>

<tr>
	<td colspan=3 style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:0;font-size:11px;>
	</td>
</tr>
<tr>
	<td>
		<img src="../img/menuspace.png">
	</td>
	<td style="text-align: center; ">
	</td>
</tr>
<tr>
	<td colspan=3 style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:0;font-size:11px;></td>
</tr>
</table>

<script LANGUAGE=javascript src="../script/coolmenus4.js"></script>

<script>

      var vleft = 185
      /*** 
      This is the menu creation code - place it right after you body tag
      Feel free to add this to a stand-alone js file and link it to your page.
      **/
      
      //Menu object creation
      oCMenu=new makeCM("oCMenu") //Making the menu object. Argument: menuname
      
      oCMenu.frames = 0
      //Menu properties   
      oCMenu.pxBetween=2	
      if (screen.width==800) 
         vleft=72;
      else
         vleft=185;
      
      //oCMenu.fromLeft=185
      
      oCMenu.fromLeft=vleft 
       
      oCMenu.fromTop=67   
      
      oCMenu.fromRight=150
      oCMenu.align="bottom"
      oCMenu.rows=1 
      oCMenu.menuPlacement="right"
                                                                   
      oCMenu.offlineRoot="/" 
      oCMenu.onlineRoot="" 
      oCMenu.resizeCheck=1 
      oCMenu.wait=1000
      oCMenu.fillImg="cm_fill.gif"
      oCMenu.zIndex=0
      
      oCMenu.openOnClick=1
      // oCMenu.closeOnClick=1
      
      
      //Background bar properties
      oCMenu.useBar=0
      oCMenu.barWidth="100%"
      oCMenu.barHeight="menu" 
      oCMenu.barClass="clBar"
      oCMenu.barX=1 
      oCMenu.barY=1
      oCMenu.barBorderX=1
      oCMenu.barBorderY=1
      oCMenu.barBorderClass=""
      
      //Level properties - ALL properties have to be spesified in level 0
      oCMenu.level[0]=new cm_makeLevel() //Add this for each new level
      oCMenu.level[0].width=110
      oCMenu.level[0].height=20 
      oCMenu.level[0].regClass="clLevel0"
      oCMenu.level[0].overClass="clLevel0over"
      oCMenu.level[0].borderX=1
      oCMenu.level[0].borderY=1
      oCMenu.level[0].borderClass="clLevel0border"
      oCMenu.level[0].offsetX=40
      oCMenu.level[0].offsetY=0
      oCMenu.level[0].rows=0
      oCMenu.level[0].arrow=0
      oCMenu.level[0].arrowWidth=0
      oCMenu.level[0].arrowHeight=0
      oCMenu.level[0].align="bottom"

    //Netscape 4 and Opera form work-around !! !! !! !! !!
    if(bw.ns4 || bw.op5 || bw.op6)
    {
      oCMenu.onshow="document.layers?document.layers.formLayer.visibility='hidden':document.getElementById('formDiv').style.visibility='hidden';"
      oCMenu.onhide="document.layers?document.layers.formLayer.visibility='visible':document.getElementById('formDiv').style.visibility='visible';"
    }
oCMenu.makeMenu('m3','',' <img src="../img/logout.jpg" height="16"><bean:message bundle="ApplicationResources" key="header.sair"/>','../system/MainMenu.do?logout_action=','',100)
oCMenu.construct()
</script>

