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
  
  Date data = new Date();
  SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat fHora = new SimpleDateFormat("HH:mm:ss");
  Usuario user = (Usuario) session.getAttribute("User");
  EntidadeNegocio entidadeNegocio = user.getEntidadeNegocio();
  TipoEntidadeNegocio tipoEntidade = null;
  if (entidadeNegocio != null)
	  tipoEntidade = entidadeNegocio.getTipoEntidadeNegocio();
  
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
   
%>

<link rel="stylesheet" href="../style.css" type="text/css">
<table width="100%">
	<tr> 
		<td width="10%"><img src="<%= request.getContextPath() %>/img/lg_SA.jpg">
		<td VALIGN=BOTTOM align=center>
	      <b><font color="#C40000" size=3><script>document.write(document.title);</script></font><b>
		</td>
		<td align="right" width="35%">
		<table>
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
		
<tr>
	<td colspan=3 style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:0;font-size:11px;></td>
</tr>
<tr>
	<td>
		<img src="../img/menuspace.png">
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
      oCMenu.level[0].offsetX=0
      oCMenu.level[0].offsetY=1
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
                
  <%
     String menu="";
     String url="http://";
     String nome="teste";
     acesso.Usuario u2 = new acesso.Usuario();
     u2 = (acesso.Usuario)session.getAttribute("User");
     acesso.EntidadeNegocio ent2 = new acesso.EntidadeNegocio();
     acesso.TipoEntidadeNegocio tipoent2 = new acesso.TipoEntidadeNegocio();

  
  int counterbl_report_Jw_favoritos=0;
  {
    portalbr.dbobj.view.Jw_favoritos t_jw_favoritos = new portalbr.dbobj.view.Jw_favoritos();
    java.util.Vector res_Jw_favoritos = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      String[][] select =  null;
      Object[][] where = {{"Acdi_usua_id","=",u2.getId()+""}};
      String[] groupby =  null;
      String[] having =  null;
      String[] order = {"itme_texto"};
      res_Jw_favoritos = j.select(t_jw_favoritos,select,where,groupby,having,order);
    } catch (Exception e){
      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
    } finally {
    if(j!=null){j.close();}
  } 
  if (res_Jw_favoritos!=null && res_Jw_favoritos.size()>0) {
    %>
    oCMenu.makeMenu('m1','',' <img src="../img/list_favoritos.gif" height="16"><bean:message bundle="ApplicationResources" key="header.favoritos"/>','','',100)
    <%
    java.lang.String menu_nome =  null;
    java.lang.String acdi_usua_id =  null;
    java.lang.String itme_texto =  null;
    java.lang.String link =  null;
    int tamanho = 0;
    int i_bl_report_Jw_favoritos = 0;
    for(int tam=0; tam<res_Jw_favoritos.size(); tam++){
         t_jw_favoritos = (portalbr.dbobj.view.Jw_favoritos)res_Jw_favoritos.elementAt(tam);    
         itme_texto = t_jw_favoritos.getItme_texto()==null?"":t_jw_favoritos.getItme_texto();
         if(tamanho< itme_texto.length()){
            tamanho = itme_texto.length();
         }
    }
    tamanho -= 10;
    tamanho *=10;
    if(tamanho<280){
         tamanho=280;
    }
    for(int x=0; x<res_Jw_favoritos.size(); x++){
    t_jw_favoritos = (portalbr.dbobj.view.Jw_favoritos)res_Jw_favoritos.elementAt(x);
    menu_nome = t_jw_favoritos.getMenu_nome()==null?"":t_jw_favoritos.getMenu_nome();
    acdi_usua_id = t_jw_favoritos.getAcdi_usua_id()==null?"":t_jw_favoritos.getAcdi_usua_id();
    itme_texto = t_jw_favoritos.getItme_texto()==null?"":t_jw_favoritos.getItme_texto();
    link = t_jw_favoritos.getLink()==null?"":t_jw_favoritos.getLink();
    
    
    menu = "'x"+x+"','m1','"+itme_texto+"','"+link+"','','"+tamanho+"'";
    %>
    oCMenu.makeMenu(<%= menu %>)
    <%
    
    }
    
    }}
%>
<%
if(user.getAcessos()>0){
%>
oCMenu.makeMenu('m2','',' <img src="../img/menu.jpg" height="16"><bean:message bundle="ApplicationResources" key="header.menu"/>','../system/MainMenu.do?refresh_action=','',100)
<%
  }
%>
oCMenu.makeMenu('m4','',' <img src="../img/logout.jpg" height="16"><bean:message bundle="ApplicationResources" key="header.sair"/>','../system/MainMenu.do?logout_action=','',100)
oCMenu.construct()
</script>

